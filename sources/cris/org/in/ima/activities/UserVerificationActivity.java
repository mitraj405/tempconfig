package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.common.Scopes;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.paytm.pgsdk.sdknative.LoginActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import java.lang.reflect.Array;
import rx.Subscriber;

public class UserVerificationActivity extends AppCompatActivity {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public UserVerificationActivity f4366a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4367a;
    public boolean b;
    @BindView(2131362085)
    TextView bt_gen_email_otp;
    @BindView(2131362086)
    TextView bt_gen_mobile_otp;

    /* renamed from: c  reason: collision with other field name */
    public String f4368c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f4369c = false;
    public String d;
    public String e;
    @BindView(2131362530)
    EditText emailInputOTP;
    @BindView(2131362487)
    TextView email_verify;
    @BindView(2131362529)
    EditText et_email;
    @BindView(2131362539)
    EditText et_isd;
    @BindView(2131362545)
    EditText et_mobile;
    public String f;
    public String g = "";
    public String h = "";
    public final String i = "91";
    @BindView(2131362548)
    EditText mobileInputOTP;
    @BindView(2131363231)
    TextView mobile_verify;
    @BindView(2131364565)
    TextView resendMailTimmer;
    @BindView(2131364566)
    TextView resendMobTimmer;
    @BindView(2131364663)
    TextView titleName;
    @BindView(2131364393)
    TextView tv_email_edit;
    @BindView(2131364489)
    TextView tv_mobile_edit;
    @BindView(2131364801)
    TextView userNameTv;
    @BindView(2131364719)
    TextView verifyEmailTv;
    @BindView(2131364720)
    TextView verifyMobileTv;

    public class b extends Subscriber<StatusDTO> {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ String[][] f4370a;
        public final /* synthetic */ String c;

        public b(String str, String[][] strArr) {
            this.c = str;
            this.f4370a = strArr;
        }

        public final void onCompleted() {
            int i = UserVerificationActivity.c;
            UserVerificationActivity.this.a.dismiss();
        }

        public final void onError(Throwable th) {
            UserVerificationActivity.this.a.dismiss();
            int i = UserVerificationActivity.c;
            xx.S(th, true, th);
        }

        public final void onNext(Object obj) {
            StatusDTO statusDTO = (StatusDTO) obj;
            UserVerificationActivity userVerificationActivity = UserVerificationActivity.this;
            userVerificationActivity.a.dismiss();
            if (statusDTO != null) {
                userVerificationActivity.emailInputOTP.setText("");
                userVerificationActivity.mobileInputOTP.setText("");
                if (statusDTO.getError() == null) {
                    C0535I5.o(userVerificationActivity.f4366a, statusDTO.getStatus(), "OK", (DialogInterface.OnClickListener) null).show();
                    String str = this.c;
                    if (str.equals("M")) {
                        userVerificationActivity.et_mobile.setEnabled(false);
                        userVerificationActivity.mobileInputOTP.setEnabled(true);
                        userVerificationActivity.mobileInputOTP.setHint(userVerificationActivity.getString(R.string.enter_otp_sent_mobile_number));
                        userVerificationActivity.h = userVerificationActivity.et_mobile.getText().toString();
                        TextView textView = userVerificationActivity.verifyMobileTv;
                        StringBuilder sb = new StringBuilder();
                        sb.append(userVerificationActivity.getResources().getString(R.string.mobile_otp_help));
                        sb.append(" ");
                        lf.x(sb, userVerificationActivity.h, textView);
                        userVerificationActivity.mobileInputOTP.requestFocus();
                        userVerificationActivity.bt_gen_mobile_otp.setText(userVerificationActivity.getString(R.string.resend_otp));
                        new N(this).start();
                    }
                    if (str.equals("E")) {
                        userVerificationActivity.et_email.setEnabled(false);
                        userVerificationActivity.emailInputOTP.setEnabled(true);
                        userVerificationActivity.emailInputOTP.setHint(userVerificationActivity.getString(R.string.enter_otp_sent_email_id));
                        userVerificationActivity.g = xx.B(userVerificationActivity.et_email);
                        TextView textView2 = userVerificationActivity.verifyEmailTv;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(userVerificationActivity.getResources().getString(R.string.email_otp_help));
                        sb2.append(" ");
                        lf.x(sb2, userVerificationActivity.g, textView2);
                        userVerificationActivity.emailInputOTP.requestFocus();
                        userVerificationActivity.bt_gen_email_otp.setText(userVerificationActivity.getString(R.string.resend_otp));
                        new O(this).start();
                    }
                } else if (statusDTO.getError().contains("Error Code")) {
                    String[] split = statusDTO.getError().toString().split("Error Code");
                    this.f4370a[0] = split;
                    C0535I5.m(userVerificationActivity, false, split[0], userVerificationActivity.getString(R.string.error), userVerificationActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } else {
                    C0535I5.m(UserVerificationActivity.this, false, statusDTO.getError(), userVerificationActivity.getString(R.string.error), userVerificationActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            } else {
                int i = UserVerificationActivity.c;
                C0535I5.m(userVerificationActivity, false, "Unable To Process Your Request.\nPlease Try After Sometime.", userVerificationActivity.getString(R.string.error), userVerificationActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public final void run() {
            UserVerificationActivity.this.f4369c = false;
        }
    }

    static {
        C1354qp.R(UserVerificationActivity.class);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    @OnClick({2131364393})
    public void editEmail() {
        this.et_email.setEnabled(true);
        this.et_email.requestFocus();
        this.emailInputOTP.setHint("");
        this.emailInputOTP.setEnabled(false);
        this.bt_gen_email_otp.setText(getString(R.string.send_otp));
        this.verifyEmailTv.setText("");
    }

    @OnClick({2131364489})
    public void editMobile() {
        this.et_mobile.setEnabled(true);
        this.et_mobile.requestFocus();
        this.mobileInputOTP.setHint("");
        this.mobileInputOTP.setEnabled(false);
        this.bt_gen_mobile_otp.setText(getString(R.string.send_otp));
        this.verifyMobileTv.setText("");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0058  */
    @butterknife.OnClick({2131362085})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void generateEmailOTPClick() {
        /*
            r8 = this;
            android.widget.EditText r0 = r8.et_email
            android.text.Editable r0 = r0.getText()
            r0.toString()
            android.widget.EditText r0 = r8.et_email
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ok"
            if (r0 == 0) goto L_0x0031
            java.lang.String r2 = ""
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 != 0) goto L_0x0031
            java.lang.String r2 = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
            boolean r0 = r0.matches(r2)
            if (r0 == 0) goto L_0x0029
            r4 = r1
            goto L_0x0039
        L_0x0029:
            r0 = 2131952679(0x7f130427, float:1.9541808E38)
            java.lang.String r0 = r8.getString(r0)
            goto L_0x0038
        L_0x0031:
            r0 = 2131952646(0x7f130406, float:1.954174E38)
            java.lang.String r0 = r8.getString(r0)
        L_0x0038:
            r4 = r0
        L_0x0039:
            boolean r0 = r4.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x0058
            android.widget.EditText r0 = r8.et_email
            r0.requestFocus()
            r3 = 0
            java.lang.String r5 = "Input Error"
            r0 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r6 = r8.getString(r0)
            r7 = 0
            r2 = r8
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r2, r3, r4, r5, r6, r7)
            r0.show()
            goto L_0x0077
        L_0x0058:
            boolean r0 = r4.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = "E"
            android.widget.EditText r1 = r8.et_email     // Catch:{ Exception -> 0x0073 }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x0073 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0073 }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x0073 }
            r2 = 0
            r8.l(r0, r1, r2)     // Catch:{ Exception -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r0 = move-exception
            r0.getMessage()
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.UserVerificationActivity.generateEmailOTPClick():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0084  */
    @butterknife.OnClick({2131362086})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void generateMobileOTPClick() {
        /*
            r13 = this;
            java.lang.String r0 = r13.e
            java.lang.String r1 = r13.i
            boolean r0 = r0.equals(r1)
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            r2 = 0
            r3 = 2131952425(0x7f130329, float:1.9541292E38)
            java.lang.String r4 = ""
            r5 = 2131952688(0x7f130430, float:1.9541826E38)
            if (r0 == 0) goto L_0x00a1
            android.widget.EditText r0 = r13.et_mobile
            android.text.Editable r0 = r0.getText()
            r0.toString()
            android.widget.EditText r0 = r13.et_mobile
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "ok"
            if (r0 == 0) goto L_0x0060
            java.lang.String r7 = r0.trim()
            boolean r4 = r7.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0038
            goto L_0x0060
        L_0x0038:
            java.lang.String r3 = r0.trim()
            int r3 = r3.length()
            r4 = 10
            if (r3 == r4) goto L_0x004c
            r0 = 2131952078(0x7f1301ce, float:1.9540589E38)
            java.lang.String r0 = r13.getString(r0)
            goto L_0x0064
        L_0x004c:
            java.lang.String r0 = r0.trim()
            boolean r0 = defpackage.C0535I5.N(r0)
            if (r0 != 0) goto L_0x005e
            r0 = 2131951898(0x7f13011a, float:1.9540224E38)
            java.lang.String r0 = r13.getString(r0)
            goto L_0x0064
        L_0x005e:
            r9 = r6
            goto L_0x0065
        L_0x0060:
            java.lang.String r0 = r13.getString(r3)
        L_0x0064:
            r9 = r0
        L_0x0065:
            boolean r0 = r9.equalsIgnoreCase(r6)
            if (r0 != 0) goto L_0x0084
            android.widget.EditText r0 = r13.et_mobile
            r0.requestFocus()
            r8 = 0
            java.lang.String r10 = r13.getString(r5)
            java.lang.String r11 = r13.getString(r1)
            r12 = 0
            r7 = r13
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r7, r8, r9, r10, r11, r12)
            r0.show()
            goto L_0x011e
        L_0x0084:
            boolean r0 = r9.equalsIgnoreCase(r6)
            if (r0 == 0) goto L_0x011e
            java.lang.String r0 = "M"
            android.widget.EditText r1 = r13.et_mobile     // Catch:{ Exception -> 0x009b }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x009b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x009b }
            r13.l(r0, r2, r1)     // Catch:{ Exception -> 0x009b }
            goto L_0x011e
        L_0x009b:
            r0 = move-exception
            r0.getMessage()
            goto L_0x011e
        L_0x00a1:
            android.widget.EditText r0 = r13.et_mobile
            boolean r0 = defpackage.xx.T(r0, r4)
            if (r0 == 0) goto L_0x00c0
            r7 = 0
            java.lang.String r8 = r13.getString(r3)
            java.lang.String r9 = r13.getString(r5)
            java.lang.String r10 = r13.getString(r1)
            r11 = 0
            r6 = r13
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r6, r7, r8, r9, r10, r11)
            r0.show()
            goto L_0x011e
        L_0x00c0:
            androidx.appcompat.app.AlertDialog$Builder r0 = new androidx.appcompat.app.AlertDialog$Builder
            cris.org.in.ima.activities.UserVerificationActivity r1 = r13.f4366a
            r0.<init>(r1)
            r1 = 17039370(0x104000a, float:2.42446E-38)
            androidx.appcompat.app.AlertDialog$Builder r0 = r0.setPositiveButton((int) r1, (android.content.DialogInterface.OnClickListener) r2)
            java.lang.String r1 = r13.getString(r5)
            androidx.appcompat.app.AlertDialog$Builder r0 = r0.setTitle((java.lang.CharSequence) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 2131952935(0x7f130527, float:1.9542327E38)
            java.lang.String r2 = r13.getString(r2)
            r1.append(r2)
            java.lang.String r2 = "(<font color='#47afff'><a href=\"https://www.irctc.co.in\">https://www.irctc.co.in</a></font>)"
            r1.append(r2)
            r2 = 2131953346(0x7f1306c2, float:1.954316E38)
            java.lang.String r2 = r13.getString(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            androidx.appcompat.app.AlertDialog$Builder r0 = r0.setMessage((java.lang.CharSequence) r1)
            r1 = 17301543(0x1080027, float:2.4979364E-38)
            androidx.appcompat.app.AlertDialog$Builder r0 = r0.setIcon((int) r1)
            androidx.appcompat.app.AlertDialog r0 = r0.create()
            r0.show()
            r1 = 16908299(0x102000b, float:2.387726E-38)
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.text.method.MovementMethod r1 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r1)
        L_0x011e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.UserVerificationActivity.generateMobileOTPClick():void");
    }

    public final void init() {
        this.titleName.setText(getString(R.string.verify_account));
        TextView textView = this.userNameTv;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.verification_user_id));
        lf.x(sb, this.f4368c, textView);
        TextView textView2 = this.verifyMobileTv;
        textView2.setText(getResources().getString(R.string.mobile_otp_help) + " " + this.et_mobile.getText().toString());
        TextView textView3 = this.verifyEmailTv;
        textView3.setText(getResources().getString(R.string.email_otp_help) + " " + this.et_email.getText().toString());
    }

    public final void l(String str, String str2, String str3) {
        C1229kx kxVar = new C1229kx();
        kxVar.setNewMobile(str3);
        kxVar.setNewEmail(str2);
        kxVar.setOtpType(str);
        if (!C0535I5.O((ConnectivityManager) getSystemService("connectivity"), getBaseContext())) {
            new Handler().postDelayed(new a(), 5000);
            return;
        }
        this.a = ProgressDialog.show(this, getString(R.string.sending_otp), getString(R.string.please_wait_text), false, false);
        String[][] strArr = (String[][]) Array.newInstance(String.class, new int[]{1, 1});
        C1223kn knVar = C0793b1.a.f3912a;
        if (knVar != null) {
            String f2 = C0657Qt.f();
            String format = String.format("/%s", new Object[]{str});
            ((Om) C0657Qt.c(knVar)).c(f2 + "getSMSeMailOTPPost" + format, kxVar).c(C1181iv.a()).a(E0.a()).b(new b(str, strArr));
            return;
        }
        this.a.dismiss();
        C0535I5.m(this, false, getString(R.string.Unable_process_request), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    @OnClick({2131362879})
    public void onBackArrowClick() {
        onBackPressed();
    }

    public final void onBackPressed() {
        try {
            if (this.f4369c) {
                finish();
                Intent intent = new Intent(this, LoginActivity.class);
                intent.setFlags(67108864);
                intent.putExtra("logout", true);
                startActivity(intent);
                return;
            }
            this.f4369c = true;
            Toast makeText = Toast.makeText(this.f4366a, getString(R.string.press_back_btn_agn_to_exit), 1);
            makeText.setGravity(1, 0, 0);
            makeText.show();
            new C0816cB(new c(), 2000).a();
        } catch (Exception e2) {
            C1354qp.R(PinValidationActivity.class);
            e2.getMessage();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_account_verification);
        ButterKnife.bind((Activity) this);
        this.f4366a = this;
        Bundle extras = getIntent().getExtras();
        this.f4368c = extras.getString("userName");
        this.d = extras.getString(Scopes.EMAIL);
        this.e = String.valueOf(extras.getInt("isd"));
        this.f = extras.getString(LoginActivity.MOBILE_KEY);
        this.f4367a = extras.getBoolean("emailVerified");
        this.b = extras.getBoolean("mobileVerified");
        String.valueOf(extras.getInt("nationalityid"));
        String str = this.e;
        String str2 = this.i;
        if (str == null || str.equals("0") || this.e.equals("") || this.e.equals(str2)) {
            this.e = str2;
            EditText editText = this.et_isd;
            editText.setText("+ " + str2);
            this.et_mobile.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        } else {
            EditText editText2 = this.et_isd;
            editText2.setText("+ " + this.e);
            this.et_mobile.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        }
        if (!this.f.equals("0")) {
            this.et_mobile.setText(this.f);
        }
        if (!this.d.equals(" ")) {
            this.et_email.setText(this.d.trim());
        }
        this.et_isd.setEnabled(false);
        this.et_mobile.setEnabled(false);
        this.et_email.setEnabled(false);
        if (this.b) {
            this.mobile_verify.setText(getString(R.string.mobile_number_verified));
            this.mobile_verify.setTextColor(getResources().getColor(R.color.green));
            this.et_isd.setVisibility(8);
            this.et_mobile.setVisibility(8);
            this.tv_mobile_edit.setVisibility(8);
            this.mobileInputOTP.setVisibility(8);
            this.bt_gen_mobile_otp.setVisibility(8);
            this.verifyMobileTv.setVisibility(8);
        }
        if (this.f4367a) {
            this.email_verify.setText(getString(R.string.emial_id_verified));
            this.email_verify.setTextColor(getResources().getColor(R.color.green));
            this.et_email.setVisibility(8);
            this.tv_email_edit.setVisibility(8);
            this.emailInputOTP.setVisibility(8);
            this.bt_gen_email_otp.setVisibility(8);
            this.verifyEmailTv.setVisibility(8);
        }
        init();
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    @OnClick({2131364806})
    public void submitOTPClick() {
        String B = xx.B(this.emailInputOTP);
        String B2 = xx.B(this.mobileInputOTP);
        if ((B2 == null || B2.equals("")) && (B == null || B.equals(""))) {
            C0535I5.m(this, false, getString(R.string.invalid_otp), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        String str = "M";
        if (!this.f4367a) {
            if (this.b) {
                if (B == null || B.equals("")) {
                    C0535I5.m(this, false, getString(R.string.invalid_otp), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    return;
                }
            } else if (B == null || B.equals("")) {
                B = null;
            } else if (B2 == null || B2.equals("")) {
                B2 = null;
            } else {
                str = "B";
            }
            str = "E";
        } else if (B2 == null || B2.equals("")) {
            C0535I5.m(this, false, getString(R.string.invalid_otp), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        String str2 = this.g;
        if (str2 == null || str2 == "") {
            this.g = this.d;
        }
        this.et_email.setText(this.g);
        String str3 = this.h;
        if (str3 == null || str3 == "") {
            this.h = this.f;
        }
        this.et_mobile.setText(this.h);
        this.et_email.setEnabled(false);
        this.et_mobile.setEnabled(false);
        C1229kx kxVar = new C1229kx();
        kxVar.setNewEmail(this.g);
        kxVar.setNewMobile(this.h);
        kxVar.setSmsCode(B2);
        kxVar.setEmailCode(B);
        kxVar.setOtpType(str);
        if (!C0535I5.O((ConnectivityManager) getSystemService("connectivity"), getBaseContext())) {
            new Handler().postDelayed(new MB(), 5000);
            return;
        }
        ProgressDialog show = ProgressDialog.show(this, getString(R.string.verify_account_msg), getString(R.string.please_wait_text), false, false);
        this.a = show;
        C1223kn knVar = C0793b1.a.f3912a;
        if (knVar != null) {
            try {
                ((Om) C0657Qt.c(knVar)).g(C0657Qt.f() + "verifySMSeMailOTPPost" + String.format("/%s", new Object[]{str}), kxVar).c(C1181iv.a()).a(E0.a()).b(new P(this, str));
            } catch (Exception e2) {
                e2.getMessage();
                this.a.dismiss();
                C0535I5.m(this, false, getString(R.string.Unable_process_request), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        } else {
            show.dismiss();
            C0535I5.m(this, false, getString(R.string.Unable_process_request), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    public class a implements Runnable {
        public final void run() {
        }
    }
}
