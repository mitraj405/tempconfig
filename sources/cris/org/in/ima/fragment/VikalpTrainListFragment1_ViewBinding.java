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

public class VikalpTrainListFragment1_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public VikalpTrainListFragment1 f5230a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ VikalpTrainListFragment1 a;

        public a(VikalpTrainListFragment1 vikalpTrainListFragment1) {
            this.a = vikalpTrainListFragment1;
        }

        public final void doClick(View view) {
            this.a.onSplBkgClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ VikalpTrainListFragment1 a;

        public b(VikalpTrainListFragment1 vikalpTrainListFragment1) {
            this.a = vikalpTrainListFragment1;
        }

        public final void doClick(View view) {
            this.a.onSubmitClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ VikalpTrainListFragment1 a;

        public c(VikalpTrainListFragment1 vikalpTrainListFragment1) {
            this.a = vikalpTrainListFragment1;
        }

        public final void doClick(View view) {
            this.a.onVikalpDateClick(view);
        }
    }

    public VikalpTrainListFragment1_ViewBinding(VikalpTrainListFragment1 vikalpTrainListFragment1, View view) {
        this.f5230a = vikalpTrainListFragment1;
        Class cls = TextView.class;
        vikalpTrainListFragment1.pnrNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnrNumber'", cls);
        vikalpTrainListFragment1.trainNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name_no, "field 'trainNumber'", cls);
        vikalpTrainListFragment1.fromStation = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcidtycode, "field 'fromStation'", cls);
        vikalpTrainListFragment1.toStation = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'toStation'", cls);
        vikalpTrainListFragment1.arrDeptTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_arr_dep_time, "field 'arrDeptTime'", cls);
        vikalpTrainListFragment1.jrnyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'jrnyDate'", cls);
        vikalpTrainListFragment1.trainList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_train_list, "field 'trainList'", RecyclerView.class);
        vikalpTrainListFragment1.splTrainLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_select_spl, "field 'splTrainLayout'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.select_spl_train, "field 'splTrain' and method 'onSplBkgClick'");
        vikalpTrainListFragment1.splTrain = (CheckBox) Utils.castView(findRequiredView, R.id.select_spl_train, "field 'splTrain'", CheckBox.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(vikalpTrainListFragment1));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_submit_btn, "field 'submitBtn' and method 'onSubmitClick'");
        vikalpTrainListFragment1.submitBtn = (TextView) Utils.castView(findRequiredView2, R.id.tv_submit_btn, "field 'submitBtn'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(vikalpTrainListFragment1));
        vikalpTrainListFragment1.selectTrnTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_trn_txt, "field 'selectTrnTxt'", cls);
        vikalpTrainListFragment1.vikalpTrainDate = (TextView) Utils.findRequiredViewAsType(view, R.id.vikalp_train_date, "field 'vikalpTrainDate'", cls);
        vikalpTrainListFragment1.selectvikalptrainbottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.select_vikalp_train_bottom, "field 'selectvikalptrainbottom'", AdManagerAdView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.ll_vikalp__train_date, "method 'onVikalpDateClick'");
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(vikalpTrainListFragment1));
    }

    public final void unbind() {
        VikalpTrainListFragment1 vikalpTrainListFragment1 = this.f5230a;
        if (vikalpTrainListFragment1 != null) {
            this.f5230a = null;
            vikalpTrainListFragment1.pnrNumber = null;
            vikalpTrainListFragment1.trainNumber = null;
            vikalpTrainListFragment1.fromStation = null;
            vikalpTrainListFragment1.toStation = null;
            vikalpTrainListFragment1.arrDeptTime = null;
            vikalpTrainListFragment1.jrnyDate = null;
            vikalpTrainListFragment1.trainList = null;
            vikalpTrainListFragment1.splTrainLayout = null;
            vikalpTrainListFragment1.splTrain = null;
            vikalpTrainListFragment1.submitBtn = null;
            vikalpTrainListFragment1.selectTrnTxt = null;
            vikalpTrainListFragment1.vikalpTrainDate = null;
            vikalpTrainListFragment1.selectvikalptrainbottom = null;
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
