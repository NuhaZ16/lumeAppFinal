// ExploreMeditationMoodScreen.kt
package com.example.lumeappfinal.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumeappfinal.R
import com.example.lumeappfinal.ui.theme.*

@Composable
fun ExploreMeditationMoodScreen() {
    var selectedMood by remember { mutableStateOf<String?>(null) }
    var journalEntry by remember { mutableStateOf(TextFieldValue("")) }

    val moods = listOf(
        "☀️" to "Bright",
        "😊" to "Happy",
        "😐" to "Meh",
        "😢" to "Sad",
        "😡" to "Angry"
    )

    val resetGoals = mapOf(
        "Bright" to "Keep that energy! 🌼",
        "Happy" to "Share your joy with someone 💌",
        "Meh" to "Try a 5-minute walk 🚶",
        "Sad" to "Write out your thoughts 📝",
        "Angry" to "Do a deep breathing session 🌬️"
    )

    val goalMessage = selectedMood?.let { resetGoals[it] ?: "" }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(SoftPink.copy(alpha = 0.4f), Color.White)
                )
            )
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "🪷 How are you feeling today?",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = DeepPurple,
            modifier = Modifier.padding(bottom = 20.dp),
            lineHeight = 30.sp,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            moods.forEach { (emoji, moodName) ->
                val isSelected = selectedMood == moodName
                val animatedColor by animateColorAsState(
                    targetValue = if (isSelected) MintGreen else Color.White
                )
                val scale by animateFloatAsState(if (isSelected) 1.2f else 1f)

                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .scale(scale)
                        .background(animatedColor, CircleShape)
                        .clickable { selectedMood = moodName },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = emoji, fontSize = 30.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (!selectedMood.isNullOrEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White.copy(alpha = 0.95f))
                    .padding(20.dp)
            ) {
                Text(
                    text = "You’re feeling $selectedMood.",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextDark
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = goalMessage ?: "",
                    fontSize = 16.sp,
                    color = DeepPurple,
                    lineHeight = 22.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "📝 Want to write about it?",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = TextDark,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = journalEntry,
            onValueChange = { journalEntry = it },
            placeholder = { Text("Write your thoughts here...") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            shape = RoundedCornerShape(20.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = LightPurple,
                focusedBorderColor = DeepPurple,
                cursorColor = DeepPurple
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Save logic */ },
            colors = ButtonDefaults.buttonColors(containerColor = MintGreen),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(
                text = "Save Entry",
                color = TextDark,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "✨ Explore Meditation",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = DeepPurple,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MeditationCard("Focus", R.drawable.meditation_focus)
                MeditationCard("Calm", R.drawable.meditation_calm)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MeditationCard("Relax", R.drawable.meditation_relax)
                MeditationCard("Sleep", R.drawable.meditation_sleep)
            }
        }
    }
}

@Composable
fun MeditationCard(title: String, imageRes: Int) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .width(160.dp)
            .height(140.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(Color.White, SoftPink.copy(alpha = 0.1f)))),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(title, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = DeepText)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExploreMeditationMoodScreenPreview() {
    LumeAppFinalTheme {
        ExploreMeditationMoodScreen()
    }
}
