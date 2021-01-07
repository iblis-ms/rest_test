package com.example.androidresttestapp.repository

import com.example.androidresttestapp.model.Author
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthorRepository {

    @GET("/authors")
    fun getAuthors() : Call<List<Author>>

    @GET("/find_authors")
    fun getAuthorsLike(@Query("like") like:String) : Call<List<Author>>
}