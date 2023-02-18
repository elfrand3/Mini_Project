package com.elcodee.miniproject.model.contract

import com.google.gson.JsonObject

interface PutContract {
    interface Presenter {
        fun putMovie(id: String, up: JsonObject)
    }
    interface View {
        fun initActivity()
        fun initListener()
        fun onMessage(Message: String)
    }
}