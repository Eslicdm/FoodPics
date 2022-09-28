package com.eslirodrigues.foodpics.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eslirodrigues.foodpics.data.repository.FoodRepository
import com.eslirodrigues.foodpics.ui.state.FoodState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
) : ViewModel() {
    private val _foodState = MutableStateFlow(FoodState())
    val foodState: StateFlow<FoodState> = _foodState.asStateFlow()

    init {
        getAllFoods()
    }

    private fun getAllFoods() = viewModelScope.launch {
        _foodState.update { it.copy(data = null, isLoading = true, errorMsg = null) }
        val data = foodRepository.getAllFoods()
        _foodState.update { it.copy(data = data, isLoading = false, errorMsg = null) }
    }
}