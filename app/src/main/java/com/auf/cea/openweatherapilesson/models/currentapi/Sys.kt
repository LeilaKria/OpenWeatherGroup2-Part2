package com.auf.cea.openweatherapilesson.models.currentapi

data class Sys(
    var country: String,
    var id: Int,
    var sunrise: Long,
    var sunset: Long,
    var type: Int
)