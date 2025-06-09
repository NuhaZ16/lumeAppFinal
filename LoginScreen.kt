package com.example.lumeappfinal.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumeappfinal.R
import com.example.lumeappfinal.ui.theme.*

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onGoToSignUp: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE2F0F1))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            // 🌸 Top image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.30f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.meditation_girl),
                    contentDescription = "Meditation Girl",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 8.dp)
                )
            }

            // 💫 Login section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.70f)
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(Color(0xFFFAF1FA))
                    .padding(horizontal = 24.dp, vertical = 24.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    var email by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }

                    Text(
                        text = "Start to change your mind",
                        fontSize = 22.sp,
                        color = DeepPurple
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Username") },
                        shape = RoundedCornerShape(16.dp),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(16.dp),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    TextButton(onClick = { onGoToSignUp() }) {
                        Text("Don’t have an account? Sign Up", fontSize = 14.sp, color = DeepPurple)
                    }

                    Button(
                        onClick = { onLoginSuccess() },
                        colors = ButtonDefaults.buttonColors(containerColor = MintGreen),
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text("Login", fontSize = 16.sp, color = TextDark)
                    }
                }
            }
        }
    }
}
