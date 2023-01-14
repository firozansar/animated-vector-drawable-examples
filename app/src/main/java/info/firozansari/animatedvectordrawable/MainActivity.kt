package info.firozansari.animatedvectordrawable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var adapter: CustomAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val demos = ArrayList<Demo>()
        demos.add(Demo(this, ExampleActivity::class.java, R.string.example_from_documentation))
        demos.add(Demo(this, RotateActivity::class.java, R.string.clock))
        demos.add(Demo(this, PathMorphActivity::class.java, R.string.smiling_face))
        demos.add(Demo(this, FillInHeartActivity::class.java, R.string.fill_in_heart))
        demos.add(Demo(this, PlayResetActivity::class.java, R.string.play_to_reset))
        demos.add(Demo(this, AnimatedIconActivity::class.java, R.string.animated_icon))
        demos.add(Demo(this, AnimatedMenuActivity::class.java, R.string.animated_menu))
        recyclerView = findViewById(R.id.recycleView) as RecyclerView?
        adapter = CustomAdapter(this, demos)
        recyclerView.setAdapter(adapter)
        recyclerView.setLayoutManager(LinearLayoutManager(this)) // Vertical Orientation By Default
    }
}