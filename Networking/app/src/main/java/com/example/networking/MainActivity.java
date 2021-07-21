package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
                updatetextview();
            }
        });

    }
    private void updatetextview(){
      //  TextView textView = findViewById(R.id.textView);
        //Make network call here
        Networktask networktask = new Networktask();
        //networktask.execute("https://www.google.com");

        networktask.execute("https://api.github.com/search/users?q=harshit");

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
            ArrayList<GithubUser> Users = parseJson(s);
            GithubUserAdapter githubUserAdapter = new GithubUserAdapter(Users);
            RecyclerView recyclerView = findViewById(R.id.rvUsers);
            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            recyclerView.setAdapter(githubUserAdapter);

            //TextView textView = findViewById(R.id.textView);
            //textView.setText(s);
        }
    }

    ArrayList<GithubUser> parseJson(String s){
        ArrayList<GithubUser> githubUsers = new ArrayList<>();

        //parse json
        try {
            JSONObject root = new JSONObject(s);
            JSONArray items = root.getJSONArray("items");
            for (int i=0;i<items.length();i++){
                JSONObject object = items.getJSONObject(i);

                String login = object.getString("login");
                Integer id = object.getInt("id");
                String html = object.getString("html_url");
                String avatar = object.getString("avatar_url");
                Double score = object.getDouble("score");

                GithubUser githubUser = new GithubUser(login,id,html,score,avatar);
                githubUsers.add(githubUser);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return githubUsers;


    }

}