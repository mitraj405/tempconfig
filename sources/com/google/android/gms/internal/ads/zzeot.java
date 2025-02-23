package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeot implements zzevo {
    private final Context zza;
    private final zzgcu zzb;

    public zzeot(zzgcu zzgcu, Context context) {
        this.zzb = zzgcu;
        this.zza = context;
    }

    private static final zzeou zzc() {
        return new zzeou((String) null, false);
    }

    public final int zza() {
        return 61;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzlT)).booleanValue()) {
            return zzgcj.zzh(zzc());
        }
        ContentResolver contentResolver = this.zza.getContentResolver();
        if (contentResolver == null) {
            return zzgcj.zzh(zzc());
        }
        return this.zzb.zzb(new zzeos(contentResolver));
    }
}
