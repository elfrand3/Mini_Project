package com.elcodee.miniproject.presenter

import com.elcodee.miniproject.model.contract.MainContract
import com.elcodee.miniproject.model.data.network.ApiService
import com.elcodee.miniproject.model.data.response.ApiResponse
import com.elcodee.miniproject.model.data.response.GenreResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View): MainContract.Presenter {
    init {
        view.initActivity()
    }
    override fun getMovie() {
        ApiService.getInstance().getMovie().enqueue(object : Callback<List<ApiResponse>>{
            override fun onResponse(
                call: Call<List<ApiResponse>>,
                response: Response<List<ApiResponse>>
            ) {
                if (response.isSuccessful){
                    val responseApi =  response.body()
                    view.setData(responseApi!!)
                }
            }

            override fun onFailure(call: Call<List<ApiResponse>>, t: Throwable) {
                view.onMessage("$t")
            }
        })
    }

    override fun getGenre() {
        ApiService.getInstance().getGenre().enqueue(object : Callback<List<GenreResponse>>{
            override fun onResponse(
                call: Call<List<GenreResponse>>,
                response: Response<List<GenreResponse>>
            ) {
                if (response.isSuccessful){
                    val responseApi =  response.body()
                    view.setGenre(responseApi!!)
                }
            }

            override fun onFailure(call: Call<List<GenreResponse>>, t: Throwable) {
                view.onMessage("$t")
            }
        })
    }
}