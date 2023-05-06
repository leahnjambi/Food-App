package com.leahnjambi.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.widget.ImageView
import android.widget.TextView

class ShowDetailsActivity : AppCompatActivity() {
    private lateinit var addToCart: TextView
    private lateinit var titleTxt: TextView
    private lateinit var price: TextView
    private lateinit var numberOrder: TextView
    private lateinit var pizza: ImageView
    private lateinit var minus: ImageView
    private lateinit var plus: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_details)
        addToCart = findViewById(R.id.addToCartBtn)
        titleTxt = findViewById(R.id.titleTxt)
        price = findViewById(R.id.priceTxt)
        numberOrder = findViewById(R.id.numberOrderText)
        pizza = findViewById(R.id.imgPizza)
        minus = findViewById(R.id.imgMinus)
        plus = findViewById(R.id.imgPlus)


        plus.setOnClickListener {
            val firstNumber = numberOrder.text.toString().trim()
            val secondNumber:Int =1
            var jibu = firstNumber.toDouble() + secondNumber
            numberOrder.text = jibu.toString()

        }
        minus.setOnClickListener {
            var firstNumber = numberOrder.text.toString().trim()
            var secondNumber:Int =1
            var jibu = firstNumber.toDouble() - secondNumber.toDouble()
            numberOrder.text = jibu.toString()

        }
    }
}