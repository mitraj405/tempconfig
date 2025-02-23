package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbko extends zzaxm {
    public zzbko(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzbki zzbki, zzbkn zzbkn) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zzbki);
        zzaxo.zzf(zza, zzbkn);
        zzdd(2, zza);
    }
}
