package com.auf.cea.openweatherapilesson

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.auf.cea.openweatherapilesson.constants.API_KEY
import com.auf.cea.openweatherapilesson.constants.CITY_NAME
import com.auf.cea.openweatherapilesson.databinding.ActivitySearchLocationBinding
import com.auf.cea.openweatherapilesson.models.currentapi.CurrentWeatherModel
import com.auf.cea.openweatherapilesson.services.helper.RetrofitHelper
import com.auf.cea.openweatherapilesson.services.repository.CurrentWeatherAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*


class SearchLocation : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySearchLocationBinding
    private lateinit var currentWeather : CurrentWeatherModel
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(CITY_NAME, Context.MODE_PRIVATE)

        binding.btnSearch.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when(p0!!.id) {
            (R.id.btn_search) -> {

                val cityName = binding.edtLocation.text.toString()
                if (cityName.isEmpty()) {
                    binding.edtLocation.error = "Required"
                    return
                } else {
                    binding.txtLoc.text = binding.edtLocation.text.toString()
                    Log.d(SearchLocation::class.java.simpleName,cityName)
                    getCurrentWeather(cityName)
                }

                val editor = sharedPreferences.edit()
                editor.putString(CITY_NAME, binding.txtLoc.text.toString())
                editor.apply()
            }
        }
    }

    private fun getCurrentWeather(cityName: String) {
        val currentAPI = RetrofitHelper.getInstance().create(CurrentWeatherAPI::class.java)
        Log.e(SearchLocation::class.java.simpleName,cityName)
        GlobalScope.launch(Dispatchers.IO) {
            val result = currentAPI.getCurrent(cityName, API_KEY,"metric")
            val data = result.body()

            if (data != null) {
                currentWeather = data
                withContext(Dispatchers.Main){
                    binding.txtTimezone.text = String.format("GMT+%s", currentWeather.timezone / 3600)
                    binding.txtTime.text = getTime(currentWeather.dt)
                    binding.txtDate.text = getDate(currentWeather.dt)
                    binding.txtCurrentFeelsLike.text = String.format("\uD83C\uDF21\n%s°C", currentWeather.main.feels_like)
                    binding.txtCurrentHumidity.text = String.format(" \uD83D\uDCA7\n%s%%", currentWeather.main.humidity)
                    binding.txtCurrentPressure.text = String.format(" \uD83D\uDCA8\n%s hPa", currentWeather.main.pressure)
                    binding.txtCurrentWindSpeed.text = String.format("%s m/s", currentWeather.wind.speed)
                    binding.txtCurrentTemp.text = String.format("%s°C", currentWeather.main.temp)
                    binding.txtMinMax.text = String.format("Min: %s°C | Max: %s°C", currentWeather.main.temp_min, currentWeather.main.temp_max)
                    binding.txtSunrise.text = getTime(currentWeather.sys.sunrise) // get time
                    binding.txtSunset.text = getTime(currentWeather.sys.sunset) // gettime

                }
            } else {
                Log.e(SearchLocation::class.java.simpleName,result.toString())
            }
        }
    }
    private fun getTime(timeStamp: Long): String{
        return SimpleDateFormat("hh:mm aa", Locale.ENGLISH).format(timeStamp * 1000)
    }

    private fun getDate(timeStamp: Long): String{
        return SimpleDateFormat("MMMM dd ,yyyy", Locale.ENGLISH).format(timeStamp * 1000)
    }
}




