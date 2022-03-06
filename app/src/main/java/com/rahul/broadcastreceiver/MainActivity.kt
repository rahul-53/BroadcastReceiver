package com.rahul.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahul.broadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var receiver:SystemBroadcastReceiver
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUser()
        broadcastReceiverRegister()
    }

    private fun broadcastReceiverRegister(){
        receiver = SystemBroadcastReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }
    }

    fun setUser(){
        val firstUser =User("rahul", "yadav", 24, true)
        binding.user = firstUser
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}