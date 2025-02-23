package cris.org.in.ima.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.fragment.AllTrainListFragment;
import cris.org.in.ima.fragment.HomeFragment;
import cris.org.in.ima.fragment.JourneyDetailsFragment;
import cris.org.in.ima.fragment.LapAllTrainListFragment;
import cris.org.in.ima.fragment.MyAccountFragment;
import cris.org.in.ima.fragment.MyTransactionFragment;
import cris.org.in.ima.fragment.PassengerDetailFragment;
import cris.org.in.ima.fragment.ReviewAndPayFragment;
import cris.org.in.ima.fragment.TrainDashboardFragment;
import cris.org.in.ima.payment.CashOnDeliveryActivity;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

public class HomeActivity extends AppCompatActivity {
    public static ImageView a;

    /* renamed from: a  reason: collision with other field name */
    public static LinearLayout f4179a;

    /* renamed from: a  reason: collision with other field name */
    public static TextView f4180a;

    /* renamed from: a  reason: collision with other field name */
    public static PgWebViewActivity f4181a;

    /* renamed from: a  reason: collision with other field name */
    public static ZaakpayActivity f4182a;

    /* renamed from: a  reason: collision with other field name */
    public static CashOnDeliveryActivity f4183a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f4184a = false;
    public static ImageView b;

    /* renamed from: b  reason: collision with other field name */
    public static TextView f4185b;

    /* renamed from: b  reason: collision with other field name */
    public static boolean f4186b = false;
    public static int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public static ImageView f4187c;

    /* renamed from: c  reason: collision with other field name */
    public static TextView f4188c;

    /* renamed from: c  reason: collision with other field name */
    public static String f4189c;
    public static ImageView d;

    /* renamed from: d  reason: collision with other field name */
    public static TextView f4190d;
    public static ImageView e;

    /* renamed from: e  reason: collision with other field name */
    public static TextView f4191e;
    public static TextView f;
    public static TextView g;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4192a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4193a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f4194a;

    /* renamed from: a  reason: collision with other field name */
    public C0822cf f4195a;

    /* renamed from: a  reason: collision with other field name */
    public HomeActivity f4196a;

    /* renamed from: a  reason: collision with other field name */
    public final HomeFragment f4197a = new HomeFragment();

    /* renamed from: a  reason: collision with other field name */
    public final TrainDashboardFragment f4198a = new TrainDashboardFragment();
    @BindView(2131362456)
    DrawerLayout drawerLayout;
    @BindView(2131362785)
    ImageView homeimage;
    @BindView(2131362786)
    TextView hometext;
    @BindView(2131363242)
    ImageView moreimage;
    @BindView(2131363243)
    TextView moretext;
    @BindView(2131363279)
    ImageView myaccountimage;
    @BindView(2131363280)
    TextView myaccounttext;
    @BindView(2131364219)
    ImageView transactionimaqe;
    @BindView(2131364221)
    TextView transactionitext;

    public class a implements View.OnClickListener {
        public final void onClick(View view) {
            HomeActivity.A(2);
        }
    }

    public class b implements DialogInterface.OnClickListener {

        public class a extends Subscriber<Boolean> {
            public final /* synthetic */ ProgressDialog a;

            public a(ProgressDialog progressDialog) {
                this.a = progressDialog;
            }

            public final void onCompleted() {
                b bVar = b.this;
                HomeActivity homeActivity = HomeActivity.this;
                CashOnDeliveryActivity cashOnDeliveryActivity = HomeActivity.f4183a;
                homeActivity.getClass();
                C0535I5.Z(HomeActivity.this.f4196a, (InterstitialAd) null, true);
            }

            public final void onError(Throwable th) {
                CashOnDeliveryActivity cashOnDeliveryActivity = HomeActivity.f4183a;
                th.getMessage();
                HomeActivity.this.f4192a = this.a;
            }

            public final void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                CashOnDeliveryActivity cashOnDeliveryActivity = HomeActivity.f4183a;
            }
        }

        public b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0535I5.f3630b = true;
            boolean R = C0535I5.R();
            HomeActivity homeActivity = HomeActivity.this;
            if (R) {
                ProgressDialog show = ProgressDialog.show(homeActivity.f4196a, homeActivity.getString(R.string.logout_loading), homeActivity.getString(R.string.please_wait_text));
                String f = C0657Qt.f();
                ((Om) C0657Qt.c(C0793b1.a.f3912a)).t0(f + "logout").c(C1181iv.a()).a(E0.a()).b(new a(show));
                return;
            }
            homeActivity.f4192a = homeActivity.f4192a;
            HomeActivity homeActivity2 = homeActivity.f4196a;
            CashOnDeliveryActivity cashOnDeliveryActivity = HomeActivity.f4183a;
            C0535I5.Z(homeActivity2, (InterstitialAd) null, true);
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ String c;

        public c(String str) {
            this.c = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            HomeActivity homeActivity = HomeActivity.this;
            HomeActivity.super.onBackPressed();
            C0535I5.u0(homeActivity);
            HomeActivity.F(this.c);
        }
    }

    static {
        C1354qp.R(HomeActivity.class);
    }

    public HomeActivity() {
        C1218kf.NEW_BOOKING.a();
    }

    public static void A(int i) {
        Context context = IrctcImaApplication.a;
        Bw e2 = Bw.e(context);
        c = i;
        if (i == 1) {
            B(context);
        }
        f4186b = true;
        if (TextUtils.isEmpty(e2.f3534a.getString("alfiler", ""))) {
            Intent intent = new Intent(context, LoginActivity.class);
            intent.setFlags(32768);
            intent.setFlags(268435456);
            intent.putExtra("isDashBoardLanding", c);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, PinValidationActivity.class);
        intent2.setFlags(32768);
        intent2.setFlags(268435456);
        intent2.putExtra("isDashBoardLanding", c);
        context.startActivity(intent2);
    }

    public static void B(Context context) {
        try {
            FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            for (int i = 0; i < supportFragmentManager.F() - 1; i++) {
                supportFragmentManager.Q();
            }
            F(C1218kf.HOME_PAGE.a());
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static void C(FragmentActivity fragmentActivity) {
        try {
            FragmentManager supportFragmentManager = ((AppCompatActivity) fragmentActivity).getSupportFragmentManager();
            int F = supportFragmentManager.F();
            while (true) {
                F--;
                if (F <= 0) {
                    return;
                }
                if (supportFragmentManager.E(F).getName().equalsIgnoreCase(C1218kf.REVIEW_JOURNEY.a())) {
                    F(supportFragmentManager.E(F).getName());
                    return;
                }
                supportFragmentManager.Q();
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static void D(Context context) {
        try {
            FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            int F = supportFragmentManager.F() - 1;
            while (F > 0) {
                if (supportFragmentManager.E(F).getName().equalsIgnoreCase(C1218kf.ADD_PASSENGER.a())) {
                    F(supportFragmentManager.E(F).getName());
                    return;
                } else {
                    supportFragmentManager.Q();
                    F--;
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void F(String str) {
        f4189c = str;
        f4180a.setText(str);
        if (!f4184a) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase(C1218kf.AUTHENTICATE_USER.a());
            C1218kf kfVar = C1218kf.AADHAARPANKYC;
            if (!equalsIgnoreCase && !str.equalsIgnoreCase(kfVar.a())) {
                G((String) null);
            }
            if (str.equalsIgnoreCase(kfVar.a())) {
                f4180a.setTextSize(14.0f);
            } else {
                f4180a.setTextSize(16.0f);
            }
            H((String) null);
        }
    }

    public static void G(String str) {
        if (str == null || str.equals("")) {
            f4190d.setVisibility(8);
            return;
        }
        f4190d.setText(str);
        f4190d.setVisibility(0);
    }

    public static void H(String str) {
        if (str == null || str.equals("")) {
            f4188c.setVisibility(8);
            return;
        }
        f4188c.setText(str);
        f4188c.setVisibility(0);
    }

    public static void I() {
        f4191e.setVisibility(0);
    }

    public static void J() {
        f4179a.setVisibility(0);
    }

    public static void K() {
        f4180a.setVisibility(0);
    }

    public static void n(Context context, Fragment fragment, String str, Boolean bool, Boolean bool2) {
        FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        int F = supportFragmentManager.F();
        if (bool2.booleanValue() && F > 1) {
            supportFragmentManager.Q();
        }
        if (!supportFragmentManager.S(str)) {
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(supportFragmentManager);
            aVar.g(R.id.home_container, fragment, str, 2);
            if (bool.booleanValue()) {
                if (aVar.f2122b) {
                    aVar.f2119a = true;
                    aVar.f2117a = str;
                } else {
                    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                }
            }
            aVar.c();
        }
        F(str);
        x();
        z();
        d.setVisibility(8);
        t();
    }

    public static void o() {
        f.setVisibility(8);
    }

    public static void p() {
        f4191e.setVisibility(8);
    }

    public static void t() {
        f4179a.setVisibility(8);
    }

    public static void x() {
        a.setVisibility(8);
    }

    public static void z() {
        f4187c.setVisibility(8);
    }

    public final void E() {
        this.hometext.setTextColor(getResources().getColor(R.color.red));
        this.homeimage.setColorFilter(this.f4196a.getResources().getColor(R.color.red));
        this.transactionitext.setTextColor(getResources().getColor(R.color.colorAccent));
        this.transactionimaqe.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
        this.myaccounttext.setTextColor(getResources().getColor(R.color.colorAccent));
        this.myaccountimage.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
        this.moretext.setTextColor(getResources().getColor(R.color.colorAccent));
        this.moreimage.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
        l(this.homeimage);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    @OnClick({2131361940})
    public void clckAmazonCart(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://contents.irctc.co.in/en/andMobShop.html")));
    }

    public final void l(ImageView imageView) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(imageView.getWindowToken(), 0);
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a2 A[Catch:{ Exception -> 0x0253 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r27, int r28, android.content.Intent r29) {
        /*
            r26 = this;
            r0 = r27
            r1 = r29
            r2 = 95
            r4 = 2
            java.lang.String r5 = "="
            java.lang.String r6 = ","
            java.lang.String r7 = "encdata"
            java.lang.String r8 = "device_back_button"
            r9 = 1
            r10 = 0
            r11 = 2131952688(0x7f130430, float:1.9541826E38)
            r12 = 2131951928(0x7f130138, float:1.9540284E38)
            if (r0 != r2) goto L_0x00e7
            cris.org.in.ima.payment.CashOnDeliveryActivity r13 = f4183a
            r13.getClass()
            java.lang.String r0 = "codresponse"
            boolean r2 = r1.hasExtra(r0)     // Catch:{ Exception -> 0x00c8 }
            if (r2 == 0) goto L_0x002f
            android.os.Bundle r1 = r29.getExtras()     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            if (r0 == 0) goto L_0x00aa
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x00c8 }
            if (r1 == 0) goto L_0x003a
            goto L_0x00aa
        L_0x003a:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x00c8 }
            r1.<init>()     // Catch:{ Exception -> 0x00c8 }
            boolean r2 = r0.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x00c8 }
            if (r2 == 0) goto L_0x0047
            r3 = r0
            goto L_0x0086
        L_0x0047:
            java.lang.String[] r0 = r0.split(r6)     // Catch:{ Exception -> 0x00c8 }
            int r2 = r0.length     // Catch:{ Exception -> 0x00c8 }
            r6 = r10
        L_0x004d:
            if (r6 >= r2) goto L_0x0070
            r14 = r0[r6]     // Catch:{ Exception -> 0x00c8 }
            java.lang.String[] r14 = r14.split(r5)     // Catch:{ Exception -> 0x00c8 }
            int r15 = r14.length     // Catch:{ Exception -> 0x00c8 }
            if (r15 != r4) goto L_0x006d
            r15 = r14[r10]     // Catch:{ Exception -> 0x00c8 }
            if (r15 == 0) goto L_0x006d
            r16 = r14[r9]     // Catch:{ Exception -> 0x00c8 }
            if (r16 == 0) goto L_0x006d
            java.lang.String r15 = r15.trim()     // Catch:{ Exception -> 0x00c8 }
            r14 = r14[r9]     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r14 = r14.trim()     // Catch:{ Exception -> 0x00c8 }
            r1.put(r15, r14)     // Catch:{ Exception -> 0x00c8 }
        L_0x006d:
            int r6 = r6 + 1
            goto L_0x004d
        L_0x0070:
            java.lang.Object r0 = r1.get(r7)     // Catch:{ Exception -> 0x00c8 }
            if (r0 == 0) goto L_0x0085
            java.lang.String r0 = r7.toLowerCase()     // Catch:{ Exception -> 0x00c8 }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x00c8 }
            goto L_0x0086
        L_0x0085:
            r3 = 0
        L_0x0086:
            if (r3 == 0) goto L_0x0090
            boolean r0 = r3.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x00c8 }
            if (r0 == 0) goto L_0x0090
            goto L_0x044b
        L_0x0090:
            if (r3 == 0) goto L_0x044b
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x00c8 }
            r0.<init>()     // Catch:{ Exception -> 0x00c8 }
            Do r1 = new Do     // Catch:{ Exception -> 0x00c8 }
            r1.<init>(r7, r3)     // Catch:{ Exception -> 0x00c8 }
            r0.add(r1)     // Catch:{ Exception -> 0x00c8 }
            xl r1 = defpackage.C1480xl.f7038a     // Catch:{ Exception -> 0x00c8 }
            androidx.fragment.app.Fragment r2 = r13.f5355a     // Catch:{ Exception -> 0x00c8 }
            cris.org.in.ima.fragment.MakePaymentNewFragment r2 = (cris.org.in.ima.fragment.MakePaymentNewFragment) r2     // Catch:{ Exception -> 0x00c8 }
            r1.c(r2, r0)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x044b
        L_0x00aa:
            android.content.Context r3 = r13.getBaseContext()     // Catch:{ Exception -> 0x00c8 }
            r4 = 0
            r0 = 2131952692(0x7f130434, float:1.9541834E38)
            java.lang.String r5 = r13.getString(r0)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r6 = r13.getString(r11)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r7 = r13.getString(r12)     // Catch:{ Exception -> 0x00c8 }
            r8 = 0
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00c8 }
            r0.show()     // Catch:{ Exception -> 0x00c8 }
            goto L_0x044b
        L_0x00c8:
            r0 = move-exception
            r0.getMessage()
            r14 = 0
            r0 = 2131952693(0x7f130435, float:1.9541836E38)
            java.lang.String r15 = r13.getString(r0)
            java.lang.String r16 = r13.getString(r11)
            java.lang.String r17 = r13.getString(r12)
            r18 = 0
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r13, r14, r15, r16, r17, r18)
            r0.show()
            goto L_0x044b
        L_0x00e7:
            r2 = 101(0x65, float:1.42E-43)
            if (r0 != r2) goto L_0x00f2
            cris.org.in.ima.activities.ZaakpayActivity r0 = f4182a
            r0.l(r1)
            goto L_0x044b
        L_0x00f2:
            r2 = 108(0x6c, float:1.51E-43)
            if (r0 != r2) goto L_0x00fd
            cris.org.in.ima.activities.ZaakpayActivity r0 = f4182a
            r0.l(r1)
            goto L_0x044b
        L_0x00fd:
            r2 = 111(0x6f, float:1.56E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 118(0x76, float:1.65E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 106(0x6a, float:1.49E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 119(0x77, float:1.67E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 120(0x78, float:1.68E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 122(0x7a, float:1.71E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 121(0x79, float:1.7E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 124(0x7c, float:1.74E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 125(0x7d, float:1.75E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 140(0x8c, float:1.96E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 138(0x8a, float:1.93E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 77
            if (r0 == r2) goto L_0x015f
            r2 = 141(0x8d, float:1.98E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 144(0x90, float:2.02E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 127(0x7f, float:1.78E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 142(0x8e, float:1.99E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 147(0x93, float:2.06E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 148(0x94, float:2.07E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 131(0x83, float:1.84E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 133(0x85, float:1.86E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 139(0x8b, float:1.95E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 152(0x98, float:2.13E-43)
            if (r0 == r2) goto L_0x015f
            r2 = 135(0x87, float:1.89E-43)
            if (r0 != r2) goto L_0x015a
            goto L_0x015f
        L_0x015a:
            super.onActivityResult(r27, r28, r29)
            goto L_0x044b
        L_0x015f:
            cris.org.in.ima.activities.PgWebViewActivity r2 = f4181a
            if (r2 == 0) goto L_0x044b
            java.lang.String r0 = "bankresponse"
            java.lang.String r13 = "hidRequestId"
            java.lang.String r14 = "hidOperation"
            java.lang.String r15 = "bdaesk3.msg"
            java.lang.String r12 = "appType"
            java.lang.String r11 = "MID"
            java.lang.String r3 = "CHECKSUMHASH"
            java.lang.String r9 = "response"
            if (r1 == 0) goto L_0x0184
            boolean r20 = r1.hasExtra(r0)     // Catch:{ Exception -> 0x0253 }
            if (r20 == 0) goto L_0x0184
            android.os.Bundle r1 = r29.getExtras()     // Catch:{ Exception -> 0x0253 }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ Exception -> 0x0253 }
            goto L_0x01a0
        L_0x0184:
            if (r1 == 0) goto L_0x0195
            boolean r0 = r1.hasExtra(r9)     // Catch:{ Exception -> 0x0253 }
            if (r0 == 0) goto L_0x0195
            android.os.Bundle r0 = r29.getExtras()     // Catch:{ Exception -> 0x0253 }
            java.lang.String r0 = r0.getString(r9)     // Catch:{ Exception -> 0x0253 }
            goto L_0x01a0
        L_0x0195:
            r0 = 2131953888(0x7f1308e0, float:1.954426E38)
            java.lang.String r0 = r2.getString(r0)     // Catch:{ Exception -> 0x0253 }
            defpackage.C0535I5.t0(r2, r0)     // Catch:{ Exception -> 0x0253 }
            r0 = 0
        L_0x01a0:
            if (r0 == 0) goto L_0x0401
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0253 }
            if (r1 == 0) goto L_0x01aa
            goto L_0x0401
        L_0x01aa:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0253 }
            r1.<init>()     // Catch:{ Exception -> 0x0253 }
            boolean r20 = r0.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r10 = "success"
            java.lang.String r4 = "ENC_DATA"
            r28 = r13
            java.lang.String r13 = "bankCode"
            if (r20 == 0) goto L_0x01c5
            r25 = r12
            r20 = r14
            r24 = r15
            goto L_0x0236
        L_0x01c5:
            java.lang.String[] r0 = r0.split(r6)     // Catch:{ Exception -> 0x0253 }
            int r6 = r0.length     // Catch:{ Exception -> 0x0253 }
            r20 = r14
            r14 = 0
        L_0x01cd:
            if (r14 >= r6) goto L_0x0216
            r29 = r6
            r6 = r0[r14]     // Catch:{ Exception -> 0x0253 }
            r23 = r0
            java.lang.String[] r0 = r6.split(r5)     // Catch:{ Exception -> 0x0253 }
            r24 = r15
            int r15 = r0.length     // Catch:{ Exception -> 0x0253 }
            r25 = r12
            r12 = 2
            if (r15 < r12) goto L_0x020b
            r15 = 0
            r22 = r0[r15]     // Catch:{ Exception -> 0x0253 }
            if (r22 == 0) goto L_0x020b
            r15 = 1
            r19 = r0[r15]     // Catch:{ Exception -> 0x0253 }
            if (r19 == 0) goto L_0x020b
            java.lang.String r12 = r22.trim()     // Catch:{ Exception -> 0x0253 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0253 }
            r15.<init>()     // Catch:{ Exception -> 0x0253 }
            r21 = 0
            r0 = r0[r21]     // Catch:{ Exception -> 0x0253 }
            r15.append(r0)     // Catch:{ Exception -> 0x0253 }
            r15.append(r5)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r0 = r15.toString()     // Catch:{ Exception -> 0x0253 }
            java.lang.String r15 = ""
            java.lang.String r0 = r6.replace(r0, r15)     // Catch:{ Exception -> 0x0253 }
            r1.put(r12, r0)     // Catch:{ Exception -> 0x0253 }
        L_0x020b:
            int r14 = r14 + 1
            r6 = r29
            r0 = r23
            r15 = r24
            r12 = r25
            goto L_0x01cd
        L_0x0216:
            r25 = r12
            r24 = r15
            java.lang.Object r0 = r1.get(r7)     // Catch:{ Exception -> 0x0253 }
            if (r0 != 0) goto L_0x0235
            java.lang.Object r0 = r1.get(r9)     // Catch:{ Exception -> 0x0253 }
            if (r0 != 0) goto L_0x0235
            java.lang.Object r0 = r1.get(r4)     // Catch:{ Exception -> 0x0253 }
            if (r0 != 0) goto L_0x0235
            java.lang.Object r0 = r1.get(r13)     // Catch:{ Exception -> 0x0253 }
            if (r0 == 0) goto L_0x0233
            goto L_0x0235
        L_0x0233:
            r0 = 0
            goto L_0x0236
        L_0x0235:
            r0 = r10
        L_0x0236:
            if (r0 == 0) goto L_0x03dc
            boolean r5 = r0.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0253 }
            if (r5 == 0) goto L_0x0240
            goto L_0x044b
        L_0x0240:
            java.lang.String r5 = "cancel"
            boolean r5 = r0.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0253 }
            if (r5 == 0) goto L_0x0256
            androidx.fragment.app.Fragment r0 = r2.f4270a     // Catch:{ Exception -> 0x0253 }
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()     // Catch:{ Exception -> 0x0253 }
            defpackage.C0535I5.u0(r0)     // Catch:{ Exception -> 0x0253 }
            goto L_0x044b
        L_0x0253:
            r0 = move-exception
            goto L_0x0424
        L_0x0256:
            java.lang.String r5 = "failed"
            boolean r5 = r0.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0253 }
            if (r5 == 0) goto L_0x0269
            androidx.fragment.app.Fragment r0 = r2.f4270a     // Catch:{ Exception -> 0x0253 }
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()     // Catch:{ Exception -> 0x0253 }
            defpackage.C0535I5.u0(r0)     // Catch:{ Exception -> 0x0253 }
            goto L_0x044b
        L_0x0269:
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x0253 }
            if (r0 == 0) goto L_0x03b7
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0253 }
            r0.<init>()     // Catch:{ Exception -> 0x0253 }
            java.lang.String r5 = r7.toLowerCase()     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r5 = r1.get(r5)     // Catch:{ Exception -> 0x0253 }
            if (r5 == 0) goto L_0x0296
            Do r3 = new Do     // Catch:{ Exception -> 0x0253 }
            java.lang.String r4 = r7.toLowerCase()     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0253 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0253 }
            r3.<init>(r7, r1)     // Catch:{ Exception -> 0x0253 }
            r0.add(r3)     // Catch:{ Exception -> 0x0253 }
            goto L_0x0390
        L_0x0296:
            java.lang.String r5 = r9.toLowerCase()     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r5 = r1.get(r5)     // Catch:{ Exception -> 0x0253 }
            if (r5 == 0) goto L_0x02b8
            Do r3 = new Do     // Catch:{ Exception -> 0x0253 }
            java.lang.String r4 = r9.toLowerCase()     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0253 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0253 }
            r3.<init>(r9, r1)     // Catch:{ Exception -> 0x0253 }
            r0.add(r3)     // Catch:{ Exception -> 0x0253 }
            goto L_0x0390
        L_0x02b8:
            java.lang.Object r5 = r1.get(r4)     // Catch:{ Exception -> 0x0253 }
            if (r5 == 0) goto L_0x0302
            Do r5 = new Do     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r6 = r1.get(r4)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0253 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0253 }
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x0253 }
            r0.add(r5)     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r4 = r1.get(r3)     // Catch:{ Exception -> 0x0253 }
            if (r4 == 0) goto L_0x02e8
            Do r4 = new Do     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r5 = r1.get(r3)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0253 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0253 }
            r4.<init>(r3, r5)     // Catch:{ Exception -> 0x0253 }
            r0.add(r4)     // Catch:{ Exception -> 0x0253 }
        L_0x02e8:
            java.lang.Object r3 = r1.get(r11)     // Catch:{ Exception -> 0x0253 }
            if (r3 == 0) goto L_0x0390
            Do r3 = new Do     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r1 = r1.get(r11)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0253 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0253 }
            r3.<init>(r11, r1)     // Catch:{ Exception -> 0x0253 }
            r0.add(r3)     // Catch:{ Exception -> 0x0253 }
            goto L_0x0390
        L_0x0302:
            java.lang.Object r3 = r1.get(r13)     // Catch:{ Exception -> 0x0253 }
            if (r3 == 0) goto L_0x0390
            java.lang.Object r3 = r1.get(r13)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0253 }
            java.lang.String r4 = "AMEX_MOB_CR"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0253 }
            if (r3 == 0) goto L_0x0390
            Do r3 = new Do     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r4 = r1.get(r13)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0253 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0253 }
            r3.<init>(r13, r4)     // Catch:{ Exception -> 0x0253 }
            r0.add(r3)     // Catch:{ Exception -> 0x0253 }
            r3 = r25
            java.lang.Object r4 = r1.get(r3)     // Catch:{ Exception -> 0x0253 }
            if (r4 == 0) goto L_0x0342
            Do r4 = new Do     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r5 = r1.get(r3)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0253 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0253 }
            r4.<init>(r3, r5)     // Catch:{ Exception -> 0x0253 }
            r0.add(r4)     // Catch:{ Exception -> 0x0253 }
        L_0x0342:
            r3 = r24
            java.lang.Object r4 = r1.get(r3)     // Catch:{ Exception -> 0x0253 }
            if (r4 == 0) goto L_0x035c
            Do r4 = new Do     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r5 = r1.get(r3)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0253 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0253 }
            r4.<init>(r3, r5)     // Catch:{ Exception -> 0x0253 }
            r0.add(r4)     // Catch:{ Exception -> 0x0253 }
        L_0x035c:
            r3 = r20
            java.lang.Object r4 = r1.get(r3)     // Catch:{ Exception -> 0x0253 }
            if (r4 == 0) goto L_0x0376
            Do r4 = new Do     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r5 = r1.get(r3)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0253 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0253 }
            r4.<init>(r3, r5)     // Catch:{ Exception -> 0x0253 }
            r0.add(r4)     // Catch:{ Exception -> 0x0253 }
        L_0x0376:
            r3 = r28
            java.lang.Object r4 = r1.get(r3)     // Catch:{ Exception -> 0x0253 }
            if (r4 == 0) goto L_0x0390
            Do r4 = new Do     // Catch:{ Exception -> 0x0253 }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0253 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0253 }
            r4.<init>(r3, r1)     // Catch:{ Exception -> 0x0253 }
            r0.add(r4)     // Catch:{ Exception -> 0x0253 }
        L_0x0390:
            java.lang.String r1 = r2.c     // Catch:{ Exception -> 0x0253 }
            if (r1 == 0) goto L_0x03ae
            java.lang.String r3 = "-1"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0253 }
            if (r1 == 0) goto L_0x03ae
            cf r1 = new cf     // Catch:{ Exception -> 0x0253 }
            androidx.fragment.app.Fragment r3 = r2.f4270a     // Catch:{ Exception -> 0x0253 }
            androidx.fragment.app.FragmentActivity r3 = r3.getActivity()     // Catch:{ Exception -> 0x0253 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0253 }
            java.lang.String r3 = "PAYMENT_COMPLETED"
            r4 = 0
            r5 = 0
            defpackage.C0535I5.W(r3, r5, r1, r4, r4)     // Catch:{ Exception -> 0x0253 }
        L_0x03ae:
            xl r1 = defpackage.C1480xl.f7038a     // Catch:{ Exception -> 0x0253 }
            androidx.fragment.app.Fragment r3 = r2.f4270a     // Catch:{ Exception -> 0x0253 }
            r1.c(r3, r0)     // Catch:{ Exception -> 0x0253 }
            goto L_0x044b
        L_0x03b7:
            androidx.fragment.app.Fragment r0 = r2.f4270a     // Catch:{ Exception -> 0x0253 }
            androidx.fragment.app.FragmentActivity r3 = r0.getActivity()     // Catch:{ Exception -> 0x0253 }
            r4 = 0
            r1 = 2131953619(0x7f1307d3, float:1.9543714E38)
            java.lang.String r5 = r2.getString(r1)     // Catch:{ Exception -> 0x0253 }
            r1 = 2131952688(0x7f130430, float:1.9541826E38)
            java.lang.String r6 = r2.getString(r1)     // Catch:{ Exception -> 0x0253 }
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r7 = r2.getString(r1)     // Catch:{ Exception -> 0x0253 }
            r8 = 0
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0253 }
            r0.show()     // Catch:{ Exception -> 0x0253 }
            goto L_0x044b
        L_0x03dc:
            androidx.fragment.app.Fragment r0 = r2.f4270a     // Catch:{ Exception -> 0x0253 }
            androidx.fragment.app.FragmentActivity r3 = r0.getActivity()     // Catch:{ Exception -> 0x0253 }
            r4 = 0
            r1 = 2131953619(0x7f1307d3, float:1.9543714E38)
            java.lang.String r5 = r2.getString(r1)     // Catch:{ Exception -> 0x0253 }
            r1 = 2131952688(0x7f130430, float:1.9541826E38)
            java.lang.String r6 = r2.getString(r1)     // Catch:{ Exception -> 0x0253 }
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r7 = r2.getString(r1)     // Catch:{ Exception -> 0x0253 }
            r8 = 0
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0253 }
            r0.show()     // Catch:{ Exception -> 0x0253 }
            goto L_0x044b
        L_0x0401:
            android.content.Context r3 = r2.getBaseContext()     // Catch:{ Exception -> 0x0253 }
            r4 = 0
            r0 = 2131952691(0x7f130433, float:1.9541832E38)
            java.lang.String r5 = r2.getString(r0)     // Catch:{ Exception -> 0x0253 }
            r1 = 2131952688(0x7f130430, float:1.9541826E38)
            java.lang.String r6 = r2.getString(r1)     // Catch:{ Exception -> 0x0253 }
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r7 = r2.getString(r1)     // Catch:{ Exception -> 0x0253 }
            r8 = 0
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0253 }
            r0.show()     // Catch:{ Exception -> 0x0253 }
            goto L_0x044b
        L_0x0424:
            androidx.fragment.app.Fragment r1 = r2.f4270a
            androidx.fragment.app.FragmentActivity r3 = r1.getActivity()
            r4 = 0
            r1 = 2131953619(0x7f1307d3, float:1.9543714E38)
            java.lang.String r5 = r2.getString(r1)
            r1 = 2131952688(0x7f130430, float:1.9541826E38)
            java.lang.String r6 = r2.getString(r1)
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r7 = r2.getString(r1)
            r8 = 0
            android.app.AlertDialog r1 = defpackage.C0535I5.m(r3, r4, r5, r6, r7, r8)
            r1.show()
            r0.getMessage()
        L_0x044b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.HomeActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @OnClick({2131362015})
    public void onBackArrowClick() {
        onBackPressed();
    }

    @SuppressLint({"RestrictedApi"})
    public final void onBackPressed() {
        String str;
        boolean z;
        if (!isFinishing()) {
            DrawerLayout drawerLayout2 = (DrawerLayout) this.f4196a.findViewById(R.id.drawer_layout);
            if (drawerLayout2 != null) {
                View d2 = drawerLayout2.d(8388611);
                if (d2 != null) {
                    z = DrawerLayout.k(d2);
                } else {
                    z = false;
                }
                if (z) {
                    View d3 = drawerLayout2.d(8388611);
                    if (d3 != null) {
                        drawerLayout2.b(d3, true);
                        return;
                    }
                    throw new IllegalArgumentException(C0709Uj.i("No drawer view found with gravity ", "LEFT"));
                }
            }
            C1218kf kfVar = C1218kf.HOME_PAGE;
            if (kfVar.a().equalsIgnoreCase(f4189c)) {
                for (Fragment next : getSupportFragmentManager().I()) {
                    if (next instanceof HomeFragment) {
                        ((HomeFragment) next).getClass();
                    }
                }
                try {
                    C0535I5.r(this, getString(R.string.logout_msg), getString(R.string.exit_alert), getString(R.string.yes), new b(), getString(R.string.no), (MyAccountFragment.c) null, getString(R.string.alert_logout_ads)).show();
                } catch (Exception e2) {
                    e2.getMessage();
                }
            } else {
                C1218kf kfVar2 = C1218kf.TRAIN;
                boolean equalsIgnoreCase = kfVar2.a().equalsIgnoreCase(f4189c);
                C1218kf kfVar3 = C1218kf.LAST_TXN;
                C1218kf kfVar4 = C1218kf.upcomingjourney;
                if (equalsIgnoreCase || kfVar4.a().equalsIgnoreCase(f4189c) || kfVar3.a().equalsIgnoreCase(f4189c)) {
                    boolean z2 = false;
                    for (Fragment next2 : getSupportFragmentManager().I()) {
                        if (next2 instanceof TrainDashboardFragment) {
                            z2 = ((TrainDashboardFragment) next2).i();
                        }
                    }
                    if (z2) {
                        return;
                    }
                }
                if (getSupportFragmentManager().F() == 1 && C1218kf.NEW_BOOKING.a().equalsIgnoreCase(f4189c)) {
                    String a2 = kfVar2.a();
                    Boolean bool = Boolean.TRUE;
                    n(this, this.f4198a, a2, bool, bool);
                }
                String charSequence = f4180a.getText().toString();
                boolean z3 = false;
                for (Fragment next3 : getSupportFragmentManager().I()) {
                    if (next3 instanceof AllTrainListFragment) {
                        z3 = ((AllTrainListFragment) next3).j();
                    }
                    if (next3 instanceof JourneyDetailsFragment) {
                        z3 = ((JourneyDetailsFragment) next3).i();
                    }
                    if (next3 instanceof LapAllTrainListFragment) {
                        z3 = ((LapAllTrainListFragment) next3).j();
                    }
                    if (next3 instanceof PassengerDetailFragment) {
                        z3 = ((PassengerDetailFragment) next3).z0();
                    }
                    if (next3 instanceof ReviewAndPayFragment) {
                        z3 = ((ReviewAndPayFragment) next3).p();
                    }
                }
                if (charSequence.equals(getResources().getString(R.string.booking_detail_title)) || charSequence.equals(getResources().getString(R.string.Metro_booking_Details))) {
                    B(this);
                } else if (charSequence.equals(C1218kf.PURCHASE_POINTS_LOYALTY_CONFIRMATION.a())) {
                    B(this.f4196a);
                    HomeActivity homeActivity = this.f4196a;
                    HomeFragment homeFragment = new HomeFragment();
                    String a3 = kfVar.a();
                    Boolean bool2 = Boolean.TRUE;
                    n(homeActivity, homeFragment, a3, bool2, bool2);
                    E();
                } else {
                    if (!C1218kf.MORE_DRAWER.a().equalsIgnoreCase(charSequence)) {
                        C1218kf kfVar5 = C1218kf.MY_ACCOUNT;
                        if (!kfVar5.a().equalsIgnoreCase(charSequence) && !C1218kf.MY_TRANSACTIONS.a().equalsIgnoreCase(charSequence)) {
                            if (C1218kf.MY_PROFILE.a().equalsIgnoreCase(charSequence) || C1218kf.EWALLET_STMT.a().equalsIgnoreCase(charSequence) || C1218kf.EWALLET_TXNS.a().equalsIgnoreCase(charSequence) || C1218kf.EWALLET_REGISTER.a().equalsIgnoreCase(charSequence) || C1218kf.ADD_LOYALITY.a().equalsIgnoreCase(charSequence) || C1218kf.PURCHASE_LOYALTY_POINTS.a().equalsIgnoreCase(charSequence)) {
                                B(this.f4196a);
                                HomeActivity homeActivity2 = this.f4196a;
                                MyAccountFragment myAccountFragment = new MyAccountFragment();
                                String a4 = kfVar5.a();
                                Boolean bool3 = Boolean.TRUE;
                                n(homeActivity2, myAccountFragment, a4, bool3, bool3);
                                return;
                            } else if (!z3) {
                                try {
                                    getSupportFragmentManager().E(getSupportFragmentManager().F() - 2).getName();
                                    String name = getSupportFragmentManager().E(getSupportFragmentManager().F() - 2).getName();
                                    if (charSequence.equalsIgnoreCase("SBI Buddy") || charSequence.equalsIgnoreCase("eWallet") || charSequence.equalsIgnoreCase("MobiKwik") || charSequence.equalsIgnoreCase("MobiKwik") || charSequence.equalsIgnoreCase("PayU") || charSequence.equalsIgnoreCase("SBI Buddy Verify") || charSequence.equalsIgnoreCase("MobiKwik OTP") || charSequence.equalsIgnoreCase("eWallet Verify") || charSequence.equalsIgnoreCase("AirtelMoney") || charSequence.equalsIgnoreCase("AirtelMoney OTP")) {
                                        C0535I5.p(this, false, getResources().getString(R.string.cancel_txn_msg), getResources().getString(R.string.cancel_txn_head), getResources().getString(R.string.yes), new c(name), getResources().getString(R.string.no), new d()).show();
                                        return;
                                    }
                                    C1218kf kfVar6 = C1218kf.REVIEW_JOURNEY;
                                    if (name.equalsIgnoreCase(kfVar6.a()) && C0822cf.f3936a) {
                                        if (this.f4195a == null) {
                                            this.f4195a = new C0822cf(this);
                                        }
                                        if (this.f4195a.getHyperServices().onBackPressed()) {
                                            return;
                                        }
                                    }
                                    super.onBackPressed();
                                    if (name.equals(kfVar.a()) && (C1218kf.TicketDetails.a().equalsIgnoreCase(charSequence) || kfVar3.a().equalsIgnoreCase(charSequence))) {
                                        for (Fragment fragment : getSupportFragmentManager().I()) {
                                            if ((fragment instanceof HomeFragment) && (str = C0535I5.l) != null && !str.isEmpty() && C0535I5.l.equalsIgnoreCase("Upcoming Journey")) {
                                                C0535I5.l = null;
                                            }
                                        }
                                    } else if (kfVar4.a().equalsIgnoreCase(charSequence)) {
                                        getSupportFragmentManager().I();
                                    }
                                    try {
                                        if (name.equals(kfVar.a())) {
                                            E();
                                        }
                                        if (!name.equals(C1218kf.ADD_PASSENGER.a()) && !name.equals(C1218kf.TRAIN_LIST.a())) {
                                            if (!name.equals(kfVar6.a())) {
                                                f4184a = false;
                                                F(name);
                                                return;
                                            }
                                        }
                                        f4184a = true;
                                    } catch (NullPointerException e3) {
                                        e3.getMessage();
                                    }
                                    F(name);
                                    return;
                                } catch (Exception e4) {
                                    e4.toString();
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    B(this.f4196a);
                    String a5 = kfVar.a();
                    Boolean bool4 = Boolean.TRUE;
                    n(this, this.f4197a, a5, bool4, bool4);
                    E();
                }
            }
        }
    }

    @OnClick({2131363241})
    public void onClickMoreDrawer(View view) {
        B(this.f4193a);
        MoreDrawerActivity moreDrawerActivity = new MoreDrawerActivity();
        String a2 = C1218kf.MORE_DRAWER.a();
        Boolean bool = Boolean.TRUE;
        n(this, moreDrawerActivity, a2, bool, bool);
        l(this.moreimage);
        this.moretext.setTextColor(getResources().getColor(R.color.red));
        this.moreimage.setColorFilter(this.f4196a.getResources().getColor(R.color.red));
        this.hometext.setTextColor(getResources().getColor(R.color.colorAccent));
        this.homeimage.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
        this.myaccounttext.setTextColor(getResources().getColor(R.color.colorAccent));
        this.myaccountimage.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
        this.transactionitext.setTextColor(getResources().getColor(R.color.colorAccent));
        this.transactionimaqe.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
    }

    public final void onCreate(Bundle bundle) {
        if (isFinishing()) {
            finish();
        }
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_screen);
        ButterKnife.bind((Activity) this);
        if (getIntent().getExtras() != null) {
            c = getIntent().getExtras().getInt("isDashBoardLanding");
        }
        AlertDialog alertDialog = C0535I5.f3619a;
        this.f4196a = this;
        this.f4193a = getApplicationContext();
        f4180a = (TextView) this.f4196a.findViewById(R.id.tv_title_name);
        f4185b = (TextView) this.f4196a.findViewById(R.id.tv_title_name_trainlist);
        f4188c = (TextView) this.f4196a.findViewById(R.id.tv_sub_title_name);
        f4190d = (TextView) this.f4196a.findViewById(R.id.tv_action_right);
        b = (ImageView) this.f4196a.findViewById(R.id.back);
        f4191e = (TextView) this.f4196a.findViewById(R.id.tv_action_right1);
        f = (TextView) this.f4196a.findViewById(R.id.tv_action_right_cancel);
        a = (ImageView) this.f4196a.findViewById(R.id.menu);
        f4179a = (LinearLayout) this.f4196a.findViewById(R.id.footer);
        f4187c = (ImageView) this.f4196a.findViewById(R.id.fevJourney);
        d = (ImageView) this.f4196a.findViewById(R.id.filterIcon);
        e = (ImageView) this.f4196a.findViewById(R.id.languageChange);
        g = (TextView) this.f4196a.findViewById(R.id.attention_msg);
        if (c == 0) {
            HomeFragment homeFragment = new HomeFragment();
            String a2 = C1218kf.HOME_PAGE.a();
            Boolean bool = Boolean.TRUE;
            n(this, homeFragment, a2, bool, bool);
            f4180a.setContentDescription(getResources().getString(R.string.irctc_rail));
        }
        g.setVisibility(8);
        f4191e.setText(getString(R.string.login));
        f4191e.setOnClickListener(new a());
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        SharedPreferences.Editor edit = this.f4194a.edit();
        edit.putLong("time", System.currentTimeMillis());
        edit.putBoolean("timepauseflag", true);
        edit.commit();
        ProgressDialog progressDialog = this.f4192a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4192a.dismiss();
        }
        C0535I5.u();
    }

    public final void onRestart() {
        super.onRestart();
    }

    public final void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.f4194a = defaultSharedPreferences;
        long j = currentTimeMillis - defaultSharedPreferences.getLong("time", 0);
        if (this.f4194a.getBoolean("timepauseflag", false) && j > 1800000) {
            B(this.f4193a);
            Intent intent = new Intent(this, IRCTCConnectActivity.class);
            intent.setFlags(67108864);
            intent.putExtra("refresh", true);
            startActivity(intent);
            finish();
        }
        this.f4194a.edit().putBoolean("timepauseflag", false);
        if (f4186b && f4189c != C1218kf.TRAIN_LIST.a()) {
            f4186b = false;
        }
        if (C0535I5.R()) {
            p();
        } else {
            I();
        }
    }

    public final void onStart() {
        super.onStart();
    }

    @OnClick({2131362783})
    public void setHome(View view) {
        String charSequence = f4180a.getText().toString();
        C1218kf kfVar = C1218kf.HOME_PAGE;
        if (!charSequence.equals(kfVar)) {
            B(this.f4193a);
            String a2 = kfVar.a();
            Boolean bool = Boolean.TRUE;
            n(this, this.f4197a, a2, bool, bool);
        }
        E();
        J();
    }

    @OnClick({2131363292})
    public void setMyAccount(View view) {
        if (C0535I5.R()) {
            B(this.f4193a);
            MyAccountFragment myAccountFragment = new MyAccountFragment();
            String a2 = C1218kf.MY_ACCOUNT.a();
            Boolean bool = Boolean.TRUE;
            n(this, myAccountFragment, a2, bool, bool);
            l(this.myaccountimage);
            this.myaccounttext.setTextColor(getResources().getColor(R.color.red));
            this.myaccountimage.setColorFilter(this.f4196a.getResources().getColor(R.color.red));
            this.hometext.setTextColor(getResources().getColor(R.color.colorAccent));
            this.homeimage.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
            this.transactionitext.setTextColor(getResources().getColor(R.color.colorAccent));
            this.transactionimaqe.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
            this.moretext.setTextColor(getResources().getColor(R.color.colorAccent));
            this.moreimage.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
            return;
        }
        A(2);
    }

    @OnClick({2131364220})
    public void setMyTransaction(View view) {
        if (C0535I5.R()) {
            B(this.f4193a);
            MyTransactionFragment myTransactionFragment = new MyTransactionFragment();
            String a2 = C1218kf.MY_TRANSACTIONS.a();
            Boolean bool = Boolean.TRUE;
            n(this, myTransactionFragment, a2, bool, bool);
            l(this.transactionimaqe);
            this.transactionitext.setTextColor(getResources().getColor(R.color.red));
            this.transactionimaqe.setColorFilter(this.f4196a.getResources().getColor(R.color.red));
            this.hometext.setTextColor(getResources().getColor(R.color.colorAccent));
            this.homeimage.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
            this.myaccounttext.setTextColor(getResources().getColor(R.color.colorAccent));
            this.myaccountimage.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
            this.moretext.setTextColor(getResources().getColor(R.color.colorAccent));
            this.moreimage.setColorFilter(this.f4196a.getResources().getColor(R.color.colorAccent));
            return;
        }
        A(2);
    }

    public class d implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
