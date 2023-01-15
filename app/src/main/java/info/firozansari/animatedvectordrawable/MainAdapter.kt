package info.firozansari.animatedvectordrawable

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import info.firozansari.animatedvectordrawable.databinding.ListItemRowBinding

class MainAdapter(private val data: List<Demo>, val itemClick: (Demo) -> Unit) :
    RecyclerView.Adapter<MainAdapter.ItemViewHolder?>() {

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, position: Int) {
        itemViewHolder.bindTo(data[position])
//        itemViewHolder.itemView.setOnClickListener()
//        itemViewHolder.textview.setOnClickListener {
//            val demo = data[position]
//            context.startActivity(Intent(context, demo.activityClass))
//        }

//        getItem(position)?.let { post ->
//            holder.bindTo(post)
//            holder.itemView.setOnClickListener { postClick(post) }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ListItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ItemViewHolder(private val binding: ListItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTo(demo: Demo) {
            with(demo) {
                binding.demoRow.text = title
            }
        }
    }

    private fun showBottomSheet(context: Context, data: String) {
        val bottomSheetFragment = MainBottomSheet()
        val bundle = Bundle()
        bundle.putString("key", data)
        bottomSheetFragment.arguments = bundle

        bottomSheetFragment.show(
            (context as AppCompatActivity).supportFragmentManager,
            "bottomSheetFragment"
        )
    }
}
