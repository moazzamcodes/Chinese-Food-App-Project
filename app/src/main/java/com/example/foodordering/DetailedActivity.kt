package com.example.foodordering

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detailed2.*

class DetailedActivity : AppCompatActivity() {

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed2)
        val helper = DBHelper(this)
if (intent.getIntExtra("type",0)==1){

        val intent = intent
        val image = intent.getIntExtra( "image", 0) // Retrieves the string value associated with "name" key
        val price = intent.getIntExtra("price", 0)
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("desc")
    fooodname.text = fooodname.text
        detailImages.setImageResource(image)
        amount.setText(String.format("%d",price))

        detailedDescription.setText(description)




        insertButton.setOnClickListener{
            val isInserted: Boolean = helper.insertOrder(
                nameBox.text.toString(),
                phoneBox.text.toString(),
                price,
                image,
                name.toString(),
                description.toString(),
                quantity.text.toString().toInt()
            )
            if (isInserted)
                Toast.makeText(this, "Data success", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

        }

    }
        else{
            val id:Int = intent.getIntExtra("id",0)

            val Cursor= helper.getOrderById(id)
       val image = Cursor?.getInt(4)
        if (image != null) {
            detailImages.setImageResource(image)
        }

        if (Cursor != null) {
            amount.setText(String.format("%d",Cursor.getInt(3)))
        }
        if (Cursor != null) {
            nameBox.setText(Cursor.getString(6))
        }
        if (Cursor != null) {
            detailedDescription.setText(Cursor.getString(5))
        }
        if (Cursor != null) {
            nameBox.setText(Cursor.getString(1))
        }
        if (Cursor != null) {
            phoneBox.setText(Cursor.getString(2))
        }
        insertButton.setText("Update Now")
        insertButton.setOnClickListener(View.OnClickListener {
            val isUpdated: Boolean = helper.updateOrder(
                nameBox.text.toString(),
                phoneBox.text.toString(),
                amount.text.toString().toInt(),
                image.toString().toInt(),
                detailedDescription.text.toString(),
                nameBox.text.toString(),
            1,id
            )
            if (isUpdated)
                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
                else
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

        })

                    }
        }

}