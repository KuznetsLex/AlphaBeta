package com.example.alphabeta

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)


        val sharedPreferenes = getSharedPreferences("Child", Context.MODE_PRIVATE)
        val minutes = findViewById<TextView>(R.id.minutes)
        val min = sharedPreferenes.getInt("MIN",0)
        minutes.text="$min"
        age(this)


        var t = 0.19.toFloat()
        var f = 0.toFloat()
        val sw1 = findViewById<Switch>(R.id.switch1)
        val nightshift = findViewById<ImageView>(R.id.nightshift)
        sw1?.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked){
                sw1.background=getResources().getDrawable(R.drawable.on)
                nightshift.alpha=t
            }
            else{
                sw1.background=getResources().getDrawable(R.drawable.off)
                nightshift.alpha=f
            }
        }
    }



    fun plus(view: View) {
        val minutes = findViewById<TextView>(R.id.minutes)
        var text2 = findViewById<TextView>(R.id.age)
        var value = minutes.getText().toString().toInt()
        if (value<30) {
            value += 5
            minutes.text = "$value"
        }

        age(this)
    }


    fun minus(view: View) {
        val minutes = findViewById<TextView>(R.id.minutes)
        var text2 = findViewById<TextView>(R.id.age)
        var value = minutes.getText().toString().toInt()
        if (value>15) {
            value -= 5
            minutes.text = "$value"
        }

        age(this)
    }

    fun toAlphabet(view: View){
        val randomIntent = Intent(this, Alphabet::class.java)
        //костыльный таймер, исправить
        randomIntent.putExtra("timer","1")
        startActivity(randomIntent)
    }

    fun age(view: MainMenu){
        val minutes = findViewById<TextView>(R.id.minutes)
        var text2 = findViewById<TextView>(R.id.age)
        var value = minutes.getText().toString().toInt()
        if (value==15){
            text2.text = "6-7"
        }
        if (value==20){
            text2.text = "8-9"
        }
        if (value==25){
            text2.text = "10-11"
        }
        if (value==30){
            text2.text = "12+"
        }
    }
}


