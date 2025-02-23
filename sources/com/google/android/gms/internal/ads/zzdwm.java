package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdwm implements zzgbq {
    public final /* synthetic */ zzbvb zza;

    public /* synthetic */ zzdwm(zzbvb zzbvb) {
        this.zza = zzbvb;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgcj.zzh(new zzdyq((InputStream) obj, this.zza));
    }
}
