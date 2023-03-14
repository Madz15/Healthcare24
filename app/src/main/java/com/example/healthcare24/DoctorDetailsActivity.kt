package com.example.healthcare24

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DoctorDetailsActivity : AppCompatActivity() {

    private val doctorDetails1 = arrayOf(
        arrayOf("Doctor Name: Mad Lawani", "Hospital Address: Newham", "Exp: 20yrs", "Mobile No: 08563050693", "500"),
            arrayOf("Doctor Name: Jen Lopez", "Hospital Address: Chelsea", "Exp: 10yrs", "Mobile No: 12330506953", "300"),
            arrayOf("Doctor Name: Poly Bill", "Hospital Address: Essex", "Exp: 5yrs", "Mobile No: 555630506932", "5500"),
            arrayOf("Doctor Name: Kyle Matthew", "Hospital Address: Victoria", "Exp: 35yrs", "Mobile No: 55863050693", "900"),
            arrayOf("Doctor Name: Kris Lapid", "Hospital Address: Pimlico", "Exp: 40yrs", "Mobile No: 08545050693", "300")
    )
    private val doctorDetails2 = arrayOf(
        arrayOf("Doctor Name: Clayton Burnett", "Hospital Address: Newham", "Exp: 20yrs", "Mobile No: 08563050693", "560"),
        arrayOf("Doctor Name: Maximillian Price", "Hospital Address: Chelsea", "Exp: 10yrs", "Mobile No: 12330506953", "450"),
        arrayOf("Doctor Name: Reid Fleming", "Hospital Address: Essex", "Exp: 5yrs", "Mobile No: 555630506932", "300"),
        arrayOf("Doctor Name: Steve Kemp", "Hospital Address: Victoria", "Exp: 35yrs", "Mobile No: 55863050693", "506"),
        arrayOf("Doctor Name: Ellie Kelley", "Hospital Address: Pimlico", "Exp: 40yrs", "Mobile No: 08545050693", "550")
    )
    private val doctorDetails3 = arrayOf(
        arrayOf("Doctor Name: Myla Humphrey", "Hospital Address: Newham", "Exp: 20yrs", "Mobile No: 08563050693", "850"),
        arrayOf("Doctor Name: Adrian Hines", "Hospital Address: Chelsea", "Exp: 10yrs", "Mobile No: 12330506953", "540"),
        arrayOf("Doctor Name: Gary Gray", "Hospital Address: Essex", "Exp: 5yrs", "Mobile No: 555630506932", "700"),
        arrayOf("Doctor Name: Kristin Bridges", "Hospital Address: Victoria", "Exp: 35yrs", "Mobile No: 55863050693", "800"),
        arrayOf("Doctor Name: Noemi Lin", "Hospital Address: Pimlico", "Exp: 40yrs", "Mobile No: 08545050693", "150")
    )
    private val doctorDetails4 = arrayOf(
        arrayOf("Doctor Name: Celia Oconnell", "Hospital Address: Newham", "Exp: 20yrs", "Mobile No: 08563050693", "500"),
        arrayOf("Doctor Name: Tessa Tyler", "Hospital Address: Chelsea", "Exp: 10yrs", "Mobile No: 12330506953", "800"),
        arrayOf("Doctor Name: Belen Branch", "Hospital Address: Essex", "Exp: 5yrs", "Mobile No: 555630506932", "600"),
        arrayOf("Doctor Name: Angie Dyer", "Hospital Address: Victoria", "Exp: 35yrs", "Mobile No: 55863050693", "230"),
        arrayOf("Doctor Name: Vanessa Dickerson", "Hospital Address: Pimlico", "Exp: 40yrs", "Mobile No: 08545050693", "800")
    )

    private val doctorDetails5 = arrayOf(
        arrayOf("Doctor Name: Allyson Mckee", "Hospital Address: Newham", "Exp: 20yrs", "Mobile No: 08563050693", "580"),
        arrayOf("Doctor Name: Kimora Phelps", "Hospital Address: Chelsea", "Exp: 10yrs", "Mobile No: 12330506953", "550"),
        arrayOf("Doctor Name: Alyssa Richardson", "Hospital Address: Essex", "Exp: 5yrs", "Mobile No: 555630506932", "540"),
        arrayOf("Doctor Name: Cordell Petty", "Hospital Address: Victoria", "Exp: 35yrs", "Mobile No: 55863050693", "400"),
        arrayOf("Doctor Name: Eduardo Nunez", "Hospital Address: Pimlico", "Exp: 40yrs", "Mobile No: 08545050693", "600")
    )

    private lateinit var tv: TextView
    private lateinit var btn: Button
    private var doctorDetails: Array<Array<String>> = emptyArray()
    private var item: HashMap<String, String> = hashMapOf()
    private var list: ArrayList<HashMap<String, String>> = arrayListOf()
    private var sa: SimpleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctors_details)

        tv = findViewById(R.id.textViewDDTitle)
        btn = findViewById(R.id.buttonDDBack)

        val title = intent.getStringExtra("title")
        tv.text = title

        when (title){

          "Family Physician" -> doctorDetails = doctorDetails1
            "Dietician" -> doctorDetails = doctorDetails2
               "Dentist" -> doctorDetails = doctorDetails3
                   "Surgeon"-> doctorDetails = doctorDetails4
                         "Cardiologists" -> doctorDetails = doctorDetails5
        }

        for(i in doctorDetails.indices) {
            item = hashMapOf()
            item["line1"] = doctorDetails[i][0]
            item["line2"] = doctorDetails[i][1]
            item["line3"] = doctorDetails[i][2]
            item["line4"] = doctorDetails[i][3]
            item["line5"] = "Cons Fees: ${doctorDetails[i][4]}£"
            list.add(item);
        }
        sa = SimpleAdapter(this, list, R.layout.multi_lines,
            arrayOf("line1", "line2","line3", "line4", "line5"),
            intArrayOf(R.id.line_a,R.id.line_b, R.id.line_c, R.id.line_d,R.id.line_e)
        )
        findViewById<ListView>(R.id.listViewDD).adapter = sa

        btn.setOnClickListener {
            val intent = Intent(this@DoctorDetailsActivity, FindDoctorActivity::class.java)
            startActivity(intent)
        }
    }}
