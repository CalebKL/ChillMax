package com.example.chillmax.presentation.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.presentation.destinations.MovieDetailsScreenDestination
import com.example.chillmax.presentation.destinations.TVDetailsScreenDestination
import com.example.chillmax.presentation.homescreen.components.ScreenContent
import com.example.chillmax.presentation.search.components.SearchBar
import com.example.chillmax.presentation.search.components.SearchContent
import com.example.chillmax.presentation.search.components.SearchItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SearchScreen(
    navigator: DestinationsNavigator,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val multiSearch = viewModel.searchResult.value.collectAsLazyPagingItems()
    val searchTerm = viewModel.searchQuery.value
    Log.d("SearchScreen", multiSearch.loadState.toString())
    Scaffold(
        topBar = {
            SearchBar(
                search = searchTerm,
                onSearchClicked ={
                    viewModel.searchAll(query = it)
                } ,
                onCloseClick = {
                    navigator.popBackStack()
                },
                onTextChanged ={
                    viewModel.updateSearchQuery(query = it)
                }
            )
        },
        content = {
            SearchContent(navigator = navigator)
            }
    )
}