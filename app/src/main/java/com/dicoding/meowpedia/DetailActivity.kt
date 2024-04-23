package com.dicoding.meowpedia

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object{
        const val key_cat = "key_cat"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName : TextView = findViewById(R.id.tv_name_received)
        val tvDetailDescription : TextView = findViewById(R.id.tv_description_received)
        val ivImgReceived : ImageView = findViewById(R.id.iv_mukameng)

        val dataCat = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Cat>(key_cat, Cat::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Cat>(key_cat)
        }

        if (dataCat != null) {
            tvDetailName.text = dataCat.name
            tvDetailDescription.text = dataCat.description
            ivImgReceived.setImageResource(dataCat.photo)
        }
    }
}