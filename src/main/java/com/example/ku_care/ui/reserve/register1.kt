package com.example.ku_care.ui.reserve

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.ku_care.R
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*


class register1 : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.reserve_health_check,container,false)
        init(view,container)
        return view
    }
    fun init(view:View,container:ViewGroup?){
        val check_date = view!!.findViewById<LinearLayout>(R.id.date_line)
        val p_checkup = view!!.findViewById<RadioButton>(R.id.check00)
        val c_checkup = view!!.findViewById<RadioButton>(R.id.check01)
        val reg = view!!.findViewById<Button>(R.id.reg_btn)
        val edit_phone = view!!.findViewById<EditText>(R.id.edit_phone)
        val date = view.findViewById<TextView>(R.id.date_pick)
        var phone: String = ""
        var type:String=""
        var korDay = ""
        val zonedToday = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toLocalDate()
        val zonedFormattedToday = zonedToday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))
        val c = Calendar.getInstance()
        var register_year = c.get(Calendar.YEAR)
        var register_month = c.get(Calendar.MONTH)
        var register_dayOfWeek = c.get(Calendar.DAY_OF_MONTH)
        val day = (register_month+1).toString()+"."+register_dayOfWeek.toString()
        date.text = day
         check_date.setOnClickListener {
             val build = AlertDialog.Builder(this.requireContext(), R.style.MyDatePickerDialogStyle)
             val dialogView = layoutInflater.inflate(R.layout.date_picker, null)
             val dpd = dialogView.findViewById<DatePicker>(R.id.calendar)
             dpd.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
                 register_year = year
                 register_month = monthOfYear
                 register_dayOfWeek = dayOfMonth
             }
             build.setView(dialogView)
                 .setPositiveButton("확인") { dialogInterface, i ->
                     date.text=""
                     date.text = (register_month + 1).toString() + "." + register_dayOfWeek.toString()
                 }
                 .show()
         }
        reg.setOnClickListener {
            phone = edit_phone.text.toString()
            if (edit_phone.text.toString() == "")
                Toast.makeText(this.context, "전화번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            else if (p_checkup.isChecked == false && c_checkup.isChecked == false) Toast.makeText(
                this.context, "건강검진 종류를 선택해주세요",
                Toast.LENGTH_SHORT
            ).show()
            else {
                if(p_checkup.isChecked)type=p_checkup.text.toString()
                else if(c_checkup.isChecked)type=p_checkup.text.toString()
                val build = AlertDialog.Builder(this.requireContext())
                val dialogView = layoutInflater.inflate(R.layout.dialog, null)
                val dialogText = dialogView.findViewById<TextView>(R.id.dialog)
                val date = dialogView.findViewById<TextView>(R.id.date)
                dialogText.text=type+"이 예약이 되었습니다."
                date.text=" 예약일 | "+ register_year.toString()+"년 "+(register_month+1).toString()+"월 "+register_dayOfWeek.toString()+"일"
                build.setView(dialogView)
                    .setPositiveButton("확인") { dialogInterface, i -> }
                    .show()
            }
            }
        }
    }









