package info.firozansari.animatedvectordrawable

import android.graphics.drawable.Animatable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

/**
 * Created by firoz on 25/03/2017.
 */
internal class IconAdapter : RecyclerView.Adapter<IconAdapter.ViewHolder?>() {

    private val animatedIcons: MutableList<AnimatedIcon>? = ArrayList()

    fun setAnimatedIcons(animatedIcons: List<AnimatedIcon>) {
        this.animatedIcons!!.addAll(animatedIcons)
        this.notifyItemRangeInserted(0, animatedIcons.size - 1)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.row_icon, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.animatedIconView.setImageDrawable(animatedIcons!![i].icon)
        viewHolder.title.text = animatedIcons[i].title
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var animatedIconView: ImageView

        init {
            title = itemView.findViewById<View>(R.id.name) as TextView
            animatedIconView = itemView.findViewById<View>(R.id.icon) as ImageView
            animatedIconView.setOnClickListener {
                val animatable = animatedIconView.drawable as Animatable
                animatable.start()
            }
        }
    }

    override fun getItemCount(): Int {
        return animatedIcons?.size ?: 0
    }

    fun clear() {
        animatedIcons!!.clear()
    }
}
