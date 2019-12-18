package com.example.ku_care.ui.reserve


import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class registertime : Fragment() {

    lateinit var adapter: registimeadapt2
    var timetypenow=1
    var timenow = ""
    var timedate=""
    var timelist2 = arrayListOf<String>("19:30", "10:05","11:30","13:00")
    var timelist3 = arrayListOf<String>("10:30", "11:05")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registertime, container, false)
        init(view, container)
        return view
    }

    fun init(view: View, container: ViewGroup?) {


        val layoutManager = GridLayoutManager(this.requireActivity(), 3)
        //LinearLayoutManager(this.requireActivity(),LinearLayoutManager.VERTICAL,false)
        val dview = view!!.findViewById<RecyclerView>(R.id.time_recycler)
        dview.layoutManager = layoutManager
        adapter = registimeadapt2(timelist3)
        dview.adapter = adapter


        val check_date = view!!.findViewById<LinearLayout>(R.id.date_line)
        val date = view.findViewById<TextView>(R.id.date_pick)
        val zonedToday = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toLocalDate()
        val zonedFormattedToday =
            zonedToday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))
        val c = Calendar.getInstance()
        var register_year = c.get(Calendar.YEAR)
        var register_month = c.get(Calendar.MONTH)
        var register_dayOfWeek = c.get(Calendar.DAY_OF_MONTH)
        val day = (register_month + 1).toString() + "." + register_dayOfWeek.toString()
        date.text = day
        check_date.setOnClickListener {
            val build = AlertDialog.Builder(this.requireContext(), R.style.MyDatePickerDialogStyle)
            val dialogView = layoutInflater.inflate(R.layout.date_picker, null)
            val dpd = dialogView.findViewById<DatePicker>(R.id.calendar)
            c.add(Calendar.DATE, +10)
            dpd.minDate = c.timeInMillis
            c.add(Calendar.DATE, +10)
            dpd.maxDate = c.timeInMillis
            c.add(Calendar.DATE, -20)
            dpd.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
                register_year = year
                register_month = monthOfYear
                register_dayOfWeek = dayOfMonth
                //Toast.makeText(this.context, "결제ds", Toast.LENGTH_SHORT).show()
                if (timetypenow==1){
                    timetypenow=2
                    timelist3.add("19:30")

                }
                else if(timetypenow==2){
                    timetypenow=3
                    timelist3.add("10:05")
                }
                else if(timetypenow==3) {
                    timetypenow=4
                    timelist3.add("11:30")
                }


                adapter.notifyDataSetChanged()
                //dview.adapter = adapter

            }
            build.setView(dialogView)
                .setPositiveButton("확인") { dialogInterface, i ->
                    date.text = ""
                    date.text =
                        (register_month + 1).toString() + "." + register_dayOfWeek.toString()
                }
                .show()
        }


        adapter.itemClickListener = object : registimeadapt2.OnItemClickListener {
            override fun OnItemClick(
                holder: registimeadapt2.ViewHolder,
                view: View,
                data: String,
                position: Int
            ) {
                timenow = data
                aa()
            }
        }

    }

    fun aa(){

        val build = AlertDialog.Builder(this.requireContext()) //
        val dialogView = layoutInflater.inflate(R.layout.dialog, null)
        val dialogText = dialogView.findViewById<TextView>(R.id.dialog)
        dialogText.text = "정형외과 이석하"+ "\n예약 시간 : "+timenow + "\n예약 신청 완료되었습니다.\n\n* 병원의 확인 후, 예약이 확정됩니다.\n* 예약 확정시 문자로 안내 드리겠습니다."
        build.setView(dialogView)
            .setPositiveButton("확인") { dialogInterface, i ->

                //paylist.add(paydata("2019년 6월 11일","주차", "0", "0", "2200", "2200", "1"))
                //adapter.notifyDataSetChanged()
            }
            .show()


        //Toast.makeText(this.context, "결제ds", Toast.LENGTH_SHORT).show()
    }

}

