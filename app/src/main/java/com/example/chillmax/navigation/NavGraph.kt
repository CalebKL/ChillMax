package com.example.chillmax.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.domain.models.TopRatedMoviesDetails
import com.example.chillmax.presentation.details.DetailsScreen
import com.example.chillmax.presentation.details.DetailsViewModel
import com.example.chillmax.presentation.homescreen.HomeScreen
import com.example.chillmax.presentation.search.SearchScreen
import com.example.chillmax.presentation.splash.SplashScreen
import com.example.chillmax.presentation.welcome.WelcomeScreen
import com.example.chillmax.util.Constants.DETAILS_ID
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ){
        composable(route = Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(route = Screen.WelcomeScreen.route){
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.DetailsScreen.route,
            arguments = listOf(navArgument(DETAILS_ID){
                type= NavType.IntType
            })
        ){
            DetailsScreen(navController = navController)
        }
        composable(route = Screen.SearchScreen.route){
            SearchScreen(navController = navController)
        }

    }
}