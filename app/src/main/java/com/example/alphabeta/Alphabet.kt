package com.example.alphabeta

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.ContactsContract
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast



class Alphabet : AppCompatActivity() {
    //var radioButton = findViewById<View>(R.id.a)
    var flag : Any = "A"
    //var letter = findViewById<RadioButton>(R.id.a)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet)

        var intent = getIntent()
        var isTimer = intent.getStringExtra("timer")
        if (isTimer=="1"){
            val timer = object: CountDownTimer(10000, 100) {
                override fun onTick(millisUntilFinished: Long)  {
                    val TV = findViewById<TextView>(R.id.intro)
                }

                override fun onFinish() {
                    finishAffinity()
                }
            }
            //timer.start() Не запускать таймер пока


        }

    }

    fun takeOnA(view: View) {
        //var letter = findViewById<RadioButton>(R.id.a)
        //letter.setBackgroundResource(R.drawable.a)
        flag="A"
        var resID = getResources().getIdentifier("a", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()

    }

    fun takeOnB(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="B"
        var resID = getResources().getIdentifier("b", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnC(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="C"
        var resID = getResources().getIdentifier("c", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnD(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="D"
        var resID = getResources().getIdentifier("d", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnE(view: View) {
        //var letter = findViewById<RadioButton>(R.id.a)
        //letter.setBackgroundResource(R.drawable.a)
        flag="E"
        var resID = getResources().getIdentifier("e", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()

    }

    fun takeOnF(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="F"
        var resID = getResources().getIdentifier("f", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnG(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="G"
        var resID = getResources().getIdentifier("g", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnH(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="H"
        var resID = getResources().getIdentifier("h", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnI(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="I"
        var resID = getResources().getIdentifier("i", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnJ(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="J"
        var resID = getResources().getIdentifier("j", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnK(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="K"
        var resID = getResources().getIdentifier("k", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnL(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="L"
        var resID = getResources().getIdentifier("l", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnM(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="M"
        var resID = getResources().getIdentifier("m", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnN(view: View) {
        //var letter = findViewById<RadioButton>(R.id.b)
        //letter.setBackgroundResource(R.drawable.b)
        flag="N"
        var resID = getResources().getIdentifier("n", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()
    }

    fun takeOnO(view: View) {
        //var letter = findViewById<RadioButton>(R.id.a)
        //letter.setBackgroundResource(R.drawable.a)
        flag="O"
        var resID = getResources().getIdentifier("o", "raw", getPackageName())
        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()

    }



    fun know(view: View){
        val randomIntent = Intent("android.intent.action.$flag")
        startActivity(randomIntent)
    }

    fun toSettings(view: View){
        val randomIntent = Intent(this, MainMenu::class.java)
        startActivity(randomIntent)
    }
   /* fun checkButton(v: View?) {
        //var tag1 = "R.drawable.aa" as Int
        //radioButton.setBackgroundResource(R.drawable.a)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        var radioId: Int = radioGroup.getCheckedRadioButtonId()
        var radioButton = findViewById<View>(radioId)
        radioButton.setBackgroundResource(R.drawable.b)
    }*/
}




