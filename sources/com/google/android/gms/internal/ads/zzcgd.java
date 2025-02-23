package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcgd {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcgd(int i, int i2, int i3) {
        this.zzc = i;
        this.zzb = i2;
        this.zza = i3;
    }

    public static zzcgd zza() {
        return new zzcgd(0, 0, 0);
    }

    public static zzcgd zzb(int i, int i2) {
        return new zzcgd(1, i, i2);
    }

    public static zzcgd zzc(zzq zzq) {
        if (zzq.zzd) {
            return new zzcgd(3, 0, 0);
        }
        if (zzq.zzi) {
            return new zzcgd(2, 0, 0);
        }
        if (zzq.zzh) {
            return zza();
        }
        return zzb(zzq.zzf, zzq.zzc);
    }

    public static zzcgd zzd() {
        return new zzcgd(5, 0, 0);
    }

    public static zzcgd zze() {
        return new zzcgd(4, 0, 0);
    }

    public final boolean zzf() {
        if (this.zzc == 0) {
            return true;
        }
        return false;
    }

    public final boolean zzg() {
        if (this.zzc == 2) {
            return true;
        }
        return false;
    }

    public final boolean zzh() {
        if (this.zzc == 5) {
            return true;
        }
        return false;
    }

    public final boolean zzi() {
        if (this.zzc == 3) {
            return true;
        }
        return false;
    }

    public final boolean zzj() {
        if (this.zzc == 4) {
            return true;
        }
        return false;
    }
}
