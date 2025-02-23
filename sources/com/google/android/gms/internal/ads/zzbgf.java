package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbgf extends zzaxm implements zzbgh {
    public zzbgf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void zze(zzbfx zzbfx, String str) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbfx);
        zza.writeString(str);
        zzdc(1, zza);
    }
}
