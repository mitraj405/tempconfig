package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzays implements ValueCallback {
    public final /* synthetic */ zzayt zza;
    public final /* synthetic */ zzayl zzb;
    public final /* synthetic */ WebView zzc;
    public final /* synthetic */ boolean zzd;

    public /* synthetic */ zzays(zzayt zzayt, zzayl zzayl, WebView webView, boolean z) {
        this.zza = zzayt;
        this.zzb = zzayl;
        this.zzc = webView;
        this.zzd = z;
    }

    public final void onReceiveValue(Object obj) {
        this.zza.zze.zzd(this.zzb, this.zzc, (String) obj, this.zzd);
    }
}
