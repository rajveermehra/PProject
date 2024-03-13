package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)

        // Get the data passed from the previous activity
        val cakeName = intent.getStringExtra("cakeName")
        val cakeDescription = intent.getStringExtra("cakeDescription")
        val photoUrl = intent.getStringExtra("photo")

        // Find the views in the layout
        val nameTextView: TextView = findViewById(R.id.name)
        val descriptionTextView: TextView = findViewById(R.id.description)
        val cakeImageView: ImageView = findViewById(R.id.imageView)
        val backButton: Button = findViewById(R.id.backButton)
        val checkoutButton: Button = findViewById(R.id.checkoutButton)
        // Set the data to the views
        nameTextView.text = cakeName
        descriptionTextView.text = cakeDescription
        Glide.with(this).load(photoUrl).into(cakeImageView)

        backButton.setOnClickListener {
            // Navigate back to the ProductActivity
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
            finish()
        }


        checkoutButton.setOnClickListener {

            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }
}
