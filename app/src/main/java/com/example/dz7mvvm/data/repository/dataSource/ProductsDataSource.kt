package com.example.dz7mvvm.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.example.dz7mvvm.data.models.ProductsModel


interface ProductsDataSource {

    fun insert(productsModel: ProductsModel)

    fun loadProducts(): LiveData<List<ProductsModel>>

    suspend fun clear()

}