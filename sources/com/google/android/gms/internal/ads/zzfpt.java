package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfpt extends zzaxm {
    public zzfpt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfpr zze(zzfpp zzfpp) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzfpp);
        Parcel zzdb = zzdb(1, zza);
        zzfpr zzfpr = (zzfpr) zzaxo.zza(zzdb, zzfpr.CREATOR);
        zzdb.recycle();
        return zzfpr;
    }

    public final zzfqa zzf(zzfpy zzfpy) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzfpy);
        Parcel zzdb = zzdb(3, zza);
        zzfqa zzfqa = (zzfqa) zzaxo.zza(zzdb, zzfqa.CREATOR);
        zzdb.recycle();
        return zzfqa;
    }

    public final void zzg(zzfpm zzfpm) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzfpm);
        zzdc(2, zza);
    }
}
