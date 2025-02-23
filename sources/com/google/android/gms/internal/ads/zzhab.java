package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzhab implements Iterator {
    private final ArrayDeque zza;
    private zzgwj zzb;

    public /* synthetic */ zzhab(zzgwm zzgwm, zzhaa zzhaa) {
        if (zzgwm instanceof zzhad) {
            zzhad zzhad = (zzhad) zzgwm;
            ArrayDeque arrayDeque = new ArrayDeque(zzhad.zzf());
            this.zza = arrayDeque;
            arrayDeque.push(zzhad);
            this.zzb = zzb(zzhad.zzd);
            return;
        }
        this.zza = null;
        this.zzb = (zzgwj) zzgwm;
    }

    private final zzgwj zzb(zzgwm zzgwm) {
        while (zzgwm instanceof zzhad) {
            zzhad zzhad = (zzhad) zzgwm;
            this.zza.push(zzhad);
            zzgwm = zzhad.zzd;
        }
        return (zzgwj) zzgwm;
    }

    public final boolean hasNext() {
        if (this.zzb != null) {
            return true;
        }
        return false;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: zza */
    public final zzgwj next() {
        zzgwj zzgwj;
        zzgwj zzgwj2 = this.zzb;
        if (zzgwj2 != null) {
            do {
                ArrayDeque arrayDeque = this.zza;
                zzgwj = null;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    this.zzb = zzgwj;
                } else {
                    zzgwj = zzb(((zzhad) this.zza.pop()).zze);
                }
            } while (zzgwj.zzd() == 0);
            this.zzb = zzgwj;
            return zzgwj2;
        }
        throw new NoSuchElementException();
    }
}
