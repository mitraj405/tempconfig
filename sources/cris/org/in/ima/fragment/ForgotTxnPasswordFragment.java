package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

public class ForgotTxnPasswordFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public Xo a = new Xo();

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4643a;

    /* renamed from: a  reason: collision with other field name */
    public Context f4644a;

    /* renamed from: a  reason: collision with other field name */
    public C1196jd f4645a = new C1196jd();
    @BindView(2131362280)
    TextView conPassVisibi;
    @BindView(2131362523)
    EditText confirmPassword;
    @BindView(2131362533)
    EditText et_forgot_pwd_email;
    @BindView(2131362534)
    EditText et_forgot_pwd_login_pwd;
    @BindView(2131363027)
    LinearLayout ll_forgot_pass;
    @BindView(2131363064)
    LinearLayout ll_send_otp;
    @BindView(2131363277)
    AdManagerAdView mPublisherAdview;
    @BindView(2131363313)
    TextView newPass_Visibi;
    @BindView(2131363314)
    EditText newPassword;
    @BindView(2131364414)
    TextView tv_forgot_pwd_login_pwd_show_hide;
    @BindView(2131364809)
    EditText verify_OTP;

    static {
        C1354qp.R(ForgotTxnPasswordFragment.class);
    }

    public final void f(EditText editText, TextView textView) {
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
                drawable.setColorFilter(new PorterDuffColorFilter(getActivity().getResources().getColor(R.color.black_90_opa), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_forgot_txn_password, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        C0535I5.a(this.newPassword, 15);
        C0535I5.a(this.confirmPassword, 15);
        HomeActivity.G(getString(R.string.send_otp));
        this.f4644a = getContext();
        this.et_forgot_pwd_email.setInputType(32);
        this.et_forgot_pwd_email.setTypeface(Typeface.MONOSPACE, 0);
        this.et_forgot_pwd_login_pwd.setInputType(129);
        this.verify_OTP.setInputType(2);
        this.verify_OTP.setTypeface(Typeface.MONOSPACE, 0);
        this.newPassword.setInputType(129);
        this.confirmPassword.setInputType(129);
        C0535I5.H(getActivity(), getView());
        this.ll_send_otp.setVisibility(0);
        this.ll_forgot_pass.setVisibility(8);
        HomeActivity.f4190d.setOnClickListener(new a());
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.mPublisherAdview, googleAdParamDTO);
        return inflate;
    }

    @OnClick({2131364414})
    public void pwdShowHide() {
        f(this.et_forgot_pwd_login_pwd, this.tv_forgot_pwd_login_pwd_show_hide);
    }

    @OnClick({2131363313})
    public void pwdShowHide1() {
        f(this.newPassword, this.newPass_Visibi);
    }

    @OnClick({2131362280})
    public void pwdShowHide2() {
        f(this.confirmPassword, this.conPassVisibi);
    }

    public class a implements View.OnClickListener {

        public class b extends Subscriber<StatusDTO> {
            public b() {
            }

            public final void onCompleted() {
                ForgotTxnPasswordFragment.this.f4643a.dismiss();
                int i = ForgotTxnPasswordFragment.c;
            }

            public final void onError(Throwable th) {
                int i = ForgotTxnPasswordFragment.c;
                xx.S(th, true, th);
            }

            public final void onNext(Object obj) {
                StatusDTO statusDTO = (StatusDTO) obj;
                a aVar = a.this;
                if (statusDTO != null) {
                    C0657Qt.h();
                    try {
                        if (statusDTO.getError() != null && statusDTO.getError().length() > 0) {
                            ForgotTxnPasswordFragment forgotTxnPasswordFragment = ForgotTxnPasswordFragment.this;
                            ForgotTxnPasswordFragment forgotTxnPasswordFragment2 = ForgotTxnPasswordFragment.this;
                            C0535I5.m(forgotTxnPasswordFragment.getActivity(), false, statusDTO.getError(), forgotTxnPasswordFragment2.getString(R.string.error), forgotTxnPasswordFragment2.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        } else if (statusDTO.getError() != null || statusDTO.getTimeStamp() == null || statusDTO.getTimeStamp().toString().length() <= 0) {
                            ForgotTxnPasswordFragment forgotTxnPasswordFragment3 = ForgotTxnPasswordFragment.this;
                            C0535I5.t0(forgotTxnPasswordFragment3.f4644a, forgotTxnPasswordFragment3.getString(R.string.error));
                            int i = ForgotTxnPasswordFragment.c;
                        } else {
                            ForgotTxnPasswordFragment forgotTxnPasswordFragment4 = ForgotTxnPasswordFragment.this;
                            ForgotTxnPasswordFragment forgotTxnPasswordFragment5 = ForgotTxnPasswordFragment.this;
                            C0535I5.I(forgotTxnPasswordFragment4.getActivity());
                            forgotTxnPasswordFragment5.ll_send_otp.setVisibility(8);
                            forgotTxnPasswordFragment5.ll_forgot_pass.setVisibility(0);
                            HomeActivity.G(forgotTxnPasswordFragment5.getString(R.string.submit));
                            forgotTxnPasswordFragment5.verify_OTP.requestFocus();
                        }
                        ForgotTxnPasswordFragment.this.f4643a.dismiss();
                    } catch (Exception e) {
                        ForgotTxnPasswordFragment.this.f4643a.dismiss();
                        int i2 = ForgotTxnPasswordFragment.c;
                        e.getMessage();
                    }
                    int i3 = ForgotTxnPasswordFragment.c;
                    statusDTO.toString();
                    return;
                }
                ForgotTxnPasswordFragment forgotTxnPasswordFragment6 = ForgotTxnPasswordFragment.this;
                C0535I5.t0(forgotTxnPasswordFragment6.f4644a, forgotTxnPasswordFragment6.getString(R.string.error));
                int i4 = ForgotTxnPasswordFragment.c;
            }
        }

        public class d extends Subscriber<StatusDTO> {
            public d() {
            }

            public final void onCompleted() {
                ForgotTxnPasswordFragment.this.f4643a.dismiss();
                int i = ForgotTxnPasswordFragment.c;
            }

            public final void onError(Throwable th) {
                int i = ForgotTxnPasswordFragment.c;
                xx.S(th, true, th);
            }

            public final void onNext(Object obj) {
                String str;
                StatusDTO statusDTO = (StatusDTO) obj;
                a aVar = a.this;
                if (statusDTO != null) {
                    C0657Qt.h();
                    try {
                        if (statusDTO.getError() != null && statusDTO.getError().length() > 0) {
                            ForgotTxnPasswordFragment forgotTxnPasswordFragment = ForgotTxnPasswordFragment.this;
                            ForgotTxnPasswordFragment forgotTxnPasswordFragment2 = ForgotTxnPasswordFragment.this;
                            C0535I5.m(forgotTxnPasswordFragment.getActivity(), false, statusDTO.getError(), forgotTxnPasswordFragment2.getString(R.string.error), forgotTxnPasswordFragment2.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        } else if (statusDTO.getError() != null || statusDTO.getTimeStamp() == null || statusDTO.getTimeStamp().toString().length() <= 0) {
                            ForgotTxnPasswordFragment forgotTxnPasswordFragment3 = ForgotTxnPasswordFragment.this;
                            C0535I5.t0(forgotTxnPasswordFragment3.f4644a, forgotTxnPasswordFragment3.getString(R.string.error));
                            int i = ForgotTxnPasswordFragment.c;
                        } else {
                            if (statusDTO.getStatus() == null || statusDTO.getStatus().length() <= 0) {
                                str = "Transaction Password has been successfully changed";
                            } else {
                                str = statusDTO.getStatus();
                            }
                            String str2 = str;
                            ForgotTxnPasswordFragment forgotTxnPasswordFragment4 = ForgotTxnPasswordFragment.this;
                            ForgotTxnPasswordFragment forgotTxnPasswordFragment5 = ForgotTxnPasswordFragment.this;
                            C0535I5.p(forgotTxnPasswordFragment4.getActivity(), false, str2, forgotTxnPasswordFragment5.getString(R.string.forgot_txn_password), forgotTxnPasswordFragment5.getString(R.string.OK), new P(this), (String) null, (DialogInterface.OnClickListener) null).show();
                        }
                        ForgotTxnPasswordFragment.this.f4643a.dismiss();
                    } catch (Exception e) {
                        ForgotTxnPasswordFragment.this.f4643a.dismiss();
                        int i2 = ForgotTxnPasswordFragment.c;
                        e.getMessage();
                    }
                    int i3 = ForgotTxnPasswordFragment.c;
                    statusDTO.toString();
                    return;
                }
                ForgotTxnPasswordFragment forgotTxnPasswordFragment6 = ForgotTxnPasswordFragment.this;
                C0535I5.t0(forgotTxnPasswordFragment6.f4644a, forgotTxnPasswordFragment6.getString(R.string.error));
                int i4 = ForgotTxnPasswordFragment.c;
            }
        }

        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0279  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0289  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0293  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x02aa  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r22) {
            /*
                r21 = this;
                r0 = r21
                android.widget.TextView r1 = cris.org.in.ima.activities.HomeActivity.f4190d
                java.lang.CharSequence r1 = r1.getText()
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "Send OTP"
                boolean r1 = r1.equalsIgnoreCase(r2)
                b1 r2 = defpackage.C0793b1.a
                r3 = 5000(0x1388, double:2.4703E-320)
                java.lang.String r5 = "connectivity"
                r6 = 2131953494(0x7f130756, float:1.954346E38)
                r7 = 2131953334(0x7f1306b6, float:1.9543136E38)
                r8 = 2131952688(0x7f130430, float:1.9541826E38)
                java.lang.String r9 = "ok"
                cris.org.in.ima.fragment.ForgotTxnPasswordFragment r10 = cris.org.in.ima.fragment.ForgotTxnPasswordFragment.this
                if (r1 == 0) goto L_0x017c
                android.widget.EditText r1 = r10.et_forgot_pwd_email
                android.text.Editable r1 = r1.getText()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x0063
                android.widget.EditText r1 = r10.et_forgot_pwd_login_pwd
                android.text.Editable r1 = r1.getText()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x0063
                r1 = 2131953459(0x7f130733, float:1.954339E38)
                java.lang.String r13 = r10.getString(r1)
                android.widget.EditText r1 = r10.et_forgot_pwd_email
                r1.requestFocus()
                android.content.Context r11 = r10.getContext()
                r12 = 0
                java.lang.String r14 = r10.getString(r8)
                java.lang.String r15 = r10.getString(r7)
                r16 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r11, r12, r13, r14, r15, r16)
                r1.show()
                goto L_0x017c
            L_0x0063:
                android.widget.EditText r1 = r10.et_forgot_pwd_email
                android.text.Editable r1 = r1.getText()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                r11 = 2131952631(0x7f1303f7, float:1.954171E38)
                if (r1 == 0) goto L_0x0082
                java.lang.String r1 = r10.getString(r11)
                android.widget.EditText r11 = r10.et_forgot_pwd_email
                r11.setError(r1)
                android.widget.EditText r1 = r10.et_forgot_pwd_email
                r1.requestFocus()
                goto L_0x017c
            L_0x0082:
                android.widget.EditText r1 = r10.et_forgot_pwd_login_pwd
                android.text.Editable r1 = r1.getText()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x00a1
                r1 = 2131952632(0x7f1303f8, float:1.9541712E38)
                java.lang.String r1 = r10.getString(r1)
                android.widget.EditText r11 = r10.et_forgot_pwd_login_pwd
                r11.setError(r1)
                android.widget.EditText r1 = r10.et_forgot_pwd_login_pwd
                r1.requestFocus()
                goto L_0x017c
            L_0x00a1:
                android.widget.EditText r1 = r10.et_forgot_pwd_email
                android.text.Editable r1 = r1.getText()
                java.lang.String r1 = r1.toString()
                if (r1 == 0) goto L_0x00c7
                java.lang.String r12 = ""
                boolean r12 = r1.equalsIgnoreCase(r12)
                if (r12 != 0) goto L_0x00c7
                java.lang.String r11 = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
                boolean r1 = r1.matches(r11)
                if (r1 == 0) goto L_0x00bf
                r13 = r9
                goto L_0x00cc
            L_0x00bf:
                r1 = 2131952677(0x7f130425, float:1.9541804E38)
                java.lang.String r1 = r10.getString(r1)
                goto L_0x00cb
            L_0x00c7:
                java.lang.String r1 = r10.getString(r11)
            L_0x00cb:
                r13 = r1
            L_0x00cc:
                boolean r1 = r13.equals(r9)
                if (r1 != 0) goto L_0x00e9
                android.content.Context r11 = r10.getContext()
                r12 = 0
                java.lang.String r14 = r10.getString(r8)
                java.lang.String r15 = r10.getString(r7)
                r16 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r11, r12, r13, r14, r15, r16)
                r1.show()
                return
            L_0x00e9:
                android.content.Context r1 = r10.getContext()
                r11 = 2131953709(0x7f13082d, float:1.9543897E38)
                java.lang.String r11 = r10.getString(r11)
                java.lang.String r12 = r10.getString(r6)
                android.app.ProgressDialog r1 = android.app.ProgressDialog.show(r1, r11, r12)
                r10.f4643a = r1
                kn r1 = r2.f3912a
                if (r1 == 0) goto L_0x0177
                androidx.fragment.app.FragmentActivity r1 = r10.getActivity()
                java.lang.Object r1 = r1.getSystemService(r5)
                android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
                android.content.Context r11 = r10.getContext()
                boolean r1 = defpackage.C0535I5.O(r1, r11)
                if (r1 != 0) goto L_0x0124
                android.os.Handler r1 = new android.os.Handler
                r1.<init>()
                cris.org.in.ima.fragment.ForgotTxnPasswordFragment$a$a r2 = new cris.org.in.ima.fragment.ForgotTxnPasswordFragment$a$a
                r2.<init>()
                r1.postDelayed(r2, r3)
                return
            L_0x0124:
                kn r1 = r2.f3912a
                java.lang.Object r1 = defpackage.C0657Qt.c(r1)
                Om r1 = (defpackage.Om) r1
                jd r11 = new jd
                r11.<init>()
                r10.f4645a = r11
                android.widget.EditText r12 = r10.et_forgot_pwd_email
                android.text.Editable r12 = r12.getText()
                java.lang.String r12 = r12.toString()
                r11.setEmailId(r12)
                jd r11 = r10.f4645a
                android.widget.EditText r12 = r10.et_forgot_pwd_login_pwd
                android.text.Editable r12 = r12.getText()
                java.lang.String r12 = r12.toString()
                r11.setLoginPassword(r12)
                java.lang.String r11 = defpackage.C0657Qt.g()
                java.lang.String r12 = "forgetTxnPasswordOtp"
                java.lang.String r11 = defpackage.C1058d.z(r11, r12)
                jd r12 = r10.f4645a
                rx.Observable r1 = r1.b1(r11, r12)
                Lm r11 = defpackage.C1181iv.a()
                rx.Observable r1 = r1.c(r11)
                Yi r11 = defpackage.E0.a()
                rx.Observable r1 = r1.a(r11)
                cris.org.in.ima.fragment.ForgotTxnPasswordFragment$a$b r11 = new cris.org.in.ima.fragment.ForgotTxnPasswordFragment$a$b
                r11.<init>()
                r1.b(r11)
            L_0x0177:
                android.app.ProgressDialog r1 = r10.f4643a
                r1.dismiss()
            L_0x017c:
                android.widget.TextView r1 = cris.org.in.ima.activities.HomeActivity.f4190d
                java.lang.CharSequence r1 = r1.getText()
                java.lang.String r1 = r1.toString()
                r11 = 2131953765(0x7f130865, float:1.954401E38)
                java.lang.String r11 = r10.getString(r11)
                boolean r1 = r1.equalsIgnoreCase(r11)
                if (r1 == 0) goto L_0x0371
                android.widget.EditText r1 = r10.verify_OTP
                android.text.Editable r1 = r1.getText()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x01db
                android.widget.EditText r1 = r10.newPassword
                android.text.Editable r1 = r1.getText()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x01db
                android.widget.EditText r1 = r10.confirmPassword
                android.text.Editable r1 = r1.getText()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x01db
                r1 = 2131953467(0x7f13073b, float:1.9543406E38)
                java.lang.String r13 = r10.getString(r1)
                android.widget.EditText r1 = r10.verify_OTP
                r1.requestFocus()
                android.content.Context r11 = r10.getContext()
                r12 = 0
                java.lang.String r14 = r10.getString(r8)
                java.lang.String r15 = r10.getString(r7)
                r16 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r11, r12, r13, r14, r15, r16)
                r1.show()
                goto L_0x0371
            L_0x01db:
                android.widget.EditText r1 = r10.verify_OTP
                android.text.Editable r1 = r1.getText()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x01f5
                java.lang.String r1 = "Please enter OTP"
                android.widget.EditText r2 = r10.verify_OTP
                r2.setError(r1)
                android.widget.EditText r1 = r10.verify_OTP
                r1.requestFocus()
                goto L_0x0371
            L_0x01f5:
                android.widget.EditText r1 = r10.newPassword
                android.text.Editable r1 = r1.getText()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x0214
                r1 = 2131951995(0x7f13017b, float:1.954042E38)
                java.lang.String r1 = r10.getString(r1)
                android.widget.EditText r2 = r10.newPassword
                r2.setError(r1)
                android.widget.EditText r1 = r10.newPassword
                r1.requestFocus()
                goto L_0x0371
            L_0x0214:
                android.widget.EditText r1 = r10.confirmPassword
                android.text.Editable r1 = r1.getText()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                r11 = 2131951991(0x7f130177, float:1.9540412E38)
                if (r1 == 0) goto L_0x0233
                java.lang.String r1 = r10.getString(r11)
                android.widget.EditText r2 = r10.confirmPassword
                r2.setError(r1)
                android.widget.EditText r1 = r10.confirmPassword
                r1.requestFocus()
                goto L_0x0371
            L_0x0233:
                android.widget.EditText r1 = r10.newPassword
                android.text.Editable r1 = r1.getText()
                java.lang.String r1 = r1.toString()
                int r12 = r1.length()
                if (r12 == 0) goto L_0x0255
                java.lang.String r12 = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,15}$"
                boolean r1 = r1.matches(r12)
                if (r1 == 0) goto L_0x024d
                r14 = r9
                goto L_0x025d
            L_0x024d:
                r1 = 2131952447(0x7f13033f, float:1.9541337E38)
                java.lang.String r1 = r10.getString(r1)
                goto L_0x025c
            L_0x0255:
                r1 = 2131952666(0x7f13041a, float:1.9541781E38)
                java.lang.String r1 = r10.getString(r1)
            L_0x025c:
                r14 = r1
            L_0x025d:
                android.widget.EditText r1 = r10.newPassword
                android.text.Editable r1 = r1.getText()
                java.lang.String r1 = r1.toString()
                android.widget.EditText r12 = r10.confirmPassword
                android.text.Editable r12 = r12.getText()
                java.lang.String r12 = r12.toString()
                if (r12 == 0) goto L_0x0289
                int r13 = r12.length()
                if (r13 <= 0) goto L_0x0289
                boolean r1 = r1.equals(r12)
                if (r1 == 0) goto L_0x0281
                r1 = r9
                goto L_0x028d
            L_0x0281:
                r1 = 2131953268(0x7f130674, float:1.9543002E38)
                java.lang.String r1 = r10.getString(r1)
                goto L_0x028d
            L_0x0289:
                java.lang.String r1 = r10.getString(r11)
            L_0x028d:
                boolean r11 = r14.equals(r9)
                if (r11 != 0) goto L_0x02aa
                android.content.Context r12 = r10.getContext()
                r13 = 0
                java.lang.String r15 = r10.getString(r8)
                java.lang.String r16 = r10.getString(r7)
                r17 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r12, r13, r14, r15, r16, r17)
                r1.show()
                return
            L_0x02aa:
                boolean r9 = r1.equals(r9)
                if (r9 != 0) goto L_0x02ca
                android.content.Context r15 = r10.getContext()
                r16 = 0
                java.lang.String r18 = r10.getString(r8)
                java.lang.String r19 = r10.getString(r7)
                r20 = 0
                r17 = r1
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r15, r16, r17, r18, r19, r20)
                r1.show()
                return
            L_0x02ca:
                android.content.Context r1 = r10.getContext()
                java.lang.String r7 = "Setting New Password"
                java.lang.String r6 = r10.getString(r6)
                android.app.ProgressDialog r1 = android.app.ProgressDialog.show(r1, r7, r6)
                r10.f4643a = r1
                kn r1 = r2.f3912a
                if (r1 == 0) goto L_0x036c
                androidx.fragment.app.FragmentActivity r1 = r10.getActivity()
                java.lang.Object r1 = r1.getSystemService(r5)
                android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
                android.content.Context r5 = r10.getContext()
                boolean r1 = defpackage.C0535I5.O(r1, r5)
                if (r1 != 0) goto L_0x0300
                android.os.Handler r1 = new android.os.Handler
                r1.<init>()
                cris.org.in.ima.fragment.ForgotTxnPasswordFragment$a$c r2 = new cris.org.in.ima.fragment.ForgotTxnPasswordFragment$a$c
                r2.<init>()
                r1.postDelayed(r2, r3)
                return
            L_0x0300:
                kn r1 = r2.f3912a
                java.lang.Object r1 = defpackage.C0657Qt.c(r1)
                Om r1 = (defpackage.Om) r1
                Xo r2 = new Xo
                r2.<init>()
                r10.a = r2
                r3 = 4
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r2.setSource(r3)
                Xo r2 = r10.a
                android.widget.EditText r3 = r10.verify_OTP
                android.text.Editable r3 = r3.getText()
                java.lang.String r3 = r3.toString()
                r2.setSeqQuestion(r3)
                Xo r2 = r10.a
                android.widget.EditText r3 = r10.newPassword
                android.text.Editable r3 = r3.getText()
                java.lang.String r3 = r3.toString()
                r2.setNewPassword(r3)
                Xo r2 = r10.a
                android.widget.EditText r3 = r10.confirmPassword
                android.text.Editable r3 = r3.getText()
                java.lang.String r3 = r3.toString()
                r2.setConfPassword(r3)
                java.lang.String r2 = defpackage.C0657Qt.g()
                java.lang.String r3 = "forgetTxnPassword"
                java.lang.String r2 = defpackage.C1058d.z(r2, r3)
                Xo r3 = r10.a
                rx.Observable r1 = r1.k1(r2, r3)
                Lm r2 = defpackage.C1181iv.a()
                rx.Observable r1 = r1.c(r2)
                Yi r2 = defpackage.E0.a()
                rx.Observable r1 = r1.a(r2)
                cris.org.in.ima.fragment.ForgotTxnPasswordFragment$a$d r2 = new cris.org.in.ima.fragment.ForgotTxnPasswordFragment$a$d
                r2.<init>()
                r1.b(r2)
            L_0x036c:
                android.app.ProgressDialog r1 = r10.f4643a
                r1.dismiss()
            L_0x0371:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.ForgotTxnPasswordFragment.a.onClick(android.view.View):void");
        }

        /* renamed from: cris.org.in.ima.fragment.ForgotTxnPasswordFragment$a$a  reason: collision with other inner class name */
        public class C0064a implements Runnable {
            public final void run() {
            }
        }

        public class c implements Runnable {
            public final void run() {
            }
        }
    }
}
