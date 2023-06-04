package com.example.foodordering.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordering.Models.Order_Models
import com.example.foodordering.R
import kotlinx.android.synthetic.main.order_samples.view.*
import kotlinx.android.synthetic.main.sample_mainfood.view.Name_order
import kotlinx.android.synthetic.main.sample_mainfood.view.imageFood

class OrderAdapter(val context: Context, val arrFood1: java.util.ArrayList<Order_Models>) : RecyclerView.Adapter<OrderAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageFood = itemView.imageFood
        val name_order = itemView.Name_order
        val order_price = itemView.Order_price
        val order_num = itemView.orderrr


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.order_samples , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageFood.setImageResource(arrFood1[position].imageFood)
        holder.name_order.text = arrFood1[position].name_order
        holder.order_price.text = arrFood1[position].Order_price
        holder.order_num.text = arrFood1[position].OrderNumber

    }

    override fun getItemCount(): Int {
        return arrFood1.size
    }}
