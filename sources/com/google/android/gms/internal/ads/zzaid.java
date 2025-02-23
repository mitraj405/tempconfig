package com.google.android.gms.internal.ads;

import com.google.firebase.perf.util.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaid implements zzaia {
    private final zzek zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzaid(zzahw zzahw) {
        zzek zzek = zzahw.zza;
        this.zza = zzek;
        zzek.zzK(12);
        this.zzc = zzek.zzp() & Constants.MAX_HOST_LENGTH;
        this.zzb = zzek.zzp();
    }

    public final int zza() {
        return -1;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i = this.zzc;
        if (i == 8) {
            return this.zza.zzm();
        }
        if (i == 16) {
            return this.zza.zzq();
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zze & 15;
        }
        int zzm = this.zza.zzm();
        this.zze = zzm;
        return (zzm & 240) >> 4;
    }
}
