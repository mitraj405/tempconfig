package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzbuj extends zzaxn implements zzbuk {
    public zzbuj() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbuu zzbuu = null;
        if (i == 1) {
            zzbtz zzbtz = (zzbtz) zzaxo.zza(parcel, zzbtz.CREATOR);
            zzaxo.zzc(parcel);
            parcel2.writeNoException();
            zzaxo.zze(parcel2, (Parcelable) null);
        } else if (i == 2) {
            zzbtz zzbtz2 = (zzbtz) zzaxo.zza(parcel, zzbtz.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                if (queryLocalInterface instanceof zzbul) {
                    zzbul zzbul = (zzbul) queryLocalInterface;
                }
            }
            zzaxo.zzc(parcel);
            parcel2.writeNoException();
        } else if (i == 4) {
            zzbvb zzbvb = (zzbvb) zzaxo.zza(parcel, zzbvb.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface2 instanceof zzbuu) {
                    zzbuu = (zzbuu) queryLocalInterface2;
                } else {
                    zzbuu = new zzbus(readStrongBinder2);
                }
            }
            zzaxo.zzc(parcel);
            zzg(zzbvb, zzbuu);
            parcel2.writeNoException();
        } else if (i == 5) {
            zzbvb zzbvb2 = (zzbvb) zzaxo.zza(parcel, zzbvb.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface3 instanceof zzbuu) {
                    zzbuu = (zzbuu) queryLocalInterface3;
                } else {
                    zzbuu = new zzbus(readStrongBinder3);
                }
            }
            zzaxo.zzc(parcel);
            zzf(zzbvb2, zzbuu);
            parcel2.writeNoException();
        } else if (i == 6) {
            zzbvb zzbvb3 = (zzbvb) zzaxo.zza(parcel, zzbvb.CREATOR);
            IBinder readStrongBinder4 = parcel.readStrongBinder();
            if (readStrongBinder4 != null) {
                IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface4 instanceof zzbuu) {
                    zzbuu = (zzbuu) queryLocalInterface4;
                } else {
                    zzbuu = new zzbus(readStrongBinder4);
                }
            }
            zzaxo.zzc(parcel);
            zze(zzbvb3, zzbuu);
            parcel2.writeNoException();
        } else if (i != 7) {
            return false;
        } else {
            String readString = parcel.readString();
            IBinder readStrongBinder5 = parcel.readStrongBinder();
            if (readStrongBinder5 != null) {
                IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface5 instanceof zzbuu) {
                    zzbuu = (zzbuu) queryLocalInterface5;
                } else {
                    zzbuu = new zzbus(readStrongBinder5);
                }
            }
            zzaxo.zzc(parcel);
            zzh(readString, zzbuu);
            parcel2.writeNoException();
        }
        return true;
    }
}
