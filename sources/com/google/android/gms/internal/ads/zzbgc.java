package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbgc extends zzaxm implements zzbge {
    public zzbgc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public final void zze(zzbfu zzbfu) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbfu);
        zzdc(1, zza);
    }
}
