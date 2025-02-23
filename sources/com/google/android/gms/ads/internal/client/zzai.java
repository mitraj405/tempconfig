package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbjt;
import com.google.android.gms.internal.ads.zzbkc;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzbom;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzai extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbom zzb;
    final /* synthetic */ OnH5AdsEventListener zzc;

    public zzai(zzaw zzaw, Context context, zzbom zzbom, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzbom;
        this.zzc = onH5AdsEventListener;
    }

    public final /* synthetic */ Object zza() {
        return new zzbkg();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzk(ObjectWrapper.wrap(this.zza), this.zzb, 242402000, new zzbjt(this.zzc));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbkc) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", new zzah())).zze(ObjectWrapper.wrap(this.zza), this.zzb, 242402000, new zzbjt(this.zzc));
        } catch (RemoteException | zzp | NullPointerException unused) {
            return null;
        }
    }
}
