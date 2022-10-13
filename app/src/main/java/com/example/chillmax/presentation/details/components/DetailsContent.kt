package com.example.chillmax.presentation.details.components

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.chillmax.R
import com.example.chillmax.domain.models.MovieCredits
import com.example.chillmax.domain.models.TopRatedMovies
import com.example.chillmax.domain.models.TopRatedMoviesDetails
import com.example.chillmax.domain.models.responses.MovieCreditsApiResponses
import com.example.chillmax.domain.models.responses.TopRatedMoviesApiResponses
import com.example.chillmax.presentation.details.DetailsViewModel
import com.example.chillmax.presentation.ui.theme.*
import com.example.chillmax.util.Resource
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun DetailsContent(
    navigator: DestinationsNavigator,
    selectedHero: TopRatedMoviesDetails?,
    ) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Expanded)
    )

    val currentSheetFraction = scaffoldState.currentSheetFraction

    val radiusAnim by animateDpAsState(
        targetValue =
        if (currentSheetFraction ==1f)
            EXTRA_LARGE_PADDING
        else RADIUS_DP
    )
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetShape = RoundedCornerShape(
            topStart = radiusAnim,
            topEnd = radiusAnim
        ),
        sheetPeekHeight = SHEET_PEEK_HEIGHT,
        sheetContent = {
                       selectedHero?.let {
                           MovieBottomSheetContent(
                               hero = it
                           )
                       }
        },
        content = {
            selectedHero?.let { hero->
                MovieBackgroundColorSpan(
                    posterUrl = hero.poster_path,
                    onCloseClick ={

                    }
                )
            }
        }
    )
}

@ExperimentalCoilApi
@Composable
fun MovieBottomSheetContent(
    hero: TopRatedMoviesDetails,
    sheetColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = Color.LightGray
){
    Column(
        modifier = Modifier
            .background(sheetColor)
            .padding(all = SHEET_PADDING)
    ){
      Row(
          modifier = Modifier
              .fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically
      ){
          Text(
              text = hero.title,
              color = contentColor,
              fontWeight = FontWeight.Bold,
              fontSize = 14.sp
          )
      }
        Spacer(modifier = Modifier.height(SMALL_PADDING))
        Text(
            text = stringResource(R.string.release_date),
            color = contentColor,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        Text(
            text = hero.release_date,
            color = contentColor,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        Text(
            text = hero.overview,
            color = contentColor,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
//        if (casts is Resource.Success){
//            CastDetails(casts = casts.data!!)

    }
}

@ExperimentalCoilApi
@Composable
fun MovieBackgroundColorSpan(
    posterUrl: String,
    imageFraction: Float = 1f,
    backgroundColor:Color = MaterialTheme.colors.surface,
    onCloseClick:()->Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ){
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
            horizontalArrangement = Arrangement.End
        ){
            IconButton(
                onClick = { onCloseClick()}
            ) {
                Icon(
                    modifier= Modifier.size(INFO_ICON_SIZE),
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(R.string.close_button),
                    tint = Color.White
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