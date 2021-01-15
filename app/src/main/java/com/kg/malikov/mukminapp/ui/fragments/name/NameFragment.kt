package com.kg.malikov.mukminapp.ui.fragments.name

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.kg.malikov.mukminapp.R
import com.kg.malikov.mukminapp.base.BaseChangeFragment
import com.kg.malikov.mukminapp.databinding.NameFragmentBinding
import com.kg.malikov.mukminapp.interfaces.IOnItemClickName
import com.kg.malikov.mukminapp.interfaces.OnFragmentInteractionListener
import com.kg.malikov.mukminapp.models.name.NameModel
import com.kg.malikov.mukminapp.ui.fragments.name.adapter.NameAdapter
import com.kg.malikov.mukminapp.utils.*
import org.koin.android.viewmodel.ext.android.viewModel

class NameFragment : BaseChangeFragment<NameFragmentBinding>(), IOnItemClickName {

    private val viewModel: NameViewModel by viewModel()
    private lateinit var mRefUserListener: AppValueEventListener
    private lateinit var list: MutableList<NameModel>
    private lateinit var adapter: NameAdapter
    private var listener: OnFragmentInteractionListener? = null

    override fun initRecView() {
        adapter = NameAdapter(list, this)
        binding.recViewSuraInQuran.adapter = adapter
    }

    override fun scrollRecView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.recViewSuraInQuran.setOnScrollChangeListener { _, _, scrollY, oldScrollX, oldScrollY ->
                val delta = scrollY - oldScrollY
                listener?.onFragmentScrolled(delta.toFloat())
            }
        }
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
        })
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