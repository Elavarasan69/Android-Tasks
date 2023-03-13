package com.robosoft.fragmentlifecycle

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment


class LauncherFragment : Fragment() {
    private lateinit var communication: Communication
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.launcher_fragment, container, false)
        val submit: Button = view.findViewById(R.id.submit_bt)
        communication = activity as Communication
        submit.setOnClickListener {
            communication.passName(view.findViewById<EditText>(R.id.product_name_et).text.toString())
            communication.passID(
                view.findViewById<EditText>(R.id.product_id_et).text.toString().toInt()
            )
            communication.passAuthority(
                view.findViewById<SwitchCompat>(R.id.authorized_tb)?.isChecked == true
            )
            communication.passQuantity(
                view.findViewById<EditText>(R.id.quantity_et).text.toString().toInt()
            )
            communication.passPrice(
                view.findViewById<EditText>(R.id.price_et).text.toString().toDouble()
            )
        }
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