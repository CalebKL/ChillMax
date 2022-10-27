package com.example.chillmax.presentation.mylist

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.chillmax.R
import com.example.chillmax.presentation.destinations.SearchScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@Composable
fun ListScreen() {

}

@Composable
fun ListFab(
    navigator: DestinationsNavigator
) {
    FloatingActionButton(
        onClick = {
            navigator.navigate(SearchScreenDestination)
        }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(R.string.add_to_my_list))
    }
}