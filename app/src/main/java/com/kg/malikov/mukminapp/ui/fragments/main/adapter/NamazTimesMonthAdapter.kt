package com.kg.malikov.mukminapp.ui.fragments.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kg.malikov.mukminapp.databinding.ItemForNamazTimeBinding
import com.kg.malikov.mukminapp.models.namaztime.Datum

class NamazTimesMonthAdapter(var data: MutableList<Datum>?) :
    RecyclerView.Adapter<NamazTimesMonthAdapter.NamazTimeHolder>() {


    fun addItems(datum: MutableList<Datum>?) {
        data = datum
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamazTimeHolder {
        val view =
            ItemForNamazTimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NamazTimeHolder(view)
    }

    override fun onBindViewHolder(holder: NamazTimeHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    class NamazTimeHolder(private val binding: ItemForNamazTimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(datum: Datum?) {
            binding.itemTvBagymdatTime.text = datum?.timings?.fajr
            binding.itemTvSunrisTime.text = datum?.timings?.sunrise
            binding.itemTvPeshimTime.text = datum?.timings?.dhuhr
            binding.itemTvAsrTime.text = datum?.timings?.asr
            binding.itemTvMagribTime.text = datum?.timings?.maghrib
            binding.itemTvIshaTime.text = datum?.timings?.isha
        }

    }
}