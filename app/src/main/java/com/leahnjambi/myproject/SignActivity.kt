package com.leahnjambi.myproject

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignActivity : AppCompatActivity() {
    lateinit var EnterName : EditText
    lateinit var EnterNumber :EditText
    lateinit var EnterEmail :EditText
    lateinit var  EnterPassword :EditText
    lateinit var Sign :Button
    lateinit var progressDialog:ProgressDialog
    lateinit var mAuth :FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        EnterName = findViewById(R.id.edtName)
        EnterNumber = findViewById(R.id.edtPhone)
        EnterEmail = findViewById(R.id.edtEmail)
        EnterPassword = findViewById(R.id.edtPassword)
        Sign= findViewById(R.id.btnSign)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Saving")
        progressDialog.setMessage("Please Wait...")
        mAuth = FirebaseAuth.getInstance()

        // Set on ClickListener to all the Edit Text and the Button
        Sign.setOnClickListener {
            var name = EnterName.text.toString().trim()
            var phoneNumber = EnterNumber.text.toString().trim()
            var email = EnterEmail.text.toString().trim()
            var password = EnterPassword.text.toString().trim()
            if (name.isEmpty()|| email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()){
                message("Empty Fields!!!!","Please fill the input")

            }else{
                progressDialog.show()
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    progressDialog.dismiss()
                    if (it.isSuccessful){
                        Toast.makeText(this,"Sign in successfully",
                            Toast.LENGTH_LONG).show()
                        mAuth.signOut()
                        finish()
                    }else{
                        message("Sign in failed,Try Again",it.exception!!.message.toString())
                    }
                }
            }
        }
    }
    fun message(title:String, message: String){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Close",null)
        alertDialog.create().show()
    }
    fun clear(){
        EnterName.setText("")
        EnterEmail.setText("")
    }
}