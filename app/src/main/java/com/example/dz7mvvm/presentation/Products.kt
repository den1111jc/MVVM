package com.example.dz7mvvm.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dz7mvvm.R
import com.example.dz7mvvm.databinding.ProductsBinding
import com.example.dz7mvvm.presentation.viewModel.ProductAdapter
import com.example.dz7mvvm.presentation.viewModel.ProductsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Products : Fragment() {

    private var binding: ProductsBinding? = null
    private var productAdapter: ProductAdapter? = null
    val productsViewModel: ProductsViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductsBinding.inflate(inflater, container, false)

        initRecyclerProducts()

        loadProducts()

        return binding?.root
    }

    private fun initRecyclerProducts(){
        binding?.recyclerProducts?.layoutManager = LinearLayoutManager(context)
        productAdapter = ProductAdapter()
        binding?.recyclerProducts?.adapter = productAdapter

    }

    private fun loadProducts(){
        productsViewModel.loadProducts.observe(viewLifecycleOwner, Observer {
            productAdapter?.setList(it)
            productAdapter?.notifyDataSetChanged()
        })
    }


}