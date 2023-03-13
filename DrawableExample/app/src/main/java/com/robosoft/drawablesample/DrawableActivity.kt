package com.robosoft.drawablesample


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DrawableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        val fpage = findViewById<Button>(R.id.click_bn)
        fpage.setOnClickListener {
            val intent = Intent(this, DrawableActivity2::class.java)
            startActivity(intent)
        }
    }
}