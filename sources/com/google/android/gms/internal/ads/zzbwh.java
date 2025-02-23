package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbwh extends zzaxm implements zzbwj {
    public zzbwh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    public final void zze() throws RemoteException {
        zzdc(7, zza());
    }

    public final void zzf() throws RemoteException {
        zzdc(6, zza());
    }

    public final void zzg() throws RemoteException {
        zzdc(2, zza());
    }

    public final void zzh(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdc(4, zza);
    }

    public final void zzi(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zze);
        zzdc(5, zza);
    }

    public final void zzj() throws RemoteException {
        zzdc(1, zza());
    }

    public final void zzk(zzbwd zzbwd) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbwd);
        zzdc(3, zza);
    }
}
