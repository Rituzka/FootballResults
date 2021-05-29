package com.devpadawan.footballresults.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devpadawan.footballresults.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCompetitors.setOnClickListener {
            val intent = Intent(this, FootballActivity::class.java)
            startActivity(intent)
        }



    }
}