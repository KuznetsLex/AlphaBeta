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
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.common.model.RemoteModelManager
import com.google.mlkit.vision.digitalink.*


class X : Activity() {
    var a = "space"
    var textView: TextView? = null
    private val REQ_CODE = 100
    var lettera = "space"
    var counta = 0
    val alett: Char = 'X'
    lateinit var txtOutput: TextView
    lateinit var customDrawingSurface: CustomDrawingSurface
    lateinit var drawingView: DrawingView
    lateinit var btnClassify: ImageView
    lateinit var aletter:ImageView
    private lateinit var btnClear: ImageView
    lateinit var recognizer: DigitalInkRecognizer
    val remoteModelManager = RemoteModelManager.getInstance()
    var model: DigitalInkRecognitionModel? = null
    companion object {
        const val DEFAULT_100_PERCENT = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        val REQ_CODE = 100
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//проверка написания
        initializeRecognition()
        txtOutput = findViewById(R.id.txtOutput)
        customDrawingSurface = findViewById(R.id.customDrawingSurface)
        btnClassify = findViewById(R.id.btnClassify)
        //btnClassify.isEnabled = false
        btnClassify.setOnClickListener {
            var thisInk = customDrawingSurface.getInk()
            recognizer = DigitalInkRecognition.getClient(
                DigitalInkRecognizerOptions.builder(model!!).build()
            )
            recognizer.recognize(thisInk)
                .addOnSuccessListener { result: RecognitionResult ->
                    var outputString = ""
                    txtOutput.text = ""
                    for (candidate in result.candidates) {
                        outputString += candidate.text + ", "
                    }
                    txtOutput.text = outputString
                }
                .addOnFailureListener { e: Exception ->
                    Log.e("Digital Ink Test", "Error during recognition: $e")
                }

            lettera = txtOutput.text.toString()
            println(lettera)
            counta += 1
            if (txtOutput.text != ""){
                if ("x" in lettera.substringBefore(',')) {
                    var resID = getResources().getIdentifier("write_correct", "raw", getPackageName())
                    val mediaPlayer = MediaPlayer.create(this, resID)
                    mediaPlayer.start()
                } else {
                    var resID = getResources().getIdentifier("write_again", "raw", getPackageName())
                    val mediaPlayer = MediaPlayer.create(this, resID)
                    mediaPlayer.start()
                }
                val randomIntent = Intent(this, X::class.java)
                startActivity(randomIntent)
                txtOutput.text = ""

            }




        }


        //подсказка
        val tip = findViewById<ImageView>(R.id.tip)
        tip.setOnClickListener() {
            var resID = getResources().getIdentifier("x", "raw", getPackageName())
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
        val forward = findViewById<ImageView>(R.id.imageView2)
        forward.setOnClickListener{
            val randomIntent = Intent(this, Fruits::class.java)
            startActivity(randomIntent)
        }

        //контур свич
        val standardSwitch:Switch = findViewById(R.id.btnChange)

        aletter = findViewById(R.id.letterai)
        standardSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                standardSwitch.background=getResources().getDrawable(R.drawable.onv1)
                aletter.visibility = View.VISIBLE
            }else{
                standardSwitch.background=getResources().getDrawable(R.drawable.offv1)
                aletter.visibility = View.GONE
            }
        }



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

        val propis=findViewById<ImageView>(R.id.letterai)
        propis.setImageResource(R.drawable.bukva_x)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQ_CODE -> {
                if (resultCode == RESULT_OK && null != data) {
                    val result: ArrayList<String>? = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    a = result?.get(0).toString()
                    if ((a == "X") or (a == "x") or (a == "икс")) {
                        var resID = getResources().getIdentifier("good", "raw", getPackageName())
                        val mediaPlayer = MediaPlayer.create(this, resID)
                        mediaPlayer.start()
                    } else{
                        var resID = getResources().getIdentifier("x_again", "raw", getPackageName())
                        val mediaPlayer = MediaPlayer.create(this, resID)
                        mediaPlayer.start()
                    }
                }
            }
        }
    }
    fun initializeRecognition(){
        val modelIdentifier: DigitalInkRecognitionModelIdentifier? =
            DigitalInkRecognitionModelIdentifier.fromLanguageTag("en-US")

        model = DigitalInkRecognitionModel.builder(modelIdentifier!!).build()
        remoteModelManager.download(model!!, DownloadConditions.Builder().build()).addOnSuccessListener {
            Log.i("InkSample", "Model Downloaded")
            btnClassify.isEnabled = true
        }. addOnFailureListener {  e: Exception ->
            Log.e("InkSample", "Model failed $e")
        }
    }
}