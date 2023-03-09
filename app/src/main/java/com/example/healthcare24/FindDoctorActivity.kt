package com.example.healthcare24

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class FindDoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_doctor)

        val exit: CardView = findViewById(R.id.cardFDBack)
        exit.setOnClickListener {
            fun onClick(view: View) {
                startActivity(Intent(this@FindDoctorActivity, HomeActivity::class.java))
            }

            val findDoctor: CardView = findViewById(R.id.cardFindDoctor)
            findDoctor.setOnClickListener {
                startActivity(Intent(this@FindDoctorActivity,HomeActivity::class.java))
            }

            val familyphysician: CardView = findViewById(R.id.cardFDFamilyPhysician)
            familyphysician.setOnClickListener {
                startActivity(Intent(this@FindDoctorActivity,DoctorDetailsActivity::class.java))


                val findDoctor: CardView = findViewById(R.id.cardFindDoctor)

                findDoctor.setOnClickListener {
                    val intent = Intent(this@FindDoctorActivity,DoctorDetailsActivity::class.java)
                    intent.putExtra("title", "Family Physicians")


                   /* findDoctor.setOnClickListener(object : View.OnClickListener {
                        override fun onClick(view: View) {
                            startActivity(Intent(this@FindDoctorActivity,DoctorDetailsActivity::class.java))
                        }})*/

    }



                val dietician: CardView = findViewById(R.id.cardFDDietician)
                dietician.setOnClickListener {
                    val findDoctor: CardView = findViewById(R.id.cardFindDoctor)
                    findDoctor.setOnClickListener {
                        val intent = Intent(this@FindDoctorActivity,DoctorDetailsActivity::class.java)
                        intent.putExtra("title", "Dietician")

                        startActivity(intent)

                    }

                    val dentist: CardView = findViewById(R.id.cardFDDentist)
                    dentist.setOnClickListener {
                    val findDoctor: CardView = findViewById(R.id.cardFindDoctor)
                        findDoctor.setOnClickListener {
                            val intent =
                                Intent(this@FindDoctorActivity, DoctorDetailsActivity::class.java)
                            intent.putExtra("title", "Dentist")

                            startActivity(intent)

                        }

                        val surgeon: CardView = findViewById(R.id.cardFDSurgeon)
                        dentist.setOnClickListener {
                            val findDoctor: CardView = findViewById(R.id.cardFindDoctor)
                            findDoctor.setOnClickListener {
                                val intent =
                                    Intent(
                                        this@FindDoctorActivity,
                                        DoctorDetailsActivity::class.java
                                    )
                                intent.putExtra("title", "Surgeon")

                            }

                            val cardiologists: CardView = findViewById(R.id.cardFDCardiologists)
                            dentist.setOnClickListener {
                                val findDoctor: CardView = findViewById(R.id.cardFindDoctor)
                                findDoctor.setOnClickListener {
                                    val intent =
                                        Intent(
                                            this@FindDoctorActivity,
                                            DoctorDetailsActivity::class.java
                                        )

                                    intent.putExtra("title", "Cardiologists")

                                }}}}}}}}}

