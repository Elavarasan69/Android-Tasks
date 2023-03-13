package com.robosoft.userdetail

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
    AdapterView.OnItemClickListener {
    val degree = arrayOf("B.Com", "B.Sc", "B.Tech", "M.Com", "M.Sc", "M.Tech", "Ph.D")
    val state = arrayOf(
        "Andhra Pradesh",
        "Arunachal Pradesh",
        "Assam",
        "Bihar",
        "Chhattisgarh",
        "Goa",
        "Gujarat",
        "Haryana",
        "Himachal Pradesh",
        "Jammu and Kashmir",
        "Jharkhand",
        "Karnataka",
        "Kerala",
        "Madhya Pradesh",
        "Maharashtra",
        "Manipur",
        "Meghalaya",
        "Mizoram",
        "Nagaland",
        "Odisha",
        "Punjab",
        "Rajasthan",
        "Sikkim",
        "Tamil Nadu",
        "Telangana",
        "Tripura",
        "Uttarakhand",
        "Uttar Pradesh",
        "West Bengal",
        "Andaman and Nicobar Islands",
        "Chandigarh",
        "Dadra and Nagar Haveli",
        "Daman and Diu",
        "Delhi"
    )
    val year = arrayOf("2018-2019", "2019-2020", "2020-2021", "2021-2022", "2022-2023")
    var graduation = ""
    var userstate = ""
    var yearofpassing = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstName = findViewById<TextInputEditText>(R.id.first_name)
        val middleName = findViewById<TextInputEditText>(R.id.middle_name)
        val lastName = findViewById<TextInputEditText>(R.id.last_name)
        val phone = findViewById<TextInputEditText>(R.id.phone_tet)
        val email = findViewById<TextInputEditText>(R.id.email_tet)
        val age = findViewById<TextInputEditText>(R.id.age_et)
        val mark = findViewById<TextInputEditText>(R.id.mark_et)
        val submit = findViewById<Button>(R.id.submit_bn)

        submit.setOnClickListener {
            val gender =
                findViewById<RadioButton>(findViewById<RadioGroup>(R.id.radioGroup_rg).checkedRadioButtonId)
            var willing = findViewById<Switch>(R.id.willing_sw).isChecked.toString()
            willing = if (willing == "true") "Yes" else "No"
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("firstname", firstName.text.toString())
            intent.putExtra("middlename", middleName.text.toString())
            intent.putExtra("lastname", lastName.text.toString())
            intent.putExtra("gender", gender.text.toString())
            intent.putExtra("age", age.text.toString())
            intent.putExtra("degree", graduation)
            intent.putExtra("phone", phone.text.toString())
            intent.putExtra("email", email.text.toString())
            intent.putExtra("state", userstate)
            intent.putExtra("mark", mark.text.toString())
            intent.putExtra("willing", willing)
            intent.putExtra("year", yearofpassing)
            startActivity(intent)
        }
        val spinner = findViewById<Spinner>(R.id.spinner_sp)
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, degree)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = this

        val yeardropdown = findViewById<AutoCompleteTextView>(R.id.year_tv)

        val adapter = ArrayAdapter(this, R.layout.list_items, year)
        yeardropdown.setAdapter(adapter)
        yeardropdown.onItemClickListener = this

        val statedropdown = findViewById<AutoCompleteTextView>(R.id.state_tv)

        val adapter2 = ArrayAdapter(this, R.layout.list_items, state)
        statedropdown.setAdapter(adapter2)
        statedropdown.setOnItemClickListener { adapterView, view, i, l ->
            yearofpassing = state[i]
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        graduation = degree[p2]
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        userstate = year[p2]
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}

