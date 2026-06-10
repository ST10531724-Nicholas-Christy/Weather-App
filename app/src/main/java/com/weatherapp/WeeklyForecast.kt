package com.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WeeklyForecast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weekly_forecast)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etDay = findViewById<EditText>(R.id.etDay)
        val etWeather = findViewById<EditText>(R.id.etWeather)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnMin = findViewById<Button>(R.id.btnMin)
        val btnMax = findViewById<Button>(R.id.btnMax)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnLeave = findViewById<Button>(R.id.btnLeave)
        val btnContinue =findViewById<Button>(R.id.btnContinue)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnSum = findViewById<Button>(R.id.btnSum)
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)

        //temperature dataset: two weeks of morning/evening readings(°C)//
        val temp = arrayOf(12, 25, 15, 29, 24, 30, 16, 31, 11, 29, 10, 18, 10, 16)

        //clear button empties both input fields and output field//
        btnClear.setOnClickListener {
            etDay.text.clear()
            etWeather.text.clear()
            tvResult.text = ""
        }
        //continue button: navigate to the third screen//
        btnContinue.setOnClickListener {
            val screen = Intent(this, WeatherForecast2::class.java)
            startActivity(screen)
        }
        //leave button returns to the welcome screen//
        btnLeave.setOnClickListener {
            val screen = Intent(this, MainActivity::class.java)
            startActivity(screen)
        }
        //Display button lists all the temperatures one per line
        btnDisplay. setOnClickListener {
            var output = "All temperatures (°C): "
            var counter = 0

            //Walk through the array with a while loop (same style as the original)//
            while (counter < temp.size) {
                output += "\n${temp[counter]}°C"
                counter++
            }
            tvResult.text = output
        }
        //min button: find the lowest temperature in the array//
        btnMin.setOnClickListener {
            var min = temp[0]      //start with the assumption that the first element is the minimum//
            var pos = 0

            while (pos < temp.size) {
                if (temp[pos] < min) {
                    min = temp[pos]
                }
                pos++
            }
            tvResult.text = "The minimum temperature is $min°C"
        }
        //Max button: find the highest temperature in the array//
        btnMax.setOnClickListener {
            var max = temp[0]     //start with the assupmtion that the first element is the maximum//
            var pos = 0

            while (pos < temp.size) {
                if (temp[pos] > max) {
                    max = temp[pos]
                }
                pos++
            }
            tvResult.text = "The maximum temperature is $max°C"
        }
        //sum button: add all temperature together//
        btnSum.setOnClickListener {
            var total = 0

            //for loop over the array(same style as the original)//
            for (t in temp) {
                total += t
            }
            tvResult.text = "The sum of all temperatures is $total°C"
        }
        //average button: calculate the mean temperature//
        btnAverage.setOnClickListener {
            var total = 0

            for (t in temp) {
                total += t
            }
            //integer division gives a whole number average//
            val avg = total/temp.size
            tvResult.text = "The average temperature is $avg°C"
        }
    }
}