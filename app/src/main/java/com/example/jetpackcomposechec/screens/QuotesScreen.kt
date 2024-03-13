package com.example.jetpackcomposechec.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposechec.viewmodels.QuotesViewModel

@Composable
fun quotesScreen() {
    val quotesViewModel: QuotesViewModel = viewModel()
    val quotes = quotesViewModel.quotes.collectAsState()

    LazyColumn(content = {
        items(quotes.value) {
            it.title?.let { it1 -> quotesListItem(quote = it1) }
        }
    })
}

@Composable
fun quotesListItem(quote: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {
            Text(
                text = quote,
                modifier = Modifier
                    .padding(16.dp),
                style = MaterialTheme.typography.body2
            )
        }
    )
}