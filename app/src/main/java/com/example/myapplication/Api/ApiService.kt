package com.example.myapplication.Api

import com.example.myapplication.model.Person
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("people")
    fun getFilmName(@Query("film")filmName:String):Response<Person>

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