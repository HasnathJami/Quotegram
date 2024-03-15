package com.example.jetpackcomposechec.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcomposechec.R
import com.example.jetpackcomposechec.viewmodels.CategoryViewModel

@Composable
fun categoryScreen(onCategoryItemClick: (category: String) -> Unit) {
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val categories = categoryViewModel.categories.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        //verticalArrangement = Arrangement.SpaceAround,
        // modifier = Modifier.fillMaxSize()
    ) {
        items(categories.value.distinct()) {
            categoryItem(it, onCategoryItemClick)
        }
    }
}

@Composable
fun categoryItem(category: String, onCategoryItemClick:(category:String) -> Unit) {

    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(160.dp)
            .clickable {
                onCategoryItemClick(category)
            }
            .clip(RoundedCornerShape(8.dp))
            //.border(1.dp, Color(0xFFEEEEEE))
            .paint(
                painter = painterResource(id = R.drawable.wave_bg), contentScale = ContentScale.Crop
            )
            .border(1.dp, Color.Red), contentAlignment = Alignment.BottomCenter

    ) {
        Text(
            text = category,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(0.dp, 20.dp),
            style = MaterialTheme.typography.body1
        )
    }

}