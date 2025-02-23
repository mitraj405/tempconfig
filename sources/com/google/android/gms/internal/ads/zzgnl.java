package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgnl implements zzgnq {
    private final String zza;
    private final zzgvr zzb;
    private final zzgwm zzc;
    private final zzgsu zzd;
    private final zzgtz zze;
    private final Integer zzf;

    private zzgnl(String str, zzgvr zzgvr, zzgwm zzgwm, zzgsu zzgsu, zzgtz zzgtz, Integer num) {
        this.zza = str;
        this.zzb = zzgvr;
        this.zzc = zzgwm;
        this.zzd = zzgsu;
        this.zze = zzgtz;
        this.zzf = num;
    }

    public static zzgnl zza(String str, zzgwm zzgwm, zzgsu zzgsu, zzgtz zzgtz, Integer num) throws GeneralSecurityException {
        if (zzgtz == zzgtz.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzgnl(str, zzgoa.zza(str), zzgwm, zzgsu, zzgtz, num);
    }

    public final zzgsu zzb() {
        return this.zzd;
    }

    public final zzgtz zzc() {
        return this.zze;
    }

    public final zzgvr zzd() {
        return this.zzb;
    }

    public final zzgwm zze() {
        return this.zzc;
    }

    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
