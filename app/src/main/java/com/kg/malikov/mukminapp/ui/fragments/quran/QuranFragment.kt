package com.kg.malikov.mukminapp.ui.fragments.quran

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.kg.malikov.mukminapp.R
import com.kg.malikov.mukminapp.base.BaseChangeFragment
import com.kg.malikov.mukminapp.databinding.QuranFragmentBinding
import com.kg.malikov.mukminapp.interfaces.IOnItemClick
import com.kg.malikov.mukminapp.interfaces.IOnFragmentInteractionListener
import com.kg.malikov.mukminapp.ui.fragments.quran.adapter.QuranSuraAdapter
import com.kg.malikov.mukminapp.utils.SURA_POSITION_KYE
import com.kg.malikov.mukminapp.utils.gone
import com.kg.malikov.mukminapp.utils.showToast
import com.kg.malikov.mukminapp.utils.visible
import org.koin.android.viewmodel.ext.android.viewModel

class QuranFragment() :
    BaseChangeFragment<QuranFragmentBinding>(),
    IOnItemClick {
    private val viewModel: QuranViewModel by viewModel()
    lateinit var adapter: QuranSuraAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scrollRecView(binding.recViewSuraInQuran)
    }

    override fun initRecView() {
        adapter = QuranSuraAdapter(mutableListOf(), this)
        binding.recViewSuraInQuran.adapter = adapter
    }

    override fun observer() {
        viewModel.fetchQuran()
        viewModel.listTimes.observeForever {
            adapter.addItems(it)
        }
        viewModel.errorMessage.observeForever {
            showToast(it.toString())
        }
        viewModel.isLoading.observeForever {
            if (it) binding.progressBarLoading.visible()
            else binding.progressBarLoading.gone()
        }
    }

    override fun onItemClick(pos: Int) {
        val bundle = bundleOf(SURA_POSITION_KYE to pos + 1)
        findNavController().navigate(R.id.detailAyatFragment, bundle)
    }
}