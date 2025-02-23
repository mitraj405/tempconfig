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
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.model.FevJourneyModel;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class FavourtyListJPPageAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(FavourtyListJPPageAdapter.class);
    private ArrayList<FevJourneyModel> fevJourneyModelList;
    /* access modifiers changed from: private */
    public fevJourneyListener listener;
    Context mContext;
    StationDb stationDb = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131364418)
        TextView fromcitycode;
        FevJourneyModel model;
        @BindView(2131364667)
        TextView tocitycode;
        @BindView(2131364339)
        TextView tv_fevjou_class;
        @BindView(2131364692)
        TextView tv_trainnumber;
        @BindView(2131364258)
        TextView tv_trainquata;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131362133})
        public void onItemClick(View view) {
            FavourtyListJPPageAdapter.this.listener.OnItemClick(this.model);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a0155;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            Class cls = TextView.class;
            viewHolder.tv_trainnumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_trainnumber, "field 'tv_trainnumber'", cls);
            viewHolder.tv_fevjou_class = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class, "field 'tv_fevjou_class'", cls);
            viewHolder.fromcitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fromStn_code, "field 'fromcitycode'", cls);
            viewHolder.tocitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toStn_code, "field 'tocitycode'", cls);
            viewHolder.tv_trainquata = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_Quota, "field 'tv_trainquata'", cls);
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
                viewHolder.tv_trainnumber = null;
                viewHolder.tv_fevjou_class = null;
                viewHolder.fromcitycode = null;
                viewHolder.tocitycode = null;
                viewHolder.tv_trainquata = null;
                this.view7f0a0155.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0155 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface fevJourneyListener {
        void OnItemClick(FevJourneyModel fevJourneyModel);
    }

    public FavourtyListJPPageAdapter(Context context, ArrayList<FevJourneyModel> arrayList, fevJourneyListener fevjourneylistener) {
        this.fevJourneyModelList = arrayList;
        this.mContext = this.mContext;
        this.listener = fevjourneylistener;
    }

    public int getItemCount() {
        ArrayList<FevJourneyModel> arrayList = this.fevJourneyModelList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s = C1058d.s(viewGroup, R.layout.item_favourtylist, viewGroup, false);
        this.mContext = viewGroup.getContext();
        return new ViewHolder(s);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        FevJourneyModel fevJourneyModel = this.fevJourneyModelList.get(i);
        this.stationDb = C0793b1.a.f3911a;
        fevJourneyModel.toString();
        viewHolder.model = fevJourneyModel;
        viewHolder.tv_trainnumber.setText(String.valueOf(fevJourneyModel.c));
        viewHolder.tv_fevjou_class.setText(String.valueOf(fevJourneyModel.f));
        try {
            viewHolder.fromcitycode.setText(String.valueOf(C0535I5.s0(fevJourneyModel.d.split("-")[1])));
            viewHolder.tocitycode.setText(String.valueOf(C0535I5.s0(fevJourneyModel.e.split("-")[1])));
        } catch (Exception e) {
            e.getMessage();
        }
        viewHolder.tv_trainquata.setText(String.valueOf(fevJourneyModel.g));
    }

    public void onSetListeners(ViewHolder viewHolder, FevJourneyModel fevJourneyModel) {
    }
}
