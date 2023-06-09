package com.example.foodordering

import android.content.Intent
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodordering.Adapters.MainAdapter
import com.example.foodordering.Models.MainModels
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sample_mainfood.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrFood = ArrayList<MainModels>()
        arrFood.add(MainModels(R.drawable.chowmin , name = "Chow Min" , price = "500" , description = "stir-fried vegetables , topped with shredded chicken , & served with fried noodles"))
        arrFood.add(MainModels(R.drawable.dimsum, name = "Dim Sum" , price = "600" , description = "a traditional Chinese meal made up of small plates of dumplings and other snack dishes and is usually accompanied by tea."))
        arrFood.add(MainModels(R.drawable.dumplings , name = "Dumplings" , price = "599" , description = "Chinese dumplings Jiaozi, are stuffed parcels made of unleavened dough and savoury fillings consisting of minced ingredients like meat, egg, tofu, or vegetables."))
        arrFood.add(MainModels(R.drawable.kungpaochicken , name = "Kung-Pao-Chicken" , price = "690" , description = " Chinese-style stir-fried chicken cubes with dried chili peppers"))
        arrFood.add(MainModels(R.drawable.greekchicken , name = "Greek Chicken" , price = "800" , description = " a dumpling filled with minced pork and spices, usually boiled in and served with soup but sometimes fried as a side dish."))
        arrFood.add(MainModels(R.drawable.charsiu , name = "Char Siu" , price = "700" , description = "Chinese restaurant-style pork with a deep red, sweet and sticky coating."))
        arrFood.add(MainModels(R.drawable.mapotofu , name = "Ma Po Toffu" , price = "570" , description = "made with simmered medium-firm silken tofu flavored with fermented bean paste, beef, plenty of red-hot roasted chili oil, and a handful of Sichuan peppercorns."))
        arrFood.add(MainModels(R.drawable.sweetandsourpork , name = "Sweet And Sour Pork" , price = "500" , description = " deep-fried pork, stir-fried with sweet pineapples and vibrant bell peppers covered in a bright sauce."))
        arrFood.add(MainModels(R.drawable.pestochickenbruschetta , name = "Pesto Chicken Bruschetta" , price = "700" , description = "stir-fried vegetables , topped with shredded chicken , & served with fried noodles"))
        arrFood.add(MainModels(R.drawable.buffalochickenbites , name = "Bluffalo_Chicken_Bites" , price = "800" , description = "stir-fried vegetables , topped with shredded chicken , & served with fried noodles"))
        arrFood.add(MainModels(R.drawable.chickenempanada, name = "Chicken_Empanada" , price = "900" , description = "stir-fried vegetables , topped with shredded chicken , & served with fried noodles"))
        arrFood.add(MainModels(R.drawable.chineseorangechicken, name = "Chinese_Orange_Chicken" , price = "900" , description = "stir-fried vegetables , topped with shredded chicken , & served with fried noodles"))
        arrFood.add(MainModels(R.drawable.twicecookedporkslices, name = "Twice Cooked Pork Slices" , price = "900" , description = "stir-fried vegetables , topped with shredded chicken , & served with fried noodles"))


        RecyclerView_Main.layoutManager = LinearLayoutManager(this)

        val recyclerAdapter1 = MainAdapter(this , arrFood)
        RecyclerView_Main.adapter = recyclerAdapter1



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Orders -> {
                // Handle menu item 1 click
                startActivity(Intent(this,OrderActivity::class.java))
                true
            }



       else -> return super.onOptionsItemSelected(item)
    }
}}