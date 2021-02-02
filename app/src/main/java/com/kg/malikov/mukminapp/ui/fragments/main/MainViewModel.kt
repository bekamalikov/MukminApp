package com.kg.malikov.mukminapp.ui.fragments.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kg.malikov.mukminapp.data.network.Status
import com.kg.malikov.mukminapp.data.network.repository.Repository
import com.kg.malikov.mukminapp.models.namaztime.Datum

class MainViewModel(var repository: Repository) : ViewModel() {
    var listTimes = MutableLiveData<Datum?>()
    var errorMessage = MutableLiveData<String>()


    fun fetchTime() {
        repository.fetchNamazTimeTodayFromNetworkByCity().observeForever {
            when (it.status) {
                Status.SUCCESS -> {
                    listTimes.postValue(it.data?.data)
                    Log.e("ololo", "fetchTimeSuccess:  $listTimes")
                }
                Status.ERROR -> errorMessage.value = it.message.toString()
            }
        }
    }
}