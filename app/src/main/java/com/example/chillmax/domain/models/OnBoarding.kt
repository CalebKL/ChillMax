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
        image = R.drawable.ragnar,
        title = "Welcome to ChillMax",
        text = "Watch your favourite Movies at the comfort of your home without going out."
    )
    object Second: OnBoarding(
        image = R.drawable.heisenberg,
        title = "Looking for your Favourite Movies/Shows?",
        text = "Do you have a favourite movie or show you are interested in watching? You are in the right place"
    )
    object Third: OnBoarding(
        image = R.drawable.johnsnow,
        title = "Only with Us for You",
        text = "We have design our application to suit your needs. Simplicity is what we thrive in."
    )
}
