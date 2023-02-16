package com.elcodee.miniproject.model.data.response

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("id") val id: String,
    @SerializedName("nama_movie") val nama_movie: String,
    @SerializedName("poster") val poster: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("pemeran") val pemeran: String,
    @SerializedName("sutradara") val sutradara: String,
    @SerializedName("negara") val negara: String,
    @SerializedName("date") val date: String
)
