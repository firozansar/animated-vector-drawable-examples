package info.firozansari.animatedvectordrawable

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Created by firoz on 19/03/2017.
 */
class PlayResetActivity : AppCompatActivity() {
    private var playToResetAnim: AnimatedVectorDrawableCompat? = null
    private var resetToPlayAnim: AnimatedVectorDrawableCompat? = null
    private var isShowingPlay = true
    private var floatingActionButton: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playreset)
        playToResetAnim =
            AnimatedVectorDrawableCompat.create(this, R.drawable.fab_play_to_reset_animated_vector)
        resetToPlayAnim =
            AnimatedVectorDrawableCompat.create(this, R.drawable.fab_reset_to_play_animated_vector)
        floatingActionButton = findViewById(R.id.fab) as FloatingActionButton?
        floatingActionButton.setImageDrawable(playToResetAnim)
        floatingActionButton.setOnClickListener(View.OnClickListener { changeButtonIcon() })
    }

    private fun changeButtonIcon() {
        val currentDrawable: AnimatedVectorDrawableCompat =
            if (isShowingPlay) playToResetAnim else resetToPlayAnim
        floatingActionButton.setImageDrawable(currentDrawable)
        currentDrawable.start()
        isShowingPlay = !isShowingPlay
    }
}
