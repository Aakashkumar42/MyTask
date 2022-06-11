package com.example.myapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Api.ApiService
import com.example.myapplication.R
import com.example.myapplication.model.Films
import com.example.myapplication.model.Person
import com.example.myapplication.model.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Request
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.contracts.contract

class PersonAdapter:RecyclerView.Adapter<PersonAdapter.PersonViewHolder>(),View.OnClickListener {

    var personList= mutableListOf<Result>()



    fun setPersonName(personlist:List<Result>){
        this.personList=personlist.toMutableList()
        personList.sortBy {
            it.name
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
       return PersonViewHolder(LayoutInflater.from(parent.context).inflate(
           R.layout.person_list,
           parent,
           false
       ))
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {

          val person=personList[position]

            holder.tvPersonName.text=person.name
            holder.tvPersonName.setOnClickListener {
            holder.tvfilname.visibility=View.VISIBLE


        }


    }

    override fun getItemCount(): Int {
       return personList.size
    }

    class PersonViewHolder(view: View):RecyclerView.ViewHolder(view){
    val tvPersonName=view.findViewById<TextView>(R.id.tvpersonName)
     val tvfilname=view.findViewById<TextView>(R.id.tvFilmName)
    }

    override fun onClick(v: View?) {
        v!!.setOnClickListener {
            v!!.findViewById<TextView>(R.id.tvFilmName)
        }

    }
    fun sortAlphabetically(arrayList: ArrayList<Result>): ArrayList< Result >{
        var returnList: ArrayList< Result > = arrayListOf()
        var list = arrayList as MutableList< Result >
        list.sortWith(Comparator { o1: Result, o2: Result ->
            o1.name.compareTo(o2.name)
        })
        returnList = list as ArrayList< Result >
        return returnList
    }
}

