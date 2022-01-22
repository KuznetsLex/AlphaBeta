package com.example.alphabeta


import java.util.*
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Locale
import com.bumptech.glide.Glide

class B : Activity() {
    var a = "space"
    var textView: TextView? = null
    private val REQ_CODE = 100
    companion object {
        const val DEFAULT_100_PERCENT = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        val REQ_CODE = 100
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //стирание


        //подсказка
        val tip = findViewById<ImageView>(R.id.tip)
        tip.setOnClickListener() {
            var resID = getResources().getIdentifier("a_letter", "raw", getPackageName())
            val mediaPlayer = MediaPlayer.create(this, resID)
            mediaPlayer.start()
        }

        //назад к алфавиту
        val abc = findViewById<ImageView>(R.id.arrow2)
        abc.setOnClickListener{
            val randomIntent = Intent(this, Alphabet::class.java)
            startActivity(randomIntent)
        }

        //к фруктам
        /*val forward = findViewById<ImageView>(R.id.imageView2)
        forward.setOnClickListener{
            val randomIntent = Intent(this, Fruits::class.java)
            startActivity(randomIntent)
        }*/




        //проверка чтения
        val speak = findViewById<ImageView>(R.id.imageView3)
        speak.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Говорите")
            try {
                startActivityForResult(intent, REQ_CODE)
            } catch (a: ActivityNotFoundException) {
                Toast.makeText(applicationContext,
                        "Просим прощения, ваше устройство не поддерживается",
                        Toast.LENGTH_SHORT).show()
            }
        }

        Glide.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/alphabeta-578df.appspot.com/o/common_tip.png?alt=media&token=7a2f76c5-baa1-4bb7-ab4f-212d817f3884").into(tip);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQ_CODE -> {
                if (resultCode == RESULT_OK && null != data) {
                    val result: ArrayList<String>? = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    a = result?.get(0).toString()
                    if (a == "а") {
                        var resID = getResources().getIdentifier("good", "raw", getPackageName())
                        val mediaPlayer = MediaPlayer.create(this, resID)
                        mediaPlayer.start()
                    } else{
                        var resID = getResources().getIdentifier("bad", "raw", getPackageName())
                        val mediaPlayer = MediaPlayer.create(this, resID)
                        mediaPlayer.start()
                    }
                }
            }
        }
    }
}