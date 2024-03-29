package com.auf.cea.openweatherapilesson.models.currentweather

import java.io.Serializable

data class CurrentModel(
    var base: String,
    var clouds: Clouds,
    var cod: Int,
    var coord: Coord,
    var dt: Int,
    var id: Int,
    var main: Main,
    var name: String,
    var sys: Sys,
    var timezone: Int,
    var visibility: Int,
    var weather: List<Weather>,
    var wind: Wind
): Serializable