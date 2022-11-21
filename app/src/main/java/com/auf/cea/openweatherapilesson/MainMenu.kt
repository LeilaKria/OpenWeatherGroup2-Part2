package com.auf.cea.openweatherapilesson

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.auf.cea.openweatherapilesson.databinding.ActivityMainMenuBinding

class MainMenu : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearchLoc.setOnClickListener(this)
        binding.btnWeatherForecast.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btn_search_loc -> {
                val intent = Intent(intent.SearchLocation::class.java)
                startActivity(intent)
            }
            R.id.btn_weather_forecast -> {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

