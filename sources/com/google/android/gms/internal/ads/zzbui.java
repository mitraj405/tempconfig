package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbui extends zzaxm implements zzbuk {
    public zzbui(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zze(zzbvb zzbvb, zzbuu zzbuu) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbvb);
        zzaxo.zzf(zza, zzbuu);
        zzdc(6, zza);
    }

    public final void zzf(zzbvb zzbvb, zzbuu zzbuu) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbvb);
        zzaxo.zzf(zza, zzbuu);
        zzdc(5, zza);
    }

    public final void zzg(zzbvb zzbvb, zzbuu zzbuu) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbvb);
        zzaxo.zzf(zza, zzbuu);
        zzdc(4, zza);
    }

    public final void zzh(String str, zzbuu zzbuu) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzaxo.zzf(zza, zzbuu);
        zzdc(7, zza);
    }
}
