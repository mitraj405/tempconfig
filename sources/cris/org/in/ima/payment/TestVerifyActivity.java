package cris.org.in.ima.payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.fragment.LoyalityPassengerDetailFragment;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class TestVerifyActivity extends Fragment {
    @BindView(2131361942)
    TextView amountTv;
    public String c;
    public String d;
    @BindView(2131362779)
    LinearLayout hintLayout;
    @BindView(2131363855)
    EditText otpText;
    @BindView(2131363857)
    TextView paymentButton;
    @BindView(2131363476)
    ImageView paymentImage;
    @BindView(2131363497)
    TextView pgTxnMsg;
    @BindView(2131363856)
    LinearLayout rlMobilePin;

    static {
        C1354qp.R(LoyalityPassengerDetailFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_sbi_buddy_verify, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.pgTxnMsg.setText(" * Payment Gateway charges and GST will be applicable");
        C1480xl xlVar = C1480xl.f7038a;
        TextView textView = this.amountTv;
        textView.setText("Total Fare:   " + getResources().getString(R.string.rupees) + xlVar.f7042a.getAmount());
        TextView textView2 = this.paymentButton;
        textView2.setText("Pay " + getResources().getString(R.string.rupees) + xlVar.f7042a.getAmount());
        this.hintLayout.setVisibility(4);
        this.rlMobilePin.setVisibility(4);
        this.paymentImage.setImageResource(R.drawable.ic_test_bank);
        this.c = LoyalityPassengerDetailFragment.l;
        this.d = LoyalityPassengerDetailFragment.k;
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

    @OnClick({2131363857})
    public void onclickVerify(View view) {
        String obj = this.otpText.getText().toString();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Do("OTP", obj));
        arrayList.add(new Do("Success", "000"));
        arrayList.add(new Do("Message", "Success"));
        arrayList.add(new Do("BankRefNo", "12345"));
        String str = this.d;
        if (str != null && str.equals("accural")) {
            if (this.c.equals(getString(R.string.SBI_bank_loyalty_credit_card))) {
                arrayList.add(new Do("BinNumber", "437748"));
            }
            if (this.c.equals(getString(R.string.BOB_bank_loyalty_credit_card))) {
                arrayList.add(new Do("BinNumber", "356132"));
            }
        }
        C1480xl.f7038a.c(this, arrayList);
    }
}
