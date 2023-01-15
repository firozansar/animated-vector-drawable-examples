package info.firozansari.animatedvectordrawable

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    fun getDemos(): List<Demo> {
        val context = getApplication<Application>().applicationContext
        val demos = mutableListOf<Demo>()
        //demos.add(Demo(RotateActivity::class.java, context.getString(R.string.clock)))
        //demos.add(Demo(FillInHeartActivity::class.java, context.getString(R.string.fill_in_heart)))
        //demos.add(Demo(PlayResetActivity::class.java, context.getString(R.string.play_to_reset)))
        demos.add(Demo(AnimatedIconActivity::class.java, context.getString(R.string.animated_icon)))
        demos.add(Demo(AnimatedMenuActivity::class.java, context.getString(R.string.animated_menu)))
        return demos
    }
}