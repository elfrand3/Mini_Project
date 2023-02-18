package com.elcodee.miniproject.model.contract

import com.google.gson.JsonObject

interface PostContract {
    interface Presenter {
        fun postMovie(data: JsonObject)
    }
    interface View {
        fun initActivity()
        fun initListener()
        fun onMessage(Message: String)
    }
}