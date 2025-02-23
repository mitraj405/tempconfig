package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzbsq;
import com.google.android.gms.internal.ads.zzbtq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzaa extends zzax {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzaw zzb;

    public zzaa(zzaw zzaw, Activity activity) {
        this.zza = activity;
        this.zzb = zzaw;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "ad_overlay");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzm(ObjectWrapper.wrap(this.zza));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbbw.zza(this.zza);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjN)).booleanValue()) {
            try {
                return zzbsm.zzI(((zzbsq) zzq.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", new zzz())).zze(ObjectWrapper.wrap(this.zza)));
            } catch (RemoteException | zzp | NullPointerException e) {
                this.zzb.zzg = zzbtq.zza(this.zza.getApplicationContext());
                this.zzb.zzg.zzh(e, "ClientApiBroker.createAdOverlay");
                return null;
            }
        } else {
            zzaw zzaw = this.zzb;
            return zzaw.zze.zza(this.zza);
        }
    }
}
