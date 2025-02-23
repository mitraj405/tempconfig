package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzduh implements Runnable {
    public final /* synthetic */ zzdun zza;
    public final /* synthetic */ zzblc zzb;

    public /* synthetic */ zzduh(zzdun zzdun, zzblc zzblc) {
        this.zza = zzdun;
        this.zzb = zzblc;
    }

    public final void run() {
        zzdun zzdun = this.zza;
        try {
            this.zzb.zzb(zzdun.zzg());
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
