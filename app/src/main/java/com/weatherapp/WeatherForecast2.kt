package com.weatherapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WeatherForecast2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather_forecast2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvResults2 = findViewById<TextView>(R.id.tvResults2)

        //build and display a simple weekly forecast summary//
        //This mirrors the kind of summary the original app intended to show//
        val forecast = """
            Mon: 12°C/25°C Cloudy 
            Tue: 13°C/29°C Partly Cloudy
            Wed: 14°C/30°C Sunny
            Thu: 16°C/31°C Hot and Sunny
            Fri: 11°C/29°C Light Showers 
            Sat: 10°C/18°C Rainy
            Sun: 10°C/16°C Heavy Rain 
        """.trimIndent()
        tvResults2.text = forecast
    }
}