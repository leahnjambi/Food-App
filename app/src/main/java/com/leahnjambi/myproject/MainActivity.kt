package com.leahnjambi.myproject


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerView2:RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: CatergoryAdapter
    private lateinit var popularAdapter: PopularAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView1= findViewById(R.id.rVw1)
        recyclerView1.setHasFixedSize(true)
        recyclerView1.layoutManager = LinearLayoutManager(this)
        recyclerView1.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true))

        foodList = ArrayList()

        foodList.add(Food(R.drawable.cat_1, "Pizza"))
        foodList.add(Food(R.drawable.cat_2, "Burger"))
        foodList.add(Food(R.drawable.cat_3, "Hotdog"))
        foodList.add(Food(R.drawable.cat_4, "Drink"))
        foodList.add(Food(R.drawable.cat_5, "Donut"))


        foodAdapter = CatergoryAdapter(foodList)
        recyclerView1.adapter = foodAdapter
        foodAdapter.onItemClick = {
            val intent = Intent(this,CatergoryActivity::class.java)
            intent.putExtra("food", it)
            startActivity(intent)


        }
        recyclerView2 = findViewById(R.id.rVw2)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true))

        foodList = ArrayList()

        foodList.add(Food(R.drawable.pop_1, "Pepperoni Pizza"))
        foodList.add(Food(R.drawable.pop_2, " Cheese Burger"))
        foodList.add(Food(R.drawable.pop_3, "Vegetable Pizza"))


        popularAdapter = PopularAdapter(foodList)
        recyclerView2.adapter = popularAdapter
        popularAdapter.onItemClick = {
            val intent = Intent(this,PopularActivity::class.java)
            intent.putExtra("food", it)
            startActivity(intent)


        }
    }
}