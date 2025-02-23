package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbwn;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final /* synthetic */ class zzfb implements Runnable {
    public final /* synthetic */ zzbwn zza;

    public /* synthetic */ zzfb(zzbwn zzbwn) {
        this.zza = zzbwn;
    }

    public final void run() {
        zzbwn zzbwn = this.zza;
        if (zzbwn != null) {
            try {
                zzbwn.zze(1);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
