package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzwb extends zzcc {
    private static final Object zzb = new Object();
    private final long zzc;
    private final long zzd;
    private final boolean zze;
    private final zzbc zzf;
    private final zzav zzg;

    static {
        zzam zzam = new zzam();
        zzam.zza("SinglePeriodTimeline");
        zzam.zzb(Uri.EMPTY);
        zzam.zzc();
    }

    public zzwb(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, zzbc zzbc, zzav zzav) {
        this.zzc = j4;
        this.zzd = j5;
        this.zze = z;
        zzbc.getClass();
        this.zzf = zzbc;
        this.zzg = zzav;
    }

    public final int zza(Object obj) {
        if (zzb.equals(obj)) {
            return 0;
        }
        return -1;
    }

    public final int zzb() {
        return 1;
    }

    public final int zzc() {
        return 1;
    }

    public final zzca zzd(int i, zzca zzca, boolean z) {
        Object obj;
        zzdi.zza(i, 0, 1);
        if (z) {
            obj = zzb;
        } else {
            obj = null;
        }
        zzca.zzl((Object) null, obj, 0, this.zzc, 0, zzb.zza, false);
        return zzca;
    }

    public final zzcb zze(int i, zzcb zzcb, long j) {
        zzdi.zza(i, 0, 1);
        zzav zzav = this.zzg;
        zzcb.zza(zzcb.zza, this.zzf, (Object) null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.zze, false, zzav, 0, this.zzd, 0, 0, 0);
        return zzcb;
    }

    public final Object zzf(int i) {
        zzdi.zza(i, 0, 1);
        return zzb;
    }
}
