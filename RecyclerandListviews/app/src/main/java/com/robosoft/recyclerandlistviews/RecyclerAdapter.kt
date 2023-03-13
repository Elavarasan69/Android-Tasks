package com.robosoft.recyclerandlistviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter(private val linearLayout: View, private val empList: ArrayList<Employee>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = empList[position]

        holder.empImageHolder.setImageResource(itemsViewModel.empImage)
        holder.empNameHolder.text = itemsViewModel.empName
        holder.empDesignationHolder.text = itemsViewModel.empDesignation
        holder.itemView.setOnClickListener {
            Snackbar.make(linearLayout, itemsViewModel.empName, Snackbar.LENGTH_LONG).show()
        }

    }

    override fun getItemCount(): Int {
        return empList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val empImageHolder: ShapeableImageView = itemView.findViewById(R.id.profile_iv)
        val empNameHolder: TextView = itemView.findViewById(R.id.emp_name_tv)
        val empDesignationHolder: TextView = itemView.findViewById(R.id.emp_designation_tv)
    }
}
