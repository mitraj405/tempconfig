package com.paytm.easypay;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.webkit.JavascriptInterface;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.perf.network.FirebasePerfHttpClient;
import com.paytm.pgsdk.PaytmWebView;
import defpackage.C0760Yo;
import defpackage.C1306oo;
import defpackage.C1355qs;
import defpackage.C1394sq;
import defpackage.Y1;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class EasypayBrowserFragment extends Fragment implements View.OnClickListener {
    public Y1 a;

    /* renamed from: a  reason: collision with other field name */
    public C0760Yo f4067a;

    /* renamed from: a  reason: collision with other field name */
    public Activity f4068a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences.Editor f4069a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f4070a;

    /* renamed from: a  reason: collision with other field name */
    public View f4071a;

    /* renamed from: a  reason: collision with other field name */
    public ImageView f4072a;

    /* renamed from: a  reason: collision with other field name */
    public LinearLayout f4073a;

    /* renamed from: a  reason: collision with other field name */
    public final a f4074a = new a();

    /* renamed from: a  reason: collision with other field name */
    public PaytmWebView f4075a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<Map<String, String>> f4076a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public C1306oo f4077a;

    /* renamed from: a  reason: collision with other field name */
    public C1355qs f4078a;

    /* renamed from: a  reason: collision with other field name */
    public C1394sq f4079a;

    /* renamed from: a  reason: collision with other field name */
    public C0360vA f4080a;
    public SharedPreferences.Editor b;

    /* renamed from: b  reason: collision with other field name */
    public SharedPreferences f4081b;

    /* renamed from: b  reason: collision with other field name */
    public ImageView f4082b;

    /* renamed from: b  reason: collision with other field name */
    public LinearLayout f4083b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<Map<String, String>> f4084b = new ArrayList<>();
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public String f4085c = "";
    public String d;
    public String e;

    public class a extends BroadcastReceiver {
        public a() {
        }

        public final void onReceive(Context context, Intent intent) {
            EasypayBrowserFragment.this.a();
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.f4071a.setVisibility(8);
            easypayBrowserFragment.f4073a.setVisibility(8);
            easypayBrowserFragment.f4083b.setBackgroundColor(Color.parseColor("#F2F1F1"));
            easypayBrowserFragment.f4082b.setVisibility(0);
            return false;
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public final void run() {
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            try {
                String string = easypayBrowserFragment.f4070a.getString("merchant_mid", "");
                FirebasePerfHttpClient.execute(new DefaultHttpClient(), new HttpGet(easypayBrowserFragment.getString(C0787as.easypay_error_endpoint) + "?user=" + easypayBrowserFragment.d + "&mid=" + string + "&device=" + easypayBrowserFragment.e + "&ruleid=" + easypayBrowserFragment.f4085c));
            } catch (Exception unused) {
            }
        }
    }

    public class j extends AlertDialog {
        public j(Activity activity) {
            super(activity, 3);
        }

        public final void show() {
            super.show();
            setContentView(C0697Tr.progress_dialog);
        }
    }

    public static ArrayList b(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            HashMap hashMap = new HashMap();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                hashMap.put(jsonReader.nextName(), jsonReader.nextString());
            }
            jsonReader.endObject();
            arrayList.add(hashMap);
        }
        jsonReader.endArray();
        return arrayList;
    }

    public final void a() {
        try {
            this.f4076a = c("rules");
            this.f4084b = c("features");
            Long valueOf = Long.valueOf(Long.parseLong((String) c(PaymentConstants.Category.CONFIG).get(0).get("ttl")));
            SharedPreferences.Editor edit = this.f4068a.getSharedPreferences("com.paytm.easypay.PREFERENCE_FILE_KEY", 0).edit();
            edit.putLong("easypay_configuration_ttl", valueOf.longValue());
            edit.commit();
        } catch (Exception e2) {
            synchronized (C1354qp.class) {
                e2.printStackTrace();
            }
        }
    }

    public final ArrayList<Map<String, String>> c(String str) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(this.f4068a.getApplicationContext().openFileInput("easypay_configuration.json"), "UTF-8"));
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals(str)) {
                    return b(jsonReader);
                }
                jsonReader.skipValue();
            }
            jsonReader.endObject();
            ArrayList<Map<String, String>> b2 = b(jsonReader);
            jsonReader.close();
            return b2;
        } finally {
            jsonReader.close();
        }
    }

    public final void d() {
        C1355qs.a aVar;
        C1306oo.c cVar;
        View view = this.f4071a;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = this.f4082b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        Y1 y1 = this.a;
        if (y1 != null) {
            try {
                Y1.b bVar = y1.f3842a;
                if (bVar != null) {
                    y1.f3843a.unregisterReceiver(bVar);
                }
            } catch (Exception unused) {
            }
            y1.f3846a.e(C0501Er.autoFillerHelperHeader, Boolean.FALSE);
            Y1.a aVar2 = y1.a;
            EditText editText = y1.f3845a;
            editText.removeTextChangedListener(aVar2);
            editText.setText("");
            this.a = null;
        }
        C1306oo ooVar = this.f4077a;
        if (ooVar != null) {
            Activity activity = ooVar.a;
            ooVar.f5642a.e(C0501Er.otpHelper, Boolean.FALSE);
            ooVar.b(Boolean.TRUE);
            try {
                C1306oo.d dVar = ooVar.f5648a;
                if (dVar != null) {
                    activity.unregisterReceiver(dVar);
                }
            } catch (Exception unused2) {
            }
            ooVar.f5641a.setText(activity.getString(C0787as.submit_otp));
            EditText editText2 = (EditText) activity.findViewById(C0501Er.editTextOtp);
            editText2.setText("");
            editText2.removeTextChangedListener(ooVar.f5649a);
            ((Button) activity.findViewById(C0501Er.buttonApproveOtp)).setEnabled(false);
            try {
                if (ooVar.f5643a.booleanValue() && (cVar = ooVar.f5647a) != null) {
                    activity.unregisterReceiver(cVar);
                    ooVar.f5643a = Boolean.FALSE;
                }
            } catch (Exception unused3) {
            }
            this.f4077a = null;
        }
        C1394sq sqVar = this.f4079a;
        if (sqVar != null) {
            try {
                C1394sq.a aVar3 = sqVar.f6962a;
                if (aVar3 != null) {
                    sqVar.a.unregisterReceiver(aVar3);
                }
            } catch (Exception unused4) {
            }
            sqVar.f6960a.e(C0501Er.buttonProceed, Boolean.FALSE);
            this.f4079a = null;
        }
        C1355qs qsVar = this.f4078a;
        if (qsVar != null) {
            try {
                Activity activity2 = qsVar.a;
                if (!(activity2 == null || (aVar = qsVar.f6928a) == null)) {
                    activity2.unregisterReceiver(aVar);
                }
            } catch (Exception unused5) {
                synchronized (C1354qp.class) {
                }
            }
            qsVar.f6926a.e(C0501Er.radioHelper, Boolean.FALSE);
            this.f4078a = null;
        }
        C0760Yo yo = this.f4067a;
        if (yo != null) {
            try {
                C0760Yo.b bVar2 = yo.a;
                if (bVar2 != null) {
                    yo.f3869a.unregisterReceiver(bVar2);
                }
            } catch (Exception unused6) {
            }
            yo.f3871a.setText("");
            yo.f3872a.e(C0501Er.passwordHelper, Boolean.FALSE);
            this.f4067a = null;
        }
        if (this.f4080a != null) {
            this.f4080a = null;
        }
    }

    public final void e(int i2, Boolean bool) {
        int i3;
        View findViewById = this.f4068a.findViewById(i2);
        if (bool.booleanValue()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (findViewById.getVisibility() != i3) {
            LinearLayout linearLayout = (LinearLayout) this.f4068a.findViewById(C0501Er.headerContainer);
            if (bool.booleanValue()) {
                this.f4082b.setVisibility(8);
                this.f4071a.setVisibility(0);
                linearLayout.setVisibility(0);
                findViewById.setVisibility(i3);
            }
            DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
            if (bool.booleanValue() && this.c == 0) {
                linearLayout.animate().translationY((float) 0).setDuration(200).setInterpolator(decelerateInterpolator).start();
            }
            int i4 = 1;
            if (!bool.booleanValue() && this.c == 1) {
                ViewPropertyAnimator animate = linearLayout.animate();
                this.f4071a.setVisibility(8);
                animate.translationY((float) -120).setDuration(200).setInterpolator(decelerateInterpolator).setListener(new i(findViewById, animate)).start();
            }
            if (!bool.booleanValue() && this.c > 1) {
                findViewById.setVisibility(i3);
            }
            if (!bool.booleanValue()) {
                linearLayout.setVisibility(8);
            }
            int i5 = this.c;
            if (!bool.booleanValue()) {
                i4 = -1;
            }
            int i6 = i5 + i4;
            this.c = i6;
            if (i6 < 0) {
                this.c = 0;
            }
        }
    }

    @JavascriptInterface
    public void logData(String str, String str2) {
        this.f4069a.putString(str, str2);
        this.f4069a.commit();
    }

    @JavascriptInterface
    public void logError(String str) {
        this.f4085c = str;
        String j2 = lf.j("rule_", str, "error_date");
        int date = Calendar.getInstance().getTime().getDate();
        if (this.f4070a.getInt(j2, 0) != date) {
            this.f4069a.putInt(j2, date);
            this.f4069a.commit();
            new Thread(new h()).start();
        }
    }

    @JavascriptInterface
    public void logEvent(String str, String str2) {
        String D = xx.D(str2, "_", str);
        this.b.putInt(D, this.f4081b.getInt(D, 0) + 1);
        this.b.commit();
    }

    @JavascriptInterface
    public void logTempData(String str) {
        C1306oo ooVar;
        C0760Yo yo = this.f4067a;
        if (yo == null && (ooVar = this.f4077a) != null) {
            ooVar.f5650b = str;
            ooVar.a.runOnUiThread(new C1331po(ooVar));
        } else if (yo != null) {
            yo.b = str;
            yo.a();
        }
    }

    @TargetApi(21)
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f4075a = (PaytmWebView) this.f4068a.findViewById(C0501Er.webView1);
        this.f4071a = this.f4068a.findViewById(C0501Er.overlay_webview);
        ImageView imageView = (ImageView) this.f4068a.findViewById(C0501Er.down_hide);
        this.f4072a = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.f4068a.findViewById(C0501Er.down_show);
        this.f4082b = imageView2;
        imageView2.setOnClickListener(this);
        this.f4071a.setOnTouchListener(new b());
        this.f4083b = (LinearLayout) this.f4068a.findViewById(C0501Er.my_content);
        this.f4075a.getSettings().setJavaScriptEnabled(true);
        this.f4075a.getSettings().setMixedContentMode(0);
        this.f4075a.addJavascriptInterface(this, "Android");
        new j(getActivity()).getWindow().setGravity(17);
        this.f4075a.setWebViewClient(this);
        this.f4075a.setWebChromeClient(new C0719V9());
        SharedPreferences sharedPreferences = this.f4068a.getSharedPreferences("com.paytm.easypay.PREFERENCE_FILE_KEY", 0);
        this.f4070a = sharedPreferences;
        this.f4069a = sharedPreferences.edit();
        SharedPreferences sharedPreferences2 = this.f4068a.getSharedPreferences("com.paytm.easypay.EVENTS_FILE", 0);
        this.f4081b = sharedPreferences2;
        this.b = sharedPreferences2.edit();
        Activity activity = this.f4068a;
        int i2 = C0501Er.buttonShowPassword;
        activity.findViewById(i2).setOnClickListener(this);
        this.f4068a.findViewById(C0501Er.radioOption1).setOnClickListener(this);
        this.f4068a.findViewById(C0501Er.radioOption2).setOnClickListener(this);
        this.f4068a.findViewById(C0501Er.buttonProceed).setOnClickListener(this);
        this.f4068a.findViewById(C0501Er.buttonApproveOtp).setOnClickListener(this);
        Activity activity2 = this.f4068a;
        int i3 = C0501Er.buttonResendOtp;
        activity2.findViewById(i3).setOnClickListener(this);
        this.f4068a.findViewById(i3).setOnClickListener(this);
        this.f4068a.findViewById(C0501Er.autoFillerHelperButton).setOnClickListener(this);
        this.f4068a.findViewById(C0501Er.button_submit_password).setOnClickListener(this);
        TextView textView = (TextView) this.f4068a.findViewById(i2);
        LinearLayout linearLayout = (LinearLayout) this.f4068a.findViewById(C0501Er.headerContainer);
        this.f4073a = linearLayout;
        linearLayout.setOnTouchListener(new c(this.f4068a));
        this.f4072a.setOnTouchListener(new d(this.f4068a));
        ((LinearLayout) this.f4068a.findViewById(C0501Er.up_arrow_container)).setOnClickListener(this);
        a();
        this.f4068a.registerReceiver(this.f4074a, new IntentFilter("com.drc.paytm_example.EASYPAY_CONFIG_DOWNLOADED"));
        this.d = Settings.Secure.getString(this.f4068a.getContentResolver(), "android_id");
        this.e = Build.MANUFACTURER + "-" + Build.MODEL + "-" + Build.VERSION.RELEASE;
    }

    public final void onClick(View view) {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        if (view.getId() == C0501Er.down_hide) {
            this.f4083b.setBackgroundColor(Color.parseColor("#FFFFFF"));
            this.f4071a.setVisibility(8);
            ViewPropertyAnimator animate = this.f4073a.animate();
            animate.translationY((float) this.f4073a.getHeight()).setDuration(500).setInterpolator(decelerateInterpolator).setListener(new e(animate)).start();
        }
        if (view.getId() == C0501Er.down_show) {
            this.f4082b.setVisibility(8);
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
            this.f4073a.setVisibility(0);
            this.f4083b.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ViewPropertyAnimator animate2 = this.f4073a.animate();
            animate2.translationY((float) 0).setDuration(500).setInterpolator(accelerateInterpolator).setListener(new f(animate2)).start();
        }
        if (view.getId() == C0501Er.up_arrow_container) {
            this.f4082b.setVisibility(8);
            AccelerateInterpolator accelerateInterpolator2 = new AccelerateInterpolator();
            this.f4073a.setVisibility(0);
            this.f4083b.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ViewPropertyAnimator animate3 = this.f4073a.animate();
            animate3.translationY((float) 0).setDuration(500).setInterpolator(accelerateInterpolator2).setListener(new g(animate3)).start();
        }
        if (view.getId() == C0501Er.autoFillerHelperButton) {
            sendEvent("toggleAutoFiller", "false", "");
        }
        if (view.getId() == C0501Er.buttonShowPassword) {
            sendEvent("togglePassword", "", "");
        }
        if (view.getId() == C0501Er.radioOption1) {
            sendEvent("selectRadioOption", C0515Ga.AVLBLTY_ONLY, "");
        }
        if (view.getId() == C0501Er.radioOption2) {
            sendEvent("selectRadioOption", C0515Ga.FARE_ONLY, "");
        }
        if (view.getId() == C0501Er.buttonProceed) {
            sendEvent("proceedProceedHelper", "", "");
        }
        if (view.getId() == C0501Er.buttonApproveOtp) {
            sendEvent("approveOtp", "", "");
        }
        if (view.getId() == C0501Er.buttonResendOtp) {
            sendEvent("resendOtp", "", "");
        }
        if (view.getId() == C0501Er.button_submit_password) {
            sendEvent("submitPassword", "", "");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C0697Tr.easypay_browser_fragment, viewGroup, false);
        this.f4068a = getActivity();
        return inflate;
    }

    public final void onDestroy() {
        a aVar;
        Activity activity;
        C0760Yo.b bVar;
        C0760Yo yo = this.f4067a;
        if (!(yo == null || (activity = yo.f3869a) == null || (bVar = yo.a) == null)) {
            activity.unregisterReceiver(bVar);
        }
        Activity activity2 = this.f4068a;
        if (!(activity2 == null || (aVar = this.f4074a) == null)) {
            activity2.unregisterReceiver(aVar);
        }
        super.onDestroy();
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction("com.paytm.easypay.CUSTOM_EVENT");
        intent.putExtra("eventName", str);
        intent.putExtra("data0", str2);
        intent.putExtra("data1", str3);
        this.f4068a.sendBroadcast(intent);
    }

    @JavascriptInterface
    public void showToast(String str) {
        Toast.makeText(this.f4068a, str, 0).show();
    }

    public class c extends C0827co {
        public c(Activity activity) {
            super(activity);
        }

        public final void b() {
            DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.f4083b.setBackgroundColor(Color.parseColor("#FFFFFF"));
            easypayBrowserFragment.f4071a.setVisibility(8);
            ViewPropertyAnimator animate = easypayBrowserFragment.f4073a.animate();
            animate.translationY((float) easypayBrowserFragment.f4073a.getHeight()).setDuration(500).setInterpolator(decelerateInterpolator).setListener(new a(animate)).start();
        }

        public final void c() {
        }

        public class a implements Animator.AnimatorListener {
            public final /* synthetic */ ViewPropertyAnimator a;

            public a(ViewPropertyAnimator viewPropertyAnimator) {
                this.a = viewPropertyAnimator;
            }

            public final void onAnimationCancel(Animator animator) {
                this.a.setListener((Animator.AnimatorListener) null);
            }

            public final void onAnimationEnd(Animator animator) {
                c cVar = c.this;
                EasypayBrowserFragment.this.f4073a.setVisibility(8);
                EasypayBrowserFragment.this.f4082b.setVisibility(0);
                EasypayBrowserFragment.this.f4083b.setBackgroundColor(Color.parseColor("#F2F1F1"));
                this.a.setListener((Animator.AnimatorListener) null);
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }
        }
    }

    public class d extends C0827co {
        public d(Activity activity) {
            super(activity);
        }

        public final void a() {
            DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.f4083b.setBackgroundColor(Color.parseColor("#FFFFFF"));
            easypayBrowserFragment.f4071a.setVisibility(8);
            ViewPropertyAnimator animate = easypayBrowserFragment.f4073a.animate();
            animate.translationY((float) easypayBrowserFragment.f4073a.getHeight()).setDuration(500).setInterpolator(decelerateInterpolator).setListener(new a(animate)).start();
        }

        public final void b() {
            DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.f4083b.setBackgroundColor(Color.parseColor("#FFFFFF"));
            easypayBrowserFragment.f4071a.setVisibility(8);
            ViewPropertyAnimator animate = easypayBrowserFragment.f4073a.animate();
            animate.translationY((float) easypayBrowserFragment.f4073a.getHeight()).setDuration(500).setInterpolator(decelerateInterpolator).setListener(new b(animate)).start();
        }

        public class a implements Animator.AnimatorListener {
            public final /* synthetic */ ViewPropertyAnimator a;

            public a(ViewPropertyAnimator viewPropertyAnimator) {
                this.a = viewPropertyAnimator;
            }

            public final void onAnimationCancel(Animator animator) {
                this.a.setListener((Animator.AnimatorListener) null);
            }

            public final void onAnimationEnd(Animator animator) {
                d dVar = d.this;
                EasypayBrowserFragment.this.f4073a.setVisibility(8);
                EasypayBrowserFragment.this.f4082b.setVisibility(0);
                EasypayBrowserFragment.this.f4083b.setBackgroundColor(Color.parseColor("#F2F1F1"));
                this.a.setListener((Animator.AnimatorListener) null);
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }
        }

        public class b implements Animator.AnimatorListener {
            public final /* synthetic */ ViewPropertyAnimator a;

            public b(ViewPropertyAnimator viewPropertyAnimator) {
                this.a = viewPropertyAnimator;
            }

            public final void onAnimationCancel(Animator animator) {
                this.a.setListener((Animator.AnimatorListener) null);
            }

            public final void onAnimationEnd(Animator animator) {
                d dVar = d.this;
                EasypayBrowserFragment.this.f4073a.setVisibility(8);
                EasypayBrowserFragment.this.f4082b.setVisibility(0);
                EasypayBrowserFragment.this.f4083b.setBackgroundColor(Color.parseColor("#F2F1F1"));
                this.a.setListener((Animator.AnimatorListener) null);
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }
        }
    }

    public class e implements Animator.AnimatorListener {
        public final /* synthetic */ ViewPropertyAnimator a;

        public e(ViewPropertyAnimator viewPropertyAnimator) {
            this.a = viewPropertyAnimator;
        }

        public final void onAnimationCancel(Animator animator) {
            this.a.setListener((Animator.AnimatorListener) null);
        }

        public final void onAnimationEnd(Animator animator) {
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.f4073a.setVisibility(8);
            easypayBrowserFragment.f4082b.setVisibility(0);
            easypayBrowserFragment.f4083b.setBackgroundColor(Color.parseColor("#F2F1F1"));
            this.a.setListener((Animator.AnimatorListener) null);
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public class f implements Animator.AnimatorListener {
        public final /* synthetic */ ViewPropertyAnimator a;

        public f(ViewPropertyAnimator viewPropertyAnimator) {
            this.a = viewPropertyAnimator;
        }

        public final void onAnimationCancel(Animator animator) {
            this.a.setListener((Animator.AnimatorListener) null);
        }

        public final void onAnimationEnd(Animator animator) {
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.f4071a.setVisibility(0);
            easypayBrowserFragment.f4083b.setBackgroundColor(Color.parseColor("#F2F1F1"));
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public class g implements Animator.AnimatorListener {
        public final /* synthetic */ ViewPropertyAnimator a;

        public g(ViewPropertyAnimator viewPropertyAnimator) {
            this.a = viewPropertyAnimator;
        }

        public final void onAnimationCancel(Animator animator) {
            this.a.setListener((Animator.AnimatorListener) null);
        }

        public final void onAnimationEnd(Animator animator) {
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.f4071a.setVisibility(0);
            easypayBrowserFragment.f4083b.setBackgroundColor(Color.parseColor("#F2F1F1"));
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public class i implements Animator.AnimatorListener {
        public final /* synthetic */ View a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ViewPropertyAnimator f4092a;

        public i(View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = view;
            this.f4092a = viewPropertyAnimator;
        }

        public final void onAnimationCancel(Animator animator) {
            this.f4092a.setListener((Animator.AnimatorListener) null);
        }

        public final void onAnimationEnd(Animator animator) {
            this.a.setVisibility(8);
            this.f4092a.setListener((Animator.AnimatorListener) null);
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @JavascriptInterface
    public void showLog(String str) {
    }
}
