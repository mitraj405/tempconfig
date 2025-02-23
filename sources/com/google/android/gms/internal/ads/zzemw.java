package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzemw implements zzcwt {
    public final /* synthetic */ zzemk zza;
    public final /* synthetic */ zzblq zzb;

    public /* synthetic */ zzemw(zzemk zzemk, zzblq zzblq) {
        this.zza = zzemk;
        this.zzb = zzblq;
    }

    public final void zzdB(zze zze) {
        this.zza.zzdB(zze);
        zzblq zzblq = this.zzb;
        if (zzblq != null) {
            try {
                zzblq.zzf(zze);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        if (zzblq != null) {
            try {
                zzblq.zze(zze.zza);
            } catch (RemoteException e2) {
                zzm.zzl("#007 Could not call remote method.", e2);
            }
        }
    }
}
