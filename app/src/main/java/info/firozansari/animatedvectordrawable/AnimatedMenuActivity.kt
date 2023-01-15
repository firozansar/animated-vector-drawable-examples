package info.firozansari.animatedvectordrawable

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Created by firoz on 01/04/2017.
 */
class AnimatedMenuActivity : AppCompatActivity() {
    private var menu: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animated_menu)
        title = "Anim Items"
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
//        val fab: FloatingActionButton = findViewById(R.id.fab).setOnClickListener(View.OnClickListener {
//            if (menu != null) {
//                for (i in 0 until menu!!.size()) {
//                    val drawable = menu!!.getItem(i).icon
//                    if (drawable is Animatable) {
//                        (drawable as Animatable).start()
//                    }
//                }
//            }
//        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val drawable = item.icon
        if (drawable is Animatable) {
            (drawable as Animatable).start()
        }
        return super.onOptionsItemSelected(item)
    }
}
