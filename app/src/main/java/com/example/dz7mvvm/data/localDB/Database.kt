package com.example.dz7mvvm.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dz7mvvm.data.models.ProductsModel

@Database(entities = [ProductsModel::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract val productsDao: ProductsDao

}