package com.robosoft.multiview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.robosoft.multiview.Cricket
import com.robosoft.multiview.ListAdapter
import com.robosoft.multiview.R

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var listAdapter: ListAdapter
    private lateinit var listView: ListView
    private lateinit var playerArrayList: ArrayList<Cricket>

    lateinit var name: Array<String>
    lateinit var type: Array<String>
    lateinit var designation: Array<String>
    lateinit var imageId: Array<String>
    lateinit var player: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        listView = view.findViewById(R.id.list_view)
        listAdapter = activity?.let { ListAdapter(it, view, playerArrayList) }!!
        listView.adapter = listAdapter
    }
    private fun dataInitialize() {

        playerArrayList = arrayListOf()

        name = arrayOf(
            "Dhoni",
            "Ravindra Jadeja",
            "Ruturaj Gaikwad",
            "Moeen Ali",
            "Ambati Rayudu",
            "Robin Uttapa",
            "Dwayne Bravo",
            "Deepak Chahar",
            "Rajvardhan Hangargekar",
            "Tushar Deshpande"
        )

        type = arrayOf(
            "image",
            "text",
            "image",
            "text",
            "image",
            "text",
            "image",
            "text",
            "image",
            "text"
        )

        designation = arrayOf(
            "Wicket Keeper Batsman (C)",
            "All-rounder (VC)",
            "Batsman",
            "All-rounder",
            "Batsman",
            "Wicket Keeper Batsman",
            "All rounder",
            "Right arm medium",
            "Right arm medium",
            "Right arm medium fast"
        )

        imageId = arrayOf(
            "https://wallpaperaccess.com/full/1898247.jpg",
            "https://wallpaperaccess.com/full/1898247.jpg",
            "https://wallpaperaccess.com/full/1898247.jpg",
            "https://wallpaperaccess.com/full/1898247.jpg",
            "https://wallpaperaccess.com/full/1898247.jpg",
            "https://wallpaperaccess.com/full/1898247.jpg",
            "https://wallpaperaccess.com/full/1898247.jpg",
            "https://wallpaperaccess.com/full/1898247.jpg",
            "https://wallpaperaccess.com/full/1898247.jpg",
            "https://wallpaperaccess.com/full/1898247.jpg",

            )

        player = arrayOf()

        for (i in name.indices) {
            val player = Cricket(name[i],type [i],designation[i],imageId[i])
            playerArrayList.add(player)
        }

    }
}