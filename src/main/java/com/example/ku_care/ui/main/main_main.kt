package com.example.ku_care.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ku_care.MyAdapter
import com.example.ku_care.R
import com.example.myapplication.MainActivity

class main_main:Fragment() {

    lateinit var regFragment : FragmentManager
    lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.main_main, container, false)
        button1(view)
        button2(view)
        button3(view)
        button4(view)
        button5(view)
        button6(view)
        return view
    }

    fun button1( view:View) {
        var adapter = MyAdapter(childFragmentManager, 7)
        var main_bt1 = view.findViewById<Button>(R.id.main_btn1)
        main_bt1.setOnClickListener {
            var bundle = Bundle()
            bundle.putInt("fragmentChange", 1)
            var intent = Intent(context, MainActivity::class.java)
            intent.putExtra("bundle", bundle)
            context!!.startActivity(intent)

        }
    }
    fun button2( view:View) {
        var adapter = MyAdapter(childFragmentManager, 7)
        var main_bt2 = view.findViewById<Button>(R.id.main_btn2)
        main_bt2.setOnClickListener {
            var bundle = Bundle()
            bundle.putInt("fragmentChange", 2)
            var intent = Intent(context, MainActivity::class.java)
            intent.putExtra("bundle", bundle)
            context!!.startActivity(intent)

        }
    }
    fun button3( view:View) {
        var adapter = MyAdapter(childFragmentManager, 7)
        var main_bt3 = view.findViewById<Button>(R.id.main_btn3)
        main_bt3.setOnClickListener {
            var bundle = Bundle()
            bundle.putInt("fragmentChange", 3)
            var intent = Intent(context, MainActivity::class.java)
            intent.putExtra("bundle", bundle)
            context!!.startActivity(intent)

        }
    }
    fun button4( view:View) {
        var adapter = MyAdapter(childFragmentManager, 7)
        var main_bt4 = view.findViewById<Button>(R.id.main_btn4)
        main_bt4.setOnClickListener {
            var bundle = Bundle()
            bundle.putInt("fragmentChange", 4)
            var intent = Intent(context, MainActivity::class.java)
            intent.putExtra("bundle", bundle)
            context!!.startActivity(intent)

        }
    }
        fun button5( view:View) {
            var adapter = MyAdapter(childFragmentManager, 7)
            var main_bt5 = view.findViewById<Button>(R.id.main_btn5)
            main_bt5.setOnClickListener {
                var bundle = Bundle()
                bundle.putInt("fragmentChange", 5)
                var intent = Intent(context, MainActivity::class.java)
                intent.putExtra("bundle", bundle)
                context!!.startActivity(intent)

            }
        }
            fun button6(view: View) {
                var adapter = MyAdapter(childFragmentManager, 7)
                var main_bt6 = view.findViewById<Button>(R.id.main_btn6)
                main_bt6.setOnClickListener {
                    var bundle = Bundle()
                    bundle.putInt("fragmentChange", 6)
                    var intent = Intent(context, MainActivity::class.java)
                    intent.putExtra("bundle", bundle)
                    context!!.startActivity(intent)

                }
            }


        }

