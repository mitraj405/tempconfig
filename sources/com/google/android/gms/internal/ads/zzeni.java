package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeni implements zzevo {
    private final Context zza;

    public zzeni(Context context) {
        this.zza = context;
    }

    public final int zza() {
        return 2;
    }

    public final ListenableFuture zzb() {
        boolean z;
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzcD)).booleanValue()) {
            return zzgcj.zzh((Object) null);
        }
        if (d7.a(this.zza, "com.google.android.gms.permission.AD_ID") == 0) {
            z = true;
        } else {
            z = false;
        }
        return zzgcj.zzh(new zzenj(z));
    }
}
