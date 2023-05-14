package com.leahnjambi.myproject

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
   private lateinit var recycler:RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var popularAdapter: PopularAdapter
    private lateinit var cost :TextView
    private lateinit var itemCost:TextView
    private lateinit var delivery:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        recycler = findViewById(R.id.cartRecyclerView)
        cost = findViewById(R.id.costTax)
        itemCost = findViewById(R.id.txtvwCost)
        delivery = findViewById(R.id.costDelivery)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this)
        foodList = ArrayList()

        foodList.add(Food(R.drawable.pop_1, "Pepperoni Pizza"))
        foodList.add(Food(R.drawable.pop_2, " Cheese Burger"))
        foodList.add(Food(R.drawable.pop_3, "Vegetable Pizza"))


        popularAdapter = PopularAdapter(foodList)
        recycler.adapter = popularAdapter

        }


    }
