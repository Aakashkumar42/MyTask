package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: PersonRepository):ViewModel() {

    init {

        viewModelScope.launch(Dispatchers.IO){
            for (i in 1..10){
                repository.getAllPernameFileName(i)
            }
        }
    }
    val personName:LiveData<Person>
    get() = repository.person
}