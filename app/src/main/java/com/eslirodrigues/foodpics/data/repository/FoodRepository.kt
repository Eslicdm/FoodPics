package com.eslirodrigues.foodpics.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.eslirodrigues.foodpics.data.model.Food
import com.eslirodrigues.foodpics.data.paging.FoodSource
import com.eslirodrigues.foodpics.data.retrofit.FoodApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FoodRepository @Inject constructor(private val foodApi: FoodApi) {

    fun getAllFoods(): Flow<PagingData<Food>> = Pager(PagingConfig(pageSize = 1000)) {
        FoodSource(foodApi)
    }.flow.flowOn(Dispatchers.IO)
}