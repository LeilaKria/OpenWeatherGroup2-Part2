package com.auf.cea.openweatherapilesson.models.currentweather

import java.io.Serializable

data class Sys(
    var country: String,
    var id: Int,
    var sunrise: Int,
    var sunset: Int,
    var type: Int
): Serializable