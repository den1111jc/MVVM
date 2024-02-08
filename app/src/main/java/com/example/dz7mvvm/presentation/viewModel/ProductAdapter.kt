package com.example.dz7mvvm.presentation.viewModel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz7mvvm.data.models.ProductsModel
import com.example.dz7mvvm.databinding.ProductItemBinding
import com.squareup.picasso.Picasso

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    private val productsList = ArrayList<ProductsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {

        val binding : ProductItemBinding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(binding)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(productsList[position])
    }

    fun setList(products: List<ProductsModel>) {
        productsList.clear()
        productsList.addAll(products)

    }


    class ProductHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            productsModel: ProductsModel

        ) {

            val getImage = productsModel.image
            Picasso.get().load(getImage).into(binding.imageProduct)
            binding.idProduct.text = productsModel.id.toString()
            binding.nameProduct.text = productsModel.name
            binding.categoryProduct.text = productsModel.category
            binding.priceProduct.text = productsModel.price

        }

    }

}
