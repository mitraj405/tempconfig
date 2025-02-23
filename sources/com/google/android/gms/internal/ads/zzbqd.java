package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbqd extends zzaxm implements zzbqf {
    public zzbqd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString("Adapter returned null.");
        zzdc(2, zza);
    }

    public final void zzf(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, zze);
        zzdc(3, zza);
    }

    public final void zzg(zzbpb zzbpb) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzf(zza, zzbpb);
        zzdc(1, zza);
    }
}
