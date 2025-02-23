package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzezb implements zzhfc {
    public static zzevr zza(Context context, zzbys zzbys, zzbyt zzbyt, Object obj, zzewu zzewu, zzeyh zzeyh, zzhew zzhew, zzhew zzhew2, zzhew zzhew3, zzhew zzhew4, zzhew zzhew5, zzhew zzhew6, zzhew zzhew7, zzhew zzhew8, Executor executor, zzfkf zzfkf, zzdsk zzdsk) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzeya) obj);
        zzewu zzewu2 = zzewu;
        hashSet.add(zzewu);
        zzeyh zzeyh2 = zzeyh;
        hashSet.add(zzeyh);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzff)).booleanValue()) {
            hashSet.add((zzevo) zzhew.zzb());
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfg)).booleanValue()) {
            hashSet.add((zzevo) zzhew2.zzb());
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfh)).booleanValue()) {
            hashSet.add((zzevo) zzhew3.zzb());
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfj)).booleanValue()) {
            hashSet.add((zzevo) zzhew5.zzb());
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfk)).booleanValue()) {
            hashSet.add((zzevo) zzhew6.zzb());
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcC)).booleanValue()) {
            hashSet.add((zzevo) zzhew8.zzb());
        }
        return new zzevr(context, executor, hashSet, zzfkf, zzdsk);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
