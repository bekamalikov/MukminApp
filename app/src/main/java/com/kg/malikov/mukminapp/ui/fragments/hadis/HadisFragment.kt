package com.kg.malikov.mukminapp.ui.fragments.hadis

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kg.malikov.mukminapp.R

class HadisFragment : Fragment() {

    companion object {
        fun newInstance() = HadisFragment()
    }

    private lateinit var viewModel: HadisViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hadis_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HadisViewModel::class.java)
        // TODO: Use the ViewModel
    }

}