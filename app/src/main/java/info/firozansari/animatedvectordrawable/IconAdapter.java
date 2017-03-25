package info.firozansari.animatedvectordrawable;

import android.graphics.drawable.Animatable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by firoz on 25/03/2017.
 */

class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    private List<AnimatedIcon> animatedIcons = new ArrayList<>();

    public void setAnimatedIcons(List<AnimatedIcon> animatedIcons) {
        this.animatedIcons.addAll(animatedIcons);
        this.notifyItemRangeInserted(0, animatedIcons.size() - 1);
    }

    @Override public ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View v =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_icon, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(final ViewHolder viewHolder, int i) {

        viewHolder.animatedIconView.setImageDrawable(animatedIcons.get(i).getIcon());

        viewHolder.name.setText(animatedIcons.get(i).getClass().getSimpleName());
    }

    @Override public int getItemCount() {
        return animatedIcons == null ? 0 : animatedIcons.size();
    }

    public void clear() {
        animatedIcons.clear();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ImageView animatedIconView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            animatedIconView = (ImageView) itemView.findViewById(R.id.icon);
            animatedIconView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    final Animatable animatable = (Animatable) animatedIconView.getDrawable();
                    animatable.start();
                }
            });
        }
    }
}