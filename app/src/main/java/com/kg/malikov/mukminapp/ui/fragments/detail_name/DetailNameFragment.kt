package com.kg.malikov.mukminapp.ui.fragments.detail_name

import com.kg.malikov.mukminapp.base.BaseFragment
import com.kg.malikov.mukminapp.databinding.DetailNameFragmentBinding
import com.kg.malikov.mukminapp.utils.GREAT_ARAB_NAME_KEY
import com.kg.malikov.mukminapp.utils.GREAT_MEANING_NAME_KEY
import com.kg.malikov.mukminapp.utils.GREAT_NAME_KEY
import com.kg.malikov.mukminapp.utils.GREAT_TRANSLATION_NAME_KEY

class DetailNameFragment : BaseFragment<DetailNameFragmentBinding>() {
    private lateinit var viewModel: DetailNameViewModel

    override fun observer() {
        val name = arguments?.get(GREAT_NAME_KEY)
        val arabName = arguments?.get(GREAT_ARAB_NAME_KEY)
        val nameTranslation = arguments?.get(GREAT_TRANSLATION_NAME_KEY)
        val meaningName = arguments?.get(GREAT_MEANING_NAME_KEY)
        binding.nameTv.text = name.toString()
        binding.arabNameTv.text = arabName.toString()
        binding.translateNameTv.text = nameTranslation.toString()
        binding.meaningNameTv.text = meaningName.toString()
    }

    override fun init() {
    }
}