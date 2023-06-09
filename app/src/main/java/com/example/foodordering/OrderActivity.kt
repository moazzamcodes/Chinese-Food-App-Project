package com.example.foodordering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodordering.Adapters.OrderAdapter
import com.example.foodordering.Models.OrderModels
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_order)


        val helper = DBHelper(this)
        val arrFood1 = ArrayList<OrderModels>()



        RecyclerView_Order.layoutManager = LinearLayoutManager(this)

        val recyclerAdapter = OrderAdapter(this , arrFood1)
        RecyclerView_Order.adapter = recyclerAdapter
    }
}