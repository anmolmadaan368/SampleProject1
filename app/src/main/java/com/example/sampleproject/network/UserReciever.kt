package com.example.sampleproject.network

import com.example.sampleproject.model.Contact
import com.example.sampleproject.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class UserReciever {


    companion object{

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.androidhive.info/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitInterface:RetrofitInterface by lazy {
            retrofit.create(RetrofitInterface::class.java)
        }
    }

    suspend fun getUsers():List<Contact>{
        return retrofitInterface.getUsers()
    }
}