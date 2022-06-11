package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Api.ApiService
import com.example.myapplication.model.Films
import com.example.myapplication.model.Person

class PersonRepository(val apiService: ApiService) {

    val pernameNameMutable=MutableLiveData<Person>()
    val person:LiveData<Person>
    get() = pernameNameMutable

    val filmsNameMutable=MutableLiveData<Films>()
    val films:LiveData<Films>
        get() = filmsNameMutable


    suspend fun getAllPernameFileName(number:Int){
        val result=apiService.getPersonFileName(number)
        if (result!=null){
            pernameNameMutable.postValue(result.body())
        }
    }
}