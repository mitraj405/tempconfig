package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import defpackage.d7;
import rx.Subscriber;

public class LoginWaitActivity extends AppCompatActivity {
    public static final /* synthetic */ int d = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public C0816cB f4224a;

    /* renamed from: a  reason: collision with other field name */
    public a f4225a;

    /* renamed from: a  reason: collision with other field name */
    public final e f4226a = new e();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4227a = false;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f4228a = new int[6];
    public boolean b = false;
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public boolean f4229c = false;

    /* renamed from: d  reason: collision with other field name */
    public boolean f4230d = false;
    @BindView(2131362766)
    TextView header_msg;
    @BindView(2131363277)
    AdManagerAdView mAdView;
    @BindView(2131363404)
    EditText otpInput;
    @BindView(2131363420)
    RelativeLayout otp_verify;
    @BindView(2131363421)
    TextView otp_verify_ll;
    @BindView(2131363538)
    ProgressBar progressBar;
    @BindView(2131363539)
    TextView progressStatus;
    @BindView(2131364568)
    TextView resendTimmer;
    @BindView(2131363678)
    TextView resend_opt;

    public class b implements Runnable {
        public int c = 0;

        public b() {
        }

        public final void run() {
            LoginWaitActivity loginWaitActivity = LoginWaitActivity.this;
            loginWaitActivity.progressBar.getIndeterminateDrawable().setColorFilter(loginWaitActivity.f4228a[this.c % 6], PorterDuff.Mode.SRC_ATOP);
            int i = this.c + 1;
            this.c = i;
            if (i == 6) {
                this.c = 0;
            }
        }
    }

    public class d extends Subscriber<E4> {
        public d() {
        }

        public final void onCompleted() {
            int i = LoginWaitActivity.d;
        }

        public final void onError(Throwable th) {
            int i = LoginWaitActivity.d;
            th.getClass();
            th.getMessage();
            LoginWaitActivity.this.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            E4 e4 = (E4) obj;
            LoginWaitActivity loginWaitActivity = LoginWaitActivity.this;
            if (e4 != null) {
                ObjectMapper h = C0657Qt.h();
                try {
                    if (e4.getError() == null) {
                        C1450w1.f7025d = System.currentTimeMillis();
                        h.writeValueAsString(e4);
                        int i = LoginWaitActivity.d;
                        if (e4.getStatus() != null) {
                            C0535I5.m(LoginWaitActivity.this, false, e4.getStatus(), loginWaitActivity.getString(R.string.OK), loginWaitActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        }
                        loginWaitActivity.otpInput.setText("");
                        new v(this).start();
                        loginWaitActivity.a.dismiss();
                        return;
                    }
                    loginWaitActivity.a.dismiss();
                    C0535I5.m(loginWaitActivity.getApplicationContext(), false, e4.getError(), loginWaitActivity.getString(R.string.error), loginWaitActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } catch (Exception e) {
                    loginWaitActivity.a.dismiss();
                    int i2 = LoginWaitActivity.d;
                    e.getMessage();
                }
            } else {
                loginWaitActivity.a.dismiss();
                C0535I5.m(loginWaitActivity.getApplicationContext(), false, loginWaitActivity.getResources().getString(R.string.unable_process_message), loginWaitActivity.getString(R.string.error), loginWaitActivity.getString(R.string.OK), loginWaitActivity.f4226a).show();
            }
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            LoginWaitActivity.this.resendOtp();
        }
    }

    static {
        C1354qp.R(LoginWaitActivity.class);
    }

    @OnClick({2131363421})
    public void VerifyOtp() {
        int i;
        if (xx.T(this.otpInput, "") || this.otpInput.getText().toString() == null) {
            C0535I5.t0(getBaseContext(), getString(R.string.please_enter_otp_value));
        } else if (!C0535I5.O((ConnectivityManager) getSystemService("connectivity"), getApplicationContext())) {
            new Handler().postDelayed(new C0596Mi(), 5000);
        } else {
            C0793b1 b1Var = C0793b1.a;
            if (b1Var.f3912a != null) {
                if (C0535I5.f3625a) {
                    i = 2;
                } else {
                    i = 1;
                }
                this.a = ProgressDialog.show(this, getString(R.string.getting_user_profile), getString(R.string.please_wait_text));
                ((Om) C0657Qt.c(b1Var.f3912a)).m(C1058d.z(C0657Qt.f(), "validateUser"), String.valueOf(i), this.otpInput.getText().toString()).c(C1181iv.a()).a(E0.a()).b(new w(this));
            }
        }
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    public final void onBackPressed() {
        C0793b1.a.f3912a = null;
        if (this.f4229c) {
            finish();
        } else if (this.otp_verify.getVisibility() == 0) {
            this.otp_verify.setVisibility(8);
            finish();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_login_wait);
        ButterKnife.bind((Activity) this);
        C0535I5.f3636d.clear();
        C0535I5.f3640e.clear();
        Bundle extras = getIntent().getExtras();
        this.f4227a = extras.getBoolean("fromLoginActivity");
        this.f4230d = extras.getBoolean("withOtpFlag");
        this.b = extras.getBoolean("fromPinValidationActivity");
        this.c = extras.getInt("isDashBoardLanding");
        Context applicationContext = getApplicationContext();
        Object obj = d7.a;
        int a2 = d7.b.a(applicationContext, R.color.red);
        int[] iArr = this.f4228a;
        iArr[0] = a2;
        iArr[1] = d7.b.a(getApplicationContext(), R.color.indigo);
        iArr[2] = d7.b.a(getApplicationContext(), R.color.purple);
        iArr[3] = d7.b.a(getApplicationContext(), R.color.blue);
        iArr[4] = d7.b.a(getApplicationContext(), R.color.pink);
        iArr[5] = d7.b.a(getApplicationContext(), R.color.teal);
        C0535I5.Y(this, this.mAdView, (GoogleAdParamDTO) null);
        this.f4225a = new a();
        this.progressStatus.setText(getString(R.string.establishing_secure_connection));
        this.progressStatus.setTextColor(getResources().getColor(R.color.white));
        getApplicationContext();
        new C1239le(this.f4225a);
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        C0816cB cBVar = this.f4224a;
        synchronized (cBVar) {
            cBVar.f3931a.removeCallbacks(cBVar.f3932a);
        }
    }

    public final void onRestart() {
        super.onRestart();
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
        if (this.f4224a == null) {
            this.f4224a = new C0816cB(new b());
        }
        this.f4224a.a();
    }

    public final void onStop() {
        super.onStop();
        C0816cB cBVar = this.f4224a;
        synchronized (cBVar) {
            cBVar.f3931a.removeCallbacks(cBVar.f3932a);
        }
    }

    @OnClick({2131363420})
    public void otpVerifyLayoutClick() {
        if (this.otp_verify.getVisibility() == 0) {
            C0793b1.a.f3912a = null;
            this.otp_verify.setVisibility(8);
            finish();
            return;
        }
        this.otp_verify.setVisibility(0);
    }

    @OnClick({2131363678})
    public void resendOtp() {
        if (!C0535I5.O((ConnectivityManager) getSystemService("connectivity"), getApplicationContext())) {
            new Handler().postDelayed(new c(), 5000);
            return;
        }
        C0793b1 b1Var = C0793b1.a;
        if (b1Var.f3912a != null) {
            this.a = ProgressDialog.show(this, getString(R.string.Resending_OTP), getString(R.string.please_wait_text), false, false);
            String f = C0657Qt.f();
            String format = String.format("/%s", new Object[]{"LOGIN"});
            ((Om) C0657Qt.c(b1Var.f3912a)).T(f + "resendOTP" + format).c(C1181iv.a()).a(E0.a()).b(new d());
            return;
        }
        C0535I5.m(this, false, getResources().getString(R.string.data_connection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    public class a extends Subscriber<String> {
        public a() {
        }

        public final void onError(Throwable th) {
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            String str = (String) obj;
            if (str != null) {
                boolean equals = str.equals("verifyuser");
                int i = 1;
                LoginWaitActivity loginWaitActivity = LoginWaitActivity.this;
                if (equals) {
                    loginWaitActivity.progressStatus.setText(loginWaitActivity.getString(R.string.verify_user));
                    loginWaitActivity.progressStatus.setTextColor(loginWaitActivity.getResources().getColor(R.color.white));
                    if (!C0535I5.O((ConnectivityManager) loginWaitActivity.getSystemService("connectivity"), loginWaitActivity.getBaseContext())) {
                        new Handler().postDelayed(new Ni(), 5000);
                        return;
                    }
                    C1223kn knVar = C0793b1.a.f3912a;
                    if (knVar != null) {
                        if (C0535I5.f3625a) {
                            i = 2;
                        }
                        ((Om) C0657Qt.c(knVar)).T0(C1058d.z(C0657Qt.f(), "validateUser"), String.valueOf(i)).c(C1181iv.a()).a(E0.a()).b(new Si(loginWaitActivity));
                    }
                } else if (str.equals("errorgeneckey")) {
                    loginWaitActivity.f4229c = true;
                    loginWaitActivity.progressStatus.setText(loginWaitActivity.getString(R.string.error_in_establishing_secure_connection));
                    loginWaitActivity.progressStatus.setTextColor(loginWaitActivity.getResources().getColor(R.color.white));
                }
            }
        }

        public final void onCompleted() {
        }
    }

    public class c implements Runnable {
        public final void run() {
        }
    }
}
