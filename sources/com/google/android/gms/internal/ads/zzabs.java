package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzabs {
    public static final zzabs zza = new zzabs(-3, -9223372036854775807L, -1);
    /* access modifiers changed from: private */
    public final int zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final long zzd;

    private zzabs(int i, long j, long j2) {
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzabs zzd(long j, long j2) {
        return new zzabs(-1, j, j2);
    }

    public static zzabs zze(long j) {
        return new zzabs(0, -9223372036854775807L, j);
    }

    public static zzabs zzf(long j, long j2) {
        return new zzabs(-2, j, j2);
    }
}
