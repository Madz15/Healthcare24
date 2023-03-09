package com.example.healthcare24

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var edUsername: EditText
    private lateinit var edEmail: EditText
    private lateinit var edPassword: EditText
    private lateinit var edConfirm: EditText
    private lateinit var btn: Button
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edUsername = findViewById(R.id.editTextRegUsername)
        edEmail = findViewById(R.id.editTextRegEmail)
        edPassword = findViewById(R.id.editTextRegPassword)
        edConfirm = findViewById(R.id.editTextRegConfirmPassword)
        btn = findViewById(R.id.buttonRegister)
        tv = findViewById(R.id.textViewExistingUser)

        tv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
            }
        })

        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {

                val username = edUsername.text.toString()
                val email = edEmail.text.toString()
                val password = edPassword.text.toString()
                val confirm = edConfirm.text.toString()

                val db = Database(applicationContext, "Healthcare24", null, 1)



                if(username.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                    Toast.makeText(applicationContext, "Please fill all details", Toast.LENGTH_SHORT).show()
                } else {

                    if(password.compareTo(confirm)==0) {
                        if(isValid(password)) {

db.register(username,email, password)

                            Toast.makeText(applicationContext, "Record Inserted", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))

                        } else {
                            Toast.makeText(applicationContext, "Password must contain at least 8 characters, having letter, digit, and special symbol", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(applicationContext, "Password and Confirm password didn't match", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun isValid(passwordhere: String): Boolean {
        var f1 = 0
        var f2 = 0
        var f3 = 0
        if (passwordhere.length < 8) {
            return false
        } else {
            for (p in 0 until passwordhere.length) {
                if (Character.isLetter(passwordhere[p])) {
                    f1 = 1
                }
            }
            for (r in 0 until passwordhere.length) {
                if (Character.isDigit(passwordhere[r])) {
                    f2 = 1
                }
            }
            for (s in 0 until passwordhere.length) {
                val c = passwordhere[s]
                if (c >= 33.toChar() && c <= 46.toChar() || c == 64.toChar()) {
                    f3 = 1
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1) {
                return true
            }
            return false
        }
    }
}
