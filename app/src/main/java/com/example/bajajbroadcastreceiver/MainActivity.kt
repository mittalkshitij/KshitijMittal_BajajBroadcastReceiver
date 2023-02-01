package com.example.bajajbroadcastreceiver

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    lateinit var receiver: MyReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = MyReceiver()

        // Intent Filter is useful to determine which apps wants to receive
        // which intents,since here we want to respond to change of
        // airplane mode
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            // registering the receiver
            // it parameter which is passed in  registerReceiver() function
            // is the intent filter that we have just created
            registerReceiver(receiver, it)
        }

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.RECEIVE_SMS)
            == PackageManager.PERMISSION_GRANTED){

            Toast.makeText(this,"Permission Granted",Toast.LENGTH_LONG).show()
        }
        else{
            ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.RECEIVE_SMS),123)
        }

        var intentFilter=IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        registerReceiver(receiver,intentFilter)

    }

    // since AirplaneModeChangeReceiver class holds a instance of Context
    // and that context is actually the activity context in which
    // the receiver has been created
//    override fun onStop() {
//        super.onStop()
//        unregisterReceiver(receiver)
//    }

    /* var intentFilter = IntentFilter("android.intent.action.AIRPLANE_MODE")
     var myReceiver = MyReceiver()
     registerReceiver(myReceiver,intentFilter)*/

}
