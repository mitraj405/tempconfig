package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzdss {
    protected final Map zza = new HashMap();
    protected final Context zzb;
    protected final Executor zzc;
    protected final zzr zzd;
    protected final boolean zze;
    private final CsiUrlBuilder zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final AtomicBoolean zzi = new AtomicBoolean();
    private final AtomicReference zzj = new AtomicReference(new Bundle());

    public zzdss(Executor executor, zzr zzr, CsiUrlBuilder csiUrlBuilder, Context context) {
        String str = (String) zzbdm.zza.zze();
        this.zzc = executor;
        this.zzd = zzr;
        this.zze = ((Boolean) zzba.zzc().zza(zzbbw.zzbN)).booleanValue();
        this.zzf = csiUrlBuilder;
        this.zzg = ((Boolean) zzba.zzc().zza(zzbbw.zzbQ)).booleanValue();
        this.zzh = ((Boolean) zzba.zzc().zza(zzbbw.zzgp)).booleanValue();
        this.zzb = context;
    }

    private final void zza(Map map, boolean z) {
        if (!map.isEmpty()) {
            if (map.isEmpty()) {
                zzm.zze("Empty or null paramMap.");
            } else {
                if (!this.zzi.getAndSet(true)) {
                    String str = (String) zzba.zzc().zza(zzbbw.zzjF);
                    this.zzj.set(zzad.zza(this.zzb, str, new zzdsr(this, str)));
                }
                Bundle bundle = (Bundle) this.zzj.get();
                for (String next : bundle.keySet()) {
                    map.put(next, String.valueOf(bundle.get(next)));
                }
            }
            String generateUrl = this.zzf.generateUrl(map);
            zze.zza(generateUrl);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("scar"));
            if (!this.zze) {
                return;
            }
            if (z && !this.zzg) {
                return;
            }
            if (!parseBoolean || this.zzh) {
                this.zzc.execute(new zzdsq(this, generateUrl));
                return;
            }
            return;
        }
        zzm.zze("Empty paramMap.");
    }

    public final String zzb(Map map) {
        return this.zzf.generateUrl(map);
    }

    public final ConcurrentHashMap zzc() {
        return new ConcurrentHashMap(this.zza);
    }

    public final /* synthetic */ void zzd(String str, SharedPreferences sharedPreferences, String str2) {
        this.zzj.set(zzad.zzb(this.zzb, str));
    }

    public final void zze(Map map) {
        zza(map, true);
    }

    public final void zzf(Map map) {
        zza(map, false);
    }
}
