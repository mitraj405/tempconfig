package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbap implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbah zza;
    final /* synthetic */ zzbzt zzb;
    final /* synthetic */ zzbar zzc;

    public zzbap(zzbar zzbar, zzbah zzbah, zzbzt zzbzt) {
        this.zza = zzbah;
        this.zzb = zzbzt;
        this.zzc = zzbar;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc.zzd) {
            zzbar zzbar = this.zzc;
            if (!zzbar.zzb) {
                zzbar.zzb = true;
                zzbag zza2 = this.zzc.zza;
                if (zza2 != null) {
                    ListenableFuture zza3 = zzbzo.zza.zza(new zzbam(this, zza2, this.zza, this.zzb));
                    zzbzt zzbzt = this.zzb;
                    zzbzt.addListener(new zzban(zzbzt, zza3), zzbzo.zzf);
                }
            }
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
