package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzxd extends zzxp implements Comparable {
    private final int zze;
    private final int zzf = this.zzd.zza();

    public zzxd(int i, zzcd zzcd, int i2, zzxi zzxi, int i3) {
        super(i, zzcd, i2);
        this.zze = zzlf.zza(i3, zzxi.zzN) ? 1 : 0;
    }

    /* renamed from: zza */
    public final int compareTo(zzxd zzxd) {
        return Integer.compare(this.zzf, zzxd.zzf);
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzxp zzxp) {
        zzxd zzxd = (zzxd) zzxp;
        return false;
    }
}
