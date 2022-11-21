package com.auf.cea.openweatherapilesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auf.cea.openweatherapilesson.databinding.ActivitySearchLocationBinding
import com.auf.cea.openweatherapilesson.models.ForecastModel


class SearchLocation : AppCompatActivity() {
    private lateinit var binding: ActivitySearchLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentWeather = intent.getSerializableExtra("weatherData") as ForecastModel

        val feelsLike = currentWeather.main.feels_like // Feels Like
        val humidity = currentWeather.main.humidity // Humidity
        val pressure = currentWeather.main.pressure // Pressure
        val windSpeed = currentWeather.wind.speed // Wind Speed

        val temp = currentWeather.main.temp // Temperature
        val minTemp = currentWeather.main.temp_min // Minimum Temp
        val maxTemp = currentWeather.main.temp_max // Maximum Temp

        binding.txtCurrentFeelsLike.text = String.format("\uD83C\uDF21\n%s°C", feelsLike)
        binding.txtCurrentHumidity.text = String.format(" \uD83D\uDCA7\n%s%%", humidity)
        binding.txtCurrentPressure.text = String.format(" \uD83D\uDCA8\n%shPa", pressure)
        binding.txtCurrentWindSpeed.text = String.format(" \uD83C\uDF2C\n%sm/s", windSpeed)
        binding.txtCurrentTemp.text = String.format("%s°C", temp)
        binding.txtMinMax.text = String.format("Min: %s°C | Max: %s°C", minTemp, maxTemp)


    }

}







