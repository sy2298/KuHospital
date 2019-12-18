package com.example.ku_care.ui.reserve

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R


class registimeadapt2(val items:ArrayList<String>)
    : RecyclerView.Adapter<registimeadapt2.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val v = LayoutInflater.from(p0.context).inflate(R.layout.registertime_, p0, false)
        return  ViewHolder(v)
    }

    interface OnItemClickListener{
        fun OnItemClick(holder:ViewHolder, view:View, data: String, position: Int )
    }
    var itemClickListener : OnItemClickListener? = null


    override fun getItemCount(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        p0.time.text=items.get(p1).toString()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var time: Button

        init {
            time=itemView.findViewById(R.id.time)

            time.setOnClickListener {
                val position = adapterPosition
                itemClickListener?.OnItemClick(this, it, items[position], position)
                //time.setBackgroundColor(Color.parseColor("#E3F2FD"))

                }
            }

        }

    }