package com.example.healthcare24

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var edUsername: EditText
    private lateinit var edPassword: EditText
    private lateinit var btn: Button
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edUsername = findViewById(R.id.editTextLoginUsername)
        edPassword = findViewById(R.id.editTextLoginPassword)
        btn = findViewById(R.id.buttonLogin)
        tv = findViewById(R.id.textViewNewUser)

        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                startActivity(Intent(this@LoginActivity,HomeActivity::class.java))

               val username = edUsername.text.toString()
                val password = edPassword.text.toString()
                val db = Database(applicationContext, "Healthcare24", null, 1)

                if(username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(applicationContext, "Please fill all details", Toast.LENGTH_SHORT).show()
            } else {

                if (db.login(username,password)==1) {
                    Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()

                    val sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
                    val editor = sharedpreferences.edit()
                    editor.putString("username", username)

                    // to save our data with key and value
                    editor.apply()

                    startActivity(Intent(this@LoginActivity,HomeActivity::class.java))

                }else{
                }

                Toast.makeText(applicationContext, "Invalid Username and Password", Toast.LENGTH_SHORT).show()
            }
            }
        })
        tv.setOnClickListener(object :View.OnClickListener {
            override fun onClick(view: View) {
                startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
            }
        })
}}
