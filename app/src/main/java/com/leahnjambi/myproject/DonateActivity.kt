package com.leahnjambi.myproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DonateActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Cost>
    private lateinit var foodAdapter: CostAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)
        recyclerView= findViewById(R.id.ryclVwDn)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        foodList = ArrayList()

        foodList.add(Cost(R.drawable.don1, "Pizza", "3269"))
        foodList.add(Cost(R.drawable.don2, "Burger", "1200"))
        foodList.add(Cost(R.drawable.don3, "Hotdog", "1400"))
        foodList.add(Cost(R.drawable.don4, "Drink","250"))
        foodList.add(Cost(R.drawable.don5, "Donut","540"))
        foodList.add(Cost(R.drawable.don6, "Pepperoni Pizza","1860"))
        foodList.add(Cost(R.drawable.don7, " Cheese Burger","750"))
        foodList.add(Cost(R.drawable.don8, "Vegetable Pizza","1900"))
        foodList.add(Cost(R.drawable.don10, "Donut","540"))
        foodList.add(Cost(R.drawable.brownbutter, "Pepperoni Pizza","1860"))
        foodList.add(Cost(R.drawable.chocolateFilled, " Cheese Burger","750"))
        foodList.add(Cost(R.drawable.jellydon, "Vegetable Pizza","1900"))


        foodAdapter = CostAdapter(foodList)
        recyclerView.adapter = foodAdapter


    }
}