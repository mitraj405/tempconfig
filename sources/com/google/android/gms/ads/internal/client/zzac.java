package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbtq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzac extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbom zzb;

    public zzac(zzaw zzaw, Context context, zzbom zzbom) {
        this.zza = context;
        this.zzb = zzbom;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "out_of_context_tester");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        Context context = this.zza;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        zzbbw.zza(context);
        if (((Boolean) zzba.zzc().zza(zzbbw.zziz)).booleanValue()) {
            return zzce.zzh(wrap, this.zzb, 242402000);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Context context = this.zza;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        zzbbw.zza(context);
        if (!((Boolean) zzba.zzc().zza(zzbbw.zziz)).booleanValue()) {
            return null;
        }
        try {
            return ((zzdk) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl", new zzab())).zze(wrap, this.zzb, 242402000);
        } catch (RemoteException | zzp | NullPointerException e) {
            zzbtq.zza(this.zza).zzh(e, "ClientApiBroker.getOutOfContextTester");
            return null;
        }
    }
}
