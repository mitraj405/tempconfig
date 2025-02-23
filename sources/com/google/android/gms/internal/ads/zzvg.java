package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzvg implements zzvx {
    final /* synthetic */ zzvj zza;
    /* access modifiers changed from: private */
    public final int zzb;

    public zzvg(zzvj zzvj, int i) {
        this.zza = zzvj;
        this.zzb = i;
    }

    public final int zza(zzjz zzjz, zzhd zzhd, int i) {
        return this.zza.zzf(this.zzb, zzjz, zzhd, i);
    }

    public final int zzb(long j) {
        return this.zza.zzh(this.zzb, j);
    }

    public final void zzd() throws IOException {
        this.zza.zzI(this.zzb);
    }

    public final boolean zze() {
        return this.zza.zzP(this.zzb);
    }
}
