package com.example.chillmax.presentation.details.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.chillmax.R
import com.example.chillmax.domain.models.MovieCredits
import com.example.chillmax.domain.models.responses.MovieCreditsApiResponses
import com.example.chillmax.presentation.ui.theme.EXTRA_SMALL_PADDING
import com.example.chillmax.presentation.ui.theme.INFO_ICON_SIZE
import com.example.chillmax.presentation.ui.theme.SHEET_PADDING
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING
import com.example.chillmax.util.Resource

@Composable
fun DetailsContent(
    navController:NavHostController
) {

}

@ExperimentalCoilApi
@Composable
fun MovieBottomSheetContent(
    filmName:String,
    releaseDay: String,
    casts: Resource<MovieCreditsApiResponses>,
    overview: String,
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
              text = filmName,
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
            text = releaseDay,
            color = contentColor,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        Text(
            text = overview,
            color = contentColor,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        if (casts is Resource.Success){
            CastDetails(casts = casts.data!!)
        }
    }
}

@ExperimentalCoilApi
@Composable
fun BackgroundColorSpan(
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