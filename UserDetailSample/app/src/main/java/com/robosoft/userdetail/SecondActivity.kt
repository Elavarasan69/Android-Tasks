package com.robosoft.userdetail

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent = intent
        val fname = intent.getStringExtra("firstname")
        val userfname = findViewById<TextView>(R.id.user_first_name_tv)
        userfname.text = fname
        val mname = intent.getStringExtra("middlename")
        val usermname = findViewById<TextView>(R.id.user_middle_name_tv)
        usermname.text = mname
        val lname = intent.getStringExtra("lastname")
        val userlname = findViewById<TextView>(R.id.user_last_name_tv)
        userlname.text = lname
        val gender = intent.getStringExtra("gender")
        val usergender = findViewById<TextView>(R.id.user_gender_tv)
        usergender.text = gender
        val age = intent.getStringExtra("age")
        val userage = findViewById<TextView>(R.id.user_age_tv)
        userage.text = age
        val graduationvalue = intent.getStringExtra("degree")
        val usergraduationvalue = findViewById<TextView>(R.id.user_graduation_tv)
        usergraduationvalue.text = graduationvalue
        val phone = intent.getStringExtra("phone")
        val userphone = findViewById<TextView>(R.id.user_phone_tv)
        userphone.text = phone
        val email = intent.getStringExtra("email")
        val useremail = findViewById<TextView>(R.id.user_email_tv)
        useremail.text = email
        val state = intent.getStringExtra("state")
        val userstate = findViewById<TextView>(R.id.user_state_tv)
        userstate.text = state
        val mark = intent.getStringExtra("mark")
        val usermark = findViewById<TextView>(R.id.user_mark_tv)
        usermark.text = mark
        val willingness = intent.getStringExtra("willing")
        val userwillingness = findViewById<TextView>(R.id.user_willingness_tv)
        userwillingness.text = willingness
        val year = intent.getStringExtra("year")
        val useryear= findViewById<TextView>(R.id.user_year_tv)
        useryear.text = year
    }
}