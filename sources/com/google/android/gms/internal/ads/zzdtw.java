package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdtw implements zzdtk {
    /* access modifiers changed from: private */
    public final long zza;
    private final zzems zzb;

    public zzdtw(long j, Context context, zzdtp zzdtp, zzcgj zzcgj, String str) {
        this.zza = j;
        zzfcq zzv = zzcgj.zzv();
        zzv.zzc(context);
        zzv.zza(new zzq());
        zzv.zzb(str);
        zzems zza2 = zzv.zzd().zza();
        this.zzb = zza2;
        zza2.zzD(new zzdtv(this, zzdtp));
    }

    public final void zza() {
        this.zzb.zzx();
    }

    public final void zzb(zzl zzl) {
        this.zzb.zzab(zzl);
    }

    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
