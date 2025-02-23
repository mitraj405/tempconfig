package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbtq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzaq extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzaw zzb;

    public zzaq(zzaw zzaw, Context context) {
        this.zza = context;
        this.zzb = zzaw;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "mobile_ads_settings");
        return new zzey();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzg(ObjectWrapper.wrap(this.zza), 242402000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Object zzcm;
        zzbbw.zza(this.zza);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjN)).booleanValue()) {
            try {
                IBinder zze = ((zzcp) zzq.zzb(this.zza, "com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl", new zzap())).zze(ObjectWrapper.wrap(this.zza), 242402000);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                if (queryLocalInterface instanceof zzco) {
                    zzcm = (zzco) queryLocalInterface;
                } else {
                    zzcm = new zzcm(zze);
                }
                return zzcm;
            } catch (RemoteException | zzp | NullPointerException e) {
                this.zzb.zzg = zzbtq.zza(this.zza);
                this.zzb.zzg.zzh(e, "ClientApiBroker.getMobileAdsSettingsManager");
                return null;
            }
        } else {
            zzaw zzaw = this.zzb;
            return zzaw.zzc.zza(this.zza);
        }
    }
}
