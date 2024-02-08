package com.example.dz7mvvm.data.api

import com.example.dz7mvvm.data.models.ProductsApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("getProducts.php")
    fun getProduct(): Call<ArrayList<ProductsApiModel>>
}