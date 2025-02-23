package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfmt implements zzfmm {
    private static zzfmt zza;
    private float zzb = 0.0f;
    private zzfmh zzc;
    private zzfml zzd;

    public zzfmt(zzfmi zzfmi, zzfmg zzfmg) {
    }

    public static zzfmt zzb() {
        if (zza == null) {
            zza = new zzfmt(new zzfmi(), new zzfmg());
        }
        return zza;
    }

    public final float zza() {
        return this.zzb;
    }

    public final void zzc(boolean z) {
        if (z) {
            zzfnt.zzd().zzi();
        } else {
            zzfnt.zzd().zzh();
        }
    }

    public final void zzd(Context context) {
        this.zzc = new zzfmh(new Handler(), context, new zzfmf(), this);
    }

    public final void zze(float f) {
        this.zzb = f;
        if (this.zzd == null) {
            this.zzd = zzfml.zza();
        }
        for (zzflu zzg : this.zzd.zzb()) {
            zzg.zzg().zzl(f);
        }
    }

    public final void zzf() {
        zzfmk.zza().zze(this);
        zzfmk.zza().zzf();
        zzfnt.zzd().zzi();
        this.zzc.zza();
    }

    public final void zzg() {
        zzfnt.zzd().zzj();
        zzfmk.zza().zzg();
        this.zzc.zzb();
    }
}
