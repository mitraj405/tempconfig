package cris.org.in.ima.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.services.StationListFetch;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.InformationMessageDTO;
import defpackage.C0535I5;
import defpackage.C0614Nv;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Subscriber;

public class IRCTCConnectActivity extends AppCompatActivity {
    public static final /* synthetic */ int d = 0;
    public final Bw a = Bw.e(this.f4202a);

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4201a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4202a;
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public String f4203c = "";
    @BindView(2131363165)
    TextView main_heading;

    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            IRCTCConnectActivity.this.finishAffinity();
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            int i2 = IRCTCConnectActivity.d;
            IRCTCConnectActivity.this.n();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            IRCTCConnectActivity.this.finishAffinity();
        }
    }

    public class e extends Subscriber<Oy> {
        public e() {
        }

        public final void onCompleted() {
            IRCTCConnectActivity iRCTCConnectActivity = IRCTCConnectActivity.this;
            if (iRCTCConnectActivity.f4201a != null && !iRCTCConnectActivity.isFinishing() && iRCTCConnectActivity.f4201a.isShowing()) {
                iRCTCConnectActivity.f4201a.dismiss();
            }
        }

        public final void onError(Throwable th) {
            IRCTCConnectActivity iRCTCConnectActivity = IRCTCConnectActivity.this;
            if (iRCTCConnectActivity.f4201a != null && !iRCTCConnectActivity.isFinishing() && iRCTCConnectActivity.f4201a.isShowing()) {
                iRCTCConnectActivity.f4201a.dismiss();
            }
            int i = IRCTCConnectActivity.d;
            th.getMessage();
            Lt.a(false, th);
        }

        public final void onNext(Object obj) {
            int i;
            Oy oy = (Oy) obj;
            IRCTCConnectActivity iRCTCConnectActivity = IRCTCConnectActivity.this;
            if (oy != null) {
                Calendar instance = Calendar.getInstance();
                Calendar instance2 = Calendar.getInstance();
                instance2.setTimeInMillis(new Date().getTime());
                instance.setTimeInMillis(oy.getTimeStamp().getTime());
                int i2 = instance.get(12);
                long j = (long) (instance.get(14) + ((instance.get(13) + ((i2 + (instance.get(11) * 60)) * 60)) * 1000));
                int i3 = instance2.get(12);
                C1450w1.f7015b = j - ((long) (instance2.get(14) + ((instance2.get(13) + ((i3 + (instance2.get(11) * 60)) * 60)) * 1000)));
                C1450w1.f7005a = 0;
                if (oy.getError() == null) {
                    Iterator<InformationMessageDTO> it = oy.getDisableRange().iterator();
                    String str = "";
                    boolean z = false;
                    while (true) {
                        JSONObject jSONObject = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        InformationMessageDTO next = it.next();
                        if (next.getParamName().equalsIgnoreCase("ON_LOAD") && next.getPopup().booleanValue()) {
                            str = next.getMessage();
                            z = next.getPopup().booleanValue();
                        }
                        if (next.getParamName().equalsIgnoreCase("BOOKNOW_MSG") && next.getPopup().booleanValue()) {
                            C0535I5.f3634c = true;
                        }
                        if (next.getParamName().equalsIgnoreCase("STATION_VERSION") && next.getMessage() != null && next.getMessage().length() > 0 && !Bw.e(iRCTCConnectActivity.f4202a).i().equalsIgnoreCase(next.getMessage())) {
                            iRCTCConnectActivity.f4203c = next.getMessage();
                        }
                        if (next.getParamName().equalsIgnoreCase("MAX_PREFERED_BERTH")) {
                            Bw e = Bw.e(iRCTCConnectActivity.f4202a);
                            try {
                                jSONObject = new JSONObject(next.getMessage());
                            } catch (JSONException e2) {
                                int i4 = IRCTCConnectActivity.d;
                                e2.getMessage();
                            }
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next2 = keys.next();
                                try {
                                    i = jSONObject.getInt(next2);
                                } catch (JSONException e3) {
                                    int i5 = IRCTCConnectActivity.d;
                                    e3.getMessage();
                                    i = 0;
                                }
                                if (next2.equalsIgnoreCase(ExpandedProductParsedResult.POUND)) {
                                    Integer valueOf = Integer.valueOf(i);
                                    C0614Nv.a c = e.f3534a.edit();
                                    c.putString("maxLbBerthKey", String.valueOf(valueOf));
                                    c.apply();
                                } else if (next2.equalsIgnoreCase("MB")) {
                                    Integer valueOf2 = Integer.valueOf(i);
                                    C0614Nv.a c2 = e.f3534a.edit();
                                    c2.putString("maxMbBerthKey", String.valueOf(valueOf2));
                                    c2.apply();
                                } else if (next2.equalsIgnoreCase("UB")) {
                                    Integer valueOf3 = Integer.valueOf(i);
                                    C0614Nv.a c3 = e.f3534a.edit();
                                    c3.putString("maxUbBerthKey", String.valueOf(valueOf3));
                                    c3.apply();
                                } else if (next2.equalsIgnoreCase("SL")) {
                                    Integer valueOf4 = Integer.valueOf(i);
                                    C0614Nv.a c4 = e.f3534a.edit();
                                    c4.putString("maxSlBerthKey", String.valueOf(valueOf4));
                                    c4.apply();
                                } else if (next2.equalsIgnoreCase("SU")) {
                                    Integer valueOf5 = Integer.valueOf(i);
                                    C0614Nv.a c5 = e.f3534a.edit();
                                    c5.putString("maxSuBerthKey", String.valueOf(valueOf5));
                                    c5.apply();
                                } else if (next2.equalsIgnoreCase("WS")) {
                                    Integer valueOf6 = Integer.valueOf(i);
                                    C0614Nv.a c6 = e.f3534a.edit();
                                    c6.putString("maxWsBerthKey", String.valueOf(valueOf6));
                                    c6.apply();
                                } else if (next2.equalsIgnoreCase("AS")) {
                                    Integer valueOf7 = Integer.valueOf(i);
                                    C0614Nv.a c7 = e.f3534a.edit();
                                    c7.putString("maxAsBerthKey", String.valueOf(valueOf7));
                                    c7.apply();
                                } else if (next2.equalsIgnoreCase("CB")) {
                                    Integer valueOf8 = Integer.valueOf(i);
                                    C0614Nv.a c8 = e.f3534a.edit();
                                    c8.putString("maxCbBerthKey", String.valueOf(valueOf8));
                                    c8.apply();
                                } else if (next2.equalsIgnoreCase("CP")) {
                                    Integer valueOf9 = Integer.valueOf(i);
                                    C0614Nv.a c9 = e.f3534a.edit();
                                    c9.putString("maxCpBerthKey", String.valueOf(valueOf9));
                                    c9.apply();
                                } else if (next2.equalsIgnoreCase("HB")) {
                                    Integer valueOf10 = Integer.valueOf(i);
                                    C0614Nv.a c10 = e.f3534a.edit();
                                    c10.putString("maxHbBerthKey", String.valueOf(valueOf10));
                                    c10.apply();
                                } else if (next2.equalsIgnoreCase("SM")) {
                                    Integer valueOf11 = Integer.valueOf(i);
                                    C0614Nv.a c11 = e.f3534a.edit();
                                    c11.putString("maxSmBerthKey", String.valueOf(valueOf11));
                                    c11.apply();
                                }
                            }
                        }
                    }
                    if (str.equals("") || !z) {
                        C1450w1.f7010a.clear();
                        C1450w1.f7010a = oy.getDisableRange();
                        C1450w1.f7023c = IRCTCConnectActivity.l(iRCTCConnectActivity, oy.getDisableRange());
                        C1450w1.f7008a = oy.getJuspayLoadDTO();
                        if (oy.getJuspayLoadDTO() != null) {
                            C0535I5.f3649j = true;
                        }
                        if (oy.getForceUpdate().booleanValue()) {
                            iRCTCConnectActivity.f4201a.dismiss();
                            C0535I5.p(IRCTCConnectActivity.this, false, oy.getInfoMsg().get(0), iRCTCConnectActivity.getString(R.string.upgrade_information), iRCTCConnectActivity.getString(R.string.upgrade), new C0846c(this), (String) null, (DialogInterface.OnClickListener) null).show();
                        } else if (oy.getUpdateRequired().booleanValue()) {
                            iRCTCConnectActivity.f4201a.dismiss();
                            C0535I5.p(IRCTCConnectActivity.this, false, oy.getInfoMsg().get(0), iRCTCConnectActivity.getString(R.string.upgrade_information), iRCTCConnectActivity.getString(R.string.upgrade), new C0847d(this), iRCTCConnectActivity.getString(R.string.no_thanks), new C0848e(this)).show();
                        } else {
                            iRCTCConnectActivity.f4201a.dismiss();
                            IRCTCConnectActivity.m(iRCTCConnectActivity);
                        }
                    } else if (iRCTCConnectActivity.getIntent().getExtras() == null || !iRCTCConnectActivity.getIntent().getExtras().getBoolean("refresh")) {
                        String string = iRCTCConnectActivity.getString(R.string.alert);
                        String string2 = iRCTCConnectActivity.getString(R.string.OK);
                        C0845b bVar = new C0845b(this, oy);
                        AlertDialog alertDialog = C0535I5.f3619a;
                        AlertDialog.Builder builder = new AlertDialog.Builder(iRCTCConnectActivity);
                        try {
                            View inflate = iRCTCConnectActivity.getLayoutInflater().inflate(R.layout.alert_msg_layout, (ViewGroup) null);
                            WebView webView = (WebView) inflate.findViewById(R.id.alert_web);
                            TextView textView = (TextView) inflate.findViewById(R.id.input_label);
                            webView.setWebViewClient(new WebViewClient());
                            webView.loadUrl("https://contents.irctc.co.in/en/Android_alerts_300x250.jpeg");
                            TextView textView2 = (TextView) inflate.findViewById(R.id.input_label);
                            textView2.setMovementMethod(LinkMovementMethod.getInstance());
                            textView2.setText(Html.fromHtml(str));
                            builder.setView(inflate);
                        } catch (Exception e4) {
                            e4.getMessage();
                            Spanned fromHtml = Html.fromHtml(str);
                            TextView textView3 = new TextView(iRCTCConnectActivity);
                            textView3.setText(fromHtml);
                            textView3.setGravity(3);
                            textView3.setPadding(80, 19, 30, 25);
                            textView3.setTextSize(16.0f);
                            textView3.setTextColor(iRCTCConnectActivity.getResources().getColor(R.color.dark));
                            textView3.setMovementMethod(LinkMovementMethod.getInstance());
                            builder.setView(textView3);
                        }
                        builder.setTitle(string);
                        builder.setPositiveButton(string2, bVar);
                        builder.setCancelable(false);
                        AlertDialog create = builder.create();
                        C0535I5.f3619a = create;
                        create.setCanceledOnTouchOutside(false);
                        C0535I5.f3619a.show();
                    } else {
                        C1450w1.f7010a.clear();
                        C1450w1.f7010a = oy.getDisableRange();
                        C1450w1.f7023c = IRCTCConnectActivity.l(iRCTCConnectActivity, oy.getDisableRange());
                        C1450w1.f7008a = oy.getJuspayLoadDTO();
                        if (oy.getJuspayLoadDTO() != null) {
                            C0535I5.f3649j = true;
                        }
                        IRCTCConnectActivity.m(iRCTCConnectActivity);
                    }
                } else {
                    iRCTCConnectActivity.f4201a.dismiss();
                    C0535I5.t0(iRCTCConnectActivity.getBaseContext(), oy.getError());
                }
            } else {
                iRCTCConnectActivity.f4201a.dismiss();
                C0535I5.t0(iRCTCConnectActivity.getBaseContext(), "Response not received. Please try again.");
            }
        }
    }

    static {
        C1354qp.R(IRCTCConnectActivity.class);
    }

    public static HashMap l(IRCTCConnectActivity iRCTCConnectActivity, ArrayList arrayList) {
        iRCTCConnectActivity.getClass();
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            InformationMessageDTO informationMessageDTO = (InformationMessageDTO) it.next();
            hashMap.put(informationMessageDTO.getParamName(), informationMessageDTO.getMessage());
        }
        return hashMap;
    }

    public static void m(IRCTCConnectActivity iRCTCConnectActivity) {
        iRCTCConnectActivity.getClass();
        try {
            C0535I5.a0(iRCTCConnectActivity);
        } catch (Exception e2) {
            e2.getMessage();
        }
        HomeActivity.c = 0;
        C0535I5.a = 0;
        C0535I5.b = 0;
        C0535I5.c = 0;
        C0535I5.f3623a = null;
        C0535I5.f3633c = null;
        C0535I5.f3628b = null;
        C0535I5.f3622a = null;
        C0535I5.f3637d = null;
        C0535I5.f3620a = null;
        C0535I5.f3616a = new C0535I5.b();
        C0535I5.f3627b = null;
        C0535I5.f3626b = null;
        C0535I5.f3631c = null;
        C0535I5.f3635d = null;
        C0535I5.f3617a = null;
        C0535I5.f3632c = new ArrayList<>();
        C0793b1.a.f3912a = null;
        C0535I5.d = 0;
        C1450w1.f7024c = false;
        C1450w1.f7007a = null;
        C0535I5.f3644g = null;
        C0535I5.f3615a = null;
        if (iRCTCConnectActivity.f4203c.length() > 0) {
            Intent intent = new Intent(iRCTCConnectActivity.getApplicationContext(), StationListFetch.class);
            intent.putExtra("stationHash", iRCTCConnectActivity.f4203c);
            iRCTCConnectActivity.getApplicationContext().startService(intent);
        }
        Intent intent2 = new Intent(iRCTCConnectActivity, HomeActivity.class);
        intent2.putExtra("isDashBoardLanding", 0);
        if (C0535I5.f3625a) {
            iRCTCConnectActivity.finish();
        }
        iRCTCConnectActivity.startActivity(intent2);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n() {
        /*
            r11 = this;
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r11.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.app.AlertDialog r1 = defpackage.C0535I5.f3619a
            r1 = 1
            r2 = 0
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch:{ Exception -> 0x001a }
            if (r0 == 0) goto L_0x0028
            boolean r0 = r0.isConnected()     // Catch:{ Exception -> 0x001a }
            if (r0 == 0) goto L_0x0028
            r0 = r1
            goto L_0x0029
        L_0x001a:
            r0 = move-exception
            r0.getMessage()
            r0 = 2131953888(0x7f1308e0, float:1.954426E38)
            java.lang.String r0 = r11.getString(r0)
            defpackage.C0535I5.t0(r11, r0)
        L_0x0028:
            r0 = r2
        L_0x0029:
            if (r0 != 0) goto L_0x0063
            r4 = 0
            android.content.res.Resources r0 = r11.getResources()
            r1 = 2131952536(0x7f130398, float:1.9541518E38)
            java.lang.String r5 = r0.getString(r1)
            android.content.res.Resources r0 = r11.getResources()
            r1 = 2131951855(0x7f1300ef, float:1.9540136E38)
            java.lang.String r6 = r0.getString(r1)
            r0 = 2131953620(0x7f1307d4, float:1.9543716E38)
            java.lang.String r7 = r11.getString(r0)
            cris.org.in.ima.activities.IRCTCConnectActivity$c r8 = new cris.org.in.ima.activities.IRCTCConnectActivity$c
            r8.<init>()
            r0 = 2131952748(0x7f13046c, float:1.9541948E38)
            java.lang.String r9 = r11.getString(r0)
            cris.org.in.ima.activities.IRCTCConnectActivity$d r10 = new cris.org.in.ima.activities.IRCTCConnectActivity$d
            r10.<init>()
            r3 = r11
            android.app.AlertDialog r0 = defpackage.C0535I5.p(r3, r4, r5, r6, r7, r8, r9, r10)
            r0.show()
            return
        L_0x0063:
            android.content.Context r0 = r11.f4202a
            Bw r0 = defpackage.Bw.e(r0)
            r0.f()
            java.lang.String r0 = r0.f()
            java.lang.String r3 = "hi"
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x0083
            java.lang.String r0 = "मान्य किया जा रहा है…."
            java.lang.String r3 = "कृपया प्रतीक्षा करें…"
            android.app.ProgressDialog r0 = android.app.ProgressDialog.show(r11, r0, r3)
            r11.f4201a = r0
            goto L_0x008d
        L_0x0083:
            java.lang.String r0 = "Validating"
            java.lang.String r3 = "Please wait..."
            android.app.ProgressDialog r0 = android.app.ProgressDialog.show(r11, r0, r3)
            r11.f4201a = r0
        L_0x008d:
            android.content.pm.PackageManager r0 = r11.getPackageManager()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r3 = r11.getPackageName()     // Catch:{ Exception -> 0x00e8 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r2)     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r0 = r0.versionName     // Catch:{ Exception -> 0x00e8 }
            defpackage.C0657Qt.a()     // Catch:{ Exception -> 0x00e8 }
            java.lang.Object r3 = defpackage.C0657Qt.b()     // Catch:{ Exception -> 0x00e8 }
            Om r3 = (defpackage.Om) r3     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r4 = defpackage.C0657Qt.f()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r5 = "appVersion"
            java.lang.String r6 = "/%s/%s"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r8 = "ANDROID"
            r7[r2] = r8     // Catch:{ Exception -> 0x00e8 }
            r7[r1] = r0     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r0 = java.lang.String.format(r6, r7)     // Catch:{ Exception -> 0x00e8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e8 }
            r1.<init>()     // Catch:{ Exception -> 0x00e8 }
            r1.append(r4)     // Catch:{ Exception -> 0x00e8 }
            r1.append(r5)     // Catch:{ Exception -> 0x00e8 }
            r1.append(r0)     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x00e8 }
            rx.Observable r0 = r3.Y0(r0)     // Catch:{ Exception -> 0x00e8 }
            Lm r1 = defpackage.C1181iv.a()     // Catch:{ Exception -> 0x00e8 }
            rx.Observable r0 = r0.c(r1)     // Catch:{ Exception -> 0x00e8 }
            Yi r1 = defpackage.E0.a()     // Catch:{ Exception -> 0x00e8 }
            rx.Observable r0 = r0.a(r1)     // Catch:{ Exception -> 0x00e8 }
            cris.org.in.ima.activities.IRCTCConnectActivity$e r1 = new cris.org.in.ima.activities.IRCTCConnectActivity$e     // Catch:{ Exception -> 0x00e8 }
            r1.<init>()     // Catch:{ Exception -> 0x00e8 }
            r0.b(r1)     // Catch:{ Exception -> 0x00e8 }
            goto L_0x00ff
        L_0x00e8:
            r0 = move-exception
            android.app.ProgressDialog r1 = r11.f4201a
            r1.dismiss()
            r0.getMessage()
            android.content.Context r0 = r11.getBaseContext()
            r1 = 2131953492(0x7f130754, float:1.9543457E38)
            java.lang.String r1 = r11.getString(r1)
            defpackage.C0535I5.t0(r0, r1)
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.IRCTCConnectActivity.n():void");
    }

    public final void o() {
        if (IrctcImaApplication.c != null && (d7.a(this, "android.permission.POST_NOTIFICATIONS") == 0 || Integer.parseInt(this.a.f3534a.getString("0", "0")) >= 2 || Build.VERSION.SDK_INT <= 32)) {
            n();
        } else if (Build.VERSION.SDK_INT >= 33) {
            J.e(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 25);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            super.onCreate(r9)
            r9 = 2131558450(0x7f0d0032, float:1.8742216E38)
            r8.setContentView((int) r9)
            butterknife.ButterKnife.bind((android.app.Activity) r8)
            android.content.Context r9 = r8.f4202a
            Bw r9 = defpackage.Bw.e(r9)
            java.lang.String r0 = r9.f()
            java.lang.String r1 = "hi"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0025
            android.widget.TextView r0 = r8.main_heading
            java.lang.String r1 = "आईआरसीटीसी रेल कनेक्ट"
            r0.setText(r1)
        L_0x0025:
            r9.f()
            android.content.Intent r9 = r8.getIntent()
            android.os.Bundle r9 = r9.getExtras()
            if (r9 == 0) goto L_0x0048
            android.content.Intent r9 = r8.getIntent()
            android.os.Bundle r9 = r9.getExtras()
            java.lang.String r0 = "ima"
            boolean r1 = r9.containsKey(r0)
            if (r1 == 0) goto L_0x0048
            boolean r9 = r9.getBoolean(r0)
            defpackage.C0535I5.f3625a = r9
        L_0x0048:
            android.content.Context r9 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x0053 }
            com.momagic.h$j r9 = new com.momagic.h$j     // Catch:{ Exception -> 0x0053 }
            r9.<init>(r8)     // Catch:{ Exception -> 0x0053 }
            r9.a()     // Catch:{ Exception -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r9 = move-exception
            r9.getMessage()
        L_0x0057:
            android.content.Intent r9 = r8.getIntent()
            android.os.Bundle r9 = r9.getExtras()
            r0 = 1
            r1 = 1000(0x3e8, double:4.94E-321)
            if (r9 == 0) goto L_0x0078
            android.content.Intent r9 = r8.getIntent()
            android.os.Bundle r9 = r9.getExtras()
            java.lang.String r3 = "logout"
            boolean r9 = r9.getBoolean(r3)
            if (r9 != r0) goto L_0x0078
            r8.finish()
            goto L_0x0088
        L_0x0078:
            r8.o()
            android.os.Handler r9 = new android.os.Handler
            r9.<init>()
            cris.org.in.ima.activities.IRCTCConnectActivity$a r3 = new cris.org.in.ima.activities.IRCTCConnectActivity$a
            r3.<init>()
            r9.postDelayed(r3, r1)
        L_0x0088:
            android.app.AlertDialog r9 = defpackage.C0535I5.f3619a
            java.lang.String r9 = android.os.Build.TAGS
            r3 = 0
            if (r9 == 0) goto L_0x0099
            java.lang.String r4 = "test-keys"
            boolean r9 = r9.contains(r4)
            if (r9 == 0) goto L_0x0099
            r9 = r0
            goto L_0x009a
        L_0x0099:
            r9 = r3
        L_0x009a:
            if (r9 != 0) goto L_0x0151
            java.io.File r9 = new java.io.File
            java.lang.String r4 = "/system/xbin/su"
            r9.<init>(r4)
            boolean r9 = r9.exists()
            if (r9 != 0) goto L_0x00b9
            java.io.File r9 = new java.io.File
            java.lang.String r4 = "/system/bin/su"
            r9.<init>(r4)
            boolean r9 = r9.exists()
            if (r9 == 0) goto L_0x00b7
            goto L_0x00b9
        L_0x00b7:
            r9 = r3
            goto L_0x00ba
        L_0x00b9:
            r9 = r0
        L_0x00ba:
            if (r9 != 0) goto L_0x0151
            java.io.File r9 = new java.io.File     // Catch:{ IOException -> 0x00d2 }
            java.lang.String r4 = "/data/test.txt"
            r9.<init>(r4)     // Catch:{ IOException -> 0x00d2 }
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ IOException -> 0x00d2 }
            r4.<init>(r9)     // Catch:{ IOException -> 0x00d2 }
            java.lang.String r9 = "Test"
            r4.write(r9)     // Catch:{ IOException -> 0x00d2 }
            r4.close()     // Catch:{ IOException -> 0x00d2 }
            r9 = r0
            goto L_0x00d3
        L_0x00d2:
            r9 = r3
        L_0x00d3:
            if (r9 != 0) goto L_0x0151
            java.io.File r9 = new java.io.File
            java.lang.String r4 = "/system/app/Superuser.apk"
            r9.<init>(r4)
            boolean r9 = r9.exists()
            if (r9 != 0) goto L_0x0151
            java.lang.String r9 = "/system/bin/busybox"
            java.lang.String r4 = "/system/xbin/busybox"
            java.lang.String r5 = "/sbin/busybox"
            java.lang.String[] r9 = new java.lang.String[]{r5, r9, r4}
            r4 = r3
        L_0x00ed:
            r5 = 3
            if (r4 >= r5) goto L_0x0102
            r5 = r9[r4]
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            boolean r5 = r6.exists()
            if (r5 == 0) goto L_0x00ff
            r9 = r0
            goto L_0x0103
        L_0x00ff:
            int r4 = r4 + 1
            goto L_0x00ed
        L_0x0102:
            r9 = r3
        L_0x0103:
            if (r9 != 0) goto L_0x0151
            java.lang.String r9 = "/system/bin/magisk"
            java.lang.String r4 = "/system/xbin/magisk"
            java.lang.String r5 = "/sbin/magisk"
            java.lang.String r6 = "/data/adb/magisk/busybox"
            java.lang.String r7 = "/sbin/.magisk"
            java.lang.String[] r9 = new java.lang.String[]{r5, r9, r4, r6, r7}
            r4 = r3
        L_0x0114:
            r5 = 5
            if (r4 >= r5) goto L_0x0129
            r5 = r9[r4]
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            boolean r5 = r6.exists()
            if (r5 == 0) goto L_0x0126
            r9 = r0
            goto L_0x012a
        L_0x0126:
            int r4 = r4 + 1
            goto L_0x0114
        L_0x0129:
            r9 = r3
        L_0x012a:
            if (r9 != 0) goto L_0x0151
            java.lang.String r9 = android.os.Build.TAGS
            if (r9 == 0) goto L_0x013a
            java.lang.String r4 = "secure"
            boolean r9 = r9.contains(r4)
            if (r9 == 0) goto L_0x013a
            r9 = r0
            goto L_0x013b
        L_0x013a:
            r9 = r3
        L_0x013b:
            if (r9 != 0) goto L_0x0151
            java.lang.String r9 = android.os.Build.TAGS
            if (r9 == 0) goto L_0x014b
            java.lang.String r4 = "mock"
            boolean r9 = r9.contains(r4)
            if (r9 == 0) goto L_0x014b
            r9 = r0
            goto L_0x014c
        L_0x014b:
            r9 = r3
        L_0x014c:
            if (r9 == 0) goto L_0x014f
            goto L_0x0151
        L_0x014f:
            r9 = r3
            goto L_0x0152
        L_0x0151:
            r9 = r0
        L_0x0152:
            if (r9 == 0) goto L_0x0165
            r9 = 2131954015(0x7f13095f, float:1.9544517E38)
            java.lang.String r9 = r8.getString(r9)
            android.widget.Toast r9 = android.widget.Toast.makeText(r8, r9, r0)
            r9.show()
            r8.finish()
        L_0x0165:
            java.lang.String r9 = "com.tatkal.train.ticket"
            android.content.pm.PackageManager r4 = r8.getPackageManager()     // Catch:{ Exception -> 0x0170 }
            r4.getPackageInfo(r9, r0)     // Catch:{ Exception -> 0x0170 }
            r3 = r0
            goto L_0x0174
        L_0x0170:
            r9 = move-exception
            r9.getMessage()
        L_0x0174:
            if (r3 == 0) goto L_0x0192
            r9 = 2131953901(0x7f1308ed, float:1.9544286E38)
            java.lang.String r9 = r8.getString(r9)
            android.widget.Toast r9 = android.widget.Toast.makeText(r8, r9, r0)
            r9.show()
            android.os.Handler r9 = new android.os.Handler
            r9.<init>()
            cris.org.in.ima.activities.IRCTCConnectActivity$b r0 = new cris.org.in.ima.activities.IRCTCConnectActivity$b
            r0.<init>()
            r9.postDelayed(r0, r1)
            return
        L_0x0192:
            android.content.Context r9 = r8.getBaseContext()
            r8.f4202a = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.IRCTCConnectActivity.onCreate(android.os.Bundle):void");
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        int i2 = 0;
        for (String equals : strArr) {
            if (equals.equals("android.permission.POST_NOTIFICATIONS")) {
                if (iArr[i2] == 0) {
                    ((IrctcImaApplication) getApplication()).b();
                } else {
                    Toast.makeText(this, R.string.notification_msg, 0).show();
                    int i3 = this.c + 1;
                    this.c = i3;
                    String valueOf = String.valueOf(i3);
                    C0614Nv nv = this.a.f3534a;
                    nv.getClass();
                    SharedPreferences.Editor edit = nv.a.edit();
                    edit.putString(C0614Nv.e("0"), C0614Nv.a(nv, valueOf));
                    edit.commit();
                }
            }
            i2++;
        }
        o();
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public class a implements Runnable {
        public final void run() {
        }
    }
}
