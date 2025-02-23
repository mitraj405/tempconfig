package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.webkit.WebView;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.paytm.easypay.EasypayBrowserFragment;
import java.util.Map;

/* renamed from: sq  reason: default package and case insensitive filesystem */
/* compiled from: ProceedHelper */
public final class C1394sq {
    public final Activity a;

    /* renamed from: a  reason: collision with other field name */
    public final WebView f6959a;

    /* renamed from: a  reason: collision with other field name */
    public final EasypayBrowserFragment f6960a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, String> f6961a;

    /* renamed from: a  reason: collision with other field name */
    public final a f6962a;

    /* renamed from: sq$a */
    /* compiled from: ProceedHelper */
    public class a extends BroadcastReceiver {
        public a() {
        }

        public final void onReceive(Context context, Intent intent) {
            String string = intent.getExtras().getString("eventName");
            string.getClass();
            boolean equals = string.equals("proceedProceedHelper");
            C1394sq sqVar = C1394sq.this;
            if (equals) {
                a aVar = sqVar.f6962a;
                if (aVar != null) {
                    sqVar.a.unregisterReceiver(aVar);
                }
                sqVar.f6959a.loadUrl("javascript:if(typeof(autoSubmitForm) != 'undefined'){Android.showLog('activating proceedhelper0'); autoSubmitForm();}");
                sqVar.f6960a.logEvent("proceeded", sqVar.f6961a.get(FacebookMediationAdapter.KEY_ID));
            } else if (string.equals("activateProceedHelper")) {
                sqVar.getClass();
                sqVar.a.runOnUiThread(new C1412tq(sqVar));
                sqVar.f6960a.logEvent("activated", sqVar.f6961a.get(FacebookMediationAdapter.KEY_ID));
            }
        }
    }

    public C1394sq(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map) {
        String str;
        a aVar = new a();
        this.f6962a = aVar;
        this.a = activity;
        this.f6960a = easypayBrowserFragment;
        this.f6961a = map;
        this.f6959a = webView;
        activity.registerReceiver(aVar, new IntentFilter("com.paytm.easypay.CUSTOM_EVENT"));
        String str2 = map.get("silent");
        String str3 = map.get("autoproceed");
        str2 = str3 != null ? "true" : str2;
        String str4 = map.get("fields");
        if (map.get("element").equals("form")) {
            str = ".submit()";
        } else {
            str = "";
        }
        str = map.get("element").equals("input") ? ".click()" : str;
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append("Android.showLog('inside proceed helper'); var a=fields; if(!");
        sb.append(str2);
        sb.append("){ Android.sendEvent('activateProceedHelper', 0, 0); } if(typeof(autoSubmitForm) == 'undefined'){ autoSubmitForm=function(){Android.showLog('activating proceedhelper1'); a[0]");
        sb.append(str);
        String B = C1058d.B(sb, "}; }  if(", str3, "){ autoSubmitForm();}");
        webView.loadUrl("javascript:" + map.get("functionStart") + B + map.get("functionEnd"));
    }
}
