package com.google.android.gms.ads.nonagon.signalgeneration;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbe implements Runnable {
    public final /* synthetic */ zzbf zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbe(zzbf zzbf, String str) {
        this.zza = zzbf;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzb.zzb.evaluateJavascript(this.zzb, (ValueCallback) null);
    }
}
