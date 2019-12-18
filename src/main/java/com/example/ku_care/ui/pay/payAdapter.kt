package com.example.ku_care.ui.pay


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_care.R


class payAdapter(val items:ArrayList<paydata>)
    : RecyclerView.Adapter<payAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val v = LayoutInflater.from(p0.context).inflate(R.layout.card, p0, false)
        return  ViewHolder(v)
    }

    interface OnItemClickListener{
        fun OnItemClick(holder:ViewHolder, view:View, data: paydata, position: Int )
    }
    var itemClickListener : OnItemClickListener? = null


    override fun getItemCount(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        p0.pay_day.text=items.get(p1).pay_date
        p0.pay0.text=items.get(p1).pay0
        p0.pay1.text = items.get(p1).pay1+"원"
        p0.pay2.text = items.get(p1).pay2+"원"
        p0.pay3.text = items.get(p1).pay3+"원"
        p0.pay4.text = items.get(p1).pay4+"원"
        p0.paytype.text=items.get(p1).paytype
        // p0.paycheck.text=items.get(p1).paycheck
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var pay_day:TextView
        var pay0: TextView
        var pay1: TextView
        var pay2: TextView
        var pay3: TextView
        var pay4: TextView
        var paycheck: LinearLayout
        var paytype: TextView

        init {
            pay_day=itemView.findViewById((R.id.pay_day))
            pay0 = itemView.findViewById(R.id.pay0)
            pay1 = itemView.findViewById(R.id.pay1)
            pay2 = itemView.findViewById(R.id.pay2)
            pay3 = itemView.findViewById(R.id.pay3)
            pay4 = itemView.findViewById(R.id.pay4)
            paycheck = itemView.findViewById(R.id.paytemps)
            paytype = itemView.findViewById(R.id.paytype)
            itemView.setOnClickListener {
                val position = adapterPosition
                itemClickListener?.OnItemClick(this, it, items[position], position)
                if (paytype.text.toString() == "1") {
                    paycheck.setBackgroundColor(Color.parseColor("#E3F2FD"));//#FFD8D8E9////#FFEAF2FA"#FFDEE4F1
                    // }
                }
            }

        }

    }}

/*package com.example.ku_care.ui.pay


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.ku_care.R

class payAdapter(context: Context, val resource:Int, var list:ArrayList<pay>)
    :ArrayAdapter<pay>(context,resource, list)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        var v:View?=convertView
        if(v==null){
            //처음, view가 생성안되어있음
            val vi=context.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater//layout객체 획득.
            v=vi.inflate(R.layout.card,null)
        }
        val p=list.get(position)
        v!!.findViewById<TextView>(R.id.pay1).text=p.pay1
        v!!.findViewById<TextView>(R.id.pay2).text=p.pay2
        v!!.findViewById<TextView>(R.id.pay3).text=p.pay3


        return v
    }


}*/
