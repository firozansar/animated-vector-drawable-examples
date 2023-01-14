package info.firozansari.animatedvectordrawable

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class CustomAdapter(private val context: Context, private val data: ArrayList<Demo>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_row, parent, false))
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {
        myViewHolder.textview.setText(data[position].title)
        myViewHolder.textview.setOnClickListener {
            val demo = data[position]
            context.startActivity(Intent(context, demo.activityClass))
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textview: TextView

        init {
            textview = itemView.findViewById<View>(R.id.txv_row) as TextView
        }
    }
}
