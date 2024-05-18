package com.example.clima

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clima.databinding.ActivityMainBinding
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    //declaracion
    private lateinit var  binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Inicializando
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.button.setOnClickListener{
            var ciudad:String = binding.TextboxCiudad.getText().toString().toLowerCase()

            Fuel.get("https://api.openweathermap.org/data/2.5/weather?q=${ciudad}&lang=es&units=metric&appid=c511a3599c18d3340d1923a2d37cc40a")
                .response { request, response, result ->
                    var JsonBody = response.body().asString("application/json")
                    val gson = Gson()
                   val clima = gson.fromJson(JsonBody,WeatherResponse::class.java)
                    binding.TextHello.text =  "Clima en ${clima.name}"
                    binding.TextTem.text = "${clima.main.temp} °C"
                    binding.TextDescrip.text = clima.weather[0].description
                    binding.TextDateAndTime.text = "${getCurrentTime()}"
                    binding.TextSensacion.text = "Sensacion termica ${clima.main.feels_like}"


                }
        }


    }
    private fun getCurrentTime(): String {
        val calendar = Calendar.getInstance()
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return formatter.format(calendar.time)
    }
}