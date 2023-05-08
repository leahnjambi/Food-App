package com.leahnjambi.myproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeopleAdapter(private val peopleList: ArrayList<People>)
    : RecyclerView.Adapter<PeopleAdapter.FoodViewHolder>(){

    var onItemClick : ((People) -> Unit)? = null
    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView1)
        val textView : TextView = itemView.findViewById(R.id.textView1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.activity_people, parent, false))

    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val people = peopleList[position]
        holder.imageView.setImageResource(people.image)
        holder.textView.text = people.name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(people)

        }

    }
}
