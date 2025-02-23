package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdyv implements zzgbq {
    public final /* synthetic */ zzbvb zza;

    public /* synthetic */ zzdyv(zzbvb zzbvb) {
        this.zza = zzbvb;
    }

    public final ListenableFuture zza(Object obj) {
        String str = new String(zzgab.zzb((InputStream) obj), zzfuj.zzc);
        zzbvb zzbvb = this.zza;
        zzbvb.zzj = str;
        return zzgcj.zzh(zzbvb);
    }
}
