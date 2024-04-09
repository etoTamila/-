package com.example.rediex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.parser.PdfTextExtractor
import org.w3c.dom.Text

class PdfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)

        val button : Button = findViewById(R.id.buttonEx)
        val pdfText : TextView = findViewById(R.id.pdfText)

        try {
            var text = ""
            val pdfReader : PdfReader = PdfReader("res/raw/pdffile.pdf")
            val n = pdfReader.numberOfPages
            for(i in 0 until n ){
                text="""
                    $text${
                        PdfTextExtractor.getTextFromPage(pdfReader, i+1).trim{it <=' '}
                    }
                """.trimIndent()
                pdfText.setText(text)
                pdfReader.close()
            }
        }catch (e: Exception){
            e.printStackTrace()
        }

        button.setOnClickListener { finish() }
    }
}