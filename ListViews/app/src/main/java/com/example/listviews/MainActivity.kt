package com.example.listviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lvFruits = findViewById<ListView>(R.id.lvFruits)
        val tvFruitName = findViewById<TextView>(R.id.tvFruitName)
        lvFruits.adapter= ArrayAdapter(this,R.layout.list_item_view,R.id.tvFruitName,
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
    }
}