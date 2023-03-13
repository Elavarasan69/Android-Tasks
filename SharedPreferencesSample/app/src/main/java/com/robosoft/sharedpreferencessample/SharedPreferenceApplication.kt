package com.robosoft.sharedpreferencessample

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

class SharedPreferenceApplication : Application() {

    @SuppressLint("SimpleDateFormat")
    override fun onCreate() {
        super.onCreate()
        val sharedPref = getSharedPreferences("sharedPreference", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        if (sharedPref.getBoolean("isFirstLaunch", true)) {
            val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm a")
            val firstLaunchTime = simpleDateFormat.format(Calendar.getInstance().time)
            editor.putString("firstLaunchTime", firstLaunchTime)
            editor.putInt("noOfLaunches", 1)
            editor.putBoolean("isFirstLaunch", false)
            editor.apply()
        } else {
            val noOfLaunches = sharedPref.getInt("noOfLaunches", 0) + 1
            editor.putInt("noOfLaunches", noOfLaunches)
            editor.apply()
        }
    }
}