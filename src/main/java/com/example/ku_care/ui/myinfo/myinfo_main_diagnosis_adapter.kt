package com.example.ku_care.ui.myinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R


class myinfo_main_diagnosis_adapter (val items:ArrayList<diagnosis_data>): RecyclerView.Adapter<myinfo_main_diagnosis_adapter.ViewHolder>() {

    val limit =3
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): myinfo_main_diagnosis_adapter.ViewHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myinfo_main_diagnosis_recycler, parent, false)
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

    override fun onBindViewHolder(holder: myinfo_main_diagnosis_adapter.ViewHolder, position: Int) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


        holder.doc_name.text  = items[position].doc_name
        holder.diagnose_department.text = items[position].diagnosis_department
        holder.diagnose_data.text  = items[position].diagnose_data
        holder.date.text  = items[position].date.toString()
        holder.patient_name.text  = items[position].patient_name
        holder.button.setOnClickListener {
            if(holder.button.text.toString() =="▽") {
                holder.linear_layout.visibility = View.VISIBLE
                holder.diagnose_data.visibility = View.VISIBLE
                holder.diagnose_content.visibility = View.VISIBLE
                holder.button.setText("△")
            }
            else{
                holder.linear_layout.visibility = View.GONE
                holder.diagnose_data.visibility = View.GONE
                holder.diagnose_content.visibility = View.GONE
                holder.button.text = "▽"
            }
        }


    }



    inner class ViewHolder(itemView: View)
        :RecyclerView.ViewHolder(itemView)
    {
        var doc_name:TextView
        var patient_name:TextView
        var date:TextView
        var button: Button
        var diagnose_data:TextView
        var diagnose_content:TextView
        var diagnose_department :TextView
        var linear_layout:LinearLayout
        //     var diagnose_professor:TextView

        init {
            doc_name = itemView.findViewById(R.id.diagnose_professor)
            patient_name = itemView.findViewById(R.id.diagnose_patient_name)
            date = itemView.findViewById(R.id.diagnose_date)
            button = itemView.findViewById(R.id.diagnose_link)
            diagnose_data =itemView.findViewById(R.id.diagnose_data)
            diagnose_content=itemView.findViewById(R.id. diagnose_content)
            diagnose_department = itemView.findViewById(R.id.diagnose_department)
            linear_layout=itemView.findViewById(R.id.linear)
            //  diagnose_professor = itemView.findViewById(R.id.diagnose_professor)




        }
    }


}
