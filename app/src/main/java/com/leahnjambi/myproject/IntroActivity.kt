package com.leahnjambi.myproject


import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.auth.FirebaseAuth

class IntroActivity : AppCompatActivity() {
    private lateinit var startButton : ConstraintLayout
    lateinit var mAuth :FirebaseAuth
    lateinit var progressDialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
         startButton =findViewById(R.id.starBtn)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait...")
        mAuth = FirebaseAuth.getInstance()
        // Set on click listeners buttons
        startButton.setOnClickListener {
            val bai = Intent(this,MainActivity::class.java)
            startActivity(bai)
        }
    }
}