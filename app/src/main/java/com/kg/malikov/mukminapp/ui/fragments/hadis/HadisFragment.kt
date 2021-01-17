package com.kg.malikov.mukminapp.ui.fragments.hadis

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.kg.malikov.mukminapp.R
import com.kg.malikov.mukminapp.base.BaseChangeFragment
import com.kg.malikov.mukminapp.databinding.HadisFragmentBinding
import com.kg.malikov.mukminapp.interfaces.IOnClickItemHadis
import com.kg.malikov.mukminapp.models.hadis.HadisModel
import com.kg.malikov.mukminapp.ui.fragments.hadis.adapter.HadisAdapter
import com.kg.malikov.mukminapp.utils.*
import org.koin.android.viewmodel.ext.android.viewModel

class HadisFragment : BaseChangeFragment<HadisFragmentBinding>(), IOnClickItemHadis {

    private val viewModel: HadisViewModel by viewModel()
    private lateinit var mRefUserListener: AppValueEventListener
    private lateinit var list: MutableList<HadisModel>
    private lateinit var adapter: HadisAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scrollRecView(binding.recViewSuraInHadis)
    }

    override fun observer() {
        list = mutableListOf()
        mRefUserListener = AppValueEventListener {
            if (it.exists()) {
                for (ds in it.children) {
                    val data = ds.getValue(HadisModel::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                    initRecView()
                }
            }
        }
        REF_DATABASE_ROOT.child(NODE_HADIS)
            .addValueEventListener(mRefUserListener)
    }

    override fun initRecView() {
        adapter = HadisAdapter(list, this)
        binding.recViewSuraInHadis.adapter = adapter
    }

    override fun onItemClick(model: HadisModel) {
        findNavController().navigate(R.id.detailHadisFragment, Bundle().also {
            it.putString(HADIS_NAME_KEY, model.nameHadis)
            it.putString(HADIS_TITLE_KEY, model.title)
            it.putString(HADIS_ARB_DESC_KEY, model.arabDescription)
            it.putString(HADIS_DESC_KEY, model.description)
            model.numberHadis?.let { it1 -> it.putInt(HADIS_NUMBER_KEY, it1) }

        })
    }
}