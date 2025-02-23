package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzgmp {
    private final zzgvr zza;
    private final Class zzb;

    public /* synthetic */ zzgmp(zzgvr zzgvr, Class cls, zzgmo zzgmo) {
        this.zza = zzgvr;
        this.zzb = cls;
    }

    public static zzgmp zzb(zzgmn zzgmn, zzgvr zzgvr, Class cls) {
        return new zzgmm(zzgvr, cls, zzgmn);
    }

    public abstract zzgen zza(zzgnq zzgnq) throws GeneralSecurityException;

    public final zzgvr zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
