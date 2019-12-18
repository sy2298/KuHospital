package com.example.ku_care.ui.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ku_care.R

class pay_card:Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pay_card, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val intent = activity!!.intent
            if (intent != null) {
                val paycard_ = intent.getIntExtra("paycard", -1)
                if (paycard_ != -1) {
                    val setpay=activity!!.findViewById<TextView>(R.id.paycard)
                    setpay.text=paycard_.toString()+"원 결제"
                }
            }
        }
    }
}


