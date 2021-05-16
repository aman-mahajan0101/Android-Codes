package com.example.whatsappopenner

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var num :String = "0"

        if(intent.action == Intent.ACTION_PROCESS_TEXT){
           num = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT).toString()
        }
        if(num.isDigitsOnly()){
            startwhatsapp(num)
        }else{
            Toast.makeText(this,"Please check the number",Toast.LENGTH_SHORT).show()
        }

    }

    private fun startwhatsapp(num: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setPackage("com.whatsapp")
        val data :String =if(num[0]=='+'){
            num.substring(1)
        }else if(num.length==10){
            "91"+num
        }else{
            num
        }
        intent.data=Uri.parse("https://wa.me/$data")
        if(packageManager.resolveActivity(intent,0) !=null){
            startActivity(intent)
        }else{
            Toast.makeText(this,"Please install Whatsapp",Toast.LENGTH_SHORT).show()
        }
        finish()
    }
}