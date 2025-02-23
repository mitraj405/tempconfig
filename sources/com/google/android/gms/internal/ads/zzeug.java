package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeug implements zzevo {
    private final String zza;
    private final String zzb;

    public zzeug(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final int zza() {
        return 31;
    }

    public final ListenableFuture zzb() {
        return zzgcj.zzh(new zzeuh(this.zza, this.zzb));
    }
}
