package com.example.bajajbroadcastreceiver.customBroadcastReceiever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        var data: String? = intent?.getStringExtra("message")

        Toast.makeText(context,data.toString(),Toast.LENGTH_LONG).show()

    }


}