package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzeqh implements Callable {
    public /* synthetic */ zzeqh(zzeqi zzeqi) {
    }

    public final Object call() {
        return new zzeqj(Long.valueOf(zzu.zzB().currentTimeMillis() - zzu.zzo().zzi().zzh().zza()).longValue());
    }
}
