package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbmm implements zzbix {
    final /* synthetic */ zzblv zza;
    final /* synthetic */ zzby zzb;
    final /* synthetic */ zzbna zzc;

    public zzbmm(zzbna zzbna, zzauo zzauo, zzblv zzblv, zzby zzby) {
        this.zza = zzblv;
        this.zzb = zzby;
        this.zzc = zzbna;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzbix, java.lang.Object] */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbnb zzbnb = (zzbnb) obj;
        zze.zza("loadJavascriptEngine > /requestReload handler: Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadJavascriptEngine > /requestReload handler: Lock acquired");
            zzm.zzi("JS Engine is requesting an update");
            if (this.zzc.zzi == 0) {
                zzm.zzi("Starting reload.");
                this.zzc.zzi = 2;
                this.zzc.zzd((zzauo) null);
            }
            this.zza.zzr("/requestReload", this.zzb.zza());
        }
        zze.zza("loadJavascriptEngine > /requestReload handler: Lock released");
    }
}
