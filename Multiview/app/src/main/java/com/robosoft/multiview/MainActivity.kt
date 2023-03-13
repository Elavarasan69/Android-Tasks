package com.robosoft.multiview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.robosoft.multiview.fragments.ListFragment
import com.robosoft.multiview.fragments.RecyclerFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_layout,RecyclerFragment(),null).addToBackStack(null).commit()
        val recyclerButton = findViewById<Button>(R.id.recycler_bt)
            recyclerButton.setOnClickListener{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_layout,RecyclerFragment(),null).addToBackStack(null).commit()
            }
        val listButton = findViewById<Button>(R.id.list_bt)
        listButton.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragment_layout,ListFragment(),null).addToBackStack(null).commit()
        }
    }
}