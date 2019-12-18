package com.example.ku_care

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.AttributeSet
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity

class Login_Popup :AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.login_layout)

        var login_maintain = findViewById<CheckBox>(R.id.login_maintain)
        //login_maintain.setBackgroundResource(R.drawable.login_box)
        //login_maintain.checked
        var login_pw = findViewById<EditText>(R.id.login_pw)
        login_pw.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        login_maintain.setOnClickListener {
            if(login_maintain.isChecked){
            }
            else{

            }
        }
        var login_login = findViewById<Button>(R.id.login_login)
        login_login.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }




}