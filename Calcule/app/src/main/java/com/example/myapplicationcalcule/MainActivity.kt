package com.example.myapplicationcalcule

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    var isNewOp=true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun event(view: View) {
        var b=findViewById<TextView>(R.id.textView)
        if(isNewOp){
            b.text=""
        }
        isNewOp=false
        var textview1:String=b.text.toString()

        val chois=view as Button
        when(chois.id){
            R.id.bu0->{ textview1 +="0"}
            R.id.bu1->{textview1 +="1"}
            R.id.bu2->{textview1+="2"}
            R.id.bu3->{textview1+="3"}
            R.id.bu4->{textview1+="4"}
            R.id.bu5->{textview1+="5"}
            R.id.bu6->{textview1+="6"}
            R.id.bu7->{textview1+="7"}
            R.id.bu8->{textview1+="8"}
            R.id.bu9->{textview1+="9"}
            R.id.butac->{textview1+="AC"}
            R.id.butdot->{textview1+="."}
        }

        b.setText(textview1)
    }

    /*fun exemple(view: View) {
        var textview1=findViewById<TextView>(R.id.textView)
        var textView11:String = textview1.text.toString()
    }*/
}