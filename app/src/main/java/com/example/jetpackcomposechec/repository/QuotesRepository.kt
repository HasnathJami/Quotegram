package com.example.jetpackcomposechec.repository

import com.example.jetpackcomposechec.api.QuotesAPI
import com.example.jetpackcomposechec.models.Quote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class QuotesRepository @Inject constructor(private val quotesAPI: QuotesAPI) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _quotes = MutableStateFlow<List<Quote>>(emptyList())
    val quotes: StateFlow<List<Quote>>
        get() = _quotes

    suspend fun getCategories() {
        val response = quotesAPI.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getQuotes(category: String) {
        val response = quotesAPI.getQuotes(category)
        if (response.isSuccessful && response.body() != null) {
            _quotes.emit(response.body()!!)
        }
    }
}