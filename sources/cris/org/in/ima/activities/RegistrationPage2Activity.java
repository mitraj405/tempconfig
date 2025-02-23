package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.fragment.CustomDialogFragment;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import rx.Subscriber;

public class RegistrationPage2Activity extends AppCompatActivity implements View.OnTouchListener {
    public static InterstitialAd a;

    /* renamed from: a  reason: collision with other field name */
    public JB f4318a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4319a = null;

    /* renamed from: a  reason: collision with other field name */
    public TextWatcher f4320a = null;

    /* renamed from: a  reason: collision with other field name */
    public RegistrationPage2Activity f4321a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4322a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4323a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, String> f4324a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4325a = false;
    @BindView(2131362517)
    EditText address;
    @BindView(2131362518)
    EditText area;
    public ArrayList<String> b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public boolean f4326b = false;
    public int c = -1;

    /* renamed from: c  reason: collision with other field name */
    public final String f4327c = "^[0-9a-zA-Z]{1}[0-9a-zA-Z\\s,\\-_:()\\/]{2,29}$";

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<String> f4328c = new ArrayList<>();

    /* renamed from: c  reason: collision with other field name */
    public boolean f4329c = false;
    @BindView(2131362124)
    LinearLayout captch_ll;
    @BindView(2131362125)
    ImageView captcha;
    @BindView(2131364327)
    EditText captchaInputValue;
    @BindView(2131362197)
    TextView city;
    @BindView(2131362319)
    TextView country;
    public final String d = "^[0-9a-zA-Z]{1}[0-9a-zA-Z\\s,\\-_:()\\/]{2,224}$";
    public final String e = "^[0]+$";
    public String f = "-1";
    public String g = "";
    public String h = "";
    public String i;
    public String j;
    public String k = "REGISTRATION";
    @BindView(2131362540)
    EditText landline;
    @BindView(2131364466)
    TextView loading_captcha;
    @BindView(2131363104)
    ImageView loginCaptchaRefresh;
    @BindView(2131364500)
    TextView nextBtn;
    @BindView(2131362582)
    EditText otherState;
    @BindView(2131362559)
    EditText othercity;
    @BindView(2131362571)
    EditText pincode;
    @BindView(2131363526)
    TextView postoffice;
    @BindView(2131363643)
    AdManagerAdView registration_bottom_ads;
    @BindView(2131362148)
    CheckBox sameoffice;
    @BindView(2131362583)
    TextView state;
    @BindView(2131362584)
    EditText street;

    public class b extends Subscriber<E4> {
        public b() {
        }

        public final void onCompleted() {
            InterstitialAd interstitialAd = RegistrationPage2Activity.a;
            RegistrationPage2Activity.this.f4319a.dismiss();
        }

        public final void onError(Throwable th) {
            InterstitialAd interstitialAd = RegistrationPage2Activity.a;
            th.getClass();
            th.getMessage();
            RegistrationPage2Activity.this.f4319a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            E4 e4 = (E4) obj;
            RegistrationPage2Activity registrationPage2Activity = RegistrationPage2Activity.this;
            if (e4 != null) {
                C0657Qt.h();
                try {
                    if (e4.getError() == null) {
                        registrationPage2Activity.c = e4.getCaptcha().intValue();
                        registrationPage2Activity.f4319a.dismiss();
                        C1450w1.f7025d = System.currentTimeMillis();
                        if (10 == registrationPage2Activity.c) {
                            RegistrationPage2Activity.l(registrationPage2Activity, e4.getCaptchaQuestion());
                            return;
                        }
                        return;
                    }
                    registrationPage2Activity.f4319a.dismiss();
                    C0535I5.m(registrationPage2Activity.f4321a, false, e4.getError(), registrationPage2Activity.getString(R.string.error), registrationPage2Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } catch (Exception e) {
                    registrationPage2Activity.f4319a.dismiss();
                    InterstitialAd interstitialAd = RegistrationPage2Activity.a;
                    e.getMessage();
                }
            } else {
                registrationPage2Activity.f4319a.dismiss();
                C0535I5.m(registrationPage2Activity.f4321a, false, registrationPage2Activity.getResources().getString(R.string.unable_process_message), registrationPage2Activity.getString(R.string.error), registrationPage2Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class c implements OnSelectionListener {
        public c() {
        }

        public final void onClick(String str) {
            RegistrationPage2Activity registrationPage2Activity = RegistrationPage2Activity.this;
            String str2 = registrationPage2Activity.f;
            registrationPage2Activity.f = registrationPage2Activity.f4324a.get(str);
            registrationPage2Activity.f4322a.dismiss();
            String str3 = registrationPage2Activity.f;
            if (str3 == null) {
                C0535I5.m(registrationPage2Activity, false, registrationPage2Activity.getString(R.string.Country_List_not_Loaded), registrationPage2Activity.getString(R.string.error), registrationPage2Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (!str3.equals(str2)) {
                registrationPage2Activity.country.setText(str);
                registrationPage2Activity.country.setError((CharSequence) null);
                registrationPage2Activity.f4323a.clear();
                registrationPage2Activity.f4328c.clear();
                if (!registrationPage2Activity.f.equals("-1")) {
                    registrationPage2Activity.pincode.setVisibility(0);
                    if (registrationPage2Activity.f.equals("94")) {
                        registrationPage2Activity.othercity.setVisibility(8);
                        registrationPage2Activity.state.setEnabled(false);
                        registrationPage2Activity.pincode.setText((CharSequence) null);
                        registrationPage2Activity.pincode.setEnabled(true);
                        TextWatcher textWatcher = registrationPage2Activity.f4320a;
                        if (textWatcher != null) {
                            registrationPage2Activity.pincode.removeTextChangedListener(textWatcher);
                        }
                        AlertDialog alertDialog = C0535I5.f3619a;
                        C0479D5 d5 = new C0479D5(registrationPage2Activity, 6);
                        registrationPage2Activity.f4320a = d5;
                        registrationPage2Activity.pincode.addTextChangedListener(d5);
                        EditText editText = (EditText) registrationPage2Activity.findViewById(R.id.et_pincode_reg);
                        editText.setInputType(2);
                        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
                        registrationPage2Activity.othercity.setText((CharSequence) null);
                        registrationPage2Activity.postoffice.setText(registrationPage2Activity.getString(R.string.post_office));
                        registrationPage2Activity.city.setText(registrationPage2Activity.getString(R.string.city));
                        registrationPage2Activity.f4325a = true;
                        return;
                    }
                    C0535I5.m(registrationPage2Activity, false, "International user registration facility is available on IRCTC website www.irctc.co.in only.", registrationPage2Activity.getString(R.string.error), registrationPage2Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                TextWatcher textWatcher2 = registrationPage2Activity.f4320a;
                if (textWatcher2 != null) {
                    registrationPage2Activity.pincode.removeTextChangedListener(textWatcher2);
                }
                AlertDialog alertDialog2 = C0535I5.f3619a;
                C0479D5 d52 = new C0479D5(registrationPage2Activity, 6);
                registrationPage2Activity.f4320a = d52;
                registrationPage2Activity.pincode.addTextChangedListener(d52);
                EditText editText2 = (EditText) registrationPage2Activity.findViewById(R.id.et_pincode_reg);
                editText2.setInputType(2);
                editText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
                registrationPage2Activity.othercity.setVisibility(8);
                registrationPage2Activity.state.setEnabled(false);
                registrationPage2Activity.pincode.setText((CharSequence) null);
                registrationPage2Activity.state.setText((CharSequence) null);
                registrationPage2Activity.othercity.setText((CharSequence) null);
                registrationPage2Activity.postoffice.setText(registrationPage2Activity.getString(R.string.post_office));
                registrationPage2Activity.city.setText(registrationPage2Activity.getString(R.string.city));
                registrationPage2Activity.f4325a = false;
                registrationPage2Activity.country.setError(registrationPage2Activity.getString(R.string.Select_Country));
            }
        }
    }

    public class d implements OnSelectionListener {
        public d() {
        }

        public final void onClick(String str) {
            RegistrationPage2Activity registrationPage2Activity = RegistrationPage2Activity.this;
            registrationPage2Activity.city.setText(str);
            registrationPage2Activity.f4322a.dismiss();
            if (!str.equals(registrationPage2Activity.getString(R.string.city))) {
                if (!registrationPage2Activity.h.equals(str)) {
                    registrationPage2Activity.f4328c.clear();
                    registrationPage2Activity.postoffice.setText(registrationPage2Activity.getString(R.string.post_office));
                    registrationPage2Activity.f4319a = ProgressDialog.show(registrationPage2Activity, registrationPage2Activity.getString(R.string.loading), registrationPage2Activity.getString(R.string.please_wait_text));
                    String B = xx.B(registrationPage2Activity.pincode);
                    String trim = registrationPage2Activity.city.getText().toString().trim();
                    String f = C0657Qt.f();
                    String format = String.format("/%s", new Object[]{B});
                    ((Om) C0657Qt.b()).j(f + "pin" + format, trim).c(C1181iv.a()).a(E0.a()).b(new H(registrationPage2Activity));
                    registrationPage2Activity.h = str;
                }
                registrationPage2Activity.f4326b = true;
                registrationPage2Activity.city.setError((CharSequence) null);
                return;
            }
            registrationPage2Activity.f4326b = false;
            registrationPage2Activity.city.setError(registrationPage2Activity.getString(R.string.Select_City));
        }
    }

    public class e implements OnSelectionListener {
        public e() {
        }

        public final void onClick(String str) {
            RegistrationPage2Activity registrationPage2Activity = RegistrationPage2Activity.this;
            registrationPage2Activity.postoffice.setText(str);
            registrationPage2Activity.f4322a.dismiss();
            if (!str.equals(registrationPage2Activity.getString(R.string.post_office))) {
                registrationPage2Activity.postoffice.setError((CharSequence) null);
                registrationPage2Activity.f4329c = true;
                registrationPage2Activity.city.setError((CharSequence) null);
                return;
            }
            registrationPage2Activity.f4329c = false;
            registrationPage2Activity.postoffice.setError(registrationPage2Activity.getString(R.string.Select_Post_Office));
        }
    }

    static {
        C1354qp.R(RegistrationPage2Activity.class);
    }

    public static void l(RegistrationPage2Activity registrationPage2Activity, String str) {
        if (str != null) {
            registrationPage2Activity.getClass();
            if (!str.equals("")) {
                registrationPage2Activity.loading_captcha.setVisibility(8);
                byte[] decode = Base64.decode(str.getBytes(), 0);
                registrationPage2Activity.captcha.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                registrationPage2Activity.captcha.setVisibility(0);
                return;
            }
        }
        registrationPage2Activity.captcha.setVisibility(8);
        registrationPage2Activity.loading_captcha.setVisibility(0);
    }

    public final String A() {
        String obj = this.street.getText().toString();
        if (obj.equalsIgnoreCase("") || obj.length() > 30 || obj.matches(this.f4327c)) {
            return "ok";
        }
        return "Invalid Street/Lane .Only letter, number , spaces and and characters \" , - _ : ) ( / \" are allowed between 3 to 30 character.";
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    @OnFocusChange({2131362517})
    public void et_address(View view) {
        if (!this.address.hasFocus()) {
            String p = p();
            if (p.equalsIgnoreCase("ok")) {
                n(1);
            } else {
                o(1, p);
            }
        }
    }

    @OnFocusChange({2131362518})
    public void et_area(View view) {
        if (!this.area.hasFocus()) {
            String t = t();
            if (t.equalsIgnoreCase("ok")) {
                n(3);
            } else {
                o(3, t);
            }
        }
    }

    @OnFocusChange({2131362540})
    public void et_landline_no(View view) {
        if (!this.landline.hasFocus()) {
            String x = x();
            if (x.equalsIgnoreCase("ok")) {
                n(6);
            } else {
                o(6, x);
            }
        }
    }

    @OnFocusChange({2131362559})
    public void et_other_city(View view) {
        String str;
        if (!this.othercity.hasFocus()) {
            String B = xx.B(this.othercity);
            if (B == null || B.equals("")) {
                str = getString(R.string.City_not_blank);
            } else if (B.length() > 50) {
                str = getString(R.string.city_length_not_more_than_50);
            } else {
                str = "ok";
            }
            if (str.equalsIgnoreCase("ok")) {
                n(4);
            } else {
                o(4, str);
            }
        }
    }

    @OnFocusChange({2131362571})
    public void et_pincode(View view) {
        if (!this.pincode.hasFocus()) {
            String z = z();
            if (z.equalsIgnoreCase("ok")) {
                this.pincode.getText().toString();
                String B = xx.B(this.pincode);
                if (!B.equals(this.g) && B.length() == 6 && this.f.equals("94")) {
                    this.f4319a = ProgressDialog.show(this, getString(R.string.validating_Pin_code), getString(R.string.please_wait_text));
                    this.state.setText((CharSequence) null);
                    this.city.setText(getString(R.string.city));
                    this.postoffice.setText(getString(R.string.post_office));
                    this.f4326b = false;
                    this.f4329c = false;
                    String f2 = C0657Qt.f();
                    String format = String.format("/%s", new Object[]{B});
                    ((Om) C0657Qt.b()).j(f2 + "pin" + format, (String) null).c(C1181iv.a()).a(E0.a()).b(new I(this, B));
                }
                n(7);
                return;
            }
            o(7, z);
        }
    }

    @OnFocusChange({2131362582})
    public void et_state_other(View view) {
        String str;
        if (!this.otherState.hasFocus()) {
            String B = xx.B(this.otherState);
            if (B == null || B.equals("")) {
                str = getString(R.string.State_not_blank);
            } else if (B.length() > 50) {
                str = getString(R.string.State_length_not_more_than_50);
            } else {
                str = "ok";
            }
            if (str.equalsIgnoreCase("ok")) {
                n(5);
            } else {
                o(5, str);
            }
        }
    }

    @OnFocusChange({2131362584})
    public void et_street(View view) {
        if (!this.street.hasFocus()) {
            String A = A();
            if (A.equalsIgnoreCase("ok")) {
                n(2);
            } else {
                o(2, A);
            }
        }
    }

    public final void init() {
        C0535I5.a(this.landline, 10);
        EditText editText = this.address;
        editText.addTextChangedListener(new f(editText));
        EditText editText2 = this.area;
        editText2.addTextChangedListener(new f(editText2));
        EditText editText3 = this.street;
        editText3.addTextChangedListener(new f(editText3));
        EditText editText4 = this.pincode;
        editText4.addTextChangedListener(new f(editText4));
        EditText editText5 = this.landline;
        editText5.addTextChangedListener(new f(editText5));
        this.othercity.setVisibility(8);
        this.othercity.setVisibility(8);
        this.otherState.setVisibility(8);
    }

    @OnClick({2131363104})
    public void loginCaptchaRefresh() {
        m();
    }

    public final void m() {
        if (!C0535I5.O((ConnectivityManager) this.f4321a.getSystemService("connectivity"), this.f4321a)) {
            new Handler().postDelayed(new a(), 5000);
            return;
        }
        ProgressDialog show = ProgressDialog.show(this, getString(R.string.loading), getString(R.string.Loading_Captcha));
        this.f4319a = show;
        show.show();
        this.j = String.valueOf(((long) (new SecureRandom().nextDouble() * 9.0E9d)) + 1000000000);
        String f2 = C0657Qt.f();
        String format = String.format("/%s/%s", new Object[]{this.j, this.k});
        ((Om) C0657Qt.b()).D(f2 + "captchaganetate" + format, (String) null).c(C1181iv.a()).a(E0.a()).b(new b());
        this.captchaInputValue.setText("");
    }

    public final void n(int i2) {
        switch (i2) {
            case 1:
                this.address.setError((CharSequence) null);
                this.address.setTextColor(-16777216);
                return;
            case 2:
                this.street.setError((CharSequence) null);
                this.street.setTextColor(-16777216);
                return;
            case 3:
                this.area.setError((CharSequence) null);
                this.area.setTextColor(-16777216);
                return;
            case 4:
                this.othercity.setError((CharSequence) null);
                this.othercity.setTextColor(-16777216);
                return;
            case 5:
                this.otherState.setError((CharSequence) null);
                this.otherState.setTextColor(-16777216);
                return;
            case 6:
                this.landline.setError((CharSequence) null);
                this.landline.setTextColor(-16777216);
                return;
            case 7:
                this.pincode.setError((CharSequence) null);
                this.pincode.setTextColor(-16777216);
                return;
            default:
                return;
        }
    }

    public final void o(int i2, String str) {
        switch (i2) {
            case 1:
                this.address.setError(str);
                this.address.setTextColor(-65536);
                return;
            case 2:
                this.street.setError(str);
                this.street.setTextColor(-65536);
                return;
            case 3:
                this.area.setError(str);
                this.area.setTextColor(-65536);
                return;
            case 4:
                this.othercity.setError(str);
                this.othercity.setTextColor(-65536);
                return;
            case 5:
                this.otherState.setError(str);
                this.otherState.setTextColor(-65536);
                return;
            case 6:
                this.landline.setError(str);
                this.landline.setTextColor(-65536);
                return;
            case 7:
                this.pincode.setError(str);
                this.pincode.setTextColor(-65536);
                return;
            default:
                return;
        }
    }

    @OnClick({2131362197})
    public void onCityClick(View view) {
        ArrayList<String> arrayList = this.f4323a;
        if (arrayList != null && !arrayList.isEmpty()) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f4322a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f4322a.show(getSupportFragmentManager(), "");
            this.f4322a.setCancelable(true);
            getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), arrayList, new d());
            this.f4322a.g().setText(getString(R.string.Select_City));
            this.f4322a.f().setAdapter(customAdapter);
        }
    }

    @OnClick({2131362319})
    public void onCountryClick(View view) {
        this.f4324a = C0535I5.f3623a;
        this.b = C0535I5.f3622a;
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4322a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4322a.show(getSupportFragmentManager(), "");
        this.f4322a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), this.b, new c());
        this.f4322a.g().setText(getString(R.string.Select_Country));
        this.f4322a.f().setAdapter(customAdapter);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_registration_page2);
        ButterKnife.bind((Activity) this);
        this.f4321a = this;
        C1055ct ctVar = new C1055ct();
        InterstitialAd.load(this, getResources().getString(R.string.register_user_interstitial_add), new AdRequest.Builder().build(), new C0761Ys(ctVar));
        InterstitialAd interstitialAd = a;
        AlertDialog alertDialog = C0535I5.f3619a;
        if (interstitialAd != null) {
            interstitialAd.show(this);
        }
        init();
        C0535I5.Y(this, this.registration_bottom_ads, (GoogleAdParamDTO) null);
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4319a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4319a.dismiss();
        }
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        ProgressDialog progressDialog = this.f4319a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4319a.dismiss();
        }
        C0535I5.u();
    }

    @OnTextChanged({2131362571})
    public void onPinCodeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (this.f.equals("94") && charSequence.length() == 6) {
            this.pincode.clearFocus();
        }
    }

    @OnClick({2131363526})
    public void onPostOfficeClick(View view) {
        ArrayList<String> arrayList = this.f4328c;
        if (arrayList != null && !arrayList.isEmpty()) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f4322a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f4322a.show(getSupportFragmentManager(), "");
            this.f4322a.setCancelable(true);
            getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), arrayList, new e());
            this.f4322a.g().setText(getString(R.string.Select_Post_Office));
            this.f4322a.f().setAdapter(customAdapter);
        }
    }

    @OnClick({2131364500})
    public void onRegisterBtnClick(View view) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String p = p();
        boolean z9 = true;
        if (p.equalsIgnoreCase("ok")) {
            n(1);
            z = true;
        } else {
            o(1, p);
            z = false;
        }
        String A = A();
        if (A.equalsIgnoreCase("ok")) {
            n(2);
            z2 = true;
        } else {
            o(2, A);
            z2 = false;
        }
        String t = t();
        if (t.equalsIgnoreCase("ok")) {
            n(3);
            z3 = true;
        } else {
            o(3, t);
            z3 = false;
        }
        if (!this.f4325a) {
            this.country.setError((CharSequence) null);
            this.country.setError("Select Country");
            z4 = false;
        } else {
            z4 = true;
        }
        if (!this.f4326b) {
            this.city.setError((CharSequence) null);
            this.city.setError("Select City");
            z5 = false;
        } else {
            z5 = true;
        }
        if (!this.f4329c) {
            this.postoffice.setError((CharSequence) null);
            this.postoffice.setError("Select Post Office");
            z6 = false;
        } else {
            z6 = true;
        }
        String x = x();
        if (x.equalsIgnoreCase("ok")) {
            n(6);
            z7 = true;
        } else {
            o(6, x);
            z7 = false;
        }
        String z10 = z();
        if (z10.equalsIgnoreCase("ok")) {
            n(7);
            z8 = true;
        } else {
            o(7, z10);
            z8 = false;
        }
        if (!z || !z2 || !z3 || !z4 || !z5 || !z6 || !z7 || !z8) {
            z9 = false;
        }
        if (z9) {
            JB jb = (JB) getIntent().getExtras().getSerializable("reg1");
            this.f4318a = jb;
            jb.setAddress(this.address.getText().toString().trim());
            this.f4318a.setStreet(this.street.getText().toString().trim());
            this.f4318a.setArea(this.area.getText().toString().trim());
            this.f4318a.setCountryId(Short.valueOf(this.f));
            this.f4318a.setPinCode(this.pincode.getText().toString().trim());
            this.f4318a.setLandlineNumber(this.landline.getText().toString().trim());
            this.f4318a.setRegistrationSource(Short.valueOf((short) 4));
            this.f4318a.setState(this.state.getText().toString().trim());
            this.f4318a.setCity(this.city.getText().toString().trim());
            this.f4318a.setPostOffice(this.postoffice.getText().toString().trim());
            if (this.sameoffice.isChecked()) {
                this.f4318a.setCopyAddressResToOff("Y");
                InterstitialAd interstitialAd = a;
                AlertDialog alertDialog = C0535I5.f3619a;
                if (interstitialAd != null) {
                    interstitialAd.show(this);
                }
                if (!C0535I5.O((ConnectivityManager) this.f4321a.getSystemService("connectivity"), this.f4321a)) {
                    new Handler().postDelayed(new Zs(), 5000);
                    return;
                }
                if (10 == this.c) {
                    String B = xx.B(this.captchaInputValue);
                    this.i = B;
                    if (B == null || B.equals("")) {
                        C0535I5.t0(getBaseContext(), getString(R.string.provide_captcha));
                        return;
                    }
                    this.f4318a.setCaptcha(this.i);
                }
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage(getString(R.string.please_wait_text));
                progressDialog.setTitle(getString(R.string.registration_progress));
                progressDialog.setProgressStyle(0);
                progressDialog.show();
                ((Om) C0657Qt.b()).V(C1058d.z(C0657Qt.f(), "registerUser"), this.f4318a).c(C1181iv.a()).a(E0.a()).b(new J(this, progressDialog));
                return;
            }
            this.f4318a.setCopyAddressResToOff("N");
            Intent intent = new Intent(getBaseContext(), RegistrationPage3Activity.class);
            intent.putExtra("reg2", this.f4318a);
            intent.putExtra("countryList", this.b);
            intent.putExtra("nationalityMap", this.f4324a);
            startActivity(intent);
        }
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4319a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4319a.dismiss();
        }
        C0535I5.u();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @OnClick({2131364713})
    public void onUserGuideClick() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://contents.irctc.co.in/en/UserGuideIRCTC.pdf"));
        startActivity(intent);
    }

    public final String p() {
        String obj = this.address.getText().toString();
        if (obj.equalsIgnoreCase("")) {
            return getString(R.string.Enter_Address);
        }
        if (obj.matches(this.d)) {
            return "ok";
        }
        return getString(R.string.invalid_character);
    }

    @OnClick({2131362148})
    public void sameOfficeAddress() {
        if (this.sameoffice.isChecked()) {
            this.nextBtn.setText(getString(R.string.register));
            this.captch_ll.setVisibility(0);
            this.k = "REGISTRATION";
            m();
            return;
        }
        this.nextBtn.setText(getString(R.string.next));
        this.captch_ll.setVisibility(8);
    }

    public final String t() {
        String obj = this.area.getText().toString();
        if (obj.equalsIgnoreCase("") || obj.length() > 30 || obj.matches(this.f4327c)) {
            return "ok";
        }
        return "Invalid Street/Lane .Only letter, number , spaces and and characters \" , - _ : ) ( / \" are allowed between 3 to 30 character.";
    }

    public final String x() {
        this.landline.getText().toString();
        String obj = this.landline.getText().toString();
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

    public final String z() {
        String B = xx.B(this.pincode);
        if (B == null || B.equals("")) {
            return getString(R.string.Pin_code_not_blank);
        }
        if (B.matches(this.e)) {
            return getString(R.string.zero_not_allowed);
        }
        if (B.length() != 6) {
            return "Pin code must be 6 characters.";
        }
        return "ok";
    }

    public class a implements Runnable {
        public final void run() {
        }
    }

    public class f implements TextWatcher {
        public final View a;

        public f(EditText editText) {
            this.a = editText;
        }

        public final void afterTextChanged(Editable editable) {
            editable.toString();
            this.a.getId();
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2;
            String charSequence3;
            String charSequence4;
            View view = this.a;
            int id = view.getId();
            RegistrationPage2Activity registrationPage2Activity = RegistrationPage2Activity.this;
            if (id == R.id.et_area_reg && (charSequence4 = charSequence.toString()) != null && charSequence4.length() > 0 && charSequence4.charAt(0) == ' ') {
                registrationPage2Activity.area.setError("Space not allowed");
            }
            if (view.getId() == R.id.et_street_reg && (charSequence3 = charSequence.toString()) != null && charSequence3.length() > 0 && charSequence3.charAt(0) == ' ') {
                registrationPage2Activity.street.setError("Space not allowed");
            }
            if (view.getId() == R.id.et_address_reg && (charSequence2 = charSequence.toString()) != null && charSequence2.length() > 0 && charSequence2.charAt(0) == ' ') {
                registrationPage2Activity.address.setError("Space not allowed");
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
