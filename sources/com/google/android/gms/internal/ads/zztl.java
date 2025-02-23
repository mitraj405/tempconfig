package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zztl implements zzvx {
    public final zzvx zza;
    final /* synthetic */ zztm zzb;
    private boolean zzc;

    public zztl(zztm zztm, zzvx zzvx) {
        this.zzb = zztm;
        this.zza = zzvx;
    }

    public final int zza(zzjz zzjz, zzhd zzhd, int i) {
        zztm zztm = this.zzb;
        if (zztm.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzhd.zzc(4);
            return -4;
        }
        long zzb2 = zztm.zzb();
        int zza2 = this.zza.zza(zzjz, zzhd, i);
        if (zza2 == -5) {
            zzaf zzaf = zzjz.zza;
            zzaf.getClass();
            int i2 = zzaf.zzC;
            int i3 = 0;
            if (i2 == 0) {
                if (zzaf.zzD != 0) {
                    i2 = 0;
                }
                return -5;
            }
            if (this.zzb.zzb == Long.MIN_VALUE) {
                i3 = zzaf.zzD;
            }
            zzad zzb3 = zzaf.zzb();
            zzb3.zzF(i2);
            zzb3.zzG(i3);
            zzjz.zza = zzb3.zzad();
            return -5;
        }
        long j = this.zzb.zzb;
        if (j == Long.MIN_VALUE || ((zza2 != -4 || zzhd.zze < j) && (zza2 != -3 || zzb2 != Long.MIN_VALUE || zzhd.zzd))) {
            return zza2;
        }
        zzhd.zzb();
        zzhd.zzc(4);
        this.zzc = true;
        return -4;
    }

    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        if (this.zzb.zzq() || !this.zza.zze()) {
            return false;
        }
        return true;
    }
}
