package cris.org.in.ima.payment;

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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.fragment.MakePaymentNewFragment;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class SbiBuddyVerifyActivity extends Fragment {
    @BindView(2131361942)
    TextView amountTv;
    @BindView(2131363855)
    EditText otpText;
    @BindView(2131363857)
    TextView paymentButton;
    @BindView(2131363476)
    ImageView paymentImage;
    @BindView(2131363497)
    TextView pgTxnMsg;
    @BindView(2131364567)
    TextView resendOtp;
    @BindView(2131364149)
    TextView titleTv;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_sbi_buddy_verify, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        C0535I5.a(this.otpText, 6);
        this.otpText.setInputType(130);
        C0535I5.H(getActivity(), getView());
        C1480xl xlVar = C1480xl.f7038a;
        TextView textView = this.titleTv;
        textView.setText("Pay " + getResources().getString(R.string.rupees) + xlVar.f7042a.getAmount() + " with mobile wallet");
        TextView textView2 = this.amountTv;
        textView2.setText("Total Fare:   " + getResources().getString(R.string.rupees) + xlVar.f7042a.getAmount());
        TextView textView3 = this.paymentButton;
        textView3.setText("Pay " + getResources().getString(R.string.rupees) + xlVar.f7042a.getAmount());
        this.pgTxnMsg.setText(xlVar.f7045b);
        if (74 == xlVar.f7042a.getBankId()) {
            this.paymentImage.setImageResource(R.drawable.page_mobikwik);
        } else if (73 == xlVar.f7042a.getBankId()) {
            this.paymentImage.setImageResource(R.drawable.page_sbi_buddy);
        } else if (91 == xlVar.f7042a.getBankId()) {
            this.paymentImage.setImageResource(R.drawable.ic_logo_airtel_money);
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

    @OnClick({2131364567})
    public void onResendOtpClick(View view) {
        C1480xl.f7038a.e(this, this.resendOtp);
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }

    @OnClick({2131363857})
    public void onclickVerify(View view) {
        String obj = this.otpText.getText().toString();
        if (!TextUtils.isDigitsOnly(obj) || TextUtils.getTrimmedLength(obj) == 0) {
            C0535I5.m(getActivity(), false, getString(R.string.please_provide_otp), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        C0535I5.H(getActivity(), getView());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Do("OTP", obj));
        C1480xl.f7038a.c((MakePaymentNewFragment) getFragmentManager().I(), arrayList);
    }
}
