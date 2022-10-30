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

    private val _addToMyList = mutableStateOf(0)
    val addToMyList: State<Int> = _addToMyList

    init {
        getWatchList()
    }

    fun addToMyList(myList: MyList) {
        viewModelScope.launch {
            useCases.addToMyListUseCase(myList)
        }.invokeOnCompletion {
            ifExists(myList.listId)
        }
    }

    fun deleteOneFromMyList(listId: Int) {
        viewModelScope.launch {
            useCases.deleteOneFromMyListUseCase(myList = listId)
        }.invokeOnCompletion {
            ifExists(listId)
        }
    }

    private fun getWatchList() {
        _list.value = useCases.getMyListUseCase()
    }

    fun deleteAllContent() {
        viewModelScope.launch {
            useCases.deleteAllContentFromMyListUseCase()
        }
    }

    fun ifExists(listId: Int){
        viewModelScope.launch {
            _addToMyList.value = useCases.ifExistsUseCase(listId)
        }
    }
}