package com.example.ku_care

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.logging.Handler

class IntroActivity :AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var imageview=findViewById<ImageView>(R.id.intro_hospital)
        //image.setImageResource(R.drawable.card1)
       // imageview.setImageDrawable(resources.getDrawable(R.drawable.card1,applicationContext.theme))
        setContentView(R.layout.intro_layout)
        //val handler = Handler()

        try{
            Thread.sleep(3000)
            val intent =  Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }catch(e:Exception){

        }

    }



    fun init(){


}


}