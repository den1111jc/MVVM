package com.example.dz7mvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dz7mvvm.R
import com.example.dz7mvvm.databinding.ActivityMainBinding
import com.example.dz7mvvm.presentation.viewModel.ProductsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    val productsViewModel: ProductsViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        productsViewModel.migration(this)


        supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()

        binding?.bottomNav?.selectedItemId = R.id.homeItemBottomNav

        binding?.bottomNav?.setOnItemSelectedListener { item ->

            when(item.itemId) {
                R.id.homeItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()
                R.id.categoriesItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Products()).commit()

            }

            return@setOnItemSelectedListener true
        }


    }


}