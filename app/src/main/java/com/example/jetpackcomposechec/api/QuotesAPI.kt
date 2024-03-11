package com.example.jetpackcomposechec.api

import com.example.jetpackcomposechec.models.Quote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface QuotesAPI {

    @GET("/v3/b/65ef4453266cfc3fde96ec1a?meta=false")
    suspend fun getQuotes(
        @Header("X-JSON-Path") category: String
    ): Response<List<Quote>>

    @GET("/v3/b/65ef4453266cfc3fde96ec1a?meta=false")
    @Headers("X-JSON-Path: quotes..category")
    suspend fun getCategories(): Response<List<String>>
}