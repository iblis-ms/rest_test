package com.example.androidresttestapp.repository

import com.example.androidresttestapp.model.Author
import retrofit2.Call
import retrofit2.http.GET

interface QuotationServiceAPI {

    @GET("/authors")
    fun getAuthors() : Call<List<Author>>
}