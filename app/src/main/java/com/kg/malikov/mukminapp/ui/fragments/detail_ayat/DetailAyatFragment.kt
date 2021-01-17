package com.kg.malikov.mukminapp.ui.fragments.detail_ayat

import android.os.Bundle
import android.view.View
import com.kg.malikov.mukminapp.base.BaseChangeFragment
import com.kg.malikov.mukminapp.databinding.DetailAyatFragmentBinding
import com.kg.malikov.mukminapp.interfaces.IOnFragmentInteractionListener
import com.kg.malikov.mukminapp.ui.fragments.detail_ayat.adapter.DetailSuraAdapter
import com.kg.malikov.mukminapp.utils.SURA_POSITION_KYE
import org.koin.android.viewmodel.ext.android.viewModel

class DetailAyatFragment : BaseChangeFragment<DetailAyatFragmentBinding>() {
    private val viewModel: DetailAyatViewModel by viewModel()
    lateinit var adapter: DetailSuraAdapter

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scrollRecView(binding.recViewDetailSura)
    }
}