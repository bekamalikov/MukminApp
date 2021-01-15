package com.kg.malikov.mukminapp.ui.fragments.quran

import android.content.Context
import android.os.Build
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.kg.malikov.mukminapp.R
import com.kg.malikov.mukminapp.base.BaseChangeFragment
import com.kg.malikov.mukminapp.databinding.QuranFragmentBinding
import com.kg.malikov.mukminapp.interfaces.IOnItemClick
import com.kg.malikov.mukminapp.interfaces.OnFragmentInteractionListener
import com.kg.malikov.mukminapp.ui.fragments.quran.adapter.QuranSuraAdapter
import com.kg.malikov.mukminapp.utils.SURA_POSITION_KYE
import com.kg.malikov.mukminapp.utils.showToast
import org.koin.android.viewmodel.ext.android.viewModel

class QuranFragment() :
    BaseChangeFragment<QuranFragmentBinding>(),
    IOnItemClick {
    private val viewModel: QuranViewModel by viewModel()
    lateinit var adapter: QuranSuraAdapter
    private var listener: OnFragmentInteractionListener? = null


    override fun scrollRecView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.recViewSuraInQuran.setOnScrollChangeListener { _, _, scrollY, oldScrollX, oldScrollY ->
                val delta = scrollY - oldScrollY
                listener?.onFragmentScrolled(delta.toFloat())
            }
        }
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
    }

    override fun onItemClick(pos: Int) {
        val bundle = bundleOf(SURA_POSITION_KYE to pos + 1)
        findNavController().navigate(R.id.detailAyatFragment, bundle)
    }

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