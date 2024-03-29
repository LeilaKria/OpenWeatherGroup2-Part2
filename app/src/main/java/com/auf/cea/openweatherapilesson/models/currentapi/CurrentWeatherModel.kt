package com.auf.cea.openweatherapilesson.models.currentapi

data class CurrentWeatherModel(
    var base: String,
    var clouds: Clouds,
    var cod: Int,
    var coord: Coord,
    var dt: Long,
    var id: Int,
    var main: Main,
    var name: String,
    var sys: Sys,
    var timezone: Int,
    var visibility: Int,
    var weather: List<Weather>,
    var wind: Wind
)