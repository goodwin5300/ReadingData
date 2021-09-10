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

class data : AppCompatActivity(), SensorEventListener {
    private lateinit var mSensorManager : SensorManager
    private var mAccelerometer : Sensor ?= null
    private var mGravity : Sensor ?= null
    private var mGyroscope : Sensor ?= null
    private var mLinearAccl : Sensor ?= null
    private var mRotateVec : Sensor ?= null

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                findViewById<TextView>(R.id.text1).text = event.values[0].toString()
                findViewById<TextView>(R.id.text2).text = event.values[1].toString()
                findViewById<TextView>(R.id.text3).text = event.values[2].toString()
            }
            else if (event.sensor.type == Sensor.TYPE_GRAVITY) {
                findViewById<TextView>(R.id.text11).text = event.values[0].toString()
                findViewById<TextView>(R.id.text10).text = event.values[1].toString()
                findViewById<TextView>(R.id.text9).text = event.values[2].toString()
            }
            else if (event.sensor.type == Sensor.TYPE_GYROSCOPE) {
                findViewById<TextView>(R.id.text13).text = event.values[0].toString()
                findViewById<TextView>(R.id.text12).text = event.values[1].toString()
                findViewById<TextView>(R.id.text7).text = event.values[2].toString()
            }
            else if (event.sensor.type == Sensor.TYPE_LINEAR_ACCELERATION) {
                findViewById<TextView>(R.id.text6).text = event.values[0].toString()
                findViewById<TextView>(R.id.text5).text = event.values[1].toString()
                findViewById<TextView>(R.id.text4).text = event.values[2].toString()
            }
            else if (event.sensor.type == Sensor.TYPE_ROTATION_VECTOR) {
                findViewById<TextView>(R.id.text19).text = event.values[0].toString()
                findViewById<TextView>(R.id.text18).text = event.values[1].toString()
                findViewById<TextView>(R.id.text17).text = event.values[2].toString()
                findViewById<TextView>(R.id.textView29).text = event.values[3].toString()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)


        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mGravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        mLinearAccl = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)
        mRotateVec = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)

    }

    override fun onResume() {
        super.onResume()
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mGravity, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mLinearAccl, SensorManager.SENSOR_DELAY_NORMAL)
        mSensorManager.registerListener(this, mRotateVec, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        mSensorManager.unregisterListener(this)
    }
}