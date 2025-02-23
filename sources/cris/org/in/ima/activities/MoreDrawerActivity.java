package cris.org.in.ima.activities;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.h;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.ima.FeedbackActivity;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.fragment.AboutUsFragment;
import cris.org.in.ima.fragment.ContactUsFragment;
import cris.org.in.ima.fragment.VikalpSystemFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.InformationMessageDTO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;

public class MoreDrawerActivity extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f4263a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentManager f4264a;

    /* renamed from: a  reason: collision with other field name */
    public Executor f4265a;

    /* renamed from: c  reason: collision with other field name */
    public final String f4266c = String.valueOf(5);
    @BindView(2131362495)
    TextView english;
    @BindView(2131363727)
    RelativeLayout feedback;
    @BindView(2131362666)
    Switch fingerAuthSwitch;
    @BindView(2131363728)
    RelativeLayout fingerprintAuthenticationLayout;
    @BindView(2131362778)
    TextView hindi;
    @BindView(2131362909)
    ImageView iv_spinner_aarogya_setu;
    @BindView(2131362931)
    TextView langauge;
    @BindView(2131362932)
    RelativeLayout langauge_layout;
    @BindView(2131363704)
    RelativeLayout rl_aarogya_setu;
    @BindView(2131363705)
    RelativeLayout rl_aarogya_setu_expand;
    @BindView(2131363735)
    RelativeLayout rl_integrityPledge;
    @BindView(2131364386)
    TextView tv_download_aarogya_setu;
    @BindView(2131364453)
    RelativeLayout tv_langauge;

    public class a extends BiometricPrompt.a {
        public final /* synthetic */ Bw a;

        public a(Bw bw) {
            this.a = bw;
        }

        public final void a(int i) {
            this.a.w("OFF");
            MoreDrawerActivity moreDrawerActivity = MoreDrawerActivity.this;
            moreDrawerActivity.fingerAuthSwitch.setChecked(false);
            if (i == 11) {
                Toast.makeText(moreDrawerActivity.getContext(), moreDrawerActivity.getResources().getString(R.string.biometric_authentication_disable_msg), 0).show();
            } else {
                Toast.makeText(moreDrawerActivity.getContext(), moreDrawerActivity.getResources().getString(R.string.biometric_register_error), 0).show();
            }
        }

        public final void b() {
            this.a.w("OFF");
            MoreDrawerActivity.this.fingerAuthSwitch.setChecked(false);
        }

        public final void c() {
            MoreDrawerActivity moreDrawerActivity = MoreDrawerActivity.this;
            ProgressDialog show = ProgressDialog.show(moreDrawerActivity.getContext(), "Loading...", moreDrawerActivity.getString(R.string.please_wait_text));
            String l = C0657Qt.l();
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).e(l + "registerBiomatric").c(C1181iv.a()).a(E0.a()).b(new A(this, show));
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            MoreDrawerActivity moreDrawerActivity = MoreDrawerActivity.this;
            moreDrawerActivity.langauge.setText("English");
            C0535I5.i0(moreDrawerActivity.getContext(), "en");
            moreDrawerActivity.g("en");
            moreDrawerActivity.getActivity().recreate();
            moreDrawerActivity.f();
            C0535I5.a0(moreDrawerActivity.getContext());
            Bw.e(moreDrawerActivity.getContext()).y("en");
            C0535I5.v(moreDrawerActivity.f4263a);
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            MoreDrawerActivity moreDrawerActivity = MoreDrawerActivity.this;
            moreDrawerActivity.langauge.setText("हिंदी");
            C0535I5.i0(moreDrawerActivity.getContext(), "hi");
            moreDrawerActivity.getActivity().recreate();
            moreDrawerActivity.f();
            C0535I5.a0(moreDrawerActivity.getContext());
            Bw.e(moreDrawerActivity.getContext()).y("hi");
            C0535I5.v(moreDrawerActivity.f4263a);
        }
    }

    static {
        C1354qp.R(MoreDrawerActivity.class);
    }

    @OnClick({2131362666})
    public void authFingerSwitch() {
        Bw e2 = Bw.e(getContext());
        if (!C0535I5.R()) {
            if (e2.c().equalsIgnoreCase("ON")) {
                this.fingerAuthSwitch.setChecked(true);
            } else {
                this.fingerAuthSwitch.setChecked(false);
            }
            HomeActivity.A(2);
        } else if (this.fingerAuthSwitch.isChecked()) {
            e2.w("ON");
            Executor d2 = d7.d(getActivity());
            this.f4265a = d2;
            BiometricPrompt biometricPrompt = new BiometricPrompt((Fragment) this, d2, new a(e2));
            BiometricPrompt.d.a aVar = new BiometricPrompt.d.a();
            aVar.a = getString(R.string.activate_biometric);
            aVar.b = getString(R.string.CANCEL);
            BiometricPrompt.d a2 = aVar.a();
            if (e2.c().equalsIgnoreCase("ON")) {
                biometricPrompt.a(a2);
            }
        } else {
            Toast.makeText(getContext(), getResources().getString(R.string.biometric_disabled), 0).show();
            e2.w("OFF");
            this.fingerAuthSwitch.setChecked(false);
        }
    }

    @OnClick({2131364386})
    public void download_aarogya_setu_tv(View view) {
        try {
            Intent launchIntentForPackage = getContext().getPackageManager().getLaunchIntentForPackage("nic.goi.aarogyasetu");
            if (launchIntentForPackage != null) {
                try {
                    startActivity(launchIntentForPackage);
                } catch (Exception e2) {
                    e2.getMessage();
                }
            } else {
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=nic.goi.aarogyasetu&hl=en_IN")));
                } catch (Exception e3) {
                    e3.getMessage();
                }
            }
        } catch (Exception e4) {
            e4.getMessage();
        }
    }

    public final void f() {
        String string = getContext().getSharedPreferences("Settings", 0).getString("My_Lang", "en");
        IrctcImaApplication.e = string;
        g(string);
    }

    public final void g(String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        SharedPreferences.Editor edit = getContext().getSharedPreferences("Settings", 0).edit();
        edit.putString("My_Lang", str);
        edit.apply();
        IrctcImaApplication.e = str;
    }

    public final void h(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    @OnClick({2131363706})
    public void onAboutUsClick(View view) {
        HomeActivity.n((AppCompatActivity) getContext(), new AboutUsFragment(), C1218kf.ABOUT_US.a(), Boolean.TRUE, Boolean.FALSE);
    }

    @OnClick({2131363716})
    public void onCancelcounterticketlick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.operations.irctc.co.in/ctcan/SystemTktCanLogin.jsf"));
        startActivity(intent);
    }

    @OnClick({2131363733})
    public void onClickHelpSupport(View view) {
        if (!C0535I5.O((ConnectivityManager) getContext().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new c(), 5000);
            return;
        }
        String packageName = getContext().getPackageName();
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("help_support" + packageName)));
        } catch (ActivityNotFoundException e2) {
            e2.getMessage();
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://equery.irctc.co.in")));
        }
    }

    @OnClick({2131363721})
    public void onContactUsClick(View view) {
        if (!C0535I5.O((ConnectivityManager) getContext().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new b(), 5000);
            return;
        }
        HomeActivity.n((AppCompatActivity) getContext(), new ContactUsFragment(), C1218kf.CONTACT_US.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4264a;
        fragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        View inflate = layoutInflater.inflate(R.layout.activity_more_drawer, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        this.f4264a = getFragmentManager();
        if (C1450w1.f7028d) {
            this.feedback.setVisibility(0);
        } else {
            this.feedback.setVisibility(8);
        }
        this.f4263a = getActivity();
        this.a = new ProgressDialog(getContext());
        HomeActivity.p();
        HomeActivity.J();
        new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        Iterator<InformationMessageDTO> it = C1450w1.f7010a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getParamName().equalsIgnoreCase("PLEDGE_ENABLE")) {
                this.rl_integrityPledge.setVisibility(0);
                break;
            } else {
                this.rl_integrityPledge.setVisibility(8);
            }
        }
        if (IrctcImaApplication.e.equals("hi")) {
            this.langauge.setText("हिंदी");
            this.hindi.setTextColor(getResources().getColor(R.color.darkGrey));
            this.english.setTextColor(getResources().getColor(R.color.dark));
            h(this.english, R.color.white);
            h(this.hindi, R.color.dark);
        } else {
            this.langauge.setText("English");
            this.hindi.setTextColor(getResources().getColor(R.color.black_90_opa));
            this.english.setTextColor(getResources().getColor(R.color.darkGrey));
            h(this.hindi, R.color.white);
            h(this.english, R.color.dark);
        }
        f();
        if (Bw.e(getContext()).c().equalsIgnoreCase("ON")) {
            this.fingerAuthSwitch.setChecked(true);
        }
        int a2 = new androidx.biometric.h(new h.c(getContext())).a(32783);
        if (a2 != 0) {
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
        return inflate;
    }

    @OnClick({2131363722})
    public void onDealsOnIrctcClick(View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://offers.irctc.co.in?utm_source=App&utm_medium=Railconnect&utm_campaign=IRCTC")));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363714})
    public void onEcateringClick(View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.ecatering.irctc.co.in/?utm_source=irctc&utm_medium=android_app&utm_campaign=sidebar_link")));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131362495})
    public void onEnglishClick(View view) {
        if (this.langauge_layout.getVisibility() == 0) {
            this.langauge_layout.setVisibility(8);
        } else {
            this.langauge_layout.setVisibility(0);
        }
        this.hindi.setTextColor(getResources().getColor(R.color.darkGrey));
        this.english.setTextColor(getResources().getColor(R.color.dark));
        h(this.english, R.color.dark);
        h(this.hindi, R.color.white);
        C0535I5.p(getContext(), false, getString(R.string.relaunch_app), getString(R.string.confirmation), getString(R.string.OK), new e(), getString(R.string.no), new f()).show();
    }

    @OnClick({2131363727})
    public void onFeedbackClick(View view) {
        if (C0535I5.R()) {
            Intent intent = new Intent(getContext(), FeedbackActivity.class);
            intent.putExtra("message_key", "-1");
            intent.putExtra("camefrompage", this.f4266c);
            startActivity(intent);
            return;
        }
        HomeActivity.A(2);
    }

    @OnClick({2131363730})
    public void onFundamentalDutiesClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://contents.irctc.co.in/en/Fundamental Duties.pdf"));
        startActivity(intent);
    }

    @OnClick({2131363731})
    public void onGalleryClick(View view) {
        String packageName = getContext().getPackageName();
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("gallery" + packageName)));
        } catch (ActivityNotFoundException e2) {
            e2.getMessage();
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.irctctourism.com/gallery/")));
        }
    }

    @OnClick({2131362778})
    public void onHindiClick(View view) {
        if (this.langauge_layout.getVisibility() == 0) {
            this.langauge_layout.setVisibility(8);
        } else {
            this.langauge_layout.setVisibility(0);
        }
        this.hindi.setTextColor(getResources().getColor(R.color.black_90_opa));
        this.english.setTextColor(getResources().getColor(R.color.darkGrey));
        h(this.hindi, R.color.dark);
        h(this.english, R.color.white);
        C0535I5.p(getContext(), false, "परिवर्तनों को प्रभावी करने के लिए कृपया ऐप को फिर से लॉन्च करें।", "पुष्टि", "ठीक है", new g(), "नहीं", new h()).show();
    }

    @OnClick({2131363735})
    public void onIntegratyPledgeClick(View view) {
        C0486Dp dp = new C0486Dp();
        dp.setLocation("SIDE_PANEL");
        dp.setPnr("");
        dp.setReservationId(0L);
        dp.setPsgnCount((Integer) null);
        Iterator<InformationMessageDTO> it = C1450w1.f7010a.iterator();
        while (it.hasNext()) {
            InformationMessageDTO next = it.next();
            if (next.getParamName().equalsIgnoreCase("PLEDGE_ENABLE")) {
                String l = C0657Qt.l();
                ((Om) C0657Qt.b()).u(l + "addPledge", dp).c(C1181iv.a()).a(E0.a()).b(new Sl());
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(next.getUrl())));
            }
        }
    }

    @OnClick({2131364453})
    public void onLangaugeClick(View view) {
        this.langauge_layout.setVisibility(0);
    }

    @OnClick({2131362932})
    public void onLangaugeLayoutClick(View view) {
        if (this.langauge_layout.getVisibility() == 0) {
            this.langauge_layout.setVisibility(8);
        }
    }

    public final void onPause() {
        super.onPause();
        if (getActivity() != null) {
            getActivity().getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        }
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363760})
    public void onRateUsClick(View view) {
        String packageName = getContext().getPackageName();
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException e2) {
            e2.getMessage();
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    public final void onResume() {
        super.onResume();
        if (getActivity() != null) {
            getActivity().getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
        }
        if (Bw.e(getContext()).c().equalsIgnoreCase("ON")) {
            this.fingerAuthSwitch.setChecked(true);
        } else {
            this.fingerAuthSwitch.setChecked(false);
        }
        HomeActivity.p();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363765})
    public void onSystemVikalpTicketClick(View view) {
        HomeActivity.n((AppCompatActivity) getContext(), new VikalpSystemFragment(), C1218kf.OPT_VIKALP.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = this.f4264a;
        fragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    @OnClick({2131363769})
    public void onUserGuideClick(View view) {
        if (!C0535I5.O((ConnectivityManager) getContext().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new d(), 5000);
            return;
        }
        String packageName = getContext().getPackageName();
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("UserGuideIRCTC" + packageName)));
        } catch (ActivityNotFoundException e2) {
            e2.getMessage();
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://contents.irctc.co.in/en/UserGuideIRCTC.pdf")));
        }
    }

    @OnClick({2131363704})
    public void rl_aarogya_setu(View view) {
        if (this.rl_aarogya_setu_expand.getVisibility() == 8) {
            this.rl_aarogya_setu_expand.setVisibility(0);
            this.iv_spinner_aarogya_setu.setRotation(180.0f);
            return;
        }
        this.rl_aarogya_setu_expand.setVisibility(8);
        this.iv_spinner_aarogya_setu.setRotation(90.0f);
    }

    @OnClick({2131363709})
    public void rl_alerts(View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.irctc.co.in/nget/enquiry/alerts")));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public class b implements Runnable {
        public final void run() {
        }
    }

    public class c implements Runnable {
        public final void run() {
        }
    }

    public class d implements Runnable {
        public final void run() {
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
