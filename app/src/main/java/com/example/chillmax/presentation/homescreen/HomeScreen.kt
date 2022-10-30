package com.example.chillmax.presentation.homescreen

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.presentation.destinations.SearchScreenDestination
import com.example.chillmax.presentation.homescreen.components.HomeTopAppBar
import com.example.chillmax.presentation.homescreen.components.ScreenContent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
) {
    val homeViewModel= hiltViewModel<HomeViewModel>()
    Scaffold(
        topBar = {
             HomeTopAppBar (onSearchClick = {
                 navigator.navigate(SearchScreenDestination)
             })
        },
        content = {
            ScreenContent(navigator = navigator )
        }
    )
}