package com.robosoft.sharedpreferencessample

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

class TimeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.time_detail_activity)

        val relativeLayout = findViewById<RelativeLayout>(R.id.relative_layout)
        val sharedPref = getSharedPreferences("sharedPreference", Context.MODE_PRIVATE)

        val hours = SimpleDateFormat("HH").format(Calendar.getInstance().time).toInt()
        var greeting = ""
        greeting = when (hours) {
            in 5..11 -> "Good Morning 🙂"
            in 12..15 -> "Good Afternoon 🙂"
            in 16..19 -> "Good Evening 🙂"
            else -> "Good Night 😴"
        }
        var greetingView = findViewById<TextView>(R.id.greeting_tv)
        greetingView.text = greeting


        findViewById<Button>(R.id.first_launch_time_bt).setOnClickListener {
            Snackbar.make(
                relativeLayout,
                sharedPref.getString("firstLaunchTime", "").toString(),
                Snackbar.LENGTH_INDEFINITE
            ).setAction("OK") {}
                .show()
        }
        findViewById<Button>(R.id.no_of_launch_bt).setOnClickListener {
            Snackbar.make(
                relativeLayout,
                sharedPref.getInt("noOfLaunches", 0).toString(),
                Snackbar.LENGTH_INDEFINITE
            ).setAction("OK") {}
                .show()
        }
    }
}