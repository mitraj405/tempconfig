package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaob {
    public final int zza;
    public final long zzb;

    private zzaob(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzaob zza(zzacl zzacl, zzek zzek) throws IOException {
        ((zzaby) zzacl).zzm(zzek.zzM(), 0, 8, false);
        zzek.zzK(0);
        return new zzaob(zzek.zzg(), zzek.zzs());
    }
}
