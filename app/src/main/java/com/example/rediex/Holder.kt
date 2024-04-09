package com.example.rediex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Holder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holder)

        val name : EditText = findViewById(R.id.editTextText)
        val phone : EditText = findViewById(R.id.editTextText2)
        val emailCont : TextInputLayout = findViewById(R.id.editTextText3)
        val email : TextInputEditText = findViewById(R.id.email)
        val passCont : TextInputLayout = findViewById(R.id.editTextText4)
        val pass : TextInputEditText = findViewById(R.id.pass)
        val pass2Cont : TextInputLayout = findViewById(R.id.editTextText5)
        val pass2 : TextInputEditText = findViewById(R.id.pass2)
        val checkBox: CheckBox = findViewById(R.id.checkBox)
        val signUp : Button = findViewById(R.id.button3)
        val SignIn : TextView = findViewById(R.id.SignIn)
        val pdfHyper : TextView = findViewById(R.id.pdfHyper)

        var a =false
        var b =false
        var c =false
        val pattern = "[a-z]".toRegex()
        val pat = "\\d+".toRegex()

        email.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               if(Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()&&pattern.containsMatchIn(email.text.toString())&&pat.containsMatchIn(email.text.toString())){
                   emailCont.helperText =""
                   a=true
               }else{ emailCont.helperText ="это не похоже на почту"
                   a=false}
            }
            override fun afterTextChanged(s: Editable?) {}
        })
        pass.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(pass.text.toString().length<5){
                    passCont.helperText="далжно быть не менее 5 символов"
                    b=false
                }else{passCont.helperText=""
                    b=true}
            }
            override fun afterTextChanged(s: Editable?) {}
        })
        pass2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(pass2.text.toString().length<5){
                    pass2Cont.helperText="далжно быть не менее 5 символов"
                    c=false
                }else{if(pass.text.toString()!=pass2.text.toString()){pass2Cont.helperText="пароли не совпадают"
                    c=false}else{pass2Cont.helperText=""
                    c=true}}
                if((name.text.toString()!=""&&phone.text.toString()!=""&&email.text.toString()!=""&&pass.text.toString()!=""
                            &&pass2.text.toString()!="") && checkBox.isChecked){
                    signUp.setBackgroundResource(R.drawable.button)
                } else{
                    signUp.setBackgroundResource(R.drawable.button_gray)
                } }
            override fun afterTextChanged(s: Editable?) {}
        })
        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if((name.text.toString()!=""&&phone.text.toString()!=""&&email.text.toString()!=""&&pass.text.toString()!=""
                        &&pass2.text.toString()!="") && checkBox.isChecked){
                signUp.setBackgroundResource(R.drawable.button)
            } else{
                signUp.setBackgroundResource(R.drawable.button_gray)
            }
        }
        signUp.setOnClickListener {
            if(a&&b&&c&&name.text.toString()!=""&&phone.text.toString()!=""&&email.text.toString()!=""&&pass.text.toString()!=""
                &&pass2.text.toString()!=""){
                val intent = Intent(this, LogIn::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "не все данные введены корректно", Toast.LENGTH_SHORT).show()}
        }
        SignIn.setOnClickListener{
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
        pdfHyper.setOnClickListener{
            val intent = Intent(this, PdfActivity::class.java)
            startActivity(intent)
        }
    }
}