package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Api.ApiService
import com.example.myapplication.adapter.PersonAdapter
import com.example.myapplication.viewmodel.MainViewModel
import com.example.myapplication.viewmodel.PersonRepository
import com.example.myapplication.viewmodel.PersonlFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    lateinit var recyclerView: RecyclerView

    val adapter by lazy {
        PersonAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerview)

        val apiService=ApiService.getInstance()
        val repository= PersonRepository(apiService)
        mainViewModel=ViewModelProvider(this,PersonlFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.personName.observe(this, Observer {
            adapter.setPersonName(it.results)
            recyclerView.adapter=adapter
        })
    }
}