package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzapq;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbi implements zzapl {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbl zzb;

    public zzbi(zzbo zzbo, String str, zzbl zzbl) {
        this.zza = str;
        this.zzb = zzbl;
    }

    public final void zza(zzapq zzapq) {
        String obj = zzapq.toString();
        zzm.zzj("Failed to load URL: " + this.zza + "\n" + obj);
        this.zzb.zza((Object) null);
    }
}
