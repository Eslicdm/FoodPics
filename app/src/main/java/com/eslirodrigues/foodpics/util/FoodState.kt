package com.eslirodrigues.foodpics.util

import androidx.paging.PagingData
import com.eslirodrigues.foodpics.data.model.Food
import kotlinx.coroutines.flow.Flow

sealed class FoodState {
    class Success(val data: Flow<PagingData<Food>>) : FoodState()
    class Failure(val msg: Throwable) : FoodState()
    object Loading : FoodState()
    object Empty : FoodState()
}