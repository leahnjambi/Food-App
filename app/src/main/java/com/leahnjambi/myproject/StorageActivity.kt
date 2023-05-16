package com.leahnjambi.myproject

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.leahnjambi.myproject.databinding.ActivityStorageBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class StorageActivity : AppCompatActivity() {
    lateinit var binding:ActivityStorageBinding
    lateinit var ImageUri:Uri
    lateinit var FoodName : EditText
    lateinit var FoodPrice : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.selectImageBtn.setOnClickListener{
            selectImage()
        }
        binding.uploadImageBtn.setOnClickListener{
            uploadImage()
        }
        FoodName = findViewById(R.id.tvName)
        FoodPrice = findViewById(R.id.tvPrice)
    }

    private fun uploadImage() {
        val progressionDialog = ProgressDialog(this)
        progressionDialog.setMessage("Uploading File...")
        progressionDialog.setCancelable(false)
        progressionDialog.show()

        val formatter = SimpleDateFormat("yyyy_MM_dd_hh_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = FoodName.text.toString() + formatter.format(now)
        val storageReference = FirebaseStorage.getInstance().getReference("Food Images/$fileName")
        storageReference.putFile(ImageUri).
        addOnCompleteListener {
            it.addOnSuccessListener {
                binding.imgFirebase.setImageURI(null)
                Toast.makeText(this@StorageActivity,"Upload Successfully",Toast.LENGTH_SHORT).show()
                if (progressionDialog.isShowing)progressionDialog.dismiss()
            }
        }.addOnFailureListener{
            Toast.makeText(this@StorageActivity,"Failed",Toast.LENGTH_SHORT).show()
            if (progressionDialog.isShowing)progressionDialog.dismiss()
        }

        val databaseReference = FirebaseDatabase.getInstance().getReference("Food Data")
        val key = databaseReference.push().key
        val foodData = FoodData(FoodName.text.toString(), FoodPrice.text.toString(), key!!)
        databaseReference.child(key).setValue(foodData)

    }

    private fun selectImage() {
        val intent = Intent()
        intent.type = "image/"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent,100)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK){
            ImageUri = data?.data!!
            Toast.makeText(this, "selected", Toast.LENGTH_SHORT).show()
            binding.imgFirebase.setImageURI(ImageUri)
        }else{
            Toast.makeText(this, "failed with code: $requestCode", Toast.LENGTH_SHORT).show()
        }
    }
}

class FoodData(foodName: String, foodPrice: String, foodKey: String) {

}


//class StorageActivity : AppCompatActivity() {
//    lateinit var binding:ActivityStorageBinding
//    lateinit var ImageUri:Uri
//    lateinit var FoodName : EditText
//    lateinit var FoodPrice : EditText
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityStorageBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.selectImageBtn.setOnClickListener{
//
//            selectImage()
//        }
//        binding.uploadImageBtn.setOnClickListener{
//            uploadImage()
//
//        }
//    }
//
//    private fun uploadImage() {
//        val progressionDialog = ProgressDialog(this)
//        progressionDialog.setMessage("Uploading File...")
//        progressionDialog.setCancelable(false)
//        progressionDialog.show()
//
//        val formatter = SimpleDateFormat("yyyy_MM_dd_hh_mm_ss", Locale.getDefault())
//        val now = Date()
//        val fileName = formatter.format(now)
//        val storageReference = FirebaseStorage.getInstance().getReference("Food Images/$fileName")
//        storageReference.putFile(ImageUri).
//                addOnCompleteListener {
//                    it.addOnSuccessListener {
//                        binding.imgFirebase.setImageURI(null)
//                        Toast.makeText(this@StorageActivity,"Upload Successfully",Toast.LENGTH_SHORT).show()
//                        if (progressionDialog.isShowing)progressionDialog.dismiss()
//                    }
//
//
//                }.addOnFailureListener{
//            Toast.makeText(this@StorageActivity,"Failed",Toast.LENGTH_SHORT).show()
//            if (progressionDialog.isShowing)progressionDialog.dismiss()
//
//        }
//
//        
//    }
//
//    private fun selectImage() {
//        val intent = Intent()
//        intent.type = "image/"
//        intent.action = Intent.ACTION_GET_CONTENT
//        startActivityForResult(intent,100)
//
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == 100 && resultCode == RESULT_OK){
//            ImageUri = data?.data!!
//            Toast.makeText(this, "selected", Toast.LENGTH_SHORT).show()
//            binding.imgFirebase.setImageURI(ImageUri)
//        }else{
//            Toast.makeText(this, "failed with code: $requestCode", Toast.LENGTH_SHORT).show()
//        }
//    }
//}