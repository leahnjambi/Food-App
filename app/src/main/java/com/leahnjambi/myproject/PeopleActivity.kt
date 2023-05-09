package com.leahnjambi.myproject

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PeopleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)
        val people = intent.getParcelableExtra<People>("people")
        if (people !=null){
            val textView : TextView = findViewById(R.id.textView)
            val imageView : ImageView = findViewById(R.id.imageView)

            textView.text = people.name
            imageView.setImageResource(people.image)



        }
    }
}