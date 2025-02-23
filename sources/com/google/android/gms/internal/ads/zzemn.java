package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzemn implements zzczb {
    private final AtomicReference zza = new AtomicReference();

    public final void zza(zzdg zzdg) {
        this.zza.set(zzdg);
    }

    public final void zzh(zzs zzs) {
        zzfbq.zza(this.zza, new zzemm(zzs));
    }
}
