package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcb {
    public static final Object zza = new Object();
    private static final zzbc zzp;
    public Object zzb = zza;
    @Deprecated
    public Object zzc;
    public zzbc zzd = zzp;
    public long zze;
    public long zzf;
    public long zzg;
    public boolean zzh;
    public boolean zzi;
    public zzav zzj;
    public boolean zzk;
    public long zzl;
    public long zzm;
    public int zzn;
    public int zzo;

    static {
        zzam zzam = new zzam();
        zzam.zza("androidx.media3.common.Timeline");
        zzam.zzb(Uri.EMPTY);
        zzp = zzam.zzc();
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcb.class.equals(obj.getClass())) {
            zzcb zzcb = (zzcb) obj;
            if (zzet.zzG(this.zzb, zzcb.zzb) && zzet.zzG(this.zzd, zzcb.zzd) && zzet.zzG((Object) null, (Object) null) && zzet.zzG(this.zzj, zzcb.zzj) && this.zze == zzcb.zze && this.zzf == zzcb.zzf && this.zzg == zzcb.zzg && this.zzh == zzcb.zzh && this.zzi == zzcb.zzi && this.zzk == zzcb.zzk && this.zzm == zzcb.zzm && this.zzn == zzcb.zzn && this.zzo == zzcb.zzo) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = ((this.zzb.hashCode() + 217) * 31) + this.zzd.hashCode();
        zzav zzav = this.zzj;
        if (zzav == null) {
            i = 0;
        } else {
            i = zzav.hashCode();
        }
        long j = this.zze;
        long j2 = this.zzf;
        long j3 = this.zzg;
        int i2 = (((((((((((((hashCode * 961) + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0)) * 31) + (this.zzk ? 1 : 0);
        long j4 = this.zzm;
        return ((((((i2 * 961) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.zzn) * 31) + this.zzo) * 31;
    }

    public final zzcb zza(Object obj, zzbc zzbc, Object obj2, long j, long j2, long j3, boolean z, boolean z2, zzav zzav, long j4, long j5, int i, int i2, long j6) {
        zzbc zzbc2;
        this.zzb = obj;
        if (zzbc == null) {
            zzbc2 = zzp;
        } else {
            zzbc2 = zzbc;
        }
        this.zzd = zzbc2;
        this.zzc = null;
        this.zze = -9223372036854775807L;
        this.zzf = -9223372036854775807L;
        this.zzg = -9223372036854775807L;
        this.zzh = z;
        this.zzi = z2;
        this.zzj = zzav;
        this.zzl = 0;
        this.zzm = j5;
        this.zzn = 0;
        this.zzo = 0;
        this.zzk = false;
        return this;
    }

    public final boolean zzb() {
        if (this.zzj != null) {
            return true;
        }
        return false;
    }
}
