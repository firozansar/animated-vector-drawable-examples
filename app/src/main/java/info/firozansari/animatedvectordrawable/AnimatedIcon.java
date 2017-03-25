package info.firozansari.animatedvectordrawable;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;

/**
 * Created by firoz on 25/03/2017.
 */

class AnimatedIcon {

    public AnimatedVectorDrawableCompat icon;

    public String title;

    public AnimatedIcon(AnimatedVectorDrawableCompat icon, String title) {

        this.icon = icon;
        this.title = title;
    }

    public AnimatedVectorDrawableCompat getIcon() {
        return icon;
    }

    public void setIcon(AnimatedVectorDrawableCompat icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
