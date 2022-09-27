package com.example.chillmax.domain.models

import androidx.annotation.DrawableRes
import com.example.chillmax.R

sealed class OnBoarding(
    @DrawableRes
    val image: Int,
    val title: String,
    val text: String
){
    object First: OnBoarding(
        image = R.drawable.lothbrok,
        title = "WELCOME",
        text = "Your Favourite Movies and Series brought right to you."
    )
    object Second: OnBoarding(
        image = R.drawable.heisenberg,
        title = "FIND A MOVIE",
        text = "Watch and find movies that bring your mood back"
    )
    object Third: OnBoarding(
        image = R.drawable.spiderman,
        title = "REAL TIME",
        text = "Movie & TV information and updates movie trailers "
    )
}
