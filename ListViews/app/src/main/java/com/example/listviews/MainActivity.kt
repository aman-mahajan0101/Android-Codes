package com.example.listviews

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {


//    lateinit var frtname: TextView
//    frtname = findViewById<TextView>(R.id.tvFruitsName)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lvFruits = findViewById<ListView>(R.id.lvFruits)
        lvFruits.adapter = ArrayAdapter(
            this, R.layout.list_item_view, R.id.tvFruitName,
            arrayOf(
                "Apple",
                "Mango",
                "Guava",
                "Banana",
                "Grapes",
                "Watermelon",
                "Papaya",
                "Strawberry",
                "Kiwi",
                "Apple",
                "Mango",
                "Guava",
                "Banana",
                "Grapes",
                "Watermelon",
                "Papaya",
                "Strawberry",
                "Kiwi"
            )
        )

        lvFruits.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(this,
            "Johny ate ${position+1}",
            Toast.LENGTH_SHORT).show()
        }
    }
}