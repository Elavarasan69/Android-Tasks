package com.robosoft.multiview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class ListAdapter(
    context: Activity,
    private val linearLayout: View,
    private val playerList: ArrayList<Cricket>
) :
    ArrayAdapter<Cricket>(context, R.layout.text_view, playerList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (playerList[position].type == "image") {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.image_view, parent, false)
        } else {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.text_view, parent, false)
        }

        val playerNameHolder: TextView = view.findViewById(R.id.title_tv)
        val playerDesignationHolder: TextView = view.findViewById(R.id.description_tv)
        val playerImageHolder: ShapeableImageView? = view.findViewById(R.id.profile_iv)
        val deletePlayer: ImageButton = view.findViewById(R.id.delete_ib)

        playerNameHolder.text = playerList[position].playerName
        playerDesignationHolder.text = playerList[position].playerDesignation
        playerImageHolder?.let {
            Picasso.get().load(playerList[position].playerImage).into(it)
        }
        view.setOnClickListener {
            Snackbar.make(linearLayout, playerList[position].playerName, Snackbar.LENGTH_LONG).show()
        }
        deletePlayer.setOnClickListener{
                val builder = AlertDialog.Builder(it.context)
                builder.setTitle("Alert")
                builder.setMessage("Are you sure you want to delete")
                builder.setPositiveButton("Yes") { _, _ ->
                    playerList.removeAt(position)
                    notifyDataSetChanged()
                }
                builder.setNegativeButton("No") { dialogInterface, _ ->
                    dialogInterface.cancel()
                }
                builder.show()
            }
        return view
        }
    }
