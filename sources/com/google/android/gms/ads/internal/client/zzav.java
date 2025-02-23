package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbws;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzav extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbom zzc;

    public zzav(zzaw zzaw, Context context, String str, zzbom zzbom) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbom;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "rewarded");
        return new zzfc();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzo(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 242402000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return zzbws.zza(this.zza, this.zzb, this.zzc);
    }
}
