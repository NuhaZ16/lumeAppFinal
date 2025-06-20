package com.example.lumeappfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.lumeappfinal.ui.NavigationGraph
import com.example.lumeappfinal.ui.theme.LumeAppFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LumeAppFinalTheme {
                val navController = rememberNavController()
                NavigationGraph(navController)
            }
        }
    }
}
