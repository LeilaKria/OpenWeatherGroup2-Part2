package com.auf.cea.openweatherapilesson.models.currentapi

data class Weather(
    var description: String,
    var icon: String,
    var id: Int,
    var main: String
)