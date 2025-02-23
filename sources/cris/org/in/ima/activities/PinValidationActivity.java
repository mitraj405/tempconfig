package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.h;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import defpackage.d7;
import java.util.Date;
import java.util.concurrent.Executor;
import rx.Subscriber;

public class PinValidationActivity extends AppCompatActivity {
    public static final /* synthetic */ int g = 0;
    public C0479D5 a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4277a = null;

    /* renamed from: a  reason: collision with other field name */
    public EditText f4278a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f4279a;

    /* renamed from: a  reason: collision with other field name */
    public BiometricPrompt.d f4280a;

    /* renamed from: a  reason: collision with other field name */
    public BiometricPrompt f4281a;

    /* renamed from: a  reason: collision with other field name */
    public C0793b1 f4282a;

    /* renamed from: a  reason: collision with other field name */
    public final k f4283a = new k();

    /* renamed from: a  reason: collision with other field name */
    public PinValidationActivity f4284a;

    /* renamed from: a  reason: collision with other field name */
    public Date f4285a;

    /* renamed from: a  reason: collision with other field name */
    public Executor f4286a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4287a = false;
    @BindView(2131361924)
    TextView agent_login;
    public TextView b;

    /* renamed from: b  reason: collision with other field name */
    public PinValidationActivity f4288b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4289b = false;
    @BindView(2131362146)
    CheckBox bkgWithOTP;
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public TextView f4290c;

    /* renamed from: c  reason: collision with other field name */
    public String f4291c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f4292c = false;
    @BindView(2131362125)
    ImageView captcha;
    @BindView(2131364327)
    EditText captchaInputValue;
    @BindView(2131362124)
    LinearLayout captchaLayout;
    public int d = -1;

    /* renamed from: d  reason: collision with other field name */
    public String f4293d;
    public final int e = 3;

    /* renamed from: e  reason: collision with other field name */
    public String f4294e;
    public int f = 0;

    /* renamed from: f  reason: collision with other field name */
    public String f4295f;
    @BindView(2131364410)
    TextView fingerPrintMsg;
    @BindView(2131363026)
    LinearLayout fingerprintIcon;

    /* renamed from: g  reason: collision with other field name */
    public final String f4296g = "";
    @BindView(2131363010)
    LinearLayout ll_bus;
    @BindView(2131364466)
    TextView loading_Captcha;
    @BindView(2131363944)
    TextView otpTimmer;
    @BindView(2131363408)
    TextView otp_message;
    @BindView(2131363409)
    LinearLayout otp_send_msg;
    @BindView(2131363505)
    AdManagerAdView pinvalidation_bottom_ads;
    @BindView(2131363734)
    LinearLayout rl_hotel;
    @BindView(2131363757)
    RelativeLayout search;
    @BindView(2131363064)
    LinearLayout sendOtp;
    @BindView(2131363945)
    TextView sendOtpTv;
    @BindView(2131364908)
    TextView with_otp_tv;
    @BindView(2131364910)
    TextView with_pin_tv;

    public class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ String c;

        public a(String str) {
            this.c = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            PinValidationActivity pinValidationActivity = PinValidationActivity.this;
            Bw e = Bw.e(pinValidationActivity.getApplicationContext());
            String str = this.c;
            if (str.equalsIgnoreCase("changeUser")) {
                e.w("OFF");
            }
            e.A((String) null);
            e.C((String) null);
            e.B((String) null);
            e.F((String) null);
            e.x((String) null);
            e.z((String) null);
            e.D((String) null);
            e.E(-1);
            pinValidationActivity.finish();
            Intent intent = new Intent(pinValidationActivity, LoginActivity.class);
            if (str.equalsIgnoreCase("lockOut")) {
                intent.putExtra("forgotPin", true);
            }
            intent.putExtra("isDashBoardLanding", pinValidationActivity.c);
            pinValidationActivity.finish();
            pinValidationActivity.startActivity(intent);
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ String c;

        public b(String str) {
            this.c = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            PinValidationActivity pinValidationActivity = PinValidationActivity.this;
            Bw e = Bw.e(pinValidationActivity.getApplicationContext());
            String str = this.c;
            if (str.equalsIgnoreCase("changeUser")) {
                e.w("OFF");
            }
            e.A((String) null);
            e.C((String) null);
            e.B((String) null);
            e.F((String) null);
            e.x((String) null);
            e.z((String) null);
            e.D((String) null);
            e.E(-1);
            pinValidationActivity.finish();
            Intent intent = new Intent(pinValidationActivity, LoginActivity.class);
            if (str.equalsIgnoreCase("forgotPin")) {
                intent.putExtra("forgotPin", true);
            }
            intent.putExtra("isDashBoardLanding", pinValidationActivity.c);
            pinValidationActivity.finish();
            pinValidationActivity.startActivity(intent);
        }
    }

    public class c extends Subscriber<C1223kn> {
        public c() {
        }

        public final void onCompleted() {
            PinValidationActivity.this.f4277a.dismiss();
            AlertDialog alertDialog = C0535I5.f3619a;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:10|11) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r3 = cris.org.in.ima.activities.PinValidationActivity.g;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onError(java.lang.Throwable r14) {
            /*
                r13 = this;
                java.lang.String r0 = ""
                cris.org.in.ima.activities.PinValidationActivity r1 = cris.org.in.ima.activities.PinValidationActivity.this
                r2 = 2131953888(0x7f1308e0, float:1.954426E38)
                defpackage.C0657Qt.a()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                android.app.ProgressDialog r3 = r1.f4277a     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r3.dismiss()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                int r3 = cris.org.in.ima.activities.PinValidationActivity.g     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r14.getClass()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r14.getMessage()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                boolean r3 = r14 instanceof retrofit2.HttpException     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r4 = 0
                if (r3 == 0) goto L_0x0048
                r3 = r14
                retrofit2.HttpException r3 = (retrofit2.HttpException) r3     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                retrofit2.Response r3 = r3.response()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                okhttp3.ResponseBody r5 = r3.errorBody()     // Catch:{ Exception -> 0x003f }
                if (r5 == 0) goto L_0x0048
                okhttp3.ResponseBody r3 = r3.errorBody()     // Catch:{ Exception -> 0x003f }
                java.lang.String r3 = r3.string()     // Catch:{ Exception -> 0x003f }
                com.fasterxml.jackson.databind.ObjectMapper r5 = defpackage.C0657Qt.h()     // Catch:{ Exception -> 0x003f }
                java.lang.Class<kn> r6 = defpackage.C1223kn.class
                java.lang.Object r3 = r5.readValue((java.lang.String) r3, r6)     // Catch:{ Exception -> 0x003f }
                kn r3 = (defpackage.C1223kn) r3     // Catch:{ Exception -> 0x003f }
                r4 = r3
                goto L_0x0048
            L_0x003f:
                int r3 = cris.org.in.ima.activities.PinValidationActivity.g     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                goto L_0x0048
            L_0x0042:
                r14 = move-exception
                goto L_0x010c
            L_0x0045:
                r14 = move-exception
                goto L_0x0120
            L_0x0048:
                java.lang.String r3 = r14.getMessage()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                java.lang.String r5 = "400"
                boolean r3 = r3.contains(r5)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                if (r3 == 0) goto L_0x0064
                android.content.Context r14 = r1.getBaseContext()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r0 = 2131953483(0x7f13074b, float:1.9543438E38)
                java.lang.String r0 = r1.getString(r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                defpackage.C0535I5.t0(r14, r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                goto L_0x0108
            L_0x0064:
                java.lang.String r14 = r14.getMessage()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                boolean r14 = r14.contains(r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                if (r14 == 0) goto L_0x00fa
                if (r4 == 0) goto L_0x00fa
                java.lang.String r14 = r4.getError_description()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                boolean r3 = r1.isFinishing()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                if (r3 != 0) goto L_0x0108
                java.lang.String r3 = "Bad credentials"
                boolean r3 = r14.equalsIgnoreCase(r3)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r5 = 2131952688(0x7f130430, float:1.9541826E38)
                r6 = 2131951928(0x7f130138, float:1.9540284E38)
                if (r3 == 0) goto L_0x00a3
                cris.org.in.ima.activities.PinValidationActivity r7 = cris.org.in.ima.activities.PinValidationActivity.this     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r8 = 0
                r14 = 2131953472(0x7f130740, float:1.9543416E38)
                java.lang.String r9 = r7.getString(r14)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                java.lang.String r10 = r1.getString(r5)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                java.lang.String r11 = r1.getString(r6)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r12 = 0
                android.app.AlertDialog r14 = defpackage.C0535I5.m(r7, r8, r9, r10, r11, r12)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r14.show()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                goto L_0x0108
            L_0x00a3:
                java.lang.String r3 = r4.getErrorMessage()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                if (r3 == 0) goto L_0x00d7
                cris.org.in.ima.activities.PinValidationActivity r7 = cris.org.in.ima.activities.PinValidationActivity.this     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r8 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r0.<init>()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                java.lang.String r3 = r4.getErrorMessage()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                java.lang.String r3 = r3.toUpperCase()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r0.append(r3)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                java.lang.String r3 = " : "
                r0.append(r3)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r0.append(r14)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                java.lang.String r9 = r0.toString()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                java.lang.String r10 = "Error"
                java.lang.String r11 = r1.getString(r6)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r12 = 0
                android.app.AlertDialog r14 = defpackage.C0535I5.m(r7, r8, r9, r10, r11, r12)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r14.show()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                goto L_0x0108
            L_0x00d7:
                cris.org.in.ima.activities.PinValidationActivity r3 = cris.org.in.ima.activities.PinValidationActivity.this     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r4 = 0
                boolean r0 = r14.equals(r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                if (r0 == 0) goto L_0x00e7
                r14 = 2131952934(0x7f130526, float:1.9542325E38)
                java.lang.String r14 = r1.getString(r14)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            L_0x00e7:
                java.lang.String r0 = r1.getString(r5)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                java.lang.String r7 = r1.getString(r6)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r8 = 0
                r5 = r14
                r6 = r0
                android.app.AlertDialog r14 = defpackage.C0535I5.m(r3, r4, r5, r6, r7, r8)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r14.show()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                goto L_0x0108
            L_0x00fa:
                android.content.Context r14 = r1.getBaseContext()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                r0 = 2131952536(0x7f130398, float:1.9541518E38)
                java.lang.String r0 = r1.getString(r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                defpackage.C0535I5.t0(r14, r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            L_0x0108:
                r1.p()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
                goto L_0x0133
            L_0x010c:
                int r0 = cris.org.in.ima.activities.PinValidationActivity.g
                r14.getMessage()
                android.content.Context r14 = r1.getBaseContext()
                java.lang.String r0 = r1.getString(r2)
                defpackage.C0535I5.t0(r14, r0)
                r1.finish()
                goto L_0x0133
            L_0x0120:
                int r0 = cris.org.in.ima.activities.PinValidationActivity.g
                r14.getMessage()
                android.content.Context r14 = r1.getBaseContext()
                java.lang.String r0 = r1.getString(r2)
                defpackage.C0535I5.t0(r14, r0)
                r1.finish()
            L_0x0133:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.PinValidationActivity.c.onError(java.lang.Throwable):void");
        }

        public final void onNext(Object obj) {
            String str;
            String str2;
            C1223kn knVar = (C1223kn) obj;
            PinValidationActivity pinValidationActivity = PinValidationActivity.this;
            pinValidationActivity.f4277a.dismiss();
            int i = C1507z0.a;
            Bundle bundle = new Bundle();
            bundle.putString("login_method", "token");
            IrctcImaApplication.f4146a.logEvent("logins", bundle);
            Bw e = Bw.e(pinValidationActivity.getApplicationContext());
            if (knVar.getError_description() != null && knVar.getError_description().equals("Bad credentials")) {
                pinValidationActivity.p();
                C0535I5.m(pinValidationActivity.f4284a, false, pinValidationActivity.getString(R.string.user_name_and_pass_notmatch), pinValidationActivity.getString(R.string.error), pinValidationActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (knVar.getError_description() != null) {
                pinValidationActivity.p();
                if (knVar.getError_description().equalsIgnoreCase("Bad credentials")) {
                    str2 = "Please enter valid Username or Password.";
                } else if (knVar.getError_description().contains("Access denied")) {
                    str2 = pinValidationActivity.getString(R.string.access_denied);
                } else {
                    str = knVar.getError_description();
                    if (str.contains("Biometric")) {
                        e.w("OFF");
                    }
                    C0535I5.m(pinValidationActivity, false, str, pinValidationActivity.getString(R.string.error), pinValidationActivity.getString(R.string.OK), new D(this, knVar)).show();
                }
                str = str2;
                C0535I5.m(pinValidationActivity, false, str, pinValidationActivity.getString(R.string.error), pinValidationActivity.getString(R.string.OK), new D(this, knVar)).show();
            } else if (!knVar.getAccess_token().isEmpty()) {
                pinValidationActivity.f4282a.f3912a = knVar;
                pinValidationActivity.f4278a.setText("");
                Intent intent = new Intent(pinValidationActivity, LoginWaitActivity.class);
                intent.putExtra("isDashBoardLanding", pinValidationActivity.c);
                intent.putExtra("fromPinValidationActivity", true);
                pinValidationActivity.finish();
                pinValidationActivity.startActivity(intent);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public final void onClick(View view) {
            PinValidationActivity.this.validatePin(view);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public final void onClick(View view) {
            PinValidationActivity.this.A("forgotPin");
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public final void onClick(View view) {
            PinValidationActivity.this.A("changeUser");
        }
    }

    public class g extends BiometricPrompt.a {
        public g() {
        }

        public final void a(int i) {
            PinValidationActivity pinValidationActivity = PinValidationActivity.this;
            pinValidationActivity.f4292c = false;
            pinValidationActivity.fingerprintIcon.setVisibility(0);
            if (i == 13) {
                pinValidationActivity.o();
            } else if (i == 10) {
                pinValidationActivity.o();
            } else if (i == 12) {
                pinValidationActivity.fingerprintIcon.setVisibility(4);
            } else if (i == 11) {
                Toast.makeText(pinValidationActivity.getApplicationContext(), pinValidationActivity.getResources().getString(R.string.biometric_authentication_disable_msg), 0).show();
                pinValidationActivity.fingerprintIcon.setVisibility(4);
            } else if (i == 7) {
                Toast.makeText(pinValidationActivity.getApplicationContext(), pinValidationActivity.getResources().getString(R.string.authentication_Failed_too_many_msg), 0).show();
                pinValidationActivity.o();
            } else {
                Toast.makeText(pinValidationActivity.getApplicationContext(), pinValidationActivity.getResources().getString(R.string.biometric_authentication_cancelled_msg), 0).show();
                pinValidationActivity.o();
            }
        }

        public final void b() {
            PinValidationActivity pinValidationActivity = PinValidationActivity.this;
            pinValidationActivity.f4292c = false;
            pinValidationActivity.fingerprintIcon.setVisibility(0);
        }

        public final void c() {
            PinValidationActivity pinValidationActivity = PinValidationActivity.this;
            pinValidationActivity.f4292c = true;
            TextView textView = pinValidationActivity.f4290c;
            textView.setText(pinValidationActivity.getString(R.string.finger_print_success_msg) + " " + Bw.e(pinValidationActivity.getApplicationContext()).h());
            pinValidationActivity.fingerPrintMsg.setVisibility(0);
            pinValidationActivity.f4278a.setVisibility(8);
            pinValidationActivity.fingerprintIcon.setVisibility(4);
            Toast.makeText(pinValidationActivity.getApplicationContext(), pinValidationActivity.getResources().getString(R.string.finger_print_success_msg2), 0).show();
            pinValidationActivity.x();
        }
    }

    public class j extends Subscriber<E4> {
        public j() {
        }

        public final void onCompleted() {
            int i = PinValidationActivity.g;
        }

        public final void onError(Throwable th) {
            int i = PinValidationActivity.g;
            th.getClass();
            th.getMessage();
            PinValidationActivity pinValidationActivity = PinValidationActivity.this;
            pinValidationActivity.f4277a.dismiss();
            Lt.b(th, pinValidationActivity.f4288b);
        }

        public final void onNext(Object obj) {
            E4 e4 = (E4) obj;
            PinValidationActivity pinValidationActivity = PinValidationActivity.this;
            if (e4 != null) {
                pinValidationActivity.f4285a = e4.getTimeStamp();
                try {
                    if (e4.getError() == null) {
                        pinValidationActivity.d = e4.getCaptcha().intValue();
                        pinValidationActivity.f4295f = e4.getStatus();
                        pinValidationActivity.f4277a.dismiss();
                        C1450w1.f7025d = System.currentTimeMillis();
                        int i = pinValidationActivity.d;
                        if (10 == i || 14 == i) {
                            PinValidationActivity.n(pinValidationActivity, e4.getCaptchaQuestion());
                            return;
                        }
                        return;
                    }
                    pinValidationActivity.f4277a.dismiss();
                    C0535I5.m(pinValidationActivity.f4284a, false, e4.getError(), pinValidationActivity.getString(R.string.error), pinValidationActivity.getString(R.string.OK), pinValidationActivity.f4283a).show();
                } catch (Exception e) {
                    pinValidationActivity.f4277a.dismiss();
                    int i2 = PinValidationActivity.g;
                    e.getMessage();
                }
            } else {
                pinValidationActivity.f4277a.dismiss();
                C0535I5.m(pinValidationActivity.f4284a, false, pinValidationActivity.getResources().getString(R.string.unable_process_message), pinValidationActivity.getString(R.string.error), pinValidationActivity.getString(R.string.OK), pinValidationActivity.f4283a).show();
            }
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            PinValidationActivity.this.o();
        }
    }

    static {
        C1354qp.R(PinValidationActivity.class);
    }

    public static void l(PinValidationActivity pinValidationActivity) {
        TextView textView = pinValidationActivity.with_otp_tv;
        Object obj = d7.a;
        textView.setTextColor(d7.b.a(pinValidationActivity, R.color.white));
    }

    public static void m(PinValidationActivity pinValidationActivity) {
        TextView textView = pinValidationActivity.with_pin_tv;
        Object obj = d7.a;
        textView.setTextColor(d7.b.a(pinValidationActivity, R.color.white));
    }

    public static void n(PinValidationActivity pinValidationActivity, String str) {
        pinValidationActivity.captchaLayout.setVisibility(0);
        pinValidationActivity.t(C0535I5.n);
        if (str == null || str.equals("")) {
            pinValidationActivity.captcha.setVisibility(8);
            pinValidationActivity.loading_Captcha.setVisibility(0);
            return;
        }
        pinValidationActivity.loading_Captcha.setVisibility(8);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        pinValidationActivity.captcha.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        pinValidationActivity.captcha.setVisibility(0);
    }

    public final void A(String str) {
        String string = getString(R.string.Forgot_Pin);
        String string2 = getString(R.string.please_re_enter_the_password);
        if (str.equalsIgnoreCase("changeUser")) {
            string = getString(R.string.changeRegisterUser);
            string2 = getString(R.string.change_register_user);
        }
        if (str.equalsIgnoreCase("lockOut")) {
            string = getString(R.string.Forgot_Pin);
            string2 = getString(R.string.max_try);
        }
        String str2 = string;
        String str3 = string2;
        if (str.equalsIgnoreCase("lockout")) {
            C0535I5.m(this, false, str3, str2, getString(R.string.ok), new a(str)).show();
            return;
        }
        C0535I5.p(this, false, str3, str2, getString(R.string.yes), new b(str), getString(R.string.no), (DialogInterface.OnClickListener) null).show();
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    public void changeUserId(View view) {
        A("changeUser");
    }

    @OnClick({2131363026})
    public void fingerprintIconOnCLick() {
        if (Bw.e(getApplicationContext()).c().equalsIgnoreCase("ON") && !this.f4292c) {
            this.f4281a.a(this.f4280a);
        }
    }

    @OnClick({2131363104})
    public void loginCaptchaRefresh() {
        o();
    }

    public final void o() {
        if (!C0535I5.O((ConnectivityManager) this.f4284a.getSystemService("connectivity"), this.f4284a)) {
            new Handler().postDelayed(new i(), 5000);
            return;
        }
        ProgressDialog progressDialog = this.f4277a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4277a.dismiss();
        }
        this.f4277a = ProgressDialog.show(this.f4284a, getString(R.string.refresh_Captcha), getString(R.string.please_wait_text), false, false);
        String f2 = C0657Qt.f();
        ((Om) C0657Qt.b()).L0(f2 + "loginCaptcha", "true").c(C1181iv.a()).a(E0.a()).b(new j());
        this.captchaInputValue.setText("");
    }

    @OnClick({2131361924})
    public void onAgentLoginClick(View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://irctc.co.in")));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131363708})
    public void onAirAppClick(View view) {
        try {
            startActivity(Intent.parseUri("https://www.air.irctc.co.in/?utm_source=dashboard", 1));
        } catch (Exception unused) {
            C0535I5.t0(getApplicationContext(), getString(R.string.error_opening_air_app));
        }
    }

    @OnClick({2131364309})
    public void onBackClick() {
        onBackPressed();
    }

    public final void onBackPressed() {
        super.onBackPressed();
        this.f4282a.f3912a = null;
        HomeActivity.f4186b = false;
        finish();
    }

    @OnClick({2131363714})
    public void onCateringAppClick(View view) {
        try {
            Intent parseUri = Intent.parseUri("market://details?id=com.irctc.fot", 1);
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage("com.irctc.fot");
            if (launchIntentForPackage != null) {
                startActivity(launchIntentForPackage);
            } else {
                startActivity(parseUri);
            }
        } catch (Exception unused) {
            C0535I5.t0(getApplicationContext(), "Error opening IRCTC Catering app.");
        }
    }

    @OnClick({2131362146})
    public void onCheckOtpBookingClick() {
        if (!this.bkgWithOTP.isChecked()) {
            this.bkgWithOTP.setChecked(false);
            C0535I5.f3620a = "N";
            int i2 = this.d;
            if ((10 == i2 || 14 == i2) && this.f4289b) {
                this.captchaLayout.setVisibility(0);
                return;
            }
            return;
        }
        this.bkgWithOTP.setChecked(true);
        C0535I5.f3620a = "OTP";
        this.captchaLayout.setVisibility(8);
    }

    @OnClick({2131364908})
    public void onClickOtp(View view) {
        C0535I5.n = true;
        t(true);
    }

    @OnClick({2131364910})
    public void onClickPin(View view) {
        C0535I5.n = false;
        t(false);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pin_validation);
        ButterKnife.bind((Activity) this);
        this.f4282a = C0793b1.a;
        this.f4284a = this;
        this.f4288b = this;
        Bw e2 = Bw.e(getApplicationContext());
        if (getIntent().getExtras() != null) {
            this.c = getIntent().getExtras().getInt("isDashBoardLanding");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.enter_pin) + " " + e2.h());
        this.f4278a = (EditText) findViewById(R.id.et_valid_pin);
        this.f4279a = (TextView) findViewById(R.id.tv_forgot_pin);
        this.b = (TextView) findViewById(R.id.tv_change_user);
        this.f4290c = (TextView) findViewById(R.id.tv_username);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.addRule(11, -1);
        this.b.setLayoutParams(layoutParams);
        try {
            spannableStringBuilder.setSpan(new StyleSpan(1), 14, spannableStringBuilder.length(), 18);
        } catch (Exception e3) {
            e3.getMessage();
        }
        C0535I5.H(this, getCurrentFocus());
        this.f4279a.setFilterTouchesWhenObscured(true);
        this.b.setFilterTouchesWhenObscured(true);
        this.search.setFilterTouchesWhenObscured(true);
        this.search.setFocusable(true);
        this.f4278a.setFocusableInTouchMode(true);
        this.f4278a.setFilterTouchesWhenObscured(true);
        this.f4278a.hasFocus();
        this.search.setOnClickListener(new d());
        this.f4279a.setOnClickListener(new e());
        this.b.setOnClickListener(new f());
        this.f4278a.addTextChangedListener(new C0479D5(this, 4));
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            TextView textView = this.f4290c;
            textView.setText(e2.h() + " " + getString(R.string.enter_four_digit_pin));
        } else {
            TextView textView2 = this.f4290c;
            textView2.setText(getString(R.string.enter_four_digit_pin) + " " + e2.h());
        }
        C0535I5.Y(this, this.pinvalidation_bottom_ads, (GoogleAdParamDTO) null);
        C0535I5.Q("CAPTCHA_ENABLE_TIME");
        if (e2.c().equalsIgnoreCase("ON")) {
            p();
            z();
            return;
        }
        this.fingerprintIcon.setVisibility(4);
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4277a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4277a.dismiss();
        }
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        ProgressDialog progressDialog = this.f4277a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4277a.dismiss();
        }
        C0535I5.u();
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
        if (!Bw.e(getApplicationContext()).c().equalsIgnoreCase("ON") || this.f4292c) {
            this.f4289b = true;
            this.f4287a = true;
            o();
            return;
        }
        this.f4289b = false;
        this.f4281a.a(this.f4280a);
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4277a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4277a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363736})
    public void onTourismAppClick(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.irctctourism.com/?utm_source=confirm")));
    }

    @OnClick({2131364713})
    public void onUserGuideClick() {
        if (!C0535I5.O((ConnectivityManager) this.f4284a.getSystemService("connectivity"), this.f4284a)) {
            new Handler().postDelayed(new l(), 5000);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://contents.irctc.co.in/en/UserGuideIRCTC.pdf"));
        startActivity(intent);
    }

    @OnClick({2131363770})
    public void onUtsAppClick(View view) {
        try {
            Intent parseUri = Intent.parseUri("https://play.google.com/store/apps/details?id=com.cris.utsmobile&hl=en_IN", 1);
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage("com.cris.utsmobile");
            if (launchIntentForPackage != null) {
                startActivity(launchIntentForPackage);
            } else {
                startActivity(parseUri);
            }
        } catch (Exception unused) {
            C0535I5.t0(getApplicationContext(), "Error opening UTS app.");
        }
    }

    @OnClick({2131363010})
    public void onbusClick(View view) {
        try {
            Intent parseUri = Intent.parseUri("https://www.bus.irctc.co.in/home?utm_source=confirm", 1);
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage("home?utm_source");
            if (launchIntentForPackage != null) {
                startActivity(launchIntentForPackage);
            } else {
                startActivity(parseUri);
            }
        } catch (Exception unused) {
            C0535I5.t0(getApplicationContext(), getString(R.string.error_opening_air_app));
        }
    }

    @OnClick({2131363734})
    public void onhotelAppClick(View view) {
        try {
            Intent parseUri = Intent.parseUri("https://www.hotels.irctc.co.in/hotel?utm_source=confirm", 1);
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage("hotel?utm_source");
            if (launchIntentForPackage != null) {
                startActivity(launchIntentForPackage);
            } else {
                startActivity(parseUri);
            }
        } catch (Exception unused) {
            C0535I5.t0(getApplicationContext(), getString(R.string.error_opening_air_app));
        }
    }

    public final void p() {
        Bw e2 = Bw.e(getApplicationContext());
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            TextView textView = this.f4290c;
            textView.setText(e2.h() + " " + getString(R.string.enter_four_digit_pin));
        } else {
            TextView textView2 = this.f4290c;
            textView2.setText(getString(R.string.enter_four_digit_pin) + " " + e2.h());
        }
        this.f4292c = false;
        this.fingerPrintMsg.setVisibility(8);
        this.f4278a.setVisibility(0);
        this.fingerprintIcon.setVisibility(0);
    }

    public final void t(boolean z) {
        Bw e2 = Bw.e(getApplicationContext());
        if (!z) {
            C0535I5.f3620a = "N";
            this.f4278a.setText("");
            this.f4278a.setFocusableInTouchMode(true);
            this.with_otp_tv.setBackground((Drawable) null);
            TextView textView = this.with_otp_tv;
            Object obj = d7.a;
            textView.setTextColor(d7.b.a(this, R.color.dark));
            this.with_pin_tv.setBackgroundColor(getResources().getColor(R.color.orange));
            this.with_pin_tv.postDelayed(new C0189f6(this, 8), 100);
            this.f4278a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            C0479D5 d5 = new C0479D5(this, 4);
            this.a = d5;
            this.f4278a.addTextChangedListener(d5);
            if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                TextView textView2 = this.f4290c;
                textView2.setText(e2.h() + " " + getString(R.string.enter_four_digit_pin));
            } else {
                TextView textView3 = this.f4290c;
                textView3.setText(getString(R.string.enter_four_digit_pin) + " " + e2.h());
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.removeRule(9);
            layoutParams.addRule(11, -1);
            this.b.setLayoutParams(layoutParams);
            this.b.requestLayout();
            ((RelativeLayout) this.b.getParent()).invalidate();
            this.f4279a.setVisibility(0);
            this.sendOtp.setVisibility(8);
            this.otp_send_msg.setVisibility(8);
            if (e2.c().equalsIgnoreCase("ON")) {
                p();
                z();
            } else {
                this.fingerprintIcon.setVisibility(4);
            }
            int i2 = this.d;
            if (10 == i2 || 14 == i2) {
                this.captchaLayout.setVisibility(0);
                return;
            }
            return;
        }
        C0535I5.f3620a = "OTP";
        this.f4278a.setFocusableInTouchMode(false);
        this.f4278a.clearFocus();
        this.f4278a.setText("");
        this.sendOtpTv.setText("Send OTP");
        this.with_pin_tv.setBackground((Drawable) null);
        TextView textView4 = this.with_pin_tv;
        Object obj2 = d7.a;
        textView4.setTextColor(d7.b.a(this, R.color.dark));
        this.with_otp_tv.setBackgroundColor(getResources().getColor(R.color.orange));
        this.with_pin_tv.postDelayed(new C0088Dd(this, 9), 100);
        C0479D5 d52 = this.a;
        if (d52 != null) {
            this.f4278a.removeTextChangedListener(d52);
            this.a = null;
        }
        this.f4278a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        this.f4278a.addTextChangedListener(new C0479D5(this, 6));
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            TextView textView5 = this.f4290c;
            textView5.setText(e2.h() + " " + getString(R.string.enter_four_digit_otp));
        } else {
            TextView textView6 = this.f4290c;
            textView6.setText(getString(R.string.enter_four_digit_otp) + " " + e2.h());
        }
        this.otp_message.setText("");
        this.otpTimmer.setText("");
        this.sendOtpTv.setEnabled(true);
        this.otpTimmer.setText("");
        this.captchaLayout.setVisibility(8);
        this.f4279a.setVisibility(8);
        this.sendOtp.setVisibility(0);
        this.otp_send_msg.setVisibility(0);
        if (e2.c().equalsIgnoreCase("ON")) {
            p();
            z();
        } else {
            this.fingerprintIcon.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams2.addRule(9, -1);
        this.b.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.sendOtp.getLayoutParams();
        layoutParams3.addRule(11, -1);
        this.sendOtp.setLayoutParams(layoutParams3);
    }

    public void validatePin(View view) {
        if (!C0535I5.O((ConnectivityManager) getSystemService("connectivity"), view.getContext())) {
            new Handler().postDelayed(new h(), 5000);
        } else {
            x();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c8 A[Catch:{ Exception -> 0x03a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01dd A[Catch:{ Exception -> 0x03a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0219 A[Catch:{ Exception -> 0x03a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0294 A[Catch:{ Exception -> 0x03a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x029e A[Catch:{ Exception -> 0x03a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02ff A[Catch:{ Exception -> 0x03a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0333 A[Catch:{ Exception -> 0x03a1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x() {
        /*
            r22 = this;
            r6 = r22
            java.lang.String r0 = "#UP#"
            java.lang.String r1 = "AAAAAAAAAAAAAAAA"
            boolean r2 = r6.f4287a
            if (r2 != 0) goto L_0x001a
            boolean r2 = r6.f4289b
            if (r2 == 0) goto L_0x001a
            android.widget.CheckBox r2 = r6.bkgWithOTP
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto L_0x001a
            r22.o()
            return
        L_0x001a:
            b1 r2 = r6.f4282a
            r3 = 0
            r2.f3912a = r3
            android.content.Context r2 = r22.getApplicationContext()
            Bw r2 = defpackage.Bw.e(r2)
            Nv r3 = r2.f3534a
            java.lang.String r4 = "alfiler"
            java.lang.String r5 = ""
            java.lang.String r3 = r3.getString(r4, r5)
            Nv r7 = r2.f3534a
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0054
            android.widget.EditText r0 = r6.f4278a
            r0.setText(r5)
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<cris.org.in.ima.activities.LoginActivity> r1 = cris.org.in.ima.activities.LoginActivity.class
            r0.<init>(r6, r1)
            java.lang.String r1 = "isDashBoardLanding"
            int r2 = r6.c
            r0.putExtra(r1, r2)
            r22.finish()
            r6.startActivity(r0)
            goto L_0x03a1
        L_0x0054:
            android.widget.EditText r3 = r6.f4278a     // Catch:{ Exception -> 0x03a1 }
            android.text.Editable r3 = r3.getText()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x03a1 }
            boolean r8 = r6.f4292c     // Catch:{ Exception -> 0x03a1 }
            if (r8 == 0) goto L_0x0067
            java.lang.String r8 = "BIOMATRIC"
            r6.f4294e = r8     // Catch:{ Exception -> 0x03a1 }
            goto L_0x0077
        L_0x0067:
            android.widget.EditText r8 = r6.captchaInputValue     // Catch:{ Exception -> 0x03a1 }
            android.text.Editable r8 = r8.getText()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r8 = r8.trim()     // Catch:{ Exception -> 0x03a1 }
            r6.f4294e = r8     // Catch:{ Exception -> 0x03a1 }
        L_0x0077:
            boolean r8 = r3.isEmpty()     // Catch:{ Exception -> 0x03a1 }
            r9 = 1
            r10 = 0
            if (r8 != 0) goto L_0x0081
            r8 = r9
            goto L_0x0082
        L_0x0081:
            r8 = r10
        L_0x0082:
            boolean r11 = r3.isEmpty()     // Catch:{ Exception -> 0x03a1 }
            if (r11 != 0) goto L_0x0096
            java.lang.String r11 = r6.f4294e     // Catch:{ Exception -> 0x03a1 }
            boolean r11 = r11.equals(r5)     // Catch:{ Exception -> 0x03a1 }
            if (r11 != 0) goto L_0x0096
            java.lang.String r11 = r6.f4294e     // Catch:{ Exception -> 0x03a1 }
            if (r11 == 0) goto L_0x0096
            r11 = r9
            goto L_0x0097
        L_0x0096:
            r11 = r10
        L_0x0097:
            java.util.Date r12 = r6.f4285a     // Catch:{ Exception -> 0x03a1 }
            if (r12 == 0) goto L_0x00a0
            boolean r12 = defpackage.C5.a(r12)     // Catch:{ Exception -> 0x03a1 }
            goto L_0x00a1
        L_0x00a0:
            r12 = r9
        L_0x00a1:
            if (r12 == 0) goto L_0x00a4
            goto L_0x00bf
        L_0x00a4:
            boolean r13 = r6.f4292c     // Catch:{ Exception -> 0x03a1 }
            if (r13 != 0) goto L_0x00bf
            r6.f4289b = r9     // Catch:{ Exception -> 0x03a1 }
            android.widget.CheckBox r13 = r6.bkgWithOTP     // Catch:{ Exception -> 0x03a1 }
            boolean r13 = r13.isChecked()     // Catch:{ Exception -> 0x03a1 }
            if (r13 == 0) goto L_0x00b3
            goto L_0x00c0
        L_0x00b3:
            int r13 = r6.d     // Catch:{ Exception -> 0x03a1 }
            r14 = 10
            if (r14 == r13) goto L_0x00bd
            r14 = 14
            if (r14 != r13) goto L_0x00c0
        L_0x00bd:
            r8 = r11
            goto L_0x00c0
        L_0x00bf:
            r8 = r10
        L_0x00c0:
            r11 = 2131952688(0x7f130430, float:1.9541826E38)
            r13 = 2131951928(0x7f130138, float:1.9540284E38)
            if (r8 != 0) goto L_0x01d3
            boolean r8 = r6.f4292c     // Catch:{ Exception -> 0x03a1 }
            if (r8 == 0) goto L_0x00ce
            goto L_0x01d3
        L_0x00ce:
            boolean r0 = r6.f4289b     // Catch:{ Exception -> 0x03a1 }
            r1 = 2131951992(0x7f130178, float:1.9540414E38)
            if (r0 == 0) goto L_0x01b5
            android.widget.CheckBox r0 = r6.bkgWithOTP     // Catch:{ Exception -> 0x03a1 }
            boolean r0 = r0.isChecked()     // Catch:{ Exception -> 0x03a1 }
            if (r0 == 0) goto L_0x00fb
            r2 = 0
            java.lang.String r3 = r6.getString(r1)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r4 = r6.getString(r11)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r5 = r6.getString(r13)     // Catch:{ Exception -> 0x03a1 }
            r7 = 0
            r0 = r22
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r0, r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x03a1 }
            r0.show()     // Catch:{ Exception -> 0x03a1 }
            goto L_0x03a1
        L_0x00fb:
            boolean r0 = r3.isEmpty()     // Catch:{ Exception -> 0x03a1 }
            if (r0 == 0) goto L_0x012a
            java.lang.String r0 = r6.f4294e     // Catch:{ Exception -> 0x03a1 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x03a1 }
            if (r0 == 0) goto L_0x012a
            r1 = 0
            r0 = 2131952628(0x7f1303f4, float:1.9541704E38)
            java.lang.String r2 = r6.getString(r0)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = r6.getString(r11)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r4 = r6.getString(r13)     // Catch:{ Exception -> 0x03a1 }
            r5 = 0
            r0 = r22
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r0, r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x03a1 }
            r0.show()     // Catch:{ Exception -> 0x03a1 }
            android.widget.EditText r0 = r6.f4278a     // Catch:{ Exception -> 0x03a1 }
            r0.requestFocus()     // Catch:{ Exception -> 0x03a1 }
            goto L_0x03a1
        L_0x012a:
            boolean r0 = r3.isEmpty()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r7 = "input_method"
            if (r0 == 0) goto L_0x0160
            r2 = 0
            java.lang.String r3 = r6.getString(r1)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r4 = r6.getString(r11)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r5 = r6.getString(r13)     // Catch:{ Exception -> 0x03a1 }
            r8 = 0
            r0 = r22
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r8
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r0, r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x03a1 }
            r0.show()     // Catch:{ Exception -> 0x03a1 }
            android.widget.EditText r0 = r6.f4278a     // Catch:{ Exception -> 0x03a1 }
            r0.requestFocus()     // Catch:{ Exception -> 0x03a1 }
            java.lang.Object r0 = r6.getSystemService(r7)     // Catch:{ Exception -> 0x03a1 }
            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0     // Catch:{ Exception -> 0x03a1 }
            android.widget.EditText r1 = r6.f4278a     // Catch:{ Exception -> 0x03a1 }
            r0.showSoftInput(r1, r9)     // Catch:{ Exception -> 0x03a1 }
            goto L_0x03a1
        L_0x0160:
            java.lang.String r0 = r6.f4294e     // Catch:{ Exception -> 0x03a1 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x03a1 }
            if (r0 == 0) goto L_0x0194
            r1 = 0
            r0 = 2131953458(0x7f130732, float:1.9543388E38)
            java.lang.String r2 = r6.getString(r0)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = r6.getString(r11)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r4 = r6.getString(r13)     // Catch:{ Exception -> 0x03a1 }
            r5 = 0
            r0 = r22
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r0, r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x03a1 }
            r0.show()     // Catch:{ Exception -> 0x03a1 }
            android.widget.EditText r0 = r6.captchaInputValue     // Catch:{ Exception -> 0x03a1 }
            r0.requestFocus()     // Catch:{ Exception -> 0x03a1 }
            java.lang.Object r0 = r6.getSystemService(r7)     // Catch:{ Exception -> 0x03a1 }
            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0     // Catch:{ Exception -> 0x03a1 }
            android.widget.EditText r1 = r6.captchaInputValue     // Catch:{ Exception -> 0x03a1 }
            r0.showSoftInput(r1, r9)     // Catch:{ Exception -> 0x03a1 }
            goto L_0x03a1
        L_0x0194:
            if (r12 == 0) goto L_0x03a1
            r1 = 0
            r0 = 2131953808(0x7f130890, float:1.9544097E38)
            java.lang.String r2 = r6.getString(r0)     // Catch:{ Exception -> 0x03a1 }
            r0 = 2131951855(0x7f1300ef, float:1.9540136E38)
            java.lang.String r3 = r6.getString(r0)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r4 = r6.getString(r13)     // Catch:{ Exception -> 0x03a1 }
            r5 = 0
            r0 = r22
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r0, r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x03a1 }
            r0.show()     // Catch:{ Exception -> 0x03a1 }
            goto L_0x03a1
        L_0x01b5:
            r2 = 0
            java.lang.String r3 = r6.getString(r1)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r4 = r6.getString(r11)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r5 = r6.getString(r13)     // Catch:{ Exception -> 0x03a1 }
            r7 = 0
            r0 = r22
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r0, r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x03a1 }
            r0.show()     // Catch:{ Exception -> 0x03a1 }
            goto L_0x03a1
        L_0x01d3:
            java.lang.String r4 = r7.getString(r4, r5)     // Catch:{ Exception -> 0x03a1 }
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x03a1 }
            if (r4 != 0) goto L_0x0213
            boolean r4 = r6.f4292c     // Catch:{ Exception -> 0x03a1 }
            if (r4 == 0) goto L_0x01e2
            goto L_0x0213
        L_0x01e2:
            android.widget.EditText r0 = r6.f4278a     // Catch:{ Exception -> 0x03a1 }
            r0.setText(r5)     // Catch:{ Exception -> 0x03a1 }
            int r0 = r6.f     // Catch:{ Exception -> 0x03a1 }
            int r0 = r0 + r9
            r6.f = r0     // Catch:{ Exception -> 0x03a1 }
            int r1 = r6.e     // Catch:{ Exception -> 0x03a1 }
            if (r0 < r1) goto L_0x01f7
            java.lang.String r0 = "lockOut"
            r6.A(r0)     // Catch:{ Exception -> 0x03a1 }
            goto L_0x03a1
        L_0x01f7:
            r1 = 0
            r0 = 2131952955(0x7f13053b, float:1.9542367E38)
            java.lang.String r2 = r6.getString(r0)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = r6.getString(r11)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r4 = r6.getString(r13)     // Catch:{ Exception -> 0x03a1 }
            r5 = 0
            r0 = r22
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r0, r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x03a1 }
            r0.show()     // Catch:{ Exception -> 0x03a1 }
            goto L_0x03a1
        L_0x0213:
            boolean r3 = android.text.TextUtils.isDigitsOnly(r3)     // Catch:{ Exception -> 0x03a1 }
            if (r3 != 0) goto L_0x023f
            boolean r3 = r6.f4292c     // Catch:{ Exception -> 0x03a1 }
            if (r3 == 0) goto L_0x021e
            goto L_0x023f
        L_0x021e:
            android.widget.EditText r0 = r6.f4278a     // Catch:{ Exception -> 0x03a1 }
            r0.setText(r5)     // Catch:{ Exception -> 0x03a1 }
            r1 = 0
            r0 = 2131953311(0x7f13069f, float:1.954309E38)
            java.lang.String r2 = r6.getString(r0)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = r6.getString(r11)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r4 = r6.getString(r13)     // Catch:{ Exception -> 0x03a1 }
            r5 = 0
            r0 = r22
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r0, r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x03a1 }
            r0.show()     // Catch:{ Exception -> 0x03a1 }
            goto L_0x03a1
        L_0x023f:
            android.app.ProgressDialog r3 = r6.f4277a     // Catch:{ Exception -> 0x03a1 }
            if (r3 == 0) goto L_0x024e
            boolean r3 = r3.isShowing()     // Catch:{ Exception -> 0x03a1 }
            if (r3 == 0) goto L_0x024e
            android.app.ProgressDialog r3 = r6.f4277a     // Catch:{ Exception -> 0x03a1 }
            r3.dismiss()     // Catch:{ Exception -> 0x03a1 }
        L_0x024e:
            r3 = 2131952159(0x7f13021f, float:1.9540753E38)
            java.lang.String r3 = r6.getString(r3)     // Catch:{ Exception -> 0x03a1 }
            r4 = 2131953495(0x7f130757, float:1.9543463E38)
            java.lang.String r4 = r6.getString(r4)     // Catch:{ Exception -> 0x03a1 }
            android.app.ProgressDialog r3 = android.app.ProgressDialog.show(r6, r3, r4)     // Catch:{ Exception -> 0x03a1 }
            r6.f4277a = r3     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x03a1 }
            r6.f4291c = r2     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r2 = "contrasena"
            java.lang.String r2 = r7.getString(r2, r5)     // Catch:{ Exception -> 0x03a1 }
            r6.f4293d = r2     // Catch:{ Exception -> 0x03a1 }
            mn r2 = new mn     // Catch:{ Exception -> 0x03a1 }
            r2.<init>()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = "password"
            r2.setGrant_type(r3)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = r6.f4291c     // Catch:{ Exception -> 0x03a1 }
            r2.setUsername(r3)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = r6.f4293d     // Catch:{ Exception -> 0x03a1 }
            byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = android.util.Base64.encodeToString(r3, r10)     // Catch:{ Exception -> 0x03a1 }
            r2.setPassword(r3)     // Catch:{ Exception -> 0x03a1 }
            android.widget.CheckBox r3 = r6.bkgWithOTP     // Catch:{ Exception -> 0x03a1 }
            boolean r3 = r3.isChecked()     // Catch:{ Exception -> 0x03a1 }
            if (r3 != 0) goto L_0x029e
            android.widget.CheckBox r3 = r6.bkgWithOTP     // Catch:{ Exception -> 0x03a1 }
            r3.setChecked(r10)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = "N"
            defpackage.C0535I5.f3620a = r3     // Catch:{ Exception -> 0x03a1 }
            goto L_0x02a7
        L_0x029e:
            android.widget.CheckBox r3 = r6.bkgWithOTP     // Catch:{ Exception -> 0x03a1 }
            r3.setChecked(r9)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = "OTP"
            defpackage.C0535I5.f3620a = r3     // Catch:{ Exception -> 0x03a1 }
        L_0x02a7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03a1 }
            r3.<init>()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r4 = r6.f4294e     // Catch:{ Exception -> 0x03a1 }
            r3.append(r4)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r4 = r6.f4295f     // Catch:{ Exception -> 0x03a1 }
            r3.append(r4)     // Catch:{ Exception -> 0x03a1 }
            r3.append(r1)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x03a1 }
            r4 = 16
            java.lang.String r3 = r3.substring(r10, r4)     // Catch:{ Exception -> 0x03a1 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03a1 }
            r7.<init>()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r8 = r2.getUsername()     // Catch:{ Exception -> 0x03a1 }
            r7.append(r8)     // Catch:{ Exception -> 0x03a1 }
            r7.append(r0)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r8 = r2.getPassword()     // Catch:{ Exception -> 0x03a1 }
            r7.append(r8)     // Catch:{ Exception -> 0x03a1 }
            r7.append(r0)     // Catch:{ Exception -> 0x03a1 }
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x03a1 }
            r0.<init>()     // Catch:{ Exception -> 0x03a1 }
            long r8 = r0.getTime()     // Catch:{ Exception -> 0x03a1 }
            r7.append(r8)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r7 = r2.getUsername()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r8 = r2.getPassword()     // Catch:{ Exception -> 0x03a1 }
            java.lang.Object r7 = defpackage.C0657Qt.d(r7, r8)     // Catch:{ Exception -> 0x03a1 }
            r11 = r7
            ln r11 = (defpackage.C1243ln) r11     // Catch:{ Exception -> 0x03a1 }
            boolean r7 = r6.f4289b     // Catch:{ Exception -> 0x03a1 }
            if (r7 == 0) goto L_0x0333
            java.lang.String r12 = r2.getGrant_type()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r13 = defpackage.C0535I5.w(r0, r3)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r14 = "true"
            java.lang.String r15 = r6.f4294e     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r0 = r6.f4295f     // Catch:{ Exception -> 0x03a1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03a1 }
            r1.<init>()     // Catch:{ Exception -> 0x03a1 }
            android.widget.CheckBox r2 = r6.bkgWithOTP     // Catch:{ Exception -> 0x03a1 }
            boolean r2 = r2.isChecked()     // Catch:{ Exception -> 0x03a1 }
            r1.append(r2)     // Catch:{ Exception -> 0x03a1 }
            r1.append(r5)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r17 = r1.toString()     // Catch:{ Exception -> 0x03a1 }
            r18 = 0
            r19 = 0
            r20 = 0
            java.lang.String r1 = r6.f4296g     // Catch:{ Exception -> 0x03a1 }
            r16 = r0
            r21 = r1
            rx.Observable r0 = r11.b(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x03a1 }
            goto L_0x0389
        L_0x0333:
            boolean r3 = r6.f4292c     // Catch:{ Exception -> 0x03a1 }
            if (r3 == 0) goto L_0x0364
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03a1 }
            r3.<init>()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r5 = r6.f4294e     // Catch:{ Exception -> 0x03a1 }
            r3.append(r5)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r5 = cris.org.in.ima.IrctcImaApplication.c     // Catch:{ Exception -> 0x03a1 }
            r3.append(r5)     // Catch:{ Exception -> 0x03a1 }
            r3.append(r1)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r1 = r1.substring(r10, r4)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r12 = r2.getGrant_type()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r13 = defpackage.C0535I5.w(r0, r1)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r14 = "true"
            java.lang.String r15 = r6.f4294e     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r16 = cris.org.in.ima.IrctcImaApplication.c     // Catch:{ Exception -> 0x03a1 }
            rx.Observable r0 = r11.c(r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x03a1 }
            goto L_0x0389
        L_0x0364:
            java.lang.String r0 = r2.getGrant_type()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r1 = r2.getUsername()     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r2 = r2.getPassword()     // Catch:{ Exception -> 0x03a1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03a1 }
            r3.<init>()     // Catch:{ Exception -> 0x03a1 }
            android.widget.CheckBox r4 = r6.bkgWithOTP     // Catch:{ Exception -> 0x03a1 }
            boolean r4 = r4.isChecked()     // Catch:{ Exception -> 0x03a1 }
            r3.append(r4)     // Catch:{ Exception -> 0x03a1 }
            r3.append(r5)     // Catch:{ Exception -> 0x03a1 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x03a1 }
            rx.Observable r0 = r11.a(r0, r1, r2, r3)     // Catch:{ Exception -> 0x03a1 }
        L_0x0389:
            Lm r1 = defpackage.C1181iv.a()     // Catch:{ Exception -> 0x03a1 }
            rx.Observable r0 = r0.c(r1)     // Catch:{ Exception -> 0x03a1 }
            Yi r1 = defpackage.E0.a()     // Catch:{ Exception -> 0x03a1 }
            rx.Observable r0 = r0.a(r1)     // Catch:{ Exception -> 0x03a1 }
            cris.org.in.ima.activities.PinValidationActivity$c r1 = new cris.org.in.ima.activities.PinValidationActivity$c     // Catch:{ Exception -> 0x03a1 }
            r1.<init>()     // Catch:{ Exception -> 0x03a1 }
            r0.b(r1)     // Catch:{ Exception -> 0x03a1 }
        L_0x03a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.PinValidationActivity.x():void");
    }

    public final void z() {
        int a2 = new androidx.biometric.h(new h.c(this)).a(32783);
        if (a2 == 1) {
            this.f4292c = false;
            Toast.makeText(this, "sensor not avail", 1).show();
        } else if (a2 == 11) {
            this.fingerprintIcon.setVisibility(4);
        } else if (a2 == 12) {
            this.f4292c = false;
            Toast.makeText(this, "not match", 1).show();
        }
        Executor d2 = d7.d(this);
        this.f4286a = d2;
        this.f4281a = new BiometricPrompt((FragmentActivity) this, d2, (BiometricPrompt.a) new g());
        BiometricPrompt.d.a aVar = new BiometricPrompt.d.a();
        aVar.a = getString(R.string.login);
        aVar.b = getString(R.string.use_pin);
        this.f4280a = aVar.a();
    }

    public class h implements Runnable {
        public final void run() {
        }
    }

    public class i implements Runnable {
        public final void run() {
        }
    }

    public class l implements Runnable {
        public final void run() {
        }
    }

    @OnClick({2131363945})
    public void onClickSendOtp(View view) {
    }
}
