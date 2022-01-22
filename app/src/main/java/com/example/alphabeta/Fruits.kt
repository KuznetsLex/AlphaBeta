package com.example.alphabeta

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Fruits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)


        val peel = findViewById<ImageView>(R.id.peel)
        peel.setOnClickListener(){
            peel.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.peel_cut))
        }

        val pineapple = findViewById<ImageView>(R.id.pineapple)
        pineapple.setOnClickListener(){
            pineapple.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pineapple_cut))
        }

        val orange = findViewById<ImageView>(R.id.orange)
        orange.setOnClickListener(){
            orange.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.orange_cut))
        }

        val beet = findViewById<ImageView>(R.id.beet)
        beet.setOnClickListener(){
            beet.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.beet_cut))
        }


        //к букве
        val back = findViewById<ImageView>(R.id.back)
        back.setOnClickListener{
            val randomIntent = Intent(this, A::class.java)
            startActivity(randomIntent)
        }

    }



}


