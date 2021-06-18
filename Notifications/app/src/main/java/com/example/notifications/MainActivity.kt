package com.example.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSimple = findViewById<Button>(R.id.btnSimple)
        var btnHead = findViewById<Button>(R.id.btnHead)
        var btnClickable1 = findViewById<Button>(R.id.btnClickable1)
        var btnClickable2 = findViewById<Button>(R.id.btnClickable2)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //Only to work for devices greater than OREO
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val channel = NotificationChannel("first",
                "default",
                NotificationManager.IMPORTANCE_HIGH)
            channel.apply {
                enableLights(true)
                enableVibration(true)
            }
            nm.createNotificationChannel(channel)

            //Previous Code
                /*
            nm.createNotificationChannel(NotificationChannel("first",
                "default",
            NotificationManager.IMPORTANCE_DEFAULT))

                 */
        }

        btnSimple.setOnClickListener {
            val simpleNotification = NotificationCompat.Builder(this,"first")
                .setContentTitle("Simple Title")
                .setContentText("Notification type: Simple")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(1,simpleNotification)
        }

        btnClickable1.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data= Uri.parse("https://www.google.com")

            val p = PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val clickableNotification1 = NotificationCompat.Builder(this,"first")
                .setContentTitle("Clickable 1 Title")
                .setContentIntent(p)
                .setAutoCancel(true)
                .setContentText("Notification type: Clickable")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(2,clickableNotification1)

        }

        btnClickable2.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data= Uri.parse("https://www.google.com")

            val p = PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val clickableNotification2 = NotificationCompat.Builder(this,"first")
                .setContentTitle("Clickable 2 Title")
                .setAutoCancel(true)
                .addAction(R.drawable.ic_launcher_foreground,"Click Me",p)
                .setContentText("Notification type: Clickable")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(3,clickableNotification2)

        }

        btnHead.setOnClickListener {

            val builder =
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {
                    Notification.Builder(this,"first")
                }else{
                    Notification.Builder(this)
                        .setPriority(Notification.PRIORITY_MAX)
                        .setDefaults(Notification.DEFAULT_LIGHTS or Notification.DEFAULT_VIBRATE)
                }

            val simpleNotification = builder
                .setContentTitle("Heads Up Title")
                .setContentText("Notification type: Head")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .build()

            nm.notify(4,simpleNotification)
        }


    }
}