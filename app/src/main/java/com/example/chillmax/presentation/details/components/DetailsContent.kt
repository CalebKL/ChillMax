package com.example.chillmax.presentation.details.components

import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.chillmax.R
import com.example.chillmax.domain.models.MyList
import com.example.chillmax.domain.models.responses.CastDetailsApiResponse
import com.example.chillmax.presentation.destinations.ListScreenDestination
import com.example.chillmax.presentation.mylist.MyListViewModel
import com.example.chillmax.presentation.ui.theme.*
import com.example.chillmax.util.Action
import com.example.chillmax.util.Resource
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun DetailsContent(
    navigator: DestinationsNavigator,
    filmName: String,
    myList:Int,
    mediaType:String,
    posterUrl: String,
    releaseDate: String,
    overview: String,
    casts: Resource<CastDetailsApiResponse>,
    state: LazyListState,
    viewModel: MyListViewModel = hiltViewModel(),
) {
    val addToMyList = viewModel.addToMyList.value
    val context = LocalContext.current
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )

    val currentSheetFraction = scaffoldState.currentSheetFraction

    val radiusAnim by animateDpAsState(
        targetValue =
        if (currentSheetFraction ==1f)
            EXTRA_LARGE_PADDING
        else RADIUS_DP)

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetShape = RoundedCornerShape(
            topStart = radiusAnim,
            topEnd = radiusAnim
        ),
        sheetPeekHeight = 140.dp,
        sheetContent = {
                    MovieBottomSheetContent(
                        releaseDate = releaseDate,
                        overview =overview,
                        filmName = filmName,
                        casts = casts,
                        state = state
                    )
        },
        content = {
            MovieBackgroundColorSpan(
                posterUrl = posterUrl,
                imageFraction = currentSheetFraction,
                onCloseClick = {
                    navigator.popBackStack()
                },
                imagePath = posterUrl,
                myList = myList,
                overview = overview,
                mediaType = mediaType,
                filmName = filmName,
                onClick = {
                    if (addToMyList != 0){
                        viewModel.deleteOneFromMyList(listId = myList)
                        Toast.makeText(context, "Removed from my List", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(
                            context, "Added to watchlist", LENGTH_SHORT
                        ).show()
                        viewModel.addToMyList(
                            MyList(
                                listId = myList,
                                imagePath = posterUrl,
                                title = filmName,
                                description = overview,
                                mediaType = mediaType
                            )
                        )
                    }
                },
                tint = if (addToMyList!= 0){
                    Color.Red
                }else{
                    Color.White
                }
            )
        }
    )
}

@ExperimentalCoilApi
@Composable
fun MovieBottomSheetContent(
    releaseDate: String,
    overview: String,
    filmName: String,
    casts: Resource<CastDetailsApiResponse>,
    sheetColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = Color.LightGray,
    state: LazyListState
) {
    Column(
        modifier = Modifier
            .background(sheetColor)
            .padding(all = SHEET_PADDING)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = filmName,
                color = contentColor,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )
        }
        Spacer(modifier = Modifier.height(SMALL_PADDING))
        Text(
            text = stringResource(R.string.release_date),
            color = contentColor,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        Text(
            text = releaseDate,
            color = contentColor,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.subtitle2
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        Text(
            text = stringResource(R.string.synopsis),
            color = contentColor,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.subtitle2
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        Text(
            text = overview,
            color = contentColor,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        if(casts is Resource.Success){
            CastDetails(casts = casts.data!!, scrollState = state)
        }

    }
}
@ExperimentalCoilApi
@Composable
fun MovieBackgroundColorSpan(
    posterUrl: String,
    myList: Int,
    imagePath: String,
    overview: String,
    mediaType:String,
    filmName: String,
    imageFraction: Float = 1f,
    backgroundColor: Color = MaterialTheme.colors.surface,
    onCloseClick: () -> Unit,
    viewModel: MyListViewModel = hiltViewModel(),
    onClick:()->Unit,
    tint:Color
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)

    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = imageFraction + 0.4f)
                .align(Alignment.TopStart),
            painter = rememberImagePainter(
                data = posterUrl,
                builder = {
                    placeholder(R.drawable.ic_placeholder)
                    crossfade(true)
                }
            ),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.background_image)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { onCloseClick() })
            { Icon(
                    modifier = Modifier.size(INFO_ICON_SIZE),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.close_button),
                    tint = Color.White
                )
            }
            IconButton(onClick = {
              onClick()
            }) {
                Icon(
                    modifier = Modifier.size(INFO_ICON_SIZE),
                    painter = painterResource(id = R.drawable.ic_thumb),
                    contentDescription = stringResource(R.string.like_movie_show),
                    tint = tint
                )
            }
        }
    }
}
@ExperimentalMaterialApi
val BottomSheetScaffoldState.currentSheetFraction:Float
    get() {
        val fraction = bottomSheetState.progress.fraction
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        Log.d("Fraction", fraction.toString())
        Log.d("Target", targetValue.toString())
        Log.d("Current", currentValue.toString())

        return when{
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Collapsed ->1f
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Expanded ->0f
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Expanded ->1f - fraction
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Collapsed ->1f + fraction
            else -> fraction
        }
    }