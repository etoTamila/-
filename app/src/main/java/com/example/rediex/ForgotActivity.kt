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
import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.parser.PdfTextExtractor

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        val emailCont : TextInputLayout = findViewById(R.id.editTextText3)
        val email : TextInputEditText = findViewById(R.id.email)
        val send : Button = findViewById(R.id.Send)

        val pat1 = "[a-z]".toRegex()
        val pat2 = "\\d+".toRegex()
        var a = false

        email.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()&&pat1.containsMatchIn(email.text.toString())&&pat2.containsMatchIn(email.text.toString())){
                    emailCont.helperText=""
                    a=true
                }else{
                    emailCont.helperText="Не правильная почта"
                    a=false
                }
            }
            override fun afterTextChanged(s: Editable?) {
                if (a){
                    send.setBackgroundResource(R.drawable.button)
                }else{send.setBackgroundResource(R.drawable.button_gray)}
            }
        })
        send.setOnClickListener {
            if (a){
                val intent = Intent(this, Verification::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Не верные данные", Toast.LENGTH_SHORT).show()
            }
        }

    }
}