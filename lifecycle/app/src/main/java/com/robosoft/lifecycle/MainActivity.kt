package com.robosoft.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val MSG = "Activity1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)
        val first = findViewById<Button>(R.id.first_bn)
        first.setOnClickListener {
            val button1 = Intent(this, Activity2::class.java)
            startActivity(button1)
            Log.d(MSG, "OnCreate")
            var txt = findViewById<TextView>(R.id.Activity1_tv)
            txt.text = getString(R.string.create)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(MSG, "OnStart")
        val txt = findViewById<TextView>(R.id.Activity1_tv)
        txt.text = getString(R.string.start)
    }

    override fun onResume() {
        super.onResume()
        Log.d(MSG, "OnResume")
        val txt = findViewById<TextView>(R.id.Activity1_tv)
        txt.text = getString(R.string.resume)
    }

    override fun onPause() {
        super.onPause()
        Log.d(MSG, "OnPause")
        val txt = findViewById<TextView>(R.id.Activity1_tv)
        txt.text = getString(R.string.pause)
    }

    override fun onStop() {
        super.onStop()
        Log.d(MSG, "OnStop")
        val txt = findViewById<TextView>(R.id.Activity1_tv)
        txt.text = getString(R.string.stop)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MSG, "OnDestroy")
        val txt = findViewById<TextView>(R.id.Activity1_tv)
        txt.text = getString(R.string.destroy)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(MSG, "OnRestart")
        val txt = findViewById<TextView>(R.id.Activity1_tv)
        txt.text = getString(R.string.restart)
    }
}