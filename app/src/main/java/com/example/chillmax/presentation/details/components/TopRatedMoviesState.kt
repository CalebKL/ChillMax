package com.example.chillmax.presentation.details.components

import com.example.chillmax.domain.models.TopRatedMoviesDetails

data class TopRatedMoviesState(
    val isLoading: Boolean = false,
    val coins:List<TopRatedMoviesDetails> = emptyList(),
    val error: String = ""
)