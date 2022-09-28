package com.eslirodrigues.foodpics.ui.state

import androidx.paging.PagingData
import com.eslirodrigues.foodpics.data.model.Food
import kotlinx.coroutines.flow.Flow

data class FoodState(
    val data: Flow<PagingData<Food>>? = null,
    val isLoading: Boolean = false,
    val errorMsg: String? = null
)