package com.leahnjambi.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var reclerView2 :
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        foodList = ArrayList()

        foodList.add(Food(R.drawable.cat_1,"Pizza"))
        foodList.add(Food(R.drawable.cat_2,"Burger"))
        foodList.add(Food(R.drawable.cat_3,"Pizza"))
        foodList.add(Food(R.drawable.cat_4,"Drink"))
        foodList.add(Food(R.drawable.cat_5,"Donut"))


        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter
        foodAdapter.onItemClick = {
            val intent = Intent(this,CatergoryActivity:: class.java)
            intent.putExtra("food",it)
            startActivity(intent)
        }





    }
}