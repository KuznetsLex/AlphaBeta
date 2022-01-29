package com.example.alphabeta

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/*val name = nameEt.text.toString().trim()
editor.putString("NAME", name)
editor.putInt("AGE", min)
editor.putInt("EYES", eyes)
editor.apply()*/



class Open : AppCompatActivity(){
    var min = 20
    var eyes = 0
    override fun onCreate(savedInstanceState: Bundle?){


        super.onCreate(savedInstanceState)
        setContentView(R.layout.open)




        val sharedPreferenes = getSharedPreferences("Child", Context.MODE_PRIVATE)
        val editor = sharedPreferenes.edit()

        val nameEt = findViewById<EditText>(R.id.name_edit)
        val yes = findViewById<ImageView>(R.id.yes)
        val no = findViewById<ImageView>(R.id.no)
        val tte = findViewById<ImageView>(R.id.tte)
        val tel = findViewById<ImageView>(R.id.tel)
        val ttw = findViewById<ImageView>(R.id.ttw)
        val tth = findViewById<ImageView>(R.id.tth)
        val tfo = findViewById<ImageView>(R.id.tfo)
        val tfi = findViewById<ImageView>(R.id.tfi)
        val ts = findViewById<ImageView>(R.id.ts)
        val back4 = findViewById<ImageView>(R.id.back4)
        val start = findViewById<ImageView>(R.id.start)



        yes.setOnClickListener{
            editor.putInt("EYES", 1)
            editor.apply()

            toFifth(this)
        }

        no.setOnClickListener{
            editor.putInt("EYES", 0)
            editor.apply()

            toFifth(this)
        }
        tte.setOnClickListener{
            min=30
            editor.putInt("MIN", min)
            editor.apply()
            toFourth(this)
        }
        tel.setOnClickListener{
            min=25
            editor.putInt("MIN", min)
            editor.apply()
            toFourth(this)
        }
        ttw.setOnClickListener{
            min=25
            editor.putInt("MIN", min)
            editor.apply()
            toFourth(this)
        }
        tth.setOnClickListener{
            min=20
            editor.putInt("MIN", min)
            editor.apply()
            toFourth(this)
        }

        tfo.setOnClickListener{
            min=20
            editor.putInt("MIN", min)
            editor.apply()
            toFourth(this)
        }
        tfi.setOnClickListener{
            min=15
            editor.putInt("MIN", min)
            editor.apply()
            toFourth(this)
        }

        ts.setOnClickListener{
            min=15
            editor.putInt("MIN", min)
            editor.apply()
            toFourth(this)
        }



        back4.setOnClickListener{
            toFourth(this)
        }


        start.setOnClickListener{
            val randomIntent = Intent(this, Alphabet::class.java)
            startActivity(randomIntent)


           /* val timer = object: CountDownTimer(10000, 100) {
            override fun onTick(millisUntilFinished: Long)  {
                val TV = findViewById<TextView>(R.id.intro)
            }

            override fun onFinish() {
                finishAffinity()
            }
        }
            timer.start() */
        }





        /*val time = findViewById<ImageView>(R.id.time)   Чтоб проверить сохранение данных
        time.setOnClickListener{
            val name = sharedPreferenes.getString("NAME","")
            val min = sharedPreferenes.getInt("AGE",0)
            val experienced = sharedPreferenes.getInt("EYES",0)
            val TV = findViewById<TextView>(R.id.minutes)
            TV.text="Name: $name \nAge: $min \nExperience: $experienced"

        }*/







    }

    fun toFirst (view: View){
        val background = findViewById<ImageView>(R.id.background)
        //val alphabeta = findViewById<ImageView>(R.id.alphabeta)
        val create_profile = findViewById<ImageView>(R.id.create_profile)

        val intro = findViewById<TextView>(R.id.intro)
        val back1 = findViewById<ImageView>(R.id.back1)
        val next1 = findViewById<ImageView>(R.id.next1)
        val name_edit = findViewById<EditText>(R.id.name_edit)
        val name_view = findViewById<TextView>(R.id.name_view)
        val ptichka = findViewById<ImageView>(R.id.ptichka)
        val zvetochek = findViewById<ImageView>(R.id.zvetochek)
        //alphabeta.visibility= (View.VISIBLE)
        create_profile.visibility= (View.VISIBLE)
        background.visibility= (View.VISIBLE)
        intro.visibility= (View.GONE)
        back1.visibility= (View.GONE)
        next1.visibility= (View.GONE)
        ptichka.visibility= (View.GONE)
        name_edit.visibility= (View.GONE)
        name_view.visibility= (View.GONE)
        zvetochek.visibility= (View.GONE)
    }

    fun toSecond (view: View){
        val background = findViewById<ImageView>(R.id.background)
        //val alphabeta = findViewById<ImageView>(R.id.alphabeta)
        val create_profile = findViewById<ImageView>(R.id.create_profile)
        val intro = findViewById<TextView>(R.id.intro)
        val back1 = findViewById<ImageView>(R.id.back1)
        val next1 = findViewById<ImageView>(R.id.next1)
        val name_edit = findViewById<EditText>(R.id.name_edit)
        val name_view = findViewById<TextView>(R.id.name_view)

        val back2 = findViewById<ImageView>(R.id.back2)
        val age_view = findViewById<TextView>(R.id.age_view)
        val add_profile = findViewById<TextView>(R.id.add_profile)
        val ptichka = findViewById<ImageView>(R.id.ptichka)

        val ts = findViewById<ImageView>(R.id.ts)
        val tfi = findViewById<ImageView>(R.id.tfi)
        val tfo = findViewById<ImageView>(R.id.tfo)
        val tth = findViewById<ImageView>(R.id.tth)
        val ttw = findViewById<ImageView>(R.id.ttw)
        val tel = findViewById<ImageView>(R.id.tel)
        val tte = findViewById<ImageView>(R.id.tte)
        val zvetochek = findViewById<ImageView>(R.id.zvetochek)


        background.visibility= (View.GONE)
        //alphabeta.visibility= (View.GONE)
        create_profile.visibility= (View.GONE)

        intro.visibility= (View.GONE)
        back1.visibility= (View.VISIBLE)
        next1.visibility= (View.VISIBLE)
        name_edit.visibility= (View.VISIBLE)
        ptichka.visibility= (View.VISIBLE)

        name_view.visibility= (View.GONE)
        back2.visibility= (View.GONE)
        age_view.visibility= (View.GONE)
        add_profile.visibility= (View.GONE)

        ts.visibility= (View.GONE)
        tfi.visibility= (View.GONE)
        tfo.visibility= (View.GONE)
        tth.visibility= (View.GONE)
        ttw.visibility= (View.GONE)
        tel.visibility= (View.GONE)
        tte.visibility= (View.GONE)
        zvetochek.visibility= (View.GONE)
    }

    fun toThird (view: View){
        val intro = findViewById<TextView>(R.id.intro)
        val back1 = findViewById<ImageView>(R.id.back1)
        val next1 = findViewById<ImageView>(R.id.next1)
        val name_edit = findViewById<EditText>(R.id.name_edit)
        val name_view = findViewById<TextView>(R.id.name_view)
        val ptichka = findViewById<ImageView>(R.id.ptichka)

        val back2 = findViewById<ImageView>(R.id.back2)
        val age_view = findViewById<TextView>(R.id.age_view)
        val add_profile = findViewById<TextView>(R.id.add_profile)

        val ts = findViewById<ImageView>(R.id.ts)
        val tfi = findViewById<ImageView>(R.id.tfi)
        val tfo = findViewById<ImageView>(R.id.tfo)
        val tth = findViewById<ImageView>(R.id.tth)
        val ttw = findViewById<ImageView>(R.id.ttw)
        val tel = findViewById<ImageView>(R.id.tel)
        val tte = findViewById<ImageView>(R.id.tte)
        val zvetochek = findViewById<ImageView>(R.id.zvetochek)

        val yes = findViewById<ImageView>(R.id.yes)
        val back3 = findViewById<ImageView>(R.id.back3)
        val no = findViewById<ImageView>(R.id.no)
        val almost = findViewById<TextView>(R.id.almost)
        val eyes1 = findViewById<TextView>(R.id.eyes1)
        val eyes2 = findViewById<TextView>(R.id.eyes2)
        val bluewing =findViewById<ImageView>(R.id.bluewing)

        val sharedPreferenes = getSharedPreferences("Child", Context.MODE_PRIVATE)
        val editor = sharedPreferenes.edit()

        val name = name_edit.text.toString().trim()
        editor.putString("NAME", name)
        editor.apply()

        back1.visibility= (View.GONE)
        next1.visibility= (View.GONE)
        name_edit.visibility= (View.GONE)
        name_view.visibility= (View.GONE)
        ptichka.visibility= (View.GONE)

        intro.visibility= (View.GONE)
        back2.visibility= (View.VISIBLE)
        age_view.visibility= (View.GONE)
        add_profile.visibility= (View.GONE)

        ts.visibility= (View.VISIBLE)
        tfi.visibility= (View.VISIBLE)
        tfo.visibility= (View.VISIBLE)
        tth.visibility= (View.VISIBLE)
        ttw.visibility= (View.VISIBLE)
        tel.visibility= (View.VISIBLE)
        tte.visibility= (View.VISIBLE)
        zvetochek.visibility= (View.VISIBLE)

        yes.visibility= (View.GONE)
        back3.visibility= (View.GONE)
        no.visibility= (View.GONE)
        almost.visibility= (View.GONE)
        eyes1.visibility= (View.GONE)
        eyes2.visibility= (View.GONE)
        bluewing.visibility= (View.GONE)
    }

    fun toFourth (view: Open){
        val back2 = findViewById<ImageView>(R.id.back2)
        val age_view = findViewById<TextView>(R.id.age_view)
        val add_profile = findViewById<TextView>(R.id.add_profile)

        val intro = findViewById<TextView>(R.id.intro)
        val ts = findViewById<ImageView>(R.id.ts)
        val tfi = findViewById<ImageView>(R.id.tfi)
        val tfo = findViewById<ImageView>(R.id.tfo)
        val tth = findViewById<ImageView>(R.id.tth)
        val ttw = findViewById<ImageView>(R.id.ttw)
        val tel = findViewById<ImageView>(R.id.tel)
        val tte = findViewById<ImageView>(R.id.tte)
        val zvetochek = findViewById<ImageView>(R.id.zvetochek)

        val yes = findViewById<ImageView>(R.id.yes)
        val back3 = findViewById<ImageView>(R.id.back3)
        val no = findViewById<ImageView>(R.id.no)
        val almost = findViewById<TextView>(R.id.almost)
        val eyes1 = findViewById<TextView>(R.id.eyes1)
        val eyes2 = findViewById<TextView>(R.id.eyes2)
        val bluewing =findViewById<ImageView>(R.id.bluewing)

        val back4 = findViewById<ImageView>(R.id.back4)
        val start_view = findViewById<TextView>(R.id.start_view)
        val recommend = findViewById<TextView>(R.id.recommend)
        val minutes = findViewById<TextView>(R.id.minutes)
        val start = findViewById<ImageView>(R.id.start)
        val sovafon = findViewById<ImageView>(R.id.sovafon)
        val sova = findViewById<ImageView>(R.id.sova)

        back2.visibility= (View.GONE)
        age_view.visibility= (View.GONE)
        add_profile.visibility= (View.GONE)

        intro.visibility= (View.GONE)
        ts.visibility= (View.GONE)
        tfi.visibility= (View.GONE)
        tfo.visibility= (View.GONE)
        tth.visibility= (View.GONE)
        ttw.visibility= (View.GONE)
        tel.visibility= (View.GONE)
        tte.visibility= (View.GONE)
        zvetochek.visibility= (View.GONE)

        yes.visibility= (View.VISIBLE)
        back3.visibility= (View.VISIBLE)
        no.visibility= (View.VISIBLE)
        bluewing.visibility= (View.VISIBLE)
        almost.visibility= (View.GONE)
        eyes1.visibility= (View.GONE)
        eyes2.visibility= (View.GONE)

        back4.visibility= (View.GONE)
        start.visibility= (View.GONE)
        recommend.visibility= (View.GONE)
        minutes.visibility= (View.GONE)
        start_view.visibility= (View.GONE)
        sovafon.visibility= (View.GONE)
        sova.visibility= (View.GONE)
    }

    fun toFifth (view: Open){
        val yes = findViewById<ImageView>(R.id.yes)
        val back3 = findViewById<ImageView>(R.id.back3)
        val no = findViewById<ImageView>(R.id.no)
        val almost = findViewById<TextView>(R.id.almost)
        val eyes1 = findViewById<TextView>(R.id.eyes1)
        val eyes2 = findViewById<TextView>(R.id.eyes2)
        val bluewing =findViewById<ImageView>(R.id.bluewing)

        val back4 = findViewById<ImageView>(R.id.back4)
        val start_view = findViewById<TextView>(R.id.start_view)
        val start = findViewById<ImageView>(R.id.start)
        val time = findViewById<ImageView>(R.id.time)
        val recommend = findViewById<TextView>(R.id.recommend)
        val minutes = findViewById<TextView>(R.id.minutes)
        val sharedPreferenes = getSharedPreferences("Child", Context.MODE_PRIVATE)
        val sovafon = findViewById<ImageView>(R.id.sovafon)
        val sova = findViewById<ImageView>(R.id.sova)



        yes.visibility= (View.GONE)
        back3.visibility= (View.GONE)
        no.visibility= (View.GONE)
        almost.visibility= (View.GONE)
        eyes1.visibility= (View.GONE)
        bluewing.visibility= (View.GONE)

        back4.visibility= (View.VISIBLE)
        start.visibility= (View.VISIBLE)
        start_view.visibility= (View.GONE)
        recommend.visibility= (View.GONE)
        minutes.visibility= (View.VISIBLE)
        time.visibility= (View.VISIBLE)
        sovafon.visibility=(View.VISIBLE)
        sova.visibility=(View.VISIBLE)

        var min = sharedPreferenes.getInt("MIN",0)
        minutes.text="$min"
    }

}