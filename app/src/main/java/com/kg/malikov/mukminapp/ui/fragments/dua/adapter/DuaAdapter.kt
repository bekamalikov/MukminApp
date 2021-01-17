package com.kg.malikov.mukminapp.ui.fragments.dua.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kg.malikov.mukminapp.databinding.ItemDuaBinding
import com.kg.malikov.mukminapp.interfaces.IOnItemClickDua
import com.kg.malikov.mukminapp.models.dua.DuaModel

class DuaAdapter(var data: MutableList<DuaModel>, var onItemClick: IOnItemClickDua) :
    RecyclerView.Adapter<DuaAdapter.DuaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DuaViewHolder {
        val view = ItemDuaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DuaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DuaViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            onItemClick.onItemClick(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class DuaViewHolder(val binding: ItemDuaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(duaModel: DuaModel) {
            binding.tvTitleDua.text = duaModel.title
        }

    }
}