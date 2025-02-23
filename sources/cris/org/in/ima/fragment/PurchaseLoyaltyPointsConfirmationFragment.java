package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.prs.ima.R;

public class PurchaseLoyaltyPointsConfirmationFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f5047a;

    /* renamed from: a  reason: collision with other field name */
    public C1263mp f5048a = null;

    /* renamed from: a  reason: collision with other field name */
    public C1432ux f5049a;
    @BindView(2131364677)
    TextView totalAmount;
    @BindView(2131364684)
    TextView totalPurchasePoint;
    @BindView(2131364706)
    TextView transactionId;

    static {
        C1354qp.R(PurchaseLoyaltyPointsConfirmationFragment.class);
    }

    public PurchaseLoyaltyPointsConfirmationFragment() {
        new C1225kp();
    }

    @OnClick({2131362089})
    public void okButton() {
        HomeActivity.B(getActivity());
        FragmentActivity activity = getActivity();
        HomeFragment homeFragment = new HomeFragment();
        String a2 = C1218kf.HOME_PAGE.a();
        Boolean bool = Boolean.TRUE;
        HomeActivity.n(activity, homeFragment, a2, bool, bool);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_purchase_loyalty_points_confirmation, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f5047a = getActivity();
        C1432ux uxVar = this.f5049a;
        if (uxVar == null || uxVar.getSoftPointsPurchaseView() == null) {
            C1263mp mpVar = this.f5048a;
            if (mpVar != null) {
                this.transactionId.setText(String.valueOf(mpVar.getTransationId()));
                String valueOf = String.valueOf(this.f5048a.getTransationId());
                if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), (Context) null)) {
                    new Handler().postDelayed(new Pq(), 5000);
                } else {
                    this.a = ProgressDialog.show(getActivity(), "Fetching data...", getString(R.string.please_wait_text));
                    String i = C0657Qt.i();
                    String format = String.format("/%s", new Object[]{valueOf});
                    ((Om) C0657Qt.c(C0793b1.a.f3912a)).A1(i + "loyaltyPurchaseData" + format, valueOf).c(C1181iv.a()).a(E0.a()).b(new C1020e0(this));
                }
            }
        } else {
            this.totalPurchasePoint.setText(String.valueOf(this.f5049a.getSoftPointsPurchaseView().getPointsToPurchase()));
            this.totalAmount.setText(String.format(getResources().getString(R.string.format_rupees), new Object[]{this.f5049a.getSoftPointsPurchaseView().getPurchaseAmount()}));
            this.transactionId.setText(String.valueOf(this.f5049a.getSoftPointsPurchaseView().getLoyaltyTxnDtlsSrlNo()));
        }
        C1408tl tlVar = C1450w1.f7012a;
        return inflate;
    }
}
