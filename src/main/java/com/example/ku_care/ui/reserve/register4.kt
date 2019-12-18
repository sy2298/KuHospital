package com.example.ku_care.ui.reserve

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ku_care.R
import kotlinx.android.synthetic.main.reserve_main.*

class register4 : Fragment() {
    lateinit var regFragment: FragmentManager
    lateinit var fragmentTransaction: FragmentTransaction

    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.reserve_waist,null)

        val profileButton=view.findViewById<Button>(R.id.d_profile)
        val reserveButton=view.findViewById<Button>(R.id.d_register)
        val countButton=view.findViewById<ImageButton>(R.id.count_btn)
        val frameLayout = view.findViewById<FrameLayout>(R.id.reg_frame)

        val waisttext1=view!!.findViewById<TextView>(R.id.waistdoc_info2)
        val waist1=SpannableString("디스크,노인성 척추질환,측만증 및 후만변형")
        waist1.setSpan(BackgroundColorSpan(Color.YELLOW),0,3,0)
        waisttext1.text=waist1

        val waisttext2=view!!.findViewById<TextView>(R.id.d_info2)
        val waist2=SpannableString("척추외상 및 질환(목,허리디스크,노인성 질환)")
        waist2.setSpan(BackgroundColorSpan(Color.YELLOW),12,17,0)
        waisttext2.text=waist2

        val waisttext3=view!!.findViewById<TextView>(R.id.d_info3)
        val waist3=SpannableString("허리디스크 수술전문, 정형외과 일반진료")
        waist3.setSpan(BackgroundColorSpan(Color.YELLOW),0,5,0)
        waisttext3.text=waist3

        val waisttext4=view!!.findViewById<TextView>(R.id.waistdoc4_info2)
        val waist4=SpannableString("정형외과 일반진료, 허리손상")
        waist4.setSpan(BackgroundColorSpan(Color.YELLOW),11,13,0)
        waisttext4.text=waist4

        val waisttext5=view!!.findViewById<TextView>(R.id.waistdoc5_info2)
        val waist5=SpannableString("허리재활치료,디스크 재활")
        waist5.setSpan(BackgroundColorSpan(Color.YELLOW),0,2,0)
        waist5.setSpan(BackgroundColorSpan(Color.YELLOW),7,10,0)
        waisttext5.text=waist5

        profileButton.setOnClickListener{
//            profileButton.setBackgroundColor(Color.parseColor("#0D47A1"))
//            profileButton.setTextColor(Color.parseColor("#FFFFFF"))
            val build=AlertDialog.Builder(this.requireContext())
            val dialogView=layoutInflater.inflate(R.layout.waistdoc_profile,null)
            val dialogText=dialogView.findViewById<TextView>(R.id.dialog)
            dialogText.text="1985 고려대학교 의과대학(의박사)\n2000 중앙대학교 의학대학원(의학박사)\n\n1997-1998 Miami University 연수\n2005-2009 건국대학교 정형외과 주임\n2007-2009 건국대학교병원 진료부원장\n\n대한정형외과학회 이사\n대한척추외과학회 감사"
            build.setView(dialogView).setPositiveButton("확인"){dialog: DialogInterface?, which: Int ->
//                profileButton.setBackgroundColor(Color.parseColor("#FFFFFF"))
//                profileButton.setTextColor(Color.parseColor("#000000"))
            }.show()
        }

        countButton.setOnClickListener{
            val build=AlertDialog.Builder(this.requireContext())
            val dialogView=layoutInflater.inflate(R.layout.waistdoc_reserve_count,null)
            val dialogText=dialogView.findViewById<TextView>(R.id.dialog)
            dialogText.text="2019/4\n2019/5/16 허리디스크 수술\n2019/08/22 디스크학회"
            build.setView(dialogView).setPositiveButton("확인"){dialog: DialogInterface?, which: Int ->    }.show()
        }


        reserveButton.setOnClickListener {
            regFragment = this.activity!!.supportFragmentManager
            fragmentTransaction = regFragment.beginTransaction()
            fragmentTransaction.replace(R.id.reg_frame, registertime())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


        return view
    }
}