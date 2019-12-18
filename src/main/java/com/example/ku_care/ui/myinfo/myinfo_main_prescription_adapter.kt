package com.example.ku_care.ui.myinfo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R


class myinfo_main_prescription_adapter (val items:ArrayList<prescription_data>): RecyclerView.Adapter<myinfo_main_prescription_adapter.ViewHolder>() {
    val limit =3
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): myinfo_main_prescription_adapter.ViewHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myinfo_main_prescription, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if(items.size>limit){
            return limit
        }else {
            return items.size
        }



    }

    override fun onBindViewHolder(holder: myinfo_main_prescription_adapter.ViewHolder, position: Int) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

/*

        holder.doc_name.text  = items[position].doc_name
        holder.diagnose_department.text = items[position].diagnosis_department
        holder.diagnose_data.text  = items[position].
        holder.date.text  = items[position].date.toString()
        holder.patient_name.text  = items[position].patient_name


*/
       /* if(position%2 ==0){
            holder.layout.setBackgroundColor(Activity().resources.getColor(R.color.graygray))
        }else{

        }
*/

        holder.doc_name.text  = items[position].doc_name
        holder.patient_name.text = items[position].patient_name
        holder.prescription_depart.text  = items[position].prescription_depart
      //  holder.date.text  = items[position].date.toString()
        holder.prescription_date.text  = items[position].date


    }



    inner class ViewHolder(itemView: View)
        :RecyclerView.ViewHolder(itemView)
    {
       // var layout :LinearLayout
        var doc_name: TextView
        var patient_name: TextView
        var prescription_date: TextView
        var prescription_depart : TextView
        //     var diagnose_professor:TextView

        init {
            doc_name = itemView.findViewById(R.id.prescription_prof)
            patient_name = itemView.findViewById(R.id.prescription_patient_name)
            prescription_date = itemView.findViewById(R.id.prescription_date)
            prescription_depart = itemView.findViewById(R.id.prescription_department)
           // layout =itemView.findViewById(R.id.prescription_linear)
         //   diagnose_data =itemView.findViewById(R.id.diagnose_data) diagnose_department = itemView.findViewById(R.id.diagnose_department)
            //  diagnose_professor = itemView.findViewById(R.id.diagnose_professor)




        }
    }


}