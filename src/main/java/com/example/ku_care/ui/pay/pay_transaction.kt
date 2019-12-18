package com.example.ku_care.ui.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R


class pay_transaction : Fragment(){


    var paylist = arrayListOf<paydata>(
        paydata("2019년 4월 12일","가정의학과","20000","3000","400","23400","2"),
        paydata("2019년 4월 12일", "정형외과","40000","31220","2200","63230","2"),
        paydata( "2019년 4월 12일","내과","20000","3000","400","23400","2")
    )




    lateinit var adapter : payAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragmentd
        val view = inflater.inflate(R.layout.pay_transaction, null)
        init(view)
        return view
    }
    fun init(view: View){
        val layoutManager = LinearLayoutManager(this.requireActivity(),LinearLayoutManager.VERTICAL,false)
        val dview = view!!.findViewById<RecyclerView>(R.id.dView)
        dview.layoutManager = layoutManager
        adapter = payAdapter(paylist)
        dview.adapter=adapter



    }
}