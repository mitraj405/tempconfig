package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.fragment.AllTrainListFragment;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.ima.model.WrapperAvailablityModel;
import cris.org.in.prs.ima.R;
import defpackage.d7;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class AvailabilityViewHolder extends RecyclerView.Adapter<AvailabilityItemHolder> {
    private static final String TAG = C1354qp.R(AvailabilityViewHolder.class);
    AvailabilityViewHolderListener listener;
    Context mContext;
    TrainBtwnStnsModel trainBtwnStnsModel;
    List<WrapperAvailablityModel> wrapperAvailablityModelList;

    public class AvailabilityItemHolder extends RecyclerView.ViewHolder {
        TextView avlDate;
        TextView avlDetails;
        LinearLayout class_fare_ll;
        TextView cnfProbability;
        LinearLayout main_layout;
        LinearLayout main_ll;

        public AvailabilityItemHolder(View view) {
            super(view);
            this.main_ll = (LinearLayout) view.findViewById(R.id.main_ll);
            this.class_fare_ll = (LinearLayout) view.findViewById(R.id.class_fare_ll);
            this.avlDate = (TextView) view.findViewById(R.id.tv_journeyDate);
            this.avlDetails = (TextView) view.findViewById(R.id.tv_avl_detail);
            this.main_layout = (LinearLayout) view.findViewById(R.id.main_layout);
            this.cnfProbability = (TextView) view.findViewById(R.id.tv_cnf_probability);
        }
    }

    public interface AvailabilityViewHolderListener {
        void onItemClick(WrapperAvailablityModel wrapperAvailablityModel, TrainBtwnStnsModel trainBtwnStnsModel);
    }

    public AvailabilityViewHolder(Context context, List<WrapperAvailablityModel> list, AvailabilityViewHolderListener availabilityViewHolderListener, TrainBtwnStnsModel trainBtwnStnsModel2) {
        this.wrapperAvailablityModelList = list;
        this.mContext = context;
        this.listener = availabilityViewHolderListener;
        this.trainBtwnStnsModel = trainBtwnStnsModel2;
    }

    public String format(String str) {
        int indexOf = str.indexOf(45);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(45, i);
        return new SimpleDateFormat("EEE, dd MMM ").format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
    }

    public int getItemCount() {
        return this.wrapperAvailablityModelList.size();
    }

    public AvailabilityItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AvailabilityItemHolder(C1058d.s(viewGroup, R.layout.item_class_with_fare, viewGroup, false));
    }

    public void onSetListeners(AvailabilityItemHolder availabilityItemHolder, final WrapperAvailablityModel wrapperAvailablityModel, TrainBtwnStnsModel trainBtwnStnsModel2) {
        availabilityItemHolder.main_ll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AllTrainListFragment.f4415b = null;
                for (WrapperAvailablityModel next : AvailabilityViewHolder.this.wrapperAvailablityModelList) {
                    if (next.a.getAvailablityDate().equals(wrapperAvailablityModel.a.getAvailablityDate())) {
                        next.f5351a = true;
                        AllTrainListFragment.f4415b = next.a;
                    } else {
                        next.f5351a = false;
                    }
                }
                AvailabilityViewHolder.this.notifyDataSetChanged();
            }
        });
    }

    public void onBindViewHolder(AvailabilityItemHolder availabilityItemHolder, int i) {
        WrapperAvailablityModel wrapperAvailablityModel = this.wrapperAvailablityModelList.get(i);
        availabilityItemHolder.class_fare_ll.setVisibility(8);
        String availablityStatus = wrapperAvailablityModel.a.getAvailablityStatus();
        int i2 = 13;
        if (availablityStatus.contains("AVAIL") && !availablityStatus.contains("WL") && availablityStatus.contains("-")) {
            availablityStatus = "AVL " + availablityStatus.split("-")[1];
        } else if (availablityStatus.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
            availablityStatus = availablityStatus.split(RemoteSettings.FORWARD_SLASH_STRING)[1];
        } else if (availablityStatus.contains("DEPARTED")) {
            i2 = 10;
        }
        if (availablityStatus.contains("TRAIN")) {
            i2 = 11;
        }
        availabilityItemHolder.avlDetails.setText(availablityStatus);
        availabilityItemHolder.avlDetails.setTextSize((float) i2);
        availabilityItemHolder.avlDate.setText(format(wrapperAvailablityModel.a.getAvailablityDate()));
        if (wrapperAvailablityModel.a.getProbability() != null) {
            availabilityItemHolder.cnfProbability.setVisibility(0);
            TextView textView = availabilityItemHolder.cnfProbability;
            StringBuilder sb = new StringBuilder();
            sb.append(("" + ((wrapperAvailablityModel.a.getProbability().doubleValue() * 100.0d) + 0.5d)).split("\\.")[0]);
            sb.append("%");
            textView.setText(sb.toString());
        } else {
            availabilityItemHolder.cnfProbability.setVisibility(8);
        }
        if (wrapperAvailablityModel.a.getReasonType().equals("W")) {
            TextView textView2 = availabilityItemHolder.avlDetails;
            Context context = this.mContext;
            Object obj = d7.a;
            textView2.setTextColor(d7.b.a(context, R.color.divider_ine));
        } else if (!wrapperAvailablityModel.a.getAvailablityStatus().contains("WL")) {
            TextView textView3 = availabilityItemHolder.avlDetails;
            Context context2 = this.mContext;
            Object obj2 = d7.a;
            textView3.setTextColor(d7.b.a(context2, R.color.green));
        } else if (wrapperAvailablityModel.a.getAvailablityStatus().contains("AVAILABLE") || wrapperAvailablityModel.a.getAvailablityStatus().contains("RAC")) {
            TextView textView4 = availabilityItemHolder.avlDetails;
            Context context3 = this.mContext;
            Object obj3 = d7.a;
            textView4.setTextColor(d7.b.a(context3, R.color.green));
        } else {
            TextView textView5 = availabilityItemHolder.avlDetails;
            Context context4 = this.mContext;
            Object obj4 = d7.a;
            textView5.setTextColor(d7.b.a(context4, R.color.red));
        }
        if (wrapperAvailablityModel.f5351a) {
            AllTrainListFragment.f4415b = wrapperAvailablityModel.a;
            availabilityItemHolder.main_ll.setBackground(d7.a.b(this.mContext, R.drawable.round_light_corner3));
        } else {
            availabilityItemHolder.main_ll.setBackground(d7.a.b(this.mContext, R.drawable.round_light_corner2));
        }
        onSetListeners(availabilityItemHolder, wrapperAvailablityModel, this.trainBtwnStnsModel);
    }
}
