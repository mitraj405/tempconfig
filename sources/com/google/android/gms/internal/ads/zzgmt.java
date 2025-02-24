package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzgmt {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzgmt(Class cls, Class cls2, zzgms zzgms) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgmt zzb(zzgmr zzgmr, Class cls, Class cls2) {
        return new zzgmq(cls, cls2, zzgmr);
    }

    public abstract zzgnq zza(zzgen zzgen) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
