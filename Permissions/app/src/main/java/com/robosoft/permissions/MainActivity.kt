package com.robosoft.permissions

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    private lateinit var mobileData: ImageView
    private lateinit var checkNetworkConnection: CheckNetworkConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val accessBtn = findViewById<Button>(R.id.permission_bn)
        accessBtn.setOnClickListener {
            requestPermission()
        }
        mobileData = findViewById(R.id.internet_iv)
        callNetworkConnection()
    }

    private fun callNetworkConnection() {
        checkNetworkConnection = CheckNetworkConnection(application)
        checkNetworkConnection.observe(this) { isConnected ->
            if (isConnected) {
                mobileData.setImageResource(R.drawable.ic_mobile_data_on)
            } else {
                mobileData.setImageResource(R.drawable.ic_mobile_data_off)
            }
        }
    }

    private fun locationAccess() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun contactAccess() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.READ_CONTACTS
    ) == PackageManager.PERMISSION_GRANTED

    private fun requestPermission() {

        var permissionToRequest = mutableListOf<String>()
        if (!contactAccess()) {
            permissionToRequest.add(Manifest.permission.READ_CONTACTS)
        } else Toast.makeText(this, "Permission Already Granted", Toast.LENGTH_SHORT).show()
        if (!locationAccess()) {
            permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        } else Toast.makeText(this, "Permission Already Granted", Toast.LENGTH_SHORT).show()
        if (permissionToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionToRequest.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PermissionRequest", "${permissions[i]} granted.")
                }
            }
        }
    }
}