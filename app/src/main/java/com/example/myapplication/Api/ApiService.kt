package com.example.myapplication.Api

import com.example.myapplication.model.Films
import com.example.myapplication.model.Person
import com.example.myapplication.model.Result
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    @GET("/api/films")
    fun getFilmName(@Query("")number:Int):Response<Films>

    @GET("people")
    suspend fun getPersonName():Response<Person>



    @GET("people")
    suspend fun getPersonFileName(@Query("number")number:Int):Response<Person>

  companion object{
      var mInstance:ApiService?=null

      fun getInstance():ApiService{
          val retrofit=Retrofit.Builder().baseUrl("https://swapi.dev/api/")
              .addConverterFactory(GsonConverterFactory.create())
              .build()
         mInstance=retrofit.create(ApiService::class.java)

         return mInstance!!
      }
  }
}