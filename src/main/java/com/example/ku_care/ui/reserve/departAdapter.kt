package com.example.ku_care.ui.reserve

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R


class departAdapter(val depart_activity: FragmentActivity?, val items:ArrayList<department>):RecyclerView.Adapter<departAdapter.ViewHolder>(){

    lateinit var regFragment : FragmentManager;//childFragmentManager
    lateinit var fragmentTransaction: FragmentTransaction
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val v = LayoutInflater.from(parent.context).inflate(R.layout.depart_items, parent, false)
        return  ViewHolder(v)
    }

    override fun getItemCount(): Int {
     //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.name.text = items.get(position).depart
            holder.button.setOnClickListener {
                val frameLayout = depart_activity!!.findViewById<FrameLayout>(R.id.reg_frame)
                val args = Bundle()
                val nextFragment = register3()
                args.putString("department", holder.name.text as String)
                nextFragment.arguments = args
                frameLayout.removeAllViews()
                regFragment = depart_activity.supportFragmentManager
                fragmentTransaction = regFragment.beginTransaction()
                fragmentTransaction.replace(R.id.reg_frame, nextFragment).commit()
                fragmentTransaction.addToBackStack(null)
//                fragmentTransaction.commit()
            }
        }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name:TextView
        var button:ImageButton
        init {
            name = itemView.findViewById(R.id.dname)
            button = itemView.findViewById(R.id.dbutton)
        }
    }
}


