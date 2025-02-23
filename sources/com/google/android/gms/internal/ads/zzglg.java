package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzglg {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzglg(Class cls, Class cls2, zzglf zzglf) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzglg zzb(zzgle zzgle, Class cls, Class cls2) {
        return new zzgld(cls, cls2, zzgle);
    }

    public abstract zzgnq zza(zzgdy zzgdy, zzger zzger) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
