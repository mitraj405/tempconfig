package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdrn implements zzfjm {
    private final Map zza;
    private final zzbav zzb;

    public zzdrn(zzbav zzbav, Map map) {
        this.zza = map;
        this.zzb = zzbav;
    }

    public final void zzd(zzfjf zzfjf, String str) {
        if (this.zza.containsKey(zzfjf)) {
            this.zzb.zzc(((zzdrm) this.zza.get(zzfjf)).zzb);
        }
    }

    public final void zzdD(zzfjf zzfjf, String str, Throwable th) {
        if (this.zza.containsKey(zzfjf)) {
            this.zzb.zzc(((zzdrm) this.zza.get(zzfjf)).zzc);
        }
    }

    public final void zzdE(zzfjf zzfjf, String str) {
        if (this.zza.containsKey(zzfjf)) {
            this.zzb.zzc(((zzdrm) this.zza.get(zzfjf)).zza);
        }
    }

    public final void zzdC(zzfjf zzfjf, String str) {
    }
}
