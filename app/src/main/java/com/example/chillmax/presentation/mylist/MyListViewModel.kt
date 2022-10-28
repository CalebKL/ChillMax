package com.example.chillmax.presentation.mylist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chillmax.domain.models.MyList
import com.example.chillmax.domain.use_cases.UseCases
import com.example.chillmax.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyListViewModel @Inject constructor(
    private val useCases: UseCases
):ViewModel() {

    private val _list = mutableStateOf<Flow<List<MyList>>>(emptyFlow())
    val list: MutableState<Flow<List<MyList>>> = _list

    fun addToMyList(myList:MyList) {
        viewModelScope.launch {
            useCases.addToMyListUseCase(myList)
        }
    }

    suspend fun deleteOneFromMyList(myList: MyList) {
        return useCases.deleteOneFromMyListUseCase(myList = myList)

    }

    suspend fun deleteAllContent() {
       return useCases.deleteAllContentFromMyListUseCase()

    }

    fun isHeroLiked(myList: Int): Flow<Boolean> {
       return useCases.isHeroLikedUseCase(myList)
    }

}