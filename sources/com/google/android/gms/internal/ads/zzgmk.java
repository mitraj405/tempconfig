package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgmk {
    private static final zzgmk zza = ((zzgmk) zzgnz.zza(new zzgmi()));
    private final AtomicReference zzb = new AtomicReference(new zzgnx(new zzgnr(), (zzgnw) null));

    public static zzgmk zzc() {
        return zza;
    }

    public final zzgdy zza(zzgnq zzgnq, zzger zzger) throws GeneralSecurityException {
        return ((zzgnx) this.zzb.get()).zza(zzgnq, zzger);
    }

    public final zzgen zzb(zzgnq zzgnq) throws GeneralSecurityException {
        return ((zzgnx) this.zzb.get()).zzb(zzgnq);
    }

    public final zzgnq zzd(zzgdy zzgdy, Class cls, zzger zzger) throws GeneralSecurityException {
        return ((zzgnx) this.zzb.get()).zzc(zzgdy, cls, zzger);
    }

    public final zzgnq zze(zzgen zzgen, Class cls) throws GeneralSecurityException {
        return ((zzgnx) this.zzb.get()).zzd(zzgen, cls);
    }

    public final synchronized void zzf(zzglc zzglc) throws GeneralSecurityException {
        zzgnr zzgnr = new zzgnr((zzgnx) this.zzb.get());
        zzgnr.zza(zzglc);
        this.zzb.set(new zzgnx(zzgnr, (zzgnw) null));
    }

    public final synchronized void zzg(zzglg zzglg) throws GeneralSecurityException {
        zzgnr zzgnr = new zzgnr((zzgnx) this.zzb.get());
        zzgnr.zzb(zzglg);
        this.zzb.set(new zzgnx(zzgnr, (zzgnw) null));
    }

    public final synchronized void zzh(zzgmp zzgmp) throws GeneralSecurityException {
        zzgnr zzgnr = new zzgnr((zzgnx) this.zzb.get());
        zzgnr.zzc(zzgmp);
        this.zzb.set(new zzgnx(zzgnr, (zzgnw) null));
    }

    public final synchronized void zzi(zzgmt zzgmt) throws GeneralSecurityException {
        zzgnr zzgnr = new zzgnr((zzgnx) this.zzb.get());
        zzgnr.zzd(zzgmt);
        this.zzb.set(new zzgnx(zzgnr, (zzgnw) null));
    }

    public final boolean zzj(zzgnq zzgnq) {
        return ((zzgnx) this.zzb.get()).zzi(zzgnq);
    }

    public final boolean zzk(zzgnq zzgnq) {
        return ((zzgnx) this.zzb.get()).zzj(zzgnq);
    }
}
