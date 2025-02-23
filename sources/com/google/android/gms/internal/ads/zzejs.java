package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzejs implements zzdgx {
    public final /* synthetic */ zzeew zza;

    public /* synthetic */ zzejs(zzeew zzeew) {
        this.zza = zzeew;
    }

    public final void zza(boolean z, Context context, zzcxd zzcxd) {
        zzeew zzeew = this.zza;
        try {
            ((zzfge) zzeew.zzb).zzv(z);
            ((zzfge) zzeew.zzb).zzA();
        } catch (zzffn e) {
            zzm.zzk("Cannot show rewarded video.", e);
            throw new zzdgw(e.getCause());
        }
    }
}
