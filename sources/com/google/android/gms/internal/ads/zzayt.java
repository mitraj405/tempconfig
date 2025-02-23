package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzayt implements Runnable {
    final ValueCallback zza;
    final /* synthetic */ zzayl zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzayv zze;

    public zzayt(zzayv zzayv, zzayl zzayl, WebView webView, boolean z) {
        this.zzb = zzayl;
        this.zzc = webView;
        this.zzd = z;
        this.zze = zzayv;
        this.zza = new zzays(this, zzayl, webView, z);
    }

    public final void run() {
        if (this.zzc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
