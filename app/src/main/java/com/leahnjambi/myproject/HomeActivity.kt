package com.leahnjambi.myproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    lateinit var minus :ImageView
    lateinit var plus :ImageView
    lateinit var numberOrder:TextView
    lateinit var orderButton: Button
    private var numberOrderVal: Int = 0;
    @SuppressLint("MissingInflatedId")
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
        numberOrder = findViewById(R.id.numberOrderText);
        numberOrderVal = numberOrder.text.toString().toInt();
        minus = findViewById(R.id.imgMinus);

        minus.setOnClickListener {
            if(numberOrderVal == 0){
                Toast.makeText( this, "Quantity cannot be less than 0.", Toast.LENGTH_SHORT).show()
            } else {
                numberOrderVal--;
                displayTotals();
            }
        }
        plus = findViewById(R.id.imgPlus)
        plus.setOnClickListener {
            numberOrderVal++;
            displayTotals();
        }
        orderButton = findViewById(R.id.addToCartBtn)
        orderButton.setOnClickListener {
            val itisha = Intent(this,SignActivity::class.java)
            startActivity(itisha)
        }

    }

    private fun displayTotals() {
        numberOrder.setText(numberOrderVal);
    }
}