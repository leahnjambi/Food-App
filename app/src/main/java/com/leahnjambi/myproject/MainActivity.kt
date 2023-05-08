package com.leahnjambi.myproject


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerView2:RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: CatergoryAdapter
    private lateinit var popularAdapter: PopularAdapter
    private lateinit var listAdapter:ArrayAdapter<String>
    lateinit var peopleButton: LinearLayout
    lateinit var order :TextView
    lateinit var search :EditText
    lateinit var home :LinearLayout




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


        recyclerView2 = findViewById(R.id.rVw2)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true))

        foodList = ArrayList()

        foodList.add(Food(R.drawable.pop_1, "Pepperoni Pizza"))
        foodList.add(Food(R.drawable.pop_2, " Cheese Burger"))
        foodList.add(Food(R.drawable.pop_3, "Vegetable Pizza"))
        foodList.add(Food(R.drawable.recipe1, "Pepperoni Pizza"))
        foodList.add(Food(R.drawable.recipe2, " Cheese Burger"))
        foodList.add(Food(R.drawable.recipe3, "Vegetable Pizza"))
        foodList.add(Food(R.drawable.recipe4, "Pepperoni Pizza"))
        foodList.add(Food(R.drawable.recipe5, " Cheese Burger"))
        foodList.add(Food(R.drawable.recipe6, "Vegetable Pizza"))
        foodList.add(Food(R.drawable.recipe7, "Pepperoni Pizza"))
        foodList.add(Food(R.drawable.recipe8, " Cheese Burger"))
        foodList.add(Food(R.drawable.recipe9, "Vegetable Pizza"))
        foodList.add(Food(R.drawable.recipe10, "Vegetable Pizza"))



        popularAdapter = PopularAdapter(foodList)
        recyclerView2.adapter = popularAdapter


        peopleButton = findViewById(R.id.PeopleBtn)
        peopleButton.setOnClickListener {
            val watu = Intent(this,ContactActivity::class.java)
            startActivity(watu)
        }
        order = findViewById(R.id.txtVw3)
        order.setOnClickListener {
            val itisha = Intent(this,SignActivity::class.java)
            startActivity(itisha)

        }
        search = findViewById(R.id.edtText1)
        search.setOnClickListener {


        }
        home = findViewById(R.id.homeBtn)
        home.setOnClickListener {
            val pata = Intent(this,CostActivity::class.java)
            startActivity(pata)
        }


    }

}