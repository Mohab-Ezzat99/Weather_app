package com.example.weatherapp.models

data class Weather(
    var temperature: String,
    var wind: String,
    var description: String,
    var forecast: ArrayList<Forecast>
)