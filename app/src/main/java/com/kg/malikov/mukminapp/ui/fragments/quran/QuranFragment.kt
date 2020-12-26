package com.kg.malikov.mukminapp.ui.fragments.quran

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kg.malikov.mukminapp.R
import com.kg.malikov.mukminapp.databinding.QuranFragmentBinding
import com.kg.malikov.mukminapp.interfaces.IOnItemClick
import com.kg.malikov.mukminapp.interfaces.OnFragmentInteractionListener
import com.kg.malikov.mukminapp.ui.fragments.quran.adapter.QuranSuraAdapter
import com.kg.malikov.mukminapp.utils.showToast
import org.koin.android.viewmodel.ext.android.viewModel

class QuranFragment() :
    Fragment(R.layout.quran_fragment),
    IOnItemClick {
    private val viewModel: QuranViewModel by viewModel()
    lateinit var adapter: QuranSuraAdapter
    private var binding: QuranFragmentBinding? = null
    private var listener: OnFragmentInteractionListener? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = QuranFragmentBinding.bind(view)
        scrollRecView()
        observer()
        initRecView()
    }

    private fun scrollRecView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding?.recViewSuraInQuran?.setOnScrollChangeListener { _, scrollX, scrollY, oldScrollX, oldScrollY ->
                val delta = scrollY - oldScrollY
                listener?.onFragmentScrolled(delta.toFloat())
            }
        }
    }

    private fun initRecView() {
        adapter = QuranSuraAdapter(mutableListOf(), this)
        binding?.recViewSuraInQuran?.adapter = adapter
    }

    private fun observer() {
        viewModel.fetchQuran()
        viewModel.listTimes.observeForever {
            adapter.addItems(it)
        }
        viewModel.errorMessage.observeForever {
            showToast(it.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    // not the key point here but important to binding listener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onItemClick(pos: Int) {
        val bundle = bundleOf("pos" to pos + 1)
        findNavController().navigate(R.id.detailAyatFragment, bundle)
    }


}