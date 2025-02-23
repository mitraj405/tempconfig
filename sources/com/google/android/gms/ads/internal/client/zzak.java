package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbom;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzak extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbom zzd;
    final /* synthetic */ zzaw zze;

    public zzak(zzaw zzaw, Context context, zzq zzq, String str, zzbom zzbom) {
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
        this.zzd = zzbom;
        this.zze = zzaw;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, FirebaseAnalytics.Event.APP_OPEN);
        return new zzew();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzc(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, this.zzd, 242402000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return this.zze.zza.zza(this.zza, this.zzb, this.zzc, this.zzd, 4);
    }
}
