package com.example.filereadwritek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var btnRead : Button
    lateinit var btnWrite : Button
    lateinit var txtview : TextView
    lateinit var editText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<EditText>(R.id.editText)
        txtview = findViewById<TextView>(R.id.txtView)
        btnRead = findViewById<Button>(R.id.btnRead)
        btnWrite = findViewById<Button>(R.id.btnWrite)

        btnWrite.setOnClickListener{
            val dataDir = ContextCompat.getDataDir(this)
            val myFile = File(dataDir,"file.txt")
            myFile.writeText(editText.text.toString())

        }
        btnRead.setOnClickListener{
            val dataDir = ContextCompat.getDataDir(this)
            val myFile = File(dataDir,"file.txt")
            txtview.text= myFile.readText()

        }

    }
}