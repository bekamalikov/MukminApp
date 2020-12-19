package com.kg.malikov.mukminapp.ui.fragments.compass

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView

open class Compass : SensorEventListener {
    private val mGravity = FloatArray(3)
    private val mGeomagnetic = FloatArray(3)
    private var azimuth = 0f
    private var currectAzimuth = 0f
    private val compassFragment = CompassFragment()
    var image: ImageView? = null


    override fun onSensorChanged(sensorEvent: SensorEvent) {
        val alpha = 0.97f
        synchronized(this) {
            if (sensorEvent.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                mGravity[0] = alpha * mGravity[0] + (1 - alpha) * sensorEvent.values[0]
                mGravity[1] = alpha * mGravity[1] + (1 - alpha) * sensorEvent.values[1]
                mGravity[2] = alpha * mGravity[2] + (1 - alpha) * sensorEvent.values[2]
            }
            if (sensorEvent.sensor.type == Sensor.TYPE_MAGNETIC_FIELD) {
                mGeomagnetic[0] =
                    alpha * mGeomagnetic[0] + (1 - alpha) * sensorEvent.values[0]
                mGeomagnetic[1] =
                    alpha * mGeomagnetic[1] + (1 - alpha) * sensorEvent.values[1]
                mGeomagnetic[2] =
                    alpha * mGeomagnetic[2] + (1 - alpha) * sensorEvent.values[2]
            }
            val R = FloatArray(9)
            val I = FloatArray(9)
            val success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic)
            if (success) {
                val orientation = FloatArray(3)
                SensorManager.getOrientation(R, orientation)
                azimuth = Math.toDegrees(orientation[0].toDouble()).toFloat()
                azimuth = (azimuth + 360) % 360
                //
                val anim: Animation = RotateAnimation(
                    -currectAzimuth,
                    -azimuth,
                    Animation.RELATIVE_TO_SELF,
                    0.5f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f
                )
                currectAzimuth = azimuth
                anim.duration = 500
                anim.repeatCount = 0
                anim.fillAfter = true
                image?.startAnimation(anim)
            }
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

}