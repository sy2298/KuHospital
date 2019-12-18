package com.example.ku_care.ui.info

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.ku_care.R
import java.io.File

class ConvenAdapter(val context: Context,val dogList: ArrayList<convenient_places>):
    RecyclerView.Adapter<ConvenAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view=LayoutInflater.from(context).inflate(R.layout.info_place_item,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(dogList[position],context)
    }


    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val dogPhoto = itemView?.findViewById<ImageView>(R.id.dogPhotoImg)
        val dogBreed = itemView?.findViewById<TextView>(R.id.dogBreedTv)
//        val dogButton =itemView?.findViewById<ImageButton>(R.id.doggyButton)

        fun bind (dog: convenient_places, context: Context) {
            /* dogPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
            이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
            if (dog.photo != "") {
                val resourceId = context.resources.getIdentifier(dog.photo, "drawable", context.packageName)
                dogPhoto?.setImageResource(resourceId)
            } else {
                dogPhoto?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            dogBreed?.text = dog.breed

        }
    }
}