package com.example.chillmax.presentation.mylist

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chillmax.R
import com.example.chillmax.presentation.destinations.SearchScreenDestination
import com.example.chillmax.util.Action
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun ListScreen(
    navigator: DestinationsNavigator,
    viewModel: MyListViewModel = hiltViewModel(),
) {
    val action by viewModel.action
    val scaffoldState = rememberScaffoldState()
    val myList by viewModel.getMyList.collectAsState()
    DisplaySnackBar(
        scaffoldState = scaffoldState,
        action =action ,
        onUndoClick = {
            viewModel.action.value = it
        },
        handleDatabaseAction = {
                               viewModel.handleDatabaseActions(action)
        },
        listTitle = viewModel.listTitle.value
    )
    Scaffold(
        scaffoldState = scaffoldState,
        content = {
                  MyListContent(
                      navigator = navigator,
                      onSwipeToDelete ={action, list ->
                          viewModel.action.value = action
                          viewModel.updateListField(list)
                      },
                      hero = myList
                  )
        },
        floatingActionButton = {
            ListFab(navigator = navigator)
        }
    )
}

@Composable
fun ListFab(
    navigator: DestinationsNavigator
) {
    FloatingActionButton(
        onClick = {
            navigator.navigate(SearchScreenDestination)
        }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(R.string.add_to_my_list))
    }
}

@Composable
fun DisplaySnackBar(
    scaffoldState: ScaffoldState,
    action: Action,
    onUndoClick:(Action)->Unit,
    handleDatabaseAction:()->Unit,
    listTitle:String
) {
    handleDatabaseAction()
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 =action){
        if (action != Action.NO_ACTION){
            scope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = snackBarMessage(action, listTitle),
                    actionLabel = setActionLabel(action)
                )
                undoDeletedTask(
                    action = Action.DELETE,
                    snackBarResult = snackBarResult,
                    onUndoClicked = onUndoClick
                )
            }
        }
    }
}


private fun snackBarMessage(action: Action, listTitle:String): String{
    return when(action){
        Action.DELETE_ALL -> "All Tasks Removed"
        else -> "${action.name}: $listTitle"
    }

}

private fun setActionLabel(action: Action): String{
    return if(action.name == "DELETE"){
        "UNDO"
    }else{
        "OK"
    }
}

private fun undoDeletedTask(
    action: Action,
    snackBarResult: SnackbarResult,
    onUndoClicked: (Action) -> Unit
){
    if (snackBarResult == SnackbarResult.ActionPerformed && action == Action.DELETE){
        onUndoClicked(Action.UNDO)
    }
}




























