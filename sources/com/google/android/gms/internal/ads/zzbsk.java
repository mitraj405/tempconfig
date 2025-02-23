package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbsk extends RemoteCreator {
    public zzbsk() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzbsq) {
            return (zzbsq) queryLocalInterface;
        }
        return new zzbso(iBinder);
    }

    public final zzbsn zza(Activity activity) {
        zzbsn zzbsl;
        try {
            IBinder zze = ((zzbsq) getRemoteCreatorInstance(activity)).zze(ObjectWrapper.wrap(activity));
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzbsn) {
                zzbsl = (zzbsn) queryLocalInterface;
            } else {
                zzbsl = new zzbsl(zze);
            }
            return zzbsl;
        } catch (RemoteException e) {
            zzm.zzk("Could not create remote AdOverlay.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e2) {
            zzm.zzk("Could not create remote AdOverlay.", e2);
            return null;
        }
    }
}
