package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzbth extends zzbtb {
    final /* synthetic */ List zza;

    public zzbth(zzbtk zzbtk, List list) {
        this.zza = list;
    }

    public final void zze(String str) {
        zzm.zzg("Error recording impression urls: ".concat(String.valueOf(str)));
    }

    public final void zzf(List list) {
        zzm.zzi("Recorded impression urls: ".concat(this.zza.toString()));
    }
}
