package com.example.weatherapp

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.viewmodels.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherRep.observe(this, { weather ->
            binding.apply {
                mainTvCurrentTemp.text = weather.temperature
                mainTvCurrentDescription.text = weather.description
                mainTvCurrentWind.text = weather.wind

                mainDays.visibility = View.VISIBLE
                mainPb.visibility = View.GONE

                val forecast1 = weather.forecast[0]
                val forecast2 = weather.forecast[1]
                val forecast3 = weather.forecast[2]

                mainTvForecast1.text = "${forecast1.temperature}/ ${forecast1.wind}"
                mainTvForecast2.text = "${forecast2.temperature}/ ${forecast2.wind}"
                mainTvForecast3.text = "${forecast3.temperature}/ ${forecast3.wind}"
            }
        })
    }
}