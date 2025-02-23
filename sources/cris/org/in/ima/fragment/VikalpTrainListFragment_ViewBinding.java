package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class VikalpTrainListFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public VikalpTrainListFragment f5231a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ VikalpTrainListFragment a;

        public a(VikalpTrainListFragment vikalpTrainListFragment) {
            this.a = vikalpTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.onSplBkgClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ VikalpTrainListFragment a;

        public b(VikalpTrainListFragment vikalpTrainListFragment) {
            this.a = vikalpTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.onSubmitClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ VikalpTrainListFragment a;

        public c(VikalpTrainListFragment vikalpTrainListFragment) {
            this.a = vikalpTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.onVikalpDateClick(view);
        }
    }

    public VikalpTrainListFragment_ViewBinding(VikalpTrainListFragment vikalpTrainListFragment, View view) {
        this.f5231a = vikalpTrainListFragment;
        Class cls = TextView.class;
        vikalpTrainListFragment.pnrNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnrNumber'", cls);
        vikalpTrainListFragment.trainNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name_no, "field 'trainNumber'", cls);
        vikalpTrainListFragment.fromStation = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcidtycode, "field 'fromStation'", cls);
        vikalpTrainListFragment.toStation = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'toStation'", cls);
        vikalpTrainListFragment.arrDeptTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_arr_dep_time, "field 'arrDeptTime'", cls);
        vikalpTrainListFragment.jrnyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'jrnyDate'", cls);
        vikalpTrainListFragment.trainList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_train_list, "field 'trainList'", RecyclerView.class);
        Class cls2 = LinearLayout.class;
        vikalpTrainListFragment.splTrainLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_select_spl, "field 'splTrainLayout'", cls2);
        View findRequiredView = Utils.findRequiredView(view, R.id.select_spl_train, "field 'splTrain' and method 'onSplBkgClick'");
        vikalpTrainListFragment.splTrain = (CheckBox) Utils.castView(findRequiredView, R.id.select_spl_train, "field 'splTrain'", CheckBox.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(vikalpTrainListFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_submit_btn, "field 'submitBtn' and method 'onSubmitClick'");
        vikalpTrainListFragment.submitBtn = (TextView) Utils.castView(findRequiredView2, R.id.tv_submit_btn, "field 'submitBtn'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(vikalpTrainListFragment));
        vikalpTrainListFragment.selectTrnTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_trn_txt, "field 'selectTrnTxt'", cls);
        vikalpTrainListFragment.vikalpTrainDate = (TextView) Utils.findRequiredViewAsType(view, R.id.vikalp_train_date, "field 'vikalpTrainDate'", cls);
        vikalpTrainListFragment.btn = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_btn, "field 'btn'", cls2);
        vikalpTrainListFragment.ll_train_list = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_train_list, "field 'll_train_list'", cls2);
        vikalpTrainListFragment.select_vikalp_trn = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_select_vikalp_trn, "field 'select_vikalp_trn'", cls2);
        vikalpTrainListFragment.selectvikalptrain_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.select_vikalp_train_bottom, "field 'selectvikalptrain_bottom'", AdManagerAdView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.ll_vikalp__train_date, "method 'onVikalpDateClick'");
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(vikalpTrainListFragment));
    }

    public final void unbind() {
        VikalpTrainListFragment vikalpTrainListFragment = this.f5231a;
        if (vikalpTrainListFragment != null) {
            this.f5231a = null;
            vikalpTrainListFragment.pnrNumber = null;
            vikalpTrainListFragment.trainNumber = null;
            vikalpTrainListFragment.fromStation = null;
            vikalpTrainListFragment.toStation = null;
            vikalpTrainListFragment.arrDeptTime = null;
            vikalpTrainListFragment.jrnyDate = null;
            vikalpTrainListFragment.trainList = null;
            vikalpTrainListFragment.splTrainLayout = null;
            vikalpTrainListFragment.splTrain = null;
            vikalpTrainListFragment.submitBtn = null;
            vikalpTrainListFragment.selectTrnTxt = null;
            vikalpTrainListFragment.vikalpTrainDate = null;
            vikalpTrainListFragment.btn = null;
            vikalpTrainListFragment.ll_train_list = null;
            vikalpTrainListFragment.select_vikalp_trn = null;
            vikalpTrainListFragment.selectvikalptrain_bottom = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
