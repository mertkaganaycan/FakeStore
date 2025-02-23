package com.example.fakestore.repository

import com.example.fakestore.api.ProductApi
import com.example.fakestore.model.Product
import retrofit2.Response

class ProductRepository(private val api:ProductApi){
    suspend fun getProducts(): Response<List<Product>>{
        return api.getProducts()
    }
}