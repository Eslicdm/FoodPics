package com.eslirodrigues.foodpics.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.eslirodrigues.foodpics.data.model.Food
import com.eslirodrigues.foodpics.ui.theme.DarkRed

@Composable
fun FoodListItem(food: Food) {
    Column(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 7.dp)
            .background(DarkRed)
    ) {
        Image(
            painter = rememberImagePainter(food.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 411.dp, height = 267.dp)
        )
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
    }
}