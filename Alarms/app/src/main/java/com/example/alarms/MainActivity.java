package com.example.alarms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAlarm = findViewById(R.id.btnAlarm);

        btnAlarm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(),MainActivity2.class);

                //For one time ALarm
                /*
                PendingIntent pi = PendingIntent.getActivity(getBaseContext(),12345,i,PendingIntent.FLAG_ONE_SHOT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                alarmManager.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+30000,pi);
                */
                //For repeating Alarm : Using setRepeating()
                /*
                PendingIntent pi = PendingIntent.getActivity(getBaseContext(),12345,i,PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime()+30000,
                        30000, pi);
                */

                //For repeating Alarm : Using setRepeating()
                PendingIntent pi = PendingIntent.getActivity(getBaseContext(),12345,i,PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime()+5000,
                        5000, pi);


            }

        });



    }
}