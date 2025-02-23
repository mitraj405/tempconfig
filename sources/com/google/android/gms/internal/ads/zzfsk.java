package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzfsk extends zzaxn implements zzfsl {
    public zzfsk() {
        super("com.google.android.play.core.lmd.protocol.ILmdOverlayServiceListener");
    }

    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzaxo.zzc(parcel);
        zzb((Bundle) zzaxo.zza(parcel, Bundle.CREATOR));
        return true;
    }
}
