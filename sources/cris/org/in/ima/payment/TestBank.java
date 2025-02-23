package cris.org.in.ima.payment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;
import rx.Subscriber;

public class TestBank extends Fragment implements C1245lp {
    public static final /* synthetic */ int c = 0;
    public Context a;
    @BindView(2131361942)
    TextView fareAmount;
    @BindView(2131362779)
    LinearLayout llHint;
    @BindView(2131364467)
    TextView loginButton;
    @BindView(2131362577)
    EditText mobileNo;
    @BindView(2131363476)
    ImageView paymentImage;
    @BindView(2131363497)
    TextView pgTxnMsg;
    @BindView(2131362578)
    EditText pin;
    @BindView(2131364530)
    TextView pinLabel;
    @BindView(2131364831)
    View pinUnderline;
    @BindView(2131363856)
    LinearLayout rlMobilePin;
    @BindView(2131364149)
    TextView titleTv;

    public class a extends Subscriber<O8> {
        public final /* synthetic */ ProgressDialog a;

        public a(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            int i = TestBank.c;
            this.a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = TestBank.c;
            xx.S(th, false, th);
        }

        public final void onNext(Object obj) {
            O8 o8 = (O8) obj;
            int i = TestBank.c;
            String message = o8.getMessage();
            TestBank testBank = TestBank.this;
            if (message == null || o8.getMessage().equals("")) {
                Bundle bundle = new Bundle();
                DepositDataFragment depositDataFragment = new DepositDataFragment();
                bundle.putSerializable("statusDTO", o8);
                depositDataFragment.setArguments(bundle);
                HomeActivity.n(testBank.getContext(), depositDataFragment, testBank.getResources().getString(R.string.ewallet_deposit_response), Boolean.FALSE, Boolean.TRUE);
                return;
            }
            C0535I5.m(testBank.a, false, o8.getMessage(), testBank.getString(R.string.error), testBank.getString(R.string.OK), new b());
        }
    }

    static {
        C1354qp.R(TestBank.class);
    }

    public final void c(String str) {
        ProgressDialog show = ProgressDialog.show(getActivity(), "Loading...", getString(R.string.please_wait_text));
        String g = C0657Qt.g();
        String format = String.format("/%s", new Object[]{str});
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).C(g + "depositData" + format).c(C1181iv.a()).a(E0.a()).b(new a(show));
    }

    public final void e() {
        Ol ol = Ol.a;
        TestVerifyActivity testVerifyActivity = new TestVerifyActivity();
        boolean z = C1480xl.f7038a.f7044a;
        FragmentActivity activity = getActivity();
        String d = xx.d(7);
        Boolean bool = Boolean.TRUE;
        ol.getClass();
        HomeActivity.n(activity, testVerifyActivity, d, bool, bool);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_sbi_buddy, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.a = getContext();
        C1480xl xlVar = C1480xl.f7038a;
        this.pgTxnMsg.setText(" * Payment Gateway charges and GST will be applicable");
        Bw.e(getContext());
        TextView textView = this.fareAmount;
        textView.setText("Total Fare: " + getResources().getString(R.string.rupees) + xlVar.f7042a.getAmount());
        TextView textView2 = this.titleTv;
        textView2.setText("Pay " + getResources().getString(R.string.rupees) + xlVar.f7042a.getAmount() + " with mobile wallet");
        this.paymentImage.setImageResource(R.drawable.ic_test_bank);
        this.rlMobilePin.setVisibility(4);
        this.llHint.setVisibility(4);
        return inflate;
    }

    @OnClick({2131364467})
    public void sbiBuddyLoginOnClick(View view) {
        C1480xl xlVar = C1480xl.f7038a;
        ArrayList arrayList = new ArrayList();
        Do doR = new Do("MOBILE", this.mobileNo.getText().toString());
        Do doR2 = new Do("PIN", this.pin.getText().toString());
        arrayList.add(doR);
        arrayList.add(doR2);
        xlVar.d(this, arrayList, (TextView) null, (EditText) null, (EditText) null, (TextView) null);
    }

    public final Fragment a() {
        return this;
    }

    public final void b() {
    }
}
