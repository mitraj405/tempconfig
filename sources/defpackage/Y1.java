package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.paytm.easypay.EasypayBrowserFragment;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Map;

/* renamed from: Y1  reason: default package */
/* compiled from: AutoFiller */
public final class Y1 {
    public final a a;

    /* renamed from: a  reason: collision with other field name */
    public final b f3842a;

    /* renamed from: a  reason: collision with other field name */
    public final Activity f3843a;

    /* renamed from: a  reason: collision with other field name */
    public final WebView f3844a;

    /* renamed from: a  reason: collision with other field name */
    public final EditText f3845a;

    /* renamed from: a  reason: collision with other field name */
    public final EasypayBrowserFragment f3846a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3847a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, String> f3848a;
    public final String b;

    /* renamed from: Y1$b */
    /* compiled from: AutoFiller */
    public class b extends BroadcastReceiver {
        public b() {
        }

        public final void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("eventName");
            string.getClass();
            if (string.equals("toggleAutoFiller")) {
                String string2 = extras.getString("data0");
                extras.getString("data1");
                Y1 y1 = Y1.this;
                y1.getClass();
                y1.f3843a.runOnUiThread(new C0763Z1(y1, string2));
            }
        }
    }

    public Y1(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map) {
        b bVar = new b();
        this.f3842a = bVar;
        this.f3843a = activity;
        this.f3846a = easypayBrowserFragment;
        this.f3848a = map;
        this.f3844a = webView;
        EditText editText = (EditText) activity.findViewById(C0501Er.autoFillerHelperEditText);
        this.f3845a = editText;
        activity.registerReceiver(bVar, new IntentFilter("com.paytm.easypay.CUSTOM_EVENT"));
        String str = "autofill-" + map.get(PaymentConstants.BANK) + map.get(FacebookMediationAdapter.KEY_ID);
        this.f3847a = str;
        String str2 = map.get("silent");
        String str3 = map.get("fields");
        this.b = str3;
        String z = C1058d.z(str3, "if(fields.length){fields[0].value=''; fields[0].blur();};");
        String j = lf.j("if(fields.length){fields[0].addEventListener('input', function(e){Android.logData('", str, "', this.value)});};");
        String A = C1058d.A("if(!", str2, "){ fields[0].addEventListener('focus', function(){fields[0].blur();Android.sendEvent('toggleAutoFiller', true, '", str, "');}); }");
        if (map.get("element").equals("select")) {
            z = C1058d.z(str3, "var a = fields[0].options; for(var i=0;i<a.length;i++){ if(a[i].value==''){a[i].selected=true; Android.showLog('selected------'); if(fields[0].onchange){fields[0].onchange(); Android.showLog('onchange------');}  break; } }");
            A = C1058d.A("if(!", str2, "){ fields[0].addEventListener('change', function(){ Android.logData('", str, "', this.value) }); }");
        }
        webView.loadUrl("javascript:" + map.get("functionStart") + z + j + A + map.get("functionEnd"));
        a aVar = new a();
        this.a = aVar;
        editText.addTextChangedListener(aVar);
    }

    /* renamed from: Y1$a */
    /* compiled from: AutoFiller */
    public class a implements TextWatcher {
        public a() {
        }

        public final void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            Y1 y1 = Y1.this;
            TextView textView = (TextView) y1.f3843a.findViewById(C0501Er.autoFillerHelperButton);
            if (obj == null || obj.length() <= 0) {
                textView.setBackgroundColor(y1.f3843a.getResources().getColor(C1309or.inActive_state_submit_button));
            } else {
                textView.setBackgroundColor(y1.f3843a.getResources().getColor(C1309or.active_state_submit_button));
            }
            y1.f3846a.logData(y1.f3847a, obj);
            StringBuilder J = xx.J(C1058d.z("javascript:" + y1.f3848a.get("functionStart"), y1.b + "if(fields.length){fields[0].value='" + obj + "';};"));
            J.append(y1.f3848a.get("functionEnd"));
            y1.f3844a.loadUrl(J.toString());
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
