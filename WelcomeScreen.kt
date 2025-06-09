package com.example.lumeappfinal.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumeappfinal.R
import com.example.lumeappfinal.ui.theme.*

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundCreme)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text =  "LUME",
            fontSize = 46.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Quicksand,
            color = DeepPurple
        )

        Text(
            text = "Reset your mind. Reclaim your peace.",
            fontSize = 16.sp,
            fontFamily = Quicksand,
            color = TextDark,
            modifier = Modifier.padding(top = 10.dp, bottom = 26.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.meditation_girl),
            contentDescription = "Meditating Girl",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .aspectRatio(0.7f) // Slightly taller
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))

        // --- Animated Login Button ---
        var loginPressed by remember { mutableStateOf(false) }
        val loginScale by animateFloatAsState(
            targetValue = if (loginPressed) 0.95f else 1f,
            animationSpec = spring(dampingRatio = 0.4f),
            label = "LoginScale"
        )

        Button(
            onClick = {
                loginPressed = true
                onLoginClick()
                loginPressed = false
            },
            colors = ButtonDefaults.buttonColors(containerColor = MintGreen),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .scale(loginScale)
        ) {
            Text("Login", fontFamily = Quicksand, color = TextDark)
        }

        // --- Animated SignUp Button ---
        var signUpPressed by remember { mutableStateOf(false) }
        val signUpScale by animateFloatAsState(
            targetValue = if (signUpPressed) 0.95f else 1f,
            animationSpec = spring(dampingRatio = 0.4f),
            label = "SignUpScale"
        )

        OutlinedButton(
            onClick = {
                signUpPressed = true
                onSignUpClick()
                signUpPressed = false
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .scale(signUpScale)
        ) {
            Text("Sign Up", fontFamily = Quicksand, color = DeepPurple)
        }
    }
}

//TO SHOW THE PREVIEW
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    LumeAppFinalTheme {
        WelcomeScreen(
            onLoginClick = {},
            onSignUpClick = {}
        )
    }
}
