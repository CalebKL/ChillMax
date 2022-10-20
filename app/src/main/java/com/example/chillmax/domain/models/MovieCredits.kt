package com.example.chillmax.domain.models

import com.google.gson.annotations.SerializedName

data class MovieCredits(
    @SerializedName("adult")
    val adult: Boolean? = null,
    @SerializedName("cast_id")
    val cast_id: Int? = null,
    @SerializedName("character")
    val character: String? = null,
    @SerializedName("credit_id")
    val credit_id: String? = null,
    @SerializedName("gender")
    val gender: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("known_for_department")
    val known_for_department: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("order")
    val order: Int? = null,
    @SerializedName("original_name")
    val original_name: String? = null,
    @SerializedName("popularity")
    val popularity: Double? = null,
    @SerializedName("profile_path")
    val profile_path: String? = null
)