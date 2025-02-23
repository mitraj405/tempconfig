package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import defpackage.C0362vD;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfma implements C0362vD.a {
    final /* synthetic */ zzfmb zza;

    public zzfma(zzfmb zzfmb) {
        this.zza = zzfmb;
    }

    public final void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
        String str;
        int i = webMessageCompat.a;
        if (i == 0) {
            try {
                JSONObject jSONObject = new JSONObject(webMessageCompat.f2634a);
                String string = jSONObject.getString(FirebaseAnalytics.Param.METHOD);
                String string2 = jSONObject.getJSONObject(Constants.ScionAnalytics.MessageType.DATA_MESSAGE).getString("adSessionId");
                if (string.equals("startSession")) {
                    zzfmb.zzd(this.zza, string2);
                } else if (!string.equals("finishSession")) {
                    zzfln.zza.booleanValue();
                } else {
                    zzfmb.zzb(this.zza, string2);
                }
            } catch (JSONException e) {
                zzfng.zza("Error parsing JS message in JavaScriptSessionService.", e);
            }
        } else {
            StringBuilder sb = new StringBuilder("Wrong data accessor type detected. ");
            if (i == 0) {
                str = "String";
            } else if (i != 1) {
                str = "Unknown";
            } else {
                str = "ArrayBuffer";
            }
            throw new IllegalStateException(C1058d.B(sb, str, " expected, but got ", "String"));
        }
    }
}
