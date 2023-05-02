package com.leahnjambi.myproject


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class IntroActivity : AppCompatActivity() {
    private lateinit var startButton : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
         startButton =findViewById(R.id.starBtn)
        startButton.setOnClickListener {
            val bai = Intent(this,MainActivity::class.java)
            startActivity(bai)
        }
    }
}