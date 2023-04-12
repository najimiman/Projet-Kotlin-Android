package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var list=ArrayList<Data>()
   //private lateinit var adtache:Floating
   //private lateinit var submit: Button
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageButton.setOnClickListener { Deletetache() }
       /* submit = findViewById(R.id.submit)
        submit.setOnClickListener {
            create()
        }*/
    }

    private fun create() {
        val inflater=LayoutInflater.from(this)
        var v=inflater.inflate(R.layout.activity_main,null)
        val adddialo=AlertDialog.Builder(this)
        adddialo.setView(v)
        adddialo.setNegativeButton("aaa"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
        adddialo.create()
        adddialo.show()
    }

    fun Ajoutertache() {
        //var nom=binding.editTextTextPersonName.text.toString()
        /*var nm=findViewById<EditText>(R.id.nomtache)
        var nom=nm.text.toString()
        Toast.makeText(this,nom,Toast.LENGTH_LONG).show()
        list.add(Data(nom))
        binding.myrecyclerView.layoutManager=LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        var adapter=MyAdapter(list)
        binding.myrecyclerView.adapter=adapter*/
        Toast.makeText(this,"pppppppppppppp",Toast.LENGTH_LONG).show()
    }
    fun Deletetache(){
        /*var aa=LayoutInflater.from(this)
        var v=aa.inflate(R.layout.ajouter,null)
        val adddialo=AlertDialog.Builder(this)
        adddialo.setView(v)

        adddialo.show()*/
        val intent=Intent(this,Methode::class.java)
        startActivity(intent)
    }

}