package com.kg.malikov.mukminapp.ui.fragments.detail_ayat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kg.malikov.mukminapp.data.network.Status
import com.kg.malikov.mukminapp.data.network.repository.Repository
import com.kg.malikov.mukminapp.models.quran.Ayah

class DetailAyatViewModel(var repository: Repository) : ViewModel() {
    var errorMessage = MutableLiveData<String?>()
    var listTimes = MutableLiveData<MutableList<Ayah>>()

    fun fetchSuraFromQuran(suraNumber: String?) {
        repository.fetchSuraFromQuranFromNetwork(suraNumber).observeForever {
            when (it.status) {
                Status.SUCCESS -> {
                    listTimes.postValue(it.data?.data?.ayahs)
                }
                Status.ERROR -> errorMessage.value = it.message.toString()
            }
        }
    }
}