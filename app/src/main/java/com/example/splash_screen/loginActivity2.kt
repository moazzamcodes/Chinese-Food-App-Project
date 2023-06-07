package com.example.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class loginActivity2 : AppCompatActivity() {


    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var RegisterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        usernameEditText = findViewById(R.id.Email)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginBTN)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username == "admin" && password == "password") {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                // Perform additional actions after successful login
                val intent = Intent(this, ClosedRange::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid username or password.", Toast.LENGTH_SHORT).show()
                // Perform additional actions for a failed login
            }
        }

        val openButton: Button = findViewById(R.id.signupBTN)
        openButton.setOnClickListener {
            val intent = Intent(this, RegActivity2::class.java)
            startActivity(intent)
        }

    }
        }
