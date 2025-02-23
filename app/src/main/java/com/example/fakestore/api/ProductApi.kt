package com.example.fakestore.api

import com.example.fakestore.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi{
    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}