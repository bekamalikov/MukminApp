package com.kg.malikov.mukminapp.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.kg.malikov.mukminapp.interfaces.IOnFragmentInteractionListener
import com.kg.malikov.mukminapp.utils.getBinding

abstract class BaseChangeFragment<V : ViewBinding> : Fragment() {
    lateinit var binding: V
    private var listener: IOnFragmentInteractionListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = getBinding()
        observer()
        initRecView()
        return binding.root
    }

    fun scrollRecView(recView: RecyclerView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            recView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
                val delta = scrollY - oldScrollY
                listener?.onFragmentScrolled(delta.toFloat())
            }
        }
    }

    abstract fun observer()
    abstract fun initRecView()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is IOnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}
