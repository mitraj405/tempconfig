package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfxq extends zzfxr {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzfxr zzc;

    public zzfxq(zzfxr zzfxr, int i, int i2) {
        this.zzc = zzfxr;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzfuu.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    public final boolean zzf() {
        return true;
    }

    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    /* renamed from: zzh */
    public final zzfxr subList(int i, int i2) {
        zzfuu.zzi(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
