package com.example.ku_care.ui.myinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R


class  myinfo_medical_history_adapter (val items:ArrayList<reserve_data>): RecyclerView.Adapter<myinfo_medical_history_adapter.ViewHolder>(){

    val limit:Int = 3
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): myinfo_medical_history_adapter.ViewHolder {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return  ViewHolder(v)

    }

    override fun getItemCount(): Int {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        if(items.size>limit){
            return limit
        }else {
            return items.size
        }

    }

    override fun onBindViewHolder( holder: myinfo_medical_history_adapter.ViewHolder,position: Int ) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class ViewHolder(itemView: View)
        :RecyclerView.ViewHolder(itemView)
    {

  /*      var str1: TextView
        var str2: TextView
        init{
            str1=itemView.findViewById(R.id.str1)
            str2=itemView.findViewById(R.id.str2)
        }*/



    }
}