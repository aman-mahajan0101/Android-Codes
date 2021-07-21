package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void updatetextview(){
      //  TextView textView = findViewById(R.id.textView);
        //Make network call here
        Networktask networktask = new Networktask();
        networktask.execute("https://www.google.com");

    }

    class Networktask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String Stringurl = strings[0];

            try {
                URL url = new URL(Stringurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                Scanner scanner = new Scanner(inputStream);

                scanner.useDelimiter("\\A");
                if(scanner.hasNext()){
                    String s = scanner.next();
                    return s;
                }



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "Failed to load";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            TextView textView = findViewById(R.id.textView);
            textView.setText(s);
        }
    }
}