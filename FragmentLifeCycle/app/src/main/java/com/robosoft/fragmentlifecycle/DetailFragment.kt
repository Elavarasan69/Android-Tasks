package com.robosoft.fragmentlifecycle

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_fragment, container, false)
        var displayName = arguments?.getString("productName")
        "Product Name: $displayName".also {
            view.findViewById<TextView>(R.id.product_name_tv).text = it
        }
        var displayID = arguments?.getInt("productID")
        "Product ID: $displayID".also { view.findViewById<TextView>(R.id.product_id_tv).text = it }
        var displayAuthority = arguments?.getBoolean("authority")
        "Authorized Product or Not: $displayAuthority".also {
            view.findViewById<TextView>(R.id.authority_tv).text = it
        }
        var displayQuantity = arguments?.getInt("quantity")
        "Product Quantity: $displayQuantity".also {
            view.findViewById<TextView>(R.id.quantity_tv).text = it
        }
        var displayPrice = arguments?.getDouble("price")
        "Product Price: $displayPrice".also { view.findViewById<TextView>(R.id.price_tv).text = it }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(ContentValues.TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(ContentValues.TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(ContentValues.TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ContentValues.TAG, "onResume")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(ContentValues.TAG, "onViewStateRestored")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ContentValues.TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ContentValues.TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(ContentValues.TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ContentValues.TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(ContentValues.TAG, "onDetach")
    }
}