package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {


    //For Doing the work in Main Thread
    /*val db by lazy{
        Room.databaseBuilder(this,
        AppDatabase::class.java,"User.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }*/

    //For Doing the Work in Another Thread Using CoRoutines
    val db by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java, "User.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 = findViewById<Button>(R.id.btn1)
        var btn2 = findViewById<Button>(R.id.btn2)
        var txt1 = findViewById<TextView>(R.id.txt1)
        var txt2 = findViewById<TextView>(R.id.txt2)
        var txt3 = findViewById<TextView>(R.id.txt3)
        var txt4 = findViewById<TextView>(R.id.txt4)

        //When Using Main Thread
        /*
        btn1.setOnClickListener {
            db.userDao().insert(User("Aman Mahajan","7838286718","Shahdara",21))
        }
        btn2.setOnClickListener {
            val list : List<User> = db.userDao().getAllUser()
            if(list.isNotEmpty()){
                with(list[0]){
                    txt1.text=name
                    txt2.text=number
                    txt3.text=address
                    txt4.text=age.toString()
                }
            }
        }
         */

        //When using Coroutines
        /*
        btn1.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                db.userDao().insert(User("Aman Mahajan","7838286718","Shahdara",21))
            }
        }
        btn2.setOnClickListener {
            runBlocking {
                val list: Deferred<List<User>> =
                    GlobalScope.async(Dispatchers.IO) { db.userDao().getAllUser() }
                if (list.await().isNotEmpty()) {
                    with(list.await()[0]) {
                        txt1.text = name
                        txt2.text = number
                        txt3.text = address
                        txt4.text = age.toString()
                    }
                }
            }
        }*/

        //When using Coroutines with LiveData
        btn1.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                db.userDao().insert(User("Aman Mahajan", "7838286718", "Shahdara", 21))
            }
        }

        db.userDao().getAllUser().observe(this, Observer { list: List<User> ->
            if (list.isNotEmpty()) {
                with(list[0]) {
                    txt1.text = name
                    txt2.text = number
                    txt3.text = address
                    txt4.text = age.toString()
                }
            }

        })

    }
}