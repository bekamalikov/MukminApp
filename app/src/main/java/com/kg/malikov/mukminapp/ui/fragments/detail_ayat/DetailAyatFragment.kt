package com.kg.malikov.mukminapp.ui.fragments.detail_ayat

import android.content.Context
import android.os.Build
import com.kg.malikov.mukminapp.base.BaseChangeFragment
import com.kg.malikov.mukminapp.databinding.DetailAyatFragmentBinding
import com.kg.malikov.mukminapp.interfaces.OnFragmentInteractionListener
import com.kg.malikov.mukminapp.ui.fragments.detail_ayat.adapter.DetailSuraAdapter
import com.kg.malikov.mukminapp.utils.SURA_POSITION_KYE
import org.koin.android.viewmodel.ext.android.viewModel

class DetailAyatFragment : BaseChangeFragment<DetailAyatFragmentBinding>() {
    private val viewModel: DetailAyatViewModel by viewModel()
    lateinit var adapter: DetailSuraAdapter
    private var listener: OnFragmentInteractionListener? = null


    override fun initRecView() {
        adapter = DetailSuraAdapter(mutableListOf())
        binding.recViewDetailSura.adapter = adapter
    }

    //observer and filling adapter
    override fun observer() {
        val pos = arguments?.getInt(SURA_POSITION_KYE)
        viewModel.fetchSuraFromQuran(pos.toString())
        viewModel.listTimes.observeForever {
            adapter.addItems(it)
        }
    }

    //fun for hide when scroll recView
    override fun scrollRecView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.recViewDetailSura.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
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

}