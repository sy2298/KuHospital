package com.example.ku_care.ui.reserve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R
import kotlinx.android.synthetic.main.reserve_doc_appointment.*


class register2 :Fragment(){
    var departList = arrayListOf<department>(
        department("가정의학과", false),
        department("감염내과", false),
        department("건강의학과", false),
        department("내분비대사과", false),
        department("류마티스내과", false),
        department("마취통증의학과", false),
        department("방사선종양학과", false),
        department("병리과", false),
        department("비뇨의학과", false),
        department("산부인과", false),
        department("소화기내과", false),
        department("신경과", false),
        department("신경외과", false),
        department("안과", false),
        department("외과", false),
        department("이비인후-두경부외과", false)
    )

    lateinit var adapter : departAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragmentd
        val view = inflater.inflate(R.layout.reserve_doc_appointment, null)
        init(view)
        return view
    }


    fun init(view:View){
        val layoutManager = LinearLayoutManager(this.requireActivity(),LinearLayoutManager.VERTICAL,false)
        val dview = view.findViewById<RecyclerView>(R.id.dView)
        val dept_btn = view.findViewById<ImageButton>(R.id.dept_search)
        val clear_btn = view.findViewById<ImageButton>(R.id.dept_clear)
        val search_info=view.findViewById<EditText>(R.id.edit_dept)
        val srch_info=search_info.text.toString()
        dview.layoutManager = layoutManager
        adapter = departAdapter(this.activity,departList)
        dview.adapter = adapter
        dept_btn.setOnClickListener{
            val fragmentTransaction=fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.reg_frame2,register4()).commit()
            fragmentTransaction.addToBackStack(null)
//            fragmentTransaction.commit()
        }
//        dept_btn.setOnClickListener {
//            var departList2 = arrayListOf<department>()
//            var dept = edit_dept.text.toString()
//            var size = departList.size
//            for (i in 0..size-1){
//                if(dept.contains("감기")){
//                    if(departList[i].depart.toString()=="이비인후-두경부외과")
//                    departList2.add(departList[i])
//                }
//                else if(dept.contains("배")||dept.contains("소화")){
//                    if(departList[i].depart.toString()=="소화기내과")
//                        departList2.add(departList[i])
//                }
//                else if(dept.contains("머리")||dept.contains("두통")){
//                    if(departList[i].depart.toString()=="신경외과"||departList[i].depart.toString()=="신경과")
//                        departList2.add(departList[i])
//                }
//                else if(departList[i].depart.toString().contains(dept)) {
//                    departList2.add(departList[i])
//                }
//            }
//            adapter = departAdapter(this.requireActivity(),departList2)
//            dview.adapter = adapter
//            adapter.notifyDataSetChanged()
//        }
        clear_btn.setOnClickListener {
            edit_dept.text.clear()
            adapter = departAdapter(this.requireActivity(),departList)
            dview.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

}
