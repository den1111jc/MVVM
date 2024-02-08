package com.example.dz7mvvm.data.repository.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.example.dz7mvvm.data.localDB.ProductsDao
import com.example.dz7mvvm.data.models.ProductsModel
import com.example.dz7mvvm.data.repository.dataSource.ProductsDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsDataSourceIMPL (private val dao: ProductsDao):
    ProductsDataSource {


    override fun insert(productsModel: ProductsModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertProduct(productsModel)}
    }

    override fun loadProducts(): LiveData<List<ProductsModel>> {
        return dao.getAllProducts()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }



}