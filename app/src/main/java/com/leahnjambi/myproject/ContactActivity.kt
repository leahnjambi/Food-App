package com.leahnjambi.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class ContactActivity : AppCompatActivity() {
    lateinit var myContact :ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        myContact = findViewById(R.id.myContact)
        myContact.setOnItemClickListener { adapterView, view, i, l ->
            val name = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(this,name, Toast.LENGTH_LONG).show()
        }
    }
}