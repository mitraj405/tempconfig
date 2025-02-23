package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgwe extends zzgwf {
    final /* synthetic */ zzgwm zza;
    private int zzb = 0;
    private final int zzc;

    public zzgwe(zzgwm zzgwm) {
        this.zza = zzgwm;
        this.zzc = zzgwm.zzd();
    }

    public final boolean hasNext() {
        if (this.zzb < this.zzc) {
            return true;
        }
        return false;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
