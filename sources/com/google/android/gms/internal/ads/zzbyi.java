package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class zzbyi extends zzaxn implements zzbyj {
    public zzbyi() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.readString();
            parcel.readString();
            zzaxo.zzc(parcel);
        } else if (i == 2) {
            String readString = parcel.readString();
            zzaxo.zzc(parcel);
            zzb(readString);
        } else if (i != 3) {
            return false;
        } else {
            zzaxo.zzc(parcel);
            zzc(parcel.readString(), parcel.readString(), (Bundle) zzaxo.zza(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
