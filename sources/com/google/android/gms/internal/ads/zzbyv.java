package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbyv {
    public final ListenableFuture zza(Context context, int i) {
        zzbzt zzbzt = new zzbzt();
        zzay.zzb();
        if (zzf.zzu(context)) {
            zzbzo.zza.execute(new zzbyu(this, context, zzbzt));
        }
        return zzbzt;
    }
}
