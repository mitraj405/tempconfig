package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzbkm extends zzaxn implements zzbkn {
    public zzbkm() {
        super("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheCallback");
    }

    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzaxo.zzc(parcel);
        zzb((ParcelFileDescriptor) zzaxo.zza(parcel, ParcelFileDescriptor.CREATOR));
        return true;
    }
}
