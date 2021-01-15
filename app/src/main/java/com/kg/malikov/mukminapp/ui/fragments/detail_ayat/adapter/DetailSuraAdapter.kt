package com.kg.malikov.mukminapp.ui.fragments.detail_ayat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kg.malikov.mukminapp.databinding.ItemAyatQuranBinding
import com.kg.malikov.mukminapp.models.quran.Ayah

class DetailSuraAdapter(
    var data: MutableList<Ayah>
) : RecyclerView.Adapter<DetailSuraAdapter.DetailSuraHolder>() {

    fun addItems(ayah: MutableList<Ayah>) {
        data = ayah
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailSuraHolder {
        val view = ItemAyatQuranBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailSuraHolder(view)
    }

    override fun onBindViewHolder(holder: DetailSuraHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class DetailSuraHolder(val binding: ItemAyatQuranBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ayah: Ayah) {
            binding.textViewNameAyat.text = ayah.text
            binding.tvNumberAyat.text = ayah.numberInSurah.toString()
        }
    }
}