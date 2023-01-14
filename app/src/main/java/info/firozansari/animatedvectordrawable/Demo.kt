package info.firozansari.animatedvectordrawable

import android.content.Context

/**
 * Created by firoz on 19/03/2017.
 */
class Demo(context: Context, val activityClass: Class<*>, titleId: Int) {
    val title: String

    init {
        title = context.getString(titleId)
    }

    override fun toString(): String {
        return title
    }
}