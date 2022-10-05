package com.tech4dev.wmtstore.ui.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.tech4dev.wmtstore.R
import com.tech4dev.wmtstore.data.models.Product

class CartAdapter(val context: Context, val cartViewModel: CartViewModel): RecyclerView.Adapter<CartViewHolder>()  {
    private val listOfSelectedProducts: List<Product> = cartViewModel.getProducts()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.layout_cart, parent, false)
        return CartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product: Product = listOfSelectedProducts[position]

        //show name
        holder.productName.text = product.name

        //show price
        holder.price.text = "$${product.price}"

        //show image
        Glide.with(context).load(product.image).into(holder.image)

        //show quantity
        holder.quantity.text = cartViewModel.getQuantity(product).toString()
    }

    override fun getItemCount(): Int = listOfSelectedProducts.size
}

class CartViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val image: ImageView = itemView.findViewById(R.id.image)
    val productName: TextView = itemView.findViewById(R.id.product_name)
    val price: TextView = itemView.findViewById(R.id.price)
    val quantity: TextView = itemView.findViewById(R.id.quantity)
    val decreaseQty: MaterialButton = itemView.findViewById(R.id.decrease_quantity)
    val increaseQty: MaterialButton = itemView.findViewById(R.id.increase_quantity)
    val deleteBtn: MaterialButton = itemView.findViewById(R.id.delete)
}