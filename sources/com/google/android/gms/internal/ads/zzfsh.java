package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfsh extends zzaxm implements zzfsj {
    public zzfsh(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    public final void zze(Bundle bundle, zzfsl zzfsl) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, bundle);
        zzaxo.zzf(zza, zzfsl);
        zzdd(2, zza);
    }

    public final void zzf(String str, Bundle bundle, zzfsl zzfsl) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzaxo.zzd(zza, bundle);
        zzaxo.zzf(zza, zzfsl);
        zzdd(1, zza);
    }

    public final void zzg(Bundle bundle, zzfsl zzfsl) throws RemoteException {
        Parcel zza = zza();
        zzaxo.zzd(zza, bundle);
        zzaxo.zzf(zza, zzfsl);
        zzdd(3, zza);
    }
}
