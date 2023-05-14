package com.leahnjambi.myproject

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class SignActivity : AppCompatActivity() {
    lateinit var EnterName : EditText
    lateinit var EnterNumber :EditText
    lateinit var EnterLocation :EditText
    lateinit var Sign :Button
    lateinit var progressDialog:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        EnterName = findViewById(R.id.edtName)
        EnterNumber = findViewById(R.id.edtPhone)
        EnterLocation = findViewById(R.id.edtPost)
        Sign= findViewById(R.id.btnSign)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Saving")
        progressDialog.setMessage("Please Wait...")

        // Set on ClickListener to all the Edit Text and the Button
        Sign.setOnClickListener {
            var name = EnterName.text.toString().trim()
            var phoneNumber = EnterNumber.text.toString().trim()
            var location = EnterLocation.text.toString().trim()
            var id = System.currentTimeMillis().toString()
            if (name.isEmpty()){
                EnterName.setError("Please Enter you full names")
                EnterName.requestFocus()
            }else if (phoneNumber.isEmpty()){
                EnterNumber.setError("Please Enter Your Phone Number")
                EnterNumber.requestFocus()

            }else if (location.isEmpty()){
                EnterLocation.setError("Please Enter The location For Your delivery ")
                EnterLocation.requestFocus()
            }else{
                //Proceed to save
                //Prepare the user to be saved
                var user = User(name, phoneNumber, location,id)
                //Create a reference in the firebase database
                var ref = FirebaseDatabase.getInstance().
                getReference().child("User/"+id)
                //Show the program to start saving
                progressDialog.show()
                ref.setValue(user).addOnCompleteListener{
                    //Dismiss the program and check  if the task is successfull
                        task->
                    progressDialog.dismiss()
                    if (task.isSuccessful){
                        Toast.makeText(this,"Sign in successfully",
                            Toast.LENGTH_LONG).show()

                    }else{
                        Toast.makeText(this,"Sign in failed,Try Again",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}