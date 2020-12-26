package com.kg.malikov.mukminapp.ui.fragments.detailayat

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kg.malikov.mukminapp.R
import com.kg.malikov.mukminapp.databinding.DetailAyatFragmentBinding
import com.kg.malikov.mukminapp.interfaces.OnFragmentInteractionListener
import com.kg.malikov.mukminapp.ui.fragments.detailayat.adapter.DetailSuraAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class DetailAyatFragment : Fragment(R.layout.detail_ayat_fragment) {
    private val viewModel: DetailAyatViewModel by viewModel()
    lateinit var adapter: DetailSuraAdapter
    private var binding: DetailAyatFragmentBinding? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pos = arguments?.getInt("pos")
        binding = DetailAyatFragmentBinding.bind(view)
        scrollRecView()
        observer(pos)
        initRecView()
    }

    private fun initRecView() {
        adapter = DetailSuraAdapter(mutableListOf())
        binding?.recViewDetailSura?.adapter = adapter
    }

    //observer and filling adapter
    private fun observer(pos: Int?) {
        viewModel.fetchSuraFromQuran(pos.toString())
        viewModel.listTimes.observeForever {
            adapter.addItems(it)
        }
    }

    //fun for hide when scroll recView
    private fun scrollRecView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding?.recViewDetailSura?.setOnScrollChangeListener { _, scrollX, scrollY, oldScrollX, oldScrollY ->
                val delta = scrollY - oldScrollY
                listener?.onFragmentScrolled(delta.toFloat())
            }
        }
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

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}