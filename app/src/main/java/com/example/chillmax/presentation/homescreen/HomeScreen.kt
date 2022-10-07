package com.example.chillmax.presentation.homescreen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
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
    navController: NavHostController
) {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val tvTopRated = homeViewModel.getTVTopRated.value.collectAsLazyPagingItems()
    val upcomingMovies = homeViewModel.upcomingMovies.value.collectAsLazyPagingItems()
    val tvPopular = homeViewModel.tvPopular.value.collectAsLazyPagingItems()
    val tvAiringToday = homeViewModel.tvAiringToday.value.collectAsLazyPagingItems()
    val topRatedMovies = homeViewModel.topRatedMovies.value.collectAsLazyPagingItems()
    val popularMovies = homeViewModel.popularMovies.value.collectAsLazyPagingItems()
    Scaffold(
        topBar = {
            HomeTopAppBar(onSearchClick = {
                navController.navigate(Screen.SearchScreen.route)
            })
        },
        content = {
            ScreenContent(navController = navController,
                tvTopRated =tvTopRated ,
                upcomingMovies =upcomingMovies ,
                tvPopular = tvPopular,
                tvAiringToday = tvAiringToday,
                topRatedMovies = topRatedMovies ,
                popularMovies = popularMovies
            )
        }
    )
}