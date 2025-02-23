package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfgt {
    private final LinkedList zza = new LinkedList();
    private final int zzb;
    private final int zzc;
    private final zzfhs zzd;

    public zzfgt(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = new zzfhs();
    }

    private final void zzi() {
        while (!this.zza.isEmpty() && zzu.zzB().currentTimeMillis() - ((zzfhd) this.zza.getFirst()).zzd >= ((long) this.zzc)) {
            this.zzd.zzg();
            this.zza.remove();
        }
    }

    public final int zza() {
        return this.zzd.zza();
    }

    public final int zzb() {
        zzi();
        return this.zza.size();
    }

    public final long zzc() {
        return this.zzd.zzb();
    }

    public final long zzd() {
        return this.zzd.zzc();
    }

    public final zzfhd zze() {
        this.zzd.zzf();
        zzi();
        if (this.zza.isEmpty()) {
            return null;
        }
        zzfhd zzfhd = (zzfhd) this.zza.remove();
        if (zzfhd != null) {
            this.zzd.zzh();
        }
        return zzfhd;
    }

    public final zzfhr zzf() {
        return this.zzd.zzd();
    }

    public final String zzg() {
        return this.zzd.zze();
    }

    public final boolean zzh(zzfhd zzfhd) {
        this.zzd.zzf();
        zzi();
        if (this.zza.size() == this.zzb) {
            return false;
        }
        this.zza.add(zzfhd);
        return true;
    }
}
