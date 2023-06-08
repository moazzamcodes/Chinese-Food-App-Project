package com.example.foodordering.Adapters

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordering.DetailedActivity
import com.example.foodordering.Models.MainModels

import com.example.foodordering.R
import kotlinx.android.synthetic.main.activity_detailed2.view.*
import kotlinx.android.synthetic.main.sample_mainfood.view.*


class MainAdapter(val context: Context ,val arrFood: java.util.ArrayList<MainModels>) : RecyclerView.Adapter<MainAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageFood = itemView.imageFood
        val name = itemView.Name_order
        val price = itemView.price
        val description = itemView.description




    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.sample_mainfood , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageFood.setImageResource(arrFood[position].image)
        holder.name.text = arrFood[position].name
        holder.price.text = arrFood[position].price
        holder.description.text = arrFood[position].description

        holder.itemView.setOnClickListener(View.OnClickListener {


            val intent = Intent(context , DetailedActivity::class.java)
           intent.putExtra("image",arrFood[position].image)
            intent.putExtra("price",arrFood[position].price)
            intent.putExtra("desc",arrFood[position].description)
            intent.putExtra("name",arrFood[position].name)
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
       return arrFood.size

    }

}