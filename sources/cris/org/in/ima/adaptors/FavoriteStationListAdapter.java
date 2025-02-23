package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.ima.model.StationModel;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class FavoriteStationListAdapter extends RecyclerView.Adapter<StationListViewHolder> {
    private static final String TAG = C1354qp.R(FavoriteStationListAdapter.class);
    Context context;
    StationListAdapterStnSelectListener listener;
    ArrayList<StationModel> stationModels;

    public interface StationListAdapterStnSelectListener {
        void onStationClick(StationModel stationModel);
    }

    public class StationListViewHolder extends RecyclerView.ViewHolder {
        TextView stationCode;
        LinearLayout stationListRelativeLayout;
        TextView stationName;

        public StationListViewHolder(View view) {
            super(view);
            this.stationCode = (TextView) view.findViewById(R.id.tv_station_code);
            this.stationName = (TextView) view.findViewById(R.id.tv_station_name);
            this.stationListRelativeLayout = (LinearLayout) view.findViewById(R.id.stnListRelLayout);
        }
    }

    public FavoriteStationListAdapter(Context context2, ArrayList<StationModel> arrayList, StationListAdapterStnSelectListener stationListAdapterStnSelectListener) {
        this.stationModels = arrayList;
        this.context = context2;
        this.listener = stationListAdapterStnSelectListener;
    }

    public void OnClickListener(LinearLayout linearLayout, final StationListAdapterStnSelectListener stationListAdapterStnSelectListener, final StationModel stationModel) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stationListAdapterStnSelectListener.onStationClick(stationModel);
            }
        });
    }

    public int getItemCount() {
        return this.stationModels.size();
    }

    public StationListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new StationListViewHolder(C1058d.s(viewGroup, R.layout.item_favourite_station, viewGroup, false));
    }

    public void onBindViewHolder(StationListViewHolder stationListViewHolder, int i) {
        StationModel stationModel = this.stationModels.get(i);
        try {
            stationModel.b.split("-");
            stationListViewHolder.stationCode.setText(stationModel.f5341a);
            stationModel.f5341a.split("-");
            stationListViewHolder.stationName.setText(stationModel.b);
        } catch (Exception e) {
            e.getMessage();
        }
        OnClickListener(stationListViewHolder.stationListRelativeLayout, this.listener, stationModel);
    }
}
