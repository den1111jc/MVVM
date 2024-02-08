package com.example.dz7mvvm.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.dz7mvvm.data.models.ProductsModel
import com.example.dz7mvvm.domain.repository.ProductsCall

class ProductsUseCase (private val productsCall: ProductsCall) {


    fun loadProducts(): LiveData<List<ProductsModel>> {

        return productsCall.loadProducts()

    }

    suspend fun startMigration (context: Context) {

        productsCall.startMigration(context)

    }



}