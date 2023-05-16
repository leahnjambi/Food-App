package com.leahnjambi.myproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CostAdapter(
    private val foodList: ArrayList<Cost>,
    private val  context : Context
         )
    : RecyclerView.Adapter<CostAdapter.FoodViewHolder>(){
    private lateinit var mListener:onItemClickListener
    interface onItemClickListener{
        fun onItemClick(Cost:Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener

    }

    class FoodViewHolder(itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imgVwHm)
        val textView1 : TextView = itemView.findViewById(R.id.txtVwHome)
        val textView2 : TextView = itemView.findViewById(R.id.txtVwHm3)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {

        return FoodViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.activity_home, parent, false),mListener)


    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        Glide.with(context).load(foodList[position].image).into(holder.imageView)
        val food = foodList[position]
        holder.imageView.setImageResource(food.image)
        holder.textView1.text = food.name
        holder.textView2.text = food.number




    }


}

