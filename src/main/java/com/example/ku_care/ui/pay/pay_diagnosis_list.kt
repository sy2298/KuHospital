package com.example.ku_care.ui.pay

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R

class pay_diagnosis_list: Fragment() {
    var paytotal = 0
    var paylist = arrayListOf<paydata>(
        paydata("2019년 6월 11일","가정의학과", "20000", "3000", "400", "23400", "1")

    )

    interface pay_TransactionListener{
        fun pay_TransactionFrag(data1:paydata)
    }

    lateinit var adapter: payAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.pay_diagnosis_list, container, false)
        init(view, container)
        return view
    }

    fun init(view: View, container: ViewGroup?) {
        val paybtn = view!!.findViewById<Button>(R.id.paybtn)
        val carpaybtn=view!!.findViewById<Button>(R.id.carpaybtn)
        val layoutManager =
            LinearLayoutManager(this.requireActivity(), LinearLayoutManager.VERTICAL, false)
        val dview = view!!.findViewById<RecyclerView>(R.id.dView)
        dview.layoutManager = layoutManager
        adapter = payAdapter(paylist)
        dview.adapter = adapter

        adapter.itemClickListener = object : payAdapter.OnItemClickListener {
            override fun OnItemClick(
                holder: payAdapter.ViewHolder,
                view: View,
                data: paydata,
                position: Int
            ) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                paytotal = paytotal.toInt() + data.pay4.toInt()
                paybtn.setText(paytotal.toString()+"원 결제")
                paybtn.setBackgroundColor(Color.parseColor("#0D47A1"))
                //data.paycheck=!data.paycheck
                if (data.paytype == "1") {
                    holder.paycheck.setBackgroundColor(Color.LTGRAY)
                } else {
                    holder.paycheck.setBackgroundColor(Color.BLUE)
                }
            }

        }

        carpaybtn.setOnClickListener {
            val carpaytext=view!!.findViewById<EditText>(R.id.carpaytext)
            val carpayresult=view!!.findViewById<TextView>(R.id.carpayresult)
            //carpayresult.visibility=VISIBLE
            //carpayresult.setText("차량번호 "+carpaytext.text.toString()+"\n들어온 시간 : 2:30    나간 시간 : 4:13")

            val build = AlertDialog.Builder(this.requireContext())
            val dialogView = layoutInflater.inflate(R.layout.dialog1, null)
            val dialogText = dialogView.findViewById<TextView>(R.id.dialog)
            dialogText.text = "차량번호 "+carpaytext.text.toString()+"\n들어온 시간 : 2:30    나간 시간 : 4:13\n\n선택하시겠습니까?"
            build.setView(dialogView)
                .setPositiveButton("확인") { dialogInterface, i ->

                    paylist.add(paydata("2019년 6월 11일","주차", "0", "0", "2200", "2200", "1"))
                    adapter.notifyDataSetChanged()
                }
                .show()

        }

        paybtn.setOnClickListener {
            if (paytotal == 0)
                Toast.makeText(this.context, "결제대상을 선택해주세요", Toast.LENGTH_SHORT).show()
            else {

                //////////////////
                val build = AlertDialog.Builder(this.requireContext())
                val dialogView = layoutInflater.inflate(R.layout.dialog1, null)
                val dialogText = dialogView.findViewById<TextView>(R.id.dialog)
                dialogText.text = paytotal.toString() + "원이 결제됩니다."
                build.setView(dialogView)
                    .setPositiveButton("확인") { dialogInterface, i ->
                        //Toast.makeText(this.context, "결제ss선택해주세요", Toast.LENGTH_SHORT).show()
                        val intent = Intent(activity, pay_card_page_2::class.java)
                        intent.putExtra("cardpay", paytotal)
                        startActivity(intent)

                        /*val temp = pay_transaction()
                        var arg = Bundle()
                        arg.putSerializable("data1", paylist)
                        temp.arguments = arg
                        val transaction = fragmentManager?.beginTransaction()
                        transaction.replace(R.id.)
                        transaction?.commit()*/


                    }
                    .show()
            }
        }
    }
}

