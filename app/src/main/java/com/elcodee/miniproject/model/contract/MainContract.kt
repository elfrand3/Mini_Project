package com.elcodee.miniproject.model.contract

import com.elcodee.miniproject.model.data.response.ApiResponse
import com.elcodee.miniproject.model.data.response.GenreResponse

interface MainContract {
    interface Presenter {
        fun getMovie()
        fun getGenre()
    }
    interface View {
        fun initActivity()
        fun initListener()
        fun onMessage(Message: String)
        fun setData(response: List<ApiResponse>)
        fun setGenre(genre: List<GenreResponse>)
    }
}