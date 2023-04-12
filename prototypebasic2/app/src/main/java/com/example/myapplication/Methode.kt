package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.AjouterBinding

class Methode:AppCompatActivity() {
    lateinit var binding: AjouterBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding=AjouterBinding.inflate(layoutInflater)
       setContentView(binding.root)
        var nom=binding.textView2

        binding.submit.setOnClickListener {
            nom.text="hello iman"
        }
    }


}
