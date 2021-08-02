package com.example.filereadwrite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.media.MediaParser;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView txtView;
    Button btnRead, btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edtText);
        txtView = findViewById(R.id.txtView);
        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);


        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                File dataDir = ContextCompat.getDataDir(MainActivity.this);
                File myFile = new File(dataDir,"file.txt");

                try {
                    FileOutputStream fos = new FileOutputStream(myFile,true);
                    fos.write(text.getBytes());
                } catch (FileNotFoundException fnfe) {
                    Toast.makeText(MainActivity.this, "File not Found", Toast.LENGTH_SHORT).show();
                } catch (IOException ioe) {
                    Toast.makeText(MainActivity.this, "Error while writing File", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dataDir = ContextCompat.getDataDir(MainActivity.this);
                File myFile = new File(dataDir,"file.txt");

                try {
                    FileInputStream fis = new FileInputStream(myFile);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);

                    StringBuilder sb = new StringBuilder();
                    String buffer = br.readLine();

                    while(buffer!= null){
                        sb.append(buffer);
                        buffer = br.readLine();
                    }

                    String text = sb.toString();
                    txtView.setText(text);

                } catch (FileNotFoundException e) {
                    Toast.makeText(MainActivity.this, "File not Found", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Error while reading File", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}