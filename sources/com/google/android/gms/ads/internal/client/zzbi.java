package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbi extends zzaxm implements zzbk {
    public zzbi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    public final void zzb(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zze);
        zzdc(2, zza);
    }

    public final void zzc() throws RemoteException {
        zzdc(1, zza());
    }
}
