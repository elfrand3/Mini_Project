package com.elcodee.miniproject.model.contract

import com.elcodee.miniproject.model.data.response.ApiResponse

interface MainContract {
    interface Presenter {
        fun getMovie()
    }
    interface View {
        fun initActivity()
        fun onMessage(Message: String)
        fun setData(response: List<ApiResponse>)
    }
}