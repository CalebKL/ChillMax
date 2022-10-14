package com.example.chillmax.presentation.homescreen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
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
    Scaffold(
        topBar = {
             HomeTopAppBar (onSearchClick = {
                 navigator.navigate(SearchScreenDestination)
             })
        },
        content = {
            ScreenContent(navigator = navigator)
        }
    )
}