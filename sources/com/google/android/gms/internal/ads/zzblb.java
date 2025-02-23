package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class zzblb extends zzaxn implements zzblc {
    public zzblb() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzblc zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzblc) {
            return (zzblc) queryLocalInterface;
        }
        return new zzbla(iBinder);
    }

    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ArrayList<zzbkv> createTypedArrayList = parcel.createTypedArrayList(zzbkv.CREATOR);
        zzaxo.zzc(parcel);
        zzb(createTypedArrayList);
        parcel2.writeNoException();
        return true;
    }
}
