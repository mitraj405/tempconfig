package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdzx implements zzgbq {
    public final /* synthetic */ zzdzz zza;
    public final /* synthetic */ zzbvb zzb;

    public /* synthetic */ zzdzx(zzdzz zzdzz, zzbvb zzbvb) {
        this.zza = zzdzz;
        this.zzb = zzbvb;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzd(this.zzb, (InputStream) obj);
    }
}
