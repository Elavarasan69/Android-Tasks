package com.robosoft.intentsample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)
        val browser = findViewById<Button>(R.id.open_browser_bn)
        browser.setOnClickListener {
            val url = "https://www.robosoftin.com"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
        val dialpad = findViewById<Button>(R.id.open_dialpad_bn)
        dialpad.setOnClickListener {
            val url = "tel:++91-8899776688"
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(url)))
        }
        val map = findViewById<Button>(R.id.open_google_map_bn)
        map.setOnClickListener {
            val url =
                "https://www.google.co.in/maps/place/Robosoft+Technologies/@13.3770747,74.7386025,16.79z/data=!4m5!3m4!1s0x3bbcbcd3ffffffff:0xaa6468a5ada29205!8m2!3d13.3791765!4d74.7401981?hl=en"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }
}