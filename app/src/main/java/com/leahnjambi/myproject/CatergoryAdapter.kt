package com.leahnjambi.myproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatergoryAdapter(private val foodList: ArrayList<Food>)
    : RecyclerView.Adapter<CatergoryAdapter.FoodViewHolder>(){

    var onItemClick : ((Food) -> Unit)? = null
    class FoodViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imgCat)
        val textView1 : TextView = itemView.findViewById(R.id.txtCat)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.activity_catergory, parent, false))

    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.imageView.setImageResource(food.image)
        holder.textView1.text = food.name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(food)

        }

    }
}