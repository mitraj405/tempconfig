package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbts;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzk extends RemoteCreator {
    private zzbts zza;

    public zzk() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzbv) {
            return (zzbv) queryLocalInterface;
        }
        return new zzbv(iBinder);
    }

    public final zzbu zza(Context context, zzq zzq, String str, zzbom zzbom, int i) {
        zzbu zzbs;
        zzbu zzbs2;
        zzbbw.zza(context);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjN)).booleanValue()) {
            try {
                IBinder zze = ((zzbv) zzq.zzb(context, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", new zzj())).zze(ObjectWrapper.wrap(context), zzq, str, zzbom, 242402000, i);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface instanceof zzbu) {
                    zzbs2 = (zzbu) queryLocalInterface;
                } else {
                    zzbs2 = new zzbs(zze);
                }
                return zzbs2;
            } catch (RemoteException | zzp | NullPointerException e) {
                zzbts zza2 = zzbtq.zza(context);
                this.zza = zza2;
                zza2.zzh(e, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzm.zzl("#007 Could not call remote method.", e);
                return null;
            }
        } else {
            try {
                IBinder zze2 = ((zzbv) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), zzq, str, zzbom, 242402000, i);
                if (zze2 == null) {
                    return null;
                }
                IInterface queryLocalInterface2 = zze2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface2 instanceof zzbu) {
                    zzbs = (zzbu) queryLocalInterface2;
                } else {
                    zzbs = new zzbs(zze2);
                }
                return zzbs;
            } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
                zzm.zzf("Could not create remote AdManager.", e2);
                return null;
            }
        }
    }
}
