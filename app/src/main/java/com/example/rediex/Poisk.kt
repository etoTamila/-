package com.example.rediex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.rediex.dop.adapterKatalog
import com.example.rediex.dop.katalogClass

class Poisk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poisk)

        val person : ImageView = findViewById(R.id.person)
        val home : ImageView = findViewById(R.id.home)

        person.setOnClickListener{
            val intetn = Intent(this, Person::class.java)
            startActivity(intetn)
        }
        home.setOnClickListener{
            val intetn = Intent(this, Home::class.java)
            startActivity(intetn)
        }
        val list : RecyclerView = findViewById(R.id.list)
        val items = ArrayList<katalogClass>()

        items.add(katalogClass(R.drawable.rybash, "Блузки и рубашки"))
        items.add(katalogClass(R.drawable.plate, "Платья"))
        items.add(katalogClass(R.drawable.kostym, "Костюмы"))
        items.add(katalogClass(R.drawable.bryki, "Брюки"))
        items.add(katalogClass(R.drawable.verhnyyodezhda, "Верхняя одежда"))
        items.add(katalogClass(R.drawable.rybash, "Блузки и рубашки"))
        items.add(katalogClass(R.drawable.plate, "Платья"))
        items.add(katalogClass(R.drawable.kostym, "Костюмы"))
        items.add(katalogClass(R.drawable.bryki, "Брюки"))
        items.add(katalogClass(R.drawable.verhnyyodezhda, "Верхняя одежда"))

        list.adapter= adapterKatalog(items, this)
    }
}