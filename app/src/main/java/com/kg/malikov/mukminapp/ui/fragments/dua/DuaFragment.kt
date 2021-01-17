package com.kg.malikov.mukminapp.ui.fragments.dua

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.kg.malikov.mukminapp.R
import com.kg.malikov.mukminapp.base.BaseChangeFragment
import com.kg.malikov.mukminapp.databinding.FragmentDuaBinding
import com.kg.malikov.mukminapp.interfaces.IOnItemClickDua
import com.kg.malikov.mukminapp.models.dua.DuaModel
import com.kg.malikov.mukminapp.ui.fragments.dua.adapter.DuaAdapter
import com.kg.malikov.mukminapp.utils.*

class DuaFragment : BaseChangeFragment<FragmentDuaBinding>(), IOnItemClickDua {
    private lateinit var mRefUserListener: AppValueEventListener
    private lateinit var list: MutableList<DuaModel>
    private lateinit var adapter: DuaAdapter

    override fun initRecView() {
        adapter = DuaAdapter(list, this)
        binding.recViewDua.adapter = adapter
    }

    override fun observer() {
        list = mutableListOf()
        mRefUserListener = AppValueEventListener {
            if (it.exists()) {
                for (ds in it.children) {
                    val data = ds.getValue(DuaModel::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                    initRecView()
                }
            }
        }
        REF_DATABASE_ROOT.child(NODE_DUA)
            .addValueEventListener(mRefUserListener)

    }

    override fun onItemClick(model: DuaModel) {
        findNavController().navigate(R.id.detail_dua_fragment, Bundle().also {
            it.putString(DUA_TITLE_KEY, model.title)
            it.putString(DUA_ARABIC_KEY, model.arabDesc)
            it.putString(DUA_DESC_KEY, model.description)
            it.putString(DUA_TRANSCRIPTION_KEY, model.transcription)
        })
    }


}