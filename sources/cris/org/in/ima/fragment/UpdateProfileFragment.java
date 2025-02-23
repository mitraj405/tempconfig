package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.activities.LoginActivity;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import defpackage.d7;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import rx.Subscriber;

public class UpdateProfileFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public C0479D5 a = null;

    /* renamed from: a  reason: collision with other field name */
    public C0561KB f5181a;

    /* renamed from: a  reason: collision with other field name */
    public C0574LB f5182a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f5183a = null;

    /* renamed from: a  reason: collision with other field name */
    public View f5184a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f5185a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f5186a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f5187a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, Boolean> f5188a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5189a;
    @BindView(2131364282)
    EditText address;
    @BindView(2131362515)
    EditText address2;
    public final ArrayList<String> b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public boolean f5190b;

    /* renamed from: c  reason: collision with other field name */
    public String f5191c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f5192c = false;
    @BindView(2131362197)
    TextView city;
    public String d = "-1";

    /* renamed from: d  reason: collision with other field name */
    public boolean f5193d = false;
    @BindView(2131362526)
    TextView dob;
    public String e = "";

    /* renamed from: e  reason: collision with other field name */
    public boolean f5194e = false;
    @BindView(2131364390)
    TextView editEmailMsg;
    @BindView(2131364391)
    TextView editMobileMsg;
    @BindView(2131362083)
    EditText email;
    public String f = "";
    @BindView(2131364405)
    RadioButton female;
    @BindView(2131362535)
    EditText fullName;
    public final String g = "^[0]+$";
    @BindView(2131363031)
    RadioGroup gender_radiobtn;
    @BindView(2131364427)
    TextView gender_tv;
    @BindView(2131362728)
    TextView generateOtp;
    public String h;
    public String i;
    @BindView(2131364444)
    TextView isd;
    public String j;
    public String k;
    public String l;
    public String m;
    @BindView(2131364475)
    RadioButton male;
    @BindView(2131362084)
    EditText mobile;
    public String n;
    public final String o = "^[0-9a-zA-Z]{1}[0-9a-zA-Z\\s,\\-_:()\\/]{2,29}$";
    @BindView(2131362847)
    TextView otpInputLabel;
    @BindView(2131363398)
    RelativeLayout otpLayout;
    @BindView(2131363435)
    FrameLayout parentLayout;
    @BindView(2131362571)
    EditText pincode;
    @BindView(2131363526)
    TextView postoffice;
    @BindView(2131363544)
    CheckBox promotionalChkbox;
    @BindView(2131364566)
    TextView resendMobTimmer;
    @BindView(2131362583)
    TextView state;
    @BindView(2131364064)
    CheckBox tandcChkbox;
    @BindView(2131364065)
    TextView tandcTv;
    @BindView(2131364695)
    RadioButton transGender;
    @BindView(2131362087)
    TextView updateEmail;
    @BindView(2131362088)
    TextView updateMobile;
    @BindView(2131364792)
    TextView updateProfileBtn;
    @BindView(2131362538)
    EditText userInput;
    @BindView(2131364716)
    EditText userName;

    public class a extends Subscriber<C0561KB> {
        public final /* synthetic */ ProgressDialog a;

        public a(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            int i = UpdateProfileFragment.c;
            this.a.dismiss();
        }

        public final void onError(Throwable th) {
            this.a.dismiss();
            int i = UpdateProfileFragment.c;
            xx.S(th, true, th);
        }

        public final void onNext(Object obj) {
            String next;
            String str;
            String str2;
            C0561KB kb = (C0561KB) obj;
            ProgressDialog progressDialog = this.a;
            progressDialog.dismiss();
            UpdateProfileFragment updateProfileFragment = UpdateProfileFragment.this;
            if (kb == null) {
                C0535I5.m(updateProfileFragment.getActivity(), false, updateProfileFragment.getString(R.string.unable_process_message), updateProfileFragment.getString(R.string.error), updateProfileFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                progressDialog.dismiss();
            } else if (kb.getErrorList() != null) {
                Iterator<String> it = kb.getErrorList().iterator();
                String str3 = "";
                while (it.hasNext() && (next = it.next()) != null && !next.trim().equals("")) {
                    StringBuilder sb = new StringBuilder();
                    if (str3.length() <= 1 || str3.charAt(0) == '*') {
                        str = "";
                    } else {
                        str = "* ";
                    }
                    sb.append(str);
                    sb.append(str3);
                    if (str3.length() > 1) {
                        str2 = "\n* ";
                    } else {
                        str2 = "";
                    }
                    str3 = C0709Uj.j(sb, str2, next);
                }
                progressDialog.dismiss();
                FragmentActivity fragmentActivity = updateProfileFragment.f5185a;
                C0535I5.m(fragmentActivity, false, str3, fragmentActivity.getResources().getString(R.string.error), updateProfileFragment.f5185a.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (kb.getError() == null) {
                int i = UpdateProfileFragment.c;
                kb.getStatus();
                if (updateProfileFragment.f5181a.getUserProfiles().getKyc_status() == 0 || updateProfileFragment.f5181a.getUserProfiles().getKyc_status() == 2) {
                    C0535I5.p(updateProfileFragment.f5185a, false, updateProfileFragment.getString(R.string.congrats_verify_aadhaar), updateProfileFragment.getString(R.string.Congratulation), updateProfileFragment.getString(R.string.Continue), new K0(this), updateProfileFragment.getString(R.string.will_do_it_later), new L0(this)).show();
                    return;
                }
                C0535I5.p(updateProfileFragment.getActivity(), false, kb.getStatus().replace("[", " ").replace("]", ""), updateProfileFragment.getString(R.string.Congratulation), updateProfileFragment.getString(R.string.ok), new M0(this), (String) null, (DialogInterface.OnClickListener) null).show();
            } else {
                C0535I5.m(updateProfileFragment.f5185a, false, kb.getStatus(), updateProfileFragment.f5185a.getResources().getString(R.string.error), updateProfileFragment.f5185a.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                progressDialog.dismiss();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public final void onClick(View view) {
            UpdateProfileFragment updateProfileFragment = UpdateProfileFragment.this;
            HomeActivity.B(updateProfileFragment.getActivity());
            HomeActivity.n((AppCompatActivity) updateProfileFragment.getActivity(), new MyAccountFragment(), C1218kf.MY_ACCOUNT.a(), Boolean.TRUE, Boolean.FALSE);
        }
    }

    public class d implements DatePickerDialog.OnDateSetListener {
        public d() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Object obj;
            Object obj2;
            int i4 = UpdateProfileFragment.c;
            UpdateProfileFragment updateProfileFragment = UpdateProfileFragment.this;
            TextView textView = updateProfileFragment.dob;
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
            textView.setText(sb);
            updateProfileFragment.dob.getText().toString();
        }
    }

    public class e extends Subscriber<C0812c0> {
        public e() {
        }

        public final void onCompleted() {
            int i = UpdateProfileFragment.c;
            UpdateProfileFragment.this.f5183a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = UpdateProfileFragment.c;
            th.getClass();
            th.getMessage();
            UpdateProfileFragment.this.f5183a.dismiss();
            Lt.a(false, th);
        }

        public final void onNext(Object obj) {
            C0812c0 c0Var = (C0812c0) obj;
            int i = UpdateProfileFragment.c;
            UpdateProfileFragment updateProfileFragment = UpdateProfileFragment.this;
            if (c0Var != null) {
                c0Var.getPostofficeList().toString();
                updateProfileFragment.b.clear();
                for (int i2 = 0; i2 < c0Var.getPostofficeList().size(); i2++) {
                    updateProfileFragment.b.add(c0Var.getPostofficeList().get(i2));
                    updateProfileFragment.state.setText(c0Var.getState());
                }
                if (updateProfileFragment.f5192c) {
                    updateProfileFragment.g();
                }
            }
            updateProfileFragment.f5183a.dismiss();
        }
    }

    public class f implements OnSelectionListener {
        public f() {
        }

        public final void onClick(String str) {
            UpdateProfileFragment updateProfileFragment = UpdateProfileFragment.this;
            updateProfileFragment.postoffice.setText(str);
            updateProfileFragment.f5186a.dismiss();
            if (!str.equals(updateProfileFragment.getString(R.string.post_office))) {
                updateProfileFragment.postoffice.setError((CharSequence) null);
                updateProfileFragment.getClass();
                updateProfileFragment.city.setError((CharSequence) null);
                return;
            }
            updateProfileFragment.getClass();
            updateProfileFragment.postoffice.setError(updateProfileFragment.getString(R.string.Select_Post_Office));
        }
    }

    public class g implements OnSelectionListener {
        public g() {
        }

        public final void onClick(String str) {
            UpdateProfileFragment updateProfileFragment = UpdateProfileFragment.this;
            updateProfileFragment.city.setText(str);
            updateProfileFragment.f5186a.dismiss();
            if (!str.equals("City")) {
                if (!updateProfileFragment.f.equals(str)) {
                    updateProfileFragment.b.clear();
                    updateProfileFragment.h();
                    updateProfileFragment.f = str;
                }
                updateProfileFragment.getClass();
                updateProfileFragment.city.setError((CharSequence) null);
                return;
            }
            updateProfileFragment.getClass();
            updateProfileFragment.city.setError(updateProfileFragment.getString(R.string.Select_City));
        }
    }

    public class h extends CountDownTimer {
        public h() {
            super(60000, 1000);
        }

        public final void onFinish() {
            UpdateProfileFragment updateProfileFragment = UpdateProfileFragment.this;
            if (updateProfileFragment.isAdded() && updateProfileFragment.getContext() != null) {
                updateProfileFragment.generateOtp.setEnabled(true);
                TextView textView = updateProfileFragment.generateOtp;
                Context context = updateProfileFragment.getContext();
                Object obj = d7.a;
                textView.setTextColor(d7.b.a(context, R.color.blue));
                updateProfileFragment.resendMobTimmer.setText("");
            }
        }

        public final void onTick(long j) {
            UpdateProfileFragment updateProfileFragment = UpdateProfileFragment.this;
            if (updateProfileFragment.isAdded() && updateProfileFragment.getContext() != null) {
                updateProfileFragment.generateOtp.setEnabled(false);
                TextView textView = updateProfileFragment.generateOtp;
                Context context = updateProfileFragment.getContext();
                Object obj = d7.a;
                textView.setTextColor(d7.b.a(context, R.color.light_grey));
                updateProfileFragment.resendMobTimmer.setVisibility(0);
                TextView textView2 = updateProfileFragment.resendMobTimmer;
                textView2.setText(updateProfileFragment.getString(R.string.you_allowed_resend_otp_After) + " " + (j / 1000) + " Sec.");
            }
        }
    }

    static {
        C1354qp.R(UpdateProfileFragment.class);
    }

    @OnFocusChange({2131362083})
    public void checkEmail(View view) {
        if (!this.f5193d) {
            this.email.setText(this.i);
        }
    }

    @OnFocusChange({2131362084})
    public void checkMobile(View view) {
        if (!this.f5193d) {
            this.mobile.setText(this.j);
        }
    }

    @OnClick({2131362289})
    public void confirmOtp(View view) {
        EditText editText = this.userInput;
        if (editText == null || editText.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), getString(R.string.enter_valid_otp), 0).show();
        } else if (this.k.equals("E")) {
            m("E", this.userInput.getText().toString(), this.email.getText().toString(), this.mobile.getText().toString(), this.f5183a);
            this.userInput.setText("");
        } else {
            m("M", this.userInput.getText().toString(), this.email.getText().toString(), this.mobile.getText().toString(), this.f5183a);
            this.userInput.setText("");
        }
    }

    @OnFocusChange({2131364282})
    public void et_address(View view) {
        if (!this.address.hasFocus()) {
            String l2 = l();
            if (l2.equalsIgnoreCase("ok")) {
                i(1);
            } else {
                k(1, l2);
            }
        }
    }

    @OnFocusChange({2131362515})
    public void et_area(View view) {
        if (!this.address2.hasFocus()) {
            String l2 = l();
            if (l2.equalsIgnoreCase("ok")) {
                i(3);
            } else {
                k(3, l2);
            }
        }
    }

    @OnFocusChange({2131362571})
    public void et_pincode(View view) {
        String str;
        if (!this.pincode.hasFocus()) {
            String B = xx.B(this.pincode);
            if (B == null || B.equals("")) {
                str = "Pin code can not be blank";
            } else if (B.matches(this.g)) {
                str = "All zeros not allowed.";
            } else if (B.length() != 6) {
                str = getString(R.string.PincodeError);
            } else {
                str = "ok";
            }
            if (str.equalsIgnoreCase("ok")) {
                this.pincode.getText().toString();
                String B2 = xx.B(this.pincode);
                if (!B2.equals(this.e) && B2.length() == 6 && this.d.equals("94")) {
                    this.f5183a = ProgressDialog.show(this.f5185a, getString(R.string.validating_Pin_code), getString(R.string.please_wait_text));
                    this.state.setText((CharSequence) null);
                    this.postoffice.setText((CharSequence) null);
                    this.city.setText("City");
                    String f2 = C0657Qt.f();
                    String format = String.format("/%s", new Object[]{B2});
                    ((Om) C0657Qt.c(C0793b1.a.f3912a)).j(f2 + "pin" + format, (String) null).c(C1181iv.a()).a(E0.a()).b(new N0(this, B2));
                }
                i(7);
                return;
            }
            k(7, str);
        }
    }

    public final void f(String str, String str2, String str3, String str4, boolean z) {
        if (!C0535I5.O((ConnectivityManager) this.f5185a.getSystemService("connectivity"), this.f5185a)) {
            new Handler().postDelayed(new C1384sB(), 5000);
            return;
        }
        this.f5191c = "";
        ProgressDialog show = ProgressDialog.show(this.f5185a, str4, "Checking Availability...");
        this.f5183a = show;
        show.show();
        ((Om) C0657Qt.b()).e1(C1058d.z(C0657Qt.f(), "checkUserAvail"), (String) null, str3, str2).c(C1181iv.a()).a(E0.a()).b(new J0(this, str2, str3));
    }

    public final void g() {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f5186a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f5186a.show(getFragmentManager(), "");
        this.f5186a.setCancelable(true);
        getFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(this.f5185a, this.b, new f());
        this.f5186a.g().setText(getString(R.string.Select_Post_Office));
        this.f5186a.f().setAdapter(customAdapter);
    }

    @OnClick({2131362728})
    public void generateOtp(View view) {
        new h().start();
        if (this.k.equals("E")) {
            String obj = this.email.getText().toString();
            TextView textView = this.updateEmail;
            getResources().getString(R.string.email_otp_msg);
            this.email.getText().toString();
            j("E", (String) null, obj, (String) null, (String) null, textView);
            return;
        }
        String obj2 = this.mobile.getText().toString();
        TextView textView2 = this.updateMobile;
        getResources().getString(R.string.mobile_otp_msg);
        this.mobile.getText().toString();
        j("M", obj2, (String) null, "94", "91", textView2);
    }

    public final void h() {
        this.f5183a = ProgressDialog.show(this.f5185a, getString(R.string.loading), getString(R.string.please_wait_text));
        String B = xx.B(this.pincode);
        String trim = this.city.getText().toString().trim();
        String f2 = C0657Qt.f();
        String format = String.format("/%s", new Object[]{B});
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).j(f2 + "pin" + format, trim).c(C1181iv.a()).a(E0.a()).b(new e());
    }

    public final void i(int i2) {
        if (i2 == 1) {
            this.address.setError((CharSequence) null);
            this.address.setTextColor(-16777216);
        } else if (i2 == 7) {
            this.pincode.setError((CharSequence) null);
            this.pincode.setTextColor(-16777216);
        } else if (i2 == 8) {
            this.mobile.setError((CharSequence) null);
            this.mobile.setTextColor(-16777216);
        } else if (i2 == 9) {
            this.email.setError((CharSequence) null);
            this.email.setTextColor(-16777216);
        }
    }

    public final void j(String str, String str2, String str3, String str4, String str5, TextView textView) {
        this.k = str;
        C1229kx kxVar = new C1229kx();
        kxVar.setNewMobile(str2);
        kxVar.setNewEmail(str3);
        if (str4 != null) {
            kxVar.setCountrycode(Integer.parseInt(str4));
        }
        kxVar.setIsd(str5);
        kxVar.setOtpType(str);
        if (!C0535I5.O((ConnectivityManager) this.f5185a.getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new C1401tB(), 5000);
            return;
        }
        C0535I5.I(getActivity());
        ProgressDialog progressDialog = new ProgressDialog(this.f5185a);
        progressDialog.setMessage(getString(R.string.please_wait_text));
        progressDialog.setTitle(getString(R.string.sending_otp));
        progressDialog.setProgressStyle(0);
        progressDialog.show();
        String f2 = C0657Qt.f();
        String format = String.format("/%s", new Object[]{str});
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).c(f2 + "getSMSeMailOTPPost" + format, kxVar).c(C1181iv.a()).a(E0.a()).b(new G0(this, progressDialog, textView, str, str3, str2));
    }

    public final void k(int i2, String str) {
        if (i2 == 1) {
            this.address.setError(str);
            this.address.setTextColor(-65536);
        } else if (i2 == 7) {
            this.pincode.setError(str);
            this.pincode.setTextColor(-65536);
        } else if (i2 == 8) {
            this.mobile.setError(str);
            this.mobile.setTextColor(-65536);
        } else if (i2 == 9) {
            this.email.setError(str);
            this.email.setTextColor(-65536);
        }
    }

    public final String l() {
        String B = xx.B(this.address);
        if (B == null || B.equals("")) {
            return getString(R.string.address_cannot_blank);
        }
        if (B.equalsIgnoreCase("")) {
            return B;
        }
        if (B.matches(this.o)) {
            return "ok";
        }
        return getString(R.string.Invalid_Street);
    }

    public final void m(String str, String str2, String str3, String str4, ProgressDialog progressDialog) {
        String str5;
        String str6;
        String str7 = null;
        if (str.equals("M")) {
            str6 = str4;
            str5 = null;
        } else {
            str5 = str3;
            str6 = null;
            str7 = str2;
            str2 = null;
        }
        if (!C0535I5.O((ConnectivityManager) this.f5185a.getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new C1365rB(), 5000);
            return;
        }
        C1229kx kxVar = new C1229kx();
        kxVar.setNewEmail(str5);
        kxVar.setNewMobile(str6);
        kxVar.setSmsCode(str2);
        kxVar.setEmailCode(str7);
        kxVar.setOtpType(str);
        ProgressDialog progressDialog2 = new ProgressDialog(this.f5185a);
        progressDialog2.setMessage(getString(R.string.please_wait_text));
        progressDialog2.setTitle(getString(R.string.verifying_otp));
        progressDialog2.setProgressStyle(0);
        progressDialog2.show();
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).g(C0657Qt.f() + "verifySMSeMailOTPPost" + String.format("/%s", new Object[]{str}), kxVar).c(C1181iv.a()).a(E0.a()).b(new I0(this, progressDialog2, progressDialog, str, str6, str5));
    }

    @OnClick({2131362115})
    public void onCancelClick() {
        this.otpLayout.setVisibility(8);
        this.email.setText(this.i);
        this.mobile.setText(this.j);
        this.email.clearFocus();
    }

    @OnClick({2131362197})
    public void onCityClick(View view) {
        ArrayList<String> arrayList = this.f5187a;
        if (arrayList != null && !arrayList.isEmpty()) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f5186a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f5186a.show(getFragmentManager(), "");
            this.f5186a.setCancelable(true);
            getFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(this.f5185a, arrayList, new g());
            this.f5186a.g().setText(getString(R.string.Select_City));
            this.f5186a.f().setAdapter(customAdapter);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        View inflate = layoutInflater.inflate(R.layout.activity_edit_profile, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f5184a = inflate;
        HomeActivity.f.setVisibility(0);
        HomeActivity.p();
        this.f5185a = getActivity();
        this.f5181a = (C0561KB) getArguments().getSerializable("updateProfile");
        this.f5182a = new C0574LB();
        this.i = this.f5181a.getUserProfiles().getEmail();
        this.j = String.valueOf(this.f5181a.getUserProfiles().getMaskedMobileNo());
        C0561KB kb = this.f5181a;
        if (kb != null) {
            if (!kb.getUserProfiles().getUserProfileAddonServices().isNameeditallowed()) {
                this.fullName.setTextColor(this.f5185a.getResources().getColor(R.color.darkGrey));
                this.fullName.setFocusable(false);
                this.fullName.setFocusableInTouchMode(false);
            }
            if (!this.f5181a.getUserProfiles().getUserProfileAddonServices().isEmaileditallowed()) {
                this.email.setTextColor(this.f5185a.getResources().getColor(R.color.darkGrey));
                this.updateEmail.setVisibility(8);
                this.editEmailMsg.setVisibility(0);
                this.editEmailMsg.setText(getString(R.string.email_error_msg, C0535I5.c(this.f5181a.getUserProfiles().getUserProfileAddonServices().getEmail_change_date())));
                this.email.setFocusable(false);
                this.email.setFocusableInTouchMode(false);
            }
            if (!this.f5181a.getUserProfiles().getUserProfileAddonServices().isGendereditallowed()) {
                this.gender_tv.setTextColor(this.f5185a.getResources().getColor(R.color.darkGrey));
                this.gender_tv.setFocusable(false);
                this.gender_tv.setFocusableInTouchMode(false);
            } else {
                this.gender_tv.setFocusable(true);
                this.gender_tv.setFocusableInTouchMode(true);
            }
            if (!this.f5181a.getUserProfiles().getUserProfileAddonServices().isMobileeditallowed()) {
                this.mobile.setTextColor(this.f5185a.getResources().getColor(R.color.darkGrey));
                this.updateMobile.setVisibility(8);
                this.editMobileMsg.setVisibility(0);
                this.editMobileMsg.setText(getString(R.string.mobile_error_msg, C0535I5.c(this.f5181a.getUserProfiles().getUserProfileAddonServices().getMoblieno_change_date())));
                this.mobile.setFocusable(false);
                this.mobile.setFocusableInTouchMode(false);
            }
            this.email.setText(this.i);
            this.mobile.setText(this.j);
            this.userName.setText(this.f5181a.getUserProfiles().getUser_loginid());
            TextView textView = this.isd;
            textView.setText("+" + this.f5181a.getUserProfiles().getIsd_code());
            this.fullName.setText(this.f5181a.getUserProfiles().getName());
            if (this.f5181a.getUserProfiles().getGender() != null && this.f5181a.getUserProfiles().getGender().equals("M")) {
                this.gender_tv.setText(getString(R.string.male));
                this.gender_tv.setFocusable(false);
                this.gender_tv.setFocusableInTouchMode(false);
            } else if (this.f5181a.getUserProfiles().getGender() != null && this.f5181a.getUserProfiles().getGender().equals("F")) {
                this.gender_tv.setText(getString(R.string.female));
                this.gender_tv.setFocusable(false);
                this.gender_tv.setFocusableInTouchMode(false);
            } else if (this.f5181a.getUserProfiles().getGender() != null && this.f5181a.getUserProfiles().getGender().equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
                this.gender_tv.setText(getString(R.string.transgender));
                this.gender_tv.setFocusable(false);
                this.gender_tv.setFocusableInTouchMode(false);
            }
            if (this.f5181a.getUserProfiles().getDate_of_birth() != null) {
                this.dob.setText(C0535I5.c(this.f5181a.getUserProfiles().getDate_of_birth()));
                if (!this.f5181a.getUserProfiles().getUserProfileAddonServices().isDobeditallowed()) {
                    this.dob.setTextColor(this.f5185a.getResources().getColor(R.color.darkGrey));
                    this.dob.setFocusableInTouchMode(false);
                    this.dob.setFocusable(false);
                }
            }
            if (this.f5181a.getUserProfiles().getPostoffice() != null) {
                this.postoffice.setText(this.f5181a.getUserProfiles().getPostoffice().toString().trim());
            } else {
                this.postoffice.setText("");
            }
            if (this.f5181a.getUserProfiles().getAddress1() != null) {
                this.address.setText(this.f5181a.getUserProfiles().getAddress1().toString().trim());
            } else {
                this.address.setText("");
            }
            if (this.f5181a.getUserProfiles().getAddress2() != null) {
                this.address2.setText(this.f5181a.getUserProfiles().getAddress2().toString().trim());
            } else {
                this.address2.setText("");
            }
            if (this.f5181a.getUserProfiles().getCity() != null) {
                this.city.setText(this.f5181a.getUserProfiles().getCity().toString().trim());
            } else {
                this.city.setText("");
            }
            if (this.f5181a.getUserProfiles().getState_name() != null) {
                this.state.setText(this.f5181a.getUserProfiles().getState_name().toString().trim());
            } else {
                this.state.setText("");
            }
            if (this.f5181a.getUserProfiles().getCountry_id() != null) {
                this.d = this.f5181a.getUserProfiles().getCountry_id().toString().trim();
            }
            if (this.f5181a.getUserProfiles().getPin_code() == null || this.f5181a.getUserProfiles().getPin_code().intValue() == 0) {
                this.pincode.setText("");
            } else {
                this.pincode.setText(this.f5181a.getUserProfiles().getPin_code().toString().trim());
            }
            C0479D5 d5 = this.a;
            if (d5 != null) {
                this.pincode.removeTextChangedListener(d5);
            }
            FragmentActivity activity = getActivity();
            AlertDialog alertDialog = C0535I5.f3619a;
            C0479D5 d52 = new C0479D5(activity, 6);
            this.a = d52;
            this.pincode.addTextChangedListener(d52);
            EditText editText = (EditText) this.f5184a.findViewById(R.id.et_pincode_reg);
            editText.setInputType(2);
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
            EditText editText2 = this.pincode;
            editText2.addTextChangedListener(new i(editText2));
            if (!this.d.equals("94")) {
                C0535I5.m(getActivity(), false, getString(R.string.International_Update_msg), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
        this.f5188a = new HashMap<>();
        EditText editText3 = this.email;
        editText3.addTextChangedListener(new i(editText3));
        EditText editText4 = this.mobile;
        editText4.addTextChangedListener(new i(editText4));
        this.f5183a = ProgressDialog.show(this.f5185a, getString(R.string.loading), getString(R.string.please_wait_text));
        if (this.f5181a.getUserProfiles().getGender() == null || (!this.f5181a.getUserProfiles().getGender().equals("M") && !this.f5181a.getUserProfiles().getGender().equals("F") && !this.f5181a.getUserProfiles().getGender().equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T))) {
            this.gender_radiobtn.setVisibility(0);
            this.gender_tv.setVisibility(8);
        } else {
            this.gender_radiobtn.setVisibility(8);
            this.gender_tv.setVisibility(0);
        }
        HomeActivity.f.setOnClickListener(new b());
        String string = getResources().getString(R.string.I_agree_to_tndc);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        Context context = getContext();
        Object obj = d7.a;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(d7.b.a(context, R.color.blue));
        StyleSpan styleSpan = new StyleSpan(1);
        c cVar = new c();
        try {
            if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                i2 = string.indexOf("नियम और शर्तें");
                i3 = i2 + 14;
            } else {
                i2 = string.indexOf("Terms & conditions");
                i3 = i2 + 18;
            }
            spannableStringBuilder.setSpan(styleSpan, i2, i3, 18);
            spannableStringBuilder.setSpan(cVar, i2, i3, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, i2, i3, 18);
        } catch (Exception e2) {
            e2.getMessage();
        }
        this.tandcTv.setText(spannableStringBuilder);
        this.tandcTv.setMovementMethod(LinkMovementMethod.getInstance());
        if (!this.f5181a.getUserProfiles().getUserProfileAddonServices().isAddresseditallowed()) {
            this.address.setTextColor(this.f5185a.getResources().getColor(R.color.darkGrey));
            this.address.setFocusable(false);
            this.address.setFocusableInTouchMode(false);
            this.address2.setTextColor(this.f5185a.getResources().getColor(R.color.darkGrey));
            this.address2.setFocusable(false);
            this.address2.setFocusableInTouchMode(false);
            this.pincode.setTextColor(this.f5185a.getResources().getColor(R.color.darkGrey));
            this.pincode.setFocusable(false);
            this.pincode.setFocusableInTouchMode(false);
            this.city.setTextColor(this.f5185a.getResources().getColor(R.color.darkGrey));
            this.city.setFocusable(false);
            this.city.setFocusableInTouchMode(false);
            this.state.setTextColor(this.f5185a.getResources().getColor(R.color.darkGrey));
            this.state.setFocusable(false);
            this.state.setFocusableInTouchMode(false);
            this.postoffice.setTextColor(this.f5185a.getResources().getColor(R.color.darkGrey));
            this.postoffice.setFocusable(false);
            this.postoffice.setFocusableInTouchMode(false);
        }
        return inflate;
    }

    @OnClick({2131362526})
    public void onDobClick() {
        if (this.f5181a.getUserProfiles().getUserProfileAddonServices().isDobeditallowed()) {
            Calendar instance = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(this.f5185a, new d(), instance.get(1), instance.get(2), instance.get(5));
            Calendar instance2 = Calendar.getInstance();
            Calendar instance3 = Calendar.getInstance();
            instance2.add(1, -18);
            instance3.add(1, -143);
            datePickerDialog.getDatePicker().setMaxDate(instance2.getTime().getTime());
            datePickerDialog.getDatePicker().setMinDate(instance3.getTime().getTime());
            datePickerDialog.setTitle(getString(R.string.Select_Date_of_Birth));
            datePickerDialog.show();
            C0535I5.I(getActivity());
        }
    }

    @OnClick({2131364405})
    public void onFemaleBtnClick(View view) {
        C0535I5.H(getActivity(), view);
        this.male.setSelected(false);
        this.female.setSelected(true);
        this.transGender.setSelected(false);
        this.h = "F";
    }

    @OnClick({2131364427})
    public void onGenderClick() {
        if (this.f5181a.getUserProfiles().getUserProfileAddonServices().isGendereditallowed()) {
            this.gender_radiobtn.setVisibility(0);
            this.gender_tv.setVisibility(8);
        }
    }

    @OnClick({2131364475})
    public void onMaleBtnClick(View view) {
        C0535I5.H(getActivity(), view);
        this.male.setSelected(true);
        this.female.setSelected(false);
        this.transGender.setSelected(false);
        this.h = "M";
    }

    @OnTextChanged({2131362571})
    public void onPinCodeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (this.d.equals("94") && charSequence.length() == 6) {
            this.pincode.clearFocus();
        }
    }

    @OnClick({2131363526})
    public void onPostOfficeClick(View view) {
        if (this.f5181a.getUserProfiles().getUserProfileAddonServices().isAddresseditallowed()) {
            ArrayList<String> arrayList = this.b;
            if (arrayList == null || arrayList.isEmpty()) {
                h();
                this.f5192c = true;
                return;
            }
            g();
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.f5194e) {
            startActivity(new Intent(this.f5185a, LoginActivity.class));
        }
        ProgressDialog progressDialog = this.f5183a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @OnClick({2131364695})
    public void onTransgender(View view) {
        C0535I5.H(getActivity(), view);
        this.male.setSelected(false);
        this.female.setSelected(false);
        this.transGender.setSelected(true);
        this.h = RequestConfiguration.MAX_AD_CONTENT_RATING_T;
    }

    @OnClick({2131364792})
    public void onUpdateProfileClick(View view) {
        String str;
        Date date;
        if (!this.tandcChkbox.isChecked()) {
            C0535I5.m(getActivity(), false, getString(R.string.tandc_chkbox_msg), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        this.f5182a.setUserProfiles(this.f5181a.getUserProfiles());
        String charSequence = this.dob.getText().toString();
        if (charSequence != null && !charSequence.isEmpty()) {
            C0538IB userProfiles = this.f5182a.getUserProfiles();
            AlertDialog alertDialog = C0535I5.f3619a;
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(charSequence);
            } catch (ParseException e2) {
                e2.printStackTrace();
                date = null;
            }
            userProfiles.setDate_of_birth(date);
        }
        EditText editText = this.address;
        if (editText != null) {
            String obj = editText.getText().toString();
            if (!obj.isEmpty()) {
                this.f5182a.getUserProfiles().setAddress1(obj);
            }
        }
        EditText editText2 = this.address2;
        if (editText2 != null) {
            this.f5182a.getUserProfiles().setAddress2(editText2.getText().toString());
        }
        EditText editText3 = this.pincode;
        if (editText3 != null) {
            String obj2 = editText3.getText().toString();
            if (!obj2.isEmpty()) {
                this.f5182a.getUserProfiles().setPin_code(Integer.valueOf(Integer.parseInt(obj2)));
            }
        }
        TextView textView = this.city;
        if (textView != null) {
            String charSequence2 = textView.getText().toString();
            if (!charSequence2.isEmpty()) {
                this.f5182a.getUserProfiles().setCity(charSequence2);
            }
        }
        TextView textView2 = this.postoffice;
        if (textView2 != null) {
            String charSequence3 = textView2.getText().toString();
            if (!charSequence3.isEmpty()) {
                this.f5182a.getUserProfiles().setPostoffice(charSequence3);
            }
        }
        TextView textView3 = this.state;
        if (textView3 != null) {
            String charSequence4 = textView3.getText().toString();
            if (!charSequence4.isEmpty()) {
                this.f5182a.getUserProfiles().setState_name(charSequence4);
            }
        }
        if (this.f5181a.getUserProfiles().getUserProfileAddonServices().isEmaileditallowed()) {
            String obj3 = this.email.getText().toString();
            this.l = obj3;
            if (!obj3.isEmpty()) {
                this.f5182a.getUserProfiles().setEmail(this.l);
            }
        }
        if (this.f5181a.getUserProfiles().getUserProfileAddonServices().isMobileeditallowed()) {
            String obj4 = this.mobile.getText().toString();
            this.m = obj4;
            if (!obj4.isEmpty()) {
                this.f5182a.getUserProfiles().setMaskedMobileNo(this.m);
            }
        }
        if (this.f5181a.getUserProfiles().getUserProfileAddonServices().isNameeditallowed()) {
            String obj5 = this.fullName.getText().toString();
            this.n = obj5;
            if (!obj5.isEmpty()) {
                this.f5182a.getUserProfiles().setName(this.n);
            }
        }
        if (this.gender_tv.getText() == getString(R.string.male)) {
            this.f5182a.getUserProfiles().setGender("M");
        }
        if (this.gender_tv.getText() == getString(R.string.female)) {
            this.f5182a.getUserProfiles().setGender("F");
        }
        if (this.gender_tv.getText() == getString(R.string.transgender)) {
            this.f5182a.getUserProfiles().setGender(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        }
        if (this.f5181a.getUserProfiles().getUserProfileAddonServices().isGendereditallowed() && (str = this.h) != null && !str.isEmpty()) {
            this.f5182a.getUserProfiles().setGender(String.valueOf(this.h));
        }
        this.f5182a.setEmail(this.l);
        this.f5182a.setIsd_code(this.f5181a.getUserProfiles().getIsd_code());
        this.f5182a.getUserProfiles().setMaskedMobileNo(this.m);
        this.f5182a.setName(this.n);
        this.f5182a.setUser_loginid(this.f5181a.getUserProfiles().getUser_loginid());
        this.f5182a.setCountry_id(this.f5181a.getUserProfiles().getCountry_id());
        ProgressDialog progressDialog = new ProgressDialog(this.f5185a);
        progressDialog.setMessage(getString(R.string.please_wait_text));
        progressDialog.setTitle(getString(R.string.Updating_Information));
        progressDialog.setProgressStyle(0);
        progressDialog.show();
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).a(C1058d.z(C0657Qt.f(), "updateUserProfile"), this.f5182a).c(C1181iv.a()).a(E0.a()).b(new a(progressDialog));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006c  */
    @butterknife.OnClick({2131362087})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void validateEmail(android.view.View r7) {
        /*
            r6 = this;
            android.widget.EditText r7 = r6.email
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            java.lang.String r0 = r6.i
            boolean r7 = r7.equals(r0)
            java.lang.String r0 = "ok"
            if (r7 == 0) goto L_0x0027
            android.widget.EditText r7 = r6.email
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            java.lang.String r1 = "*"
            boolean r7 = r7.contains(r1)
            if (r7 != 0) goto L_0x0027
            goto L_0x004c
        L_0x0027:
            android.widget.EditText r7 = r6.email
            android.text.Editable r7 = r7.getText()
            r7.toString()
            android.widget.EditText r7 = r6.email
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            if (r7 == 0) goto L_0x0051
            java.lang.String r1 = ""
            boolean r1 = r7.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x0051
            java.lang.String r1 = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
            boolean r7 = r7.matches(r1)
            if (r7 == 0) goto L_0x004e
        L_0x004c:
            r7 = r0
            goto L_0x0053
        L_0x004e:
            java.lang.String r7 = "Please enter valid email Id."
            goto L_0x0053
        L_0x0051:
            java.lang.String r7 = "Please enter email id."
        L_0x0053:
            boolean r0 = r7.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x006c
            r7 = 0
            r6.f5190b = r7
            r1 = 0
            r2 = 0
            android.widget.EditText r7 = r6.email
            java.lang.String r3 = defpackage.xx.B(r7)
            r5 = 0
            java.lang.String r4 = "Validating Email Id"
            r0 = r6
            r0.f(r1, r2, r3, r4, r5)
            goto L_0x0074
        L_0x006c:
            r0 = 1
            r6.f5190b = r0
            r0 = 9
            r6.k(r0, r7)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.UpdateProfileFragment.validateEmail(android.view.View):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0082  */
    @butterknife.OnClick({2131362088})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void validateMobile(android.view.View r7) {
        /*
            r6 = this;
            android.widget.EditText r7 = r6.mobile
            android.text.Editable r7 = r7.getText()
            r7.toString()
            android.widget.EditText r7 = r6.mobile
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            java.lang.String r0 = r6.j
            boolean r7 = r7.equals(r0)
            java.lang.String r0 = "ok"
            if (r7 == 0) goto L_0x0030
            android.widget.EditText r7 = r6.mobile
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            java.lang.String r1 = "*"
            boolean r7 = r7.contains(r1)
            if (r7 != 0) goto L_0x0030
            goto L_0x0065
        L_0x0030:
            android.widget.EditText r7 = r6.mobile
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            if (r7 == 0) goto L_0x0067
            java.lang.String r1 = r7.trim()
            java.lang.String r2 = ""
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x0049
            goto L_0x0067
        L_0x0049:
            java.lang.String r1 = r7.trim()
            int r1 = r1.length()
            r2 = 10
            if (r1 == r2) goto L_0x0058
            java.lang.String r7 = "Should be 10 digits"
            goto L_0x0069
        L_0x0058:
            java.lang.String r7 = r7.trim()
            boolean r7 = defpackage.C0535I5.N(r7)
            if (r7 != 0) goto L_0x0065
            java.lang.String r7 = "Mobile number is invalid"
            goto L_0x0069
        L_0x0065:
            r7 = r0
            goto L_0x0069
        L_0x0067:
            java.lang.String r7 = "Cannot be blank"
        L_0x0069:
            boolean r0 = r7.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0082
            r7 = 0
            r6.f5189a = r7
            r1 = 0
            android.widget.EditText r7 = r6.mobile
            java.lang.String r2 = defpackage.xx.B(r7)
            r3 = 0
            r5 = 0
            java.lang.String r4 = "Validating Mobile Number"
            r0 = r6
            r0.f(r1, r2, r3, r4, r5)
            goto L_0x008a
        L_0x0082:
            r0 = 8
            r6.k(r0, r7)
            r7 = 1
            r6.f5189a = r7
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.UpdateProfileFragment.validateMobile(android.view.View):void");
    }

    public class c extends ClickableSpan {
        public c() {
        }

        public final void onClick(View view) {
            UpdateProfileFragment updateProfileFragment = UpdateProfileFragment.this;
            if (!C0535I5.O((ConnectivityManager) updateProfileFragment.getActivity().getSystemService("connectivity"), updateProfileFragment.f5185a)) {
                new Handler().postDelayed(new a(), 5000);
            } else {
                updateProfileFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://contents.irctc.co.in/en/deactivateEWalletTermsAndConditions.pdf")));
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }

        public class a implements Runnable {
            public final void run() {
            }
        }
    }

    public class i implements TextWatcher {
        public final View a;

        public i(EditText editText) {
            this.a = editText;
        }

        public final void afterTextChanged(Editable editable) {
            editable.toString();
            this.a.getId();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
