package com.auf.cea.openweatherapilesson.models.currentapi

data class Main(
    var feels_like: Double,
    var humidity: Int,
    var pressure: Int,
    var temp: Double,
    var temp_max: Double,
    var temp_min: Double
)