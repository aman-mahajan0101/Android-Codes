package com.example.networking_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlin.with as with

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    lateinit var tvLogin : TextView
    lateinit var tvName : TextView
    lateinit var imageView : ImageView

    private var data : List<User> = ArrayList()
    var onItemClick:((id:String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) =  holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    fun swapData(data : List<User>){
        this.data=data
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView : View ) :RecyclerView.ViewHolder(itemView){
        fun bind(item: User) = with(itemView){
            tvName = findViewById(R.id.tvName)
            tvLogin = findViewById(R.id.tvLogin)
            imageView = findViewById(R.id.imageView)
            tvName.text = item.name
            tvLogin.text=item.login
            Picasso.get().load(item.avatarUrl).into(imageView)
            setOnClickListener {
                onItemClick?.invoke(item.login!!)
            }
        }

    }
}