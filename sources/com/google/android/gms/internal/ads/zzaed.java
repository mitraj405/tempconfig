package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaed implements zzadx {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzaed(int i, int i2, int i3, int i4, int i5, int i6) {
        this.zza = i;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
    }

    public static zzaed zzb(zzek zzek) {
        int zzi = zzek.zzi();
        zzek.zzL(12);
        int zzi2 = zzek.zzi();
        int zzi3 = zzek.zzi();
        int zzi4 = zzek.zzi();
        zzek.zzL(4);
        int zzi5 = zzek.zzi();
        int zzi6 = zzek.zzi();
        zzek.zzL(8);
        return new zzaed(zzi, zzi2, zzi3, zzi4, zzi5, zzi6);
    }

    public final int zza() {
        return 1752331379;
    }
}
