package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzqb {
    /* access modifiers changed from: private */
    public final Context zza;
    /* access modifiers changed from: private */
    public final zzof zzb;
    private boolean zzc;
    private final zzqa zzd;
    /* access modifiers changed from: private */
    public zzqd zze;
    /* access modifiers changed from: private */
    public zzpt zzf;

    @Deprecated
    public zzqb() {
        this.zza = null;
        this.zzb = zzof.zza;
        this.zzd = zzqa.zza;
    }

    public final zzqp zzc() {
        zzdi.zzf(!this.zzc);
        this.zzc = true;
        if (this.zze == null) {
            this.zze = new zzqd(new zzct[0]);
        }
        if (this.zzf == null) {
            this.zzf = new zzpt(this.zza);
        }
        return new zzqp(this, (zzqo) null);
    }

    public zzqb(Context context) {
        this.zza = context;
        this.zzb = zzof.zza;
        this.zzd = zzqa.zza;
    }
}
