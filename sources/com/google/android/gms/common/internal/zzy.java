package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public final class zzy extends zza implements zzaa {
    public zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final int zzc() throws RemoteException {
        Parcel zzB = zzB(2, zza());
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final IObjectWrapper zzd() throws RemoteException {
        return C0709Uj.e(zzB(1, zza()));
    }
}
