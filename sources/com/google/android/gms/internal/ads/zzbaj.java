package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbaj extends zzaxm {
    public zzbaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzbah zzbah) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbah);
        Parcel zzdb = zzdb(3, zza);
        long readLong = zzdb.readLong();
        zzdb.recycle();
        return readLong;
    }

    public final zzbae zzf(zzbah zzbah) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbah);
        Parcel zzdb = zzdb(1, zza);
        zzbae zzbae = (zzbae) zzaxo.zza(zzdb, zzbae.CREATOR);
        zzdb.recycle();
        return zzbae;
    }

    public final zzbae zzg(zzbah zzbah) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbah);
        Parcel zzdb = zzdb(2, zza);
        zzbae zzbae = (zzbae) zzaxo.zza(zzdb, zzbae.CREATOR);
        zzdb.recycle();
        return zzbae;
    }
}
