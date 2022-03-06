package com.rahul.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rahul.broadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var receiver:SystemBroadcastReceiver
    lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setUser()
        observeData()
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

    private fun observeData(){
        myViewModel= ViewModelProvider(this)[MyViewModel::class.java]
        binding.viewModel  = myViewModel
        binding.lifecycleOwner = this
        binding.editText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {
                myViewModel.sendMessage(char.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
}