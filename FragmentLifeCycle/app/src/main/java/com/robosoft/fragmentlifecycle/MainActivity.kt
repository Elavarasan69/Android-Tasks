package com.robosoft.fragmentlifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Communication {
    private val bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val launcherFragment = LauncherFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, launcherFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun transferData() {
        val transaction = this.supportFragmentManager.beginTransaction()
        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle
        transaction.replace(R.id.fragment_container, detailFragment).commit()
    }

    override fun passName(editTextData: String) {
        bundle.putString("productName", editTextData)
        transferData()
    }

    override fun passID(editTextData: Int) {
        bundle.putInt("productID", editTextData)
        transferData()
    }

    override fun passAuthority(editTextData: Boolean) {
        bundle.putBoolean("authority", editTextData)
        transferData()
    }

    override fun passQuantity(editTextData: Int) {
        bundle.putInt("quantity", editTextData)
        transferData()
    }

    override fun passPrice(editTextData: Double) {
        bundle.putDouble("price", editTextData)
        transferData()
    }
}