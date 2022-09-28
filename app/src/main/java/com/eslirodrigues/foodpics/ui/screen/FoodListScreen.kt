package com.eslirodrigues.foodpics.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.eslirodrigues.foodpics.ui.components.FoodChip
import com.eslirodrigues.foodpics.ui.theme.PrimaryRed
import com.eslirodrigues.foodpics.ui.viewmodel.FoodViewModel

@Composable
fun FoodListScreen(
    viewModel: FoodViewModel = hiltViewModel(),
) {
    val foodState by viewModel.foodState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when {
            foodState.errorMsg != null -> { Text(text = foodState.errorMsg!!) }
            foodState.isLoading -> { CircularProgressIndicator() }
            foodState.data != null -> {
                val foodChipLabel = mutableStateListOf<String>()
                val data = foodState.data!!.collectAsLazyPagingItems().itemSnapshotList
                var filterChipName by remember { mutableStateOf("") }
                data.groupBy { it?.name }.keys.forEach { if (it != null) foodChipLabel.add(it) }
                FoodChip(labelList = foodChipLabel, onItemClicked = { food ->
                    filterChipName = food
                }) {
                    val filteredList = if (filterChipName.isNotEmpty()) {
                        data.filter { it?.name == filterChipName }
                    } else { data }
                    LazyVerticalGrid(
                        modifier = Modifier
                            .background(PrimaryRed)
                            .fillMaxSize(),
                        columns = GridCells.Fixed(2)
                    ) {
                        items(filteredList) { food ->
                            Spacer(modifier = Modifier.padding(5.dp))
                            if (food != null) FoodListItem(food = food)
                        }
                    }
                }
            }
        }
    }
}