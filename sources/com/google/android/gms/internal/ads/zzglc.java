package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzglc {
    private final zzgvr zza;
    private final Class zzb;

    public /* synthetic */ zzglc(zzgvr zzgvr, Class cls, zzglb zzglb) {
        this.zza = zzgvr;
        this.zzb = cls;
    }

    public static zzglc zzb(zzgla zzgla, zzgvr zzgvr, Class cls) {
        return new zzgkz(zzgvr, cls, zzgla);
    }

    public abstract zzgdy zza(zzgnq zzgnq, zzger zzger) throws GeneralSecurityException;

    public final zzgvr zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
