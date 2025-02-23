package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.fragment.CustomDialogFragment;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class RegistrationActivity extends AppCompatActivity {
    public static final /* synthetic */ int d = 0;
    public JB a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4299a = null;

    /* renamed from: a  reason: collision with other field name */
    public RegistrationActivity f4300a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4301a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4302a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, Boolean> f4303a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4304a;
    public ArrayList<String> b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public final HashMap<String, String> f4305b = new HashMap<>();

    /* renamed from: b  reason: collision with other field name */
    public boolean f4306b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f4307c;

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<String> f4308c = new ArrayList<>();

    /* renamed from: c  reason: collision with other field name */
    public HashMap<String, String> f4309c = new HashMap<>();

    /* renamed from: c  reason: collision with other field name */
    public boolean f4310c;
    @BindView(2131362523)
    EditText confirmpassword;

    /* renamed from: d  reason: collision with other field name */
    public String f4311d;

    /* renamed from: d  reason: collision with other field name */
    public final ArrayList<String> f4312d = new ArrayList<>();

    /* renamed from: d  reason: collision with other field name */
    public final HashMap<String, String> f4313d = new HashMap<>();

    /* renamed from: d  reason: collision with other field name */
    public boolean f4314d = false;
    @BindView(2131362526)
    TextView dob;
    public final HashMap<String, String> e = new HashMap<>();

    /* renamed from: e  reason: collision with other field name */
    public final boolean f4315e = true;
    @BindView(2131362529)
    EditText email;
    public boolean f = false;
    @BindView(2131364405)
    RadioButton female;
    @BindView(2131362532)
    EditText fname;
    public boolean g = false;
    public boolean h = false;
    @BindView(2131362541)
    EditText lname;
    @BindView(2131364475)
    RadioButton male;
    @BindView(2131363172)
    TextView maritalStatus;
    @BindView(2131362544)
    EditText mname;
    @BindView(2131362546)
    EditText mobile;
    @BindView(2131363298)
    TextView nationality;
    @BindView(2131364499)
    TextView next;
    @BindView(2131363351)
    TextView occupation;
    @BindView(2131362568)
    EditText password;
    @BindView(2131363643)
    AdManagerAdView registration_bottom_ads;
    @BindView(2131362579)
    EditText secAnswer;
    @BindView(2131363880)
    TextView secQuestion;
    @BindView(2131364695)
    RadioButton transGender;
    @BindView(2131364352)
    TextView tvConfPwdShowHide;
    @BindView(2131364547)
    TextView tvPwdShowHide;
    @BindView(2131362587)
    EditText userName;

    public class a implements OnSelectionListener {
        public a() {
        }

        public final void onClick(String str) {
            RegistrationActivity registrationActivity = RegistrationActivity.this;
            registrationActivity.occupation.setText(str);
            registrationActivity.f4301a.dismiss();
            if (!registrationActivity.f4313d.get(str).equals("-1")) {
                registrationActivity.f = true;
                registrationActivity.occupation.setError((CharSequence) null);
                return;
            }
            registrationActivity.f = false;
            registrationActivity.occupation.setError(registrationActivity.getString(R.string.Select_Occupation));
        }
    }

    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public final void onFocusChange(View view, boolean z) {
            if (!z) {
                EditText editText = RegistrationActivity.this.fname;
                editText.setText(editText.getText().toString().replaceAll("\\s+", " ").trim());
            }
        }
    }

    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        public final void onFocusChange(View view, boolean z) {
            if (!z) {
                EditText editText = RegistrationActivity.this.mname;
                editText.setText(editText.getText().toString().replaceAll("\\s+", " ").trim());
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public final void onFocusChange(View view, boolean z) {
            if (!z) {
                EditText editText = RegistrationActivity.this.lname;
                editText.setText(editText.getText().toString().replaceAll("\\s+", " ").trim());
            }
        }
    }

    public class e implements DatePickerDialog.OnDateSetListener {
        public e() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Object obj;
            Object obj2;
            int i4 = RegistrationActivity.d;
            RegistrationActivity registrationActivity = RegistrationActivity.this;
            TextView textView = registrationActivity.dob;
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
            registrationActivity.dob.getText().toString();
            registrationActivity.n(7);
        }
    }

    public class f implements OnSelectionListener {
        public f() {
        }

        public final void onClick(String str) {
            RegistrationActivity registrationActivity = RegistrationActivity.this;
            registrationActivity.secQuestion.setText(str);
            registrationActivity.f4301a.dismiss();
            if (!registrationActivity.e.get(str).equals("-1")) {
                registrationActivity.g = true;
                registrationActivity.secAnswer.setEnabled(true);
                registrationActivity.secQuestion.setError((CharSequence) null);
                return;
            }
            registrationActivity.secAnswer.setEnabled(false);
            registrationActivity.g = false;
            registrationActivity.secQuestion.setError(registrationActivity.getString(R.string.select_secret_question));
        }
    }

    public class g implements OnSelectionListener {
        public g() {
        }

        public final void onClick(String str) {
            RegistrationActivity registrationActivity = RegistrationActivity.this;
            registrationActivity.f4301a.dismiss();
            registrationActivity.nationality.setText(str);
            HashMap<String, String> hashMap = registrationActivity.f4309c;
            if (hashMap == null) {
                registrationActivity.f4314d = false;
                registrationActivity.nationality.setError(registrationActivity.getString(R.string.select_Nationality));
            } else if (hashMap.get(str).equals("Show all")) {
                registrationActivity.nationality.setText(registrationActivity.getString(R.string.select_Nationality));
                registrationActivity.nationality.setError((CharSequence) null);
                registrationActivity.f4314d = true;
                C0535I5.b0(registrationActivity.f4300a);
                registrationActivity.nationality.setText(registrationActivity.getString(R.string.select_Nationality));
            } else if (Integer.valueOf(registrationActivity.f4309c.get(str)).intValue() == 94 || Integer.valueOf(registrationActivity.f4309c.get(str)).intValue() < 1) {
                registrationActivity.f4314d = true;
            } else {
                registrationActivity.f4314d = false;
                registrationActivity.nationality.setError((CharSequence) null);
                C0535I5.m(registrationActivity, false, "International user registration facility is available on IRCTC website www.irctc.co.in only.", registrationActivity.getString(R.string.error), registrationActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class h implements OnSelectionListener {
        public h() {
        }

        public final void onClick(String str) {
            RegistrationActivity registrationActivity = RegistrationActivity.this;
            registrationActivity.maritalStatus.setText(str);
            registrationActivity.f4301a.dismiss();
            if (!registrationActivity.f4305b.get(str).equals("nil")) {
                registrationActivity.getClass();
                registrationActivity.maritalStatus.setError((CharSequence) null);
                return;
            }
            registrationActivity.getClass();
            registrationActivity.maritalStatus.setError(registrationActivity.getString(R.string.select_marital_status));
        }
    }

    static {
        C1354qp.R(RegistrationActivity.class);
    }

    public final String A() {
        this.email.getText().toString();
        String obj = this.email.getText().toString();
        if (obj == null || obj.equalsIgnoreCase("")) {
            return getString(R.string.enter_email_id);
        }
        if (obj.matches("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$")) {
            return "ok";
        }
        return getString(R.string.enter_valid_email_id);
    }

    public final String B() {
        String obj = this.fname.getText().toString();
        if (obj == null || obj.equalsIgnoreCase("")) {
            return getString(R.string.Password_ente_First_name);
        }
        if (obj.length() < 1) {
            return getString(R.string.first_name_length_cannot_lessthan_3characters);
        }
        if (obj.length() > 20) {
            return getString(R.string.first_name_length_cannot_morethan_20characters);
        }
        if (obj.matches("^[a-zA-Z\\s]+$")) {
            return "ok";
        }
        return getString(R.string.please_enter_valid_first_name);
    }

    public final String C() {
        this.mobile.getText().toString();
        String obj = this.mobile.getText().toString();
        if (obj == null || obj.trim().equalsIgnoreCase("")) {
            return getString(R.string.cannot_blank);
        }
        if (obj.trim().length() != 10) {
            return getString(R.string.Should_10_digits);
        }
        if (!C0535I5.N(obj.trim())) {
            return getString(R.string.Mobile_number_invalid);
        }
        return "ok";
    }

    public final String D() {
        this.password.getText().toString();
        String obj = this.password.getText().toString();
        if (obj.length() == 0) {
            return getString(R.string.enter_password);
        }
        if (obj.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,15}$")) {
            return "ok";
        }
        return getString(R.string.characters_long_capital_small_numeric);
    }

    public final String E() {
        String str;
        this.userName.getText().toString();
        String obj = this.userName.getText().toString();
        if (obj.equalsIgnoreCase("")) {
            str = getString(R.string.please_enter_User_ID);
        } else if (!obj.matches("^[a-zA-Z].*")) {
            str = getString(R.string.user_id_first_latel_alphabet);
        } else if (!obj.matches("^[a-zA-Z0-9_]+$")) {
            str = getString(R.string.use_id_contain_letters_numbers_underscores);
        } else if (obj.length() <= 3) {
            str = getString(R.string.user_id_not_3lesschar);
        } else if (obj.length() > 35) {
            str = getString(R.string.user_length_not_35char);
        } else {
            str = "ok";
        }
        m();
        return str;
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    @OnClick({2131362523})
    public void cnfPasswordval(View view) {
        if (!this.confirmpassword.hasFocus()) {
            String z = z();
            if (z.equalsIgnoreCase("ok")) {
                n(3);
            } else {
                p(3, z);
            }
        }
    }

    @OnClick({2131364352})
    public void confPwdShowHide() {
        t(this.confirmpassword, this.tvConfPwdShowHide);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @butterknife.OnClick({2131364499})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doNext() {
        /*
            r9 = this;
            android.widget.EditText r0 = r9.userName
            android.text.Editable r0 = r0.getText()
            java.lang.String r2 = r0.toString()
            android.widget.EditText r0 = r9.mobile
            android.text.Editable r0 = r0.getText()
            java.lang.String r3 = r0.toString()
            android.widget.EditText r0 = r9.email
            android.text.Editable r0 = r0.getText()
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = r9.C()
            java.lang.String r1 = "ok"
            boolean r5 = r0.equalsIgnoreCase(r1)
            r6 = 0
            r7 = 1
            r8 = 8
            if (r5 == 0) goto L_0x0110
            r9.n(r8)
            java.lang.String r0 = r9.A()
            boolean r5 = r0.equalsIgnoreCase(r1)
            r8 = 9
            if (r5 == 0) goto L_0x0107
            r9.n(r8)
            java.lang.String r0 = r9.E()
            boolean r5 = r0.equalsIgnoreCase(r1)
            if (r5 == 0) goto L_0x00fe
            r9.n(r7)
            java.lang.String r0 = r9.D()
            boolean r5 = r0.equalsIgnoreCase(r1)
            r8 = 2
            if (r5 == 0) goto L_0x00f5
            r9.n(r8)
            java.lang.String r0 = r9.z()
            boolean r5 = r0.equalsIgnoreCase(r1)
            r8 = 3
            if (r5 == 0) goto L_0x00ec
            r9.n(r8)
            java.lang.String r0 = r9.B()
            boolean r5 = r0.equalsIgnoreCase(r1)
            r8 = 4
            if (r5 == 0) goto L_0x00e3
            r9.n(r8)
            android.widget.TextView r0 = r9.dob
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x0092
            java.lang.String r5 = r0.trim()
            java.lang.String r8 = ""
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0090
            goto L_0x0092
        L_0x0090:
            r5 = r1
            goto L_0x0094
        L_0x0092:
            java.lang.String r5 = "Cannot be blank"
        L_0x0094:
            int r0 = r0.length()
            r8 = 10
            if (r0 != r8) goto L_0x00ce
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r8 = "dd/MM/yyyy"
            r0.<init>(r8)
            android.widget.TextView r8 = r9.dob     // Catch:{ ParseException -> 0x00b8 }
            java.lang.CharSequence r8 = r8.getText()     // Catch:{ ParseException -> 0x00b8 }
            java.lang.String r8 = r8.toString()     // Catch:{ ParseException -> 0x00b8 }
            java.util.Date r0 = r0.parse(r8)     // Catch:{ ParseException -> 0x00b8 }
            int r0 = defpackage.C0535I5.f(r0)     // Catch:{ ParseException -> 0x00b8 }
            r9.c = r0     // Catch:{ ParseException -> 0x00b8 }
            goto L_0x00bc
        L_0x00b8:
            r0 = move-exception
            r0.getMessage()
        L_0x00bc:
            int r0 = r9.c
            r8 = 18
            if (r0 < r8) goto L_0x00c6
            r8 = 125(0x7d, float:1.75E-43)
            if (r0 <= r8) goto L_0x00d5
        L_0x00c6:
            r0 = 2131951638(0x7f130016, float:1.9539696E38)
            java.lang.String r5 = r9.getString(r0)
            goto L_0x00d5
        L_0x00ce:
            r0 = 2131953462(0x7f130736, float:1.9543396E38)
            java.lang.String r5 = r9.getString(r0)
        L_0x00d5:
            boolean r0 = r5.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x00dd
            r0 = r7
            goto L_0x0119
        L_0x00dd:
            cris.org.in.ima.activities.RegistrationActivity r0 = r9.f4300a
            defpackage.C0535I5.t0(r0, r5)
            goto L_0x0118
        L_0x00e3:
            r9.p(r8, r0)
            cris.org.in.ima.activities.RegistrationActivity r1 = r9.f4300a
            defpackage.C0535I5.t0(r1, r0)
            goto L_0x0118
        L_0x00ec:
            r9.p(r8, r0)
            cris.org.in.ima.activities.RegistrationActivity r1 = r9.f4300a
            defpackage.C0535I5.t0(r1, r0)
            goto L_0x0118
        L_0x00f5:
            r9.p(r8, r0)
            cris.org.in.ima.activities.RegistrationActivity r1 = r9.f4300a
            defpackage.C0535I5.t0(r1, r0)
            goto L_0x0118
        L_0x00fe:
            r9.p(r7, r0)
            cris.org.in.ima.activities.RegistrationActivity r1 = r9.f4300a
            defpackage.C0535I5.t0(r1, r0)
            goto L_0x0118
        L_0x0107:
            r9.p(r8, r0)
            cris.org.in.ima.activities.RegistrationActivity r1 = r9.f4300a
            defpackage.C0535I5.t0(r1, r0)
            goto L_0x0118
        L_0x0110:
            r9.p(r8, r0)
            cris.org.in.ima.activities.RegistrationActivity r1 = r9.f4300a
            defpackage.C0535I5.t0(r1, r0)
        L_0x0118:
            r0 = r6
        L_0x0119:
            if (r0 == 0) goto L_0x0172
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r9.f4303a
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0131
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r9.f4303a
            java.lang.Object r0 = r0.get(r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0132
        L_0x0131:
            r6 = r7
        L_0x0132:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r9.f4303a
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x0148
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r9.f4303a
            java.lang.Object r0 = r0.get(r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0149
        L_0x0148:
            r6 = r7
        L_0x0149:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r9.f4303a
            boolean r0 = r0.containsKey(r4)
            if (r0 == 0) goto L_0x0162
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r9.f4303a
            java.lang.Object r0 = r0.get(r4)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0160
            goto L_0x0162
        L_0x0160:
            r0 = r6
            goto L_0x0163
        L_0x0162:
            r0 = r7
        L_0x0163:
            if (r0 == 0) goto L_0x016c
            r6 = 1
            java.lang.String r5 = "Validating Details"
            r1 = r9
            r1.l(r2, r3, r4, r5, r6)
        L_0x016c:
            r0 = r0 ^ r7
            if (r0 == 0) goto L_0x0172
            r9.x()
        L_0x0172:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.RegistrationActivity.doNext():void");
    }

    @OnClick({2131362526})
    public void dobClick(View view) {
        onDobClick();
    }

    @OnFocusChange({2131362532})
    public void fnameval(View view) {
        if (!this.fname.hasFocus()) {
            String B = B();
            if (B.equalsIgnoreCase("ok")) {
                n(4);
            } else {
                p(4, B);
            }
        }
    }

    public final void init() {
        this.f4303a = new HashMap<>();
        this.f4299a = ProgressDialog.show(this, getString(R.string.loading), getString(R.string.please_wait_text));
        if (this.e.isEmpty() || this.f4312d.isEmpty()) {
            String f2 = C0657Qt.f();
            ((Om) C0657Qt.b()).V0(f2 + "seqQuestion").c(C1181iv.a()).a(E0.a()).b(new F(this));
        }
        if (this.f4313d.isEmpty() || this.f4308c.isEmpty()) {
            String f3 = C0657Qt.f();
            ((Om) C0657Qt.b()).d(f3 + "occupation").c(C1181iv.a()).a(E0.a()).b(new G(this));
        }
        ArrayList<String> arrayList = this.f4302a;
        boolean isEmpty = arrayList.isEmpty();
        HashMap<String, String> hashMap = this.f4305b;
        if (isEmpty || hashMap.isEmpty()) {
            hashMap.clear();
            hashMap.put(getString(R.string.unmarried), "U");
            hashMap.put(getString(R.string.married), "M");
            arrayList.add(getString(R.string.unmarried));
            arrayList.add(getString(R.string.married));
            this.maritalStatus.setText(getString(R.string.marital_status));
        }
        HashMap<String, String> hashMap2 = C0535I5.f3623a;
        this.f4309c = hashMap2;
        ArrayList<String> arrayList2 = C0535I5.f3622a;
        this.b = arrayList2;
        if (hashMap2 == null || arrayList2 == null) {
            this.f4309c = new HashMap<>();
            this.b = new ArrayList<>();
            this.f4309c.put(getString(R.string.India), "94");
            this.f4309c.put(getString(R.string.show_all), "Show all");
            this.b.add(getString(R.string.India));
            this.b.add(getString(R.string.show_all));
            C0535I5.f3623a = this.f4309c;
            C0535I5.f3622a = this.b;
        }
        this.nationality.setText(this.f4300a.getResources().getString(R.string.nationality));
        EditText editText = this.userName;
        editText.addTextChangedListener(new i(editText));
        EditText editText2 = this.email;
        editText2.addTextChangedListener(new i(editText2));
        EditText editText3 = this.mobile;
        editText3.addTextChangedListener(new i(editText3));
        EditText editText4 = this.password;
        editText4.addTextChangedListener(new i(editText4));
        EditText editText5 = this.confirmpassword;
        editText5.addTextChangedListener(new i(editText5));
        EditText editText6 = this.secAnswer;
        editText6.addTextChangedListener(new i(editText6));
        o(this.userName, 35);
        o(this.password, 15);
        o(this.fname, 20);
        o(this.lname, 20);
        o(this.mname, 20);
        new LinearLayout.LayoutParams(0, -1).weight = 4.0f;
    }

    public final void l(String str, String str2, String str3, String str4, boolean z) {
        if (!C0535I5.O((ConnectivityManager) this.f4300a.getSystemService("connectivity"), this.f4300a)) {
            new Handler().postDelayed(new Ts(), 5000);
            return;
        }
        this.f4307c = "";
        this.f4299a = ProgressDialog.show(this, str4, getString(R.string.Checking_Availability_msg));
        ((Om) C0657Qt.b()).e1(C1058d.z(C0657Qt.f(), "checkUserAvail"), str, str3, str2).c(C1181iv.a()).a(E0.a()).b(new E(this, str, str2, str3, z));
    }

    @OnFocusChange({2131362541})
    public void lnameval(View view) {
        this.lname.hasFocus();
    }

    public final void m() {
        ProgressDialog progressDialog = this.f4299a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @OnFocusChange({2131362544})
    public void mnameval(View view) {
        this.mname.hasFocus();
    }

    public final void n(int i2) {
        switch (i2) {
            case 1:
                this.userName.setError((CharSequence) null);
                this.userName.setTextColor(-16777216);
                return;
            case 2:
                this.password.setError((CharSequence) null);
                this.password.setTextColor(-16777216);
                return;
            case 3:
                this.confirmpassword.setError((CharSequence) null);
                this.confirmpassword.setTextColor(-16777216);
                return;
            case 4:
                this.fname.setError((CharSequence) null);
                this.fname.setTextColor(-16777216);
                return;
            case 5:
                this.mname.setError((CharSequence) null);
                this.mname.setTextColor(-16777216);
                return;
            case 6:
                this.lname.setError((CharSequence) null);
                this.lname.setTextColor(-16777216);
                return;
            case 7:
                this.dob.setError((CharSequence) null);
                this.dob.setTextColor(-16777216);
                return;
            case 8:
                this.mobile.setError((CharSequence) null);
                this.mobile.setTextColor(-16777216);
                return;
            case 9:
                this.email.setError((CharSequence) null);
                this.email.setTextColor(-16777216);
                return;
            default:
                return;
        }
    }

    public final void o(EditText editText, int i2) {
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_registration_page1);
        ButterKnife.bind((Activity) this);
        this.f4300a = this;
        this.a = new JB();
        init();
        this.f4304a = false;
        this.f4306b = false;
        this.f4310c = false;
        this.fname.setOnFocusChangeListener(new b());
        this.mname.setOnFocusChangeListener(new c());
        this.lname.setOnFocusChangeListener(new d());
        C0535I5.Y(this, this.registration_bottom_ads, (GoogleAdParamDTO) null);
        this.password.setLongClickable(false);
        this.password.setTextIsSelectable(false);
        this.confirmpassword.setLongClickable(false);
        this.confirmpassword.setTextIsSelectable(false);
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4299a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4299a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131362443})
    public void onDobClick() {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new e(), instance.get(1), instance.get(2), instance.get(5));
        Calendar instance2 = Calendar.getInstance();
        Calendar instance3 = Calendar.getInstance();
        instance2.add(1, -18);
        instance3.add(1, -143);
        datePickerDialog.getDatePicker().setMaxDate(instance2.getTime().getTime());
        datePickerDialog.getDatePicker().setMinDate(instance3.getTime().getTime());
        datePickerDialog.setTitle(getString(R.string.Select_Date_of_Birth));
        datePickerDialog.show();
        C0535I5.I(this);
    }

    @OnClick({2131364405})
    public void onFemaleBtnClick(View view) {
        C0535I5.H(this, view);
        this.male.setSelected(false);
        this.female.setSelected(true);
        this.transGender.setSelected(false);
        this.f4311d = "F";
    }

    @OnClick({2131364475})
    public void onMaleBtnClick(View view) {
        C0535I5.H(this, view);
        this.male.setSelected(true);
        this.female.setSelected(false);
        this.transGender.setSelected(false);
        this.f4311d = "M";
    }

    @OnClick({2131363172})
    public void onMaritalStatusClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4301a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4301a.show(getSupportFragmentManager(), "");
        this.f4301a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), this.f4302a, new h());
        this.f4301a.g().setText(getString(R.string.select_marital_status));
        this.f4301a.f().setAdapter(customAdapter);
    }

    @OnClick({2131363298})
    public void onNationalityClick(View view) {
        this.f4309c = C0535I5.f3623a;
        this.b = C0535I5.f3622a;
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4301a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4301a.show(getSupportFragmentManager(), "");
        this.f4301a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), this.b, new g());
        this.f4301a.g().setText(getString(R.string.select_Nationality));
        this.f4301a.f().setAdapter(customAdapter);
    }

    @OnClick({2131363351})
    public void onOccupationClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4301a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4301a.show(getSupportFragmentManager(), "");
        this.f4301a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), this.f4308c, new a());
        this.f4301a.g().setText(getString(R.string.Select_Occupation));
        this.f4301a.f().setAdapter(customAdapter);
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        ProgressDialog progressDialog = this.f4299a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4299a.dismiss();
        }
        C0535I5.u();
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    @OnClick({2131363880})
    public void onSecretQuestionClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4301a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4301a.show(getSupportFragmentManager(), "");
        this.f4301a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), this.f4312d, new f());
        this.f4301a.g().setText(getString(R.string.select_secret_question));
        this.f4301a.f().setAdapter(customAdapter);
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4299a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4299a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364695})
    public void onTransgender(View view) {
        C0535I5.H(this, view);
        this.male.setSelected(false);
        this.female.setSelected(false);
        this.transGender.setSelected(true);
        this.f4311d = RequestConfiguration.MAX_AD_CONTENT_RATING_T;
    }

    @OnClick({2131364713})
    public void onUserGuideClick(View view) {
        String packageName = getPackageName();
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("UserGuideIRCTC" + packageName)));
        } catch (ActivityNotFoundException e2) {
            e2.getMessage();
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://contents.irctc.co.in/en/UserGuideIRCTC.pdf")));
        }
    }

    public final void p(int i2, String str) {
        switch (i2) {
            case 1:
                this.userName.setError(str);
                this.userName.setTextColor(-65536);
                return;
            case 2:
                this.password.setError(str);
                this.password.setTextColor(-65536);
                return;
            case 3:
                this.confirmpassword.setError(str);
                this.confirmpassword.setTextColor(-65536);
                return;
            case 4:
                this.fname.setError(str);
                this.fname.setTextColor(-65536);
                return;
            case 5:
                this.mname.setError(str);
                this.mname.setTextColor(-65536);
                return;
            case 6:
                this.lname.setError(str);
                this.lname.setTextColor(-65536);
                return;
            case 7:
                this.dob.setError(str);
                this.dob.setTextColor(-65536);
                return;
            case 8:
                this.mobile.setError(str);
                this.mobile.setTextColor(-65536);
                return;
            case 9:
                this.email.setError(str);
                this.email.setTextColor(-65536);
                return;
            default:
                return;
        }
    }

    @OnClick({2131362568})
    public void passwordval(View view) {
        String D = D();
        if (D.equalsIgnoreCase("ok")) {
            n(2);
        } else {
            p(2, D);
        }
    }

    @OnClick({2131364547})
    public void pwdShowHide() {
        t(this.password, this.tvPwdShowHide);
    }

    @OnFocusChange({2131362587})
    public void searchUser(View view) {
        if (!this.userName.hasFocus()) {
            String E = E();
            if (!E.equalsIgnoreCase("ok")) {
                p(1, E);
                this.f4304a = true;
            } else if (!this.f4303a.containsKey(this.userName.getText().toString().trim())) {
                this.f4304a = false;
                if (!this.userName.getText().toString().trim().equals("")) {
                    l(xx.B(this.userName), (String) null, (String) null, "Validating User", false);
                }
            } else if (!this.f4303a.get(this.userName.getText().toString().trim()).booleanValue()) {
                this.f4304a = true;
                p(1, getString(R.string.username_already_registered));
            } else {
                this.f4304a = false;
                n(1);
            }
        }
    }

    public final void t(EditText editText, TextView textView) {
        if (editText.getInputType() == 145) {
            editText.setInputType(129);
            editText.setSelection(editText.getText().length());
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility_off, 0);
            return;
        }
        editText.setInputType(145);
        editText.setSelection(editText.getText().length());
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility, 0);
        textView.setContentDescription(getResources().getString(R.string.hidePassword));
    }

    @OnFocusChange({2131362529})
    public void validateEmail(View view) {
        if (!this.email.hasFocus()) {
            String A = A();
            if (!A.equalsIgnoreCase("ok")) {
                this.f4310c = true;
                p(9, A);
            } else if (!this.f4303a.containsKey(this.email.getText().toString().trim())) {
                this.f4310c = false;
                l((String) null, (String) null, xx.B(this.email), getString(R.string.validating_email), false);
            } else if (!this.f4303a.get(this.email.getText().toString().trim()).booleanValue()) {
                this.f4310c = true;
                p(9, getString(R.string.email_already_registered));
            } else {
                this.f4310c = false;
                n(9);
            }
        }
    }

    @OnFocusChange({2131362546})
    public void validateMobile(View view) {
        if (!this.mobile.hasFocus()) {
            String C = C();
            if (!C.equalsIgnoreCase("ok")) {
                p(8, C);
                this.f4306b = true;
            } else if (!this.f4303a.containsKey(this.mobile.getText().toString().trim())) {
                this.f4306b = false;
                l((String) null, xx.B(this.mobile), (String) null, getString(R.string.validating_mobile_number), false);
            } else if (!this.f4303a.get(this.mobile.getText().toString().trim()).booleanValue()) {
                p(8, getString(R.string.mobilenumber_already_registered));
                this.f4306b = true;
            } else {
                this.f4306b = false;
                n(8);
            }
        }
    }

    public final void x() {
        String str;
        if (!this.f4314d) {
            this.nationality.setError((CharSequence) null);
            this.nationality.setError(getString(R.string.select_Nationality));
        }
        if (!this.g) {
            this.secQuestion.setError((CharSequence) null);
            this.secQuestion.setError("Select Secret Question");
        }
        if (!this.h) {
            this.secAnswer.setError((CharSequence) null);
            this.secAnswer.setError(getString(R.string.Please_fill_your_answer));
            this.secAnswer.setTextColor(-65536);
        }
        String str2 = this.f4311d;
        if (str2 == null || str2.equals("")) {
            C0535I5.t0(this.f4300a, getString(R.string.please_select_gender));
        } else if (this.f4314d && this.g && this.h && this.f4315e) {
            this.a.setUserName(this.userName.getText().toString().trim());
            this.a.setPassWord(this.password.getText().toString().trim());
            this.a.setCnfPassWord(this.confirmpassword.getText().toString().trim());
            this.a.setFirstName(this.fname.getText().toString().trim());
            this.a.setMiddleName(this.mname.getText().toString().trim());
            this.a.setLastName(this.lname.getText().toString().trim());
            JB jb = this.a;
            String trim = this.dob.getText().toString().trim();
            jb.setDob(trim.substring(6, 10) + trim.substring(3, 5) + trim.substring(0, 2));
            JB jb2 = this.a;
            if (this.male.isSelected()) {
                str = "M";
            } else if (this.female.isSelected()) {
                str = "F";
            } else {
                str = RequestConfiguration.MAX_AD_CONTENT_RATING_T;
            }
            jb2.setGender(str);
            this.a.setMobile(this.mobile.getText().toString().trim());
            this.a.setEmail(this.email.getText().toString().trim());
            this.a.setNationalityId(Short.valueOf(this.f4309c.get(this.nationality.getText().toString())));
            this.a.setSecurityQuestion(this.e.get(this.secQuestion.getText()));
            this.a.setSecurityAns(this.secAnswer.getText().toString().trim());
            this.a.setPrefLanguage("en");
            if (!this.f) {
                this.a.setOccupation("6");
            } else {
                this.a.setOccupation(this.f4313d.get(this.occupation.getText()));
            }
            if (this.maritalStatus.getText() == null || !this.maritalStatus.getText().equals("")) {
                this.a.setMartialStatus(this.f4305b.get(this.maritalStatus.getText()));
            } else {
                this.a.setMartialStatus("");
            }
            this.a.getClass();
            Intent intent = new Intent(getBaseContext(), RegistrationPage2Activity.class);
            intent.putExtra("reg1", this.a);
            startActivity(intent);
        }
    }

    public final String z() {
        this.confirmpassword.getText().toString();
        String obj = this.password.getText().toString();
        String obj2 = this.confirmpassword.getText().toString();
        if (obj2 == null || obj2.length() <= 0) {
            return getString(R.string.please_provide_Confirm_password);
        }
        if (obj.equals(obj2)) {
            return "ok";
        }
        return getString(R.string.new_Confirm_mismatch);
    }

    @OnClick({2131364713})
    public void onUserGuideClick() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://contents.irctc.co.in/en/UserGuideIRCTC.pdf"));
        startActivity(intent);
    }

    public class i implements TextWatcher {
        public final View a;

        public i(EditText editText) {
            this.a = editText;
        }

        public final void afterTextChanged(Editable editable) {
            String str;
            String obj = editable.toString();
            if (this.a.getId() == R.id.et_security_answer) {
                int i = RegistrationActivity.d;
                RegistrationActivity registrationActivity = RegistrationActivity.this;
                registrationActivity.h = false;
                if (obj.trim().length() <= 0) {
                    str = "Please fill your answer";
                } else if (obj.length() < 1) {
                    str = "Answer length cannot be less than 1 characters.";
                } else if (obj.length() > 20) {
                    str = "Answer length cannot be more than 20 characters.";
                } else if (obj.matches("^[a-zA-Z0-9\\_\\s]+$")) {
                    str = "ok";
                } else {
                    str = "Please enter valid answer, special case are not allowed.";
                }
                if (!str.equals("ok")) {
                    registrationActivity.secAnswer.setError(str);
                    registrationActivity.secAnswer.setTextColor(-65536);
                    registrationActivity.h = false;
                    return;
                }
                registrationActivity.secAnswer.setError((CharSequence) null);
                registrationActivity.secAnswer.setTextColor(-16777216);
                registrationActivity.h = true;
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2;
            if (this.a.getId() == R.id.et_email && (charSequence2 = charSequence.toString()) != null && charSequence2.length() > 0 && charSequence2.charAt(0) == ' ') {
                RegistrationActivity.this.email.setError("Space not allowed");
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
