package com.eslirodrigues.foodpics.data.model


import com.squareup.moshi.Json

data class Food(
    @Json(name = "image")
    val image: String = ""
)