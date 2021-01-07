package com.example.androidresttestapp.service

import com.example.androidresttestapp.model.Author
import com.example.androidresttestapp.repository.AuthorRepository
import com.example.androidresttestapp.repository.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AuthorManager {

    interface GetAuthorCallback{
        fun onResponse(authors:List<Author>)
        fun onFailure(error:String)
    }

    private class GetAuthorInternalCallback (val like:String, val externalCallback:GetAuthorCallback) : Callback<List<Author>> {
        override fun onResponse(call: Call<List<Author>>, response: Response<List<Author>>) {
            if (response.isSuccessful) {

                externalCallback.onResponse(response.body()!!)
            }
            else{

                externalCallback.onFailure("Error response")
            }
        }

        override fun onFailure(call: Call<List<Author>>, t: Throwable) {
            t.printStackTrace()
            externalCallback.onFailure("Call error: ${t.message}")
        }
    }

    fun getAuthors(like:String, callback:GetAuthorCallback) {
        val request = ServiceBuilder.buildService(AuthorRepository::class.java)
        val call = if (like.isEmpty()){
            request.getAuthors()
        } else{
            request.getAuthorsLike(like)
        }
        val internalCallback = GetAuthorInternalCallback(like, callback)
        call.enqueue(internalCallback)
    }
}
