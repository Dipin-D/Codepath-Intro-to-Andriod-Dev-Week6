package com.example.week6.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("character")
    fun getData(@Query("page")page: Int):Call<RickAndMorty>

}