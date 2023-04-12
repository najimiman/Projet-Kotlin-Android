package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var activeplayer=1
    var playe1=ArrayList<Int>()
    var playe2=ArrayList<Int>()
    var emptycells=ArrayList<Int>()
    var winner=-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun select(view: View) {
        val chois=view as Button
        var initialecell=0
        when(chois.id){
            R.id.button1->initialecell=1
            R.id.button2->initialecell=2
            R.id.button3->initialecell=3
            R.id.button4->initialecell=4
            R.id.button5->initialecell=5
            R.id.button6->initialecell=6
            R.id.button7->initialecell=7
            R.id.button8->initialecell=8
            R.id.button9->initialecell=9
        }
        Log.d("cell",initialecell.toString())
        Go(initialecell,chois)

    }

    fun Go(initialecell:Int,chois:Button){

        if(activeplayer==1){
            chois.setText("X")
            chois.setBackgroundResource(R.color.black)
            playe1.add(initialecell)
            activeplayer=2

        }
        else{
            chois.setText("O")
            chois.setBackgroundResource(R.color.teal_200)
            playe2.add(initialecell)
            activeplayer=1
        }
        chois.isEnabled=false
        Winner()
    }
    fun StartAgain(){
        val intent = Intent(this, MainActivity::class.java)
        // start your next activity
        startActivity(intent)
    }
    fun Winner(){

    if(playe1.contains(1)&& playe1.contains(2) &&playe1.contains(3)){
        winner=1
    }
    if(playe2.contains(1)&& playe2.contains(2) &&playe2.contains(3)){
        winner=2
    }
    if(playe2.contains(4)&& playe2.contains(5) &&playe2.contains(6)){
        winner=2
    }
    if(playe1.contains(4)&& playe1.contains(5) &&playe1.contains(6)){
        winner=1
    }
    if(playe2.contains(7)&& playe2.contains(8) &&playe2.contains(9)){
        winner=2
    }
    if(playe1.contains(7)&& playe1.contains(8) &&playe1.contains(9)){
        winner=1
    }
    if(playe1.contains(1)&& playe1.contains(4) &&playe1.contains(7)){
        winner=1
    }
    if(playe2.contains(1)&& playe2.contains(4) &&playe2.contains(7)){
        winner=2
    }
    if(playe1.contains(2)&& playe1.contains(5) &&playe1.contains(8)){
        winner=1
    }
    if(playe2.contains(2)&& playe2.contains(5) &&playe2.contains(8)){
        winner=2
    }
    if(playe1.contains(3)&& playe1.contains(6) &&playe1.contains(9)){
        winner=1
    }
    if(playe2.contains(3)&& playe2.contains(6) &&playe2.contains(9)){
        winner=2
    }
    if(playe1.contains(1)&& playe1.contains(5) &&playe1.contains(9)){
        winner=1
    }
    if(playe2.contains(1)&& playe2.contains(5) &&playe2.contains(9)){
        winner=2
    }
    if(playe1.contains(3)&& playe1.contains(5) &&playe1.contains(7)){
        winner=1
    }
    if(playe2.contains(3)&& playe2.contains(5) &&playe2.contains(7)){
        winner=2
    }
    if(winner !=-1){
        if(winner==1){
            //Toast.makeText(this,"player 1 is ganne",Toast.LENGTH_LONG).show()
            val builder = AlertDialog.Builder(this)
            //set title for alert dialog
            builder.setTitle("Gagner")
            //set message for alert dialog
            builder.setMessage("player 1 is ganne")
            builder.setCancelable(true)
            builder.setPositiveButton("start again"){dialogInterface, which ->
                //Toast.makeText(applicationContext,"clicked yes",Toast.LENGTH_LONG).show()
                finish()
                StartAgain()
            }
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                finish()
            }
            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()

        }
        else{
            //Toast.makeText(this,"player 2 is ganne",Toast.LENGTH_LONG).show()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Gagner")
            builder.setMessage("player 2 is ganne")
            builder.setCancelable(true)
            builder.setPositiveButton("again"){dialogInterface, which ->
                //Toast.makeText(applicationContext,"clicked yes",Toast.LENGTH_LONG).show()
                finish()
                StartAgain()

            }
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                finish()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }

}

    /*fun add(view: View) {
        val editText= findViewById<EditText>(R.id.nom)
        var nom=editText.text
        val textView2=findViewById<TextView>(R.id.textView2)
        textView2.setText(nom)

    }*/
}