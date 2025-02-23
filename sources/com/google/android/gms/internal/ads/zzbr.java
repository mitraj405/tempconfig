package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbr {
    private final zzz zza = new zzz();

    public final zzbr zza(int i) {
        this.zza.zza(i);
        return this;
    }

    public final zzbr zzb(zzbt zzbt) {
        zzab zza2 = zzbt.zza;
        for (int i = 0; i < zza2.zzb(); i++) {
            this.zza.zza(zza2.zza(i));
        }
        return this;
    }

    public final zzbr zzc(int... iArr) {
        for (int i = 0; i < 20; i++) {
            this.zza.zza(iArr[i]);
        }
        return this;
    }

    public final zzbr zzd(int i, boolean z) {
        if (z) {
            this.zza.zza(i);
        }
        return this;
    }

    public final zzbt zze() {
        return new zzbt(this.zza.zzb(), (zzbs) null);
    }
}
