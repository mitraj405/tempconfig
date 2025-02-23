package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzod {
    public static final zzod zza;
    public final int zzb;
    public final int zzc;
    private final zzfxw zzd;

    static {
        zzod zzod;
        if (zzet.zza >= 33) {
            zzfxv zzfxv = new zzfxv();
            for (int i = 1; i <= 10; i++) {
                zzfxv.zzf(Integer.valueOf(zzet.zzh(i)));
            }
            zzod = new zzod(2, (Set) zzfxv.zzi());
        } else {
            zzod = new zzod(2, 10);
        }
        zza = zzod;
    }

    public zzod(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzod)) {
            return false;
        }
        zzod zzod = (zzod) obj;
        if (this.zzb == zzod.zzb && this.zzc == zzod.zzc && zzet.zzG(this.zzd, zzod.zzd)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        zzfxw zzfxw = this.zzd;
        if (zzfxw == null) {
            i = 0;
        } else {
            i = zzfxw.hashCode();
        }
        return (((this.zzb * 31) + this.zzc) * 31) + i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        return "AudioProfile[format=" + this.zzb + ", maxChannelCount=" + this.zzc + ", channelMasks=" + valueOf + "]";
    }

    public final int zza(int i, zzh zzh) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (zzet.zza >= 29) {
            return zzob.zza(this.zzb, i, zzh);
        }
        Integer num = (Integer) zzof.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
        num.getClass();
        return num.intValue();
    }

    public final boolean zzb(int i) {
        if (this.zzd != null) {
            int zzh = zzet.zzh(i);
            if (zzh == 0) {
                return false;
            }
            return this.zzd.contains(Integer.valueOf(zzh));
        } else if (i <= this.zzc) {
            return true;
        } else {
            return false;
        }
    }

    public zzod(int i, Set set) {
        this.zzb = i;
        zzfxw zzl = zzfxw.zzl(set);
        this.zzd = zzl;
        zzfzx zze = zzl.iterator();
        int i2 = 0;
        while (zze.hasNext()) {
            i2 = Math.max(i2, Integer.bitCount(((Integer) zze.next()).intValue()));
        }
        this.zzc = i2;
    }
}
