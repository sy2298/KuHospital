package com.example.ku_care.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R

class recycler_adapter(val items:ArrayList<recyclerdata>): RecyclerView.Adapter<recycler_adapter.ViewHolder>(){
    override fun onBindViewHolder(holder: recycler_adapter.ViewHolder, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.str1.text=items.get(position).str1.toString() //새로 문자열 추가하려면 아래 inner class ViewHolder에 변수하나 추가하고 여기도 처리해주세용
        holder.str2.text=items.get(position).str2.toString()
    }

    fun moveItem(pos1:Int, pos2:Int){
        //두개의 데이터 바꿈.
        val item1=items.get(pos1)
        //val item2=items.get(pos2)
        items.removeAt(pos1)
        items.add(pos2, item1)
        notifyItemMoved(pos1, pos2)
    }

    fun removeItem(pos:Int){
        items.removeAt(pos)
        notifyItemRemoved(pos)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v= LayoutInflater.from(p0.context).inflate(R.layout.main_navigation_recyclerview,p0,false)
        return ViewHolder(v) //row객체의 인스턴스를 viewholder에 전달.
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return items.size //저장된 배열의 item개수 반환
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class ViewHolder(itemView: View)
        :RecyclerView.ViewHolder(itemView)
    {
        var str1: TextView
        var str2: TextView
        init{
            str1=itemView.findViewById(R.id.str1)
            str2=itemView.findViewById(R.id.str2)
        }
    }


}