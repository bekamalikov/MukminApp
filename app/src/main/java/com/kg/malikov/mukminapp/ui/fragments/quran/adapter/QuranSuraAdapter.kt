package com.kg.malikov.mukminapp.ui.fragments.quran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kg.malikov.mukminapp.databinding.ItemSuraBinding
import com.kg.malikov.mukminapp.interfaces.IOnItemClick
import com.kg.malikov.mukminapp.models.quran.Surah

class QuranSuraAdapter(
    var data: MutableList<Surah>,
    private val onItemClick: IOnItemClick
) :
    RecyclerView.Adapter<QuranSuraAdapter.QuranSuraViewHolder>() {


    fun addItems(sura: MutableList<Surah>) {
        data = sura
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranSuraViewHolder {
        val view = ItemSuraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuranSuraViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuranSuraViewHolder, position: Int) {
        holder.bind(data.get(position))
        holder.itemView.setOnClickListener {
            onItemClick.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class QuranSuraViewHolder(val binding: ItemSuraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(surah: Surah?) {
            binding.textViewNameSura.text = surah?.englishName
            binding.arabTextViewNameSura.text = surah?.name
            binding.tvNumberSura.text = surah?.number.toString()
        }

    }
}