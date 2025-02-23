package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.prs.ima.R;

public class MasterPassengerListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(int i, View view) {
            super(view);
        }
    }

    public MasterPassengerListAdapter(Context context) {
        this.mContext = context;
    }

    public int getItemCount() {
        return 10;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(i, C1058d.r(viewGroup, R.layout.item_master_passenger_list, (ViewGroup) null));
    }
}
