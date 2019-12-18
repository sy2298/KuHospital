package com.example.ku_care.ui.reserve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ku_care.R

class register3 : Fragment() {
    var depart_name = ""
    lateinit var regFragment : FragmentManager;//childFragmentManager
    lateinit var fragmentTransaction: FragmentTransaction
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (arguments != null) {
            depart_name = arguments!!.getString("department").toString()
        }
        val view = inflater.inflate(R.layout.department_info, null)
        val depart = view.findViewById<TextView>(R.id.dept_name)
        val back = view.findViewById<ImageButton>(R.id.back_btn)
        back.setOnClickListener {
            regFragment = this.activity!!.supportFragmentManager
            fragmentTransaction = regFragment.beginTransaction()
            fragmentTransaction.replace(R.id.reg_frame, register2()).commit()
            fragmentTransaction.addToBackStack(null)
        }
        depart.text = depart_name
        return view
    }
}
