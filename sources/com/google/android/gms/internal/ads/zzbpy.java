package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class zzbpy extends zzaxn implements zzbpz {
    public zzbpy() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zzg(asInterface);
        } else if (i == 2) {
            String readString = parcel.readString();
            zzaxo.zzc(parcel);
            zze(readString);
        } else if (i == 3) {
            zzaxo.zzc(parcel);
            zzf((zze) zzaxo.zza(parcel, zze.CREATOR));
        } else if (i != 4) {
            return false;
        } else {
            zzbov zzb = zzbou.zzb(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zzh(zzb);
        }
        parcel2.writeNoException();
        return true;
    }
}
