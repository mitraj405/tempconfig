package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbl extends zzaxm implements zzbn {
    public zzbl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final String zze() throws RemoteException {
        throw null;
    }

    public final String zzf() throws RemoteException {
        throw null;
    }

    public final void zzg(zzl zzl) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzl);
        zzdc(1, zza);
    }

    public final void zzh(zzl zzl, int i) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzl);
        zza.writeInt(i);
        zzdc(5, zza);
    }

    public final boolean zzi() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        boolean zzg = zzaxo.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
