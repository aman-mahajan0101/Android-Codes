package com.example.implicitintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

const val KEY_1="Name"
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mailbtn = findViewById<Button>(R.id.mailbtn)
        val browsebtn = findViewById<Button>(R.id.browsebtn)
        val dialbtn = findViewById<Button>(R.id.dialbtn)
        val edittext = findViewById<EditText>(R.id.editText)
        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener{
            val i = Intent(this,MainActivity2::class.java)
            i.putExtra(KEY_1,"Aman")
            startActivity(i)
        }

        mailbtn.setOnClickListener{
            val email = edittext.text.toString()
            val i =  Intent()
            i.action = Intent.ACTION_SENDTO
            i.data= Uri.parse("mailto:$email")
            startActivity(i)
        }

        browsebtn.setOnClickListener{
            val browse = edittext.text.toString()
            val i =  Intent()
            i.action = Intent.ACTION_VIEW
            i.data= Uri.parse("http://$browse")
            startActivity(i)
        }
        dialbtn.setOnClickListener{
            val dial = edittext.text.toString()
            val i =  Intent()
            i.action = Intent.ACTION_DIAL
            i.data= Uri.parse("tel:$dial")
            startActivity(i)
        }



    }


}