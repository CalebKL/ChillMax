package com.example.chillmax.navigation

sealed class Screen(val route: String){
    object SplashScreen: Screen("splash_screen")
    object WelcomeScreen: Screen("welcome_screen")
    object HomeScreen: Screen("home_screen")
    object DetailsScreen: Screen("details_screen/{detailsId}"){
        fun passDetailsId(detailsId: Int): String{
            return "details_screen/$detailsId"
        }
    }
    object SearchScreen: Screen("search_screen")
}
