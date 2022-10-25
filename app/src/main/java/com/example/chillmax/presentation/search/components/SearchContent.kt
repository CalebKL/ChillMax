package com.example.chillmax.presentation.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.chillmax.presentation.destinations.MovieDetailsScreenDestination
import com.example.chillmax.presentation.destinations.TVDetailsScreenDestination
import com.example.chillmax.presentation.search.SearchViewModel
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchContent(
    navigator: DestinationsNavigator,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val multiSearch = viewModel.multiSearch.value.collectAsLazyPagingItems()
    val searchQuery by viewModel.searchQuery

    LazyColumn(
        verticalArrangement = Arrangement.Top,
        contentPadding = PaddingValues(SMALL_PADDING)
    ){
        items(multiSearch){ search ->
            SearchItem(
                searchItem = search,
                modifier =Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .clickable {
                        when(search?.mediaType){
                            "Tv Shows" ->{
                                navigator.navigate(TVDetailsScreenDestination(search.id!!))
                            }
                            "Movies" ->{
                                navigator.navigate(MovieDetailsScreenDestination(search.id!!))
                            }
                            else -> searchQuery
                        }
                    }
            )
        }
        if (multiSearch.loadState.append == LoadState.Loading){
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
    multiSearch.apply {
        loadState
        when(loadState.refresh){
            is LoadState.Loading ->{
                CircularProgressIndicator(
                    modifier = Modifier,
                    color = Color.Red,
                    strokeWidth = 2.dp
                )
            }
            is LoadState.Error ->{
                val error = multiSearch.loadState.refresh as LoadState.Error
                Text(
                    text = when(error.error){
                        is HttpException ->{
                            "Oops! Something Went Wrong"
                        }
                        is IOException ->{
                            "Couldn't Reach Server! Check Your Internet Connection"
                        }
                        else->{
                            "Unknown Error"
                        }
                    },
                    textAlign = TextAlign.Center,
                    color = Color.Red
                )
            }else->{}
        }
    }

}