package com.example.dz7mvvm.presentation.di

import androidx.room.Room
import com.example.dz7mvvm.data.localDB.Database
import com.example.dz7mvvm.data.repository.ProductsRepository
import com.example.dz7mvvm.data.repository.dataSource.ProductsApiDataSource
import com.example.dz7mvvm.data.repository.dataSource.ProductsDataSource
import com.example.dz7mvvm.data.repository.dataSourceIMPL.ProductsApiDataSourceIMPL
import com.example.dz7mvvm.data.repository.dataSourceIMPL.ProductsDataSourceIMPL
import com.example.dz7mvvm.domain.repository.ProductsCall
import com.example.dz7mvvm.domain.useCase.ProductsUseCase
import com.example.dz7mvvm.presentation.viewModel.ProductsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleProducts = module{

    single {
        Room.databaseBuilder(androidContext(), Database::class.java,
            "localDB").build()
    }

    single { get<Database>().productsDao }


    single<ProductsDataSource> {
        ProductsDataSourceIMPL(
            get()
        )
    }

    single<ProductsApiDataSource> {
        ProductsApiDataSourceIMPL(
            get()
        )
    }

    single<ProductsCall> { ProductsRepository(get(),get()) }

    single { ProductsUseCase(get()) }

    viewModel { ProductsViewModel(get()) }

}