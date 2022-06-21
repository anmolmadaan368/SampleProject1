package com.example.sampleproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.R
import com.example.sampleproject.model.Contact
import com.example.sampleproject.model.Phone
import com.example.sampleproject.model.User

class UserAdapter(private val context: Context, private var userResponse:ArrayList<Contact>) :RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user,parent,false))
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val user = userResponse[position]

        holder.name.text = user.name
        holder.email.text = user.email
        holder.gender.text = user.gender
        holder.mobile.text = user.phone.toString()

    }

    override fun getItemCount(): Int {
        return userResponse.size
    }

    fun setUserData(list: ArrayList<Contact>){
        this.userResponse = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name:TextView = itemView.findViewById(R.id.Name)
        val email:TextView = itemView.findViewById(R.id.Email)
        val gender:TextView = itemView.findViewById(R.id.Gender)
        val mobile:TextView = itemView.findViewById(R.id.mobile)

    }

}