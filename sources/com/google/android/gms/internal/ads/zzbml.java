package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbml implements zzbix {
    final /* synthetic */ long zza;
    final /* synthetic */ zzbmz zzb;
    final /* synthetic */ zzblv zzc;
    final /* synthetic */ zzbna zzd;

    public zzbml(zzbna zzbna, long j, zzbmz zzbmz, zzblv zzblv) {
        this.zza = j;
        this.zzb = zzbmz;
        this.zzc = zzblv;
        this.zzd = zzbna;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbnb zzbnb = (zzbnb) obj;
        long currentTimeMillis = zzu.zzB().currentTimeMillis() - this.zza;
        zze.zza("onGmsg /jsLoaded. JsLoaded latency is " + currentTimeMillis + " ms.");
        zze.zza("loadJavascriptEngine > /jsLoaded handler: Trying to acquire lock");
        synchronized (this.zzd.zza) {
            zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock acquired");
            if (this.zzb.zze() != -1) {
                if (this.zzb.zze() != 1) {
                    this.zzd.zzi = 0;
                    zzblv zzblv = this.zzc;
                    zzblv.zzq("/log", zzbiw.zzg);
                    zzblv.zzq("/result", zzbiw.zzo);
                    this.zzb.zzi(this.zzc);
                    this.zzd.zzh = this.zzb;
                    zze.zza("Successfully loaded JS Engine.");
                    zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released");
                    return;
                }
            }
            zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released, the promise is already settled");
        }
    }
}
