package com.example.lumeappfinal.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "welcome") {

        // Welcome screen → Login or SignUp
        composable("welcome") {
            WelcomeScreen(
                onLoginClick = { navController.navigate("login") },
                onSignUpClick = { navController.navigate("signup") }
            )
        }

        // Login screen → Mood Tracker
        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("mood") },
                onGoToSignUp = { navController.navigate("signup") }
            )
        }

        // Sign up screen → Mood Tracker
        composable("signup") {
            SignUpScreen(
                onSignUpComplete = { navController.navigate("mood") }
            )
        }

        // Mood Tracker Screen (with meditation and journaling)
        composable("mood") {
            ExploreMeditationMoodScreen()
        }
    }
}
