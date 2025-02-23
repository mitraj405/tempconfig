package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public class zzbdc {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    public zzbdc(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbdc zza(String str, double d) {
        return new zzbdc(str, Double.valueOf(d), 3);
    }

    public static zzbdc zzb(String str, long j) {
        return new zzbdc(str, Long.valueOf(j), 2);
    }

    public static zzbdc zzc(String str, String str2) {
        return new zzbdc(str, str2, 4);
    }

    public static zzbdc zzd(String str, boolean z) {
        return new zzbdc(str, Boolean.valueOf(z), 1);
    }

    public final Object zze() {
        zzbeh zza2 = zzbej.zza();
        if (zza2 == null) {
            if (zzbej.zzb() != null) {
                zzbej.zzb().zza();
            }
            return this.zzb;
        }
        int i = this.zzc - 1;
        if (i == 0) {
            return zza2.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (i == 1) {
            return zza2.zzc(this.zza, ((Long) this.zzb).longValue());
        }
        if (i != 2) {
            return zza2.zzd(this.zza, (String) this.zzb);
        }
        return zza2.zzb(this.zza, ((Double) this.zzb).doubleValue());
    }
}
