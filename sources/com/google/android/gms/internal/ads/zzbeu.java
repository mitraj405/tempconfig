package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbeu extends zzaxm implements zzbew {
    public zzbeu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public final String zzg() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final List zzh() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        ArrayList zzb = zzaxo.zzb(zzdb);
        zzdb.recycle();
        return zzb;
    }
}
