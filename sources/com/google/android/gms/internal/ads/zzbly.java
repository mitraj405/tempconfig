package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbly implements zzcga {
    public final /* synthetic */ zzbmj zza;

    public /* synthetic */ zzbly(zzbmj zzbmj) {
        this.zza = zzbmj;
    }

    public final void zza() {
        long currentTimeMillis = zzu.zzB().currentTimeMillis();
        zzbmj zzbmj = this.zza;
        long j = zzbmj.zzc;
        ArrayList arrayList = zzbmj.zzb;
        arrayList.add(Long.valueOf(currentTimeMillis - j));
        String valueOf = String.valueOf(arrayList.get(0));
        zze.zza("LoadNewJavascriptEngine(onEngLoaded) latency is " + valueOf + " ms.");
        zzt.zza.postDelayed(new zzbmf(zzbmj.zza, zzbmj.zzd, zzbmj.zze, arrayList, j), (long) ((Integer) zzba.zzc().zza(zzbbw.zzb)).intValue());
    }
}
