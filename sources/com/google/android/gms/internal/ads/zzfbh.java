package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzw;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfbh implements zzfhp {
    public final zzfcb zza;
    public final zzfcd zzb;
    public final zzl zzc;
    public final String zzd;
    public final Executor zze;
    public final zzw zzf;
    public final zzfhe zzg;

    public zzfbh(zzfcb zzfcb, zzfcd zzfcd, zzl zzl, String str, Executor executor, zzw zzw, zzfhe zzfhe) {
        this.zza = zzfcb;
        this.zzb = zzfcd;
        this.zzc = zzl;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzw;
        this.zzg = zzfhe;
    }

    public final zzfhe zza() {
        return this.zzg;
    }

    public final Executor zzb() {
        return this.zze;
    }
}
