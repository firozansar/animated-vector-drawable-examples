package info.firozansari.animatedvectordrawable;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by firoz on 19/03/2017.
 */

public class PlayResetActivity extends AppCompatActivity {

    private AnimatedVectorDrawableCompat playToResetAnim;
    private AnimatedVectorDrawableCompat resetToPlayAnim;
    private boolean isShowingPlay = true;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playreset);
        playToResetAnim = AnimatedVectorDrawableCompat.create(this, R.drawable.fab_play_to_reset_animated_vector);
        resetToPlayAnim = AnimatedVectorDrawableCompat.create(this, R.drawable.fab_reset_to_play_animated_vector);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setImageDrawable(playToResetAnim);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButtonIcon();
            }
        });
    }

    private void changeButtonIcon(){
        AnimatedVectorDrawableCompat currentDrawable = isShowingPlay ? playToResetAnim : resetToPlayAnim;
        floatingActionButton.setImageDrawable(currentDrawable);
        currentDrawable.start();
        isShowingPlay = !isShowingPlay;
    }

}
