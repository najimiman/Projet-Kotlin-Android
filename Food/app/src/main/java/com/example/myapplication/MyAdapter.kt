package com.example.myapplication

import android.support.v7.view.menu.MenuView.ItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(val userlist:ArrayList<Data>): RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val text_description=itemView.findViewById(R.id.textView2) as TextView
        val my_image=itemView.findViewById(R.id.imageView) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.recycle_row,parent,false)
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data:Data=userlist[position]
        holder.text_description.text=data.Description
        holder.my_image.setImageResource(data.Image)
    }

    override fun getItemCount(): Int {
        return  userlist.size
    }

}