package com.eslirodrigues.foodpics.data.retrofit

import com.eslirodrigues.foodpics.data.model.Food
import retrofit2.http.GET

interface FoodApi {

    @GET("api/images/burger")
    suspend fun getAllBurgers(): Food

    @GET("api/images/pizza")
    suspend fun getAllPizza(): Food
}