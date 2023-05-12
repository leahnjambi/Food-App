package com.leahnjambi.myproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CostActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var foodList: ArrayList<Cost>
    private lateinit var foodAdapter: CostAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cost)
        recyclerView= findViewById(R.id.costRyclVw)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = ArrayList()

        foodList.add(Cost(R.drawable.cat_1, "Pizza", "3269"))
        foodList.add(Cost(R.drawable.cat_2, "Burger", "1200"))
        foodList.add(Cost(R.drawable.cat_3, "Hotdog", "1400"))
        foodList.add(Cost(R.drawable.cat_4, "Drink", "250"))
        foodList.add(Cost(R.drawable.cat_5, "Donut", "540"))
        foodList.add(Cost(R.drawable.pop_1, "Pepperoni Pizza", "1860"))
        foodList.add(Cost(R.drawable.pop_2, " Cheese Burger", "750"))
        foodList.add(Cost(R.drawable.pop_3, "Vegetable Pizza", "1900"))


        foodAdapter =CostAdapter(foodList)
        recyclerView.adapter = foodAdapter
        foodAdapter.setOnItemClickListener(object : CostAdapter.onItemClickListener{
            @SuppressLint("SuspiciousIndentation")
            override fun onItemClick(Position: Int) {
                //Toast.makeText(this@CostActivity,"You Click on.$Name",Toast.LENGTH_SHORT).show()
            val intent = Intent(this@CostActivity,ShowDetailsActivity:: class.java)
                intent.putExtra("heading",foodList[Position].name)
                intent.putExtra("imageid",foodList[Position].image)
                startActivity(intent)
            }

        })

    }

}
