package com.example.androidresttestapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidresttestapp.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.findAuthorsCard.setOnClickListener {
            Log.d("MainMenu", "Find authors clicked")

            val intent = Intent(this, FindAuthorsActivity::class.java)
            startActivity(intent)
        }
    }
}
