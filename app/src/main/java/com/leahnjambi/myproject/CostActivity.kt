package com.leahnjambi.myproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.leahnjambi.myproject.databinding.ActivityCostBinding

//import com.google.firebase.ktx.Firebase
//import com.google.firebase.storage.StorageReference
//import com.google.firebase.storage.ktx.storage

//class CostActivity : AppCompatActivity() {
//    private lateinit var recyclerView:RecyclerView
//    private lateinit var foodList: ArrayList<Cost>
//    private lateinit var foodAdapter: CostAdapter
//
//    // Add these lines to initialize Firebase Storage and create a reference to the image you want to download
//    private lateinit var storageRef: StorageReference
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_cost)
//
//        // Initialize Firebase Storage
//        val storage = Firebase.storage
//        storageRef = storage.reference
//
//        recyclerView= findViewById(R.id.costRyclVw)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        foodList = ArrayList()
//
//        foodList.add(Cost(R.drawable.cat_1, "Pizza", "3269"))
//        foodList.add(Cost(R.drawable.cat_2, "Burger", "1200"))
//        foodList.add(Cost(R.drawable.cat_3, "Hotdog", "1400"))
//        foodList.add(Cost(R.drawable.cat_4, "Drink", "250"))
//        foodList.add(Cost(R.drawable.cat_5, "Donut", "540"))
//        foodList.add(Cost(R.drawable.pop_1, "Pepperoni Pizza", "1860"))
//        foodList.add(Cost(R.drawable.pop_2, "Cheese Burger", "750"))
//        foodList.add(Cost(R.drawable.pop_3, "Vegetable Pizza", "1900"))
//
//        foodAdapter = CostAdapter(foodList)
//        recyclerView.adapter = foodAdapter
//
//        // Add this line to download images using Glide and show them in the RecyclerView
//        foodAdapter.setImageDownloadListener(object : CostAdapter.ImageDownloadListener {
//            override fun onImageDownloaded(position: Int) {
//                val imageRef = storageRef.child("images/image.jpg")
//                Glide.with(this@CostActivity /* context */)
//                    .load(imageRef)
//                    .into(foodAdapter.getImageView(position))
//            }
//        })
//
//        foodAdapter.setOnItemClickListener(object : CostAdapter.onItemClickListener{
//            override fun onItemClick(Position: Int) {
//                val intent = Intent(this@CostActivity,ShowDetailsActivity:: class.java)
//                intent.putExtra("heading",foodList[Position].name)
//                intent.putExtra("imageid",foodList[Position].image)
//                intent.putExtra("cost",foodList[Position].number)
//                startActivity(intent)
//            }
//
//        })
//
//    }
//}

class CostActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var foodList: ArrayList<Cost>
    private lateinit var foodAdapter: CostAdapter
    private lateinit var databaseReference:DatabaseReference
    private lateinit var binding:ActivityCostBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cost)
        recyclerView= findViewById(R.id.costRyclVw)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = ArrayList()
        databaseReference =FirebaseDatabase.getInstance().getReference("Food Image")
        databaseReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (dataSnapShot in snapshot.children){
                        val  image = dataSnapShot.getValue(Cost::class.java)
                        foodList.add(image!!)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@CostActivity,error.toString(),Toast.LENGTH_SHORT).show()
            }
        })

        foodList.add(Cost(R.drawable.cat_1, "Pizza", "3269"))
        foodList.add(Cost(R.drawable.cat_2, "Burger", "1200"))
        foodList.add(Cost(R.drawable.cat_3, "Hotdog", "1400"))
        foodList.add(Cost(R.drawable.cat_4, "Drink", "250"))
        foodList.add(Cost(R.drawable.cat_5, "Donut", "540"))
        foodList.add(Cost(R.drawable.pop_1, "Pepperoni Pizza", "1860"))
        foodList.add(Cost(R.drawable.pop_2, "Cheese Burger", "750"))
        foodList.add(Cost(R.drawable.pop_3, "Vegetable Pizza", "1900"))


        foodAdapter = CostAdapter(foodList,this@CostActivity)
        recyclerView.adapter = foodAdapter
        foodAdapter.setOnItemClickListener(object : CostAdapter.onItemClickListener{
            override fun onItemClick(Position: Int) {
                val intent = Intent(this@CostActivity,ShowDetailsActivity:: class.java)
                intent.putExtra("heading",foodList[Position].name)
                intent.putExtra("imageid",foodList[Position].image)
                intent.putExtra("cost",foodList[Position].number)
                startActivity(intent)
            }
        })
    }
}
