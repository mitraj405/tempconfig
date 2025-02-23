package cris.org.in.ima.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.h;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import java.util.concurrent.Executor;
import rx.Subscriber;

public class PinGenerationActivity extends AppCompatActivity {
    public static final /* synthetic */ int e = 0;
    public Executor a;
    public final int c = 4;
    public int d = 0;
    @BindView(2131362569)
    EditText editTextPin;
    @BindView(2131362575)
    EditText editTextReEnterPin;
    @SuppressLint({"UseSwitchCompatOrMaterialCode"})
    @BindView(2131362666)
    Switch fingerAuthSwitch;
    @BindView(2131363728)
    RelativeLayout fingerprintAuthenticationLayout;
    @BindView(2131363504)
    AdManagerAdView pingeneration_bottom_ads;

    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ View a;

        public class a implements Runnable {
            public final /* synthetic */ ProgressDialog a;

            public a(ProgressDialog progressDialog) {
                this.a = progressDialog;
            }

            public final void run() {
                ProgressDialog progressDialog;
                b bVar = b.this;
                View view = bVar.a;
                if (view != null && view.isShown() && (progressDialog = this.a) != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                PinGenerationActivity pinGenerationActivity = PinGenerationActivity.this;
                String obj = pinGenerationActivity.editTextPin.getText().toString();
                String obj2 = pinGenerationActivity.editTextReEnterPin.getText().toString();
                if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2)) {
                    C0535I5.t0(pinGenerationActivity.getBaseContext(), pinGenerationActivity.getString(R.string.emptypin));
                } else if (obj.trim().length() != 4) {
                    C0535I5.t0(pinGenerationActivity.getBaseContext(), pinGenerationActivity.getString(R.string.fourdigitpin));
                } else if (obj.equals(obj2)) {
                    Bw.e(pinGenerationActivity.getApplicationContext()).C(obj);
                    pinGenerationActivity.finish();
                    if (pinGenerationActivity.d == 0) {
                        Intent intent = new Intent(pinGenerationActivity, HomeActivity.class);
                        intent.putExtra("isDashBoardLanding", pinGenerationActivity.d);
                        pinGenerationActivity.startActivity(intent);
                    }
                } else {
                    C0535I5.t0(pinGenerationActivity.getBaseContext(), pinGenerationActivity.getString(R.string.notmatchping));
                }
            }
        }

        public b(View view) {
            this.a = view;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            PinGenerationActivity pinGenerationActivity = PinGenerationActivity.this;
            C0816cB cBVar = new C0816cB(new a(ProgressDialog.show(pinGenerationActivity, "", pinGenerationActivity.getString(R.string.please_wait_text))), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
            pinGenerationActivity.getClass();
            cBVar.a();
        }
    }

    public class d extends BiometricPrompt.a {
        public final /* synthetic */ Bw a;

        public d(Bw bw) {
            this.a = bw;
        }

        public final void a(int i) {
            this.a.w("OFF");
            PinGenerationActivity pinGenerationActivity = PinGenerationActivity.this;
            pinGenerationActivity.fingerAuthSwitch.setChecked(false);
            if (i == 11) {
                Toast.makeText(pinGenerationActivity.getBaseContext(), pinGenerationActivity.getResources().getString(R.string.biometric_authentication_disable_msg), 0).show();
            } else {
                Toast.makeText(pinGenerationActivity.getBaseContext(), pinGenerationActivity.getResources().getString(R.string.biometric_register_error), 0).show();
            }
        }

        public final void b() {
            this.a.w("OFF");
            PinGenerationActivity.this.fingerAuthSwitch.setChecked(false);
        }

        public final void c() {
            PinGenerationActivity pinGenerationActivity = PinGenerationActivity.this;
            ProgressDialog show = ProgressDialog.show(pinGenerationActivity, "Loading...", pinGenerationActivity.getString(R.string.please_wait_text));
            String l = C0657Qt.l();
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).e(l + "registerBiomatric").c(C1181iv.a()).a(E0.a()).b(new C(this, show));
        }
    }

    static {
        C1354qp.R(PinGenerationActivity.class);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    @OnClick({2131362666})
    public void authFingerSwitch() {
        Bw e2 = Bw.e(getApplicationContext());
        if (this.fingerAuthSwitch.isChecked()) {
            e2.w("ON");
            Executor d2 = d7.d(getApplicationContext());
            this.a = d2;
            BiometricPrompt biometricPrompt = new BiometricPrompt((FragmentActivity) this, d2, (BiometricPrompt.a) new d(e2));
            BiometricPrompt.d.a aVar = new BiometricPrompt.d.a();
            aVar.a = getString(R.string.activate_biometric);
            aVar.b = getString(R.string.CANCEL);
            BiometricPrompt.d a2 = aVar.a();
            if (e2.c().equalsIgnoreCase("ON")) {
                biometricPrompt.a(a2);
                return;
            }
            return;
        }
        Toast.makeText(getBaseContext(), getResources().getString(R.string.biometric_disabled), 0).show();
        e2.w("OFF");
        this.fingerAuthSwitch.setChecked(false);
    }

    public final void init() {
        this.editTextPin.addTextChangedListener(new c());
        EditText editText = this.editTextReEnterPin;
        AlertDialog alertDialog = C0535I5.f3619a;
        editText.addTextChangedListener(new C0479D5(this, this.c));
    }

    public final boolean l() {
        if (this.editTextPin.getText().toString().trim().length() != 4) {
            C0535I5.t0(this, getString(R.string.fourdigitpin));
            this.editTextPin.setError(getString(R.string.fourdigitpin));
            return false;
        }
        this.editTextPin.setError((CharSequence) null);
        return true;
    }

    public final boolean m() {
        String obj = this.editTextReEnterPin.getText().toString();
        String obj2 = this.editTextPin.getText().toString();
        if (obj.trim().length() != 4) {
            this.editTextReEnterPin.setText((CharSequence) null);
            C0535I5.t0(getBaseContext(), getString(R.string.fourdigitpin));
            this.editTextReEnterPin.setError(getString(R.string.fourdigitpin));
            return false;
        } else if (!obj2.equals(obj)) {
            this.editTextReEnterPin.setText((CharSequence) null);
            this.editTextReEnterPin.setError(getString(R.string.notmatchping));
            return false;
        } else {
            this.editTextReEnterPin.setError((CharSequence) null);
            return true;
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

    @OnClick({2131363010})
    public void onBUSAppClick(View view) {
        try {
            startActivity(Intent.parseUri("https://www.bus.irctc.co.in/home?utm_source=confirm", 1));
        } catch (Exception unused) {
            C0535I5.t0(getApplicationContext(), getString(R.string.error_opening_air_app));
        }
    }

    public final void onBackPressed() {
        try {
            C0535I5.p(this, true, getString(R.string.you_will_logged_out), getString(R.string.logout_alerts), getString(R.string.yes), new e(), getString(R.string.no), (DialogInterface.OnClickListener) null).show();
        } catch (Exception e2) {
            e2.getMessage();
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

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activty_pin_generation);
        ButterKnife.bind((Activity) this);
        if (getIntent().getExtras() != null) {
            this.d = getIntent().getExtras().getInt("isDashBoardLanding");
        }
        C0535I5.Y(this, this.pingeneration_bottom_ads, (GoogleAdParamDTO) null);
        init();
        Bw e2 = Bw.e(this);
        this.fingerAuthSwitch.setChecked(false);
        e2.w("OFF");
        int a2 = new h(new h.c(this)).a(32783);
        if (a2 == 0) {
            return;
        }
        if (a2 == 1) {
            this.fingerprintAuthenticationLayout.setVisibility(8);
        } else if (a2 == 11) {
            this.fingerprintAuthenticationLayout.setVisibility(8);
        } else if (a2 != 12) {
            this.fingerprintAuthenticationLayout.setVisibility(0);
        } else {
            this.fingerprintAuthenticationLayout.setVisibility(8);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    @OnTextChanged({2131362575})
    public void onPinCodeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 4 && m()) {
            EditText editText = this.editTextReEnterPin;
            AlertDialog alertDialog = C0535I5.f3619a;
            editText.addTextChangedListener(new C0479D5(this, 4));
        }
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onStop() {
        super.onStop();
    }

    @OnClick({2131364622})
    public void onSubmitClick(View view) {
        if (l() && m() && C0535I5.O((ConnectivityManager) getSystemService("connectivity"), getBaseContext())) {
            C0535I5.p(this, false, getString(R.string.pin_remenber_msg), getString(R.string.remember_PIN), getString(R.string.OK), new b(view), (String) null, (DialogInterface.OnClickListener) null).show();
        }
    }

    @OnClick({2131363736})
    public void onTourismAppClick(View view) {
        try {
            startActivity(Intent.parseUri("https://www.irctctourism.com/?utm_source=confirm", 1));
        } catch (Exception unused) {
            C0535I5.t0(getApplicationContext(), getString(R.string.error_opening_air_app));
        }
    }

    @OnClick({2131364713})
    public void onUserGuideClick() {
        if (!C0535I5.O((ConnectivityManager) getApplication().getSystemService("connectivity"), getApplication())) {
            new Handler().postDelayed(new a(), 5000);
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

    @OnClick({2131363734})
    public void onhotelAppClick(View view) {
        try {
            startActivity(Intent.parseUri("https://www.hotels.irctc.co.in/hotel?utm_source=confirm", 1));
        } catch (Exception unused) {
            C0535I5.t0(getApplicationContext(), getString(R.string.error_opening_air_app));
        }
    }

    @OnFocusChange({2131362569})
    public void validatePin(View view) {
        if (!this.editTextPin.hasFocus()) {
            l();
        }
    }

    @OnFocusChange({2131362575})
    public void validateRePin(View view) {
        if (!this.editTextReEnterPin.hasFocus()) {
            m();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            String f = C0657Qt.f();
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).t0(f + "logout").c(C1181iv.a()).a(E0.a()).b(new a());
        }

        public class a extends Subscriber<Boolean> {
            public a() {
            }

            public final void onError(Throwable th) {
                int i = PinGenerationActivity.e;
                th.getMessage();
                C0535I5.v(PinGenerationActivity.this);
            }

            public final void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                int i = PinGenerationActivity.e;
                C0535I5.v(PinGenerationActivity.this);
            }

            public final void onCompleted() {
            }
        }
    }

    public class a implements Runnable {
        public final void run() {
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = charSequence.length();
            PinGenerationActivity pinGenerationActivity = PinGenerationActivity.this;
            if (length == pinGenerationActivity.c) {
                pinGenerationActivity.editTextReEnterPin.requestFocus();
            }
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
