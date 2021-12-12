package com.eslirodrigues.foodpics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eslirodrigues.foodpics.ui.screen.FoodListScreen
import com.eslirodrigues.foodpics.ui.theme.FoodPicsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodPicsTheme {
               FoodListScreen()
            }
        }
    }
}