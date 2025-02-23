package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfbu implements zzful {
    final /* synthetic */ zzfby zza;

    public zzfbu(zzfby zzfby) {
        this.zza = zzfby;
    }

    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzm.zzh("", (zzdyp) obj);
        zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzfby zzfby = this.zza;
        zzfby.zzd = new zzfbx((zzbvb) null, zzfby.zze(), (zzfbw) null);
        return this.zza.zzd;
    }
}
