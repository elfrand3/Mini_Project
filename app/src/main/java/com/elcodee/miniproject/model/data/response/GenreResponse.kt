package com.elcodee.miniproject.model.data.response

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("id") val id: String,
    @SerializedName("nama_genre") val nama_genre: String
)