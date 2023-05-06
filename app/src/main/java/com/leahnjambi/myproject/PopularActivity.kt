package com.leahnjambi.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PopularActivity : AppCompatActivity() {
    private lateinit var add : TextView

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
        add = findViewById(R.id.txtViewAdd)
        add.setOnClickListener {
            val ongeza = Intent(this,ShowDetailsActivity::class.java)
            startActivity(ongeza)
        }


    }
}