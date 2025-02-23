package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbac implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbad zza;

    public zzbac(zzbad zzbad) {
        this.zza = zzbad;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            zzbad zzbad = this.zza;
            if (zzbad.zzd != null) {
                zzbad.zzd = null;
            }
            this.zza.zzc.notifyAll();
        }
    }
}
