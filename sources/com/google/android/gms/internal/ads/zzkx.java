package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzkx {
    private static final zzui zzt = new zzui(new Object(), -1);
    public final zzcc zza;
    public final zzui zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzhw zzf;
    public final boolean zzg;
    public final zzwi zzh;
    public final zzyc zzi;
    public final List zzj;
    public final zzui zzk;
    public final boolean zzl;
    public final int zzm;
    public final zzbq zzn;
    public final boolean zzo = false;
    public volatile long zzp;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;

    public zzkx(zzcc zzcc, zzui zzui, long j, long j2, int i, zzhw zzhw, boolean z, zzwi zzwi, zzyc zzyc, List list, zzui zzui2, boolean z2, int i2, zzbq zzbq, long j3, long j4, long j5, long j6, boolean z3) {
        this.zza = zzcc;
        this.zzb = zzui;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
        this.zzf = zzhw;
        this.zzg = z;
        this.zzh = zzwi;
        this.zzi = zzyc;
        this.zzj = list;
        this.zzk = zzui2;
        this.zzl = z2;
        this.zzm = i2;
        this.zzn = zzbq;
        this.zzp = j3;
        this.zzq = j4;
        this.zzr = j5;
        this.zzs = j6;
    }

    public static zzkx zzg(zzyc zzyc) {
        zzcc zzcc = zzcc.zza;
        zzui zzui = zzt;
        return new zzkx(zzcc, zzui, -9223372036854775807L, 0, 1, (zzhw) null, false, zzwi.zza, zzyc, zzfxr.zzm(), zzui, false, 0, zzbq.zza, 0, 0, 0, 0, false);
    }

    public static zzui zzh() {
        return zzt;
    }

    public final zzkx zza(zzui zzui) {
        boolean z = this.zzl;
        int i = this.zzm;
        zzbq zzbq = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzkx(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzui, z, i, zzbq, j, j2, j3, j4, false);
    }

    public final zzkx zzb(zzui zzui, long j, long j2, long j3, long j4, zzwi zzwi, zzyc zzyc, List list) {
        long j5 = j2;
        long j6 = j3;
        long j7 = j4;
        zzwi zzwi2 = zzwi;
        zzyc zzyc2 = zzyc;
        List list2 = list;
        zzui zzui2 = this.zzk;
        boolean z = this.zzl;
        int i = this.zzm;
        zzbq zzbq = this.zzn;
        long j8 = this.zzp;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = this.zze;
        zzhw zzhw = this.zzf;
        boolean z2 = this.zzg;
        return new zzkx(this.zza, zzui, j5, j6, i2, zzhw, z2, zzwi2, zzyc2, list2, zzui2, z, i, zzbq, j8, j7, j, elapsedRealtime, false);
    }

    public final zzkx zzc(boolean z, int i) {
        zzbq zzbq = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzkx(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z, i, zzbq, j, j2, j3, j4, false);
    }

    public final zzkx zzd(zzhw zzhw) {
        boolean z = this.zzg;
        zzwi zzwi = this.zzh;
        zzyc zzyc = this.zzi;
        List list = this.zzj;
        zzui zzui = this.zzk;
        boolean z2 = this.zzl;
        int i = this.zzm;
        zzbq zzbq = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzkx(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzhw, z, zzwi, zzyc, list, zzui, z2, i, zzbq, j, j2, j3, j4, false);
    }

    public final zzkx zze(int i) {
        zzhw zzhw = this.zzf;
        boolean z = this.zzg;
        zzwi zzwi = this.zzh;
        zzyc zzyc = this.zzi;
        List list = this.zzj;
        zzui zzui = this.zzk;
        boolean z2 = this.zzl;
        int i2 = this.zzm;
        zzbq zzbq = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzkx(this.zza, this.zzb, this.zzc, this.zzd, i, zzhw, z, zzwi, zzyc, list, zzui, z2, i2, zzbq, j, j2, j3, j4, false);
    }

    public final zzkx zzf(zzcc zzcc) {
        return new zzkx(zzcc, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    public final boolean zzi() {
        if (this.zze == 3 && this.zzl && this.zzm == 0) {
            return true;
        }
        return false;
    }
}
