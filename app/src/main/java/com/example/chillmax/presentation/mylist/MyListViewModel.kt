package com.example.chillmax.presentation.mylist

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chillmax.domain.models.MyList
import com.example.chillmax.domain.use_cases.UseCases
import com.example.chillmax.util.Action
import com.example.chillmax.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyListViewModel @Inject constructor(
    private val useCases: UseCases
):ViewModel(){

    val action: MutableState<Action> = mutableStateOf(Action.NO_ACTION)
    val listTitle: MutableState<String> = mutableStateOf("")
    val id: MutableState<Int> = mutableStateOf(0)
    val isLiked: MutableState<Boolean> = mutableStateOf(false)
    val imagePath: MutableState<String> = mutableStateOf("")
    val description: MutableState<String> = mutableStateOf("")
    val mediaType: MutableState<String> = mutableStateOf("")

    private val _getMyList = MutableStateFlow<Resource<List<MyList>>>(Resource.Loading())
    val getMyList: StateFlow<Resource<List<MyList>>> = _getMyList

    private fun addToMyList(){
      viewModelScope.launch{
          val myList= MyList(
              isLiked = isLiked.value,
              id = id.value,
              imagePath = imagePath.value,
              title = listTitle.value,
              description = description.value,
              mediaType = mediaType.value
          )
          useCases.addToMyListUseCase(myList)
      }
   }

    private fun deleteOneFromList(){
        viewModelScope.launch {
            val myList = MyList(
                isLiked = isLiked.value,
                id = id.value,
                imagePath = imagePath.value,
                title = listTitle.value,
                description = description.value,
                mediaType = mediaType.value
            )
            useCases.deleteOneFromMyListUseCase(myList)
        }
    }

    private fun deleteAllContent(){
        viewModelScope.launch {
            useCases.deleteAllContentFromMyListUseCase()
        }
    }

    private fun isHeroLiked(){
       viewModelScope.launch {
           val myList = MyList(
               isLiked = isLiked.value,
               id = id.value,
               imagePath = imagePath.value,
               title = listTitle.value,
               description = description.value,
               mediaType = mediaType.value
           )
           viewModelScope.launch {
               useCases.isHeroLikedUseCase(myList = myList)
           }
       }
    }

    fun handleDatabaseActions(action: Action){
        when(action){
            Action.ADD ->{
                addToMyList()
            }
            Action.UNDO ->{
                addToMyList()
            }
            Action.DELETE ->{
                deleteOneFromList()
            }
            Action.IS_LIKED ->{
                isHeroLiked()
            }
            Action.DELETE_ALL ->{
                deleteAllContent()

            }else ->{

        }
        }
        this.action.value = Action.NO_ACTION
    }

    fun updateListField(myList: MyList?){
        Log.d("Updated List Fields", myList.toString())
        if(myList != null){
            isLiked.value = isLiked.value
            id.value = id.value
            imagePath.value = imagePath.value
            listTitle.value = listTitle.value
            description.value = description.value
            mediaType.value = mediaType.value

        }else{
            isLiked.value = false
            id.value = 0
            imagePath.value = ""
            listTitle.value = ""
            description.value = ""
            mediaType.value = ""
        }
    }

}
