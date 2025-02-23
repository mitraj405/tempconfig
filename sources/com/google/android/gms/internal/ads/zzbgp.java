package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbgp extends zzaxm implements zzbgr {
    public zzbgp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public final void zze(zzbha zzbha) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbha);
        zzdc(1, zza);
    }
}
