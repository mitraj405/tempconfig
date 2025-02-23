package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzevu implements zzevo {
    private final Context zza;
    private final zzgcu zzb;

    public zzevu(Context context, zzgcu zzgcu) {
        this.zza = context;
        this.zzb = zzgcu;
    }

    public final int zza() {
        return 59;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzbdk.zzb.zze()).booleanValue()) {
            return this.zzb.zzb(new zzevt(this));
        }
        return zzgcj.zzh((Object) null);
    }

    public final /* synthetic */ zzevv zzc() throws Exception {
        Context context = this.zza;
        return new zzevv(zzbbg.zzb(context), zzbbg.zza(context));
    }
}
