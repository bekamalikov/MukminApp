package com.kg.malikov.mukminapp.ui.fragments.name

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kg.malikov.mukminapp.data.network.repository.Repository
import com.kg.malikov.mukminapp.models.name.NameModel

class NameViewModel(var repository: Repository) : ViewModel() {
    var listTimes = MutableLiveData<MutableList<NameModel?>>(mutableListOf())
    var errorMessage = MutableLiveData<String?>()

    /*  fun fetchName() {
          val newData = listTimes
          listTimes.observeForever {
              repository.fetchNameByNetwork(it).observeForever {
                  when (it.status) {
                      Status.SUCCESS -> {
                          listTimes.value=it.data
                          Log.d("anime", it.data.toString())
                      }
                  }
              }

          }*/
}

