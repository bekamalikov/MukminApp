package com.kg.malikov.mukminapp.ui.fragments.name

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kg.malikov.mukminapp.R

class NameFragment : Fragment() {

    companion object {
        fun newInstance() = NameFragment()
    }

    private lateinit var viewModel: NameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.name_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NameViewModel::class.java)
        // TODO: Use the ViewModel
    }
}