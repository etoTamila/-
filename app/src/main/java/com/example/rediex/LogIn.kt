package com.example.rediex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val emailCont : TextInputLayout = findViewById(R.id.editTextText3)
        val email : TextInputEditText = findViewById(R.id.email)
        val passCont : TextInputLayout = findViewById(R.id.editTextText5)
        val pass : TextInputEditText = findViewById(R.id.pass)
        val forgot : TextView= findViewById(R.id.textView10)
        val logIn : Button = findViewById(R.id.LogIn)
        var a= false

        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
                    emailCont.helperText ="это не похоже на почту"
                    a=false
                }else{ emailCont.helperText =""
                    a=true}
            }
            override fun afterTextChanged(s: Editable?) {}
        })
         forgot.setOnClickListener{
            val intent = Intent(this, ForgotActivity::class.java)
             startActivity(intent)
         }
        pass.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (email.text.toString().isNotEmpty()&& pass.text.toString().isNotEmpty()){
                    logIn.setBackgroundResource(R.drawable.button)
                }else{logIn.setBackgroundResource(R.drawable.button_gray)}
            }
        })
            logIn.setOnClickListener {
                if(email.text.toString()=="a@a.a"&&pass.text.toString()=="12345"){
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "нет такого пользователя",Toast.LENGTH_SHORT).show()
                }
            }

        
    }
}