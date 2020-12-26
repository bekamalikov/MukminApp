package com.kg.malikov.mukminapp.ui.fragments.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kg.malikov.mukminapp.R
import com.kg.malikov.mukminapp.databinding.MainFragmentBinding
import com.kg.malikov.mukminapp.models.namaztime.Datum
import com.kg.malikov.mukminapp.utils.showToast
import org.koin.android.viewmodel.ext.android.viewModel


class MainFragment : Fragment(R.layout.main_fragment) {
    private val viewModel: MainViewModel by viewModel()
    private var binding: MainFragmentBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        observer()
        viewModel.listTimes.observeForever {
            filingRecViewValue(it)
        }

    }

    //fill rec view value
    private fun filingRecViewValue(it: Datum?) {
        binding?.itemTvBagymdatTime?.text = it?.timings?.fajr
        binding?.itemTvSunrisTime?.text = it?.timings?.sunrise
        binding?.itemTvPeshimTime?.text = it?.timings?.dhuhr
        binding?.itemTvAsrTime?.text = it?.timings?.asr
        binding?.itemTvMagribTime?.text = it?.timings?.maghrib
        binding?.itemTvIshaTime?.text = it?.timings?.isha
        binding?.itemTvDate?.text = it?.date?.gregorian?.date
    }

    private fun observer() {
        viewModel.fetchTime()
        viewModel.errorMessage.observeForever {
            showToast(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}