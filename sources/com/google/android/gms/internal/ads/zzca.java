package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzca {
    public Object zza;
    public Object zzb;
    public int zzc;
    public long zzd;
    public long zze;
    public boolean zzf;
    private zzb zzg = zzb.zza;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzca.class.equals(obj.getClass())) {
            zzca zzca = (zzca) obj;
            if (!zzet.zzG(this.zza, zzca.zza) || !zzet.zzG(this.zzb, zzca.zzb) || this.zzc != zzca.zzc || this.zzd != zzca.zzd || this.zzf != zzca.zzf || !zzet.zzG(this.zzg, zzca.zzg)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        Object obj = this.zza;
        int i2 = 0;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        Object obj2 = this.zzb;
        if (obj2 != null) {
            i2 = obj2.hashCode();
        }
        int i3 = ((((i + 217) * 31) + i2) * 31) + this.zzc;
        long j = this.zzd;
        return this.zzg.hashCode() + (((((i3 * 31) + ((int) (j ^ (j >>> 32)))) * 961) + (this.zzf ? 1 : 0)) * 31);
    }

    public final int zza(int i) {
        return this.zzg.zza(i).zzb;
    }

    public final int zzb() {
        int i = this.zzg.zzb;
        return 0;
    }

    public final int zzc(long j) {
        return -1;
    }

    public final int zzd(long j) {
        this.zzg.zzb(-1);
        return -1;
    }

    public final int zze(int i) {
        return this.zzg.zza(i).zza(-1);
    }

    public final int zzf(int i, int i2) {
        return this.zzg.zza(i).zza(i2);
    }

    public final int zzg() {
        int i = this.zzg.zzd;
        return 0;
    }

    public final long zzh(int i, int i2) {
        zza zza2 = this.zzg.zza(i);
        if (zza2.zzb != -1) {
            return zza2.zzf[i2];
        }
        return -9223372036854775807L;
    }

    public final long zzi(int i) {
        long j = this.zzg.zza(i).zza;
        return 0;
    }

    public final long zzj() {
        long j = this.zzg.zzc;
        return 0;
    }

    public final long zzk(int i) {
        long j = this.zzg.zza(i).zzg;
        return 0;
    }

    public final zzca zzl(Object obj, Object obj2, int i, long j, long j2, zzb zzb2, boolean z) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = i;
        this.zzd = j;
        this.zze = 0;
        this.zzg = zzb2;
        this.zzf = z;
        return this;
    }

    public final boolean zzm(int i) {
        zzb();
        if (i != -1) {
            return false;
        }
        this.zzg.zzb(-1);
        return false;
    }

    public final boolean zzn(int i) {
        boolean z = this.zzg.zza(i).zzh;
        return false;
    }
}
