package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle:ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val drawerlayout:DrawerLayout=binding.drawerlayout
        val navigationview:NavigationView=binding.navView
        toggle= ActionBarDrawerToggle(this,drawerlayout,R.string.open,R.string.close)
        drawerlayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->Toast.makeText(applicationContext,"home",Toast.LENGTH_LONG).show()
                R.id.message->Toast.makeText(applicationContext,"message",Toast.LENGTH_LONG).show()
                R.id.settings->Toast.makeText(applicationContext,"parametre",Toast.LENGTH_LONG).show()
                R.id.choix1->Toast.makeText(applicationContext,"choix1",Toast.LENGTH_LONG).show()

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}