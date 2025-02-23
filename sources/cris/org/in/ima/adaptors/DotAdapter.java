package cris.org.in.ima.adaptors;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.prs.ima.R;

public class DotAdapter extends RecyclerView.Adapter<DotViewHolder> {
    private int dotsPerGroup = 3;
    private int itemCount;
    private int selectedPosition = 0;

    public static class DotViewHolder extends RecyclerView.ViewHolder {
        ImageView dotImageView;

        public DotViewHolder(View view) {
            super(view);
            this.dotImageView = (ImageView) view.findViewById(R.id.dotImageView);
        }
    }

    public DotAdapter(int i) {
        this.itemCount = i;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public DotViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DotViewHolder(C1058d.s(viewGroup, R.layout.dot_item, viewGroup, false));
    }

    public void setSelectedPosition(int i) {
        this.selectedPosition = i;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(DotViewHolder dotViewHolder, int i) {
        if (i == this.selectedPosition / this.dotsPerGroup) {
            dotViewHolder.dotImageView.setImageResource(R.drawable.dot_selected);
            return;
        }
        dotViewHolder.dotImageView.setImageResource(0);
        dotViewHolder.dotImageView.setBackgroundResource(R.drawable.dot_unselected);
    }
}
