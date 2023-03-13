package com.robosoft.recyclerandlistviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, RecyclerFragment(),null).addToBackStack(null).commit()
        val listView = findViewById<Button>(R.id.list_bt)
        listView.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, ListFragment(),null).addToBackStack(null).commit()
        }
        val recycleView = findViewById<Button>(R.id.recycler_bt)
        recycleView.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, RecyclerFragment(),null).addToBackStack(null).commit()
        }
    }
}