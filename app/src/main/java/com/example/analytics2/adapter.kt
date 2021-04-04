package com.example.analytics2

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*

class adapter (var activity: Activity, var data: MutableList<item>):
    RecyclerView.Adapter<adapter.myViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapter.myViewHolder {
        val root = LayoutInflater.from(activity).inflate(R.layout.item, parent, false)
        return myViewHolder(root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: adapter.myViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.information.text = data[position].information

        Glide.with(activity).
        load(Uri.parse(data[position].image)).
        into(holder.image)
    }

    class myViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        val name = root.itemName
        val information = root.itemInformation
        val image = root.itemImage
    }
}