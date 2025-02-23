package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgnm implements zzgnq {
    private final zzgvr zza;
    private final zzgsz zzb;

    private zzgnm(zzgsz zzgsz, zzgvr zzgvr) {
        this.zzb = zzgsz;
        this.zza = zzgvr;
    }

    public static zzgnm zza(zzgsz zzgsz) throws GeneralSecurityException {
        return new zzgnm(zzgsz, zzgoa.zza(zzgsz.zzi()));
    }

    public static zzgnm zzb(zzgsz zzgsz) {
        return new zzgnm(zzgsz, zzgoa.zzb(zzgsz.zzi()));
    }

    public final zzgsz zzc() {
        return this.zzb;
    }

    public final zzgvr zzd() {
        return this.zza;
    }
}
