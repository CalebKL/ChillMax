package com.example.chillmax.presentation.mylist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.R
import com.example.chillmax.presentation.destinations.HomeScreenDestination
import com.example.chillmax.presentation.ui.theme.LARGE_PADDING
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun MyListTopAppBar(
    onSearchClick:()->Unit,
    navigator: DestinationsNavigator
) {
    Row(modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        IconButton(
            modifier = Modifier
                .size(LARGE_PADDING)
                .weight(2f),
            onClick = {
                navigator.navigate(HomeScreenDestination)
            }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.arrow_back)
            )
        }
        Text(
            modifier = Modifier.weight(8f),
            text = stringResource(R.string.my_list),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
        IconButton(
            modifier= Modifier.weight(2f),
            onClick = onSearchClick
        ) {
            Icon(
                modifier = Modifier.size(LARGE_PADDING),
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(R.string.search_icon),
            )
        }
    }
}

