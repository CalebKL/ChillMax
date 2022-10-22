package com.example.chillmax.presentation.details.components

data class TopRatedMoviesState(
    val isLoading: Boolean = false,
    val coins:List<TopRatedMoviesDetails> = emptyList(),
    val error: String = ""
)