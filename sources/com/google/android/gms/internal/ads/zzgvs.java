package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgvs {
    private final zzgvr zza;

    private zzgvs(zzgvr zzgvr) {
        this.zza = zzgvr;
    }

    public static zzgvs zzb(byte[] bArr, zzger zzger) {
        return new zzgvs(zzgvr.zzb(bArr));
    }

    public static zzgvs zzc(int i) {
        return new zzgvs(zzgvr.zzb(zzgno.zzb(i)));
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final byte[] zzd(zzger zzger) {
        return this.zza.zzc();
    }
}
