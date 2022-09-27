package com.example.chillmax.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.chillmax.navigation.SetupNavigation
import com.example.chillmax.presentation.ui.theme.ChillMaxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChillMaxTheme {
                 navController = rememberNavController()
                SetupNavigation(navController =navController )
            }
        }
    }
}
