package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzglh implements zzgdz {
    final String zza;
    final Class zzb;
    final zzgsu zzc;

    public zzglh(String str, Class cls, zzgsu zzgsu, zzgzr zzgzr) {
        this.zza = str;
        this.zzb = cls;
        this.zzc = zzgsu;
    }

    public static zzgdz zzd(String str, Class cls, zzgsu zzgsu, zzgzr zzgzr) {
        return new zzglh(str, cls, zzgsu, zzgzr);
    }

    public final zzgsv zza(zzgwm zzgwm) throws GeneralSecurityException {
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb(this.zza);
        zza2.zzc(zzgwm);
        zza2.zza(zzgtz.RAW);
        zzgnq zzd = zzgmk.zzc().zzd(zzgma.zzb().zza(zzgmk.zzc().zzb(zzgnm.zza((zzgsz) zza2.zzbr())), (Integer) null), zzgnl.class, zzgdx.zza());
        zzgst zza3 = zzgsv.zza();
        zzgnl zzgnl = (zzgnl) zzd;
        zza3.zzb(zzgnl.zzg());
        zza3.zzc(zzgnl.zze());
        zza3.zza(zzgnl.zzb());
        return (zzgsv) zza3.zzbr();
    }

    public final Class zzb() {
        return this.zzb;
    }

    public final Object zzc(zzgwm zzgwm) throws GeneralSecurityException {
        return zzgmh.zza().zzc(zzgmk.zzc().zza(zzgnl.zza(this.zza, zzgwm, this.zzc, zzgtz.RAW, (Integer) null), zzgdx.zza()), this.zzb);
    }
}
