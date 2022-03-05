package com.rahul.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SystemBroadcastReceiver:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val airplaneModeEnabled =  intent?.getBooleanExtra("state",false)?:return
        if (airplaneModeEnabled){
            Toast.makeText(context,"airplane mode enabled", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"airplane mode disabled", Toast.LENGTH_SHORT).show()
        }
    }
}