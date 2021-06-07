package com.example.asynctasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static android.graphics.Color.*;

public class MainActivity extends AppCompatActivity {

        Button btnChangeColor;
        ConstraintLayout clBackground;
        ListView lvItems;
        String[] items = new String[]{
                "Alpha","Beta","Gamma","Delta","Phi","Curo"
        };


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangeColor=findViewById(R.id.btnChangeColor);
        clBackground=findViewById(R.id.clBackground);
        lvItems=findViewById(R.id.lvItems);

            ArrayAdapter<String> itemAdapter= new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    items
            );

            lvItems.setAdapter(itemAdapter);



        /*Without the use of Handler and Multiple Threads were not running
        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waitNsec(10);
                clBackground.setBackgroundColor(RED);
            }
        });*/

        //With the use of handler
            btnChangeColor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Handler h = new Handler();
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            Log.d("Delay", "run: We have waited for 5 sec");
                            clBackground.setBackgroundColor(RED);

                        }
                    };
                    h.postDelayed(r,5000);
                }
            });




    }

    void wait1sec(){
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis()< startTime+1000);
    }

    void waitNsec(int n){
        for (int i=0;i<n;i++){
            wait1sec();
        }
    }

}