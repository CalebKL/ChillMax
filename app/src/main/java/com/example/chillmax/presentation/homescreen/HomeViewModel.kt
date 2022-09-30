package com.example.chillmax.presentation.homescreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.example.chillmax.domain.models.TVTopRated
import com.example.chillmax.domain.use_cases.UseCases
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

    private val _getTVTopRated = mutableStateOf<Flow<PagingData<TVTopRated>>>(emptyFlow())
    val getTVTopRated: State<Flow<PagingData<TVTopRated>>> = _getTVTopRated

    init {
        getTVTopRated(null)
    }
    fun getTVTopRated(genreId: Int?) {
        viewModelScope.launch {
            _getTVTopRated.value = if (genreId != null){
                useCases.getTvTopRatedUseCase().map { pagingData->
                    pagingData.filter {
                        it.genre_ids.contains(genreId)
                    }
                }.cachedIn(viewModelScope)
            }else{
                useCases.getTvTopRatedUseCase().cachedIn(viewModelScope)
            }
        }
    }
}