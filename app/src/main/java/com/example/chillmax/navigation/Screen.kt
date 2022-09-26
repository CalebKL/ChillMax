package com.example.chillmax.navigation

sealed class Screen(val route: String){
    object Splash: Screen("splash_screen")
    object Welcome: Screen("welcome_screen")
    object Home: Screen("home_screen")
    object Details: Screen("details_screen/{id}"){
        fun passId(id: Int): String{
            return "details_screen/$id"
        }
    }
    object Search: Screen("search_screen")
}
