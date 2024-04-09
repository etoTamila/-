package com.example.rediex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Verification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)
        val t1 : EditText = findViewById(R.id.t1)
        val t2 : EditText = findViewById(R.id.t2)
        val t3 : EditText = findViewById(R.id.t3)
        val t4 : EditText = findViewById(R.id.t4)
        val t5 : EditText = findViewById(R.id.t5)
        val t6 : EditText = findViewById(R.id.t6)
        val timerText : TextView = findViewById(R.id.timer)

        val send : Button = findViewById(R.id.Send)

        val timer = object : CountDownTimer(60000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                timerText.setText("resend after "+(millisUntilFinished/100).toString())
            }
            override fun onFinish() { finish()}
        }
        timer.start()

        send.setOnClickListener {
            if (t1.text.toString()=="0"&&t2.text.toString()=="0"&&t3.text.toString()=="0"&&t4.text.toString()=="0"&&t5.text.toString()=="0"&&t6.text.toString()=="0"){
                val intent = Intent(this, NewPass::class.java)
            }else{t1.setBackgroundResource(R.drawable.bedred)
                t2.setBackgroundResource(R.drawable.bedred)
                t3.setBackgroundResource(R.drawable.bedred)
                t4.setBackgroundResource(R.drawable.bedred)
                t5.setBackgroundResource(R.drawable.bedred)
                t6.setBackgroundResource(R.drawable.bedred)}
        }

        t6.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(t1.text.toString().isNotEmpty()&&t2.text.toString().isNotEmpty()&&t3.text.toString().isNotEmpty()&&t4.text.toString().isNotEmpty()&&t5.text.toString().isNotEmpty()&&t6.text.toString().isNotEmpty()){
                    send.setBackgroundResource(R.drawable.button)
                }else{send.setBackgroundResource(R.drawable.button_gray)}
            }
        })
        t5.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if(t1.text.toString().isNotEmpty()&&t2.text.toString().isNotEmpty()&&t3.text.toString().isNotEmpty()&&t4.text.toString().isNotEmpty()&&t5.text.toString().isNotEmpty()&&t6.text.toString().isNotEmpty()){
                    send.setBackgroundResource(R.drawable.button)
                }else{send.setBackgroundResource(R.drawable.button_gray)}
            }
        })

    }
}