package com.example.foodordering

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.foodordering.Models.Order_Models

class DBHelper (context: Context?): SQLiteOpenHelper(context, DBNAME, null, ver) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(
            "create table Order1" +
                    "(id integer primary key autoincrement," +
                    "name text," +
                    "phone text," +
                    "price integer," +
                    "image integer," +
                    "quantity integer," +
                    "description text," +
                    "foodname text)"
        )
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("DROP table if exists Order1")
        onCreate(sqLiteDatabase)
    }

    fun insertOrder(
        name: String,
        phone: String,
        price: Int,
        image: Int,
        desc: String,
        foodName: String,
        quantity: Int

    ): Boolean {
        val database = readableDatabase
        val values = ContentValues()
        values.put("name", name)
        values.put("phone", phone)
        values.put("price", price)
        values.put("image", image)
        values.put("quantity",quantity)
        values.put("description", desc)
        values.put("foodName", foodName)
      //  values.put("quantity", quantity)
        val id = database.insert("Order1", null, values)
        return if (id <= 0) {
            false
        } else {
            true
        }
    }

    val Order: ArrayList<Order_Models>
    get() {
        val Order = ArrayList<Order_Models>()
        val database = this.writableDatabase
        val cursor = database.rawQuery("Select id,foodName,image,price from Order1", null)
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                val model = Order_Models(0,"","","")

                model.OrderNumber = cursor.getInt(0).toString() + " "
                model.name_order = cursor.getString(1)
                model.imageFood = cursor.getInt(2)
                model.Order_price = cursor.getInt(3).toString() + " "
                Order.add(model)
            }
        }
        cursor.close()
        database.close()
        return Order
    }

    fun getOrderById(id: Int): Cursor? {
        val database = this.writableDatabase
        val cursor = database.rawQuery("Select * from Order1 where id= $id", null)
        cursor?.moveToFirst()
        return cursor
    }

    fun updateOrder(
        name: String,
        phone: String,
        price: Int,
        image: Int,
        desc: String,
        foodName: String,
        quantity: Int,
        id: Int
    ): Boolean {
        val database = readableDatabase
        val values = ContentValues()
        values.put("name", name)
        values.put("phone", phone)
        values.put("price", price)
        values.put("image", image)
        values.put("desc", desc)
        values.put("foodName", foodName)
        values.put("quantity", quantity)
        val row = database.update("Order1", values, "id=$id", null).toLong()
        return if (row <= 0) {
            false
        } else {
            true
        }
    }

    fun deleteOrder(id: String): Int {
        val database = this.writableDatabase
        return database.delete("Order1", "id=$id", null)
    }

    companion object {
        val DBNAME = "OrderApp_DB.db"
        val ver = 4
    }
}