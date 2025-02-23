package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzduf implements Callable {
    public final /* synthetic */ zzdun zza;
    public final /* synthetic */ zzfju zzb;

    public /* synthetic */ zzduf(zzdun zzdun, zzfju zzfju) {
        this.zza = zzdun;
        this.zzb = zzfju;
    }

    public final Object call() {
        this.zza.zzf(this.zzb);
        return null;
    }
}
