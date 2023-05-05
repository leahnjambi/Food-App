package com.leahnjambi.myproject

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class OrderActivity : AppCompatActivity() {
   private lateinit var buttonSms :Button
    private lateinit var buttonCall : Button
    private lateinit var buttonEmail : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        buttonSms = findViewById(R.id.btnSms)
        buttonCall = findViewById(R.id.btnCall)
        buttonEmail = findViewById(R.id.btnEmail)

        // Set on ClickListener To all the Buttons
        buttonCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0795549871"))
            if (ContextCompat.checkSelfPermission(
                    this@OrderActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@OrderActivity,
                    arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        buttonEmail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "njambileah07@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "FOOD ORDERING AND FREE DELIVERY")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Leah,following the recent....")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
        buttonSms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0795549871")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello there")
            startActivity(intent)

        }
    }
}