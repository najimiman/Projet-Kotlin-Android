package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user=ArrayList<Data>()
        user.add(Data("cafe",R.drawable.dk))
        user.add(Data("aa",R.drawable.dk))
        user.add(Data("cafe",R.drawable.dk))
        user.add(Data("aa",R.drawable.dk))
        user.add(Data("cafe",R.drawable.dk))
        user.add(Data("aa",R.drawable.dk))
        user.add(Data("cafe",R.drawable.dk))
        user.add(Data("aa",R.drawable.dk))
        user.add(Data("cafe",R.drawable.dk))
        user.add(Data("aa",R.drawable.dk))
        user.add(Data("cafe",R.drawable.dk))
        user.add(Data("aa",R.drawable.dk))
        user.add(Data("cafe",R.drawable.dk))
        user.add(Data("aa",R.drawable.dk))
        user.add(Data("cafe",R.drawable.dk))
        user.add(Data("aa",R.drawable.dk))
        binding.myreciecleview.layoutManager= LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val adaptere=MyAdapter(user)
        binding.myreciecleview.adapter=adaptere
    }

}