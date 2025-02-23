package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfmr implements Runnable {
    final /* synthetic */ WebView zza;
    final /* synthetic */ String zzb;

    public zzfmr(zzfms zzfms, WebView webView, String str) {
        this.zza = webView;
        this.zzb = str;
    }

    public final void run() {
        zzfms.zzj(this.zza, this.zzb);
    }
}
