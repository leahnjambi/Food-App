package com.leahnjambi.myproject

import android.app.ProgressDialog
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import com.leahnjambi.myproject.databinding.ActivityRetrieveBinding
import java.io.File

class RetrieveActivity : AppCompatActivity() {
    lateinit var binding: ActivityRetrieveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrieveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getBtn.setOnClickListener {
            val progressDialog = ProgressDialog(this)
            progressDialog.setMessage("Fetching the image...")
            progressDialog.setCancelable(false)
            progressDialog.show()

            val imageName = binding.edtRetrieve.text.toString()
            val storageRef = FirebaseStorage.getInstance().reference.child("Food Images/$imageName.jpg")

            val localFile = File.createTempFile("tempImage", "jpg")
            storageRef.getFile(localFile).addOnSuccessListener {
                val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                binding.imgRetrieve.setImageBitmap(bitmap)
                if (progressDialog.isShowing)
                    progressDialog.dismiss()

            }.addOnFailureListener {
                Toast.makeText(this, "Failed to retrieve the Food Image", Toast.LENGTH_SHORT).show()
                if (progressDialog.isShowing)
                    progressDialog.dismiss()


            }
        }

    }
}
