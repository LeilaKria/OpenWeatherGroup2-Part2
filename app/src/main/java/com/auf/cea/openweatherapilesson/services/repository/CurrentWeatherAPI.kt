package com.auf.cea.openweatherapilesson.services.repository

import com.auf.cea.openweatherapilesson.models.currentapi.CurrentWeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherAPI {
    @GET("/data/2.5/weather")
    suspend fun getCurrent(
        @Query("q") q : String,
        @Query("appid") apiID : String,
        @Query("units") units: String
    ): Response <CurrentWeatherModel>
}