package com.example.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class MyAdapter (val listtache:ArrayList<Data>):RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    class ViewHolder(myview:View):RecyclerView.ViewHolder(myview) {
        val text_tache=itemView.findViewById(R.id.textView) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.row_recycleview,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val data:Data=listtache[position]
        val data=listtache[position]
        holder.text_tache.text=data.Nomtache
    }

    override fun getItemCount(): Int {
        return  listtache.size
    }


}