package com.kg.malikov.mukminapp.ui.fragments.detail_hadis

import com.kg.malikov.mukminapp.base.BaseFragment
import com.kg.malikov.mukminapp.databinding.DetailHadisFragmentBinding
import com.kg.malikov.mukminapp.utils.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailHadisFragment : BaseFragment<DetailHadisFragmentBinding>() {
    private val viewModel: DetailHadisViewModel by viewModel()

    override fun init() {

    }

    override fun observer() {
        val nameHadis = arguments?.get(HADIS_NAME_KEY)
        val titleHadis = arguments?.get(HADIS_TITLE_KEY)
        val arabDescHadis = arguments?.get(HADIS_ARB_DESC_KEY)
        val descHadis = arguments?.get(HADIS_DESC_KEY)
        val numberHadis = arguments?.get(HADIS_NUMBER_KEY)
        binding.nameHadisTv.text = nameHadis.toString()
        binding.arabDescTv.text = arabDescHadis.toString()
        binding.titleTv.text = titleHadis.toString()
        binding.descHadisTv.text = descHadis.toString()
    }

}