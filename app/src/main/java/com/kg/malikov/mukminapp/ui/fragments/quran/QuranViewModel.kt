package com.kg.malikov.mukminapp.ui.fragments.quran

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kg.malikov.mukminapp.data.network.Status
import com.kg.malikov.mukminapp.data.network.repository.Repository
import com.kg.malikov.mukminapp.models.quran.Surah

class QuranViewModel(var repository: Repository) : ViewModel() {
    var errorMessage = MutableLiveData<String?>()
    var listTimes = MutableLiveData<MutableList<Surah>>()

    fun fetchQuran() {
        repository.fetchQuranFromNetwork().observeForever {
            when (it.status) {
                Status.SUCCESS -> {
                    listTimes.postValue(it.data?.data?.surahs)
                    Log.d("anime", it.data.toString())
                }
                Status.ERROR -> errorMessage.value = it.message.toString()
            }
        }
    }

}