package com.example.ku_care.ui.reserve


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ku_care.R
import kotlinx.android.synthetic.main.reserve_main.*



class reserve_main :Fragment() {

    //private val regFragmentManager
   // var subFragment : subFragment = childFragmentManager.findFragmentById()
    //val regFragment = //getactivity?.supportFragmentManager
    lateinit var regFragment :FragmentManager ;//childFragmentManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.reserve_main, container, false)
        // init(view)

//        activity.supportFragmentManager
        regFragment = childFragmentManager
        regFragment.beginTransaction().add(R.id.reg_frame,register1()).commit()

        changeView(view)
        return view
    }

    fun init(view: View) {
        val layoutManager =
            LinearLayoutManager(this.requireActivity(), LinearLayoutManager.VERTICAL, false)

    }

    fun changeView( view:View) {
        lateinit var fragmentTransaction: FragmentTransaction
        var reserve_ap = view.findViewById<Button>(R.id.register_btn)
        var checkup_btn = view.findViewById<Button>(R.id.checkup_btn)
        val frameLayout = view.findViewById<FrameLayout>(R.id.reg_frame)
        reserve_ap.setOnClickListener {
            register_btn.setBackgroundResource(R.drawable.border)
            checkup_btn.setBackgroundColor(Color.WHITE)
            fragmentTransaction = regFragment.beginTransaction()
            frameLayout.removeAllViews()
            fragmentTransaction.replace(R.id.reg_frame, register2())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        checkup_btn.setOnClickListener {
            checkup_btn.setBackgroundResource(R.drawable.border)
            register_btn.setBackgroundColor(Color.WHITE)
            fragmentTransaction = regFragment.beginTransaction()
            frameLayout.removeAllViews()
            fragmentTransaction.replace(R.id.reg_frame, register1())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


    }
}
