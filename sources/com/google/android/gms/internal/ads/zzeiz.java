package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzeiz implements zzdgx {
    public final /* synthetic */ zzeew zza;

    public /* synthetic */ zzeiz(zzeew zzeew) {
        this.zza = zzeew;
    }

    public final void zza(boolean z, Context context, zzcxd zzcxd) {
        zzeew zzeew = this.zza;
        try {
            ((zzfge) zzeew.zzb).zzv(z);
            ((zzfge) zzeew.zzb).zzz(context);
        } catch (zzffn e) {
            throw new zzdgw(e.getCause());
        }
    }
}
