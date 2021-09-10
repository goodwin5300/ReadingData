package com.example.readingdata

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class environment2 : AppCompatActivity(), SensorEventListener {
    private lateinit var mSensorManager : SensorManager
    private var mAmbientTemp : Sensor ?= null
    private var mLight : Sensor ?= null
    private var mPressure : Sensor ?= null
    private var mHumidity : Sensor ?= null

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            if (event.sensor.type == Sensor.TYPE_AMBIENT_TEMPERATURE) {
                findViewById<TextView>(R.id.text1).text = event.values[0].toString()
            }
            else if (event.sensor.type == Sensor.TYPE_LIGHT) {
                findViewById<TextView>(R.id.text11).text = event.values[0].toString()
            }
            else if (event.sensor.type == Sensor.TYPE_PRESSURE) {
                findViewById<TextView>(R.id.text13).text = event.values[0].toString()
            }
            else if (event.sensor.type == Sensor.TYPE_RELATIVE_HUMIDITY) {
                findViewById<TextView>(R.id.text6).text = event.values[0].toString()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_environment2)


        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        mAmbientTemp = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)
        mHumidity = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY)

    }

    override fun onResume() {
        super.onResume()
        mSensorManager.registerListener(this, mAmbientTemp, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mHumidity, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        mSensorManager.unregisterListener(this)
    }
}