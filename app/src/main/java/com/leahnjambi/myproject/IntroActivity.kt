package com.leahnjambi.myproject

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class IntroActivity : AppCompatActivity() {
    lateinit var startButton : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
         startButton =findViewById(R.id.starBtn)
        startButton.setOnClickListener {
            var bai = Intent(this,MainActivity::class.java)
            startActivity(bai)
        }
    }
}