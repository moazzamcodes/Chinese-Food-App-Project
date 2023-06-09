package com.example.foodordering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodordering.Adapters.OrderAdapter
import com.example.foodordering.Models.Order_Models
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val arrFood1 = ArrayList<Order_Models>()

        arrFood1.add(Order_Models(R.drawable.chowmin , name_order = "Chow Min" , Order_price = "500" , OrderNumber = "9302832"))
        arrFood1.add(Order_Models(R.drawable.chowmin , name_order = "Chow Min" , Order_price = "500" , OrderNumber = "9305432"))
        arrFood1.add(Order_Models(R.drawable.sweetandsourpork , name_order = "Sweet & Sour Pork" , Order_price = "500" , OrderNumber = "9356432"))
        arrFood1.add(Order_Models(R.drawable.chowmin , name_order = "Chow Min" , Order_price = "500" , OrderNumber = "9385832"))
        arrFood1.add(Order_Models(R.drawable.chowmin , name_order = "Chow Min" , Order_price = "500" , OrderNumber = "9302542"))
        arrFood1.add(Order_Models(R.drawable.mapotofu , name_order = "Mo po rofu" , Order_price = "500" , OrderNumber = "9353432"))
        arrFood1.add(Order_Models(R.drawable.chowmin , name_order = "Chow Min" , Order_price = "500" , OrderNumber = "9386532"))
        arrFood1.add(Order_Models(R.drawable.chowmin , name_order = "Chow Min" , Order_price = "500" , OrderNumber = "9305462"))
        arrFood1.add(Order_Models(R.drawable.chowmin , name_order = "Chow Min" , Order_price = "500" , OrderNumber = "9305462"))


        RecyclerView_Main.layoutManager = LinearLayoutManager(this)

        val recyclerAdapter = OrderAdapter(this , arrFood1)
        RecyclerView_Order.adapter = recyclerAdapter
    }
}