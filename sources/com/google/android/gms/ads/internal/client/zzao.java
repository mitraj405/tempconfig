package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbtq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzao extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbom zzc;
    final /* synthetic */ zzaw zzd;

    public zzao(zzaw zzaw, Context context, String str, zzbom zzbom) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbom;
        this.zzd = zzaw;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "native_ad");
        return new zzeu();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzb(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 242402000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Object zzbo;
        zzbbw.zza(this.zza);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjN)).booleanValue()) {
            try {
                IBinder zze = ((zzbr) zzq.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", new zzan())).zze(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 242402000);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                if (queryLocalInterface instanceof zzbq) {
                    zzbo = (zzbq) queryLocalInterface;
                } else {
                    zzbo = new zzbo(zze);
                }
                return zzbo;
            } catch (RemoteException | zzp | NullPointerException e) {
                this.zzd.zzg = zzbtq.zza(this.zza);
                this.zzd.zzg.zzh(e, "ClientApiBroker.createAdLoaderBuilder");
                return null;
            }
        } else {
            zzaw zzaw = this.zzd;
            return zzaw.zzb.zza(this.zza, this.zzb, this.zzc);
        }
    }
}
