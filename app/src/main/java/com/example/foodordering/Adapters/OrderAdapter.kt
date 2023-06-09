package com.example.foodordering.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordering.DetailedActivity
import com.example.foodordering.Models.OrderModels
import com.example.foodordering.R
import kotlinx.android.synthetic.main.order_samples.view.*
import kotlinx.android.synthetic.main.sample_mainfood.view.Name_order
import kotlinx.android.synthetic.main.sample_mainfood.view.imageFood

class OrderAdapter(private val context: Context,private val arrFood1: java.util.ArrayList<OrderModels>) : RecyclerView.Adapter<OrderAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageFood: ImageView = itemView.imageFood
        val nameorder: TextView = itemView.Name_order
        val orderprice: TextView = itemView.Order_price
        val ordernum: TextView = itemView.orderrr




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.order_samples , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageFood.setImageResource(arrFood1[position].imageFood)
        holder.nameorder.text = arrFood1[position].name_order
        holder.orderprice.text = arrFood1[position].Order_price
        holder.ordernum.text = arrFood1[position].OrderNumber
        holder

        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context , DetailedActivity::class.java)
            intent.putExtra("id",(arrFood1[position].OrderNumber))
            intent.putExtra("type",2)
            context.startActivity(intent)
        })









    }

    override fun getItemCount(): Int {
        return arrFood1.size
    }}
