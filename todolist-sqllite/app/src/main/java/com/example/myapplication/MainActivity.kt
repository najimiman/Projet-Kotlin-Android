package com.example.myapplication

//import android.support.v7.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.SimpleAdapter
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Room
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text
import java.util.Observer


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var appdata:AppDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appdata = AppDataBase.getDatabase(this)
        binding.buttonadd.setOnClickListener {
            adddata()
        }
        binding.buttonsearch.setOnClickListener {
            readdata()
        }
    }
    //Log.d("tache", "title: ${tache.title}, descri: ${tache.description}")
    private fun readdata() {
        val tacheViewModel = appdata.tacheDao()
//        val tableLayout=binding.mytablelayout
//        val aa=appdata.tacheDao().getAll().observe(this, androidx.lifecycle.Observer { tacheList ->
//            for (tache in tacheList) {
//                val tacheTitle = tache.title
//                val tacheDescription = tache.description
//
//
//                val tableRow = TableRow(this)
//
//
//                val textView1 = TextView(this)
//                textView1.text = tacheTitle
//
//                val textView2 = TextView(this)
//                textView2.text = tacheDescription
//
//
//                tableRow.addView(textView1)
//                tableRow.addView(textView2)
//
//
//                tableLayout.addView(tableRow)
//            }
//        })
//        val arraym= arrayOf("iman","ilham","aya","iman","ilham","aya","iman","ilham","aya")
//        val aa=tacheViewModel.getAll().observe(this, androidx.lifecycle.Observer { tacheList ->for (tache in tacheList){
//            Log.d("tache", "title: ${tache.title}, descri: ${tache.description}")
//        } })
//        val listt= arrayOf(aa.toString())
//        val pp=aa.toString()
//        val myadapter=ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,pp)
//        binding.mylist.adapter=myadapter
//        Log.d(listt.toString(),"mmmm")
//            val titlee=findViewById<TextView>(R.id.textView1)
//            val descri=findViewById<TextView>(R.id.textView2)

//        tacheViewModel.getAll().observe(this, androidx.lifecycle.Observer { tacheList ->
//            for (tache in tacheList) {
//                Log.d("tache", "title: ${tache.title}, descri: ${tache.description}")
//            }
//            val myadapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, tacheList)
//            binding.mylist.adapter = myadapter
//        })
        tacheViewModel.getAll().observe(this, androidx.lifecycle.Observer { tacheList ->
            for (tache in tacheList) {
                Log.d("Tache", "title: ${tache.title}, description: ${tache.description}")
            }
            val myadapter=object : ArrayAdapter<Tache>(this,R.layout.itemlist,tacheList){
                override fun getView(position:Int,convertView: View?,parent:ViewGroup): View {
//                    val view=super.getView(position, convertView, parent)
                    var view = convertView
                    if (view == null) {
                        view = LayoutInflater.from(context).inflate(R.layout.itemlist, parent, false)
                    }
                    val item=getItem(position)
                    val titletextview=view!!.findViewById<TextView>(R.id.titleTextView)
                    val descriptextview=view!!.findViewById<TextView>(R.id.descriptionTextView)
                    titletextview.text=item?.title
                    descriptextview.text=item?.description
                    return view!!
                }
            }
            binding.mylist.adapter=myadapter
//            val myadapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, tacheList)
//            binding.mylist.adapter = myadapter
        })



    }

    /////////////////////////////////////////////////
    private fun adddata(){
        val title=binding.title.text.toString()
        val description=binding.desciption.text.toString()
        if(title.isNotEmpty() && description.isNotEmpty()){
            val tache=Tache(0,title,description)
            GlobalScope.launch (Dispatchers.IO ) {
                appdata.tacheDao().insert(tache)
            }
//            Log.d(tache.title,"title")
//            Log.d(tache.description,"description")


            binding.title.text.clear()
            binding.desciption.text.clear()
            Toast.makeText(this@MainActivity,"sucess",Toast.LENGTH_LONG).show()
        }
       else{
            Toast.makeText(this@MainActivity,"remplir tout",Toast.LENGTH_LONG).show()
        }
    }

    ////////////////////////////////////////////////////

    private fun readDatas(){

        val idt = binding.editTextTextPersonName.text.toString()

        if (idt.isNotEmpty()){

            lateinit var tache: Tache

            GlobalScope.launch {

                tache = appdata.tacheDao().findByRoll(idt.toInt())
                Log.d("Robin Data",tache.toString())
                displayData(tache)

            }

        }else Toast.makeText(this@MainActivity,"Please enter the data", Toast.LENGTH_SHORT).show()

    }
    private suspend fun displayData(tache: Tache){

        withContext(Dispatchers.Main){

//            binding.title.text = tache.title
//            binding.desciption.text = tache.description
//            binding.tvRollNo.text = student.rollNo.toString()
            Log.d(tache.title,"tache")
            Log.d(tache.description,"description")
        }

    }

}