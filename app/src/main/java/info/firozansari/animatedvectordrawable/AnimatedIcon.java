package info.firozansari.animatedvectordrawable;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;

/**
 * Created by firoz on 25/03/2017.
 */

class AnimatedIcon {

    public AnimatedVectorDrawableCompat icon;

    public AnimatedIcon(AnimatedVectorDrawableCompat icon) {
        this.icon = icon;
    }

    public AnimatedVectorDrawableCompat getIcon() {
        return icon;
    }

    public void setIcon(AnimatedVectorDrawableCompat icon) {
        this.icon = icon;
    }
}
