package com.example.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val num1 = findViewById<EditText>(R.id.edText1)
        val num2 = findViewById<EditText>(R.id.edText2)
        val btn = findViewById<Button>(R.id.Result)
        val txt = findViewById<TextView>(R.id.ResultText)
        btn.setOnClickListener {
            val n1 = Integer.valueOf(num1.text.toString())
            val n2 = Integer.valueOf(num2.text.toString())
            val n3 = n1 + n2
            txt.text = n3.toString()
        }


    }


}

