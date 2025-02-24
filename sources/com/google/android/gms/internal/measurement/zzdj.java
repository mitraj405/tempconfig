package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
public final class zzdj extends zzbu implements zzdh {
    public zzdj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final int zza() throws RemoteException {
        Parcel zza = zza(2, a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final void zza(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzbw.zza(a_, (Parcelable) bundle);
        a_.writeLong(j);
        zzb(1, a_);
    }
}
