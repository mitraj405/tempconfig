package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
public abstract class zzdk extends zzbx implements zzdh {
    public zzdk() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            long readLong = parcel.readLong();
            zzbw.zzb(parcel);
            zza(parcel.readString(), parcel.readString(), (Bundle) zzbw.zza(parcel, Bundle.CREATOR), readLong);
            parcel2.writeNoException();
        } else if (i != 2) {
            return false;
        } else {
            int zza = zza();
            parcel2.writeNoException();
            parcel2.writeInt(zza);
        }
        return true;
    }
}
