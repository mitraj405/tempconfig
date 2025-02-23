package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcfc implements Runnable {
    public final /* synthetic */ zzcfi zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ ValueCallback zzc;

    public /* synthetic */ zzcfc(zzcfi zzcfi, String str, ValueCallback valueCallback) {
        this.zza = zzcfi;
        this.zzb = str;
        this.zzc = valueCallback;
    }

    public final void run() {
        this.zza.zzaU(this.zzb, this.zzc);
    }
}
