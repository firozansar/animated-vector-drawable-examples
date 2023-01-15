package info.firozansari.animatedvectordrawable

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import info.firozansari.animatedvectordrawable.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var floatingActionButton: FloatingActionButton? = null
    private var playToResetAnim: AnimatedVectorDrawableCompat? = null
    private var resetToPlayAnim: AnimatedVectorDrawableCompat? = null
    private var isShowingPlay = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.pathMorphExample.setOnClickListener { animate(it as ImageView) }
        binding.rotateImageExample.setOnClickListener { animate(it as ImageView) }
        binding.helpText.setOnClickListener {
            MainBottomSheet().show(supportFragmentManager, "MainBottomSheetTag")
        }

        fabsetup(binding)
    }

    private fun fabsetup(binding: ActivityMainBinding){
        floatingActionButton = binding.fab
        playToResetAnim =
            AnimatedVectorDrawableCompat.create(this, R.drawable.fab_play_to_reset_animated_vector)
        resetToPlayAnim =
            AnimatedVectorDrawableCompat.create(this, R.drawable.fab_reset_to_play_animated_vector)
        floatingActionButton?.setImageDrawable(playToResetAnim)
        floatingActionButton?.setOnClickListener { changeButtonIcon() }
    }

    private fun changeButtonIcon() {
        val currentDrawable: AnimatedVectorDrawableCompat? =
            if (isShowingPlay) playToResetAnim else resetToPlayAnim
        floatingActionButton?.setImageDrawable(currentDrawable)
        currentDrawable?.start()
        isShowingPlay = !isShowingPlay
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val drawable = item.icon
        if (drawable is Animatable) {
            (drawable as Animatable).start()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun animate(view: ImageView) {
        val drawable = view.drawable
        if (drawable is Animatable) {
            (drawable as Animatable).start()
        }
    }
}
