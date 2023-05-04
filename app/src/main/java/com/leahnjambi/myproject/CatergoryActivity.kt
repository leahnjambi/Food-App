package com.leahnjambi.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CatergoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catergory)
        val food = intent.getParcelableExtra<Food>("food")
        if (food !=null){
            val textView : TextView = findViewById(R.id.fee)
            val imageView : ImageView = findViewById(R.id.imageView)

            textView.text = food.name
            imageView.setImageResource(food.image)


        }

    }
}