package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbum extends zzaxm implements zzbuo {
    public zzbum(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdsService");
    }

    public final void zze(zzbug zzbug, zzbur zzbur) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbug);
        zzaxo.zzf(zza, zzbur);
        zzdc(3, zza);
    }

    public final void zzf(zzbuc zzbuc, zzbur zzbur) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbuc);
        zzaxo.zzf(zza, zzbur);
        zzdc(1, zza);
    }
}
