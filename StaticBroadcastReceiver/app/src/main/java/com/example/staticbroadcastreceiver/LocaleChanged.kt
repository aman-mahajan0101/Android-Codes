package com.example.staticbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class LocaleChanged : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("RCV","LOCALE")
        Toast.makeText(context,"Language Changed",Toast.LENGTH_SHORT).show();
        context.startActivity(Intent(context,MainActivity::class.java))
    }
}