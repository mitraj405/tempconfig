package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzzg {
    /* access modifiers changed from: private */
    public final Context zza;
    /* access modifiers changed from: private */
    public final zzaah zzb;
    private zzcm zzc;
    /* access modifiers changed from: private */
    public zzbx zzd;
    private boolean zze;

    public zzzg(Context context, zzaah zzaah) {
        this.zza = context.getApplicationContext();
        this.zzb = zzaah;
    }

    public final zzzt zzc() {
        zzdi.zzf(!this.zze);
        if (this.zzd == null) {
            if (this.zzc == null) {
                this.zzc = new zzzm((zzzl) null);
            }
            this.zzd = new zzzn(this.zzc);
        }
        zzzt zzzt = new zzzt(this, (zzzs) null);
        this.zze = true;
        return zzzt;
    }
}
