package com.example.chillmax.presentation.homescreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chillmax.presentation.homescreen.HomeViewModel
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING

@Composable
fun Genres(
    viewModel: HomeViewModel
) {
    val genres = if(viewModel.selectedOption.value == "Tv Shows"){
        viewModel.tvGenres.value
    }else{
        viewModel.movieGenres.value
    }

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ){
        items( items = genres){genre ->
            Text(
                modifier = Modifier.clip(
                    shape = RoundedCornerShape(
                        size = 8.dp
                    )
                )
                    .clickable {
                               if (viewModel.selectedOption.value == "Tv Shows"){
                                   viewModel.setGenre(genre.name)
                                   viewModel.getTVTopRated(genre.id)
                                   viewModel.getTVAiringToday(genre.id)
                                   viewModel.getTVPopular(genre.id)
                               }else if (viewModel.selectedOption.value == "Movies"){
                                   viewModel.setGenre(genre.name)
                                   viewModel.getPopularMovies(genre.id)
                                   viewModel.getUpComingMovies(genre.id)
                                   viewModel.topRatedMovies(genre.id)
                               }
                    }
                    .padding(SMALL_PADDING),
                text = genre.name,
                color = Color.White,
                style = MaterialTheme.typography.body1.merge()
            )
        }
    }
}