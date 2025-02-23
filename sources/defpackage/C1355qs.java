package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.webkit.WebView;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.paytm.easypay.EasypayBrowserFragment;
import java.util.Map;

/* renamed from: qs  reason: default package and case insensitive filesystem */
/* compiled from: RadioHelper */
public final class C1355qs {
    public final Activity a;

    /* renamed from: a  reason: collision with other field name */
    public final WebView f6925a;

    /* renamed from: a  reason: collision with other field name */
    public final EasypayBrowserFragment f6926a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, String> f6927a;

    /* renamed from: a  reason: collision with other field name */
    public final a f6928a;

    /* renamed from: qs$a */
    /* compiled from: RadioHelper */
    public class a extends BroadcastReceiver {
        public a() {
        }

        public final void onReceive(Context context, Intent intent) {
            String str;
            Bundle extras = intent.getExtras();
            String string = extras.getString("eventName");
            string.getClass();
            boolean equals = string.equals("selectRadioOption");
            C1355qs qsVar = C1355qs.this;
            if (equals) {
                String string2 = extras.getString("data0");
                qsVar.getClass();
                boolean equals2 = string2.equals(C0515Ga.AVLBLTY_ONLY);
                EasypayBrowserFragment easypayBrowserFragment = qsVar.f6926a;
                Map<String, String> map = qsVar.f6927a;
                if (equals2) {
                    str = map.get("value1");
                    easypayBrowserFragment.logEvent("selectedOption1", map.get(FacebookMediationAdapter.KEY_ID));
                } else {
                    str = map.get("value2");
                    easypayBrowserFragment.logEvent("selectedOption2", map.get(FacebookMediationAdapter.KEY_ID));
                }
                qsVar.f6925a.loadUrl(C0709Uj.i("javascript:", lf.j("if(typeof(autoSelectRadio) != 'undefined'){autoSelectRadio('", str, "');}")));
            } else if (string.equals("activateRadioHelper")) {
                qsVar.getClass();
                qsVar.a.runOnUiThread(new C1373rs(qsVar));
                qsVar.f6926a.logEvent("activated", qsVar.f6927a.get(FacebookMediationAdapter.KEY_ID));
            }
        }
    }

    public C1355qs(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map) {
        a aVar = new a();
        this.f6928a = aVar;
        this.a = activity;
        this.f6926a = easypayBrowserFragment;
        this.f6927a = map;
        this.f6925a = webView;
        activity.registerReceiver(aVar, new IntentFilter("com.paytm.easypay.CUSTOM_EVENT"));
        Integer.parseInt(map.get("length"));
        webView.loadUrl("javascript:" + map.get("functionStart") + map.get("fields") + "var a = fields; if(a.length){Android.sendEvent('activateRadioHelper',0,0);}; var aa=a; autoSelectRadio=function(value){  for(var i=0;i<aa.length;i++){ if(aa[i].value==value){\taa[i].checked=true; try{ customJs(); }catch(e){}  }  }   }" + map.get("functionEnd"));
    }
}
