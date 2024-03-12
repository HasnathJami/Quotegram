package com.example.jetpackcomposechec.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposechec.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: QuotesRepository):ViewModel() {
    val categories: StateFlow<List<String>>
    get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }
}