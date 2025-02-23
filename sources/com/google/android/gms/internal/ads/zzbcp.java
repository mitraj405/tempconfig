package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbcp extends zzaxm implements zzbcr {
    public zzbcp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public final void zze(zzbco zzbco) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbco);
        zzdc(1, zza);
    }
}
