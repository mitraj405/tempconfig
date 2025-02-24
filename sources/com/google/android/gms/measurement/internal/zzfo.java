package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzbx;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public abstract class zzfo extends zzbx implements zzfl {
    public zzfo() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzbw.zzb(parcel);
                zza((zzbd) zzbw.zza(parcel, zzbd.CREATOR), (zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zzbw.zzb(parcel);
                zza((zzno) zzbw.zza(parcel, zzno.CREATOR), (zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                zzbw.zzb(parcel);
                zzc((zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                zzbw.zzb(parcel);
                zza((zzbd) zzbw.zza(parcel, zzbd.CREATOR), readString, readString2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbw.zzb(parcel);
                zzg((zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                boolean zzc = zzbw.zzc(parcel);
                zzbw.zzb(parcel);
                List<zzno> zza = zza((zzo) zzbw.zza(parcel, zzo.CREATOR), zzc);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 9:
                String readString3 = parcel.readString();
                zzbw.zzb(parcel);
                byte[] zza2 = zza((zzbd) zzbw.zza(parcel, zzbd.CREATOR), readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                zzbw.zzb(parcel);
                zza(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbw.zzb(parcel);
                String zzb = zzb((zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzb);
                return true;
            case 12:
                zzbw.zzb(parcel);
                zza((zzae) zzbw.zza(parcel, zzae.CREATOR), (zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zzbw.zzb(parcel);
                zza((zzae) zzbw.zza(parcel, zzae.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zzbw.zzb(parcel);
                List<zzno> zza3 = zza(parcel.readString(), parcel.readString(), zzbw.zzc(parcel), (zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza3);
                return true;
            case 15:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                boolean zzc2 = zzbw.zzc(parcel);
                zzbw.zzb(parcel);
                List<zzno> zza4 = zza(readString7, readString8, readString9, zzc2);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza4);
                return true;
            case 16:
                zzbw.zzb(parcel);
                List<zzae> zza5 = zza(parcel.readString(), parcel.readString(), (zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza5);
                return true;
            case 17:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                zzbw.zzb(parcel);
                List<zzae> zza6 = zza(readString10, readString11, readString12);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza6);
                return true;
            case 18:
                zzbw.zzb(parcel);
                zzd((zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 19:
                zzbw.zzb(parcel);
                zza((Bundle) zzbw.zza(parcel, Bundle.CREATOR), (zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 20:
                zzbw.zzb(parcel);
                zze((zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 21:
                zzbw.zzb(parcel);
                zzaj zza7 = zza((zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                zzbw.zzb(parcel2, zza7);
                return true;
            case 24:
                zzbw.zzb(parcel);
                List<zzmu> zza8 = zza((zzo) zzbw.zza(parcel, zzo.CREATOR), (Bundle) zzbw.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza8);
                return true;
            case 25:
                zzbw.zzb(parcel);
                zzh((zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 26:
                zzbw.zzb(parcel);
                zzf((zzo) zzbw.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
