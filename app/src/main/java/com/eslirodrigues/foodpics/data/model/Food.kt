package com.eslirodrigues.foodpics.data.model


import com.squareup.moshi.Json

data class Food(
    val name: String = "",
    @Json(name = "image")
    val image: String = ""
)