package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzag extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbom zzb;

    public zzag(zzaw zzaw, Context context, zzbom zzbom) {
        this.zza = context;
        this.zzb = zzbom;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzl(ObjectWrapper.wrap(this.zza), this.zzb, 242402000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbsj) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", new zzaf())).zze(ObjectWrapper.wrap(this.zza), this.zzb, 242402000);
        } catch (RemoteException | zzp | NullPointerException unused) {
            return null;
        }
    }
}
