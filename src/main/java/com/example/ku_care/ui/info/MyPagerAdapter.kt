package com.example.ku_care.ui.info

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter

class MyPagerAdapter(fm: FragmentManager) :  FragmentPagerAdapter(fm){



    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                info_map()
            }
            1 -> info_convient()
            else -> return info_phone()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "오시는길"
            1 -> "편의시설"
            else -> {
                return "전화번호안내"
            }
        }
    }

}