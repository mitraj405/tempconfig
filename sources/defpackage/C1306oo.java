package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.paytm.easypay.EasypayBrowserFragment;
import java.util.Map;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: oo  reason: default package and case insensitive filesystem */
/* compiled from: OtpHelper */
public final class C1306oo {
    public final Activity a;

    /* renamed from: a  reason: collision with other field name */
    public final WebView f5639a;

    /* renamed from: a  reason: collision with other field name */
    public final EditText f5640a;

    /* renamed from: a  reason: collision with other field name */
    public final TextView f5641a;

    /* renamed from: a  reason: collision with other field name */
    public final EasypayBrowserFragment f5642a;

    /* renamed from: a  reason: collision with other field name */
    public Boolean f5643a = Boolean.FALSE;

    /* renamed from: a  reason: collision with other field name */
    public final String f5644a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, String> f5645a;

    /* renamed from: a  reason: collision with other field name */
    public Timer f5646a;

    /* renamed from: a  reason: collision with other field name */
    public final c f5647a = new c();

    /* renamed from: a  reason: collision with other field name */
    public final d f5648a;

    /* renamed from: a  reason: collision with other field name */
    public C1371ro f5649a;
    public final EditText b;

    /* renamed from: b  reason: collision with other field name */
    public String f5650b;

    /* renamed from: b  reason: collision with other field name */
    public Timer f5651b;

    /* renamed from: oo$a */
    /* compiled from: OtpHelper */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            C1306oo ooVar = C1306oo.this;
            String str = ooVar.f5645a.get("receivedOtp");
            EditText editText = (EditText) ooVar.a.findViewById(C0501Er.editTextOtp);
            editText.setText(str);
            editText.setSelection(str.length());
            ((Button) ooVar.a.findViewById(C0501Er.buttonApproveOtp)).setEnabled(true);
            editText.setTypeface((Typeface) null, 1);
            ooVar.f5639a.loadUrl(C0709Uj.i("javascript:", lf.j("autoFillOtp('", str, "');")));
            editText.requestFocus();
        }
    }

    /* renamed from: oo$b */
    /* compiled from: OtpHelper */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public final void onFocusChange(View view, boolean z) {
            C1306oo ooVar = C1306oo.this;
            if (z) {
                ooVar.f5640a.setHint("");
            } else {
                ooVar.f5640a.setHint("Enter OTP");
            }
        }
    }

    /* renamed from: oo$c */
    /* compiled from: OtpHelper */
    public class c extends BroadcastReceiver {
        public c() {
        }

        public final void onReceive(Context context, Intent intent) {
            Bundle extras;
            if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED") && (extras = intent.getExtras()) != null) {
                try {
                    Object[] objArr = (Object[]) extras.get("pdus");
                    if (objArr == null) {
                        C1306oo.this.a("One time ptm_password is 501475 valid till 16:39:56, applicable only for a single online transaction on your HDFC Bank Credit Card ending 3606.Do not share this OTP to anyone for security reasons and Bank shall not be responsible for any misuse.");
                        return;
                    }
                    int length = objArr.length;
                    SmsMessage[] smsMessageArr = new SmsMessage[length];
                    for (int i = 0; i < length; i++) {
                        SmsMessage createFromPdu = SmsMessage.createFromPdu((byte[]) objArr[i]);
                        smsMessageArr[i] = createFromPdu;
                        createFromPdu.getOriginatingAddress();
                        C1306oo.this.a(smsMessageArr[i].getMessageBody());
                    }
                } catch (Exception e) {
                    e.getMessage();
                    synchronized (C1354qp.class) {
                    }
                }
            }
        }
    }

    /* renamed from: oo$d */
    /* compiled from: OtpHelper */
    public class d extends BroadcastReceiver {
        public d() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onReceive(android.content.Context r7, android.content.Intent r8) {
            /*
                r6 = this;
                android.os.Bundle r7 = r8.getExtras()
                java.lang.String r8 = "eventName"
                java.lang.String r7 = r7.getString(r8)
                r7.getClass()
                int r8 = r7.hashCode()
                r0 = 3
                r1 = 2
                r2 = 1
                switch(r8) {
                    case -51042937: goto L_0x0039;
                    case 853955742: goto L_0x002e;
                    case 1392020230: goto L_0x0023;
                    case 2018704624: goto L_0x0018;
                    default: goto L_0x0017;
                }
            L_0x0017:
                goto L_0x0044
            L_0x0018:
                java.lang.String r8 = "resendOtp"
                boolean r7 = r7.equals(r8)
                if (r7 != 0) goto L_0x0021
                goto L_0x0044
            L_0x0021:
                r7 = r0
                goto L_0x0045
            L_0x0023:
                java.lang.String r8 = "activateOtpHelper"
                boolean r7 = r7.equals(r8)
                if (r7 != 0) goto L_0x002c
                goto L_0x0044
            L_0x002c:
                r7 = r1
                goto L_0x0045
            L_0x002e:
                java.lang.String r8 = "approveOtp"
                boolean r7 = r7.equals(r8)
                if (r7 != 0) goto L_0x0037
                goto L_0x0044
            L_0x0037:
                r7 = r2
                goto L_0x0045
            L_0x0039:
                java.lang.String r8 = "focusOtpField"
                boolean r7 = r7.equals(r8)
                if (r7 != 0) goto L_0x0042
                goto L_0x0044
            L_0x0042:
                r7 = 0
                goto L_0x0045
            L_0x0044:
                r7 = -1
            L_0x0045:
                oo r8 = defpackage.C1306oo.this
                if (r7 == 0) goto L_0x0158
                java.lang.String r3 = "id"
                if (r7 == r2) goto L_0x00d5
                if (r7 == r1) goto L_0x0070
                if (r7 == r0) goto L_0x0053
                goto L_0x016c
            L_0x0053:
                android.webkit.WebView r7 = r8.f5639a
                java.lang.String r0 = "javascript:Android.showLog('resend otp- '+ typeof(autoResendOtp));autoResendOtp();"
                r7.loadUrl(r0)
                java.lang.Boolean r7 = java.lang.Boolean.TRUE
                r8.b(r7)
                java.util.Map<java.lang.String, java.lang.String> r7 = r8.f5645a
                java.lang.Object r7 = r7.get(r3)
                java.lang.String r7 = (java.lang.String) r7
                java.lang.String r0 = "resendOTP"
                com.paytm.easypay.EasypayBrowserFragment r8 = r8.f5642a
                r8.logEvent(r0, r7)
                goto L_0x016c
            L_0x0070:
                r8.getClass()
                qo r7 = new qo
                r7.<init>(r8)
                android.app.Activity r0 = r8.a
                r0.runOnUiThread(r7)
                ro r7 = new ro
                r7.<init>(r8)
                r8.f5649a = r7
                int r7 = defpackage.C0501Er.editTextOtp
                android.view.View r7 = r0.findViewById(r7)
                android.widget.EditText r7 = (android.widget.EditText) r7
                ro r1 = r8.f5649a
                r7.addTextChangedListener(r1)
                java.util.Timer r1 = new java.util.Timer
                r1.<init>()
                r8.f5651b = r1
                so r2 = new so
                r2.<init>(r8, r7)
                r4 = 10000(0x2710, double:4.9407E-320)
                r1.schedule(r2, r4)
                android.content.IntentFilter r7 = new android.content.IntentFilter
                java.lang.String r1 = "android.provider.Telephony.SMS_RECEIVED"
                r7.<init>(r1)
                oo$c r1 = r8.f5647a
                r0.registerReceiver(r1, r7)
                java.lang.Boolean r7 = java.lang.Boolean.TRUE
                r8.f5643a = r7
                java.util.Timer r7 = new java.util.Timer
                r7.<init>()
                r8.f5646a = r7
                to r0 = new to
                r0.<init>(r8)
                r1 = 60000(0xea60, double:2.9644E-319)
                r7.schedule(r0, r1)
                java.util.Map<java.lang.String, java.lang.String> r7 = r8.f5645a
                java.lang.Object r7 = r7.get(r3)
                java.lang.String r7 = (java.lang.String) r7
                java.lang.String r0 = "activated"
                com.paytm.easypay.EasypayBrowserFragment r8 = r8.f5642a
                r8.logEvent(r0, r7)
                goto L_0x016c
            L_0x00d5:
                java.util.Map<java.lang.String, java.lang.String> r7 = r8.f5645a
                java.lang.String r0 = "isPGSDK"
                java.lang.Object r1 = r7.get(r0)
                android.webkit.WebView r2 = r8.f5639a
                if (r1 == 0) goto L_0x0143
                java.lang.Object r0 = r7.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "true"
                boolean r0 = r0.equalsIgnoreCase(r1)
                if (r0 == 0) goto L_0x0143
                android.app.Activity r0 = r8.a
                int r1 = defpackage.C0501Er.editTextOtp
                android.view.View r0 = r0.findViewById(r1)
                java.lang.String r1 = "receivedOtp"
                java.lang.Object r4 = r7.get(r1)
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 != 0) goto L_0x010c
                java.lang.Object r7 = r7.get(r1)
                java.lang.String r7 = (java.lang.String) r7
                goto L_0x0129
            L_0x010c:
                if (r0 == 0) goto L_0x0127
                android.widget.EditText r0 = (android.widget.EditText) r0
                android.text.Editable r7 = r0.getText()
                java.lang.String r7 = r7.toString()
                boolean r7 = android.text.TextUtils.isEmpty(r7)
                if (r7 != 0) goto L_0x0127
                android.text.Editable r7 = r0.getText()
                java.lang.String r7 = r7.toString()
                goto L_0x0129
            L_0x0127:
                java.lang.String r7 = ""
            L_0x0129:
                java.lang.String r0 = "addOtp('"
                java.lang.String r1 = "');"
                java.lang.String r7 = defpackage.lf.j(r0, r7, r1)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "javascript:"
                r0.<init>(r1)
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                r2.loadUrl(r7)
                goto L_0x0148
            L_0x0143:
                java.lang.String r7 = "javascript:Android.showLog('approve otp- '+ typeof(autoSubmitForm));autoSubmitForm();"
                r2.loadUrl(r7)
            L_0x0148:
                java.util.Map<java.lang.String, java.lang.String> r7 = r8.f5645a
                java.lang.Object r7 = r7.get(r3)
                java.lang.String r7 = (java.lang.String) r7
                java.lang.String r0 = "approvedOTP"
                com.paytm.easypay.EasypayBrowserFragment r8 = r8.f5642a
                r8.logEvent(r0, r7)
                goto L_0x016c
            L_0x0158:
                android.app.Activity r7 = r8.a
                java.lang.String r0 = "input_method"
                java.lang.Object r7 = r7.getSystemService(r0)
                android.view.inputmethod.InputMethodManager r7 = (android.view.inputmethod.InputMethodManager) r7
                android.widget.EditText r0 = r8.f5640a
                r0.requestFocus()
                android.widget.EditText r8 = r8.b
                r7.showSoftInput(r8, r2)
            L_0x016c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C1306oo.d.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* renamed from: oo$e */
    /* compiled from: OtpHelper */
    public class e implements Runnable {
        public e() {
        }

        public final void run() {
            C1306oo ooVar = C1306oo.this;
            String str = ooVar.f5645a.get("receivedOtp");
            EditText editText = (EditText) ooVar.a.findViewById(C0501Er.editTextOtp);
            editText.setTypeface((Typeface) null, 1);
            editText.setText(str);
            editText.setSelection(str.length());
            ((Button) ooVar.a.findViewById(C0501Er.buttonApproveOtp)).setEnabled(true);
            ooVar.f5639a.loadUrl(C0709Uj.i("javascript:", "autoFillOtp('" + str + "');"));
            editText.requestFocus();
        }
    }

    /* renamed from: oo$f */
    /* compiled from: OtpHelper */
    public class f implements Runnable {
        public f() {
        }

        public final void run() {
            C1306oo ooVar = C1306oo.this;
            String str = ooVar.f5645a.get("receivedOtp");
            EditText editText = (EditText) ooVar.a.findViewById(C0501Er.editTextOtp);
            ooVar.f5641a.setText("OTP detected, press submit to continue");
            editText.setText(str);
            editText.setSelection(str.length());
            editText.setTypeface((Typeface) null, 1);
            ((Button) ooVar.a.findViewById(C0501Er.buttonApproveOtp)).setEnabled(true);
            if (ooVar.f5645a.get("isPGSDK") == null || !ooVar.f5645a.get("isPGSDK").equalsIgnoreCase("true")) {
                ooVar.f5639a.loadUrl(C0709Uj.i("javascript:", lf.j("autoFillOtp('", str, "');")));
            } else {
                ooVar.f5639a.loadUrl(C0709Uj.i("javascript:", C0709Uj.j(new StringBuilder("addOtp('"), ooVar.f5645a.get("receivedOtp"), "');")));
            }
            editText.requestFocus();
        }
    }

    public C1306oo(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map) {
        d dVar = new d();
        this.f5648a = dVar;
        this.a = activity;
        this.f5642a = easypayBrowserFragment;
        this.f5645a = map;
        this.f5639a = webView;
        this.b = (EditText) activity.findViewById(C0501Er.autoFillerHelperEditText);
        EditText editText = (EditText) activity.findViewById(C0501Er.editTextOtp);
        this.f5640a = editText;
        this.f5641a = (TextView) activity.findViewById(C0501Er.otp_hint);
        editText.setOnFocusChangeListener(new b());
        activity.registerReceiver(dVar, new IntentFilter("com.paytm.easypay.CUSTOM_EVENT"));
        String str = map.get("fields");
        this.f5644a = str;
        String z = C1058d.z(str, "var a = fields; if(a.length&&!(fields[0].offsetParent == null)){Android.sendEvent('activateOtpHelper', 0, 0); var aa=a; autoFillOtp=function(value){ aa[0].value = value; }; }");
        webView.loadUrl("javascript:" + map.get("functionStart") + z + "if(fields.length){ fields[0].addEventListener('input', function(e){Android.logTempData(this.value)});}" + map.get("functionEnd"));
    }

    public final void a(String str) {
        Pattern compile = Pattern.compile("(|^)\\d{6}");
        Pattern compile2 = Pattern.compile("(|^)\\d{4}");
        Pattern compile3 = Pattern.compile("(|^)\\d{8}");
        Matcher matcher = compile.matcher(str);
        Matcher matcher2 = compile2.matcher(str);
        Matcher matcher3 = compile3.matcher(str);
        boolean find = matcher3.find();
        Activity activity = this.a;
        Map<String, String> map = this.f5645a;
        if (find) {
            Timer timer = this.f5646a;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = this.f5651b;
            if (timer2 != null) {
                timer2.cancel();
            }
            map.put("receivedOtp", matcher3.group(0));
            activity.runOnUiThread(new e());
        } else if (matcher.find()) {
            Timer timer3 = this.f5646a;
            if (timer3 != null) {
                timer3.cancel();
            }
            Timer timer4 = this.f5651b;
            if (timer4 != null) {
                timer4.cancel();
            }
            map.put("receivedOtp", matcher.group(0));
            activity.runOnUiThread(new f());
        } else if (matcher2.find()) {
            Timer timer5 = this.f5646a;
            if (timer5 != null) {
                timer5.cancel();
            }
            Timer timer6 = this.f5651b;
            if (timer6 != null) {
                timer6.cancel();
            }
            map.put("receivedOtp", matcher2.group(0));
            activity.runOnUiThread(new a());
        }
    }

    public final void b(Boolean bool) {
        int i = C0501Er.buttonApproveOtp;
        ((Button) this.a.findViewById(i)).setEnabled(false);
        Map<String, String> map = this.f5645a;
        if (map.get("resendEnabled") != null && !map.get("resendEnabled").equals("false")) {
            int i2 = C0501Er.buttonResendOtp;
            Boolean valueOf = Boolean.valueOf(!bool.booleanValue());
            EasypayBrowserFragment easypayBrowserFragment = this.f5642a;
            easypayBrowserFragment.e(i2, valueOf);
            easypayBrowserFragment.e(i, bool);
        }
    }
}
