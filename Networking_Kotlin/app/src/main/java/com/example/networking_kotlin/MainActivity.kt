package com.example.networking_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import com.squareup.picasso.Picasso;
import retrofit2.Response

class MainActivity : AppCompatActivity(){

    lateinit var sView : androidx.appcompat.widget.SearchView
    val adapter = UserAdapter()
    lateinit var userRv: RecyclerView
    val originalList = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userRv = findViewById(R.id.userRv)
        sView = findViewById(R.id.sView)

        adapter.onItemClick = {
            val intent = Intent(this, UserActivtiy::class.java)
            intent.putExtra("ID", it)
            startActivity(intent)
        }

        userRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter

        }

        sView.isSubmitButtonEnabled = true
        sView.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               query?.let {searchUsers(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let{searchUsers(it) }
                return true
            }

        })

        sView.setOnCloseListener {
            adapter.swapData(originalList)
            true

        }

        sView.setOnCloseListener {
            adapter.swapData(originalList)
            true
        }
        GlobalScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO) { Client.api.getUsers() }
            if(response.isSuccessful) {
                response.body()?.let{
                    originalList.addAll(it)
                    adapter.swapData(it)
                }
            }
        }




        //Code we used for Okhttp and Gson
        /*
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.github.com/users/aman-mahajan0101")
            .build()


        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create()
         */


        //Done while using Gson
        /*
         GlobalScope.launch(Dispatchers.Main) {
            val response= withContext(Dispatchers.IO){okHttpClient.newCall(request).execute().body?.string() }
            val user = gson.fromJson<User>(response,User::class.java)
            tvName.text = user.name
            tvLogin.text=user.login
            Picasso.get().load(user.avatarUrl).into(imageView)
         */


        //Done while using Okhttp
        /*
        GlobalScope.launch(Dispatchers.Main) {
          val response= withContext(Dispatchers.IO){okHttpClient.newCall(request).execute().body?.string() }
          //Log.d("Networking","${response.body?.string()}")

            val obj = JSONObject(response)
            val login = obj.getString("login")
            val name = obj.getString("name")
            val image = obj.getString("avatar_url")
            tvName.text = name
            tvLogin.text=login
            Picasso.get().load(image).into(imageView)

         */


    }
    fun searchUsers(query:String){
        GlobalScope.launch(Dispatchers.Main){
            val response = withContext(Dispatchers.IO) { Client.api.searchUsers(query) }
            if(response.isSuccessful) {
                response.body()?.let{
                    it.items?.let { it1 -> adapter.swapData(it1) }
                }
            }
        }
    }

}
