package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.paytm.easypay.EasypayBrowserFragment;
import java.util.Map;

/* renamed from: Yo  reason: default package and case insensitive filesystem */
/* compiled from: PasswordHelper */
public final class C0760Yo {
    public final b a;

    /* renamed from: a  reason: collision with other field name */
    public final Activity f3869a;

    /* renamed from: a  reason: collision with other field name */
    public final WebView f3870a;

    /* renamed from: a  reason: collision with other field name */
    public final EditText f3871a;

    /* renamed from: a  reason: collision with other field name */
    public final EasypayBrowserFragment f3872a;

    /* renamed from: a  reason: collision with other field name */
    public Boolean f3873a = Boolean.FALSE;

    /* renamed from: a  reason: collision with other field name */
    public final String f3874a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, String> f3875a;
    public String b = "";
    public String c = "";
    public String d = "";
    public final String e;

    /* renamed from: Yo$b */
    /* compiled from: PasswordHelper */
    public class b extends BroadcastReceiver {
        public b() {
        }

        public final void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("eventName");
            string.getClass();
            char c = 65535;
            switch (string.hashCode()) {
                case -1905225220:
                    if (string.equals("activatePasswordHelper")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1641265649:
                    if (string.equals("togglePassword")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2104149715:
                    if (string.equals("submitPassword")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            C0760Yo yo = C0760Yo.this;
            switch (c) {
                case 0:
                    String string2 = extras.getString("data0");
                    yo.getClass();
                    boolean equals = string2.equals("true");
                    Activity activity = yo.f3869a;
                    if (equals) {
                        activity.runOnUiThread(new C0771Zo(yo));
                    } else {
                        yo.b = "";
                        activity.runOnUiThread(new C0786ap(yo));
                    }
                    yo.f3872a.logEvent("activated", yo.f3875a.get(FacebookMediationAdapter.KEY_ID));
                    return;
                case 1:
                    yo.f3873a = Boolean.valueOf(!yo.f3873a.booleanValue());
                    yo.a();
                    yo.f3872a.logEvent("togglePassword", yo.f3875a.get(FacebookMediationAdapter.KEY_ID));
                    return;
                case 2:
                    yo.f3870a.loadUrl(C0709Uj.i("javascript:", C1058d.z("(function(){l=document.getElementsByName('" + yo.e, "');e=document.createEvent('HTMLEvents');e.initEvent('click',true,true);l[0].dispatchEvent(e);})()")));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: Yo$c */
    /* compiled from: PasswordHelper */
    public class c implements Runnable {
        public c() {
        }

        public final void run() {
            C0760Yo yo = C0760Yo.this;
            yo.f3871a.setTextColor(yo.f3869a.getResources().getColor(C1309or.active_state_submit_button));
            ((TextView) yo.f3869a.findViewById(C0501Er.buttonShowPassword)).setText(yo.d);
            if (yo.f3871a.getText().length() == yo.c.length()) {
                yo.f3871a.setSelection(yo.c.length());
            }
        }
    }

    public C0760Yo(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map, String str) {
        b bVar = new b();
        this.a = bVar;
        this.f3869a = activity;
        this.f3872a = easypayBrowserFragment;
        this.f3875a = map;
        this.f3870a = webView;
        this.e = str;
        activity.registerReceiver(bVar, new IntentFilter("com.paytm.easypay.CUSTOM_EVENT"));
        String str2 = map.get("fields");
        this.f3874a = str2;
        EditText editText = (EditText) activity.findViewById(C0501Er.editTextPassword);
        this.f3871a = editText;
        String z = C1058d.z(str2, "var a=fields; for(var i=0;i<a.length;i++){if(a[i].type=='password'){a[i].blur();a[i].addEventListener('input', function(e){Android.logTempData(this.value)}); a[i].addEventListener('focus', function(){Android.sendEvent('activatePasswordHelper', true, 0);Android.logTempData(this.value);});}}");
        webView.loadUrl("javascript:" + map.get("functionStart") + str2 + z + map.get("functionEnd"));
        editText.addTextChangedListener(new a());
    }

    public final void a() {
        boolean booleanValue = this.f3873a.booleanValue();
        EditText editText = this.f3871a;
        if (booleanValue) {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.c = this.b;
            this.d = "Hide";
        } else {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.d = "Show";
        }
        this.f3869a.runOnUiThread(new c());
    }

    /* renamed from: Yo$a */
    /* compiled from: PasswordHelper */
    public class a implements TextWatcher {
        public a() {
        }

        public final void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            C0760Yo yo = C0760Yo.this;
            TextView textView = (TextView) yo.f3869a.findViewById(C0501Er.buttonShowPassword);
            Button button = (Button) yo.f3869a.findViewById(C0501Er.button_submit_password);
            if (obj == null || obj.length() <= 0) {
                textView.setVisibility(8);
                button.setBackgroundColor(yo.f3869a.getResources().getColor(C1309or.inActive_state_submit_button));
            } else {
                textView.setVisibility(0);
                button.setBackgroundColor(yo.f3869a.getResources().getColor(C1309or.active_state_submit_button));
            }
            yo.b = obj;
            StringBuilder J = xx.J(C1058d.z("javascript:" + yo.f3875a.get("functionStart"), yo.f3874a + "if(fields.length){fields[0].value='" + obj + "';};"));
            J.append(yo.f3875a.get("functionEnd"));
            yo.f3870a.loadUrl(J.toString());
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
