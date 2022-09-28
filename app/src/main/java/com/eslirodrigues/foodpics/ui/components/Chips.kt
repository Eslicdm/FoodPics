package com.eslirodrigues.foodpics.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eslirodrigues.foodpics.ui.theme.DarkRed
import com.eslirodrigues.foodpics.ui.theme.LightRed
import com.eslirodrigues.foodpics.ui.theme.PrimaryRed

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FoodChip(
    labelList: SnapshotStateList<String>,
    onItemClicked: (food: String) -> Unit,
    content: @Composable () -> Unit
) {
    var selectedItem by remember { mutableStateOf("") }
    var isSelected by remember { mutableStateOf(false) }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryRed),
    ) {
        items(labelList) { name ->
            Spacer(modifier = Modifier.padding(5.dp))
            isSelected = selectedItem == name
            FilterChip(
                selected = isSelected,
                onClick = {
                    selectedItem = name
                    onItemClicked(name)
                },
                border = if (isSelected)
                    BorderStroke(1.dp, DarkRed) else BorderStroke(1.dp, Color.LightGray),
                colors = ChipDefaults.filterChipColors(
                    contentColor = if (isSelected) Color.White else Color.LightGray,
                    backgroundColor = if (isSelected) LightRed else DarkRed
                ),
                content = {
                    Text(
                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 9.dp),
                        text = name,
                        color = if (isSelected) Color.White else Color.LightGray
                    )
                }
            )
        }
    }
    content()
}