package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbb;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzbuq extends zzaxn implements zzbur {
    public zzbuq() {
        super("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
    }

    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzaxo.zzc(parcel);
            zzf((ParcelFileDescriptor) zzaxo.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zzaxo.zzc(parcel);
            zze((zzbb) zzaxo.zza(parcel, zzbb.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
