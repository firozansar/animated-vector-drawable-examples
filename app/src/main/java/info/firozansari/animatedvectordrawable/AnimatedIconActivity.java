package info.firozansari.animatedvectordrawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by firoz on 19/03/2017.
 */

public class AnimatedIconActivity extends AppCompatActivity {
    private ArrayList<AnimatedIcon> animatedIcons = new ArrayList<>();
    private IconAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animated_icon);

        // Init and Setup RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(AnimatedIconActivity.this, 2));
        //animator not yet working
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new IconAdapter();
        recyclerView.setAdapter(mAdapter);
    }
}