package com.leahnjambi.myproject

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val food = intent.getParcelableExtra<Cost>("Cost")
        if (food !=null){
            val textView1 : TextView = findViewById(R.id.txtVwHome)
            val textView2 :TextView = findViewById(R.id.txtVwHm3)
            val imageView : ImageView = findViewById(R.id.imageView)

            textView1.text = food.name
            imageView.setImageResource(food.image)
            textView2.text = food.number

        }

    }
}