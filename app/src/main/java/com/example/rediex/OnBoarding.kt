package com.example.rediex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class OnBoarding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        val button : Button = findViewById(R.id.button)
        val image : ImageView = findViewById(R.id.imageView2)
        val image2 : ImageView = findViewById(R.id.image3)
        val image3 : ImageView = findViewById(R.id.image4)
        val text1 : TextView = findViewById(R.id.text1)
        val text12 : TextView = findViewById(R.id.text12)
        val text13 : TextView = findViewById(R.id.text13)
        val text2 : TextView = findViewById(R.id.text2)
        val text22 : TextView = findViewById(R.id.text22)
        val text23 : TextView = findViewById(R.id.text23)
        val buttonSign : Button = findViewById(R.id.button2)
        val podtext1 : TextView = findViewById(R.id.podtext1)
        val podtext2 : TextView = findViewById(R.id.podtext2)
        val inAnim = AnimationUtils.loadAnimation(this, R.anim.in_right)
        val outAnim = AnimationUtils.loadAnimation(this, R.anim.out_right)
        val buttonSkip : Button = findViewById(R.id.buttonskip)
        val button2 : Button = findViewById(R.id.button2)

        val arrayPhoto = arrayOf(R.drawable.photo1, R.drawable.photo2, R.drawable.photo3)
        val arrayText1 = arrayOf("Quick Delivery At Your Doorstep", "Flexible Payment", "eal-time Tracking")
        val arrayText2 = arrayOf("Enjoy quick pick-up and delivery to your destination", "Different modes of payment either before and after delivery without stress", "Track your packages/items from the comfort of your home till final destination")

        var i : Int = 1
        button.setOnClickListener {

                image.startAnimation(outAnim)
                image.setImageResource(arrayPhoto[i])
                image.startAnimation(inAnim)

            text1.startAnimation(outAnim)
            text1.setText(arrayText1[i])
            text1.startAnimation(inAnim)

            text2.startAnimation(outAnim)
            text2.setText(arrayText2[i])
            text2.startAnimation(inAnim)

            i += 1
            if(i==arrayPhoto.size){
                buttonSkip.visibility = View.INVISIBLE
                buttonSign.visibility = View.VISIBLE
                button.visibility = View.INVISIBLE
                podtext1.visibility = View.VISIBLE
                podtext2.visibility = View.VISIBLE
            }

        }

//            if (i==0){
//                image.startAnimation(outAnim)
//                image.visibility = View.INVISIBLE
//
//                image2.visibility = View.VISIBLE
//                image2.startAnimation(inAnim)
//
//
//                text1.startAnimation(outAnim)
//                text1.visibility= View.INVISIBLE
//                text12.startAnimation(inAnim)
//                text12.visibility= View.VISIBLE
//
//                text2.startAnimation(outAnim)
//                text2.visibility= View.INVISIBLE
//                text22.startAnimation(inAnim)
//                text22.visibility= View.VISIBLE
//
//                i=1
//            }else {
//                image2.startAnimation(outAnim)
//                image2.visibility = View.INVISIBLE
//                image3.visibility = View.VISIBLE
//                image3.startAnimation(inAnim)
//
//                text12.startAnimation(outAnim)
//                text12.visibility= View.INVISIBLE
//                text13.startAnimation(inAnim)
//                text13.visibility= View.VISIBLE
//
//                text22.startAnimation(outAnim)
//                text22.visibility= View.INVISIBLE
//                text23.startAnimation(inAnim)
//                text23.visibility= View.VISIBLE
//
//                buttonSkip.visibility = View.INVISIBLE
//                buttonSign.visibility = View.VISIBLE
//                button.visibility = View.INVISIBLE
//                podtext1.visibility = View.VISIBLE
//                podtext2.visibility = View.VISIBLE
//
//            }
//
//        }
        buttonSkip.setOnClickListener {
            val intent = Intent(this, Holder::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, Holder::class.java)
            startActivity(intent)
        }
        podtext2.setOnClickListener{
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
    }
}