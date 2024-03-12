package com.example.jetpackcomposechec.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposechec.models.Quote
import com.example.jetpackcomposechec.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(private val repository: QuotesRepository) : ViewModel() {
    val quotes: StateFlow<List<Quote>>
        get() = repository.quotes

    init {
        viewModelScope.launch {
            repository.getQuotes("Inspirational")
        }
    }
}