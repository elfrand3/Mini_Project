package com.elcodee.miniproject.presenter

import com.elcodee.miniproject.model.contract.PutContract
import com.elcodee.miniproject.model.data.network.ApiService
import com.elcodee.miniproject.model.data.response.ApiResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PutPresenter(val view: PutContract.View): PutContract.Presenter {
    init {
        view.initActivity()
        view.initListener()
    }
    override fun putMovie(id: String, up: JsonObject) {
        ApiService.getInstance().putMovie(id, up).enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful){
                    view.onMessage("update success")
                }else{
                    view.onMessage("update gagal")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                view.onMessage("$t")
            }
        })
    }
}