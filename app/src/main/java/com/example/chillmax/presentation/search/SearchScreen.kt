package com.example.chillmax.presentation.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.chillmax.presentation.search.components.SearchBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SearchScreen(
    navigator: DestinationsNavigator,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by viewModel.searchQuery
    val multiSearch = viewModel.multiSearch.value.collectAsLazyPagingItems()
    Scaffold(
        topBar = {
            SearchBar(
                search = searchQuery,
                onSearchClicked ={
                    viewModel.multiSearch(it)
                } ,
                onCloseClick = {
                    navigator.popBackStack()
                },
                onTextChanged ={
                    viewModel.updateSearchQuery(it)
                }
            )
        },
        content = {

        }
    )
}