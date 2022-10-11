package com.example.chillmax.presentation.homescreen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.domain.models.Genres
import com.example.chillmax.domain.models.TVAiringToday
import com.example.chillmax.domain.models.TVTopRated
import com.example.chillmax.navigation.Screen
import com.example.chillmax.presentation.homescreen.components.HomeTopAppBar
import com.example.chillmax.presentation.homescreen.components.ScreenContent

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            HomeTopAppBar(onSearchClick = {
                navController.navigate(Screen.SearchScreen.route)
            })
        },
        content = {
            ScreenContent(
                navController = navController,
                viewModel = viewModel
            )
        }
    )
}