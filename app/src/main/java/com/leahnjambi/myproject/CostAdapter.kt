package com.leahnjambi.myproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CostAdapter(private val foodList: ArrayList<Cost>)
    : RecyclerView.Adapter<CostAdapter.FoodViewHolder>(){

    var onItemClick : ((Cost) -> Unit)? = null
    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imgVwHm)
        val textView1 : TextView = itemView.findViewById(R.id.txtVwHome)
        val textView2 : TextView = itemView.findViewById(R.id.txtVwHm3)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.activity_home, parent, false))

    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.imageView.setImageResource(food.image)
        holder.textView1.text = food.name
        holder.textView2.text = food.number

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(food)

        }

    }
}
