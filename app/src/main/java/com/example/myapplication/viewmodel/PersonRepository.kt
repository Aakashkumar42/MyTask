package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Api.ApiService
import com.example.myapplication.model.Person

class PersonRepository(val apiService: ApiService) {

    val pernameNameMutable=MutableLiveData<Person>()
    val person:LiveData<Person>
    get() = pernameNameMutable

    suspend fun getAllPername(){
        val result=apiService.getPersonName()
        if (result!=null){
            pernameNameMutable.postValue(result.body())
        }
    }

    suspend fun getAllPernameFileName(number:Int){
        val result=apiService.getPersonFileName(number)
        if (result!=null){
            pernameNameMutable.postValue(result.body())
        }
    }
}