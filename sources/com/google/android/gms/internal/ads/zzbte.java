package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbte {
    private static zzbym zza;
    private final Context zzb;
    private final AdFormat zzc;
    private final zzdx zzd;
    private final String zze;

    public zzbte(Context context, AdFormat adFormat, zzdx zzdx, String str) {
        this.zzb = context;
        this.zzc = adFormat;
        this.zzd = zzdx;
        this.zze = str;
    }

    public static zzbym zza(Context context) {
        zzbym zzbym;
        synchronized (zzbte.class) {
            if (zza == null) {
                zza = zzay.zza().zzr(context, new zzboi());
            }
            zzbym = zza;
        }
        return zzbym;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzl zzl;
        long currentTimeMillis = System.currentTimeMillis();
        zzbym zza2 = zza(this.zzb);
        if (zza2 == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        Context context = this.zzb;
        zzdx zzdx = this.zzd;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        if (zzdx == null) {
            zzm zzm = new zzm();
            zzm.zzg(currentTimeMillis);
            zzl = zzm.zza();
        } else {
            zzdx.zzq(currentTimeMillis);
            zzl = zzp.zza.zza(this.zzb, this.zzd);
        }
        try {
            zza2.zzf(wrap, new zzbyq(this.zze, this.zzc.name(), (zzq) null, zzl), new zzbtd(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
