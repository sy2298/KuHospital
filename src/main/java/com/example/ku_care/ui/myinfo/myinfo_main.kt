package com.example.ku_care.ui.myinfo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.Login_Popup
import com.example.ku_care.R


class myinfo_main: Fragment(){
    lateinit var cmonth:TextView
    var items = arrayListOf<diagnosis_data>(
        diagnosis_data("최우진 교수", "김건국", "2019/12/02 ","신경외과"," 척추 측만증이 예상되나\n환자의 추후 경과를 지켜봐야함")
    )
    var items2 = arrayListOf<prescription_data>(
        prescription_data("김경호 교수", "김건국", "2019/10/02 ","피부과"),
        prescription_data("이석하 교수", "김건국", "2019/12/20 ","정형외과"))
    var items3 = arrayListOf<diagnosis_data>(
            diagnosis_data("최우진 교수님", "김건국", "2019/12/02 ","신경외과"," 하루 2번 아침,저녁으로\n식후 30분 이내에 먹어야함")
    )

    lateinit var childFragment: FragmentManager
    lateinit var diagnosis_adapter : myinfo_main_diagnosis_adapter
    lateinit var prescription_adapter : myinfo_main_prescription_adapter
    lateinit var history_adapter : myinfo_main_diagnosis_adapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var view = inflater.inflate(com.example.ku_care.R.layout.myinfo_main, null)
        val ls= view.findViewById<LinearLayout>(com.example.ku_care.R.id.test_layout)
        //  val ls= view.findViewById<Button>(R.id.link_setting)
        init(view)
        linkSetting(view)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )



        /*     childFragment = childFragmentManager
             //cardFragment.beginTransaction().add(R.id.nav_myinfo, pay_diagnosis_list()).commit()

             changeView(view)
     */
        //    val ls= view.findViewById<ImageButton>(R.id.link_setting)
        //  ls.setBackgroundResource(R.drawable.myinfo_settingwheel)
        return view;
    }



    fun linkSetting(view:View){


        var link_setting = view.findViewById<Button>(com.example.ku_care.R.id.link_setting)

        link_setting.setOnClickListener{

            var intent = Intent(context, Login_Popup::class.java)//PopupWindow.class::Login_Popup)
            startActivityForResult(intent,1)

        }

    }

    fun changeView(view: View) {

        /*    var healthdata_btn = view.findViewById<Button>(R.id.healthdata_btn)
            var medical_history_btn = view.findViewById<Button>(R.id.medical_history_btn)

            lateinit var fragmentTransaction: FragmentTransaction

            medical_history_btn.setOnClickListener {
                medical_history_btn.setBackgroundResource(R.drawable.border)
                medical_history_btn.setBackgroundColor(Color.WHITE)
                fragmentTransaction = childFragment.beginTransaction()
                fragmentTransaction.replace(R.id.pay_frame, pay_transaction())
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
            healthdata_btn.setOnClickListener {
                healthdata_btn.setBackgroundResource(R.drawable.border)
                healthdata_btn.setBackgroundColor(Color.WHITE)
                fragmentTransaction = childFragment.beginTransaction()
                fragmentTransaction.replace(R.id.pay_frame, pay_diagnosis_list())
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }*/
    }


    fun init(view: View){
        val cal = view!!.findViewById<RecyclerView>(com.example.ku_care.R.id.calendar)
        cmonth = view!!.findViewById<TextView>(com.example.ku_care.R.id.current_month)
        cal.apply {
            layoutManager = GridLayoutManager(activity, Calendar.DAYS_OF_WEEK)
            adapter = CalendarAdapter(
                this@myinfo_main,
                cmonth.text.toString()
            )
        }
        val layoutManager = LinearLayoutManager(this.requireActivity(),LinearLayoutManager.VERTICAL,false)
        val diagnose_recycler = view!!.findViewById<RecyclerView>(com.example.ku_care.R.id.diagnose_recycler_layout)
        diagnose_recycler.layoutManager = layoutManager
        diagnosis_adapter = myinfo_main_diagnosis_adapter(items)
        diagnose_recycler.adapter=diagnosis_adapter

        val pre_layoutManager = LinearLayoutManager(this.requireActivity(),LinearLayoutManager.VERTICAL,false)
        val prescription_layout = view!!.findViewById<RecyclerView>(com.example.ku_care.R.id.prescription_recycler_layout)
        prescription_layout.layoutManager = pre_layoutManager
        prescription_adapter = myinfo_main_prescription_adapter(items2)
        prescription_layout.adapter=prescription_adapter

        val history_layoutManager = LinearLayoutManager(this.requireActivity(),LinearLayoutManager.VERTICAL,false)
        val history_layout = view!!.findViewById<RecyclerView>(R.id.history_recycler_layout)
        history_layout.layoutManager = history_layoutManager
        history_adapter = myinfo_main_diagnosis_adapter(items3)
        history_layout.adapter=history_adapter

    }
}
