package com.example.networking_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserActivtiy : AppCompatActivity() {

    lateinit var tvLogin: TextView
    lateinit var tvName: TextView
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        tvName = findViewById(R.id.tvName)
        tvLogin = findViewById(R.id.tvLogin)
        imageView = findViewById(R.id.imageView)

        val id = intent.getStringExtra("ID")

        GlobalScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO) { Client.api.getUsersByid(id!!) }
            if(response.isSuccessful) {
                response.body()?.let{
                    tvName.text = it.name
                    tvLogin.text=it.login
                    Picasso.get().load(it.avatarUrl).into(imageView)
                }
            }
        }
    }
}