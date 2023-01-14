package info.firozansari.animatedvectordrawable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import java.util.ArrayList

/**
 * Created by firoz on 19/03/2017.
 */
class AnimatedIconActivity : AppCompatActivity() {
    private val animatedIcons = ArrayList<AnimatedIcon>()
    private var mAdapter: IconAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animated_icon)

        // Init and Setup RecyclerView
        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.layoutManager = GridLayoutManager(this@AnimatedIconActivity, 2)
        //animator not yet working
        recyclerView.itemAnimator = DefaultItemAnimator()
        mAdapter = IconAdapter()
        //recyclerView.setAdapter(mAdapter)
    }

    override fun onResume() {
        super.onResume()
        val avd1: AnimatedVectorDrawableCompat? =
            AnimatedVectorDrawableCompat.create(this@AnimatedIconActivity, R.drawable.anim_android)
        val avd2: AnimatedVectorDrawableCompat? =
            AnimatedVectorDrawableCompat.create(this@AnimatedIconActivity, R.drawable.anim_blutooth)
        val icon1 = avd1?.let { AnimatedIcon(it, getString(R.string.android_icon)) }
        val icon2 = avd2?.let { AnimatedIcon(it, getString(R.string.bluetooth_icon)) }
        icon1?.let { animatedIcons.add(it) }
        icon2?.let { animatedIcons.add(it) }
        mAdapter?.setAnimatedIcons(animatedIcons)
    }
}
