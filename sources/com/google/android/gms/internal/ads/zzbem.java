package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbem extends zzaxm {
    public zzbem(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzbtx zzbtx) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbtx);
        zzdc(1, zza);
    }
}
