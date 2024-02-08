package com.example.dz7mvvm.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.dz7mvvm.data.models.ProductsModel

interface ProductsCall {

    fun loadProducts(): LiveData<List<ProductsModel>>

    suspend fun startMigration(context: Context)

}