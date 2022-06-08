package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Api.ApiService
import com.example.myapplication.R
import com.example.myapplication.model.Result
import java.util.*

class PersonAdapter:RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    var personList= mutableListOf<Result>()

    fun setPersonName(personlist:List<Result>){
        this.personList=personlist.toMutableList()
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
            holder.tvfilname.text=person.films.toString()
        }
    }

    override fun getItemCount(): Int {
       return personList.size
    }

    class PersonViewHolder(view: View):RecyclerView.ViewHolder(view){
    val tvPersonName=view.findViewById<TextView>(R.id.tvpersonName)
     val tvfilname=view.findViewById<TextView>(R.id.tvFilmName)
    }
}