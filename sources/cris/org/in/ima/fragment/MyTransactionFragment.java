package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.a;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import defpackage.C0535I5;

public class MyTransactionFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentManager f4841a;
    @BindView(2131362946)
    RelativeLayout lastTransationDetailLL;
    @BindView(2131363289)
    AdManagerAdView mytransactionbottom;

    static {
        C1354qp.R(MyTransactionFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Long l;
        View inflate = layoutInflater.inflate(R.layout.fragment_my_transaction, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        HomeActivity.p();
        HomeActivity.J();
        HomeActivity.z();
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.mytransactionbottom, googleAdParamDTO);
        this.f4841a = getFragmentManager();
        this.a = new ProgressDialog(getContext());
        C0535I5.b bVar = C0535I5.f3616a;
        if (bVar == null || (l = bVar.f3653a) == null || String.valueOf(l).length() <= 5) {
            this.lastTransationDetailLL.setVisibility(8);
        } else {
            this.lastTransationDetailLL.setVisibility(0);
        }
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363724})
    public void onFailedTxnHistoryClick(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new FailedTxnHistoryFragment(), C1218kf.FAILED_TXN_HISTORY.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4841a;
        fragmentManager.getClass();
        a aVar = new a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    @OnClick({2131362946})
    public void onLastTransactionClick(View view) {
        Long l;
        C0535I5.b bVar = C0535I5.f3616a;
        if (bVar != null && (l = bVar.f3653a) != null) {
            String l2 = l.toString();
            if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getActivity())) {
                new Handler().postDelayed(new C1304om(), 5000);
                return;
            }
            ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.last_Transaction), getString(R.string.please_wait));
            this.a = show;
            C1223kn knVar = C0793b1.a.f3912a;
            if (knVar != null) {
                try {
                    show.show();
                    String f = C0657Qt.f();
                    String format = String.format("/%s", new Object[]{l2});
                    ((Om) C0657Qt.c(knVar)).F0(f + "historySearchByTxnId" + format).c(C1181iv.a()).a(E0.a()).b(new C1329pm(this));
                } catch (Exception e) {
                    e.getMessage();
                    this.a.dismiss();
                    C0535I5.t0(getActivity(), getString(R.string.please_try_again));
                }
            } else {
                C0535I5.m(getActivity(), false, getResources().getString(R.string.unable_process_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    @OnClick({2131363754})
    public void onMyBookingClick(View view) {
        C0535I5.f3652m = false;
        TicketHistoryUtil.f5370a = TicketHistoryUtil.SortFor.BOOKINGS;
        HomeActivity.n((AppCompatActivity) getActivity(), new BookingHistoryFragment(), C1218kf.MY_BOOKING.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4841a;
        fragmentManager.getClass();
        a aVar = new a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363767})
    public void onRefundHistoryClick(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new RefundTxnHistoryFragment(), C1218kf.TICKET_REFUND_HISTORY.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4841a;
        fragmentManager.getClass();
        a aVar = new a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    public final void onResume() {
        super.onResume();
        HomeActivity.p();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363766})
    public void onTdrHistoryClick(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new TdrHistoryFragment(), C1218kf.TDR_HISTORY.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4841a;
        fragmentManager.getClass();
        a aVar = new a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    @OnClick({2131363717})
    public void onTktCancellationHistoryClick(View view) {
        HomeActivity.n((AppCompatActivity) getActivity(), new CancellationHistoryFragment(), C1218kf.TKT_CANCELLATION_HISTORY.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4841a;
        fragmentManager.getClass();
        a aVar = new a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }
}
