package com.example.retrofitapi

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("repos")
    fun getData():Call<List<PostModel>>
}