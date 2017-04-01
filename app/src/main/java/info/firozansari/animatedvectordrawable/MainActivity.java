package info.firozansari.animatedvectordrawable;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Demo> demos = new ArrayList<>();
        demos.add(new Demo(this, ExampleActivity.class, R.string.example_from_documentation));
        demos.add(new Demo(this, RotateActivity.class, R.string.clock));
        demos.add(new Demo(this, PathMorphActivity.class, R.string.smiling_face));
        demos.add(new Demo(this, FillInHeartActivity.class, R.string.fill_in_heart));
        demos.add(new Demo(this, PlayResetActivity.class, R.string.play_to_reset));
        demos.add(new Demo(this, AnimatedIconActivity.class, R.string.animated_icon));
        demos.add(new Demo(this, AnimatedMenuActivity.class, R.string.animated_menu));


        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        adapter = new CustomAdapter(this, demos);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Vertical Orientation By Default



    }


}
