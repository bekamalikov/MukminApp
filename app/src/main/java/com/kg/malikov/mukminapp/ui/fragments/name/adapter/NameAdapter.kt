package com.kg.malikov.mukminapp.ui.fragments.name.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kg.malikov.mukminapp.databinding.ItemNameBinding
import com.kg.malikov.mukminapp.interfaces.IOnItemClick
import com.kg.malikov.mukminapp.interfaces.IOnItemClickName
import com.kg.malikov.mukminapp.models.name.NameModel

class NameAdapter(
    var data: MutableList<NameModel>,
    private val onItemClick: IOnItemClickName
) : RecyclerView.Adapter<NameAdapter.NameViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NameViewHolder(view)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            onItemClick.onItemClick(data[position])
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addData(name: MutableList<NameModel>) {
        data = name
        notifyDataSetChanged()
    }

    class NameViewHolder(val binding: ItemNameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(nameModel: NameModel) {
            binding.tvName.text = nameModel.name
            binding.tvArabName.text = nameModel.arabName
        }

    }
}