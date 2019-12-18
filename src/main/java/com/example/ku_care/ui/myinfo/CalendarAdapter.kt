package com.example.ku_care.ui.myinfo

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R
import com.example.ku_care.ui.main.ViewHolderHelper
import org.w3c.dom.Text
import android.util.Log.d as d1


class CalendarAdapter(val main_main: Fragment,val cal:String) : RecyclerView.Adapter<ViewHolderHelper>() {

    val baseCalendar = Calendar()

    init {
        baseCalendar.initBaseCalendar {
            refreshView(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHelper {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dates, parent, false)
        return ViewHolderHelper(view)
    }

    override fun getItemCount(): Int {
        return Calendar.LOW_OF_CALENDAR * Calendar.DAYS_OF_WEEK
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolderHelper, position: Int) {
        if( baseCalendar.data[position].toString()=="2"||baseCalendar.data[position].toString()=="20"){
            holder.itemView.findViewById<TextView>(R.id.item_date).setTextColor(
                Color.parseColor("#FFF44336")
            )
        }
        else if (position % Calendar.DAYS_OF_WEEK == 0) holder.itemView.findViewById<TextView>(R.id.item_date).setTextColor(
            Color.parseColor("#ff1200")
        )
        else holder.itemView.findViewById<TextView>(R.id.item_date).setTextColor(
            Color.parseColor(
                "#676d6e"
            )
        )

        if (position < baseCalendar.prevMonthTailOffset || position >= baseCalendar.prevMonthTailOffset + baseCalendar.currentMonthMaxDate) {
            holder.itemView.findViewById<TextView>(R.id.item_date).alpha = 0f
        } else {
            holder.itemView.findViewById<TextView>(R.id.item_date).alpha = 1f
        }
        holder.itemView.findViewById<TextView>(R.id.item_date).text =
            baseCalendar.data[position].toString()
        var str = baseCalendar.data[position].toString()
        var getDate = cal.split("  ")
        var mon = (getDate[1].toInt() + 1)
        var month = ""
        var check = 0
        if (mon < 10) month = "0$mon"
        var date = getDate[0] + month
        holder.itemView.findViewById<TextView>(R.id.item_date).setOnClickListener {
            var datestr = ""
            datestr = holder.itemView.findViewById<TextView>(R.id.item_date).text.toString()
            if (date.length != 8) {
                datestr = "0$datestr"
                date = date + datestr
            }
        }
    }

    fun changeToPrevMonth() {
        baseCalendar.changeToPrevMonth {
            refreshView(it)
        }
    }

    fun changeToNextMonth() {
        baseCalendar.changeToNextMonth {
            refreshView(it)
        }
    }
    private fun refreshView(calendar: java.util.Calendar) {
        notifyDataSetChanged()

    }
    class CalendarViewHolder(inflater: LayoutInflater,parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_dates,parent,false)){

    }
}