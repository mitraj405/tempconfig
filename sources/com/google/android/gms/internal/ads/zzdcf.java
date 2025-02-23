package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdcf implements Runnable {
    public final /* synthetic */ zzdcg zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzdcf(zzdcg zzdcg, Object obj) {
        this.zza = zzdcg;
        this.zzb = obj;
    }

    public final void run() {
        try {
            this.zza.zza(this.zzb);
        } catch (Throwable th) {
            zzu.zzo().zzv(th, "EventEmitter.notify");
            zze.zzb("Event emitter exception.", th);
        }
    }
}
