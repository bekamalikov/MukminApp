package com.kg.malikov.mukminapp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.kg.malikov.mukminapp.interfaces.OnFragmentInteractionListener
import com.kg.malikov.mukminapp.utils.getBinding

abstract class BaseChangeFragment<V : ViewBinding> : Fragment() {
    lateinit var binding: V
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = getBinding()
        scrollRecView()
        observer()
        initRecView()

        return binding.root
    }

    abstract fun scrollRecView()
    abstract fun observer()
    abstract fun initRecView()

}
