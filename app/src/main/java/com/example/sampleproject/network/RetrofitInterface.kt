package com.example.sampleproject.network

import com.example.sampleproject.model.Contact
import com.example.sampleproject.model.User
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("contacts/")
    suspend fun getUsers():List<Contact>
}