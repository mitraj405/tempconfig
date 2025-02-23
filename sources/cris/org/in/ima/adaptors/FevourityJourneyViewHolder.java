package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
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

public class FevourityJourneyViewHolder extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(FevourityJourneyViewHolder.class);
    private ArrayList<FevJourneyModel> fevJourneyModelList;
    /* access modifiers changed from: private */
    public fevJourneyListener listener;
    Context mContext;
    StationDb stationDb = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362648)
        RadioButton fev_radio;
        @BindView(2131362716)
        TextView fromcitycode;
        FevJourneyModel model;
        @BindView(2131364169)
        TextView tocitycode;
        @BindView(2131364408)
        TextView tv_fevjou_class;
        @BindView(2131364691)
        TextView tv_trainname;
        @BindView(2131364692)
        TextView tv_trainnumber;
        @BindView(2131364693)
        TextView tv_trainquata;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131362646})
        public void fevJouneyLayoutClick() {
            if (this.model != null) {
                FevourityJourneyViewHolder.this.listener.OnItemClick(this.model);
            }
        }

        @OnClick({2131362648})
        public void fevRadioClick() {
            if (this.model != null) {
                FevourityJourneyViewHolder.this.listener.OnItemClick(this.model);
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a0356;
        private View view7f0a0358;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            View findRequiredView = Utils.findRequiredView(view, R.id.fev_radio, "field 'fev_radio' and method 'fevRadioClick'");
            viewHolder.fev_radio = (RadioButton) Utils.castView(findRequiredView, R.id.fev_radio, "field 'fev_radio'", RadioButton.class);
            this.view7f0a0358 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.fevRadioClick();
                }
            });
            Class cls = TextView.class;
            viewHolder.tv_trainname = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_trainname, "field 'tv_trainname'", cls);
            viewHolder.tv_trainnumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_trainnumber, "field 'tv_trainnumber'", cls);
            viewHolder.tv_fevjou_class = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fevjou_class, "field 'tv_fevjou_class'", cls);
            viewHolder.fromcitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcitycode, "field 'fromcitycode'", cls);
            viewHolder.tocitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'tocitycode'", cls);
            viewHolder.tv_trainquata = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_trainquata, "field 'tv_trainquata'", cls);
            View findRequiredView2 = Utils.findRequiredView(view, R.id.fevJourney_ll, "method 'fevJouneyLayoutClick'");
            this.view7f0a0356 = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.fevJouneyLayoutClick();
                }
            });
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.fev_radio = null;
                viewHolder.tv_trainname = null;
                viewHolder.tv_trainnumber = null;
                viewHolder.tv_fevjou_class = null;
                viewHolder.fromcitycode = null;
                viewHolder.tocitycode = null;
                viewHolder.tv_trainquata = null;
                this.view7f0a0358.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0358 = null;
                this.view7f0a0356.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0356 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface fevJourneyListener {
        void OnItemClick(FevJourneyModel fevJourneyModel);
    }

    public FevourityJourneyViewHolder(Context context, ArrayList<FevJourneyModel> arrayList, fevJourneyListener fevjourneylistener) {
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
        View r = C1058d.r(viewGroup, R.layout.item_fevourityjourney_list, (ViewGroup) null);
        this.mContext = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }

    public void onSetListeners(ViewHolder viewHolder, final FevJourneyModel fevJourneyModel) {
        viewHolder.fev_radio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (FevourityJourneyViewHolder.this.listener != null) {
                    FevourityJourneyViewHolder.this.listener.OnItemClick(fevJourneyModel);
                }
            }
        });
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        FevJourneyModel fevJourneyModel = this.fevJourneyModelList.get(i);
        this.stationDb = C0793b1.a.f3911a;
        fevJourneyModel.toString();
        viewHolder.model = fevJourneyModel;
        TextView textView = viewHolder.tv_trainnumber;
        textView.setText(String.valueOf("(" + fevJourneyModel.c + ")"));
        viewHolder.tv_fevjou_class.setText(String.valueOf(fevJourneyModel.f));
        try {
            String[] split = fevJourneyModel.d.split("-");
            TextView textView2 = viewHolder.fromcitycode;
            textView2.setText(String.valueOf((C0535I5.s0(split[0]) + "(" + split[1] + ")").trim()));
            String[] split2 = fevJourneyModel.e.split("-");
            TextView textView3 = viewHolder.tocitycode;
            textView3.setText(String.valueOf(C0535I5.s0(split2[0]) + "(" + split2[1] + ")").trim());
        } catch (Exception e) {
            e.getMessage();
        }
        viewHolder.tv_trainquata.setText(String.valueOf(fevJourneyModel.g));
        viewHolder.fev_radio.setChecked(false);
    }
}
