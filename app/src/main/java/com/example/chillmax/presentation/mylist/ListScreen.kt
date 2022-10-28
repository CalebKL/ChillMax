package com.example.chillmax.presentation.mylist

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.R
import com.example.chillmax.presentation.destinations.HomeScreenDestination
import com.example.chillmax.presentation.destinations.SearchScreenDestination
import com.example.chillmax.util.Action
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun ListScreen(
    navigator: DestinationsNavigator,
    viewModel: MyListViewModel = hiltViewModel(),
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
                 MyListTopAppBar(onSearchClick = {
                     navigator.navigate(SearchScreenDestination)
                 }, navigator =navigator
                 )
        },
        content = {
                 DisplayMyList(
                     navigator = navigator,
                     viewModel =viewModel
                 )
        },
        floatingActionButton = {
            ListFab(navigator = navigator)
        }
    )
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun ListFab(
    navigator: DestinationsNavigator
) {
    FloatingActionButton(
        onClick = {
            navigator.navigate(HomeScreenDestination)
        }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(R.string.add_to_my_list))
    }
}























