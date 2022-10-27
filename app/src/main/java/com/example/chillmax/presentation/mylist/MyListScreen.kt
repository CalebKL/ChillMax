package com.example.chillmax.presentation.mylist

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.chillmax.R
import com.example.chillmax.domain.models.MyList
import com.example.chillmax.presentation.ui.theme.EXTRA_SMALL_PADDING
import com.example.chillmax.presentation.ui.theme.ICON_SIZE
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING
import com.example.chillmax.util.Action
import com.example.chillmax.util.Constants
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Destination
@Composable
fun MyListScreen() {

}


@Composable
fun HandleListContent(
    navigator: DestinationsNavigator,
    onSwipeToDelete: (Action, MyList)->Unit,
    hero:List<MyList>,
) {
    if (hero.isEmpty()){

    }else{
        DisplayMyList(
            myList = hero,
            navigator =navigator,
            onSwipeToDelete = onSwipeToDelete
        )
    }
}


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DisplayMyList(
    myList: List<MyList>,
    navigator: DestinationsNavigator,
    onSwipeToDelete: (Action, MyList)->Unit,
) {
    LazyColumn(){
        items(
            items = myList,
            key = { list->
                list.id
            }
        ){fav->
            val dismissState = rememberDismissState()
            val dismissDirection = dismissState.dismissDirection
            val isDismissed = dismissState.isDismissed(DismissDirection.EndToStart)

            if(isDismissed && dismissDirection == DismissDirection.EndToStart){
                val scope = rememberCoroutineScope()
                scope.launch {
                    delay(300)
                    onSwipeToDelete(Action.DELETE,fav)
                }
            }

            val degrees by animateFloatAsState(
                targetValue =
                if (dismissState.targetValue == DismissValue.Default)
                    0f
                else
                    -45f
            )
            var itemAppeared by remember { mutableStateOf(false) }

            LaunchedEffect(key1 = true ){
                itemAppeared = true
            }
            AnimatedVisibility(
                visible = itemAppeared && !isDismissed,
                enter = expandVertically(
                    animationSpec = tween(
                        durationMillis = 300
                    )
                ),
                exit = shrinkVertically(
                    animationSpec = tween(
                        durationMillis = 300
                    )
                )
            ){
                SwipeToDismiss(
                    state =dismissState,
                    directions = setOf(DismissDirection.EndToStart),
                    dismissThresholds = { FractionalThreshold(fraction = 0.2f) },
                    background = {RedBackground(degrees = degrees)},
                    dismissContent = {
                        MyListItem(onClick = {

                        }, hero = fav)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MyListItem(
    modifier: Modifier = Modifier,
    onClick:()->Unit,
    hero:MyList?
) {
    Card(
        modifier = modifier
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(SMALL_PADDING),
        elevation = EXTRA_SMALL_PADDING
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                modifier= Modifier.weight(3f),
                painter = rememberImagePainter(
                    data = "${Constants.IMAGE_BASE_URL}/${hero?.imagePath}",
                    builder = {
                        placeholder(R.drawable.ic_placeholder)
                        crossfade(true)
                    }
                ),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.image_banner)
            )
            Column(
                modifier = modifier
                    .weight(7f)
                    .padding(SMALL_PADDING)
            ){
                Text(
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    text =(hero?.title?:"No Title Provided")
                )
                Spacer(modifier = Modifier.height(SMALL_PADDING))
                Text(
                    style = MaterialTheme.typography.subtitle2,
                    text = hero?.description?:"No description",
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
@Composable
fun RedBackground(degrees:Float) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(SMALL_PADDING),
        contentAlignment = Alignment.CenterEnd
    )
    {
        Icon(
            modifier = Modifier.rotate(degrees = degrees),
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(R.string.delete_icon),
            tint = Color.White
        )
    }
}

@Composable
fun EmptyListContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            modifier = Modifier
                .size(ICON_SIZE)
                .alpha(ContentAlpha.disabled),
            painter = painterResource(id = R.drawable.ic_sad),
            contentDescription = stringResource(
                R.string.empty_content)
        )
        Spacer(modifier = Modifier.height(SMALL_PADDING))
        Text(
            modifier =Modifier.alpha(ContentAlpha.disabled),
            text = stringResource(R.string.nothing_to_display),
            color = Color.White,
            style = MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun EmptyContentPrev() {
    EmptyListContent()
}





















