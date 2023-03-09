package com.example.healthcare24

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DoctorDetailsActivity : AppCompatActivity() {

    private lateinit var tv: TextView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctors_details)

        tv = findViewById(R.id.textViewDDTitle)
        btn = findViewById(R.id.buttonDDBack)

        val title = intent.getStringExtra("title")
        tv.text = title

        btn.setOnClickListener {
            val intent = Intent(this@DoctorDetailsActivity, FindDoctorActivity::class.java)
            startActivity(intent)
        }
    }
}
