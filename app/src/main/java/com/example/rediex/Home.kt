package com.example.rediex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.rediex.dop.classProtucts
import com.example.rediex.dop.productAdapter

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val list : RecyclerView = findViewById(R.id.list)
        var item = ArrayList<classProtucts>()

        item.add(classProtucts(R.drawable.lipstick,"Помада от лореаль париж", "1299р."))
        item.add(classProtucts(R.drawable.mist,"Линейка мистов для тела", "8000р."))
        item.add(classProtucts(R.drawable.syoss,"Шампунь суос берите он норм", "5600р."))
        item.add(classProtucts(R.drawable.mist,"Линейка мистов для тела", "8000р."))
        item.add(classProtucts(R.drawable.mist,"Линейка мистов для тела", "8000р."))
        item.add(classProtucts(R.drawable.syoss,"Шампунь суос берите он норм", "5600р."))
        item.add(classProtucts(R.drawable.lipstick,"Помада от лореаль париж", "1299р."))
        item.add(classProtucts(R.drawable.mist,"Линейка мистов для тела", "8000р."))
        item.add(classProtucts(R.drawable.mist,"Линейка мистов для тела", "8000р."))
        item.add(classProtucts(R.drawable.syoss,"Шампунь суос берите он норм", "5600р."))
        item.add(classProtucts(R.drawable.lipstick,"Помада от лореаль париж", "1299р."))
        item.add(classProtucts(R.drawable.mist,"Линейка мистов для тела", "8000р."))

        list.adapter= productAdapter(item, this)

        val person : ImageView = findViewById(R.id.person)

        person.setOnClickListener{
            val intetn = Intent(this, Person::class.java)
            startActivity(intetn)
        }

        val poisk : ImageView = findViewById(R.id.poisk)

        poisk.setOnClickListener{
            val intetn = Intent(this, Poisk::class.java)
            startActivity(intetn)
        }
    }
}