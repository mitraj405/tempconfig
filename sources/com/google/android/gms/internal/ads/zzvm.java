package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzvm implements zzuh {
    private final zzfr zza;
    private int zzb = 1048576;
    private final zzvl zzc;
    private final zzyo zzd;

    public zzvm(zzfr zzfr, zzvl zzvl) {
        zzyo zzyo = new zzyo(-1);
        this.zza = zzfr;
        this.zzc = zzvl;
        this.zzd = zzyo;
    }

    public final zzvm zza(int i) {
        this.zzb = i;
        return this;
    }

    public final zzvo zzb(zzbc zzbc) {
        zzbc.zzb.getClass();
        return new zzvo(zzbc, this.zza, this.zzc, zzri.zza, this.zzd, this.zzb, (zzvn) null);
    }
}
