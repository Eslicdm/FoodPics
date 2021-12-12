package com.eslirodrigues.foodpics.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.eslirodrigues.foodpics.data.model.Food
import com.eslirodrigues.foodpics.ui.viewmodel.FoodViewModel
import com.eslirodrigues.foodpics.util.FoodState

@Composable
fun FoodListScreen(
    viewModel: FoodViewModel = hiltViewModel()
) {

    when (val result = viewModel.response.value) {
        is FoodState.Success -> {
            val food: LazyPagingItems<Food> = result.data.collectAsLazyPagingItems()
            LazyRow {
                items(food) { response ->
                    FoodListItem(food = response!!)
                }
            }
        }
        is FoodState.Failure -> {
            Text(text = "${result.msg}")
        }
        is FoodState.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        is FoodState.Empty -> {
            Text(text = "Empty")
        }
    }
}