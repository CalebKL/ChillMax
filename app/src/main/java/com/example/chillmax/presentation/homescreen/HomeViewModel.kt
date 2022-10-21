package com.example.chillmax.presentation.homescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.use_cases.UseCases
import com.example.chillmax.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _selectedOption = mutableStateOf("Movies")
    val selectedOption: State<String> = _selectedOption

    fun setSelectedOption(selectedOption: String){
        _selectedOption.value = selectedOption
    }

    private val _selectedGenre = mutableStateOf("")
    val selectedGenre: State<String> = _selectedGenre

    fun setGenre(genres: String){
        _selectedGenre.value = genres
    }

    private val _getTVGenres = mutableStateOf<List<Genres>>(emptyList())
    val tvGenres: State<List<Genres>> = _getTVGenres

    private val _getMovieGenres = mutableStateOf<List<Genres>>(emptyList())
    val movieGenres: State<List<Genres>> = _getMovieGenres

    private val _getTVTopRated = mutableStateOf<Flow<PagingData<TVTopRated>>>(emptyFlow())
    val getTVTopRated: State<Flow<PagingData<TVTopRated>>> = _getTVTopRated

    private val _getUpcomingMovies = mutableStateOf<Flow<PagingData<UpcomingMovies>>>(emptyFlow())
    val upcomingMovies: State<Flow<PagingData<UpcomingMovies>>> = _getUpcomingMovies

    private val _getTVPopular = mutableStateOf<Flow<PagingData<TVPopular>>>(emptyFlow())
    val tvPopular: State<Flow<PagingData<TVPopular>>> = _getTVPopular

    private val _getTVAiringToday = mutableStateOf<Flow<PagingData<TVAiringToday>>>(emptyFlow())
    val tvAiringToday: State<Flow<PagingData<TVAiringToday>>> = _getTVAiringToday

    private val _topRatedMovies = mutableStateOf<Flow<PagingData<TopRatedMovies>>>(emptyFlow())
    val topRatedMovies: State<Flow<PagingData<TopRatedMovies>>> = _topRatedMovies

    private val _getPopularMovies = mutableStateOf<Flow<PagingData<PopularMovies>>>(emptyFlow())
    val popularMovies: State<Flow<PagingData<PopularMovies>>> = _getPopularMovies

    init {
        getTVTopRated(null)
        getUpComingMovies(null)
        getTVPopular(null)
        getTVAiringToday(null)
        getPopularMovies(null)
        topRatedMovies(null)
        getTVGenres()
        getMovieGenres()
    }



    fun getTVTopRated(genreId: Int?) {
        viewModelScope.launch {
            _getTVTopRated.value = if (genreId != null) {
                useCases.getTvTopRatedUseCase().map { pagingData ->
                    pagingData.filter {
                        it.genre_ids.contains(genreId)
                    }
                }.cachedIn(viewModelScope)
            } else {
                useCases.getTvTopRatedUseCase().cachedIn(viewModelScope)
            }
        }
    }

    fun getUpComingMovies(genreId: Int?) {
        viewModelScope.launch {
            _getUpcomingMovies.value = if (genreId != null) {
                useCases.getUpcomingMoviesUseCase().map { pagingData ->
                    pagingData.filter {
                        it.genre_ids.contains(genreId)
                    }
                }.cachedIn(viewModelScope)
            } else {
                useCases.getUpcomingMoviesUseCase().cachedIn(viewModelScope)
            }
        }
    }

    fun getTVPopular(genreId: Int?) {
        viewModelScope.launch {
            _getTVPopular.value = if (genreId != null) {
                useCases.getTVPopularUseCase().map { pagingData ->
                    pagingData.filter {
                        it.genre_ids.contains(genreId)
                    }
                }.cachedIn(viewModelScope)
            } else {
                useCases.getTVPopularUseCase().cachedIn(viewModelScope)
            }
        }
    }


    fun getTVAiringToday(genreId: Int?) {
        viewModelScope.launch {
            _getTVAiringToday.value = if (genreId != null) {
                useCases.getTVAiringTodayUseCase().map { pagingData ->
                    pagingData.filter {
                        it.genre_ids.contains(genreId)
                    }
                }.cachedIn(viewModelScope)
            } else {
                useCases.getTVAiringTodayUseCase().cachedIn(viewModelScope)
            }
        }
    }

    fun topRatedMovies(genreId: Int?) {
        viewModelScope.launch {
            _topRatedMovies.value = if (genreId != null) {
                useCases.getTopRatedMoviesUseCase().map { pagingData ->
                    pagingData.filter {
                        it.genre_ids.contains(genreId)
                    }
                }.cachedIn(viewModelScope)
            } else {
                useCases.getTopRatedMoviesUseCase().cachedIn(viewModelScope)
            }
        }
    }

    fun getPopularMovies(genreId: Int?) {
        viewModelScope.launch {
            _getPopularMovies.value = if (genreId != null) {
                useCases.getPopularMoviesUseCase().map { pagingData ->
                    pagingData.filter {
                        it.genre_ids.contains(genreId)
                    }
                }.cachedIn(viewModelScope)
            } else {
                useCases.getPopularMoviesUseCase().cachedIn(viewModelScope)
            }
        }
    }

    private fun getMovieGenres(){
        viewModelScope.launch {
            when(val result =useCases.getMovieGenresUseCase()){
                is Resource.Success -> {
                    _getMovieGenres.value = result.data?.genres!!

                }is Resource.Error ->{

                }else ->{}
            }
        }
    }

    private fun getTVGenres(){
        viewModelScope.launch {
            when(val result =useCases.getTVGenresUseCase()){
                is Resource.Success -> {
                    _getTVGenres.value = result.data?.genres!!

                }is Resource.Error ->{

            }else ->{}
            }
        }
    }
}
