package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import defpackage.d7;
import rx.Subscriber;

public class VikalpSystemFragment extends Fragment implements View.OnTouchListener {
    public static final /* synthetic */ int c = 0;
    public final F4 a = new F4();

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f5198a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f5199a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f5200a;

    /* renamed from: a  reason: collision with other field name */
    public final GoogleAdParamDTO f5201a = new GoogleAdParamDTO();

    /* renamed from: a  reason: collision with other field name */
    public final d f5202a = new d();
    @BindView(2131362125)
    ImageView captcha;
    @BindView(2131362128)
    EditText captchaInput;
    @BindView(2131362126)
    ImageView captchaRefresh;
    @BindView(2131363102)
    TextView loadingCaptcha;
    @BindView(2131363385)
    AdManagerAdView optvikalp_otp;
    @BindView(2131363384)
    AdManagerAdView optvikalpbottom;
    @BindView(2131363407)
    RelativeLayout otpLayout;
    @BindView(2131362572)
    EditText pnrNumber;
    @BindView(2131364567)
    TextView resendOtp;
    @BindView(2131364776)
    TextView termsAndConditions;
    @BindView(2131362585)
    EditText trainNumber;
    @BindView(2131364810)
    TextView verifyOtp;
    @BindView(2131364843)
    EditText vikalpOtp;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            String str;
            int i = VikalpSystemFragment.c;
            VikalpSystemFragment vikalpSystemFragment = VikalpSystemFragment.this;
            String j = vikalpSystemFragment.j();
            if (j.equalsIgnoreCase("ok")) {
                vikalpSystemFragment.g(1);
                z = true;
            } else {
                vikalpSystemFragment.h(1, j);
                z = false;
            }
            String k = vikalpSystemFragment.k();
            if (k.equalsIgnoreCase("ok")) {
                vikalpSystemFragment.g(2);
                z2 = true;
            } else {
                vikalpSystemFragment.h(2, k);
                z2 = false;
            }
            String i2 = vikalpSystemFragment.i();
            if (i2.equalsIgnoreCase("ok")) {
                vikalpSystemFragment.g(3);
                z3 = true;
            } else {
                vikalpSystemFragment.h(3, i2);
                z3 = false;
            }
            if (!z || !z2 || !z3) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                C0674S1 s1 = new C0674S1();
                s1.setTrainNumber(vikalpSystemFragment.trainNumber.getText().toString());
                s1.setPnrNumber(vikalpSystemFragment.pnrNumber.getText().toString());
                s1.setCaptchaAnswer(vikalpSystemFragment.captchaInput.getText().toString());
                s1.setTokenKey(vikalpSystemFragment.a.getCaptchaToken());
                if (!C0535I5.O((ConnectivityManager) vikalpSystemFragment.getActivity().getSystemService("connectivity"), vikalpSystemFragment.getContext())) {
                    new Handler().postDelayed(new C1130gD(), 5000);
                } else {
                    vikalpSystemFragment.captcha.setVisibility(8);
                    vikalpSystemFragment.loadingCaptcha.setVisibility(0);
                    if (C0535I5.c == 2) {
                        str = "Y";
                    } else {
                        str = "N";
                    }
                    vikalpSystemFragment.f5198a = ProgressDialog.show(vikalpSystemFragment.f5199a, vikalpSystemFragment.getString(R.string.validating_Details), vikalpSystemFragment.getString(R.string.please_wait_text), false, false);
                    ((Om) C0657Qt.b()).X(C0657Qt.m() + "atasPnrEnquy", s1, str).c(C1181iv.a()).a(E0.a()).b(new P0(vikalpSystemFragment, s1));
                    vikalpSystemFragment.captchaInput.setText("");
                }
                vikalpSystemFragment.resendOtp.setClickable(false);
                new Handler().postDelayed(new Q0(vikalpSystemFragment), 5000);
                vikalpSystemFragment.resendOtp.setClickable(true);
                vikalpSystemFragment.verifyOtp.setClickable(true);
            } else if (vikalpSystemFragment.j().equals("ok") && vikalpSystemFragment.k().equals("ok") && vikalpSystemFragment.i().equals("ok")) {
                Toast makeText = Toast.makeText(vikalpSystemFragment.f5199a, vikalpSystemFragment.getString(R.string.validation_failed1), 1);
                makeText.setGravity(1, 0, 0);
                makeText.show();
            }
        }
    }

    public class c extends Subscriber<F4> {
        public c() {
        }

        public final void onCompleted() {
            int i = VikalpSystemFragment.c;
        }

        public final void onError(Throwable th) {
            int i = VikalpSystemFragment.c;
            th.getClass();
            th.getMessage();
            VikalpSystemFragment.this.f5198a.dismiss();
            Mt.a(th);
        }

        public final void onNext(Object obj) {
            F4 f4 = (F4) obj;
            VikalpSystemFragment vikalpSystemFragment = VikalpSystemFragment.this;
            if (f4 != null) {
                try {
                    C0657Qt.h();
                    if (f4.getCaptchaQuestion() == null || f4.getCaptchaQuestion().equals("")) {
                        vikalpSystemFragment.captcha.setVisibility(8);
                        vikalpSystemFragment.loadingCaptcha.setVisibility(0);
                    } else {
                        vikalpSystemFragment.loadingCaptcha.setVisibility(8);
                        int i = VikalpSystemFragment.c;
                        f4.getCaptchaQuestion();
                        f4.getCaptchaQuestion().getBytes().toString();
                        byte[] decode = Base64.decode(f4.getCaptchaQuestion().getBytes(), 0);
                        vikalpSystemFragment.captcha.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                        vikalpSystemFragment.captcha.setVisibility(0);
                        vikalpSystemFragment.a.setCaptchaToken(f4.getCaptchaToken());
                        vikalpSystemFragment.captchaInput.setTextColor(vikalpSystemFragment.getResources().getColor(R.color.black_90_opa));
                    }
                    vikalpSystemFragment.f5198a.dismiss();
                } catch (Exception e) {
                    vikalpSystemFragment.f5198a.dismiss();
                    int i2 = VikalpSystemFragment.c;
                    e.getMessage();
                }
            } else {
                vikalpSystemFragment.f5198a.dismiss();
                C0535I5.m(vikalpSystemFragment.f5199a, false, vikalpSystemFragment.getResources().getString(R.string.unable_process_message), vikalpSystemFragment.getString(R.string.error), vikalpSystemFragment.getString(R.string.OK), vikalpSystemFragment.f5202a).show();
            }
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            VikalpSystemFragment.this.f();
        }
    }

    static {
        C1354qp.R(VikalpSystemFragment.class);
    }

    public final void f() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new b(), 5000);
            return;
        }
        this.captcha.setVisibility(8);
        this.loadingCaptcha.setVisibility(0);
        this.f5198a = ProgressDialog.show(this.f5199a, getString(R.string.Loading_Captcha), getString(R.string.please_wait_text), false, false);
        String m = C0657Qt.m();
        ((Om) C0657Qt.e()).r1(m + "generateCaptcha").c(C1181iv.a()).a(E0.a()).b(new c());
        this.captchaInput.setText("");
    }

    public final void g(int i) {
        if (i == 1) {
            this.pnrNumber.setError((CharSequence) null);
            this.pnrNumber.setTextColor(-16777216);
        } else if (i == 2) {
            this.trainNumber.setError((CharSequence) null);
            this.trainNumber.setTextColor(-16777216);
        } else if (i == 3) {
            this.captchaInput.setError((CharSequence) null);
            this.captchaInput.setTextColor(-1);
        }
    }

    public final void h(int i, String str) {
        if (i == 1) {
            this.pnrNumber.setError(str);
            this.pnrNumber.setTextColor(-65536);
        } else if (i == 2) {
            this.trainNumber.setError(str);
            this.trainNumber.setTextColor(-65536);
        } else if (i == 3) {
            this.captchaInput.setError(str);
            this.captchaInput.setTextColor(-65536);
        }
    }

    public final String i() {
        if (this.captchaInput.getText() == null || this.captchaInput.getText().toString().trim().length() != 0) {
            return "ok";
        }
        return getString(R.string.enter_captcha);
    }

    public final String j() {
        if (lf.e(this.pnrNumber) == 0) {
            return getString(R.string.enter_pnr);
        }
        if (lf.e(this.pnrNumber) != 10) {
            return "Invalid PNR";
        }
        return "ok";
    }

    public final String k() {
        if (lf.e(this.trainNumber) == 0) {
            return getString(R.string.enter_train_number);
        }
        if (lf.e(this.trainNumber) != 5) {
            return "Invalid Train Number";
        }
        return "ok";
    }

    @OnClick({2131362126})
    public void onCaptchaRefreshClick(View view) {
        f();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_vikalp_system_tickets, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        getArguments();
        this.f5199a = getContext();
        this.f5200a = getActivity();
        HomeActivity.G(getString(R.string.send_otp));
        this.pnrNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        this.trainNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        f();
        EditText editText = this.pnrNumber;
        editText.setInputType(2);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        EditText editText2 = this.trainNumber;
        editText2.setInputType(2);
        editText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getString(R.string.TndC_system_tkt_vikalp));
        Context context = this.f5199a;
        Object obj = d7.a;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(d7.b.a(context, R.color.light_yellow));
        StyleSpan styleSpan = new StyleSpan(1);
        C1107fD fDVar = new C1107fD(this);
        try {
            spannableStringBuilder.setSpan(styleSpan, 32, 50, 18);
            spannableStringBuilder.setSpan(fDVar, 32, 50, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, 32, 50, 18);
        } catch (Exception e) {
            e.getMessage();
        }
        this.termsAndConditions.setText(spannableStringBuilder);
        this.termsAndConditions.setMovementMethod(LinkMovementMethod.getInstance());
        HomeActivity.x();
        HomeActivity.p();
        String str = C1450w1.f7009a;
        GoogleAdParamDTO googleAdParamDTO = this.f5201a;
        googleAdParamDTO.setAge(str);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.optvikalpbottom, googleAdParamDTO);
        HomeActivity.f4190d.setOnClickListener(new a());
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f5198a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f5198a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364810})
    public void onNext(View view) {
        String str;
        boolean z;
        if (this.vikalpOtp.getText() == null || !this.vikalpOtp.getText().toString().trim().isEmpty()) {
            str = "ok";
        } else {
            str = "Enter OTP";
        }
        if (str.equalsIgnoreCase("ok")) {
            this.vikalpOtp.setError((CharSequence) null);
            this.vikalpOtp.setTextColor(-16777216);
            z = true;
        } else {
            this.vikalpOtp.setError(str);
            this.vikalpOtp.setTextColor(-65536);
            z = false;
        }
        if (z) {
            String obj = this.pnrNumber.getText().toString();
            String obj2 = this.vikalpOtp.getText().toString();
            if (!C0535I5.O((ConnectivityManager) this.f5199a.getSystemService("connectivity"), getContext())) {
                new Handler().postDelayed(new C1086eD(), 5000);
                return;
            }
            this.f5198a = ProgressDialog.show(this.f5199a, getString(R.string.verifying_otp), getString(R.string.please_wait_text), false, false);
            ((Om) C0657Qt.b()).k(C0657Qt.m() + "atasTrainEnq" + String.format("/%s/%s", new Object[]{obj, obj2})).c(C1181iv.a()).a(E0.a()).b(new O0(this));
        }
    }

    public final void onPause() {
        super.onPause();
        HomeActivity.p();
        ProgressDialog progressDialog = this.f5198a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f5198a.dismiss();
        }
        C0535I5.u();
    }

    @OnTextChanged({2131362572})
    public void onPnrTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 10) {
            String j = j();
            if (j.equalsIgnoreCase("ok")) {
                g(1);
            } else {
                h(1, j);
            }
            this.pnrNumber.clearFocus();
            this.trainNumber.requestFocus();
        }
    }

    @OnClick({2131364567})
    public void onResendOtpClick(View view) {
        Context context = this.f5199a;
        TextView textView = this.resendOtp;
        if (!C0535I5.O((ConnectivityManager) context.getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new C1174iD(), 5000);
            return;
        }
        textView.setClickable(false);
        textView.setTextColor(this.f5199a.getResources().getColor(R.color.black_50_opa));
        ProgressDialog progressDialog = new ProgressDialog(this.f5199a);
        progressDialog.setMessage(getString(R.string.please_wait_text));
        progressDialog.setTitle(getString(R.string.sending_otp));
        progressDialog.setProgressStyle(0);
        progressDialog.show();
        String m = C0657Qt.m();
        String format = String.format("/%s", new Object[]{this.pnrNumber.getText().toString()});
        ((Om) C0657Qt.b()).X0(m + "resendOTP" + format).c(C1181iv.a()).a(E0.a()).b(new C1065dD(this, progressDialog, textView, context));
    }

    public final void onResume() {
        super.onResume();
        HomeActivity.p();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f5198a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f5198a.dismiss();
        }
        C0535I5.u();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() != R.id.scrollView) {
            return false;
        }
        C0535I5.I(getActivity());
        return false;
    }

    @OnTextChanged({2131362585})
    public void onTrainNumberTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 5) {
            String k = k();
            if (k.equalsIgnoreCase("ok")) {
                g(2);
            } else {
                h(2, k);
            }
            this.trainNumber.clearFocus();
            this.captchaInput.requestFocus();
        }
    }

    @OnClick({2131363407})
    public void otpLayoutClick(View view) {
        if (this.otpLayout.getVisibility() == 8) {
            this.otpLayout.setVisibility(0);
            C0535I5.Y(getActivity(), this.optvikalp_otp, this.f5201a);
            return;
        }
        this.otpLayout.setVisibility(8);
    }

    public class b implements Runnable {
        public final void run() {
        }
    }
}
