package com.example.clima

data class WeatherResponse(
    val weather: List<Weathers>,
    val base: String,
    val main: Main,
    val visibility: Int,
    val dt: Long,
    val sys: Sys,
    val name: String,
)

data class Weathers(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int,
    val sea_level: Int,
    val grnd_level: Int
)

data class Sys(
    val country: String,
    val sunrise: Long,
    val sunset: Long
)

