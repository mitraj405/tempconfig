package cris.org.in.ima.payment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class SbiBuddy extends Fragment implements C1245lp {
    @BindView(2131361942)
    TextView fareAmount;
    @BindView(2131364467)
    TextView loginButton;
    @BindView(2131362577)
    EditText mobileNo;
    @BindView(2131364521)
    TextView otpMsgInfo;
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
    @BindView(2131364149)
    TextView titleTv;

    static {
        C1354qp.R(SbiBuddy.class);
    }

    public final void e() {
        Boolean bool = C1480xl.a;
        new SbiBuddyVerifyActivity();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_sbi_buddy, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.pin.setInputType(130);
        EditText editText = this.pin;
        FragmentActivity activity = getActivity();
        AlertDialog alertDialog = C0535I5.f3619a;
        editText.addTextChangedListener(new C0479D5(activity, 4));
        this.mobileNo.addTextChangedListener(new C0479D5(getActivity(), 10));
        C0535I5.H(getActivity(), getView());
        C0535I5.a(this.mobileNo, 10);
        C0535I5.a(this.pin, 4);
        C1480xl xlVar = C1480xl.f7038a;
        Bw e = Bw.e(getContext());
        TextView textView = this.fareAmount;
        textView.setText("Total Fare: " + getResources().getString(R.string.rupees) + xlVar.f7042a.getAmount());
        TextView textView2 = this.titleTv;
        textView2.setText("Pay " + getResources().getString(R.string.rupees) + xlVar.f7042a.getAmount() + " with mobile wallet");
        this.mobileNo.setText(e.k());
        this.pgTxnMsg.setText(xlVar.f7045b);
        if (74 == xlVar.f7042a.getBankId()) {
            this.pinLabel.setVisibility(4);
            this.pin.setVisibility(4);
            this.pinUnderline.setVisibility(4);
            this.paymentImage.setImageResource(R.drawable.page_mobikwik);
            this.otpMsgInfo.setText("Please enter your registered MobiKwik mobile number. We will send OTP to verify.");
        } else if (91 == xlVar.f7042a.getBankId()) {
            this.pinLabel.setVisibility(4);
            this.pin.setVisibility(4);
            this.pinUnderline.setVisibility(4);
            this.paymentImage.setImageResource(R.drawable.ic_logo_airtel_money);
            this.otpMsgInfo.setText("Please enter your registered Airtel Money mobile number. We will send OTP to verify.");
        } else if (73 == xlVar.f7042a.getBankId()) {
            this.paymentImage.setImageResource(R.drawable.page_sbi_buddy);
            this.otpMsgInfo.setText("Please enter your registered SbiBuddy mobile number. We will send OTP to verify.");
        }
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        C0535I5.u();
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }

    @OnClick({2131364467})
    public void sbiBuddyLoginOnClick(View view) {
        C1480xl xlVar = C1480xl.f7038a;
        String obj = this.pin.getText().toString();
        this.pin.setInputType(130);
        if (!C0535I5.N(this.mobileNo.getText().toString())) {
            C0535I5.m(getActivity(), false, getString(R.string.please_provide_valid_mobile_number), getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
        } else if (73 != xlVar.f7042a.getBankId() || (!TextUtils.isEmpty(obj) && TextUtils.getTrimmedLength(obj) == 4)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Do("MOBILE", this.mobileNo.getText().toString()));
            if (73 == xlVar.f7042a.getBankId()) {
                arrayList.add(new Do("PIN", obj));
            }
            xlVar.d(this, arrayList, (TextView) null, (EditText) null, (EditText) null, (TextView) null);
        } else {
            C0535I5.m(getActivity(), false, getString(R.string.please_enter_pin_of_4digits), getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
        }
    }

    public final Fragment a() {
        return this;
    }

    public final void b() {
    }

    public final void c(String str) {
    }
}
