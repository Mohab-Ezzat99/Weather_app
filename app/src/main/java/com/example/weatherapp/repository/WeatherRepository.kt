package com.example.weatherapp.repository

import com.example.weatherapp.api.APIService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(private val apiService: APIService) {

    suspend fun getWeather() = apiService.getWeather()
}