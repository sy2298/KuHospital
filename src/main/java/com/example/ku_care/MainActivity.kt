package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.ku_care.MyAdapter
import com.example.ku_care.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var tabLayer: TabLayout?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        init()


    }

    fun init(){
        var num = 0
        var intent = intent
        var data = intent.getBundleExtra("bundle")
        if(data!=null) {
            num = data.getInt("fragmentChange")
        }
        tabLayer = findViewById(R.id.layout_tab)
        tabLayer!!.addTab(tabLayer!!.newTab().setText("     홈     ").setIcon(R.drawable.home_icon))
        tabLayer!!.addTab(tabLayer!!.newTab().setText("     예약     ").setIcon(R.drawable.reserve_icon))
        tabLayer!!.addTab(tabLayer!!.newTab().setText("마이").setIcon(R.drawable.my_icon))
        tabLayer!!.addTab(tabLayer!!.newTab().setText("    결제    ").setIcon(R.drawable.pay))
        tabLayer!!.addTab(tabLayer!!.newTab().setText("   안내   ").setIcon(R.drawable.information))
        // 탭 4개 추가

        val adapter = MyAdapter(supportFragmentManager, tabLayer!!.tabCount)
        content.adapter = adapter
//        if(num==2){
//            tabLayer!!.getTabAt(1)?.select()
//            content.currentItem= tabLayer!!.selectedTabPosition
//            Toast.makeText(this,"hihi",Toast.LENGTH_SHORT).show()

        when(num){
            1 -> {
                tabLayer!!.getTabAt(2)?.select()
                content.currentItem= tabLayer!!.selectedTabPosition

            }
            2->{  tabLayer!!.getTabAt(4)?.select()
                content.currentItem= tabLayer!!.selectedTabPosition

            }
            3->{  tabLayer!!.getTabAt(1)?.select()
                content.currentItem= tabLayer!!.selectedTabPosition

            }
            4->{  tabLayer!!.getTabAt(3)?.select()
                content.currentItem= tabLayer!!.selectedTabPosition

            }
            5->{  tabLayer!!.getTabAt(3)?.select()
                content.currentItem= tabLayer!!.selectedTabPosition

            }
            6->{  tabLayer!!.getTabAt(3)?.select()
                content.currentItem= tabLayer!!.selectedTabPosition

            }
        }
        tabLayer!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {}
            override fun onTabUnselected(p0: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab) {
                Log.e("test", tab.position.toString() + " " + content.currentItem.toString())
                content.currentItem = tab.position
            }
        })

    }
}