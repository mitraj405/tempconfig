package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbyk extends zzaxm implements zzbym {
    public zzbyk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, iObjectWrapper2);
        zza.writeString(str);
        zzaxo.zzf(zza, iObjectWrapper3);
        return C0709Uj.e(zzdb(11, zza));
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzbyq zzbyq, zzbyj zzbyj) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzd(zza, zzbyq);
        zzaxo.zzf(zza, zzbyj);
        zzdc(1, zza);
    }

    public final void zzg(zzbtl zzbtl) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbtl);
        zzdc(7, zza);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtc) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbtc);
        zzdc(10, zza);
    }

    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtc) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbtc);
        zzdc(9, zza);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        zzdc(8, zza);
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, iObjectWrapper);
        zzdc(2, zza);
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtc) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbtc);
        zzdc(6, zza);
    }

    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtc) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzaxo.zzf(zza, iObjectWrapper);
        zzaxo.zzf(zza, zzbtc);
        zzdc(5, zza);
    }
}
