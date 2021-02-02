package com.kg.malikov.mukminapp.ui.fragments.namaz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kg.malikov.mukminapp.R

class NamazFragment : Fragment() {

    companion object {
        fun newInstance() = NamazFragment()
    }

    private lateinit var viewModel: NamazViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.namaz_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NamazViewModel::class.java)
        // TODO: Use the ViewModel
    }

}