package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgnd {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    public /* synthetic */ zzgnd(zzgmz zzgmz, zzgnc zzgnc) {
        this.zza = new HashMap(zzgmz.zza);
        this.zzb = new HashMap(zzgmz.zzb);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzgnk) this.zzb.get(cls)).zza();
        }
        throw new GeneralSecurityException(lf.j("No input primitive class for ", cls.toString(), " available"));
    }

    public final Object zzb(zzgdy zzgdy, Class cls) throws GeneralSecurityException {
        zzgnb zzgnb = new zzgnb(zzgdy.getClass(), cls, (zzgna) null);
        if (this.zza.containsKey(zzgnb)) {
            return ((zzgmx) this.zza.get(zzgnb)).zza(zzgdy);
        }
        throw new GeneralSecurityException(lf.j("No PrimitiveConstructor for ", zzgnb.toString(), " available"));
    }

    public final Object zzc(zzgnj zzgnj, Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            zzgnk zzgnk = (zzgnk) this.zzb.get(cls);
            if (zzgnj.zzd().equals(zzgnk.zza()) && zzgnk.zza().equals(zzgnj.zzd())) {
                return zzgnk.zzc(zzgnj);
            }
            throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
    }
}
