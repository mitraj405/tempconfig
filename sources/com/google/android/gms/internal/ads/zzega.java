package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzega implements zzcrs {
    public final /* synthetic */ zzeew zza;

    public /* synthetic */ zzega(zzeew zzeew) {
        this.zza = zzeew;
    }

    public final zzdq zza() {
        try {
            return ((zzbql) this.zza.zzb).zze();
        } catch (RemoteException e) {
            throw new zzffn(e);
        }
    }
}
