package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;

public class TrainScheduleFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f5176a;
    @BindView(2131363776)
    LinearLayout route_ll;
    @BindView(2131363836)
    RecyclerView rv_station_list;
    @BindView(2131364532)
    EditText tv_pnr;
    @BindView(2131364573)
    TextView tv_runs_on_Fri;
    @BindView(2131364574)
    TextView tv_runs_on_Mon;
    @BindView(2131364575)
    TextView tv_runs_on_Sat;
    @BindView(2131364576)
    TextView tv_runs_on_Sun;
    @BindView(2131364577)
    TextView tv_runs_on_Thu;
    @BindView(2131364578)
    TextView tv_runs_on_Tue;
    @BindView(2131364579)
    TextView tv_runs_on_Wed;
    @BindView(2131364686)
    TextView tv_train_name;

    static {
        C1354qp.R(TrainScheduleFragment.class);
    }

    public TrainScheduleFragment() {
        new GoogleAdParamDTO();
    }

    public final void f(String str, Context context) {
        Om om;
        if (!C0535I5.O((ConnectivityManager) context.getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new C0493EA(), 5000);
            return;
        }
        try {
            boolean M = C0535I5.M();
            ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.requestWindowFeature(1);
            progressDialog.setMessage(getString(R.string.please_wait_text));
            progressDialog.show();
            if (!M) {
                if (!C0535I5.R()) {
                    om = (Om) C0657Qt.b();
                    String f = C0657Qt.f();
                    String format = String.format("/%s", new Object[]{str});
                    om.g1(f + "trnscheduleenquiry" + format).c(C1181iv.a()).a(E0.a()).b(new F0(this, progressDialog, str, context));
                }
            }
            om = (Om) C0657Qt.c(C0793b1.a.f3912a);
            String f2 = C0657Qt.f();
            String format2 = String.format("/%s", new Object[]{str});
            om.g1(f2 + "trnscheduleenquiry" + format2).c(C1181iv.a()).a(E0.a()).b(new F0(this, progressDialog, str, context));
        } catch (Exception e) {
            e.getMessage();
            C0535I5.t0(context, getString(R.string.please_try_again));
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_trainschedule, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.a = getContext();
        EditText editText = this.tv_pnr;
        FragmentActivity activity = getActivity();
        AlertDialog alertDialog = C0535I5.f3619a;
        editText.addTextChangedListener(new C0479D5(activity, 5));
        this.f5176a = getActivity();
        this.tv_pnr.requestFocus();
        HomeActivity.J();
        HomeActivity.p();
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        HomeActivity.p();
        C0535I5.u();
    }

    public final void onResume() {
        super.onResume();
        HomeActivity.p();
    }

    @OnClick({2131364586})
    public void onSearchClick() {
        this.route_ll.setVisibility(8);
        C0535I5.I(getActivity());
        try {
            if (this.tv_pnr.getText().toString().compareToIgnoreCase("") == 0) {
                C0535I5.o(getActivity(), getString(R.string.enter_train_number), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            } else if (this.tv_pnr.getText().toString().length() != 5) {
                C0535I5.o(getActivity(), getString(R.string.train_number_invalid), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            } else {
                f(this.tv_pnr.getText().toString(), this.a);
                this.route_ll.setVisibility(8);
                C0535I5.I(getActivity());
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }
}
