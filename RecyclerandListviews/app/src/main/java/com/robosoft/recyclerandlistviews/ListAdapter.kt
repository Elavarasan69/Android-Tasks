package com.robosoft.recyclerandlistviews

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.Snackbar

class ListAdapter(
    private val context: Activity,
    private val linearLayout: View,
    private val empList: ArrayList<Employee>
) :
    ArrayAdapter<Employee>(context, R.layout.card_view_design, empList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        val view = LayoutInflater.from(context).inflate(R.layout.card_view_design, parent, false)

        val empImageHolder: ShapeableImageView = view.findViewById(R.id.profile_iv)
        val empNameHolder: TextView = view.findViewById(R.id.emp_name_tv)
        val empDesignationHolder: TextView = view.findViewById(R.id.emp_designation_tv)

        empImageHolder.setImageResource(empList[position].empImage)
        empNameHolder.text = empList[position].empName
        empDesignationHolder.text = empList[position].empDesignation
        view.setOnClickListener {
            Snackbar.make(linearLayout, empList[position].empName, Snackbar.LENGTH_LONG).show()
        }
        return view
    }

}
