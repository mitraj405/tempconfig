package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
final class zzau implements Iterator<zzaq> {
    private int zza = 0;
    private final /* synthetic */ zzas zzb;

    public zzau(zzas zzas) {
        this.zzb = zzas;
    }

    public final boolean hasNext() {
        if (this.zza < this.zzb.zza.length()) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        if (this.zza < this.zzb.zza.length()) {
            String zza2 = this.zzb.zza;
            int i = this.zza;
            this.zza = i + 1;
            return new zzas(String.valueOf(zza2.charAt(i)));
        }
        throw new NoSuchElementException();
    }
}
