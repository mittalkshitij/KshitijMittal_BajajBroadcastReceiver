package com.example.bajajbroadcastreceiver.customBroadcastReceiever



import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.bajajbroadcastreceiver.R


class LauncherActivity : AppCompatActivity() {

    lateinit var customReceiver: CustomReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        var button = findViewById<Button>(R.id.button)

        button.setOnClickListener {

            customReceiver = CustomReceiver()

            val intent =
                Intent()

            intent.putExtra("message", "This is Custom Broadcast Receiver")
            intent.action = "CUSTOM_INTENT"

            registerReceiver(customReceiver,IntentFilter("CUSTOM_INTENT"))

            sendBroadcast(intent)
        }
    }

}