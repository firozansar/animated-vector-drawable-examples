package info.firozansari.animatedvectordrawable;

import android.content.Context;

/**
 * Created by firoz on 19/03/2017.
 */

public class Demo {
    public final Class<?> activityClass;
    public final String title;

    public Demo(Context context, Class<?> activityClass, int titleId) {
        this.activityClass = activityClass;
        this.title = context.getString(titleId);
    }

    @Override
    public String toString() {
        return this.title;
    }
}
