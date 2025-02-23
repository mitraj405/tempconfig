package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbb;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzbut extends zzaxn implements zzbuu {
    public zzbut() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzaxo.zzc(parcel);
            zzf((ParcelFileDescriptor) zzaxo.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i == 2) {
            zzaxo.zzc(parcel);
            zze((zzbb) zzaxo.zza(parcel, zzbb.CREATOR));
        } else if (i != 3) {
            return false;
        } else {
            zzaxo.zzc(parcel);
            zzg((ParcelFileDescriptor) zzaxo.zza(parcel, ParcelFileDescriptor.CREATOR), (zzbvb) zzaxo.zza(parcel, zzbvb.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
