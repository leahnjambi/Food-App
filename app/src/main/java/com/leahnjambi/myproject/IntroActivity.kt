package com.leahnjambi.myproject

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class IntroActivity : AppCompatActivity() {
    lateinit var startButton : ConstraintLayout
    lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
         startButton =findViewById(R.id.starBtn)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("loading")
        progressDialog.setMessage("Please Wait...")
        startButton.setOnClickListener {
            var bai = Intent(this,MainActivity::class.java)
            startActivity(bai)
        }
    }
}