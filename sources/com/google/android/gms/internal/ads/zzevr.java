package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hyper.constants.LogCategory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzevr {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfkf zzd;
    private final zzdsk zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzevr(Context context, Executor executor, Set set, zzfkf zzfkf, zzdsk zzdsk) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfkf;
        this.zze = zzdsk;
    }

    public final ListenableFuture zza(Object obj, Bundle bundle) {
        zzfju zza2 = zzfjt.zza(this.zza, 8);
        zza2.zzi();
        ArrayList arrayList = new ArrayList(this.zzb.size());
        List arrayList2 = new ArrayList();
        zzbbn zzbbn = zzbbw.zzkQ;
        if (!((String) zzba.zzc().zza(zzbbn)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) zzba.zzc().zza(zzbbn)).split(","));
        }
        this.zzf = zzu.zzB().elapsedRealtime();
        Bundle bundle2 = new Bundle();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbS)).booleanValue() && bundle != null) {
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            if (obj instanceof Bundle) {
                bundle.putLong(zzdrt.CLIENT_SIGNALS_START.zza(), currentTimeMillis);
            } else {
                bundle.putLong(zzdrt.GMS_SIGNALS_START.zza(), currentTimeMillis);
            }
        }
        for (zzevo zzevo : this.zzb) {
            if (!arrayList2.contains(String.valueOf(zzevo.zza()))) {
                if (!((Boolean) zzba.zzc().zza(zzbbw.zzfo)).booleanValue() || zzevo.zza() != 44) {
                    long elapsedRealtime = zzu.zzB().elapsedRealtime();
                    ListenableFuture zzb2 = zzevo.zzb();
                    zzb2.addListener(new zzevp(this, elapsedRealtime, zzevo, bundle2), zzbzo.zzf);
                    arrayList.add(zzb2);
                }
            }
        }
        ListenableFuture zza3 = zzgcj.zzb(arrayList).zza(new zzevq(arrayList, obj, bundle, bundle2), this.zzc);
        if (zzfki.zza()) {
            zzfke.zza(zza3, this.zzd, zza2);
        }
        return zza3;
    }

    public final void zzb(long j, zzevo zzevo, Bundle bundle) {
        long elapsedRealtime = zzu.zzB().elapsedRealtime() - j;
        if (((Boolean) zzbdu.zza.zze()).booleanValue()) {
            zze.zza("Signal runtime (ms) : " + zzfvj.zzc(zzevo.getClass().getCanonicalName()) + " = " + elapsedRealtime);
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbS)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzbT)).booleanValue()) {
                synchronized (this) {
                    bundle.putLong("sig" + zzevo.zza(), elapsedRealtime);
                }
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbQ)).booleanValue()) {
            zzdsj zza2 = this.zze.zza();
            zza2.zzb(LogCategory.ACTION, "lat_ms");
            zza2.zzb("lat_grp", "sig_lat_grp");
            zza2.zzb("lat_id", String.valueOf(zzevo.zza()));
            zza2.zzb("clat_ms", String.valueOf(elapsedRealtime));
            if (((Boolean) zzba.zzc().zza(zzbbw.zzbR)).booleanValue()) {
                synchronized (this) {
                    this.zzg++;
                }
                zza2.zzb("seq_num", zzu.zzo().zzh().zzd());
                synchronized (this) {
                    if (this.zzg == this.zzb.size() && this.zzf != 0) {
                        this.zzg = 0;
                        String valueOf = String.valueOf(zzu.zzB().elapsedRealtime() - this.zzf);
                        if (zzevo.zza() <= 39 || zzevo.zza() >= 52) {
                            zza2.zzb("lat_clsg", valueOf);
                        } else {
                            zza2.zzb("lat_gmssg", valueOf);
                        }
                    }
                }
            }
            zza2.zzg();
        }
    }
}
