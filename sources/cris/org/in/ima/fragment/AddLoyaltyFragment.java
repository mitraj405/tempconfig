package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import java.util.ArrayList;
import java.util.Iterator;
import rx.Subscriber;

public class AddLoyaltyFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f4397a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4398a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<String> f4399a = null;
    public ArrayList<C1187j2> b;

    /* renamed from: c  reason: collision with other field name */
    public String f4400c = "";

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<String> f4401c = new ArrayList<>();
    @BindView(2131362543)
    EditText loyaltyNumber;
    @BindView(2131363112)
    TextView loyalty_bank;
    @BindView(2131363407)
    RelativeLayout otpLayout;
    @BindView(2131362560)
    EditText otpNumber;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            AddLoyaltyFragment addLoyaltyFragment = AddLoyaltyFragment.this;
            if (addLoyaltyFragment.otpLayout.getVisibility() == 0) {
                addLoyaltyFragment.otpLayout.setVisibility(8);
            } else if (!addLoyaltyFragment.loyaltyNumber.getText().toString().trim().equals("")) {
                addLoyaltyFragment.f(addLoyaltyFragment.a, addLoyaltyFragment.loyaltyNumber);
            } else {
                Toast makeText = Toast.makeText(addLoyaltyFragment.a, addLoyaltyFragment.getString(R.string.loyalty_Account_Number), 1);
                makeText.setGravity(1, 0, 0);
                makeText.show();
            }
        }
    }

    public class b implements OnSelectionListener {
        public b() {
        }

        public final void onClick(String str) {
            AddLoyaltyFragment addLoyaltyFragment = AddLoyaltyFragment.this;
            addLoyaltyFragment.loyalty_bank.setText(str);
            addLoyaltyFragment.f4398a.dismiss();
            addLoyaltyFragment.f4400c = C1058d.e(str);
        }
    }

    public class d extends Subscriber<StatusDTO> {
        public final /* synthetic */ ProgressDialog a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Context f4402a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ EditText f4403a;

        public d(ProgressDialog progressDialog, EditText editText, Context context) {
            this.a = progressDialog;
            this.f4403a = editText;
            this.f4402a = context;
        }

        public final void onCompleted() {
            int i = AddLoyaltyFragment.c;
            this.a.dismiss();
        }

        public final void onError(Throwable th) {
            this.a.dismiss();
            int i = AddLoyaltyFragment.c;
            xx.S(th, true, th);
        }

        public final void onNext(Object obj) {
            StatusDTO statusDTO = (StatusDTO) obj;
            this.a.dismiss();
            AddLoyaltyFragment addLoyaltyFragment = AddLoyaltyFragment.this;
            if (statusDTO == null) {
                int i = AddLoyaltyFragment.c;
                C0535I5.m(this.f4402a, false, addLoyaltyFragment.getString(R.string.unble_to_request_try_sometime), addLoyaltyFragment.getString(R.string.error), addLoyaltyFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (statusDTO.getError() == null) {
                int i2 = AddLoyaltyFragment.c;
                C0535I5.p(addLoyaltyFragment.a, false, statusDTO.getStatus(), addLoyaltyFragment.getString(R.string.info), addLoyaltyFragment.getString(R.string.OK), new C1017d(this), (String) null, (DialogInterface.OnClickListener) null).show();
            } else {
                this.f4403a.setText("");
                C0535I5.m(this.f4402a, false, statusDTO.getError(), addLoyaltyFragment.getString(R.string.error), addLoyaltyFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    static {
        C1354qp.R(AddLoyaltyFragment.class);
    }

    @OnClick({2131363407})
    public void OtpLayoutClick() {
        this.otpLayout.setVisibility(8);
    }

    @OnClick({2131364810})
    public void VerifyButtonClick() {
        if (!this.otpNumber.getText().toString().trim().equals("")) {
            Context context = this.a;
            EditText editText = this.loyaltyNumber;
            EditText editText2 = this.otpNumber;
            if (!C0535I5.O((ConnectivityManager) context.getSystemService("connectivity"), getContext())) {
                new Handler().postDelayed(new C0743X(), 5000);
                return;
            }
            ProgressDialog progressDialog = new ProgressDialog(this.a);
            progressDialog.setMessage(getString(R.string.please_wait_text));
            progressDialog.setTitle(getString(R.string.adding_loyalty_account));
            progressDialog.setProgressStyle(0);
            progressDialog.show();
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).U(xx.D(C0657Qt.g(), "addLoyaltyAccount", String.format("/%s/%s", new Object[]{editText.getText(), editText2.getText()})), this.f4400c).c(C1181iv.a()).a(E0.a()).b(new C0774a0(this, progressDialog, context));
            return;
        }
        C0535I5.t0(this.a, getString(R.string.Please_Enter_OTP));
    }

    public final void f(Context context, EditText editText) {
        if (!C0535I5.O((ConnectivityManager) this.a.getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new c(), 5000);
            return;
        }
        ProgressDialog progressDialog = new ProgressDialog(this.a);
        progressDialog.setMessage(getString(R.string.please_wait_text));
        progressDialog.setTitle(getString(R.string.sending_otp));
        progressDialog.setProgressStyle(0);
        progressDialog.show();
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).o(xx.D(C0657Qt.g(), "addLoyaltyAccountOtp", String.format("/%s", new Object[]{editText.getText()})), this.f4400c).c(C1181iv.a()).a(E0.a()).b(new d(progressDialog, editText, context));
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_loyalty_account, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.a = getContext();
        this.f4397a = getActivity();
        HomeActivity.G(getString(R.string.send_otp));
        HomeActivity.x();
        HomeActivity.p();
        this.f4399a = new ArrayList<>();
        this.b = C1450w1.f7022c;
        HomeActivity.f4190d.setOnClickListener(new a());
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 1);
        this.loyaltyNumber.requestFocus();
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    @OnClick({2131363103})
    public void onLoyaltyBankClick(View view) {
        ArrayList<String> arrayList;
        int i = 0;
        while (true) {
            int size = C1450w1.f7017b.size();
            arrayList = this.f4401c;
            if (i >= size) {
                break;
            }
            arrayList.add(C1450w1.f7017b.get(i).getSoftAccountSummaryDTO().getBankName());
            i++;
        }
        if (this.b != null) {
            this.f4399a.clear();
            Iterator<C1187j2> it = this.b.iterator();
            while (it.hasNext()) {
                String f = C1058d.f(String.valueOf(it.next().getBankId()));
                if (f != null && !arrayList.contains(f)) {
                    this.f4399a.add(f);
                }
            }
        }
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4398a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4398a.show(getActivity().getSupportFragmentManager(), "");
        this.f4398a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), this.f4399a, new b());
        this.f4398a.g().setText(getString(R.string.select_bank_name));
        this.f4398a.f().setAdapter(customAdapter);
    }

    @OnClick({2131362543})
    public void onLoyaltyNumberClick(View view) {
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 1);
        this.loyaltyNumber.requestFocus();
    }

    public final void onPause() {
        super.onPause();
        HomeActivity.p();
    }

    @OnClick({2131364567})
    public void onResendOtpClick(View view) {
        f(this.a, this.loyaltyNumber);
    }

    public final void onResume() {
        super.onResume();
        HomeActivity.p();
    }

    public final void onStop() {
        super.onStop();
    }

    public class c implements Runnable {
        public final void run() {
        }
    }
}
