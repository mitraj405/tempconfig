package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbws {
    public static final zzbwg zza(Context context, String str, zzbom zzbom) {
        zzbwg zzbwe;
        try {
            IBinder zze = ((zzbwk) zzq.zzb(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", new zzbwr())).zze(ObjectWrapper.wrap(context), str, zzbom, 242402000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzbwg) {
                zzbwe = (zzbwg) queryLocalInterface;
            } else {
                zzbwe = new zzbwe(zze);
            }
            return zzbwe;
        } catch (RemoteException | zzp e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }
}
