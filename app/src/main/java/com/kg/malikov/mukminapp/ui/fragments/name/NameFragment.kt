package com.kg.malikov.mukminapp.ui.fragments.name

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.kg.malikov.mukminapp.R
import com.kg.malikov.mukminapp.base.BaseChangeFragment
import com.kg.malikov.mukminapp.databinding.NameFragmentBinding
import com.kg.malikov.mukminapp.interfaces.IOnFragmentInteractionListener
import com.kg.malikov.mukminapp.interfaces.IOnItemClickName
import com.kg.malikov.mukminapp.models.name.NameModel
import com.kg.malikov.mukminapp.ui.fragments.name.adapter.NameAdapter
import com.kg.malikov.mukminapp.utils.*
import org.koin.android.viewmodel.ext.android.viewModel

class NameFragment : BaseChangeFragment<NameFragmentBinding>(), IOnItemClickName {

    private val viewModel: NameViewModel by viewModel()
    private lateinit var mRefUserListener: AppValueEventListener
    private lateinit var list: MutableList<NameModel>
    private lateinit var adapter: NameAdapter

    override fun initRecView() {
        adapter = NameAdapter(list, this)
        binding.recViewName.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scrollRecView(binding.recViewName)
    }

    override fun observer() {
        list = mutableListOf()
        mRefUserListener = AppValueEventListener {
            if (it.exists()) {
                for (ds in it.children) {
                    val data = ds.getValue(NameModel::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                    initRecView()
                }
            }
        }
        REF_DATABASE_ROOT.child(NODE_NAMES)
            .addValueEventListener(mRefUserListener)

    }

    override fun onItemClick(model: NameModel) {
        findNavController().navigate(R.id.detailNameFragment, Bundle().also {
            it.putString(GREAT_NAME_KEY, model.name)
            it.putString(GREAT_ARAB_NAME_KEY, model.arabName)
            it.putString(GREAT_TRANSLATION_NAME_KEY, model.nameTranslation)
            it.putString(GREAT_MEANING_NAME_KEY, model.meaningName)
        })
    }


}