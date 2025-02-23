package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdjk {
    zzbge zza;
    zzbgb zzb;
    zzbgr zzc;
    zzbgo zzd;
    zzblq zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdjk zza(zzbgb zzbgb) {
        this.zzb = zzbgb;
        return this;
    }

    public final zzdjk zzb(zzbge zzbge) {
        this.zza = zzbge;
        return this;
    }

    public final zzdjk zzc(String str, zzbgk zzbgk, zzbgh zzbgh) {
        this.zzf.put(str, zzbgk);
        if (zzbgh != null) {
            this.zzg.put(str, zzbgh);
        }
        return this;
    }

    public final zzdjk zzd(zzblq zzblq) {
        this.zze = zzblq;
        return this;
    }

    public final zzdjk zze(zzbgo zzbgo) {
        this.zzd = zzbgo;
        return this;
    }

    public final zzdjk zzf(zzbgr zzbgr) {
        this.zzc = zzbgr;
        return this;
    }

    public final zzdjm zzg() {
        return new zzdjm(this);
    }
}
