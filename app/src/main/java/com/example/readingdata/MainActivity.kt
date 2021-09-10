package com.example.readingdata

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        val listV = findViewById<ListView>(R.id.list)
        val motion = findViewById(R.id.data) as Button
        val position = findViewById(R.id.data2) as Button
        val environment = findViewById(R.id.data3) as Button
        val sleep = findViewById(R.id.data4) as Button

        val listItems = arrayOfNulls<String>(deviceSensors.size)
        for(i in 0 until deviceSensors.size) {
            listItems[i] = deviceSensors[i].name
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listV.adapter = adapter

        motion.setOnClickListener() {
            val intent = Intent(this, data::class.java)
            startActivity(intent)
        }

        position.setOnClickListener() {
            val intent = Intent(this, position2::class.java)
            startActivity(intent)
        }

        environment.setOnClickListener() {
            val intent = Intent(this, environment2::class.java)
            startActivity(intent)
        }

        sleep.setOnClickListener() {
            val intent = Intent(this, SleepAPI::class.java)
            startActivity(intent)
        }

    }

}