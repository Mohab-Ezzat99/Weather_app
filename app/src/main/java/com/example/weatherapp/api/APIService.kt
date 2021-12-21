package com.example.weatherapp.api

import com.example.weatherapp.models.Weather
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("weather/Egypt")
    suspend fun getWeather(): Response<Weather>
}