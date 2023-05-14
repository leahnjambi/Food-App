package com.leahnjambi.myproject

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PopularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular)
        val food = intent.getParcelableExtra<Food>("food")
        if (food !=null){
            val textView : TextView = findViewById(R.id.textView)
            val imageView : ImageView = findViewById(R.id.imageView)

            textView.text = food.name
            imageView.setImageResource(food.image)

        }

    }
}