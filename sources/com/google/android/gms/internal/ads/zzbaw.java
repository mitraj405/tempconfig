package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final /* synthetic */ class zzbaw implements Runnable {
    public final /* synthetic */ zzbbb zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzbaw(zzbbb zzbbb, Context context) {
        this.zza = zzbbb;
        this.zzb = context;
    }

    public final void run() {
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbbw.zzet)).booleanValue();
        zzbbb zzbbb = this.zza;
        Context context = this.zzb;
        if (booleanValue) {
            try {
                zzbbb.zza = (zzaxr) zzq.zzb(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", new zzbax());
                zzbbb.zza.zze(ObjectWrapper.wrap(context), "GMA_SDK");
                zzbbb.zzb = true;
            } catch (RemoteException | zzp | NullPointerException unused) {
                zzm.zze("Cannot dynamite load clearcut");
            }
        }
    }
}
