package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzbun extends zzaxn implements zzbuo {
    public zzbun() {
        super("com.google.android.gms.ads.internal.request.IAdsService");
    }

    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbur zzbur = null;
        if (i == 1) {
            zzbuc zzbuc = (zzbuc) zzaxo.zza(parcel, zzbuc.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (queryLocalInterface instanceof zzbur) {
                    zzbur = (zzbur) queryLocalInterface;
                } else {
                    zzbur = new zzbup(readStrongBinder);
                }
            }
            zzaxo.zzc(parcel);
            zzf(zzbuc, zzbur);
        } else if (i == 2) {
            zzbuc zzbuc2 = (zzbuc) zzaxo.zza(parcel, zzbuc.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (queryLocalInterface2 instanceof zzbur) {
                    zzbur zzbur2 = (zzbur) queryLocalInterface2;
                }
            }
            zzaxo.zzc(parcel);
        } else if (i != 3) {
            return false;
        } else {
            zzbug zzbug = (zzbug) zzaxo.zza(parcel, zzbug.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (queryLocalInterface3 instanceof zzbur) {
                    zzbur = (zzbur) queryLocalInterface3;
                } else {
                    zzbur = new zzbup(readStrongBinder3);
                }
            }
            zzaxo.zzc(parcel);
            zze(zzbug, zzbur);
        }
        parcel2.writeNoException();
        return true;
    }
}
