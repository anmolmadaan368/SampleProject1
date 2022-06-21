package com.example.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleproject.ViewModel.UserViewModel
import com.example.sampleproject.ViewModel.UserViewModelFactory
import com.example.sampleproject.adapter.UserAdapter
import com.example.sampleproject.databinding.ActivityMainBinding
import com.example.sampleproject.model.Contact
import com.example.sampleproject.network.UserReciever
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val userReciever:UserReciever = UserReciever()
    private lateinit var userAdapter: UserAdapter
    private lateinit var userViewModel: UserViewModel
//    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView()
        val viewModelFactory = UserViewModelFactory(userReciever)
        userViewModel = ViewModelProvider(this,viewModelFactory)[UserViewModel::class.java]
        userViewModel.getUsers()
        userViewModel.response.observe(this, Observer {
            userAdapter.setUserData(it as ArrayList<Contact>)
            recycler_view.visibility= View.VISIBLE

        })


    }


    private fun recyclerView(){
        userAdapter = UserAdapter(this,ArrayList())

        recycler_view.apply {
            recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter=userAdapter
        }

    }
}