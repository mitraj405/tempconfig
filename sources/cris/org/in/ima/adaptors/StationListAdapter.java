package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.model.StationModel;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class StationListAdapter extends RecyclerView.Adapter<StationListViewHolder> {
    Context context;
    StationListAdapterStnSelectListener listener;
    ArrayList<StationModel> stationModels;

    public interface StationListAdapterStnSelectListener {
        void onStationClick(StationModel stationModel);
    }

    public class StationListViewHolder extends RecyclerView.ViewHolder {
        TextView stationCity;
        TextView stationCode;
        LinearLayout stationListRelativeLayout;
        TextView stationName;
        TextView stationState;

        public StationListViewHolder(View view) {
            super(view);
            this.stationCode = (TextView) view.findViewById(R.id.tv_station_code);
            this.stationName = (TextView) view.findViewById(R.id.tv_station_name);
            this.stationCity = (TextView) view.findViewById(R.id.tv_station_city);
            this.stationState = (TextView) view.findViewById(R.id.tv_station_state);
            this.stationListRelativeLayout = (LinearLayout) view.findViewById(R.id.stnListRelLayout);
        }
    }

    public StationListAdapter(Context context2, ArrayList<StationModel> arrayList, StationListAdapterStnSelectListener stationListAdapterStnSelectListener) {
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
        return new StationListViewHolder(C1058d.s(viewGroup, R.layout.item_station, viewGroup, false));
    }

    public void onBindViewHolder(StationListViewHolder stationListViewHolder, int i) {
        String str;
        StationModel stationModel = this.stationModels.get(i);
        stationListViewHolder.stationCode.setText(stationModel.f5341a);
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            stationListViewHolder.stationState.setText(C0535I5.s0(stationModel.g));
            String str2 = stationModel.d;
            if (str2 == null || str2.isEmpty()) {
                stationListViewHolder.stationName.setText(C0535I5.s0(stationModel.b));
            } else {
                stationListViewHolder.stationName.setText(C0535I5.s0(stationModel.d));
            }
            if (stationModel.e != null) {
                TextView textView = stationListViewHolder.stationCity;
                textView.setText(stationModel.e + ", ");
            } else {
                TextView textView2 = stationListViewHolder.stationCity;
                textView2.setText(C0535I5.s0(stationModel.c) + ", ");
            }
        } else {
            stationListViewHolder.stationState.setText(C0535I5.s0(stationModel.f));
            stationListViewHolder.stationName.setText(C0535I5.s0(stationModel.b));
            TextView textView3 = stationListViewHolder.stationCity;
            textView3.setText(C0535I5.s0(stationModel.c) + ", ");
        }
        String str3 = stationModel.c;
        if (str3 == "" || (str = stationModel.e) == "" || str3 == null || str == null) {
            stationListViewHolder.stationCity.setVisibility(8);
        } else {
            stationListViewHolder.stationCity.setVisibility(0);
        }
        if (stationListViewHolder.stationCode.equals("BDTS")) {
            stationListViewHolder.stationCity.toString();
        }
        stationListViewHolder.stationState.setAllCaps(false);
        stationListViewHolder.stationCity.setAllCaps(false);
        OnClickListener(stationListViewHolder.stationListRelativeLayout, this.listener, stationModel);
    }
}
