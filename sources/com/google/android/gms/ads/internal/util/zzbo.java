package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzaop;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzapv;
import com.google.android.gms.internal.ads.zzaqo;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.perf.FirebasePerformance;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbo {
    private static zzapk zza;
    private static final Object zzb = new Object();

    public zzbo(Context context) {
        zzapk zzapk;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzb) {
            if (zza == null) {
                zzbbw.zza(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) zzba.zzc().zza(zzbbw.zzdW)).booleanValue()) {
                        zzapk = zzaz.zzb(context);
                        zza = zzapk;
                    }
                }
                zzapk = zzaqo.zza(context, (zzapv) null);
                zza = zzapk;
            }
        }
    }

    public final ListenableFuture zza(String str) {
        zzbzt zzbzt = new zzbzt();
        zza.zza(new zzbn(str, (Map) null, zzbzt));
        return zzbzt;
    }

    public final ListenableFuture zzb(int i, String str, Map map, byte[] bArr) {
        String str2 = str;
        zzbl zzbl = new zzbl((zzbk) null);
        zzbi zzbi = new zzbi(this, str2, zzbl);
        zzl zzl = new zzl((String) null);
        zzbj zzbj = new zzbj(this, i, str, zzbl, zzbi, bArr, map, zzl);
        if (zzl.zzk()) {
            try {
                zzl.zzd(str2, FirebasePerformance.HttpMethod.GET, zzbj.zzl(), zzbj.zzx());
            } catch (zzaop e) {
                zzm.zzj(e.getMessage());
            }
        }
        zza.zza(zzbj);
        return zzbl;
    }
}
