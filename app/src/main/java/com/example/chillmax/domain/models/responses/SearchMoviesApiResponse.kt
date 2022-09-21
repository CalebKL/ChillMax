package com.example.chillmax.domain.models.responses

import com.example.chillmax.domain.models.SearchMovies
import com.example.chillmax.domain.models.TopRatedMovies

data class SearchMoviesApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? =null,
    val movies: List<SearchMovies> = emptyList()
)
