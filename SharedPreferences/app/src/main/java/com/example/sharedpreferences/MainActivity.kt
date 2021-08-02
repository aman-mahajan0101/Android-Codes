package com.example.sharedpreferences

import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var btnRed : Button
    lateinit var btnBlue : Button
    lateinit var btnGreen : Button
    lateinit var llBackground : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRed = findViewById(R.id.btnRed)
        btnBlue = findViewById(R.id.btnBlue)
        btnGreen = findViewById(R.id.btnGreen)
        llBackground = findViewById(R.id.llBackground)

        var sPref = getPreferences(MODE_PRIVATE)
        var color = sPref.getInt("COLOR",Color.WHITE)
        llBackground.setBackgroundColor(color)

        fun saveColor(color:Int){
            var editor = sPref.edit()
            editor.putInt("COLOR",color)
            editor.apply()
        }


        btnRed.setOnClickListener {
            llBackground.setBackgroundColor(Color.RED)
            saveColor(Color.RED)
        }
        btnBlue.setOnClickListener {
            llBackground.setBackgroundColor(Color.BLUE)
            saveColor(Color.BLUE)
        }
        btnGreen.setOnClickListener {
            llBackground.setBackgroundColor(Color.GREEN)
            saveColor(Color.GREEN)
        }


    }
}