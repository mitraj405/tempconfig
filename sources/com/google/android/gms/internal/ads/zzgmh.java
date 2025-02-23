package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgmh {
    private static final zzgmh zza = new zzgmh();
    private final AtomicReference zzb = new AtomicReference(new zzgnd(new zzgmz((zzgmy) null), (zzgnc) null));

    public static zzgmh zza() {
        return zza;
    }

    public final Class zzb(Class cls) throws GeneralSecurityException {
        return ((zzgnd) this.zzb.get()).zza(cls);
    }

    public final Object zzc(zzgdy zzgdy, Class cls) throws GeneralSecurityException {
        return ((zzgnd) this.zzb.get()).zzb(zzgdy, cls);
    }

    public final Object zzd(zzgnj zzgnj, Class cls) throws GeneralSecurityException {
        return ((zzgnd) this.zzb.get()).zzc(zzgnj, cls);
    }

    public final synchronized void zze(zzgmx zzgmx) throws GeneralSecurityException {
        zzgmz zzgmz = new zzgmz((zzgnd) this.zzb.get(), (zzgmy) null);
        zzgmz.zza(zzgmx);
        this.zzb.set(new zzgnd(zzgmz, (zzgnc) null));
    }

    public final synchronized void zzf(zzgnk zzgnk) throws GeneralSecurityException {
        zzgmz zzgmz = new zzgmz((zzgnd) this.zzb.get(), (zzgmy) null);
        zzgmz.zzb(zzgnk);
        this.zzb.set(new zzgnd(zzgmz, (zzgnc) null));
    }
}
