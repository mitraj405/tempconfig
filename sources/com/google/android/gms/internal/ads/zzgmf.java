package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgmf {
    private static final zzgmf zza = new zzgmf();
    private static final zzgme zzb = new zzgme((zzgmd) null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzgmf zzb() {
        return zza;
    }

    public final zzglp zza() {
        zzglp zzglp = (zzglp) this.zzc.get();
        if (zzglp == null) {
            return zzb;
        }
        return zzglp;
    }
}
