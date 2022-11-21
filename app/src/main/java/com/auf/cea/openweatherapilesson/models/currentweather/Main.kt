package com.auf.cea.openweatherapilesson.models.currentweather

import java.io.Serializable

data class Main(
    var feels_like: Double,
    var humidity: Int,
    var pressure: Int,
    var temp: Double,
    var temp_max: Double,
    var temp_min: Double
): Serializable