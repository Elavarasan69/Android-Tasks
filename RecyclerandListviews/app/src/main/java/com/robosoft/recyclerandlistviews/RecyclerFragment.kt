package com.robosoft.recyclerandlistviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerFragment : Fragment(R.layout.fragment_recycler) {

    private lateinit var adapter: RecyclerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var employeeArrayList: ArrayList<Employee>

    lateinit var imageId: Array<Int>
    lateinit var name: Array<String>
    lateinit var designation: Array<String>
    lateinit var emp: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RecyclerAdapter(
            view, employeeArrayList
        )
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {

        employeeArrayList = arrayListOf()

        imageId = arrayOf(
            R.drawable.user_icon,
            R.drawable.user_icon,
            R.drawable.user_icon,
            R.drawable.user_icon,
            R.drawable.user_icon,
            R.drawable.user_icon,
            R.drawable.user_icon,
            R.drawable.user_icon,
            R.drawable.user_icon,
            R.drawable.user_icon
        )

        name = arrayOf(
            "Steve Rogers",
            "Tony Stark",
            "Thor Odinson",
            "Bruce Banner",
            "Natasha Romanoff",
            "Clinton Barton",
            "T'Challa",
            "Wanda Maximoff",
            "Stephen Strange",
            "Peter Parker"
        )

        designation = arrayOf(
            "Captain America",
            "Iron Man",
            "Thor",
            "Hulk",
            "Black Widow",
            "Hawkeye",
            "Black Panther",
            "Scarlet Witch",
            "Doctor Strange",
            "Spider man"
        )

        emp = arrayOf()

        for (i in imageId.indices) {
            val emp = Employee(imageId[i], name[i], designation[i])
            employeeArrayList.add(emp)
        }

    }
}