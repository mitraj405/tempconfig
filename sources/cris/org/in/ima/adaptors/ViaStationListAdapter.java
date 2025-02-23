package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.model.ViaStationModel;
import cris.org.in.prs.ima.R;
import java.util.List;

public class ViaStationListAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public ViaStnListener listener;
    private Context mContext;
    private List<ViaStationModel> viaStations;

    public interface ViaStnListener {
        void onItemClick(ViaStationModel viaStationModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViaStationModel item;
        @BindView(2131362913)
        CheckBox viaCheckBox;
        @BindView(2131364722)
        TextView viaStn;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.viaCheckBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.iv_via_checkbox, "field 'viaCheckBox'", CheckBox.class);
            viewHolder.viaStn = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_via_stn, "field 'viaStn'", TextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.viaCheckBox = null;
                viewHolder.viaStn = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public ViaStationListAdapter(Context context, List<ViaStationModel> list, ViaStnListener viaStnListener) {
        this.mContext = context;
        this.viaStations = list;
        this.listener = viaStnListener;
    }

    public int getItemCount() {
        return this.viaStations.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(C1058d.r(viewGroup, R.layout.item_via_station, (ViewGroup) null));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final ViaStationModel viaStationModel = this.viaStations.get(i);
        viewHolder.item = viaStationModel;
        StationDb stationDb = C0793b1.a.f3911a;
        TextView textView = viewHolder.viaStn;
        textView.setText(viaStationModel.a + " - " + C0535I5.s0(stationDb.m(viaStationModel.a)));
        if (viaStationModel.f5349a) {
            viewHolder.viaCheckBox.setChecked(true);
        } else {
            viewHolder.viaCheckBox.setChecked(false);
        }
        viewHolder.viaCheckBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ViaStationListAdapter.this.listener != null) {
                    ViaStationListAdapter.this.listener.onItemClick(viaStationModel);
                }
                ViaStationListAdapter.this.notifyDataSetChanged();
            }
        });
        viewHolder.viaStn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ViaStationListAdapter.this.listener != null) {
                    ViaStationListAdapter.this.listener.onItemClick(viaStationModel);
                }
                ViaStationListAdapter.this.notifyDataSetChanged();
            }
        });
    }
}
