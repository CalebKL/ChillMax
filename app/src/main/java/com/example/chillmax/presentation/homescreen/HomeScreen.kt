package com.example.chillmax.presentation.homescreen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.chillmax.domain.models.TVAiringToday
import com.example.chillmax.domain.models.TVTopRated
import com.example.chillmax.navigation.Screen
import com.example.chillmax.presentation.homescreen.components.HomeTopAppBar
import com.example.chillmax.presentation.homescreen.components.ScreenContent

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val getTVTopRated = homeViewModel.getTVTopRated.value.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopAppBar(onSearchClick = {
                navController.navigate(Screen.SearchScreen.route)
            })
        },
        content = {

        }
    )
}