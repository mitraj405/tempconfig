package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbvo extends zzaxm {
    public zzbvo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbvn zzbvn, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbvn);
        zza.writeString(str);
        zza.writeString(str2);
        zzdc(2, zza);
    }
}
