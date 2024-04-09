package com.example.rediex.dop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rediex.R

class productAdapter(var items : List<classProtucts>, val context: Context):RecyclerView.Adapter<productAdapter.MyVH>() {
    class MyVH( view: View):RecyclerView.ViewHolder(view){
        val image : ImageView = view.findViewById(R.id.image_item)
        val title : TextView = view.findViewById(R.id.title_item)
        val price : TextView = view.findViewById(R.id.price_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.item_vid, parent, false)
        return MyVH(root)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.image.setImageResource(items[position].photo)
        holder.title.setText(items[position].name)
        holder.price.setText(items[position].cost)
    }
}