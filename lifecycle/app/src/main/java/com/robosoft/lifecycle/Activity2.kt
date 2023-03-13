package com.robosoft.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {
    private val MSG = "Activity2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val second = findViewById<Button>(R.id.second_bn)
        second.setOnClickListener {
            val button2 = Intent(this, MainActivity::class.java)
            startActivity(button2)
            Log.d(MSG, "OnCreate")
            val txt = findViewById<TextView>(R.id.Activity2_tv)
            txt.text = getString(R.string.create)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(MSG, "OnStart")
        val txt = findViewById<TextView>(R.id.Activity2_tv)
        txt.text = getString(R.string.start)
    }

    override fun onResume() {
        super.onResume()
        Log.d(MSG, "OnResume")
        val txt = findViewById<TextView>(R.id.Activity2_tv)
        txt.text = getString(R.string.resume)
    }

    override fun onPause() {
        super.onPause()
        Log.d(MSG, "OnPause")
        val txt = findViewById<TextView>(R.id.Activity2_tv)
        txt.text = getString(R.string.pause)
    }

    override fun onStop() {
        super.onStop()
        Log.d(MSG, "OnStop")
        val txt = findViewById<TextView>(R.id.Activity2_tv)
        txt.text = getString(R.string.stop)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MSG, "OnDestroy")
        val txt = findViewById<TextView>(R.id.Activity2_tv)
        txt.text = getString(R.string.destroy)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(MSG, "OnRestart")
        val txt = findViewById<TextView>(R.id.Activity2_tv)
        txt.text = getString(R.string.restart)
    }
}