package com.example.foodordering

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detailed2.*

class DetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed2)


        val intent = intent
        val image = intent.getIntExtra("image",0) // Retrieves the string value associated with "name" key
        val price = intent.getIntExtra("price", 0)
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("desc")

        detailImages.setImageResource(image)
        nameBox.setText(name)
        amount.setText(String.format("%d",price))
        detailedDescription.setText(description)

        val helper = DBHelper(this)
        insertButton.setOnClickListener /* l = */ {
            val isInserted: Boolean = helper.insertOrder(
                nameBox.text.toString(),
                phoneBox.text.toString(),
                price,
                image,
                description.toString(),
                name.toString()
            )
            if (isInserted)
                Toast.makeText(this, "Data success", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

        }

    }

}