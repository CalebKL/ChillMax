package com.example.chillmax.data.resource

import androidx.paging.PagingConfig
import androidx.paging.PagingState
import com.example.chillmax.domain.models.MyList
import com.example.chillmax.domain.models.PopularMovies
import com.example.chillmax.domain.models.responses.PopularMoviesApiResponses


val fakeList = MyList(
    listId = 1,
    imagePath = "Just a random text",
    title = "Mzazi wewe",
    description = "Just sum random text",
    mediaType = "Another random text"
)
val popularPagingState = PagingState<Int, PopularMovies>(
    listOf(),
    null,
    PagingConfig(10),
    10
)

val popularMoviesResult = PopularMovies(
    adult = true,
    backdrop_path = "sum random text",
    genre_ids = listOf(1,2,3),
    id = 1,
    original_title = "Vikings",
    original_language = "English",
    overview = "sum random text",
    popularity = 12.23,
    poster_path = "sum random text",
    release_date = "12/12/13",
    title = "Ragnar",
    video = false,
    vote_count = 12,
    vote_average = 13.54
)

val validEmptyMovieResult = PopularMoviesApiResponses(
    page = 2,
    searches = emptyList(),
    totalPages = 100,
    totalResults = 290
)

val validMovieResult = PopularMoviesApiResponses(
    page = 2,
    searches = listOf(popularMoviesResult),
    totalPages = 100,
    totalResults = 290
)