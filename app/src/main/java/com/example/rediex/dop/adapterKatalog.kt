package com.example.rediex.dop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rediex.R

class adapterKatalog(val item : List<katalogClass>, val context: Context):RecyclerView.Adapter<adapterKatalog.MyVH>() {
    class MyVH(val view : View): RecyclerView.ViewHolder(view){
        val image : ImageView = view.findViewById(R.id.image_item)
        val title : TextView = view.findViewById(R.id.title_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.item_katalog, parent, false)
        return MyVH(root)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.image.setImageResource(item[position].photo)
        holder.title.setText(item[position].title)
    }
}