package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaec implements zzadx {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaec(int i, int i2, int i3, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzaec zzb(zzek zzek) {
        int zzi = zzek.zzi();
        zzek.zzL(8);
        int zzi2 = zzek.zzi();
        int zzi3 = zzek.zzi();
        zzek.zzL(4);
        int zzi4 = zzek.zzi();
        zzek.zzL(12);
        return new zzaec(zzi, zzi2, zzi3, zzi4);
    }

    public final int zza() {
        return 1751742049;
    }
}
