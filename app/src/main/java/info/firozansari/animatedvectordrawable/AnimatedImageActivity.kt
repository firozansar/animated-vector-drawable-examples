package info.firozansari.animatedvectordrawable

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

abstract class AnimatedImageActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        imageView = findViewById<ImageView>(R.id.image)
        imageView?.setOnClickListener { animate() }
    }

    private fun animate() {
        val drawable = imageView!!.drawable
        if (drawable is Animatable) {
            (drawable as Animatable).start()
        }
    }

    protected abstract val layoutId: Int
}