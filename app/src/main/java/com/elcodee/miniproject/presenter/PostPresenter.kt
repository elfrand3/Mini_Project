package com.elcodee.miniproject.presenter

import com.elcodee.miniproject.model.contract.PostContract
import com.elcodee.miniproject.model.data.network.ApiService
import com.elcodee.miniproject.model.data.response.ApiResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostPresenter(val view: PostContract.View): PostContract.Presenter {
    init {
        view.initActivity()
        view.initListener()
    }
    override fun postMovie(data: JsonObject) {
        ApiService.getInstance().postMovie(data).enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful){
                    view.onMessage("success")
                }else{
                    view.onMessage("gagal")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                view.onMessage("$t")
            }
        })
    }
}