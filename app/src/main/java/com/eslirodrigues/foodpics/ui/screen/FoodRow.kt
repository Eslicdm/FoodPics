package com.eslirodrigues.foodpics.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eslirodrigues.foodpics.data.model.Food
import com.eslirodrigues.foodpics.ui.theme.DarkRed

@Composable
fun FoodRow(foodList: List<Food?>, foodName: String) {
    Text(
        text = foodName,
        color = Color.White,
        modifier = Modifier
            .background(DarkRed)
            .padding(horizontal = 10.dp)
            .width(80.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    )
    LazyRow(modifier = Modifier.background(DarkRed)) {
        items(foodList) { response ->
            FoodListItem(food = response!!)
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))
}