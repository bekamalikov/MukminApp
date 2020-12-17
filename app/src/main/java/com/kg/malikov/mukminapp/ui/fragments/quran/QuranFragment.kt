package com.kg.malikov.mukminapp.ui.fragments.quran

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kg.malikov.mukminapp.R

class QuranFragment : Fragment() {

    companion object {
        fun newInstance() = QuranFragment()
    }

    private lateinit var viewModel: QuranViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quran_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuranViewModel::class.java)
        // TODO: Use the ViewModel
    }

}