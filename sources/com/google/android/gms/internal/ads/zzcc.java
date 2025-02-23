package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzcc {
    public static final zzcc zza = new zzbz();

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
    }

    public final boolean equals(Object obj) {
        int zzh;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcc)) {
            return false;
        }
        zzcc zzcc = (zzcc) obj;
        if (zzcc.zzc() == zzc() && zzcc.zzb() == zzb()) {
            zzcb zzcb = new zzcb();
            zzca zzca = new zzca();
            zzcb zzcb2 = new zzcb();
            zzca zzca2 = new zzca();
            for (int i = 0; i < zzc(); i++) {
                if (!zze(i, zzcb, 0).equals(zzcc.zze(i, zzcb2, 0))) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < zzb(); i2++) {
                if (!zzd(i2, zzca, true).equals(zzcc.zzd(i2, zzca2, true))) {
                    return false;
                }
            }
            int zzg = zzg(true);
            if (zzg == zzcc.zzg(true) && (zzh = zzh(true)) == zzcc.zzh(true)) {
                while (zzg != zzh) {
                    int zzj = zzj(zzg, 0, true);
                    if (zzj != zzcc.zzj(zzg, 0, true)) {
                        return false;
                    }
                    zzg = zzj;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        zzcb zzcb = new zzcb();
        zzca zzca = new zzca();
        int zzc = zzc() + 217;
        int i2 = 0;
        while (true) {
            i = zzc * 31;
            if (i2 >= zzc()) {
                break;
            }
            zzc = i + zze(i2, zzcb, 0).hashCode();
            i2++;
        }
        int zzb = zzb() + i;
        for (int i3 = 0; i3 < zzb(); i3++) {
            zzb = (zzb * 31) + zzd(i3, zzca, true).hashCode();
        }
        int zzg = zzg(true);
        while (zzg != -1) {
            zzb = (zzb * 31) + zzg;
            zzg = zzj(zzg, 0, true);
        }
        return zzb;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzca zzd(int i, zzca zzca, boolean z);

    public abstract zzcb zze(int i, zzcb zzcb, long j);

    public abstract Object zzf(int i);

    public int zzg(boolean z) {
        if (zzo()) {
            return -1;
        }
        return 0;
    }

    public int zzh(boolean z) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i, zzca zzca, zzcb zzcb, int i2, boolean z) {
        int i3 = zzd(i, zzca, false).zzc;
        if (zze(i3, zzcb, 0).zzo != i) {
            return i + 1;
        }
        int zzj = zzj(i3, i2, z);
        if (zzj == -1) {
            return -1;
        }
        return zze(zzj, zzcb, 0).zzn;
    }

    public int zzj(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 == 1) {
                return i;
            }
            if (i2 != 2) {
                throw new IllegalStateException();
            } else if (i == zzh(z)) {
                return zzg(z);
            } else {
                return i + 1;
            }
        } else if (i == zzh(z)) {
            return -1;
        } else {
            return i + 1;
        }
    }

    public int zzk(int i, int i2, boolean z) {
        if (i == zzg(false)) {
            return -1;
        }
        return i - 1;
    }

    public final Pair zzl(zzcb zzcb, zzca zzca, int i, long j) {
        Pair zzm = zzm(zzcb, zzca, i, j, 0);
        zzm.getClass();
        return zzm;
    }

    public final Pair zzm(zzcb zzcb, zzca zzca, int i, long j, long j2) {
        zzdi.zza(i, 0, zzc());
        zze(i, zzcb, j2);
        if (j == -9223372036854775807L) {
            long j3 = zzcb.zzl;
            j = 0;
        }
        int i2 = zzcb.zzn;
        zzd(i2, zzca, false);
        while (i2 < zzcb.zzo) {
            long j4 = zzca.zze;
            int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i3 == 0) {
                break;
            }
            int i4 = i2 + 1;
            long j5 = zzd(i4, zzca, false).zze;
            if (i3 < 0) {
                break;
            }
            i2 = i4;
        }
        zzd(i2, zzca, true);
        long j6 = zzca.zze;
        long j7 = zzca.zzd;
        if (j7 != -9223372036854775807L) {
            j = Math.min(j, j7 - 1);
        }
        long max = Math.max(0, j);
        Object obj = zzca.zzb;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(max));
    }

    public zzca zzn(Object obj, zzca zzca) {
        return zzd(zza(obj), zzca, true);
    }

    public final boolean zzo() {
        if (zzc() == 0) {
            return true;
        }
        return false;
    }
}
