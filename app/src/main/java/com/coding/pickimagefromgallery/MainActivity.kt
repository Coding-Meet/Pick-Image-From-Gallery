package com.coding.pickimagefromgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var galleryImg : ImageView
    private lateinit var pickImageFormGalleryBtn : Button


    private val imageContract = registerForActivityResult(ActivityResultContracts.GetContent()){
        galleryImg.setImageURI(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        galleryImg = findViewById(R.id.galleryImg)
        pickImageFormGalleryBtn = findViewById(R.id.pickImageGalleryBtn)

        pickImageFormGalleryBtn.setOnClickListener {
            imageContract.launch("image/*")
        }
    }
}