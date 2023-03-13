package com.robosoft.drawablesample

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View.TEXT_ALIGNMENT_CENTER
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DrawableActivity2 : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fpage)
        val back = findViewById<Button>(R.id.back_bn)
        back.setOnClickListener {
            onBackPressed()
        }
        back.text = getString(R.string.Go_back)
        back.setTextColor(Color.WHITE)
        val txt = findViewById<TextView>(R.id.welcome2_tv)
        txt.text = getString(R.string.Captain_america_movie_list)
        txt.textSize = 25f
        txt.textAlignment = TEXT_ALIGNMENT_CENTER
        txt.setTextColor(Color.BLACK)
        val captainamerica1 = findViewById<ImageView>(R.id.img4_iv)
        captainamerica1.setImageResource(R.drawable.captain_america_1)
        val captainamerica2 = findViewById<ImageView>(R.id.img5_iv)
        captainamerica2.setImageResource(R.drawable.captain_america_2)
        val captainamerica3 = findViewById<ImageView>(R.id.img6_iv)
        captainamerica3.setImageResource(R.drawable.captain_america_3)
        val captainamericashield = findViewById<ImageView>(R.id.img7_iv)
        captainamericashield.setImageResource(R.drawable.ic_captain_america_s_shield)
    }
}