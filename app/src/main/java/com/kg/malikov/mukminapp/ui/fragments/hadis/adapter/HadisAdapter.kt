package com.kg.malikov.mukminapp.ui.fragments.hadis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kg.malikov.mukminapp.databinding.ItemHadisBinding
import com.kg.malikov.mukminapp.interfaces.IOnClickItemHadis
import com.kg.malikov.mukminapp.models.hadis.HadisModel

class HadisAdapter(var data: MutableList<HadisModel>, private val onItemClick: IOnClickItemHadis) :
    RecyclerView.Adapter<HadisAdapter.HadisViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadisViewHolder {
        val view = ItemHadisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HadisViewHolder(view)
    }

    override fun onBindViewHolder(holder: HadisViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            onItemClick.onItemClick(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class HadisViewHolder(val binding: ItemHadisBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(nameModel: HadisModel) {
            binding.tvNameHadis.text = nameModel.nameHadis
            binding.numberHadis.text = nameModel.numberHadis.toString()
        }

    }
}