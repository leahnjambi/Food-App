package com.leahnjambi.myproject

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShowDetailsActivity : AppCompatActivity() {
    private lateinit var addToCart: TextView
    private lateinit var titleTxt: TextView
    private lateinit var numberOrder: TextView
    private lateinit var pizza: ImageView
    private lateinit var minus: ImageView
    private lateinit var plus: ImageView
    private var numberOrderVal: Int = 0;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_details)
        addToCart = findViewById(R.id.addToCartBtn)
        titleTxt = findViewById(R.id.titleTxt)
        numberOrder = findViewById(R.id.numberOrderText)
        pizza = findViewById(R.id.imgPizza)
        minus = findViewById(R.id.imgMinus)
        plus = findViewById(R.id.imgPlus)
        val bundle : Bundle? = intent.extras
        val name = bundle!!.getString("heading")
        val  image = bundle!!.getInt("imageid")
        titleTxt.text = name
        pizza.setImageResource(image)


        numberOrder = findViewById(R.id.numberOrderText);
        numberOrderVal = numberOrder.text.toString().toInt();
        minus.setOnClickListener {
            if(numberOrderVal == 0){
                Toast.makeText( this, "Quantity cannot be less than 0.", Toast.LENGTH_SHORT).show()
            } else {
                numberOrderVal--;
                displayTotals();
            }
    }
        plus.setOnClickListener {
            numberOrderVal++;
            displayTotals();
        }
        addToCart.setOnClickListener {
            val itisha = Intent(this,SignActivity::class.java)
            startActivity(itisha)
        }
    }

    private fun displayTotals() {
        numberOrder.setText(numberOrderVal);
    }

}
