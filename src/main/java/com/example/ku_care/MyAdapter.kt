package com.example.ku_care

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ku_care.ui.info.info_main
import com.example.ku_care.ui.main.main_main
import com.example.ku_care.ui.myinfo.myinfo_main
import com.example.ku_care.ui.pay.pay_main
import com.example.ku_care.ui.reserve.reserve_main



class MyAdapter(fm: FragmentManager, val num:Int): FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return num
    }

    override fun getItem(position: Int): Fragment {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        when (position) {
            0 -> return main_main()
            1 -> return reserve_main()
            2 -> return myinfo_main()
            3 -> return pay_main()
            4 -> return info_main()
        }
        return reserve_main()
    }
}