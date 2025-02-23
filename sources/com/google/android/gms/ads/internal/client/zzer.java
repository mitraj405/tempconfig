package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzer implements Runnable {
    final /* synthetic */ zzet zza;

    public zzer(zzet zzet) {
        this.zza = zzet;
    }

    public final void run() {
        zzeu zzeu = this.zza.zza;
        if (zzeu.zza != null) {
            try {
                zzeu.zza.zze(1);
            } catch (RemoteException e) {
                zzm.zzk("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
