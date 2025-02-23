package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class TrainScheduleFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public TrainScheduleFragment f5177a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TrainScheduleFragment a;

        public a(TrainScheduleFragment trainScheduleFragment) {
            this.a = trainScheduleFragment;
        }

        public final void doClick(View view) {
            this.a.onSearchClick();
        }
    }

    public TrainScheduleFragment_ViewBinding(TrainScheduleFragment trainScheduleFragment, View view) {
        this.f5177a = trainScheduleFragment;
        trainScheduleFragment.tv_pnr = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_pnr, "field 'tv_pnr'", EditText.class);
        trainScheduleFragment.route_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.route_ll, "field 'route_ll'", LinearLayout.class);
        Class cls = TextView.class;
        trainScheduleFragment.tv_train_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_train_name, "field 'tv_train_name'", cls);
        trainScheduleFragment.tv_runs_on_Mon = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_runs_on_Mon, "field 'tv_runs_on_Mon'", cls);
        trainScheduleFragment.tv_runs_on_Tue = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_runs_on_Tue, "field 'tv_runs_on_Tue'", cls);
        trainScheduleFragment.tv_runs_on_Wed = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_runs_on_Wed, "field 'tv_runs_on_Wed'", cls);
        trainScheduleFragment.tv_runs_on_Thu = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_runs_on_Thu, "field 'tv_runs_on_Thu'", cls);
        trainScheduleFragment.tv_runs_on_Fri = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_runs_on_Fri, "field 'tv_runs_on_Fri'", cls);
        trainScheduleFragment.tv_runs_on_Sat = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_runs_on_Sat, "field 'tv_runs_on_Sat'", cls);
        trainScheduleFragment.tv_runs_on_Sun = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_runs_on_Sun, "field 'tv_runs_on_Sun'", cls);
        trainScheduleFragment.rv_station_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_station_list, "field 'rv_station_list'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_search, "method 'onSearchClick'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(trainScheduleFragment));
    }

    public final void unbind() {
        TrainScheduleFragment trainScheduleFragment = this.f5177a;
        if (trainScheduleFragment != null) {
            this.f5177a = null;
            trainScheduleFragment.tv_pnr = null;
            trainScheduleFragment.route_ll = null;
            trainScheduleFragment.tv_train_name = null;
            trainScheduleFragment.tv_runs_on_Mon = null;
            trainScheduleFragment.tv_runs_on_Tue = null;
            trainScheduleFragment.tv_runs_on_Wed = null;
            trainScheduleFragment.tv_runs_on_Thu = null;
            trainScheduleFragment.tv_runs_on_Fri = null;
            trainScheduleFragment.tv_runs_on_Sat = null;
            trainScheduleFragment.tv_runs_on_Sun = null;
            trainScheduleFragment.rv_station_list = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
