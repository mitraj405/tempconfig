package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbyq;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzaa implements Callable {
    public final /* synthetic */ zzak zza;
    public final /* synthetic */ zzbyq zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzaa(zzak zzak, zzbyq zzbyq, Bundle bundle) {
        this.zza = zzak;
        this.zzb = zzbyq;
        this.zzc = bundle;
    }

    public final Object call() {
        return this.zza.zzq(this.zzb, this.zzc);
    }
}
