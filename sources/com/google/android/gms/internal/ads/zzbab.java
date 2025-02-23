package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbab implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbad zza;

    public zzbab(zzbad zzbad) {
        this.zza = zzbad;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zza.zzc) {
            try {
                zzbad zzbad = this.zza;
                if (zzbad.zzd != null) {
                    zzbad.zzf = zzbad.zzd.zzq();
                }
            } catch (DeadObjectException e) {
                zzm.zzh("Unable to obtain a cache service instance.", e);
                zzbad.zzh(this.zza);
            }
            this.zza.zzc.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            this.zza.zzc.notifyAll();
        }
    }
}
