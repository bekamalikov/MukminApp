package com.kg.malikov.mukminapp.ui.fragments.detail_dua

import com.kg.malikov.mukminapp.base.BaseFragment
import com.kg.malikov.mukminapp.databinding.DetailDuaFragmentBinding
import com.kg.malikov.mukminapp.utils.DUA_ARABIC_KEY
import com.kg.malikov.mukminapp.utils.DUA_DESC_KEY
import com.kg.malikov.mukminapp.utils.DUA_TITLE_KEY
import com.kg.malikov.mukminapp.utils.DUA_TRANSCRIPTION_KEY

class DetailDuaFragment : BaseFragment<DetailDuaFragmentBinding>() {
    private lateinit var viewModel: DetailDuaViewModel
    override fun observer() {
        val title = arguments?.get(DUA_TITLE_KEY)
        val transcription = arguments?.get(DUA_TRANSCRIPTION_KEY)
        val arabicDesc = arguments?.get(DUA_ARABIC_KEY)
        val description = arguments?.get(DUA_DESC_KEY)

        binding.duaArabicDescTv.text = arabicDesc.toString()
        binding.duaTitleTv.text = title.toString()
        binding.duaTranscriptionTv.text = transcription.toString()
        binding.duaDescTv.text = description.toString()
    }

    override fun init() {

    }


}