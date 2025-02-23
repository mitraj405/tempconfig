package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgzx extends zzgwf {
    final zzhab zza;
    zzgwh zzb = zzb();
    final /* synthetic */ zzhad zzc;

    public zzgzx(zzhad zzhad) {
        this.zzc = zzhad;
        this.zza = new zzhab(zzhad, (zzhaa) null);
    }

    private final zzgwh zzb() {
        zzhab zzhab = this.zza;
        if (zzhab.hasNext()) {
            return zzhab.next().iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        if (this.zzb != null) {
            return true;
        }
        return false;
    }

    public final byte zza() {
        zzgwh zzgwh = this.zzb;
        if (zzgwh != null) {
            byte zza2 = zzgwh.zza();
            if (!this.zzb.hasNext()) {
                this.zzb = zzb();
            }
            return zza2;
        }
        throw new NoSuchElementException();
    }
}
