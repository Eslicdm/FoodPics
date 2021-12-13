package com.eslirodrigues.foodpics.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.eslirodrigues.foodpics.data.model.Food
import com.eslirodrigues.foodpics.ui.theme.PrimaryRed
import com.eslirodrigues.foodpics.ui.viewmodel.FoodViewModel
import com.eslirodrigues.foodpics.util.FoodState

@Composable
fun FoodListScreen(
    viewModel: FoodViewModel = hiltViewModel()
) {
    LazyColumn(
        modifier = Modifier
            .background(PrimaryRed)
            .fillMaxSize()
    ) {
        items(1) {
            when (val result = viewModel.response.value) {
                is FoodState.Success -> {
                    val food: LazyPagingItems<Food> = result.data.collectAsLazyPagingItems()
                    val burgerList = food.itemSnapshotList.filter {
                        it?.name == "burger"
                    }
                    val pizzaList = food.itemSnapshotList.filter {
                        it?.name == "pizza"
                    }
                    val pastaList = food.itemSnapshotList.filter {
                        it?.name == "pasta"
                    }
                    val dessertList = food.itemSnapshotList.filter {
                        it?.name == "dessert"
                    }
                    FoodRow(foodList = burgerList, foodName = "Burger")
                    FoodRow(foodList = pizzaList, foodName = "Pizza")
                    FoodRow(foodList = pastaList, foodName = "Pasta")
                    FoodRow(foodList = dessertList, foodName = "Dessert")
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
    }
}