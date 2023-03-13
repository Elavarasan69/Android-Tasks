package com.robosoft.intentsample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class ExplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)
        val launch = findViewById<Button>(R.id.launch_activity_bn)
        launch.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
        val launchintent = findViewById<Button>(R.id.launch_inplicit_intent_activity_bn)
        launchintent.setOnClickListener {
            val intent2 = Intent(this, ImplicitIntentActivity::class.java)
            startActivity(intent2)
        }
    }
}