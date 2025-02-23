package com.example.fakestore.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakestore.adapter.ProductAdapter
import com.example.fakestore.databinding.ActivityMainBinding
import com.example.fakestore.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    // ViewBinding for 'activity_main.xml'
    private lateinit var binding: ActivityMainBinding

    // MVVM ViewModel
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe product list from ViewModel
        viewModel.products.observe(this) { productList ->
            // Pass the product list to the adapter
            binding.recyclerView.adapter = ProductAdapter(productList)
        }

        // Observe error messages from ViewModel
        viewModel.errorMessage.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }

        // Fetch products from API
        viewModel.fetchProducts()
    }
}
