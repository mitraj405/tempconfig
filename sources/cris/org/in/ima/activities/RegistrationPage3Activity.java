package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
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
import android.view.View;
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

public class RegistrationPage3Activity extends AppCompatActivity {
    public static InterstitialAd a;

    /* renamed from: a  reason: collision with other field name */
    public JB f4333a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4334a = null;

    /* renamed from: a  reason: collision with other field name */
    public TextWatcher f4335a = null;

    /* renamed from: a  reason: collision with other field name */
    public RegistrationPage3Activity f4336a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4337a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4338a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, String> f4339a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4340a = false;
    @BindView(2131362550)
    EditText address;
    @BindView(2131362551)
    EditText area;
    public RegistrationPage3Activity b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<String> f4341b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public boolean f4342b = false;
    public int c = -1;

    /* renamed from: c  reason: collision with other field name */
    public final String f4343c = "^[0-9a-zA-Z]{1}[0-9a-zA-Z\\s,\\-_:()\\/]{2,29}$";

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<String> f4344c = new ArrayList<>();

    /* renamed from: c  reason: collision with other field name */
    public boolean f4345c = false;
    @BindView(2131362124)
    LinearLayout captch_ll;
    @BindView(2131362125)
    ImageView captcha;
    @BindView(2131364327)
    EditText captchaInputValue;
    @BindView(2131363354)
    TextView city;
    @BindView(2131363355)
    TextView country;
    public final String d = "^[0-9a-zA-Z]{1}[0-9a-zA-Z\\s,\\-_:()\\/]{2,224}$";

    /* renamed from: d  reason: collision with other field name */
    public boolean f4346d = false;
    public final String e = "^[0]+$";
    public String f = "-1";
    public String g = "";
    public String h = "";
    public String i;
    public String j;
    public String k = "REGISTRATION";
    @BindView(2131362552)
    EditText landline;
    @BindView(2131364466)
    TextView loading_captcha;
    @BindView(2131363104)
    ImageView loginCaptchaRefresh;
    @BindView(2131363277)
    AdManagerAdView mPublisherAdview;
    @BindView(2131364561)
    TextView nextBtn;
    @BindView(2131362555)
    EditText otherState;
    @BindView(2131362553)
    EditText othercity;
    @BindView(2131362554)
    EditText pincode;
    @BindView(2131363356)
    TextView postoffice;
    @BindView(2131363643)
    AdManagerAdView registration_bottom_ads;
    @BindView(2131363687)
    LinearLayout residence;
    @BindView(2131363688)
    LinearLayout residence_ll;
    @BindView(2131362556)
    TextView state;
    @BindView(2131362557)
    EditText street;
    @BindView(2131364795)
    TextView userStatusverify;

    public class a extends Subscriber<E4> {
        public a() {
        }

        public final void onCompleted() {
            InterstitialAd interstitialAd = RegistrationPage3Activity.a;
            RegistrationPage3Activity.this.f4334a.dismiss();
        }

        public final void onError(Throwable th) {
            InterstitialAd interstitialAd = RegistrationPage3Activity.a;
            th.getClass();
            th.getMessage();
            RegistrationPage3Activity.this.f4334a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            E4 e4 = (E4) obj;
            RegistrationPage3Activity registrationPage3Activity = RegistrationPage3Activity.this;
            if (e4 != null) {
                C0657Qt.h();
                try {
                    if (e4.getError() == null) {
                        registrationPage3Activity.c = e4.getCaptcha().intValue();
                        registrationPage3Activity.f4334a.dismiss();
                        C1450w1.f7025d = System.currentTimeMillis();
                        if (10 == registrationPage3Activity.c) {
                            RegistrationPage3Activity.l(registrationPage3Activity, e4.getCaptchaQuestion());
                        } else {
                            C0535I5.t0(registrationPage3Activity.getBaseContext(), registrationPage3Activity.getString(R.string.Unable_process_request));
                        }
                    } else {
                        registrationPage3Activity.f4334a.dismiss();
                        C0535I5.m(registrationPage3Activity.f4336a, false, e4.getError(), registrationPage3Activity.getString(R.string.error), registrationPage3Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    }
                } catch (Exception e) {
                    registrationPage3Activity.f4334a.dismiss();
                    InterstitialAd interstitialAd = RegistrationPage3Activity.a;
                    e.getMessage();
                }
            } else {
                registrationPage3Activity.f4334a.dismiss();
                C0535I5.m(registrationPage3Activity.f4336a, false, registrationPage3Activity.getResources().getString(R.string.unable_process_message), registrationPage3Activity.getString(R.string.error), registrationPage3Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class b implements OnSelectionListener {
        public b() {
        }

        public final void onClick(String str) {
            RegistrationPage3Activity registrationPage3Activity = RegistrationPage3Activity.this;
            String str2 = registrationPage3Activity.f;
            registrationPage3Activity.f = registrationPage3Activity.f4339a.get(str);
            registrationPage3Activity.f4337a.dismiss();
            if (!registrationPage3Activity.f.equals(str2)) {
                registrationPage3Activity.country.setText(str);
                registrationPage3Activity.country.setError((CharSequence) null);
                registrationPage3Activity.f4338a.clear();
                registrationPage3Activity.f4344c.clear();
                if (!registrationPage3Activity.f.equals("-1")) {
                    registrationPage3Activity.pincode.setVisibility(0);
                    if (registrationPage3Activity.f.equals("94")) {
                        registrationPage3Activity.othercity.setVisibility(8);
                        registrationPage3Activity.state.setEnabled(false);
                        registrationPage3Activity.pincode.setText((CharSequence) null);
                        registrationPage3Activity.pincode.setEnabled(true);
                        TextWatcher textWatcher = registrationPage3Activity.f4335a;
                        if (textWatcher != null) {
                            registrationPage3Activity.pincode.removeTextChangedListener(textWatcher);
                        }
                        AlertDialog alertDialog = C0535I5.f3619a;
                        registrationPage3Activity.f4335a = new C0479D5(registrationPage3Activity, 6);
                        EditText editText = (EditText) registrationPage3Activity.findViewById(R.id.et_office_pincode_reg);
                        editText.setInputType(2);
                        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
                        registrationPage3Activity.state.setText((CharSequence) null);
                        registrationPage3Activity.othercity.setText((CharSequence) null);
                        registrationPage3Activity.postoffice.setText(registrationPage3Activity.getString(R.string.post_office));
                        registrationPage3Activity.city.setText(registrationPage3Activity.getString(R.string.post_office));
                        registrationPage3Activity.f4340a = true;
                        return;
                    }
                    C0535I5.m(registrationPage3Activity, false, "International user registration facility is available on IRCTC website www.irctc.co.in only.", registrationPage3Activity.getString(R.string.error), registrationPage3Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                TextWatcher textWatcher2 = registrationPage3Activity.f4335a;
                if (textWatcher2 != null) {
                    registrationPage3Activity.pincode.removeTextChangedListener(textWatcher2);
                }
                AlertDialog alertDialog2 = C0535I5.f3619a;
                registrationPage3Activity.f4335a = new C0479D5(registrationPage3Activity, 6);
                registrationPage3Activity.othercity.setVisibility(8);
                registrationPage3Activity.otherState.setVisibility(8);
                registrationPage3Activity.state.setEnabled(false);
                registrationPage3Activity.pincode.setText((CharSequence) null);
                registrationPage3Activity.state.setText((CharSequence) null);
                registrationPage3Activity.othercity.setText((CharSequence) null);
                registrationPage3Activity.postoffice.setText(registrationPage3Activity.getString(R.string.post_office));
                registrationPage3Activity.city.setText(registrationPage3Activity.getString(R.string.post_office));
                registrationPage3Activity.f4340a = false;
                registrationPage3Activity.country.setError(registrationPage3Activity.getString(R.string.Select_Country));
            }
        }
    }

    public class c implements OnSelectionListener {
        public c() {
        }

        public final void onClick(String str) {
            RegistrationPage3Activity registrationPage3Activity = RegistrationPage3Activity.this;
            registrationPage3Activity.city.setText(str);
            registrationPage3Activity.f4337a.dismiss();
            if (!str.equals("City")) {
                if (!registrationPage3Activity.h.equals(str)) {
                    registrationPage3Activity.f4344c.clear();
                    registrationPage3Activity.postoffice.setText(registrationPage3Activity.getString(R.string.post_office));
                    registrationPage3Activity.f4334a = ProgressDialog.show(registrationPage3Activity, registrationPage3Activity.getString(R.string.loading), registrationPage3Activity.getString(R.string.please_wait_text));
                    String B = xx.B(registrationPage3Activity.pincode);
                    String trim = registrationPage3Activity.city.getText().toString().trim();
                    String f = C0657Qt.f();
                    String format = String.format("/%s", new Object[]{B});
                    ((Om) C0657Qt.b()).j(f + "pin" + format, trim).c(C1181iv.a()).a(E0.a()).b(new K(registrationPage3Activity));
                    registrationPage3Activity.h = str;
                }
                registrationPage3Activity.f4342b = true;
                registrationPage3Activity.city.setError((CharSequence) null);
                return;
            }
            registrationPage3Activity.f4342b = false;
            registrationPage3Activity.city.setError(registrationPage3Activity.getString(R.string.Select_City));
        }
    }

    public class d implements OnSelectionListener {
        public d() {
        }

        public final void onClick(String str) {
            RegistrationPage3Activity registrationPage3Activity = RegistrationPage3Activity.this;
            registrationPage3Activity.postoffice.setText(str);
            registrationPage3Activity.f4337a.dismiss();
            if (!str.equals("Post Office")) {
                registrationPage3Activity.postoffice.setError((CharSequence) null);
                registrationPage3Activity.f4345c = true;
                registrationPage3Activity.city.setError((CharSequence) null);
                return;
            }
            registrationPage3Activity.f4345c = false;
            registrationPage3Activity.postoffice.setError(registrationPage3Activity.getString(R.string.Select_Post_Office));
        }
    }

    static {
        C1354qp.R(RegistrationPage3Activity.class);
    }

    public static void l(RegistrationPage3Activity registrationPage3Activity, String str) {
        registrationPage3Activity.captch_ll.setVisibility(0);
        if (str == null || str.equals("")) {
            registrationPage3Activity.captcha.setVisibility(8);
            registrationPage3Activity.loading_captcha.setVisibility(0);
            return;
        }
        registrationPage3Activity.loading_captcha.setVisibility(8);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        registrationPage3Activity.captcha.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        registrationPage3Activity.captcha.setVisibility(0);
    }

    @OnFocusChange({2131362550})
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

    @OnFocusChange({2131362552})
    public void et_landline_no(View view) {
        if (!this.landline.hasFocus()) {
            String t = t();
            if (t.equalsIgnoreCase("ok")) {
                n(6);
            } else {
                o(6, t);
            }
        }
    }

    @OnFocusChange({2131362553})
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

    @OnFocusChange({2131362554})
    public void et_pincode(View view) {
        if (!this.pincode.hasFocus()) {
            String x = x();
            if (x.equalsIgnoreCase("ok")) {
                this.pincode.getText().toString();
                String B = xx.B(this.pincode);
                if (!B.equals(this.g) && B.length() == 6 && this.f.equals("94")) {
                    this.f4334a = ProgressDialog.show(this, getString(R.string.validating_Pin_code), getString(R.string.please_wait_text));
                    this.state.setText((CharSequence) null);
                    this.city.setText(getString(R.string.post_office));
                    this.postoffice.setText(getString(R.string.post_office));
                    this.f4342b = false;
                    this.f4345c = false;
                    String f2 = C0657Qt.f();
                    String format = String.format("/%s", new Object[]{B});
                    ((Om) C0657Qt.b()).j(f2 + "pin" + format, (String) null).c(C1181iv.a()).a(E0.a()).b(new L(this, B));
                }
                n(7);
                return;
            }
            o(7, x);
        }
    }

    @OnFocusChange({2131362555})
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

    @OnFocusChange({2131362557})
    public void et_street(View view) {
        if (!this.street.hasFocus()) {
            String z = z();
            if (z.equalsIgnoreCase("ok")) {
                n(2);
            } else {
                o(2, z);
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
        this.otherState.setVisibility(8);
    }

    @OnClick({2131363104})
    public void loginCaptchaRefresh() {
        m();
    }

    public final void m() {
        if (!C0535I5.O((ConnectivityManager) this.f4336a.getSystemService("connectivity"), this.f4336a)) {
            new Handler().postDelayed(new e(), 5000);
            return;
        }
        ProgressDialog show = ProgressDialog.show(this, getString(R.string.loading), getString(R.string.Loading_Captcha));
        this.f4334a = show;
        show.show();
        this.j = String.valueOf(((long) (new SecureRandom().nextDouble() * 9.0E9d)) + 1000000000);
        String f2 = C0657Qt.f();
        String format = String.format("/%s/%s", new Object[]{this.j, this.k});
        ((Om) C0657Qt.b()).D(f2 + "captchaganetate" + format, (String) null).c(C1181iv.a()).a(E0.a()).b(new a());
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

    public final void onBackPressed() {
        if (!this.f4346d) {
            super.onBackPressed();
        }
    }

    @OnClick({2131363354})
    public void onCityClick(View view) {
        ArrayList<String> arrayList = this.f4338a;
        if (arrayList != null && !arrayList.isEmpty()) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f4337a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f4337a.show(getSupportFragmentManager(), "");
            this.f4337a.setCancelable(true);
            getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), arrayList, new c());
            this.f4337a.g().setText(getString(R.string.Select_City));
            this.f4337a.f().setAdapter(customAdapter);
        }
    }

    @OnClick({2131363355})
    public void onCountryClick(View view) {
        this.f4339a = C0535I5.f3623a;
        this.f4341b = C0535I5.f3622a;
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4337a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4337a.show(getSupportFragmentManager(), "");
        this.f4337a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), this.f4341b, new b());
        this.f4337a.g().setText(getString(R.string.Select_Country));
        this.f4337a.f().setAdapter(customAdapter);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_registration_page3);
        ButterKnife.bind((Activity) this);
        this.f4336a = this;
        this.b = this;
        C1076dt dtVar = new C1076dt();
        InterstitialAd.load(this, getResources().getString(R.string.register_user_interstitial_add), new AdRequest.Builder().build(), new C1094et(dtVar));
        InterstitialAd interstitialAd = a;
        AlertDialog alertDialog = C0535I5.f3619a;
        if (interstitialAd != null) {
            interstitialAd.show(this);
        }
        init();
        this.k = "REGISTRATION";
        m();
        C0535I5.Y(this, this.registration_bottom_ads, (GoogleAdParamDTO) null);
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4334a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4334a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363360})
    public void onOKClick(View view) {
        startActivity(new Intent(getBaseContext(), LoginActivity.class));
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        ProgressDialog progressDialog = this.f4334a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4334a.dismiss();
        }
        C0535I5.u();
    }

    @OnTextChanged({2131362554})
    public void onPinCodeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (this.f.equals("94") && charSequence.length() == 6) {
            this.pincode.clearFocus();
        }
    }

    @OnClick({2131363356})
    public void onPostOfficeClick(View view) {
        ArrayList<String> arrayList = this.f4344c;
        if (arrayList != null && !arrayList.isEmpty()) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f4337a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f4337a.show(getSupportFragmentManager(), "");
            this.f4337a.setCancelable(true);
            getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), arrayList, new d());
            this.f4337a.g().setText(getString(R.string.Select_Post_Office));
            this.f4337a.f().setAdapter(customAdapter);
        }
    }

    @OnClick({2131364561})
    public void onRegisterBtnClick(View view) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String p = p();
        boolean z8 = true;
        if (p.equalsIgnoreCase("ok")) {
            n(1);
            z = true;
        } else {
            o(1, p);
            z = false;
        }
        String z9 = z();
        if (z9.equalsIgnoreCase("ok")) {
            n(2);
            z2 = true;
        } else {
            o(2, z9);
            z2 = false;
        }
        if (!this.f4340a) {
            this.country.setError((CharSequence) null);
            this.country.setError("Select Country");
            z3 = false;
        } else {
            z3 = true;
        }
        if (!this.f4342b) {
            this.city.setError((CharSequence) null);
            this.city.setError("Select City");
            z4 = false;
        } else {
            z4 = true;
        }
        if (!this.f4345c) {
            this.postoffice.setError((CharSequence) null);
            this.postoffice.setError("Select Post Office");
            z5 = false;
        } else {
            z5 = true;
        }
        String t = t();
        if (t.equalsIgnoreCase("ok")) {
            n(6);
            z6 = true;
        } else {
            o(6, t);
            z6 = false;
        }
        String x = x();
        if (x.equalsIgnoreCase("ok")) {
            n(7);
            z7 = true;
        } else {
            o(7, x);
            z7 = false;
        }
        if (!z || !z2 || !z3 || !z4 || !z5 || !z6 || !z7) {
            z8 = false;
        }
        if (z8) {
            JB jb = (JB) getIntent().getExtras().getSerializable("reg2");
            this.f4333a = jb;
            jb.setOff_Address(this.address.getText().toString().trim());
            this.f4333a.setOff_Street(this.street.getText().toString().trim());
            this.f4333a.setOff_area(this.area.getText().toString().trim());
            this.f4333a.setOff_CountryId(Short.valueOf(this.f));
            this.f4333a.setOff_PinCode(this.pincode.getText().toString().trim());
            this.f4333a.setOff_LandlineNumber(this.landline.getText().toString().trim());
            this.f4333a.setRegistrationSource(Short.valueOf((short) 4));
            this.f4333a.setOff_State(this.state.getText().toString().trim());
            this.f4333a.setOff_City(this.city.getText().toString().trim());
            this.f4333a.setOff_PostOffice(this.postoffice.getText().toString().trim());
            InterstitialAd interstitialAd = a;
            AlertDialog alertDialog = C0535I5.f3619a;
            if (interstitialAd != null) {
                interstitialAd.show(this);
            }
            if (!C0535I5.O((ConnectivityManager) this.f4336a.getSystemService("connectivity"), this.f4336a)) {
                new Handler().postDelayed(new C1119ft(), 5000);
                return;
            }
            if (10 == this.c) {
                String B = xx.B(this.captchaInputValue);
                this.i = B;
                if (B == null || B.equals("")) {
                    C0535I5.t0(getBaseContext(), getString(R.string.provide_captcha));
                    return;
                }
                this.f4333a.setCaptcha(this.i);
            }
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(getString(R.string.please_wait_text));
            progressDialog.setTitle(getString(R.string.registration_progress));
            progressDialog.setProgressStyle(0);
            progressDialog.show();
            ((Om) C0657Qt.b()).V(C1058d.z(C0657Qt.f(), "registerUser"), this.f4333a).c(C1181iv.a()).a(E0.a()).b(new M(this, progressDialog));
        }
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4334a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4334a.dismiss();
        }
        C0535I5.u();
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

    public final String t() {
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

    public final String x() {
        String B = xx.B(this.pincode);
        if (B == null || B.equals("")) {
            return getString(R.string.Pin_code_not_blank);
        }
        if (B.matches(this.e)) {
            return getString(R.string.zero_not_allowed);
        }
        if (B.length() != 6) {
            return getString(R.string.PincodeError);
        }
        return "ok";
    }

    public final String z() {
        String obj = this.street.getText().toString();
        if (obj.equalsIgnoreCase("") || obj.length() > 30 || obj.matches(this.f4343c)) {
            return "ok";
        }
        return "Invalid Street/Lane .Only letter, number , spaces and and characters \" , - _ : ) ( / \" are allowed between 3 to 30 character.";
    }

    public class e implements Runnable {
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
            RegistrationPage3Activity registrationPage3Activity = RegistrationPage3Activity.this;
            if (id == R.id.et_area_reg && (charSequence4 = charSequence.toString()) != null && charSequence4.length() > 0 && charSequence4.charAt(0) == ' ') {
                registrationPage3Activity.area.setError("Space not allowed");
            }
            if (view.getId() == R.id.et_street_reg && (charSequence3 = charSequence.toString()) != null && charSequence3.length() > 0 && charSequence3.charAt(0) == ' ') {
                registrationPage3Activity.street.setError("Space not allowed");
            }
            if (view.getId() == R.id.et_address_reg && (charSequence2 = charSequence.toString()) != null && charSequence2.length() > 0 && charSequence2.charAt(0) == ' ') {
                registrationPage3Activity.address.setError("Space not allowed");
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
