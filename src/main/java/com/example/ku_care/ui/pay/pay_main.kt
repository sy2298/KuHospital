package com.example.ku_care.ui.pay

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ku_care.R
import kotlinx.android.synthetic.main.card.*
import kotlinx.android.synthetic.main.pay_main.*


class pay_main : Fragment() {

    lateinit var cardFragment: FragmentManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var view = inflater.inflate(R.layout.pay_main, null)
        cardFragment = childFragmentManager
        cardFragment.beginTransaction().add(R.id.pay_frame,pay_diagnosis_list()).commit()

        changeView(view)


        return view
    }


    fun changeView(view: View) {

        var pay_register_btn = view.findViewById<Button>(R.id.pay_register_btn)
        var pay_btn = view.findViewById<Button>(R.id.pay_btn)

        lateinit var fragmentTransaction: FragmentTransaction

        pay_register_btn.setOnClickListener {
            pay_register_btn.setBackgroundResource(R.drawable.border)
            pay_register_btn.setBackgroundColor(Color.WHITE)
            fragmentTransaction = cardFragment.beginTransaction()
            fragmentTransaction.replace(R.id.pay_frame, pay_transaction())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        pay_btn.setOnClickListener {
            pay_btn.setBackgroundResource(R.drawable.border)
            pay_btn.setBackgroundColor(Color.WHITE)
            fragmentTransaction = cardFragment.beginTransaction()
            fragmentTransaction.replace(R.id.pay_frame, pay_diagnosis_list())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


    }
}