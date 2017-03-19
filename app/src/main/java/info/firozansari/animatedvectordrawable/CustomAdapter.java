package info.firozansari.animatedvectordrawable;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;

    private ArrayList<Demo> data;

    private LayoutInflater inflater;

    private int previousPosition = 0;

    public CustomAdapter(Context context, ArrayList<Demo> data) {

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_item_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {

        myViewHolder.textview.setText(data.get(position).title);


        final int currentPosition = position;
        final Demo infoData = data.get(position);

        myViewHolder.textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Demo demo = data.get(position);
                context.startActivity(new Intent(context, demo.activityClass));
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textview;

        public MyViewHolder(View itemView) {
            super(itemView);

            textview = (TextView) itemView.findViewById(R.id.txv_row);

        }
    }

}
