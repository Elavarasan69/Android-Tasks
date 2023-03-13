package com.robosoft.multiview


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val linearLayout: View, private val playerList: ArrayList<Cricket>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        context = parent.context
        if (playerList[viewType].type == "image") {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.image_view, parent, false)
        } else {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.text_view, parent, false)
        }
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = playerList[position]


        holder.playerNameHolder.text = itemsViewModel.playerName
        holder.playerDesignationHolder.text = itemsViewModel.playerDesignation
        holder.playerImageHolder?.let {
            Picasso.get().load(itemsViewModel.playerImage).into(it)
        }
        holder.itemView.setOnClickListener {
            Snackbar.make(linearLayout, itemsViewModel.playerName, Snackbar.LENGTH_LONG).show()
        }
        holder.deletePlayer.setOnClickListener {
           val builder = AlertDialog.Builder(it.context)
            builder.setTitle("Alert")
                builder.setMessage("Are you sure you want to delete")
                builder.setPositiveButton("Yes") { _, _ ->
                    playerList.removeAt(position)
                    notifyItemRemoved(position)
                }
                builder.setNegativeButton("No") { dialogInterface, _ ->
                    dialogInterface.cancel()
                }
            builder.show()
        }

    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerImageHolder: ShapeableImageView? = itemView.findViewById(R.id.profile_iv)
        val playerNameHolder: TextView = itemView.findViewById(R.id.title_tv)
        val playerDesignationHolder: TextView = itemView.findViewById(R.id.description_tv)
        val deletePlayer: ImageButton = itemView.findViewById(R.id.delete_ib)
    }
}
