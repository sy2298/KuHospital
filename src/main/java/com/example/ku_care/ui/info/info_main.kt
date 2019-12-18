package com.example.ku_care.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.ku_care.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.info_main.*

class info_main :Fragment(){

    lateinit var infoFragment : FragmentManager;//childFragmentManager
    lateinit var infoAdapter : PagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        infoFragment = childFragmentManager
        infoFragment.beginTransaction().add(R.id.info_viewpager, info_map()).commit()

        val view = inflater.inflate(R.layout.info_main, container, false)

        infoAdapter = MyPagerAdapter(infoFragment)
        val viewPager = view.findViewById<ViewPager>(R.id.info_viewpager)
        viewPager.adapter  = infoAdapter

        val info_tab = view.findViewById<TabLayout>(R.id.info_tab)
        info_tab.setupWithViewPager(viewPager)

        return view
    }
}