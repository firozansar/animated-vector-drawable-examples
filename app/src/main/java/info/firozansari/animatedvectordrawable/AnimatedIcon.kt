package info.firozansari.animatedvectordrawable

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

/**
 * Created by firoz on 25/03/2017.
 */
internal class AnimatedIcon(icon: AnimatedVectorDrawableCompat, title: String) {
    var icon: AnimatedVectorDrawableCompat
    var title: String

    init {
        this.icon = icon
        this.title = title
    }

    fun getIcon(): AnimatedVectorDrawableCompat {
        return icon
    }

    fun setIcon(icon: AnimatedVectorDrawableCompat) {
        this.icon = icon
    }
}