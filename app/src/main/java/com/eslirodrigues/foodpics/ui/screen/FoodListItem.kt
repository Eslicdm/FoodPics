package com.eslirodrigues.foodpics.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
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
            .padding(10.dp)
            .border(2.dp, DarkRed)
    ) {
        Image(
            painter = rememberImagePainter(food.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 311.dp, height = 267.dp)
        )
    }
}