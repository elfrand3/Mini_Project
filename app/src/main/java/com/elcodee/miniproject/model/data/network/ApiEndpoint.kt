package com.elcodee.miniproject.model.data.network

import com.elcodee.miniproject.model.data.response.ApiResponse
import com.elcodee.miniproject.model.data.response.GenreResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiEndpoint {
    @GET("movie")
    fun getMovie(): Call<List<ApiResponse>>

    @GET("genre")
    fun getGenre(): Call<List<GenreResponse>>

    @POST("movie")
    fun postMovie(
        @Body data: JsonObject
    ): Call<ApiResponse>

    @DELETE("movie/{id}")
    fun deleteMovie(
        @Path("id") id: String
    ): Call<ApiResponse>
}