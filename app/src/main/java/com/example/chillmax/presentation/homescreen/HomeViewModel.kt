package com.example.chillmax.presentation.homescreen

import androidx.lifecycle.ViewModel
import com.example.chillmax.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    val getTVTopRatedUseCase = useCases.tvTopRatedUseCase
    val getUpcomingMoviesUseCase = useCases.getUpcomingMoviesUseCase
    val getTVPopularUseCase = useCases.getPopularMoviesUseCase
    val getTVGenresUseCase = useCases.getTVGenresUseCase
    val getTVAiringTodayUseCase = useCases.getTVAiringTodayUseCase
    val getTopRatedMoviesUseCase = useCases.getTopRatedMoviesUseCase
    val getPopularMoviesUseCase = useCases.getPopularMoviesUseCase
    val getMovieGenresUseCase = useCases.getMovieGenresUseCase
}