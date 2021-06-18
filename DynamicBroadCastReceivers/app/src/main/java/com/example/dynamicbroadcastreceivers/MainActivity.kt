package com.example.dynamicbroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val psr = PowerStateReceiver()
        val iFilter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }

        registerReceiver(psr,iFilter)

    }

    inner class PowerStateReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {

            if(intent == null) return

            if(intent.action == Intent.ACTION_POWER_DISCONNECTED){
                Toast.makeText(this@MainActivity,"Power State Discharged",Toast.LENGTH_SHORT).show()

            }
            if(intent.action == Intent.ACTION_POWER_CONNECTED){
                Toast.makeText(this@MainActivity,"Power State Charged",Toast.LENGTH_SHORT).show()
            }

        }
    }
}