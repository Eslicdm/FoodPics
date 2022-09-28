package com.eslirodrigues.foodpics.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.eslirodrigues.foodpics.data.model.Food
import com.eslirodrigues.foodpics.ui.theme.DarkRed
import com.eslirodrigues.foodpics.ui.theme.LightRed

@Composable
fun FoodListItem(food: Food) {
    val price = (1..100).random()

    Card(
        modifier = Modifier.padding(10.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .background(LightRed)
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .size(width = 311.dp, height = 167.dp)
                    .border(2.dp, DarkRed),
                contentScale = ContentScale.Crop,
                loading = { LinearProgressIndicator() },
                model = food.image,
                contentDescription = "${food.name} $price"
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = food.name.capitalize(Locale.current),
                    color = Color.White
                )
                Text(
                    text = "$$price",
                    color = Color.White
                )
            }
        }
    }
}