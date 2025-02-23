package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbks implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzbku zzb;

    public zzbks(zzbku zzbku, zzbzt zzbzt) {
        this.zza = zzbzt;
        this.zzb = zzbku;
    }

    public final void onConnected(Bundle bundle) {
        try {
            this.zza.zzc(this.zzb.zza.zzp());
        } catch (DeadObjectException e) {
            this.zza.zzd(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        this.zza.zzd(new RuntimeException(lf.h("onConnectionSuspended: ", i)));
    }
}
