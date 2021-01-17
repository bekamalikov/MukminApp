package com.kg.malikov.mukminapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.kg.malikov.mukminapp.utils.getBindingForBaseFragment


abstract class BaseFragment<V : ViewBinding> : Fragment() {
    lateinit var binding: V
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = getBindingForBaseFragment()
        init()
        observer()
        return binding.root
    }

    abstract fun observer()
    abstract fun init()
}
