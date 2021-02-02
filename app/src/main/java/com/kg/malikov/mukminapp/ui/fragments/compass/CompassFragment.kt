package com.kg.malikov.mukminapp.ui.fragments.compass


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.kg.malikov.mukminapp.R
import org.koin.android.ext.android.inject

class CompassFragment : Fragment() {
    var imageView: ImageView? = null
    private var mSensorManager: SensorManager? = null
    private lateinit var compass: Compass
    private val viewModel by inject<CompassViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.compass_fragment, container, false)

    }

    private fun init(view: View?) {
        imageView = view?.findViewById(R.id.compass)
        mSensorManager = activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        compass = Compass()
        compass.image = imageView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    override fun onResume() {
        super.onResume()
        mSensorManager?.registerListener(
            compass, mSensorManager!!.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
            SensorManager.SENSOR_DELAY_GAME
        )
        mSensorManager?.registerListener(
            compass, mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_GAME
        )
    }

    override fun onPause() {
        super.onPause()
        mSensorManager?.unregisterListener(compass)
    }


}