package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import defpackage.C1421u9;
import defpackage.d7;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rx.Observable;
import rx.Subscriber;

public class LoginActivity extends AppCompatActivity {
    public static final /* synthetic */ int e = 0;
    @BindView(2131362531)
    EditText ChangePwdetCaptcha;
    @BindView(2131362184)
    ImageView ChangePwdrefreshCaptcha;
    @BindView(2131362268)
    EditText CnfCaptchaEnter;
    @BindView(2131362267)
    ImageView CnfPwdrefreshCaptcha;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public C0793b1 f4209a;

    /* renamed from: a  reason: collision with other field name */
    public final b f4210a = new b();

    /* renamed from: a  reason: collision with other field name */
    public final e f4211a = new e();

    /* renamed from: a  reason: collision with other field name */
    public final k f4212a = new k();

    /* renamed from: a  reason: collision with other field name */
    public LoginActivity f4213a;

    /* renamed from: a  reason: collision with other field name */
    public Date f4214a;

    /* renamed from: a  reason: collision with other field name */
    public final C1216kd f4215a = new C1216kd();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4216a = false;
    @BindView(2131361924)
    TextView agent_login;
    public LoginActivity b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4217b = false;
    @BindView(2131362146)
    CheckBox bookingWithOtp;
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public String f4218c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f4219c = false;
    @BindView(2131362104)
    ImageView calender;
    @BindView(2131362125)
    ImageView captcha;
    @BindView(2131362183)
    ImageView captchaChangePwd;
    @BindView(2131362266)
    ImageView captchaCnfPwd;
    @BindView(2131362127)
    ImageView captchaForgotUserId;
    @BindView(2131364327)
    EditText captchaInputValue;
    @BindView(2131362124)
    LinearLayout captchaLayout;
    @BindView(2131362703)
    RelativeLayout changePwdlayout;
    @BindView(2131362290)
    EditText confirmPassword;
    public int d = -1;

    /* renamed from: d  reason: collision with other field name */
    public String f4220d = "";

    /* renamed from: d  reason: collision with other field name */
    public boolean f4221d = false;

    /* renamed from: e  reason: collision with other field name */
    public String f4222e;
    @BindView(2131362128)
    EditText etCaptcha;
    @BindView(2131362560)
    EditText et_otp;
    public String f;
    @BindView(2131362707)
    TextView forgotPasswordOnclick;
    @BindView(2131362705)
    RelativeLayout forgotUserId;
    @BindView(2131362704)
    RelativeLayout forgotUserPwd;
    @BindView(2131362701)
    AdManagerAdView forgot_pass2_bottom_ads;
    @BindView(2131362702)
    AdManagerAdView forgot_pass_bottom_ads;
    @BindView(2131362706)
    EditText forgot_userdetail;
    public String g;
    public String h = null;
    public String i;
    public final String j = "";
    public final String k = "^\\d{10}$";
    @BindView(2131363010)
    LinearLayout ll_bus;
    @BindView(2131363102)
    TextView loadingCaptcha;
    @BindView(2131362519)
    TextView loadingCaptchaChangePwd;
    @BindView(2131362269)
    TextView loadingCaptchaCnfPwd;
    @BindView(2131364466)
    TextView loading_Captcha;
    @BindView(2131363737)
    RelativeLayout loginButtonLo;
    @BindView(2131363105)
    AdManagerAdView login_bottom_ads;
    @BindView(2131363210)
    TextView message;
    @BindView(2131363316)
    EditText newPassword;
    @BindView(2131363410)
    TextView otpMsgsShow;
    @BindView(2131363944)
    TextView otpTimmer;
    @BindView(2131363408)
    TextView otp_message;
    @BindView(2131362568)
    EditText password;
    @BindView(2131362728)
    TextView reSendOtp;
    @BindView(2131362126)
    ImageView refreshCaptcha;
    @BindView(2131364561)
    TextView registerUser;
    @BindView(2131364566)
    TextView resendMobTimmer;
    @BindView(2131363734)
    LinearLayout rl_hotel;
    @BindView(2131363064)
    LinearLayout sendOtp;
    @BindView(2131363945)
    TextView send_otp_tv;
    @BindView(2131364039)
    RelativeLayout submitForgotId;
    @BindView(2131362291)
    TextView submitPwd;
    @BindView(2131364042)
    TextView submitUserId;
    @BindView(2131364352)
    TextView tvConfPwdShowHide;
    @BindView(2131364547)
    TextView tvPwdShowHide;
    @BindView(2131362588)
    EditText userName;
    @BindView(2131362185)
    EditText userNameShow;
    @BindView(2131364712)
    EditText user_dob;
    @BindView(2131364800)
    EditText useremail;
    @BindView(2131364908)
    TextView with_otp_tv;
    @BindView(2131364909)
    TextView with_password;

    public class a extends Subscriber<E4> {
        public a() {
        }

        public final void onCompleted() {
            int i = LoginActivity.e;
        }

        public final void onError(Throwable th) {
            int i = LoginActivity.e;
            th.getClass();
            th.getMessage();
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.a.dismiss();
            Lt.b(th, loginActivity.b);
        }

        public final void onNext(Object obj) {
            E4 e4 = (E4) obj;
            LoginActivity loginActivity = LoginActivity.this;
            if (e4 != null) {
                loginActivity.f4214a = e4.getTimeStamp();
                C0657Qt.h();
                try {
                    if (e4.getError() == null) {
                        loginActivity.d = e4.getCaptcha().intValue();
                        loginActivity.i = e4.getStatus();
                        loginActivity.a.dismiss();
                        C1450w1.f7025d = System.currentTimeMillis();
                        int i = loginActivity.d;
                        if (10 == i || 14 == i) {
                            LoginActivity.n(loginActivity, e4.getCaptchaQuestion());
                            return;
                        }
                        return;
                    }
                    loginActivity.a.dismiss();
                    C0535I5.m(loginActivity.f4213a, false, e4.getError(), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), loginActivity.f4210a).show();
                } catch (Exception e) {
                    loginActivity.a.dismiss();
                    int i2 = LoginActivity.e;
                    e.getMessage();
                }
            } else {
                loginActivity.a.dismiss();
                C0535I5.m(loginActivity.f4213a, false, loginActivity.getResources().getString(R.string.unable_process_message), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), loginActivity.f4210a).show();
            }
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            LoginActivity.this.t();
        }
    }

    public class d extends Subscriber<E4> {
        public d() {
        }

        public final void onCompleted() {
            int i = LoginActivity.e;
            LoginActivity.this.a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = LoginActivity.e;
            th.getClass();
            th.getMessage();
            LoginActivity.this.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            E4 e4 = (E4) obj;
            LoginActivity loginActivity = LoginActivity.this;
            if (e4 != null) {
                try {
                    if (e4.getError() == null) {
                        int i = LoginActivity.e;
                        e4.toString();
                        if (e4.getCaptchaQuestion() == null || e4.getCaptchaQuestion().equals("")) {
                            loginActivity.CnfPwdrefreshCaptcha.setVisibility(8);
                            loginActivity.captchaCnfPwd.setVisibility(8);
                            loginActivity.loadingCaptchaChangePwd.setVisibility(8);
                            loginActivity.captchaForgotUserId.setVisibility(8);
                            loginActivity.captchaChangePwd.setVisibility(8);
                            loginActivity.loadingCaptcha.setVisibility(0);
                        } else {
                            loginActivity.loadingCaptcha.setVisibility(8);
                            if (loginActivity.f4220d.equals("FORGOT_USER")) {
                                byte[] decode = Base64.decode(e4.getCaptchaQuestion().getBytes(), 0);
                                loginActivity.captchaForgotUserId.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                                loginActivity.captchaForgotUserId.setVisibility(0);
                                loginActivity.captchaForgotUserId.setBackgroundColor(loginActivity.getResources().getColor(R.color.yellow));
                            } else {
                                byte[] decode2 = Base64.decode(e4.getCaptchaQuestion().getBytes(), 0);
                                loginActivity.captchaChangePwd.setImageBitmap(BitmapFactory.decodeByteArray(decode2, 0, decode2.length));
                                loginActivity.captchaChangePwd.setVisibility(0);
                                loginActivity.loadingCaptchaChangePwd.setVisibility(8);
                                loginActivity.captchaCnfPwd.setImageBitmap(BitmapFactory.decodeByteArray(decode2, 0, decode2.length));
                                loginActivity.captchaChangePwd.setBackgroundColor(loginActivity.getResources().getColor(R.color.yellow));
                                loginActivity.captchaCnfPwd.setBackgroundColor(loginActivity.getResources().getColor(R.color.yellow));
                            }
                        }
                        loginActivity.a.dismiss();
                    } else {
                        C0535I5.m(LoginActivity.this, false, e4.getError(), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), new C0849f()).show();
                    }
                } catch (Exception e) {
                    int i2 = LoginActivity.e;
                    e.getMessage();
                    C0535I5.m(LoginActivity.this, false, e.getMessage(), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), new C0850g()).show();
                }
            } else {
                C0535I5.m(loginActivity, false, loginActivity.getResources().getString(R.string.unable_process_message), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), new C0851h()).show();
            }
            loginActivity.a.dismiss();
        }
    }

    public class g extends Subscriber<StatusDTO> {
        public g() {
        }

        public final void onCompleted() {
            int i = LoginActivity.e;
            LoginActivity.this.a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = LoginActivity.e;
            th.getClass();
            th.getMessage();
            LoginActivity.this.a.dismiss();
            Lt.a(false, th);
        }

        public final void onNext(Object obj) {
            StatusDTO statusDTO = (StatusDTO) obj;
            int i = LoginActivity.e;
            LoginActivity loginActivity = LoginActivity.this;
            if (statusDTO != null) {
                C0657Qt.h();
                if (statusDTO.getError() == null) {
                    C0535I5.o(loginActivity, statusDTO.getStatus(), loginActivity.getString(R.string.OK), new C0852i(this)).show();
                } else {
                    C0535I5.m(LoginActivity.this, false, statusDTO.getError(), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), new C0853j(this)).show();
                }
            } else {
                C0535I5.m(loginActivity, false, loginActivity.getResources().getString(R.string.unable_process_message), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), new C0854k()).show();
            }
            loginActivity.a.dismiss();
        }
    }

    public class i extends Subscriber<Xo> {
        public i() {
        }

        public final void onCompleted() {
            int i = LoginActivity.e;
            LoginActivity.this.a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = LoginActivity.e;
            th.getClass();
            th.getMessage();
            LoginActivity.this.a.dismiss();
            Lt.a(false, th);
        }

        public final void onNext(Object obj) {
            String next;
            Xo xo = (Xo) obj;
            int i = LoginActivity.e;
            LoginActivity loginActivity = LoginActivity.this;
            if (xo != null) {
                C0657Qt.h();
                if (xo.getErrorList() == null) {
                    loginActivity.changePwdlayout.setVisibility(0);
                    loginActivity.et_otp.requestFocus();
                    new C0855l(loginActivity).start();
                    C0535I5.I(loginActivity.b);
                    loginActivity.userName.setFocusable(false);
                    loginActivity.password.setFocusable(false);
                    loginActivity.forgotUserPwd.setVisibility(8);
                    loginActivity.a.dismiss();
                    byte[] decode = Base64.decode(xo.getCaptchaDto().getCaptchaQuestion().getBytes(), 0);
                    loginActivity.captchaCnfPwd.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                    loginActivity.loadingCaptchaCnfPwd.setVisibility(8);
                    loginActivity.captchaCnfPwd.setVisibility(0);
                    loginActivity.otpMsgsShow.setText(xo.getStatus());
                    C0535I5.m(LoginActivity.this, false, xo.getStatus(), loginActivity.getString(R.string.Info), loginActivity.getString(R.string.OK), new C0856m()).show();
                    loginActivity.forgotUserPwd.setVisibility(8);
                } else {
                    if (xo.getCaptchaDto() != null) {
                        byte[] decode2 = Base64.decode(xo.getCaptchaDto().getCaptchaQuestion().getBytes(), 0);
                        loginActivity.captchaCnfPwd.setImageBitmap(BitmapFactory.decodeByteArray(decode2, 0, decode2.length));
                    }
                    Iterator<String> it = xo.getErrorList().iterator();
                    String str = "";
                    while (it.hasNext() && (next = it.next()) != null) {
                        if (!next.equals("")) {
                            str = xx.D(str, next, "\n");
                        }
                    }
                    C0535I5.m(loginActivity, false, str, loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), new C0857n(this)).show();
                }
            } else {
                C0535I5.m(loginActivity, false, loginActivity.getResources().getString(R.string.unable_process_message), loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), new C0858o()).show();
            }
            loginActivity.a.dismiss();
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        public final void onClick(View view) {
            int i = LoginActivity.e;
            String Q = C0535I5.Q("USER_REGISTRATION");
            LoginActivity loginActivity = LoginActivity.this;
            if (Q != null) {
                C0535I5.o(loginActivity, loginActivity.getString(R.string.new_registration_is_disabled_from) + Q, loginActivity.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                return;
            }
            try {
                loginActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.irctc.co.in/nget/profile/user-signup")));
            } catch (Exception e) {
                int i2 = LoginActivity.e;
                e.getMessage();
            }
        }
    }

    public class k implements View.OnTouchListener {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            view.setFocusable(true);
            view.setEnabled(true);
            view.setFocusableInTouchMode(true);
            return false;
        }
    }

    public class m extends C1421u9.a {
        public m(EditText editText) {
            super(editText);
        }

        public final void a() {
            LoginActivity loginActivity = LoginActivity.this;
            if (loginActivity.password.getInputType() == 145) {
                loginActivity.password.setInputType(129);
                EditText editText = loginActivity.password;
                editText.setSelection(editText.getText().length());
                loginActivity.password.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility_off, 0);
                return;
            }
            loginActivity.password.setInputType(145);
            EditText editText2 = loginActivity.password;
            editText2.setSelection(editText2.getText().length());
            loginActivity.password.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility, 0);
            for (Drawable drawable : loginActivity.password.getCompoundDrawables()) {
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(loginActivity.f4213a.getResources().getColor(R.color.black_90_opa), PorterDuff.Mode.SRC_IN));
                }
            }
        }
    }

    public class o implements DatePickerDialog.OnDateSetListener {
        public o() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Object obj;
            Object obj2;
            int i4 = LoginActivity.e;
            LoginActivity loginActivity = LoginActivity.this;
            EditText editText = loginActivity.user_dob;
            StringBuilder sb = new StringBuilder();
            if (i3 > 9) {
                obj = Integer.valueOf(i3);
            } else {
                obj = lf.h("0", i3);
            }
            sb.append(obj);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            int i5 = i2 + 1;
            if (i5 > 9) {
                obj2 = Integer.valueOf(i5);
            } else {
                obj2 = lf.h("0", i5);
            }
            sb.append(obj2);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(i);
            editText.setText(sb);
            loginActivity.user_dob.getText().toString();
            loginActivity.user_dob.setError((CharSequence) null);
        }
    }

    static {
        C1354qp.R(LoginActivity.class);
    }

    public static void l(LoginActivity loginActivity) {
        loginActivity.password.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView = loginActivity.with_otp_tv;
        Object obj = d7.a;
        textView.setTextColor(d7.b.a(loginActivity, R.color.white));
        loginActivity.userName.setText("");
        loginActivity.password.setText("");
    }

    public static void m(LoginActivity loginActivity) {
        loginActivity.getClass();
        Object obj = d7.a;
        loginActivity.password.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, d7.a.b(loginActivity, R.drawable.visibility_off), (Drawable) null);
        loginActivity.with_password.setTextColor(d7.b.a(loginActivity, R.color.white));
        loginActivity.userName.setText("");
        loginActivity.password.setText("");
    }

    public static void n(LoginActivity loginActivity, String str) {
        loginActivity.getClass();
        if (!C0535I5.n) {
            TextView textView = loginActivity.with_password;
            Object obj = d7.a;
            textView.setTextColor(d7.b.a(loginActivity, R.color.white));
            loginActivity.with_password.setBackgroundColor(loginActivity.getResources().getColor(R.color.orange));
        }
        loginActivity.captchaLayout.setVisibility(0);
        if (str == null || str.equals("")) {
            loginActivity.captcha.setVisibility(8);
            loginActivity.loading_Captcha.setVisibility(0);
            return;
        }
        loginActivity.loading_Captcha.setVisibility(8);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        loginActivity.captcha.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        loginActivity.captcha.setVisibility(0);
    }

    public final boolean A() {
        if (this.f4220d.equals("FORGOT_USER")) {
            if (!this.etCaptcha.getText().toString().trim().equalsIgnoreCase("")) {
                this.etCaptcha.setError((CharSequence) null);
                return true;
            }
            this.etCaptcha.setError(getString(R.string.please_enter_Captcha));
            return false;
        } else if (!this.ChangePwdetCaptcha.getText().toString().trim().equalsIgnoreCase("")) {
            this.ChangePwdetCaptcha.setError((CharSequence) null);
            return true;
        } else {
            this.ChangePwdetCaptcha.setError(getString(R.string.please_enter_Captcha));
            return false;
        }
    }

    public final String B(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return getString(R.string.please_provide_Confirm_password);
        }
        if (str.equals(str2)) {
            return getString(R.string.ok);
        }
        return getString(R.string.password_and_confirm_password_mismatch);
    }

    public final String C(String str) {
        String string = getString(R.string.ok);
        if (str.length() == 0) {
            return getString(R.string.enter_password);
        }
        if (str.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,15}$")) {
            return string;
        }
        return getString(R.string.characters_long_capital_small_numeric);
    }

    public final boolean D() {
        if (this.f4220d.equals("FORGOT_USER")) {
            if (!this.useremail.getText().toString().trim().equalsIgnoreCase("")) {
                this.useremail.setError((CharSequence) null);
                return true;
            }
            this.useremail.setError(getString(R.string.please_enter_valid_user_detail));
            return false;
        } else if (!this.forgot_userdetail.getText().toString().trim().equalsIgnoreCase("")) {
            this.forgot_userdetail.setError((CharSequence) null);
            return true;
        } else {
            this.forgot_userdetail.setError(getString(R.string.please_enter_valid_user_detail));
            return false;
        }
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    @OnFocusChange({2131362290})
    public void cnfPasswordval(View view) {
        if (!this.confirmPassword.hasFocus()) {
            String B = B(this.newPassword.getText().toString(), this.confirmPassword.getText().toString());
            if (!B.equalsIgnoreCase(getString(R.string.ok))) {
                this.confirmPassword.setError(B);
            } else {
                this.confirmPassword.setError((CharSequence) null);
            }
        }
    }

    @OnClick({2131364352})
    public void confPwdShowHide() {
        z(this.confirmPassword, this.tvConfPwdShowHide);
    }

    @OnClick({2131362104})
    public void dobCalender() {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new o(), instance.get(1), instance.get(2), instance.get(5));
        Calendar instance2 = Calendar.getInstance();
        Calendar instance3 = Calendar.getInstance();
        instance2.add(1, -5);
        instance3.add(1, -143);
        datePickerDialog.getDatePicker().setMaxDate(instance2.getTime().getTime());
        datePickerDialog.getDatePicker().setMinDate(instance3.getTime().getTime());
        datePickerDialog.setTitle(getString(R.string.Select_Date_of_Birth));
        datePickerDialog.show();
    }

    public final void init() {
        EditText editText = this.userName;
        k kVar = this.f4212a;
        editText.setOnTouchListener(kVar);
        this.password.setOnTouchListener(kVar);
    }

    @OnClick({2131363104})
    public void loginCaptchaRefresh() {
        t();
    }

    public final void o() {
        String str = this.f4218c;
        C1216kd kdVar = this.f4215a;
        kdVar.setTxnId(str);
        kdVar.setUserId(this.forgot_userdetail.getText().toString().trim());
        kdVar.setCaptcha(this.ChangePwdetCaptcha.getText().toString());
        kdVar.setSeqType((String) null);
        kdVar.setDob(this.user_dob.getText().toString());
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
            startActivity(Intent.parseUri("https://www.air.irctc.co.in/?utm_source=login", 1));
        } catch (Exception unused) {
            C0535I5.t0(getApplicationContext(), getString(R.string.error_opening_air_app));
        }
    }

    @OnClick({2131364309})
    public void onBackClick() {
        onBackPressed();
    }

    public final void onBackPressed() {
        this.f4209a.f3912a = null;
        if (this.forgotUserPwd.getVisibility() == 0 || this.changePwdlayout.getVisibility() == 0 || this.forgotUserId.getVisibility() == 0) {
            this.password.setFocusableInTouchMode(true);
            this.userName.setFocusableInTouchMode(true);
            this.userName.setFocusable(true);
            this.forgotUserPwd.setVisibility(8);
            this.changePwdlayout.setVisibility(8);
            this.forgotUserId.setVisibility(8);
            this.login_bottom_ads.setVisibility(0);
            return;
        }
        HomeActivity.f4186b = false;
        finish();
        if (this.f4219c) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("isDashBoardLanding", 0);
            startActivity(intent);
        }
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
        if (!this.bookingWithOtp.isChecked()) {
            this.bookingWithOtp.setChecked(false);
            this.h = "N";
            C0535I5.f3620a = "N";
            int i2 = this.d;
            if (10 == i2 || 14 == i2) {
                this.captchaLayout.setVisibility(0);
                return;
            }
            return;
        }
        this.bookingWithOtp.setChecked(true);
        this.h = "OTP";
        C0535I5.f3620a = "OTP";
        this.captchaLayout.setVisibility(8);
    }

    @OnClick({2131363945})
    public void onClickSendOtp(View view) {
        if (xx.B(this.userName) == null || this.userName.getText().toString().trim().equals("")) {
            this.userName.setError(getString(R.string.plrase_provide_useename));
        } else if (!C0535I5.O((ConnectivityManager) this.f4213a.getSystemService("connectivity"), this.f4213a)) {
            new Handler().postDelayed(new C0530Hi(), 5000);
        } else {
            Om om = (Om) C0657Qt.b();
            String B = xx.B(this.userName);
            if (!B.equals("")) {
                C1229kx kxVar = new C1229kx();
                kxVar.setUserId(B);
                ProgressDialog show = ProgressDialog.show(this, getString(R.string.loading), getString(R.string.Loading_Captcha));
                this.a = show;
                show.show();
                String f2 = C0657Qt.f();
                om.a1(f2 + "generateUserOTP", kxVar).c(C1181iv.a()).a(E0.a()).b(new u(this));
            }
        }
    }

    @OnClick({2131362705})
    public void onClickSpinnerDisable(View view) {
        C0535I5.I(this);
        this.password.setFocusableInTouchMode(true);
        this.userName.setFocusableInTouchMode(true);
        this.password.setFocusable(true);
        this.userName.setFocusable(true);
        this.login_bottom_ads.setVisibility(0);
        if (this.forgotUserId.getVisibility() == 0) {
            this.forgotUserId.setVisibility(8);
            this.user_dob.setText("");
            this.useremail.setText("");
            this.etCaptcha.setText("");
            return;
        }
        this.forgotUserId.setVisibility(0);
    }

    @OnClick({2131364908})
    public void onClickWithOtp(View view) {
        C0535I5.n = true;
        x(true);
    }

    @OnClick({2131364909})
    public void onClickWithPassword(View view) {
        C0535I5.n = false;
        x(false);
    }

    @OnClick({2131362703})
    public void onClickforgotPwdCnfSpinnerGone(View view) {
        C0535I5.I(this);
        this.password.setFocusableInTouchMode(true);
        this.userName.setFocusableInTouchMode(true);
        this.userName.setFocusable(true);
        C0535I5.Y(this, this.forgot_pass2_bottom_ads, (GoogleAdParamDTO) null);
        this.login_bottom_ads.setVisibility(8);
        if (this.changePwdlayout.getVisibility() == 8) {
            this.changePwdlayout.setVisibility(0);
            return;
        }
        this.et_otp.setText("");
        this.newPassword.setText("");
        this.confirmPassword.setText("");
        this.CnfCaptchaEnter.setText("");
        this.changePwdlayout.setVisibility(8);
    }

    @OnClick({2131362704})
    public void onClickforgotPwdSpinnerGone(View view) {
        C0535I5.I(this);
        this.password.setFocusableInTouchMode(true);
        this.userName.setFocusableInTouchMode(true);
        this.password.setFocusable(true);
        this.userName.setFocusable(true);
        this.login_bottom_ads.setVisibility(0);
        if (this.forgotUserPwd.getVisibility() == 8) {
            this.forgotUserPwd.setVisibility(0);
            return;
        }
        this.forgot_userdetail.setText("");
        this.ChangePwdetCaptcha.setText("");
        this.forgotUserPwd.setVisibility(8);
    }

    @OnClick({2131362291})
    public void onConfirmClick() {
        Boolean bool = Boolean.TRUE;
        if (this.userNameShow.getText().toString().isEmpty() || this.userNameShow.getText().toString() == null) {
            bool = Boolean.FALSE;
            this.userNameShow.setError(getString(R.string.enter_reg_user_name));
        }
        if (this.et_otp.getText().toString().isEmpty() || this.et_otp.getText().toString() == null) {
            bool = Boolean.FALSE;
            this.et_otp.setError(getString(R.string.enter_received_otp));
        }
        String C = C(this.newPassword.getText().toString());
        if (!C.equalsIgnoreCase(getString(R.string.ok))) {
            bool = Boolean.valueOf(bool.booleanValue() & false);
            this.newPassword.setError(C);
        } else {
            this.newPassword.setError((CharSequence) null);
        }
        String B = B(this.newPassword.getText().toString(), this.confirmPassword.getText().toString());
        if (!B.equalsIgnoreCase(getString(R.string.ok))) {
            bool = Boolean.valueOf(bool.booleanValue() & false);
            this.confirmPassword.setError(B);
        } else {
            this.confirmPassword.setError((CharSequence) null);
        }
        if (this.CnfCaptchaEnter.getText().toString().isEmpty()) {
            bool = Boolean.valueOf(bool.booleanValue() & false);
            this.CnfCaptchaEnter.setError(getString(R.string.please_enter_Captcha));
        }
        if (!bool.booleanValue()) {
            return;
        }
        if (!C0535I5.O((ConnectivityManager) getApplicationContext().getSystemService("connectivity"), getApplicationContext())) {
            new Handler().postDelayed(new C0497Ei(), 5000);
            return;
        }
        ProgressDialog show = ProgressDialog.show(this, getString(R.string.loading_only), getString(R.string.please_wait_text));
        this.a = show;
        show.show();
        Xo xo = new Xo();
        xo.setSource(5);
        xo.setNewPassword(this.newPassword.getText().toString());
        xo.setConfPassword(this.confirmPassword.getText().toString());
        xo.setSeqAns(this.et_otp.getText().toString());
        xo.setTxnId(this.f4218c);
        xo.setUserId(this.userNameShow.getText().toString());
        xo.setCaptcha(this.CnfCaptchaEnter.getText().toString());
        String f2 = C0657Qt.f();
        ((Om) C0657Qt.b()).Q(f2 + "forgotPasswordConfirm", xo).c(C1181iv.a()).a(E0.a()).b(new C0860q(this));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_login);
        ButterKnife.bind((Activity) this);
        this.b = this;
        this.f4213a = this;
        C1450w1.f7024c = false;
        C1450w1.f7007a = null;
        if (getIntent().getExtras() != null) {
            this.c = getIntent().getExtras().getInt("isDashBoardLanding");
            this.f4219c = getIntent().getExtras().getBoolean("backchangepass");
        }
        this.password.setInputType(129);
        this.f4209a = C0793b1.a;
        Bw e2 = Bw.e(getApplicationContext());
        if (!TextUtils.isEmpty(e2.h())) {
            this.userName.setText(e2.h());
            this.password.requestFocus();
        }
        this.password.setText("");
        init();
        this.registerUser.setOnClickListener(new j());
        this.f4218c = "0";
        this.user_dob.addTextChangedListener(this.f4211a);
        try {
            String charSequence = this.message.getText().toString();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            spannableStringBuilder.setSpan(new StyleSpan(1), charSequence.indexOf("updated"), charSequence.indexOf("updated") + 19, 18);
            this.message.setText(spannableStringBuilder);
        } catch (Exception e3) {
            e3.getMessage();
        }
        EditText editText = this.password;
        editText.setOnTouchListener(new m(editText));
        C0535I5.Y(this, this.login_bottom_ads, (GoogleAdParamDTO) null);
        C0535I5.Y(this, this.forgot_pass_bottom_ads, (GoogleAdParamDTO) null);
        C0535I5.Y(this, this.forgot_pass2_bottom_ads, (GoogleAdParamDTO) null);
        C0535I5.a(this.etCaptcha, 10);
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    @OnClick({2131362707})
    public void onForgotPasswordClick(View view) {
        C0535I5.I(this);
        this.userName.setFocusable(false);
        this.password.setFocusable(false);
        this.forgot_userdetail.setError((CharSequence) null);
        this.ChangePwdetCaptcha.setError((CharSequence) null);
        if (this.forgotUserPwd.getVisibility() == 8) {
            this.forgotUserPwd.setVisibility(0);
            this.f4220d = "FORGOT_PASSWORD";
            this.forgot_userdetail.setText("");
            this.ChangePwdetCaptcha.setText("");
            p();
            C0535I5.Y(this, this.forgot_pass_bottom_ads, (GoogleAdParamDTO) null);
            this.login_bottom_ads.setVisibility(8);
            return;
        }
        this.forgotUserPwd.setVisibility(8);
    }

    @OnClick({2131362728})
    public void onGenerateClick() {
        o();
        this.a = ProgressDialog.show(this, getString(R.string.loading), getString(R.string.please_wait_text));
        String obj = this.forgot_userdetail.getText().toString();
        String f2 = C0657Qt.f();
        String.format("/%s/%s", new Object[]{this.f4218c, obj});
        ((Om) C0657Qt.b()).I(f2 + "forgotPassinit", this.f4215a).c(C1181iv.a()).a(E0.a()).b(new C0521Gi(this));
        this.et_otp.requestFocus();
        new C0855l(this).start();
    }

    @OnClick({2131363737})
    public void onLoginClick(View view) {
        boolean z;
        boolean z2;
        Observable<C1223kn> observable;
        int i2;
        if (!C0535I5.O((ConnectivityManager) getSystemService("connectivity"), view.getContext())) {
            new Handler().postDelayed(new n(), 5000);
            return;
        }
        C0535I5.H(this, view);
        if (this.f4217b || !this.f4216a || this.bookingWithOtp.isChecked()) {
            if (isFinishing()) {
                finish();
            }
            this.f4209a.f3912a = null;
            C0657Qt.a();
            this.f4222e = xx.B(this.userName);
            this.f = xx.B(this.password);
            this.g = xx.B(this.captchaInputValue);
            if (this.f4222e.equals("") || this.f4222e == null || this.f.equals("") || this.f == null) {
                z = false;
            } else {
                z = true;
            }
            if (this.f4222e.equals("") || this.f4222e == null || this.f.equals("") || this.f == null || this.g.equals("") || this.g == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean a2 = C5.a(this.f4214a);
            if (a2) {
                z = false;
            } else if (this.f4216a && !this.bookingWithOtp.isChecked() && (10 == (i2 = this.d) || 14 == i2)) {
                z = z2;
            }
            if (z) {
                ProgressDialog progressDialog = this.a;
                if (progressDialog != null && progressDialog.isShowing()) {
                    this.a.dismiss();
                }
                this.a = ProgressDialog.show(this, getString(R.string.checking_credentials), getString(R.string.please_wait_text));
                C1261mn mnVar = new C1261mn();
                mnVar.setGrant_type("password");
                mnVar.setUsername(this.f4222e);
                mnVar.setPassword(Base64.encodeToString(this.f.getBytes(), 0));
                String substring = (this.g + this.i + "AAAAAAAAAAAAAAAA").substring(0, 16);
                String str = mnVar.getUsername() + "#UP#" + mnVar.getPassword() + "#UP#" + new Date().getTime();
                try {
                    C1243ln lnVar = (C1243ln) C0657Qt.d(mnVar.getUsername(), mnVar.getPassword());
                    if (this.f4216a) {
                        observable = lnVar.b(mnVar.getGrant_type(), C0535I5.w(str, substring), "true", this.g, this.i, this.bookingWithOtp.isChecked() + "", (String) null, (String) null, (String) null, this.j);
                    } else {
                        observable = lnVar.a(mnVar.getGrant_type(), mnVar.getUsername(), mnVar.getPassword(), this.bookingWithOtp.isChecked() + "");
                    }
                    observable.c(C1181iv.a()).a(E0.a()).b(new s(this));
                } catch (Exception e2) {
                    this.a.dismiss();
                    e2.getMessage();
                    C0535I5.t0(getBaseContext(), getString(R.string.unable_process_message));
                }
            } else if (!this.f4216a) {
                C0535I5.t0(getBaseContext(), getString(R.string.plrase_provide_useename_password));
            } else if (this.bookingWithOtp.isChecked()) {
                C0535I5.t0(getBaseContext(), getString(R.string.plrase_provide_useename_password));
            } else if (this.f4222e.isEmpty() && this.f.isEmpty() && this.g.isEmpty()) {
                C0535I5.t0(getBaseContext(), getString(R.string.blank_login_credential));
            } else if (this.f4222e.isEmpty()) {
                C0535I5.t0(getBaseContext(), getString(R.string.plrase_provide_useename));
                this.userName.requestFocus();
                ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.userName, 1);
            } else if (this.f.isEmpty()) {
                C0535I5.t0(getBaseContext(), getString(R.string.plrase_provide_password));
                this.password.requestFocus();
                ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.password, 1);
            } else if (a2) {
                C0535I5.m(this, false, getString(R.string.time_zone_msg), getString(R.string.Info), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else {
                C0535I5.t0(getBaseContext(), getString(R.string.provide_captcha));
                this.captchaInputValue.requestFocus();
                ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.captchaInputValue, 1);
            }
        } else {
            t();
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

    public final void onRestart() {
        super.onRestart();
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
        Bw.e(getApplicationContext()).C((String) null);
        this.f4216a = true;
        this.f4217b = true;
        this.captchaLayout.setVisibility(0);
        t();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    @OnClick({2131364041})
    public void onSubmitPwd() {
        ProgressDialog show = ProgressDialog.show(this, getString(R.string.loading), getString(R.string.please_wait_text));
        this.a = show;
        show.show();
        if (this.forgot_userdetail.getText() != null) {
            Matcher matcher = Pattern.compile(this.k).matcher(this.forgot_userdetail.getText().toString());
            if (!this.forgot_userdetail.getText().toString().contains("@") && !matcher.matches()) {
                this.userNameShow.setText(this.forgot_userdetail.getText().toString());
                this.userNameShow.setClickable(false);
                this.userNameShow.setEnabled(false);
            } else if (matcher.matches()) {
                this.userNameShow.setText("");
            } else if (this.forgot_userdetail.getText().toString().contains("@")) {
                this.userNameShow.setText("");
            } else {
                this.userNameShow.setText((CharSequence) null);
                this.userNameShow.setClickable(true);
                this.userNameShow.setEnabled(true);
            }
        }
        if (!C0535I5.O((ConnectivityManager) getApplicationContext().getSystemService("connectivity"), getApplicationContext())) {
            new Handler().postDelayed(new h(), 5000);
        } else if (this.f4218c.equals("0")) {
            this.a.dismiss();
            C0535I5.m(this, false, getString(R.string.Please_try_after_sometime), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (!D() || !A()) {
            this.a.dismiss();
        } else {
            o();
            ((Om) C0657Qt.b()).I(C1058d.z(C0657Qt.f(), "forgotPassinit"), this.f4215a).c(C1181iv.a()).a(E0.a()).b(new i());
        }
    }

    @OnClick({2131364042})
    public void onSubmitUser() {
        String str;
        DB db = new DB();
        if (xx.T(this.useremail, "")) {
            C0535I5.t0(getBaseContext(), getString(R.string.Please_provide_email));
            return;
        }
        String obj = this.useremail.getText().toString();
        AlertDialog alertDialog = C0535I5.f3619a;
        if (!Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$", 2).matcher(obj).matches()) {
            C0535I5.t0(getBaseContext(), getString(R.string.please_provide_correct_email));
        } else if (xx.T(this.user_dob, "")) {
            C0535I5.t0(getBaseContext(), getString(R.string.please_provide_dob));
        } else if (this.f4221d) {
            C0535I5.t0(getBaseContext(), getString(R.string.enter_valid_dateformate));
            this.user_dob.requestFocus();
        } else if (xx.T(this.etCaptcha, "")) {
            C0535I5.t0(getBaseContext(), getString(R.string.please_enter_Captcha));
        } else if (this.f4218c.equals("0")) {
            C0535I5.m(this, false, getResources().getString(R.string.Please_try_after_sometime), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else {
            db.setTxnId(this.f4218c);
            db.setEmail(this.useremail.getText().toString().trim());
            db.setCaptcha(this.etCaptcha.getText().toString());
            try {
                str = new SimpleDateFormat("yyyyMMdd").format(new SimpleDateFormat("dd/MM/yyyy").parse(this.user_dob.getText().toString())).toString();
            } catch (Exception e2) {
                e2.getMessage();
                str = "";
            }
            ProgressDialog show = ProgressDialog.show(this, getString(R.string.loading), getString(R.string.please_wait));
            this.a = show;
            show.show();
            if (!C0535I5.O((ConnectivityManager) getApplicationContext().getSystemService("connectivity"), getApplicationContext())) {
                new Handler().postDelayed(new f(), 5000);
                return;
            }
            this.user_dob.getText().equals("");
            if (A()) {
                String f2 = C0657Qt.f();
                String format = String.format("/%s", new Object[]{str});
                ((Om) C0657Qt.b()).f(f2 + "forgotDetails" + format, db).c(C1181iv.a()).a(E0.a()).b(new g());
                return;
            }
            this.a.dismiss();
        }
    }

    @OnClick({2131363736})
    public void onTourismAppClick(View view) {
        try {
            startActivity(Intent.parseUri("https://www.irctctourism.com/?utm_source=login", 1));
        } catch (Exception unused) {
            C0535I5.t0(getApplicationContext(), getString(R.string.error_opening_air_app));
        }
    }

    @OnClick({2131364713})
    public void onUserGuideClick() {
        if (!C0535I5.O((ConnectivityManager) this.b.getSystemService("connectivity"), this.b)) {
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
            Intent parseUri = Intent.parseUri("https://www.bus.irctc.co.in/home?utm_source=login", 1);
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
    public void onhotelClick(View view) {
        try {
            Intent parseUri = Intent.parseUri("https://www.hotels.irctc.co.in/hotel?utm_source=login", 1);
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
        if (!C0535I5.O((ConnectivityManager) this.f4213a.getSystemService("connectivity"), this.f4213a)) {
            new Handler().postDelayed(new c(), 5000);
            return;
        }
        this.captchaForgotUserId.setVisibility(8);
        this.captchaChangePwd.setVisibility(8);
        this.loadingCaptcha.setVisibility(0);
        ProgressDialog show = ProgressDialog.show(this, getString(R.string.loading), getString(R.string.Loading_Captcha));
        this.a = show;
        show.show();
        this.f4218c = String.valueOf(((long) (new SecureRandom().nextDouble() * 9.0E9d)) + 1000000000);
        String f2 = C0657Qt.f();
        String format = String.format("/%s/%s", new Object[]{this.f4218c, this.f4220d});
        ((Om) C0657Qt.b()).D(f2 + "captchaganetate" + format, "").c(C1181iv.a()).a(E0.a()).b(new d());
    }

    @OnFocusChange({2131363316})
    public void passwordval(View view) {
        if (this.newPassword.hasFocus()) {
            this.newPassword.setVisibility(0);
            return;
        }
        String C = C(this.newPassword.getText().toString());
        if (!C.equalsIgnoreCase(getString(R.string.ok))) {
            this.newPassword.setError(C);
        } else {
            this.newPassword.setError((CharSequence) null);
        }
    }

    @OnClick({2131364547})
    public void pwdShowHide() {
        z(this.newPassword, this.tvPwdShowHide);
    }

    @OnClick({2131362126})
    public void refreshCaptcha(View view) {
        this.etCaptcha.setText("");
        p();
    }

    @OnClick({2131362267})
    public void refreshCaptchaCNFPwd(View view) {
        this.CnfCaptchaEnter.setText("");
        p();
    }

    @OnClick({2131362184})
    public void refreshCaptchaPwd(View view) {
        this.ChangePwdetCaptcha.setText("");
        p();
    }

    public final void t() {
        if (!C0535I5.O((ConnectivityManager) this.f4213a.getSystemService("connectivity"), this.f4213a)) {
            new Handler().postDelayed(new p(), 5000);
            return;
        }
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        this.a = ProgressDialog.show(this.f4213a, getResources().getString(R.string.refresh_Captcha), getResources().getString(R.string.please_wait_text), false, false);
        String f2 = C0657Qt.f();
        ((Om) C0657Qt.b()).L0(f2 + "loginCaptcha", "true").c(C1181iv.a()).a(E0.a()).b(new a());
        this.captchaInputValue.setText("");
    }

    @OnFocusChange({2131362531})
    public void validateCaptcha(View view) {
        if (!this.ChangePwdetCaptcha.hasFocus() && !this.etCaptcha.hasFocus()) {
            A();
        }
    }

    @OnFocusChange({2131362706})
    public void validateUser(View view) {
        if (!this.forgot_userdetail.hasFocus() && !this.useremail.hasFocus()) {
            D();
        }
    }

    public final void x(boolean z) {
        if (!z) {
            this.h = "N";
            C0535I5.f3620a = "N";
            this.sendOtp.setVisibility(8);
            this.userName.setHint("User Name / Mobile / Email");
            this.password.setHint("Password");
            this.password.setFocusableInTouchMode(true);
            this.with_otp_tv.setBackground((Drawable) null);
            TextView textView = this.with_otp_tv;
            Object obj = d7.a;
            textView.setTextColor(d7.b.a(this, R.color.dark));
            this.with_password.setBackgroundColor(getResources().getColor(R.color.orange));
            this.password.postDelayed(new gA(this, 12), 10);
            int i2 = this.d;
            if (10 == i2 || 14 == i2) {
                this.captchaLayout.setVisibility(0);
                return;
            }
            return;
        }
        this.h = "OTP";
        this.userName.setHint("Username / Email");
        this.password.setHint("OTP");
        this.password.setFocusableInTouchMode(false);
        this.with_password.setBackground((Drawable) null);
        TextView textView2 = this.with_password;
        Object obj2 = d7.a;
        textView2.setTextColor(d7.b.a(this, R.color.dark));
        this.with_otp_tv.setBackgroundColor(getResources().getColor(R.color.orange));
        this.send_otp_tv.setText("Send OTP");
        this.otp_message.setText("");
        this.send_otp_tv.setEnabled(true);
        this.otpTimmer.setText("");
        this.password.postDelayed(new C0140b6(this, 8), 10);
        C0535I5.f3620a = this.h;
        this.captchaLayout.setVisibility(8);
        this.sendOtp.setVisibility(0);
    }

    public final void z(EditText editText, TextView textView) {
        if (editText.getInputType() == 145) {
            editText.setInputType(129);
            editText.setSelection(editText.getText().length());
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility_off, 0);
            return;
        }
        editText.setInputType(145);
        editText.setSelection(editText.getText().length());
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility, 0);
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(this.f4213a.getResources().getColor(R.color.black_90_opa), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public class c implements Runnable {
        public final void run() {
        }
    }

    public class f implements Runnable {
        public final void run() {
        }
    }

    public class h implements Runnable {
        public final void run() {
        }
    }

    public class l implements Runnable {
        public final void run() {
        }
    }

    public class n implements Runnable {
        public final void run() {
        }
    }

    public class p implements Runnable {
        public final void run() {
        }
    }

    @OnFocusChange({2131362531})
    public void validUserChangePwd(View view) {
    }

    public class e implements TextWatcher {
        public e() {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() == 10) {
                LoginActivity.this.etCaptcha.requestFocus();
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.f4221d = false;
            try {
                if (charSequence2.length() == 2 && i2 == 0) {
                    if (Integer.parseInt(charSequence2) >= 1) {
                        if (Integer.parseInt(charSequence2) <= 31) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            loginActivity.user_dob.setText(charSequence2);
                            loginActivity.user_dob.setSelection(charSequence2.length());
                        }
                    }
                    loginActivity.f4221d = true;
                }
                if (charSequence2.length() == 5 && i2 == 0) {
                    String substring = charSequence2.substring(3);
                    if (Integer.parseInt(substring) >= 1) {
                        if (Integer.parseInt(substring) <= 12) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            loginActivity.user_dob.setText(charSequence2);
                            loginActivity.user_dob.setSelection(charSequence2.length());
                        }
                    }
                    loginActivity.f4221d = true;
                }
                if (charSequence2.length() == 10 && i2 == 0) {
                    String substring2 = charSequence2.substring(6);
                    int i4 = Calendar.getInstance().get(1);
                    if (Integer.parseInt(substring2) > i4 - 5 || Integer.parseInt(substring2) < i4 - 143) {
                        loginActivity.user_dob.setError(loginActivity.getString(R.string.please_provide_correct_dob));
                        loginActivity.f4221d = true;
                    }
                    String obj = loginActivity.user_dob.getText().toString();
                    char[] charArray = obj.toCharArray();
                    if (charArray[2] != '/') {
                        loginActivity.f4221d = true;
                    }
                    if (charArray[5] != '/') {
                        loginActivity.f4221d = true;
                    }
                    if (Integer.parseInt(obj.substring(0, 2)) < 1 || Integer.parseInt(obj.substring(0, 2)) > 31) {
                        loginActivity.f4221d = true;
                    }
                    if (Integer.parseInt(obj.substring(3, 5)) < 1 || Integer.parseInt(obj.substring(3, 5)) > 12) {
                        loginActivity.f4221d = true;
                    }
                }
                if (loginActivity.f4221d) {
                    C0535I5.t0(loginActivity.getBaseContext(), loginActivity.getString(R.string.enter_valid_dateformate));
                }
            } catch (Exception e) {
                int i5 = LoginActivity.e;
                e.getMessage();
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
