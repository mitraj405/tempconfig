package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzr;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfll {
    private final Context zza;
    private final Executor zzb;
    private final zzr zzc;
    private final zzfki zzd;

    public zzfll(Context context, Executor executor, zzr zzr, zzfki zzfki) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzr;
        this.zzd = zzfki;
    }

    public final /* synthetic */ void zza(String str) {
        this.zzc.zza(str);
    }

    public final /* synthetic */ void zzb(String str, zzfkf zzfkf) {
        zzfju zza2 = zzfjt.zza(this.zza, 14);
        zza2.zzi();
        zza2.zzg(this.zzc.zza(str));
        if (zzfkf == null) {
            this.zzd.zzb(zza2.zzm());
            return;
        }
        zzfkf.zza(zza2);
        zzfkf.zzh();
    }

    public final void zzc(String str, zzfkf zzfkf) {
        if (!zzfki.zza() || !((Boolean) zzbdl.zzd.zze()).booleanValue()) {
            this.zzb.execute(new zzflj(this, str));
        } else {
            this.zzb.execute(new zzflk(this, str, zzfkf));
        }
    }

    public final void zzd(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), (zzfkf) null);
        }
    }
}
