package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzgbq;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzy implements zzgbq {
    public final /* synthetic */ zzak zza;

    public /* synthetic */ zzy(zzak zzak) {
        this.zza = zzak;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgcj.zzm(this.zza.zzS("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzz(this.zza, (Uri) obj), this.zza.zzk);
    }
}
