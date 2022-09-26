package com.example.chillmax.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chillmax.presentation.splash.SplashScreen

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

        }
        composable(route = Screen.HomeScreen.route){

        }
        composable(route = Screen.DetailsScreen.route){

        }
        composable(route = Screen.SearchScreen.route){

        }

    }
}