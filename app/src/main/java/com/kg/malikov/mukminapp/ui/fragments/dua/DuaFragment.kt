package com.kg.malikov.mukminapp.ui.fragments.dua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kg.malikov.mukminapp.R
import org.koin.android.ext.android.inject

class DuaFragment : Fragment() {


    private val viewModel by inject<DuaViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dua, container, false)
    }

}