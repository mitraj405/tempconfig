package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzbtf extends zzbtb {
    final /* synthetic */ UpdateImpressionUrlsCallback zza;

    public zzbtf(zzbtk zzbtk, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza = updateImpressionUrlsCallback;
    }

    public final void zze(String str) {
        this.zza.onFailure(str);
    }

    public final void zzf(List list) {
        this.zza.onSuccess(list);
    }
}
