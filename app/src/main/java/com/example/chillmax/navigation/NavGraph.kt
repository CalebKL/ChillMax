package com.example.chillmax.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chillmax.presentation.homescreen.HomeScreen
import com.example.chillmax.presentation.splash.SplashScreen
import com.example.chillmax.presentation.welcome.WelcomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ){
        composable(route = Screen.SplashScreen.route){
            SplashScreen()
        }
        composable(route = Screen.WelcomeScreen.route){
            WelcomeScreen()
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen()
        }
        composable(route = Screen.DetailsScreen.route){

        }
        composable(route = Screen.SearchScreen.route){

        }

    }
}