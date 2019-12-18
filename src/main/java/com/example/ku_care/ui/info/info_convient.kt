package com.example.ku_care.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R


class info_convient : Fragment(){
    lateinit var recycler_view : RecyclerView
    var dogList = arrayListOf<convenient_places>(
        convenient_places("[원내시설] 식당/카페", "restaurant",false),
        convenient_places("[원내시설] 편의시설", "hours",false),
        convenient_places("[원내시설] 기타시설", "house",false),
        convenient_places("[주변시설] 약국","medicine",false),
        convenient_places("[주변시설] 기타시설","store",false)

    )




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.info_convient, container, false)
        recycler_view = view.findViewById(R.id.mRecyclerView)

        val mAdapter=ConvenAdapter(this.requireContext(),dogList)
        recycler_view.adapter=mAdapter

        val lm= LinearLayoutManager(this.requireContext())
        recycler_view.layoutManager=lm
        recycler_view.setHasFixedSize(true)


        return view
    }

}