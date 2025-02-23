package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdjm {
    public static final zzdjm zza = new zzdjm(new zzdjk());
    private final zzbge zzb;
    private final zzbgb zzc;
    private final zzbgr zzd;
    private final zzbgo zze;
    private final zzblq zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    public final zzbgb zza() {
        return this.zzc;
    }

    public final zzbge zzb() {
        return this.zzb;
    }

    public final zzbgh zzc(String str) {
        return (zzbgh) this.zzh.get(str);
    }

    public final zzbgk zzd(String str) {
        return (zzbgk) this.zzg.get(str);
    }

    public final zzbgo zze() {
        return this.zze;
    }

    public final zzbgr zzf() {
        return this.zzd;
    }

    public final zzblq zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList(this.zzg.size());
        for (int i = 0; i < this.zzg.size(); i++) {
            arrayList.add((String) this.zzg.h(i));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    private zzdjm(zzdjk zzdjk) {
        this.zzb = zzdjk.zza;
        this.zzc = zzdjk.zzb;
        this.zzd = zzdjk.zzc;
        this.zzg = new SimpleArrayMap(zzdjk.zzf);
        this.zzh = new SimpleArrayMap(zzdjk.zzg);
        this.zze = zzdjk.zzd;
        this.zzf = zzdjk.zze;
    }
}
