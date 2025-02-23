package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzhe extends zzcc {
    private final int zzb;
    private final zzwa zzc;

    public zzhe(boolean z, zzwa zzwa) {
        this.zzc = zzwa;
        this.zzb = zzwa.zzc();
    }

    private final int zzw(int i, boolean z) {
        if (z) {
            return this.zzc.zzd(i);
        }
        if (i >= this.zzb - 1) {
            return -1;
        }
        return i + 1;
    }

    private final int zzx(int i, boolean z) {
        if (z) {
            return this.zzc.zze(i);
        }
        if (i <= 0) {
            return -1;
        }
        return i - 1;
    }

    public final int zza(Object obj) {
        int zza;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int zzp = zzp(obj2);
            if (!(zzp == -1 || (zza = zzu(zzp).zza(obj3)) == -1)) {
                return zzs(zzp) + zza;
            }
        }
        return -1;
    }

    public final zzca zzd(int i, zzca zzca, boolean z) {
        int zzq = zzq(i);
        int zzt = zzt(zzq);
        zzu(zzq).zzd(i - zzs(zzq), zzca, z);
        zzca.zzc += zzt;
        if (z) {
            Object zzv = zzv(zzq);
            Object obj = zzca.zzb;
            obj.getClass();
            zzca.zzb = Pair.create(zzv, obj);
        }
        return zzca;
    }

    public final zzcb zze(int i, zzcb zzcb, long j) {
        int zzr = zzr(i);
        int zzt = zzt(zzr);
        int zzs = zzs(zzr);
        zzu(zzr).zze(i - zzt, zzcb, j);
        Object zzv = zzv(zzr);
        if (!zzcb.zza.equals(zzcb.zzb)) {
            zzv = Pair.create(zzv, zzcb.zzb);
        }
        zzcb.zzb = zzv;
        zzcb.zzn += zzs;
        zzcb.zzo += zzs;
        return zzcb;
    }

    public final Object zzf(int i) {
        int zzq = zzq(i);
        return Pair.create(zzv(zzq), zzu(zzq).zzf(i - zzs(zzq)));
    }

    public final int zzg(boolean z) {
        int i;
        if (this.zzb != 0) {
            if (z) {
                i = this.zzc.zza();
            } else {
                i = 0;
            }
            while (zzu(i).zzo()) {
                i = zzw(i, z);
                if (i == -1) {
                }
            }
            return zzu(i).zzg(z) + zzt(i);
        }
        return -1;
    }

    public final int zzh(boolean z) {
        int i;
        int i2 = this.zzb;
        if (i2 != 0) {
            if (z) {
                i = this.zzc.zzb();
            } else {
                i = i2 - 1;
            }
            while (zzu(i).zzo()) {
                i = zzx(i, z);
                if (i == -1) {
                }
            }
            return zzu(i).zzh(z) + zzt(i);
        }
        return -1;
    }

    public final int zzj(int i, int i2, boolean z) {
        int i3;
        int zzr = zzr(i);
        int zzt = zzt(zzr);
        zzcc zzu = zzu(zzr);
        int i4 = i - zzt;
        if (i2 == 2) {
            i3 = 0;
        } else {
            i3 = i2;
        }
        int zzj = zzu.zzj(i4, i3, z);
        if (zzj != -1) {
            return zzt + zzj;
        }
        int zzw = zzw(zzr, z);
        while (zzw != -1 && zzu(zzw).zzo()) {
            zzw = zzw(zzw, z);
        }
        if (zzw != -1) {
            return zzu(zzw).zzg(z) + zzt(zzw);
        } else if (i2 == 2) {
            return zzg(z);
        } else {
            return -1;
        }
    }

    public final int zzk(int i, int i2, boolean z) {
        int zzr = zzr(i);
        int zzt = zzt(zzr);
        int zzk = zzu(zzr).zzk(i - zzt, 0, false);
        if (zzk != -1) {
            return zzt + zzk;
        }
        int zzx = zzx(zzr, false);
        while (zzx != -1 && zzu(zzx).zzo()) {
            zzx = zzx(zzx, false);
        }
        if (zzx == -1) {
            return -1;
        }
        return zzu(zzx).zzh(false) + zzt(zzx);
    }

    public final zzca zzn(Object obj, zzca zzca) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int zzp = zzp(obj2);
        int zzt = zzt(zzp);
        zzu(zzp).zzn(obj3, zzca);
        zzca.zzc += zzt;
        zzca.zzb = obj;
        return zzca;
    }

    public abstract int zzp(Object obj);

    public abstract int zzq(int i);

    public abstract int zzr(int i);

    public abstract int zzs(int i);

    public abstract int zzt(int i);

    public abstract zzcc zzu(int i);

    public abstract Object zzv(int i);
}
