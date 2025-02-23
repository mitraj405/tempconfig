package cris.org.in.ima.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.activities.MasterPassengerNewActivity;
import cris.org.in.ima.adaptors.MasterPassengerListNewViewHolder;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.model.MasterPassengerModel;
import cris.org.in.prs.ima.R;
import defpackage.C1426uk;
import defpackage.d7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import rx.Subscriber;

public class MasterPassengerListNewFragment extends Fragment {
    public static final /* synthetic */ int d = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4808a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f4809a;

    /* renamed from: a  reason: collision with other field name */
    public MasterPassengerListNewViewHolder f4810a;

    /* renamed from: a  reason: collision with other field name */
    public final e f4811a = new e();

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<MasterPassengerModel> f4812a = null;
    public int c = -1;
    @BindView(2131362474)
    RelativeLayout editPsgnLayout;
    @BindView(2131364394)
    TextView errorMsg;
    @BindView(2131363039)
    LinearLayout ll_legend;
    @BindView(2131363051)
    LinearLayout ll_pending_check;
    @BindView(2131363175)
    AdManagerAdView masterlist;
    @BindView(2131363177)
    RecyclerView passengetList;
    @BindView(2131364496)
    TextView tv_msg_max_tickets;
    @BindView(2131364527)
    TextView tv_pending_check;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            String Q = C0535I5.Q("SELECT_MASTER_LIST");
            String Q2 = C0535I5.Q("EDIT_MASTER_LIST");
            MasterPassengerListNewFragment masterPassengerListNewFragment = MasterPassengerListNewFragment.this;
            if (Q != null) {
                FragmentActivity activity = masterPassengerListNewFragment.getActivity();
                C0535I5.o(activity, masterPassengerListNewFragment.getString(R.string.master_list_not_allowed) + " " + Q, "Ok", (DialogInterface.OnClickListener) null).show();
            } else if (Q2 != null) {
                FragmentActivity activity2 = masterPassengerListNewFragment.getActivity();
                C0535I5.o(activity2, masterPassengerListNewFragment.getString(R.string.master_list_not_allowed) + " " + Q2, "Ok", (DialogInterface.OnClickListener) null).show();
            } else {
                int i = masterPassengerListNewFragment.c;
                if (i < 0 || C1450w1.b < i) {
                    masterPassengerListNewFragment.startActivityForResult(new Intent(masterPassengerListNewFragment.getActivity(), MasterPassengerNewActivity.class), 1);
                    return;
                }
                C0535I5.o(masterPassengerListNewFragment.getActivity(), masterPassengerListNewFragment.getString(R.string.limit_max_mst_psgn), masterPassengerListNewFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        public final void onClick(View view) {
            MasterPassengerListNewFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://contents.irctc.co.in/en/Linking%20Aadhaar%20Mobile%20App%20Guide.pdf")));
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public class d extends Subscriber<C1426uk> {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ boolean f4813a;

        public d(boolean z) {
            this.f4813a = z;
        }

        public final void onCompleted() {
            int i = MasterPassengerListNewFragment.d;
            MasterPassengerListNewFragment.this.a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = MasterPassengerListNewFragment.d;
            th.getClass();
            th.getMessage();
            MasterPassengerListNewFragment masterPassengerListNewFragment = MasterPassengerListNewFragment.this;
            masterPassengerListNewFragment.passengetList.setVisibility(8);
            masterPassengerListNewFragment.ll_pending_check.setVisibility(8);
            masterPassengerListNewFragment.tv_msg_max_tickets.setVisibility(8);
            masterPassengerListNewFragment.errorMsg.setVisibility(0);
            masterPassengerListNewFragment.ll_legend.setVisibility(8);
            masterPassengerListNewFragment.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            C1426uk ukVar = (C1426uk) obj;
            MasterPassengerListNewFragment masterPassengerListNewFragment = MasterPassengerListNewFragment.this;
            if (ukVar != null) {
                C0657Qt.h();
                try {
                    if (ukVar.getErrorMessage() == null) {
                        masterPassengerListNewFragment.errorMsg.setVisibility(8);
                        masterPassengerListNewFragment.passengetList.setVisibility(0);
                        masterPassengerListNewFragment.ll_pending_check.setVisibility(0);
                        masterPassengerListNewFragment.tv_msg_max_tickets.setVisibility(0);
                        masterPassengerListNewFragment.ll_legend.setVisibility(0);
                        masterPassengerListNewFragment.c = ukVar.getMaxAllowedPsgn().intValue();
                        masterPassengerListNewFragment.f4812a.clear();
                        masterPassengerListNewFragment.f4812a = null;
                        masterPassengerListNewFragment.f4812a = new ArrayList<>();
                        Iterator<C1426uk.a> it = ukVar.getPassengerDetailList().iterator();
                        while (it.hasNext()) {
                            MasterPassengerModel masterPassengerModel = new MasterPassengerModel();
                            masterPassengerModel.a = it.next();
                            masterPassengerListNewFragment.f4812a.add(masterPassengerModel);
                        }
                        ArrayList<MasterPassengerModel> arrayList = masterPassengerListNewFragment.f4812a;
                        if (!(arrayList == null || arrayList.size() == 0)) {
                            C0535I5.f3632c = masterPassengerListNewFragment.f4812a;
                            if (this.f4813a) {
                                C0535I5.o(masterPassengerListNewFragment.getActivity(), masterPassengerListNewFragment.getString(R.string.MasterList_Refreshed_Successfully), masterPassengerListNewFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                            }
                        }
                        MasterPassengerListNewViewHolder masterPassengerListNewViewHolder = new MasterPassengerListNewViewHolder(masterPassengerListNewFragment.f4808a, masterPassengerListNewFragment.f4812a, masterPassengerListNewFragment.f4811a);
                        masterPassengerListNewFragment.f4810a = masterPassengerListNewViewHolder;
                        masterPassengerListNewFragment.passengetList.setAdapter(masterPassengerListNewViewHolder);
                        masterPassengerListNewFragment.a.dismiss();
                    } else {
                        masterPassengerListNewFragment.passengetList.setVisibility(8);
                        masterPassengerListNewFragment.ll_pending_check.setVisibility(8);
                        masterPassengerListNewFragment.tv_msg_max_tickets.setVisibility(8);
                        masterPassengerListNewFragment.errorMsg.setVisibility(0);
                        TextView textView = masterPassengerListNewFragment.errorMsg;
                        textView.setText(ukVar.getErrorMessage() + masterPassengerListNewFragment.getString(R.string.please_add_psgn_master));
                        masterPassengerListNewFragment.ll_legend.setVisibility(8);
                        C0535I5.m(masterPassengerListNewFragment.getActivity(), false, ukVar.getErrorMessage(), masterPassengerListNewFragment.getString(R.string.error), masterPassengerListNewFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        masterPassengerListNewFragment.a.dismiss();
                    }
                    C1450w1.b = masterPassengerListNewFragment.f4812a.size();
                } catch (Exception e) {
                    int i = MasterPassengerListNewFragment.d;
                    e.getMessage();
                    masterPassengerListNewFragment.passengetList.setVisibility(8);
                    masterPassengerListNewFragment.passengetList.setVisibility(8);
                    masterPassengerListNewFragment.ll_pending_check.setVisibility(8);
                    masterPassengerListNewFragment.tv_msg_max_tickets.setVisibility(8);
                    masterPassengerListNewFragment.errorMsg.setVisibility(0);
                    masterPassengerListNewFragment.errorMsg.setText(masterPassengerListNewFragment.getString(R.string.unble_to_fetch_data));
                    masterPassengerListNewFragment.ll_legend.setVisibility(8);
                    C0535I5.m(masterPassengerListNewFragment.getActivity(), false, masterPassengerListNewFragment.getString(R.string.unble_to_fetch_data), masterPassengerListNewFragment.getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                    masterPassengerListNewFragment.a.dismiss();
                }
            }
        }
    }

    public class e implements MasterPassengerListNewViewHolder.MasterPassengerListNewViewHolderListener {
        public e() {
        }

        public final void onEditClick(MasterPassengerModel masterPassengerModel) {
            String Q = C0535I5.Q("EDIT_MASTER_LIST");
            MasterPassengerListNewFragment masterPassengerListNewFragment = MasterPassengerListNewFragment.this;
            if (Q != null) {
                FragmentActivity activity = masterPassengerListNewFragment.getActivity();
                C0535I5.o(activity, masterPassengerListNewFragment.getString(R.string.master_list_not_allowed) + " " + Q, "Ok", (DialogInterface.OnClickListener) null).show();
                return;
            }
            int i = MasterPassengerListNewFragment.d;
            masterPassengerListNewFragment.getClass();
            Intent intent = new Intent(masterPassengerListNewFragment.getContext(), MasterPassengerNewActivity.class);
            intent.putExtra("isEdit", true);
            intent.putExtra("MasterPassengerDetail", masterPassengerModel.a);
            masterPassengerListNewFragment.startActivityForResult(intent, 4);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public final void run() {
            ArrayList<MasterPassengerModel> arrayList = C0535I5.f3632c;
            MasterPassengerListNewFragment masterPassengerListNewFragment = MasterPassengerListNewFragment.this;
            masterPassengerListNewFragment.f4812a = arrayList;
            if (arrayList == null || arrayList.size() == 0) {
                masterPassengerListNewFragment.f(false);
            }
        }
    }

    static {
        C1354qp.R(MasterPassengerListNewFragment.class);
    }

    public final void f(boolean z) {
        String Q = C0535I5.Q("SELECT_MASTER_LIST");
        if (!C0535I5.O((ConnectivityManager) this.f4808a.getSystemService("connectivity"), this.f4808a)) {
            new Handler().postDelayed(new c(), 5000);
            return;
        }
        ArrayList<MasterPassengerModel> arrayList = C0535I5.f3632c;
        this.f4812a = arrayList;
        if ((arrayList == null || arrayList.size() == 0 || z) && Q == null) {
            if (this.f4812a == null) {
                this.f4812a = new ArrayList<>();
            }
            C0793b1 b1Var = C0793b1.a;
            if (b1Var.f3912a != null && !((Activity) this.f4808a).isFinishing()) {
                Context context = this.f4808a;
                this.a = ProgressDialog.show(context, context.getResources().getString(R.string.fetch_master_psgn), this.f4808a.getResources().getString(R.string.please_wait_text));
                Objects.toString(b1Var.f3912a);
                String f2 = C0657Qt.f();
                ((Om) C0657Qt.c(b1Var.f3912a)).A(f2 + "masterpsgnlistenquiry").c(C1181iv.a()).a(E0.a()).b(new d(z));
                return;
            }
            return;
        }
        this.errorMsg.setVisibility(8);
        this.passengetList.setVisibility(0);
        this.ll_pending_check.setVisibility(0);
        this.tv_msg_max_tickets.setVisibility(0);
        this.ll_legend.setVisibility(0);
        MasterPassengerListNewViewHolder masterPassengerListNewViewHolder = new MasterPassengerListNewViewHolder(this.f4808a, this.f4812a, this.f4811a);
        this.f4810a = masterPassengerListNewViewHolder;
        this.passengetList.setAdapter(masterPassengerListNewViewHolder);
        if (Q != null) {
            FragmentActivity activity = getActivity();
            C0535I5.o(activity, getString(R.string.master_list_not_allowed) + " " + Q, "Ok", (DialogInterface.OnClickListener) null).show();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null) {
            return;
        }
        if ((i == 4 || i == 1) && i2 == 0) {
            f(false);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_master_list_new, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4808a = getContext();
        this.f4809a = getActivity();
        HomeActivity.x();
        HomeActivity.z();
        HomeActivity.G(getString(R.string.add_passenger));
        this.passengetList.setLayoutManager(new LinearLayoutManager(this.f4808a));
        this.passengetList.setHasFixedSize(true);
        this.passengetList.setAdapter(this.f4810a);
        f(false);
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.masterlist, googleAdParamDTO);
        HomeActivity.f4190d.setOnClickListener(new a());
        HomeActivity.J();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f4808a.getResources().getString(R.string.user_book_12ticket));
        Context context = getContext();
        Object obj = d7.a;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(d7.b.a(context, R.color.blue));
        StyleSpan styleSpan = new StyleSpan(1);
        b bVar = new b();
        try {
            spannableStringBuilder.setSpan(styleSpan, 155, 167, 18);
            spannableStringBuilder.setSpan(bVar, 156, 167, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, 155, 167, 18);
        } catch (Exception e2) {
            e2.getMessage();
        }
        this.tv_msg_max_tickets.setText(spannableStringBuilder);
        this.tv_msg_max_tickets.setMovementMethod(LinkMovementMethod.getInstance());
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    public final void onResume() {
        super.onResume();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        new Handler().postDelayed(new f(), 30000);
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    @OnClick({2131364527})
    public void setTv_pending_check(View view) {
        f(true);
    }

    public class c implements Runnable {
        public final void run() {
        }
    }
}
