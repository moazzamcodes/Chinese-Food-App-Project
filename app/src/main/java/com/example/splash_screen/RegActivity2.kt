package com.example.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegActivity2 : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg2)

        nameEditText = findViewById(R.id.Name)
        emailEditText = findViewById(R.id.Email)
        passwordEditText = findViewById(R.id.password)
        registerButton = findViewById(R.id.regBTN)

        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                // Perform registration logic here
                // You can save the user's name, email, and password in a database or perform any other necessary actions
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ClosedRange::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }

    }
    }
}