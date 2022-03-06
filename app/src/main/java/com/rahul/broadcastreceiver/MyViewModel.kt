package com.rahul.broadcastreceiver

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {

    val message = MutableLiveData<String>()

    fun sendMessage(text:String){
        message.value= text
    }
}