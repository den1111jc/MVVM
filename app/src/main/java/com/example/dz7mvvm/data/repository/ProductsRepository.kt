package com.example.dz7mvvm.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.dz7mvvm.data.models.ProductsModel
import com.example.dz7mvvm.data.repository.dataSource.ProductsApiDataSource
import com.example.dz7mvvm.data.repository.dataSource.ProductsDataSource
import com.example.dz7mvvm.domain.repository.ProductsCall

class ProductsRepository (private val productsApiDataSource: ProductsApiDataSource,
                          private val productsDataSource: ProductsDataSource
): ProductsCall {

    override fun loadProducts(): LiveData<List<ProductsModel>> {    //метод получения данных с локальной БД
        return productsDataSource.loadProducts()
    }

    override suspend fun startMigration(context: Context) {
        productsDataSource.clear()
        productsApiDataSource.startMigration(context)
    }

}