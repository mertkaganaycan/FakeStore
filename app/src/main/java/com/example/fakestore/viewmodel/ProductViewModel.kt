package com.example.fakestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.api.RetrofitInstance
import com.example.fakestore.model.Product
import com.example.fakestore.repository.ProductRepository
import kotlinx.coroutines.launch

    class ProductViewModel: ViewModel(){
        private val repository = ProductRepository(RetrofitInstance.api)

        private val _products = MutableLiveData<List<Product>>()
        val products : LiveData<List<Product>> = _products

        private val _errorMessage = MutableLiveData<String>()
        val errorMessage: LiveData<String> = _errorMessage

        fun fetchProducts() {
            viewModelScope.launch {
                try {
                    val response = repository.getProducts()
                    if (response.isSuccessful) {
                        _products.postValue(response.body())
                    } else {
                        _errorMessage.postValue("Error: ${response.message()}")
                    }
                } catch (e: Exception) {
                    _errorMessage.postValue("Network error: ${e.message}")
                }
            }
        }
    }
