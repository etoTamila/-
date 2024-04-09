package com.example.rediex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Resources.Theme
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate

class Person : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        val switch : Switch = findViewById(R.id.switch1)
        val home : ImageView = findViewById(R.id.home)
        val poisk : ImageView = findViewById(R.id.poisk)

        poisk.setOnClickListener{
            val intetn = Intent(this, Poisk::class.java)
            startActivity(intetn)
        }
        home.setOnClickListener {
            val itent= Intent(this, Home::class.java)
            startActivity(intent)
        }

        switch.setOnClickListener{
            if (switch.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)}
        }


    }
    private fun light(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
    private fun dark(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    private fun isState():Boolean{
        val sharedPreferences=getSharedPreferences("TemePrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("isDarkTheme", false)
    }
    private  fun saveState(isDarkTheme: Boolean){
        val sharedPreferences= getSharedPreferences("TemePrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isDarkTheme",isDarkTheme)
        editor.apply()
    }

}