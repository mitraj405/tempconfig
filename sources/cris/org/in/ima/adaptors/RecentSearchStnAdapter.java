package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.model.RecentSearchStationModel;
import cris.org.in.prs.ima.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class RecentSearchStnAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(RecentSearchStnAdapter.class);
    /* access modifiers changed from: private */
    public RecentSearchStnListener listener;
    private Context mContext;
    private ArrayList<RecentSearchStationModel> recentSearchStationModels;

    public interface RecentSearchStnListener {
        void onItemClick(RecentSearchStationModel recentSearchStationModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131364418)
        TextView fromStnCode;
        @BindView(2131364416)
        TextView fromStnName;
        RecentSearchStationModel item;
        @BindView(2131364450)
        TextView journeyDate;
        @BindView(2131364667)
        TextView toStnCode;
        @BindView(2131364668)
        TextView toStnName;
        @BindView(2131364339)
        TextView tvclass;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131362133})
        public void onItemClick(View view) {
            RecentSearchStnAdapter.this.listener.onItemClick(this.item);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a0155;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            Class cls = TextView.class;
            viewHolder.fromStnCode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fromStn_code, "field 'fromStnCode'", cls);
            viewHolder.fromStnName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_formStn_name, "field 'fromStnName'", cls);
            viewHolder.toStnCode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toStn_code, "field 'toStnCode'", cls);
            viewHolder.toStnName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toStn_name, "field 'toStnName'", cls);
            viewHolder.journeyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_journeyDate, "field 'journeyDate'", cls);
            viewHolder.tvclass = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class, "field 'tvclass'", cls);
            View findRequiredView = Utils.findRequiredView(view, R.id.card_layout, "method 'onItemClick'");
            this.view7f0a0155 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.onItemClick(view);
                }
            });
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.fromStnCode = null;
                viewHolder.fromStnName = null;
                viewHolder.toStnCode = null;
                viewHolder.toStnName = null;
                viewHolder.journeyDate = null;
                viewHolder.tvclass = null;
                this.view7f0a0155.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0155 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public RecentSearchStnAdapter(Context context, ArrayList<RecentSearchStationModel> arrayList, RecentSearchStnListener recentSearchStnListener) {
        this.mContext = context;
        this.listener = recentSearchStnListener;
        this.recentSearchStationModels = arrayList;
    }

    public int getItemCount() {
        ArrayList<RecentSearchStationModel> arrayList = this.recentSearchStationModels;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(C1058d.s(viewGroup, R.layout.item_recent_search_stn, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        try {
            StationDb stationDb = C0793b1.a.f3911a;
            RecentSearchStationModel recentSearchStationModel = this.recentSearchStationModels.get(i);
            viewHolder.item = recentSearchStationModel;
            String[] split = recentSearchStationModel.a.split("-");
            viewHolder.fromStnCode.setText(split[0]);
            viewHolder.fromStnName.setText(stationDb.m(split[0]));
            String[] split2 = viewHolder.item.b.split("-");
            viewHolder.toStnCode.setText(split2[0]);
            viewHolder.toStnName.setText(stationDb.m(split2[0]));
            Date parse = new SimpleDateFormat("yyyyMMdd").parse(viewHolder.item.c);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE dd MMM yyyy");
            if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                simpleDateFormat = new SimpleDateFormat("EEE dd MMM yyyy", new Locale("hi", "IN"));
            }
            viewHolder.journeyDate.setText(simpleDateFormat.format(parse));
            viewHolder.tvclass.setText(viewHolder.item.d);
        } catch (Exception e) {
            e.toString();
        }
    }
}
