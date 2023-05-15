package com.leahnjambi.myproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
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
    private lateinit var cost: TextView
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
        cost = findViewById(R.id.txtVwHm3)
        val bundle : Bundle? = intent.extras
        val name = bundle!!.getString("heading")
        val image = bundle!!.getInt("imageid")
        val number = bundle!!.getString("cost").toString().toDouble()

        titleTxt.text = name
        cost.text = number.toString()
        pizza.setImageResource(image)

        numberOrderVal = numberOrder.text.toString().toDouble().toInt();
        minus.setOnClickListener {
            if(numberOrderVal == 1){
                Toast.makeText( this, "Quantity cannot be less than 1.", Toast.LENGTH_SHORT).show()
            } else {
                numberOrderVal--;
                displayTotals(number);
            }
        }
        plus.setOnClickListener {
            numberOrderVal++;
            displayTotals(number);
        }
        addToCart.setOnClickListener {
//            val itisha = Intent(this,SignActivity::class.java)
//            startActivity(itisha)
            val uri = Uri.parse("smsto:+254795549871")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "NEW ORDER\n" +
                    "Item name: $name\n" +
                    "$name quantity: $numberOrderVal\n"+
                    "Total price: "+(number * numberOrderVal))
            startActivity(intent)
        }
    }

    private fun displayTotals(unit: Double) {
        val numberOrder = findViewById<View>(R.id.numberOrderText) as TextView
        cost.text = (unit * numberOrderVal).toString()
        numberOrder.text = numberOrderVal.toString()
    }

}