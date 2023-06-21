package com.example.myapplication

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityMainBinding
import androidx.lifecycle.lifecycleScope

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    
    private lateinit var apiservice:Apitask
    private var progressDialog:ProgressDialog?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        apiservice=Url.gettask().create(Apitask::class.java)
        binding.buttonget.setOnClickListener {
            Log.d("mmmmmmmmmmmm","hhhhhhhh")
            gettaskId()
        }
    }
    private fun gettaskId() {
        lifecycleScope.launch{
            showLoading("Getting,please wait")
            val result=apiservice.gettaskbyID("3")
            if(result.isSuccessful){
                Log.e("mmmmm","gettaskID:${result.body()?.data}")
            }
            else{
                Log.e("not","gettaskID:${result.message()}")
            }
            progressDialog?.dismiss()
        }
    }
    private fun showLoading(msg:String){
        progressDialog= ProgressDialog.show(this,null,msg,true)
    }

}