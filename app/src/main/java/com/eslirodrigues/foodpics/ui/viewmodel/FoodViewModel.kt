package com.eslirodrigues.foodpics.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eslirodrigues.foodpics.data.repository.FoodRepository
import com.eslirodrigues.foodpics.util.FoodState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
) : ViewModel() {
    val response: MutableState<FoodState> = mutableStateOf(FoodState.Loading)

    init {
        getAllFoods()
    }

    private fun getAllFoods() = viewModelScope.launch {
        foodRepository.getAllFoods()
            .onStart {
                response.value = FoodState.Loading
            }
            .catch {
                response.value = FoodState.Failure(it)
            }
            .collect {
                delay(1000L)
                response.value = FoodState.Success(foodRepository.getAllFoods())
            }
    }
}