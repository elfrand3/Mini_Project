package com.elcodee.miniproject.model.data.network

import com.elcodee.miniproject.model.data.response.ApiResponse
import com.elcodee.miniproject.model.data.response.GenreResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("movie")
    fun getMovie(): Call<List<ApiResponse>>

    @GET("genre")
    fun getGenre(): Call<List<GenreResponse>>
}